package net.protoqueue.rpc.gen

/**
 * //todo only test, must remove
 * Created by zhongyongsheng on 2019-08-13.
 */
object RPCApi {
    internal var adapter: RPCAdapter? = null
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

class RPCError(val sdkResCode: Int, val srvResCode: Int) : Exception() {
    override fun toString(): String {
        return "RPCError(sdkResCode=$sdkResCode, srvResCode=$srvResCode)"
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

interface RPCAdapter {
    fun send(
        serviceName: String, functionName: String, bytes: ByteArray, parameter: RPCParameter? = null,
        successCallback: RPCResponseCallback,
        errorCallback: RPCErrorCallback? = null
    )

    fun subscribe(serviceName: String, functionName: String, receiver: RPCNotifyReceiver)
}

data class RPCParameter(val timeout: Long = 0L)