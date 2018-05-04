package net.protoqueue.processor


import net.protoqueue.annotation.ProtoQueueClass
import net.protoqueue.compiler.common.CompilerContext
import net.protoqueue.compiler.data.ProtoQueueClassData
import net.protoqueue.util.Util
import javax.lang.model.element.ElementKind
import javax.lang.model.element.Modifier
import javax.lang.model.element.TypeElement

/**
 * Created by zhongyongsheng on 2018/4/14.
 */
class ProtoQueueClassProcessor internal constructor(internal var compileContext: CompilerContext, internal var classElement: TypeElement) {


    internal fun process(): ProtoQueueClassData {
        val annotationMirror = Util.getAnnotationMirror(classElement, ProtoQueueClass::class.java)

        val appId = Util.getAnnotationValue(annotationMirror, "appId").value as Int
        val protoContextLiteral = Util.getAnnotationValue(annotationMirror, "protoContextLiteral").toString()
        val superClass = classElement.superclass
        val declaredType = Util.asDeclared(superClass)
        val typeArguments = declaredType.typeArguments

        if (typeArguments.size < 2) {
            compileContext.log.error(classElement, "must defined the type arguments <P,C>")
        }

        val allMembers = Util.getAllMembers(compileContext.processingEnvironment, classElement)
        val overrideMethods = allMembers
                .filter({ element -> element.modifiers.contains(Modifier.ABSTRACT) && element.kind == ElementKind.METHOD })
                .map {
                    Util.asExecutable(it)
                }
                .map { it.toString() to it }.toMap()
//        compileContext.log.debug("ProtoQueueClassProcessor declaredType %s", typeArguments)

        var data = ProtoQueueClassData(classElement,
                appId,
                protoContextLiteral.filter { it != '\"' },
                typeArguments[0],
                typeArguments[1],
                overrideMethods["buildProto(byte[])"],
                overrideMethods["toByteArray(P)"],
                overrideMethods["getProtoContext(P)"],
                overrideMethods["getOwnAppId()"],
                overrideMethods["incrementAndGetSeqContext()"],
                overrideMethods["getSeqContext()"])
        compileContext.log.debug("ProtoQueueClassProcessor data %s", data)
        return data
    }
}
