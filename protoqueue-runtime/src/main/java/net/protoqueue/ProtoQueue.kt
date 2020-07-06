package net.protoqueue

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import net.protoqueue.rpc.ResponseRegister
import net.stripe.lib.ObservableViewModel
import java.io.Closeable
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicBoolean

/**
 * P代表ProtoBuffer类，C代表上下文的类型（例如seqId是Integer类型）
 * Created by zhongyongsheng on 2018/4/20.
 */
abstract class ProtoQueue<P, C> {
    protected var mProtoSender: ProtoSender? = null
    protected var mContextMap: MutableMap<C, ProtoRequest> = ConcurrentHashMap()
    protected var mHandler: Handler = Handler(Looper.getMainLooper())
    protected val mResponseRegister = ResponseRegister<P>()

    fun init(protoSender: ProtoSender) {
        mProtoSender = protoSender
    }

    /**
     * 发送协议，回调接收协议
     * @param proto 发送协议
     * @param receiveUri 接收协议的uri
     * @param receiver 接收协议回调
     * @return
     */
    @Deprecated(message = "use enqueue lambda below", replaceWith = ReplaceWith("enqueue receiver: (P) -> Unit"))
    protected fun enqueue(
        proto: P,
        receiveUri: Int,
        receiver: ProtoReceiver<P>
    ): ProtoDisposable {
        return enqueueInternal(proto, receiveUri, getTopSid(), getSubSid(), { receiver.onProto(it) }, null)
    }

    /**
     * 发送协议，回调接收协议
     * @param proto 发送协议
     * @param receiveUri 接收协议的uri
     * @param receiver 接收协议回调(高阶函数）推荐
     * @return
     */
    protected fun enqueue(
        proto: P,
        receiveUri: Int,
        receiver: (P) -> Unit
    ): ProtoDisposable {
        return enqueueInternal(proto, receiveUri, getTopSid(), getSubSid(), receiver, null)
    }

    /**
     * 发送协议，回调接收协议，自定义topSid, subSid
     * @param proto 发送协议
     * @param receiveUri 接收协议的uri
     * @param topSid 顶级频道号
     * @param subSid 子频道号
     * @param receiver 接收协议回调
     * @return
     */
    internal fun enqueueInternal(
        proto: P,
        receiveUri: Int,
        topSid: Long,
        subSid: Long,
        receiver: (P) -> Unit,
        parameter: QueueParameter<P, C>?
    ): ProtoDisposable {

        var data: ByteArray? = null
        var protoContext: C? = null
        try {
            onProtoPreProcess(proto)
        } catch (t: Throwable) {
            onProtoException(t)
        }

        try {
            data = toByteArray(proto)
        } catch (t: Throwable) {
            onProtoException(t)
        }

        try {
            protoContext = getProtoContext(proto)
        } catch (t: Throwable) {
            onProtoException(t)
        }

        val protoRequest =
            ProtoRequest(data, receiver, getOwnAppId(), protoContext, receiveUri, topSid, subSid, parameter)
        return protoRequest.send()
    }

    /**
     * 返回带自定义参数的QueueParameter，调用
     * @param proto
     * @param receiveUri
     * @param receiver
     * @return
     */
    protected fun newQueueParameter(
        proto: P,
        receiveUri: Int,
        receiver: ProtoReceiver<P>
    ): QueueParameter<P, C> {
        return QueueParameter(this, proto, receiveUri) { receiver.onProto(it) }
    }

    /**
     * 返回带自定义参数的QueueParameter，调用
     * @param proto
     * @param receiveUri
     * @param receiver 高阶函数版，推荐
     * @return
     */
    protected fun newQueueParameter(
        proto: P,
        receiveUri: Int,
        receiver: (P) -> Unit
    ): QueueParameter<P, C> {
        return QueueParameter(this, proto, receiveUri, receiver)
    }

    protected fun onNotifyData(appId: Int, data: ByteArray) {
        try {
            if (getOwnAppId() != appId) return
            val proto = buildProto(data)
            val receiveContext = getProtoContext(proto)

            //只有找到正常的回包，被正确处理，才返回；否则交由广播逻辑处理
            receiveContext?.let {
                try {
                    if (mContextMap[it]?.onReceive(proto) == true)
                        return
                } catch (t: Throwable) {
                    onProtoException(t)
                }
            }
            //注册器的广播处理
            mResponseRegister.onReceive(proto, this)
            //全局的广播处理
            onNotificationData(proto)
        } catch (t: Throwable) {
            onProtoException(t)
        }
    }

    internal fun iGetTopSid(): Long {
        return getTopSid()
    }

    internal fun iGetSubSid(): Long {
        return getSubSid()
    }

