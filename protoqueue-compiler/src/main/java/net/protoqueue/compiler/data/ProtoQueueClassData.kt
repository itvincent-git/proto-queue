package net.protoqueue.compiler.data

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.asClassName
import com.squareup.kotlinpoet.asTypeName
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
    val protoClass: TypeMirror,
    val protoContextType: TypeMirror,
    val buildProtoMethod: ExecutableElement?,
    val toByteArrayMethod: ExecutableElement?,
    val getProtoContextMethod: ExecutableElement?,
    val getOwnAppIdMethod: ExecutableElement?,
    val incrementAndGetSeqContextMethod: ExecutableElement?,
    val getSeqContextMethod: ExecutableElement?,
    val getReceiveUriMethod: ExecutableElement?
) {
    val typeName = element.asClassName()
    val implClassName = typeName.simpleNames.joinToString("_") + "_Impl"
    val implTypeName = ClassName.bestGuess(typeName.packageName + "." + implClassName)
    val protoClassTypeName = protoClass.asTypeName()

    init {
    }

    override fun toString(): String {
        return "ProtoQueueClassData(protoContextLiteral='$protoContextLiteral', buildProtoLiteral='" +
            "$buildProtoLiteral', toByteArrayLiteral='$toByteArrayLiteral', uriLiteral='$uriLiteral'" +
            ", protoClass=$protoClass, protoContextType=$protoContextType, buildProtoMethod=$buildProtoMethod," +
            " toByteArrayMethod=$toByteArrayMethod, getProtoContextMethod=$getProtoContextMethod, " +
            "getOwnAppIdMethod=$getOwnAppIdMethod, incrementAndGetSeqContextMethod=$incrementAndGetSeqContextMethod, " +
            "getSeqContextMethod=$getSeqContextMethod, getReceiveUriMethod=$getReceiveUriMethod, " +
            "implTypeName=$implTypeName, typeName=$typeName)"
    }
}
