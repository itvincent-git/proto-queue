package net.protoqueue.compiler.data

import com.squareup.javapoet.ClassName

import javax.lang.model.element.TypeElement

/**
 * Created by zhongyongsheng on 2018/4/14.
 */
class ProtoQueueClassData(element: TypeElement/*, List<PortInterfaceMethod> portInterfaceMethodList*/) {
    var implTypeName: ClassName
    var typeName: ClassName
//    var portInterfaceMethodList: List<PortInterfaceMethod>? = null

    init {
        typeName = ClassName.get(element)
        val implClassName = typeName.simpleNames().joinToString("_") + "_Impl"
        implTypeName = ClassName.get(typeName.packageName(), implClassName)

        //        this.portInterfaceMethodList = portInterfaceMethodList;
    }
}
