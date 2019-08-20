package net.protoqueue.rpc.runtime

import net.protoqueue.rpc.gen.RPCApi
import net.protoqueue.rpc.gen.RPCNotifyReceiver

/**
 * RPC Handler 订阅后返回的监听器，可用于取消监听
 * Created by zhongyongsheng on 2019-08-20.
 */
class RPCHandlerObserver(
    private val serviceName: String,
    private val functionName: String,
    private var receiver: RPCNotifyReceiver?
) {

    fun cancel() {
        receiver?.let { RPCApi.unsubscribe(serviceName, functionName, it) }
        receiver = null
    }
}