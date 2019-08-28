package net.protoqueue.rpc.gen

import net.protoqueue.rpc.runtime.RPCParameter

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

    //自动生成代码使用，请不要直接使用
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

    //自动生成代码使用，请不要直接使用
    fun subscribe(serviceName: String, functionName: String, receiver: RPCNotifyReceiver) {
        adapter?.subscribe(serviceName, functionName, receiver)
    }

    //自动生成代码使用，请不要直接使用
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
    data: ByteArray,
    parameter: RPCParameter?
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
    data: ByteArray,
    parameter: RPCParameter?
) -> Unit

/**
 * 实现接口，调用的yyservicesdk的方法
 */
interface RPCAdapter {

    /**
     * 实现发送数据
     *
     * @param serviceName service名
     * @param functionName service方法名
     * @param bytes 发送的数据
     * @param successCallback 成功回调
     * @param errorCallback 失败回调
     * @param parameter 透传的参数
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
