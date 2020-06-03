package net.protoqueue.processor

import net.protoqueue.annotation.ProtoQueueClass
import net.protoqueue.compiler.common.CompilerContext
import net.protoqueue.compiler.data.ProtoQueueClassData
import net.protoqueue.compiler.data.ProtoQueueRPCData
import net.protoqueue.rpc.ProtoQueueRPC
import net.protoqueue.util.asDeclaredType
import net.protoqueue.util.asExecutable
import net.protoqueue.util.getAllMembers
import net.protoqueue.util.getAnnotationMirror
import net.protoqueue.util.getAnnotationValue
import javax.lang.model.element.ElementKind
import javax.lang.model.element.Modifier
import javax.lang.model.element.TypeElement

/**
 * 解析@ProtoQueueClass标注的类
 * Created by zhongyongsheng on 2018/4/14.
 */
class ProtoQueueClassProcessor(
    private var classElement: TypeElement
) {


    internal fun process(): ProtoQueueClassData {
        val annotationMirror = classElement.getAnnotationMirror(ProtoQueueClass::class.java)
        val protoContextLiteral =
            annotationMirror.getAnnotationValue("protoContextLiteral").toString().filter { it != '\"' }
        val toByteArrayLiteral =
            annotationMirror.getAnnotationValue("toByteArrayLiteral").toString().filter { it != '\"' }
        val buildProtoLiteral =
            annotationMirror.getAnnotationValue("buildProtoLiteral").toString().filter { it != '\"' }
        val uriLiteral = annotationMirror.getAnnotationValue("uriLiteral").toString().filter { it != '\"' }
        val resCodeLiteral = annotationMirror.getAnnotationValue("resCodeLiteral").toString().filter { it != '\"' }
        val resMessageLiteral =
            annotationMirror.getAnnotationValue("resMessageLiteral").toString().filter { it != '\"' }
        val superClass = classElement.superclass
        val declaredType = superClass.asDeclaredType()
        val typeArguments = declaredType.typeArguments

        if (typeArguments.size < 2) {
            CompilerContext.log.error(classElement, "must defined the type arguments <P,C>")
        }

        val allMembers = classElement.getAllMembers(CompilerContext.processingEnvironment)
        val overrideMethods = allMembers
            .filter { it.modifiers.contains(Modifier.ABSTRACT) && it.kind == ElementKind.METHOD }
            .map { it.asExecutable() }
            .map { it.toString() to it }.toMap()

        CompilerContext.log.debug("overrideMethods $overrideMethods")

        val rpcDatas = allMembers.filter { it.modifiers.contains(Modifier.ABSTRACT) && it.kind == ElementKind.METHOD }
            .filter { it.getAnnotation(ProtoQueueRPC::class.java) != null }
            .map { it.asExecutable() }
            .map { ProtoQueueRPCData.parse(it) }

        var data = ProtoQueueClassData(classElement,
            protoContextLiteral,
            buildProtoLiteral,
            toByteArrayLiteral,
            uriLiteral,
            typeArguments[0],
            typeArguments[1],
            resCodeLiteral,
            resMessageLiteral,
            rpcDatas)
        CompilerContext.log.debug("ProtoQueue process %s/%s", classElement.toString(), data)
        return data
    }
}
