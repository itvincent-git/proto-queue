package net.protoqueue.rpc.gen

/**
 * 生成通知的结构
 * @author linmin1 on 2019-08-14.
 *
 */
data class NotifyStruct(val notifyFunctionName: String, val notifyType: String) {
    val notifyFunctionGenName: String = "subscribe" + notifyFunctionName.capitalize()
    val notifyPackage: String = notifyType.substringBeforeLast(".")
    val notifySimpleName: String = notifyType.substringAfterLast(".")
}