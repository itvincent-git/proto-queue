package net.protoqueue.rpc

/**
 * 注解在RPC配置的function上
 * Created by zhongyongsheng on 2020/4/21.
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class ProtoQueueRPC(
    val requestUri: Int,
    val responseUri: Int,
    val requestProperty: String,
    val responseProperty: String
)