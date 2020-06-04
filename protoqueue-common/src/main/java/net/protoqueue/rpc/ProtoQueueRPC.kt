package net.protoqueue.rpc

/**
 * 注解在RPC配置的function上
 * Created by zhongyongsheng on 2020/4/21.
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.SOURCE)
annotation class ProtoQueueRPC(
    /**
     * 请求的uri，例如kUserRequestUri
     */
    val requestUri: Int = Int.MIN_VALUE,

    /**
     * 响应的uri，例如kUserResponseUri
     */
    val responseUri: Int,

    /**
     * 请求类在外层Proto中访问属性名，例如userRequest，这里是生成的java文件中的驼峰式名称，不是.proto文件中带_的名称
     */
    val requestProperty: String = "",

    /**
     * 响应类在外层Proto中访问属性名，例如userRequest，这里是生成的java文件中的驼峰式名称，不是.proto文件中带_的名称
     */
    val responseProperty: String
)