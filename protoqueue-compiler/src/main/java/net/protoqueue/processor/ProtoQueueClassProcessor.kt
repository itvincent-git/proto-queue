package net.protoqueue.processor


import com.google.auto.common.MoreElements
import com.google.auto.common.MoreTypes
import net.protoqueue.compiler.common.CompilerContext
import net.protoqueue.compiler.data.ProtoQueueClassData
import net.protoqueue.util.Util
import net.protoqueue.annotation.ProtoQueueClass
import javax.lang.model.element.TypeElement

/**
 * Created by zhongyongsheng on 2018/4/14.
 */
class ProtoQueueClassProcessor internal constructor(internal var compileContext: CompilerContext, internal var classElement: TypeElement) {

    internal fun process(): ProtoQueueClassData {
        val annotationMirror = Util.getAnnotationMirror(classElement, ProtoQueueClass::class.java)
        //compileContext.log.debug("process @ProtoQueueClass:%s", annotationMirror)

        val appId = Util.getAnnotationValue(annotationMirror, "appId").value as Int
        val protoContextLiteral = Util.getAnnotationValue(annotationMirror, "protoContextLiteral").toString()
        //val protoContextTypeValue = Util.getAnnotationValue(annotationMirror, "protoContextType")
        //val protoContextTypeMirror = Util.annotationValueToType(protoContextTypeValue)

//        compileContext.log.debug("ProtoQueueClassProcessor process %s",
//                classElement.superclass)
//        val superClass = Util.toTypeElement(classElement.superclass)
        val superClass = classElement.superclass
        val declaredType = Util.asDeclared(superClass)
        val typeArguments = declaredType.typeArguments

        if (typeArguments.size < 2) {
            compileContext.log.error(classElement, "must defined the type arguments <P,C>")
        }

        compileContext.log.debug("ProtoQueueClassProcessor declaredType %s", typeArguments)
//        declaredType.typeParameters/*.map ({it.genericElement})*/.forEach {
//            compileContext.log.debug("ProtoQueueClassProcessor foreach %s", it.genericElement) }

        return ProtoQueueClassData(classElement, appId, protoContextLiteral, typeArguments[1])
    }
}
