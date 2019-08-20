package net.protoqueue.rpc.gen

/**
 * RPCApi
 * 使用前需要先调用initialize()方法，自定义adapter
 * Created by zhongyongsheng on 2019-08-13.
 */
object RPCApi {
    private var adapter: RPCAdapter? = null

    /**
     * 必须先初始化，实现RPCAdapter的方法，才能正常收发数据
     */
    @JvmStatic
    fun initialize(_adapter: RPCAdapter) {
        adapter = _adapter
    }

    fun send(
        serviceName: String,
        functionName: String,
        bytes: ByteArray,
        successCallback: RPCResponseCallback,
        errorCallback: RPCErrorCallback? = null,
        parameter: RPCParameter? = null
    ) {
        adapter?.send(serviceName, functionName, bytes, successCallback, errorCallback, parameter)
    }

    fun subscribe(serviceName: String, functionName: String, receiver: RPCNotifyReceiver) {
        adapter?.subscribe(serviceName, functionName, receiver)
    }

    fun unsubscribe(serviceName: String, functionName: String, receiver: RPCNotifyReceiver) {
        adapter?.unsubscribe(serviceName, functionName, receiver)
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

    /**
     * 实现发送数据
     */
    fun send(
        serviceName: String,
        functionName: String,
        bytes: ByteArray,
        successCallback: RPCResponseCallback,
        errorCallback: RPCErrorCallback? = null,
        parameter: RPCParameter? = null
    )

    /**
     * 实现监听接收数据
     */
    fun subscribe(serviceName: String, functionName: String, receiver: RPCNotifyReceiver)

    /**
     * 实现取消监听接收数据
     */
    fun unsubscribe(serviceName: String, functionName: String, receiver: RPCNotifyReceiver)
}

data class RPCParameter(val timeout: Long = 0L)