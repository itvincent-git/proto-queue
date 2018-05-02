package net.port.transformer.processor


import net.port.transformer.compiler.common.CompilerContext
import net.port.transformer.compiler.data.ProtoQueueClassData
import net.port.transformer.util.Util
import net.protoqueue.annotation.ProtoQueueClass
import javax.lang.model.element.TypeElement

/**
 * Created by zhongyongsheng on 2018/4/14.
 */
class ProtoQueueClassProcessor internal constructor(internal var compileContext: CompilerContext, internal var classElement: TypeElement) {

    internal fun process(): ProtoQueueClassData {
        val annotationMirror = Util.getAnnotationMirror(classElement, ProtoQueueClass::class.java)
        compileContext.log.warn("process @ProtoQueueClass:", annotationMirror)
        //        List<? extends Element> allMembers = Util.getAllMembers(compileContext.processingEnvironment, transformerElement);
        //        List<PortInterfaceMethod> portInterfaceMethodList = allMembers.stream()
        //                .filter(
        //                        (Predicate<Element>) element ->
        //                                element.getModifiers().contains(Modifier.ABSTRACT) && element.getKind().equals(ElementKind.METHOD))
        //                .map((Function<Element, PortInterfaceMethod>) element -> {
        //                    ExecutableElement methodElement = Util.asExecutable(element);
        //                    TypeElement interfaceType = Util.toTypeElement(methodElement.getReturnType());
        //                    PortInterfaceData data = new PortInterfaceProcessor(compileContext, interfaceType).process();
        //                    PortInterfaceMethod method = new PortInterfaceMethod(methodElement, methodElement.getSimpleName().toString(), data);
        //                    return method;
        //                }).collect(Collectors.toList());
        //
        //        portInterfaceMethodList.forEach(portInterfaceMethod -> {
        //            try {
        //                new PortInterfaceWriter(portInterfaceMethod.portInterfaceData).write(compileContext.processingEnvironment);
        //            } catch (IOException e) {
        //                compileContext.log.error("PortInterfaceWriter error", e.getMessage());
        //            }
        //
        //        });
        return ProtoQueueClassData(classElement/*, portInterfaceMethodList*/)
    }
}
