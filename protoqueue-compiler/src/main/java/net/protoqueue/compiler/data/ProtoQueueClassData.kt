package net.protoqueue.compiler.data

import com.squareup.javapoet.ClassName

import javax.lang.model.element.TypeElement
import javax.lang.model.type.TypeMirror

/**
 * Created by zhongyongsheng on 2018/4/14.
 */
class ProtoQueueClassData(element: TypeElement,
                          val appId: Int,
                          val protoContextLiteral: String,
                          val protoClass: TypeMirror,
                          val protoContextType: TypeMirror) {
    var implTypeName: ClassName
    var typeName: ClassName

    init {
        typeName = ClassName.get(element)
        val implClassName = typeName.simpleNames().joinToString("_") + "_Impl"
        implTypeName = ClassName.get(typeName.packageName(), implClassName)
    }

    override fun toString(): String {
        return "ProtoQueueClassData(appId=$appId, protoContextLiteral='$protoContextLiteral', protoClass=$protoClass, protoContextType=$protoContextType, implTypeName=$implTypeName, typeName=$typeName)"
    }


}
