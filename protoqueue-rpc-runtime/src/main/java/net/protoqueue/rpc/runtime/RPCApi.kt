package net.protoqueue.rpc.gen

import java.lang.RuntimeException

/**
 * Created by zhongyongsheng on 2019-08-13.
 */
object RPCApi {
    internal var adapter: RPCAdapter? = null
    fun initialize(_adapter: RPCAdapter) {
        adapter = _adapter
    }

    fun send(
        service: String, functionName: String, bytes: ByteArray,
        successCallback: RPCResponseCallback,
        errorCallback: RPCErrorCallback? = null,
        parameter: RPCParameter? = null
    ) {
        adapter?.send(service, functionName, bytes, parameter, successCallback, errorCallback)
    }

    fun subscribe(serviceName: String, functionName: String, receiver: RPCNotifyReceiver) {
        adapter?.subscribe(serviceName, functionName, receiver)
    }
}

class RPCError(val sdkResCode: Int, val srvResCode: Int) : RuntimeException()

/**
 * 成功回调
 */
typealias RPCResponseCallback = (
    serverName: String,
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

interface RPCAdapter {
    fun send(
        serverName: String, functionName: String, bytes: ByteArray, parameter: RPCParameter? = null,
        successCallback: RPCResponseCallback,
        errorCallback: RPCErrorCallback? = null
    )

    fun subscribe(serverName: String, functionName: String, receiver: RPCNotifyReceiver)
}

data class RPCParameter(val timeout: Long = 0L)