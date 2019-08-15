package net.protoqueue.rpc.gen

/**
 * Created by zhongyongsheng on 2019-08-13.
 */
object RPCApi {
    internal var adapter: RPCAdapter? = null
    fun initialize(_adapter: RPCAdapter) {
        adapter = _adapter
    }
}

/**
 * 成功回调
 */
typealias RPCResponseCallback = (
    serverName: String,
    funcName: String, protoType: String,
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
        errorCallback: RPCErrorCallback
    )

    fun subscribeNotify(serverName: String, functionName: String, receiver: RPCNotifyReceiver)
}

data class RPCParameter(val timeout: Long = 0L)