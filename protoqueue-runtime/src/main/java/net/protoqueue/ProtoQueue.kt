package net.protoqueue

import android.os.Handler
import android.os.Message
import java.util.concurrent.ConcurrentHashMap

/**
 * P代表ProtoBuffer类，C代表上下文的类型（例如seqId是Integer类型）
 * Created by zhongyongsheng on 2018/4/20.
 */
abstract class ProtoQueue<P, C> {
    protected var mProtoSender: ProtoSender? = null
    protected var mContextMap: MutableMap<C, ProtoContext<P, C>> = ConcurrentHashMap()
    protected var mHandler: Handler = ProtoHandler()


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
    protected fun enqueue(proto: P,
                          receiveUri: Int,
                          receiver: ProtoReceiver<P>): ProtoDisposable {
        return enqueue(proto, receiveUri, getTopSid(), getSubSid(), { receiver.onProto(it) }, null)
    }

    /**
     * 发送协议，回调接收协议
     * @param proto 发送协议
     * @param receiveUri 接收协议的uri
     * @param receiver 接收协议回调(高阶函数）推荐
     * @return
     */
    protected fun enqueue(proto: P,
                          receiveUri: Int,
                          receiver: (P) -> Unit): ProtoDisposable {
        return enqueue(proto, receiveUri, getTopSid(), getSubSid(), receiver, null)
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
    internal fun enqueue(proto: P,
                receiveUri: Int,
                topSid: Long,
                subSid: Long,
                receiver: (P) -> Unit,
                parameter: QueueParameter<P, C>?): ProtoDisposable {

        var data: ByteArray? = null
        var context: C? = null
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
            context = getProtoContext(proto)
        } catch (t: Throwable) {
            onProtoException(t)
        }

        val protoContext = ProtoContext(data, receiver, getOwnAppId(), context,
                receiveUri, topSid, subSid, parameter)

        if (data != null && context != null) {
            mContextMap[context] = protoContext
            mProtoSender?.onSend(getOwnAppId(), data, topSid, subSid)

            if (parameter != null && parameter.timeout > 0) {
                val message = mHandler.obtainMessage()
                message.what = 1
                message.obj = context
                mHandler.sendMessageDelayed(message, parameter.timeout.toLong())
            }
        }

        return protoContext.protoDisposable
    }

    /**
     * 返回带自定义参数的QueueParameter，调用
     * @param proto
     * @param receiveUri
     * @param receiver
     * @return
     */
    protected fun newQueueParameter(proto: P,
                                    receiveUri: Int,
                                    receiver: ProtoReceiver<P>): QueueParameter<P, C> {
        return QueueParameter(this, proto, receiveUri) { receiver.onProto(it) }
    }

    /**
     * 返回带自定义参数的QueueParameter，调用
     * @param proto
     * @param receiveUri
     * @param receiver 高阶函数版，推荐
     * @return
     */
    protected fun newQueueParameter(proto: P,
                                    receiveUri: Int,
                                    receiver: (P) -> Unit): QueueParameter<P, C> {
        return QueueParameter(this, proto, receiveUri, receiver)
    }

    protected fun onNotifyData(appId: Int, data: ByteArray) {
        try {
            if (getOwnAppId() != appId) return
            val proto = buildProto(data)
            val protoContext = getProtoContext(proto)

            val context = mContextMap[protoContext]
            if (context != null && getReceiveUri(proto) == context.receiveUri) {
                mContextMap.remove(protoContext)
                if (!context.protoDisposable.isDisposed)
                    context.receiver(proto)
            } else {
                onNotificationData(proto)
            }
        } catch (t: Throwable) {
            onProtoException(t)
        }

    }

    private fun handleTimeout(msg: Message) {
        val context = msg.obj as C
        val protoContext = mContextMap[context] ?: return
        if (protoContext.protoDisposable.isDisposed) return
        if (protoContext.parameter != null && protoContext.parameter?.error != null) {
            protoContext.parameter?.error?.invoke(ProtoTimeoutError("Wait for response timeout"))
        }
        mContextMap.remove(context)
    }

    internal inner class ProtoHandler : Handler() {
        override fun handleMessage(msg: Message) {
            try {
                when (msg.what) {
                    1 -> handleTimeout(msg)
                }
            } catch (t: Throwable) {
                onProtoException(t)
            }

        }
    }

    internal fun iGetTopSid(): Long {
        return getTopSid()
    }

    internal fun iGetSubSid(): Long {
        return getSubSid()
    }

    /**
     * 自动生成不需要实现
     * @return
     */
    abstract fun getSeqContext(): C

    /**
     * 自动生成不需要实现
     * @return
     */
    abstract fun incrementAndGetSeqContext(): C

    /**
     * 自动生成不需要实现
     * @param data
     * @return
     * @throws Exception
     */
    @Throws(Exception::class)
    protected abstract fun buildProto(data: ByteArray): P

    /**
     * 自动生成不需要实现
     * @param proto
     * @return
     */
    protected abstract fun toByteArray(proto: P): ByteArray

    /**
     * 自动生成不需要实现
     * @param proto
     * @return
     */
    protected abstract fun getProtoContext(proto: P): C

    /**
     * 自动生成不需要实现
     * @param proto
     * @return
     */
    protected abstract fun getReceiveUri(proto: P): Int

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
