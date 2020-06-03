package net.protoqueue.compiler.data

import com.squareup.kotlinpoet.asTypeName
import net.protoqueue.compiler.common.CompilerContext
import net.protoqueue.rpc.ProtoQueueRPC
import net.protoqueue.util.asDeclaredType
import net.protoqueue.util.toTypeElement
import javax.lang.model.element.ExecutableElement
import javax.lang.model.type.TypeMirror

/**
 * Created by zhongyongsheng on 2020/6/2.
 */
data class ProtoQueueRPCData(
    val executableElement: ExecutableElement,
    val requestUri: Int,
    val responseUri: Int,
    val requestProperty: String,
    val responseProperty: String,
    private val requestProtoClass: TypeMirror,
    private val responseProtoClass: TypeMirror
) {
    val requestProtoClassTypeName = requestProtoClass.asTypeName()
    val responseProtoClassTypeName = responseProtoClass.asTypeName()

    companion object {
        fun parse(element: ExecutableElement): ProtoQueueRPCData {
            val annotation = element.getAnnotation(ProtoQueueRPC::class.java)
            if (element.returnType.toTypeElement().toString() != "net.protoqueue.rpc.RPC") {
                CompilerContext.log.error(element, "must use RPC to defined the return type, actual is ${element
                    .returnType.toTypeElement()}")
            }
            val returnDeclaredType = element.returnType.asDeclaredType()
            val returnTypeArguments = returnDeclaredType.typeArguments
            if (returnTypeArguments.size < 2) {
                CompilerContext.log.error(element, "must defined the return type arguments <Request,Response>")
            }
            return ProtoQueueRPCData(
                executableElement = element,
                requestUri = annotation.requestUri,
                responseUri = annotation.responseUri,
                requestProperty = annotation.requestProperty,
                responseProperty = annotation.responseProperty,
                requestProtoClass = returnTypeArguments[0],
                responseProtoClass = returnTypeArguments[1]
            )
        }
    }
}