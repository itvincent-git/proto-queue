package net.port.transformer.compiler.data;

import com.squareup.javapoet.ClassName;

import java.util.List;
import java.util.stream.Collectors;

import javax.lang.model.element.TypeElement;

/**
 * Created by zhongyongsheng on 2018/4/14.
 */
public class ProtoQueueClassData {
    public ClassName implTypeName;
    public ClassName typeName;
    public List<PortInterfaceMethod> portInterfaceMethodList;

    public ProtoQueueClassData(TypeElement element/*, List<PortInterfaceMethod> portInterfaceMethodList*/) {
        typeName = ClassName.get(element);
        String implClassName = typeName.simpleNames().stream().collect(Collectors.joining("_")) + "_Impl";
        implTypeName = ClassName.get(typeName.packageName(), implClassName);

//        this.portInterfaceMethodList = portInterfaceMethodList;
    }
}
