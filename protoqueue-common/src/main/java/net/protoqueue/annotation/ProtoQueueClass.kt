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
     * @return
     */
    val protoContextLiteral: String = "return %T.header.getSeqid()",
    /**
     * 生成buildProto的语句，默认例如FtsUserProto.parseFrom
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
    val uriLiteral: String = "uri"
)