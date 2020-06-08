package net.protoqueue.rpc

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import net.protoqueue.ProtoQueue
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
    val builder = RegisterBuilder(this)
    block(builder)
}

/**
 * 对[LifecycleOwner]绑定监听的广播，生命周期到ON_DESTROY时，则会解除监听
 */
class RegisterBuilder(private val lifecycleOwner: LifecycleOwner) {
    fun <REQ, RES> RPC<REQ, RES>.onRegister(block: (RES?, ResponseParameter) -> Unit) {
        val disposable = registerResponse(block)
        lifecycleOwner.lifecycle.addObserver(object : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestroy() {
                disposable.dispose()
            }
        })
    }
}