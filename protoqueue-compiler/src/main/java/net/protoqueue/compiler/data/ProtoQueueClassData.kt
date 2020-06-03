package net.protoqueue.compiler.data

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.asClassName
import com.squareup.kotlinpoet.asTypeName
import net.protoqueue.util.toKotlinPrimitiveType
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
    protoClass: TypeMirror,
    protoContextType: TypeMirror,
    val resCodeLiteral: String,
    val resMessageLiteral: String,
    val rpcDatas: List<ProtoQueueRPCData>
) {
    val typeName = element.asClassName()
    val implClassName = typeName.simpleNames.joinToString("_") + "_Impl"
    val implTypeName = ClassName(typeName.packageName, implClassName)
    val protoClassTypeName = protoClass.asTypeName()
    val protoContextTypeName = protoContextType.asTypeName()
    val protoContextKotlinTypeName = protoContextType.asTypeName().toKotlinPrimitiveType()

    override fun toString(): String {
        return "ProtoQueueClassData(protoContextLiteral='$protoContextLiteral', buildProtoLiteral='" +
            "$buildProtoLiteral', toByteArrayLiteral='$toByteArrayLiteral', uriLiteral='$uriLiteral" +
            "', typeName=" +
            "$typeName, implClassName='$implClassName', implTypeName=$implTypeName, protoClassTypeName=" +
            "$protoClassTypeName, protoContextTypeName=$protoContextTypeName, rpcDatas=$rpcDatas, " +
            "resCodeLiteral=$resCodeLiteral, resMessageLiteral=$resMessageLiteral)"
    }
}