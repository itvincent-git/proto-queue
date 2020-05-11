package net.protoqueue.compiler.data

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.asClassName
import com.squareup.kotlinpoet.asTypeName
import net.protoqueue.util.toKotlinPrimitiveType
import javax.lang.model.element.ExecutableElement
import javax.lang.model.element.TypeElement
import javax.lang.model.type.TypeMirror

/**
 * 注解处理完后记录的数据
 * Created by zhongyongsheng on 2018/4/14.
 */
class ProtoQueueClassData(
    element: TypeElement,
    val protoContextLiteral: String,
    val buildProtoLiteral: String,
    val toByteArrayLiteral: String,
    val uriLiteral: String,
    private val protoClass: TypeMirror,
    private val protoContextType: TypeMirror,
    val buildProtoMethod: ExecutableElement?,
    val toByteArrayMethod: ExecutableElement?,
    val getProtoContextMethod: ExecutableElement?,
    val getOwnAppIdMethod: ExecutableElement?,
    val incrementAndGetSeqContextMethod: ExecutableElement?,
    val getSeqContextMethod: ExecutableElement?,
    val getReceiveUriMethod: ExecutableElement?,
    val setUriMethod: ExecutableElement?
) {
    val typeName = element.asClassName()
    val implClassName = typeName.simpleNames.joinToString("_") + "_Impl"
    val implTypeName = ClassName.bestGuess(typeName.packageName + "." + implClassName)
    val protoClassTypeName = protoClass.asTypeName()
    val protoContextTypeName = protoContextType.asTypeName()
    val protoContextKotlinTypeName = protoContextType.asTypeName().toKotlinPrimitiveType()

//    init {
//        CompilerContext.log.debug("protoContextKotlinTypeName:${protoContextKotlinTypeName}")
//        CompilerContext.log.debug("${java.lang.Long::class.java.name}")
//    }

    override fun toString(): String {
        return "ProtoQueueClassData(protoContextLiteral='$protoContextLiteral', buildProtoLiteral='" +
            "$buildProtoLiteral', toByteArrayLiteral='$toByteArrayLiteral', uriLiteral='$uriLiteral" +
            "', buildProtoMethod=$buildProtoMethod, toByteArrayMethod=$toByteArrayMethod" +
            ", getProtoContextMethod=$getProtoContextMethod, getOwnAppIdMethod=$getOwnAppIdMethod" +
            ", incrementAndGetSeqContextMethod=$incrementAndGetSeqContextMethod, getSeqContextMethod=" +
            "$getSeqContextMethod, getReceiveUriMethod=$getReceiveUriMethod, typeName=" +
            "$typeName, implClassName='$implClassName', implTypeName=$implTypeName, protoClassTypeName=" +
            "$protoClassTypeName, protoContextTypeName=$protoContextTypeName)"
    }
}