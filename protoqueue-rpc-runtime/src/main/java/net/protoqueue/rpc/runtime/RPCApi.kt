package net.protoqueue.rpc.gen

import net.protoqueue.rpc.runtime.RPCError

/**
 * RPCApi
 * 使用前需要先调用initialize()方法，自定义adapter
 * Created by zhongyongsheng on 2019-08-13.
 */
object RPCApi {
    private var adapter: RPCAdapter? = null
    fun initialize(_adapter: RPCAdapter) {
        adapter = _adapter
    }

    @Throws(RPCError::class)
    fun send(
        serviceName: String, functionName: String, bytes: ByteArray,
        successCallback: RPCResponseCallback,
        errorCallback: RPCErrorCallback? = null,
        parameter: RPCParameter? = null
    ) {
        adapter?.send(serviceName, functionName, bytes, parameter, successCallback, errorCallback)
    }

    fun subscribe(serviceName: String, functionName: String, receiver: RPCNotifyReceiver) {
        adapter?.subscribe(serviceName, functionName, receiver)
    }
}

/**
 * 成功回调
 */
typealias RPCResponseCallback = (
    serviceName: String,
    funcName: String,
    data: ByteArray
) -> Unit

/**
 * 错误回调
 */
typealias RPCErrorCallback = (sdkResCode: Int, srvResCode: Int) -> Unit

/**
 * 通知接通器
 */
typealias RPCNotifyReceiver = (
    serviceName: String,
    functionName: String,
    data: ByteArray
) -> Unit

/**
 * 实现接口，调用的yyservicesdk的方法
 */
interface RPCAdapter {
    fun send(
        serviceName: String, functionName: String, bytes: ByteArray, parameter: RPCParameter? = null,
        successCallback: RPCResponseCallback,
        errorCallback: RPCErrorCallback? = null
    )

    fun subscribe(serviceName: String, functionName: String, receiver: RPCNotifyReceiver)
}

data class RPCParameter(val timeout: Long = 0L)