    /**
     * 一个请求
     */
    inner class ProtoRequest(
        val data: ByteArray?,
        val receiver: (P) -> Unit,
        val appId: Int,
        val context: C?,
        val receiveUri: Int,
        val topSid: Long,
        val subSid: Long,
        val parameter: QueueParameter<P, C>?
    ) {
        private var protoDisposable: ProtoDisposable? = null

        fun send(): ProtoDisposable {
            val valContext = this.context
            if (data != null && valContext != null) {
                mContextMap[valContext] = this
                try {
                    mProtoSender?.onSend(appId, data, topSid, subSid)
                } catch (t: Throwable) {
                    onProtoException(t)
                }

                if (parameter != null && parameter.timeout > 0) {
                    mHandler.postAtTime({
                        handleTimeout()
                    }, valContext, SystemClock.uptimeMillis() + parameter.timeout.toLong())
                }
            }
            protoDisposable = ProtoDisposableImpl(valContext)
            return protoDisposable!!
        }

        private fun handleTimeout() {
            protoDisposable?.finish()
            if (protoDisposable?.isDisposed() == true) return
            try {
                parameter?.error?.invoke(ProtoTimeoutError("Wait for response timeout"))
            } catch (t: Throwable) {
                onProtoException(t)
            }
        }

        fun onReceive(proto: P): Boolean {
            if (getReceiveUri(proto) == receiveUri) {
                protoDisposable?.finish()
                if (protoDisposable?.isDisposed() == false)
                    receiver(proto)
                return true
            }
            return false
        }

        /**
         * 取消回包的实现
         * Created by zhongyongsheng on 2018/9/24.
         */
        inner class ProtoDisposableImpl(private val context: C?) : ProtoDisposable {
            var isDisposed = AtomicBoolean(false)
            var onFinishListener: (() -> Unit)? = null

            override fun dispose() {
                isDisposed.set(true)
                context?.let {
                    mContextMap.remove(it)
                    mHandler.removeCallbacksAndMessages(it)
                }
            }

            override fun isDisposed(): Boolean {
                return isDisposed.get()
            }

            override fun finish() {
                mContextMap.remove(context)
                mHandler.removeCallbacksAndMessages(context)
                onFinishListener?.invoke()
            }

            override fun registerLifecycle(lifecycle: Lifecycle) {
                lifecycle.addObserver(DisposableObserver(this))
            }

            override fun registerObservableViewModel(viewModel: ObservableViewModel) {
                context?.let {
                    val observer = viewModel.getCloseable(PROTO_DISPOSABLE_VM_KEY) ?: kotlin.run {
                        viewModel.addCloseableIfAbsent(PROTO_DISPOSABLE_VM_KEY, CloseableObserver<C>())
                    }
                    observer.contextMap[context] = this
                    this.onFinishListener = {
                        observer.contextMap.remove(context)
                    }
                }
            }
        }

        /**
         * 监听生命周期时，当onDestory/close时，停止任务执行
         */
        inner class DisposableObserver(private val disposable: ProtoDisposable) : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestroy() {
                disposable.dispose()
            }
        }

        /**
         * 监听生命周期时，当onDestory/close时，停止任务执行
         */
        inner class CloseableObserver<C> : Closeable {
            internal val contextMap = ConcurrentHashMap<C, ProtoDisposable>()

            override fun close() {
                contextMap.forEach {
                    it.value.dispose()
                }
            }
        }
    }

    companion object {
        private val PROTO_DISPOSABLE_VM_KEY = "PROTO_DISPOSABLE_VIEWMODEL_ONCLEAR"
    }

    /**
     * 自动生成不需要实现
     * 当前的上下文序列号
     * @return
     */
    abstract fun getSeqContext(): C

    /**
     * 自动生成不需要实现
     * 自增并返回上下文序列号
     * @return
     */
    abstract fun incrementAndGetSeqContext(): C

    /**
     * 自动生成不需要实现
     * 生成PROTO对象
     * @param data
     * @return
     * @throws Exception
     */
    @Throws(Exception::class)
    protected abstract fun buildProto(data: ByteArray): P

    /**
     * 自动生成不需要实现
     * 返回序列化后的ByteArray
     * @param proto
     * @return
     */
    protected abstract fun toByteArray(proto: P): ByteArray

    /**
     * 自动生成不需要实现
     * 取PROTO的上下文序列号
     * @param proto
     * @return
     */
    protected abstract fun getProtoContext(proto: P): C?

    /**
     * 自动生成不需要实现
     * 回包的URI
     * @param proto
     * @return
     */
    abstract fun getReceiveUri(proto: P): Int

    /**
     * 自动生成不需要实现
     * 设置URI到PROTO
     * @param proto
     * @return
     */
    protected abstract fun setUri(proto: P, uri: Int)

    //=============== 以下需要子类实现 ===========
    /**
     * 本协议的appid
     * @return
     */
    protected abstract fun getOwnAppId(): Int

    /**
     * 顶级频道号
     * @return
     */
    protected abstract fun getTopSid(): Long

    /**
     * 子频道号
     * @return
     */
    protected abstract fun getSubSid(): Long

    /**
     * 解协议时出现异常
     * @param throwable
     */
    protected abstract fun onProtoException(throwable: Throwable)

    /**
     * 不是发-》收的协议，纯广播的协议
     */
    protected abstract fun onNotificationData(proto: P)

    /**
     * 发送协议前的处理，可用于加header等处理
     * @param proto
     */
    protected abstract fun onProtoPreProcess(proto: P)
}
