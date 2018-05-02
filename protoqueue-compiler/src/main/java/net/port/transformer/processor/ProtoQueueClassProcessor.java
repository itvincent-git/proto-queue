package net.port.transformer.processor;


import net.port.transformer.annotation.PortProcessor;
import net.port.transformer.compiler.writer.PortInterfaceWriter;
import net.port.transformer.util.Util;
import net.port.transformer.compiler.common.CompilerContext;
import net.port.transformer.compiler.data.PortInterfaceData;
import net.port.transformer.compiler.data.PortInterfaceMethod;
import net.port.transformer.compiler.data.ProtoQueueClassData;
import net.protoqueue.annotation.ProtoQueueClass;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

/**
 * Created by zhongyongsheng on 2018/4/14.
 */
public class ProtoQueueClassProcessor {
    CompilerContext compileContext;
    TypeElement classElement;

    ProtoQueueClassProcessor(CompilerContext context, TypeElement element) {
        compileContext = context;
        classElement = element;
    }

    ProtoQueueClassData process() {
        AnnotationMirror annotationMirror = Util.getAnnotationMirror(classElement, ProtoQueueClass.class);
        compileContext.log.warn("process @ProtoQueueClass:", annotationMirror);
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
        ProtoQueueClassData protoQueueClassData = new ProtoQueueClassData(classElement/*, portInterfaceMethodList*/);
//
//        portInterfaceMethodList.forEach(portInterfaceMethod -> {
//            try {
//                new PortInterfaceWriter(portInterfaceMethod.portInterfaceData).write(compileContext.processingEnvironment);
//            } catch (IOException e) {
//                compileContext.log.error("PortInterfaceWriter error", e.getMessage());
//            }
//
//        });
        return protoQueueClassData;
    }
}
