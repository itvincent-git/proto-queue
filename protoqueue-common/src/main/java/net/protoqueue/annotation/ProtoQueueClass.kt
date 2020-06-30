package net.protoqueue.annotation

/**
 * 注解在入口类上
 * Created by zhongyongsheng on 2020/4/20.
 */
@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class ProtoQueueClass(
    /**
     * seq上下文在proto里定义的名称
     * %L传入的是proto
     * @return
     */
    val protoContextLiteral: String = "return %L.header?.seqid",
    /**
     * 生成buildProto的语句，默认例如FtsUserProto.parseFrom
     * %T是PROTO类名
     * %L是data
     * @return
     */
    val buildProtoLiteral: String = "return %T.parseFrom(%L)",
    /**
     * 生成toByteArray的语句
     * @return
     */
    val toByteArrayLiteral: String = "return com.google.protobuf.nano.MessageNano.toByteArray(proto)",
    /**
     * uri在proto里定义的名称
     * @return
     */
    val uriLiteral: String = "uri",

    /**
     * rpc方法中使用到的获取response header代码
     * %L是PROTO的实例
     */
    val resHeaderLiteral: String = "%L.header"
)