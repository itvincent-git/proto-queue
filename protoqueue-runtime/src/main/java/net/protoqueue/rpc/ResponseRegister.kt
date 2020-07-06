package net.protoqueue.rpc

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import net.protoqueue.ProtoQueue
import net.stripe.lib.ICloseableObserver
import java.io.Closeable
import java.util.concurrent.ConcurrentHashMap

/**
 * 回包的回调注册器，为线程安全的方法
 * Created by zhongyongsheng on 2020/5/11.
 */
class ResponseRegister<PROTO> {
    private val registerMap = ConcurrentHashMap<Int, MutableList<(PROTO) -> Unit>>()

    @Synchronized
    fun addRegister(uri: Int, block: (PROTO) -> Unit): ResponseRegisterDisposable {
        registerMap[uri]?.let {
            it.add(block)
        } ?: kotlin.run {
            registerMap.put(uri, mutableListOf(block))
        }
        return ResponseRegisterDisposable {
            removeRegister(uri, block)
        }
    }

    @Synchronized
    fun removeRegister(uri: Int, block: (PROTO) -> Unit) {
        registerMap[uri]?.let {
            it.remove(block)
        }
    }

    fun <C> onReceive(value: PROTO, protoQueue: ProtoQueue<PROTO, C>) {
        val uri = protoQueue.getReceiveUri(value)
        val registerList = registerMap[uri]
        if (registerList != null) {
            for (register in registerList) {
                register(value)
            }
        }
    }
}

/**
 * 可取消注册uri,block
 */
class ResponseRegisterDisposable(val block: () -> Unit) {

    /**
     * 取消注册的监听
     */
    fun dispose() {
        block()
    }
}

/**
 * 对[LifecycleOwner]绑定监听的广播，生命周期到ON_DESTROY时，则会解除监听
 */
fun LifecycleOwner.rpcRegister(block: RegisterBuilder.() -> Unit) {
    val builder = RegisterBuilder {
        lifecycle.addObserver(object : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestroy() {
                it.dispose()
            }
        })
    }
    block(builder)
}

private const val OBSERVABLE_VIEW_MODEL_CLOSEABLE_KEY = "OBSERVABLE_VIEW_MODEL_CLOSEABLE"

/**
 *  对[ICloseableObserver]绑定监听的广播，生命周期到结束时，则会解除监听
 */
fun ICloseableObserver.rpcRegister(block: RegisterBuilder.() -> Unit) {
    val builder = RegisterBuilder {
        addCloseableIfAbsent(OBSERVABLE_VIEW_MODEL_CLOSEABLE_KEY, object : Closeable {
            override fun close() {
                it.dispose()
            }
        })
    }
    block(builder)
}

/**
 * 对[LifecycleOwner]绑定监听的广播，生命周期到ON_DESTROY时，则会解除监听
 */
class RegisterBuilder(
    private val callback: (ResponseRegisterDisposable) -> Unit
) {
    fun <REQ, RES> RPC<REQ, RES>.onResponse(block: (RES?, ResponseParameter) -> Unit) {
        val disposable = registerResponse(block)
        callback(disposable)
    }
}