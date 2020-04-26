package net.protoqueue.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解在入口类上
 * Created by zhongyongsheng on 2018/4/20.
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface ProtoQueueClass {

    /**
     * seq上下文在proto里定义的名称
     * @return
     */
    String protoContextLiteral();

    /**
     * 生成buildProto的语句，默认例如FtsUserProto.parseFrom
     * @return
     */
    String buildProtoLiteral() default "return %T.parseFrom(%L)";

    /**
     * 生成toByteArray的语句
     * @return
     */
    String toByteArrayLiteral() default "return com.google.protobuf.nano.MessageNano.toByteArray(proto)";

    /**
     * uri在proto里定义的名称
     * @return
     */
    String uriLiteral() default "uri";
}
