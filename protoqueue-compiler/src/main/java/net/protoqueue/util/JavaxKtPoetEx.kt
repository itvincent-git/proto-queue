package net.protoqueue.util

import com.google.auto.common.AnnotationMirrors
import com.google.auto.common.MoreElements
import com.google.auto.common.MoreTypes
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asTypeName
import javax.annotation.processing.ProcessingEnvironment
import javax.lang.model.element.AnnotationMirror
import javax.lang.model.element.AnnotationValue
import javax.lang.model.element.Element
import javax.lang.model.element.ExecutableElement
import javax.lang.model.element.TypeElement
import javax.lang.model.element.VariableElement
import javax.lang.model.type.DeclaredType
import javax.lang.model.type.TypeKind
import javax.lang.model.type.TypeMirror
import javax.lang.model.util.SimpleAnnotationValueVisitor6

/**
 * Element, TypeMirror, TypeName等的扩展，使用kotlinpoet方式来实现
 * Created by zhongyongsheng on 2020/6/2.
 */

//======Element========

fun Element.toTypeName(): TypeName {
    return this.asType().asTypeName()
}

/**
 * Element转化为TypeElement，包含类的名称，实现的接口，父类等
 * @param element
 * @return
 */
fun Element.toTypeElement(): TypeElement {
    return MoreElements.asType(this)
}

/**
 * 转化为可执行方法的Element，包含方法的参数、返回值
 * @param element
 * @return
 */
fun Element.asExecutable(): ExecutableElement {
    return MoreElements.asExecutable(this)
}

/**
 * Element转化为DeclaredType，包含类型参数
 * @param element
 * @return
 */
fun Element.asDeclaredType(): DeclaredType {
    return MoreTypes.asDeclared(this.asType())
}

/**
 * AnnotationMirror 包含注解的类型，注解元素的值
 * @param element
 * @param annotationClass
 * @return
 */
fun Element.getAnnotationMirror(annotationClass: Class<out Annotation>): AnnotationMirror {
    return MoreElements.getAnnotationMirror(this, annotationClass).get()
}

/**
 * 返回所有成员变量及方法
 * @param processingEnvironment
 * @param element
 * @return
 */
fun TypeElement.getAllMembers(processingEnvironment: ProcessingEnvironment): List<Element> {
    return processingEnvironment.elementUtils.getAllMembers(this)
}

/**
 * 转为变量element
 */
fun Element.toVariableElement(): VariableElement {
    return MoreElements.asVariable(this)
}

/**
 * VariableElement变量相应的类转化为TypeElement
 * @param element
 * @return
 */
fun VariableElement.toTypeElement(): TypeElement {
    return this.asType().toTypeElement()
}

//======TypeMirror========
/**
 * TypeMirror转化为TypeElement，包含类的名称，实现的接口，父类等
 * @param typeMirror
 * @return
 */
fun TypeMirror.toTypeElement(): TypeElement {
    return MoreTypes.asTypeElement(this)
}


/**
 * TypeMirror转化为DeclaredType，包含类型参数
 */
fun TypeMirror.asDeclaredType(): DeclaredType {
    return MoreTypes.asDeclared(this)
}


/**
 * 根据元素名称返回注解的元素的值
 * @param annotationMirror
 * @param name
 * @return
 */
fun AnnotationMirror.getAnnotationValue(name: String): AnnotationValue {
    return AnnotationMirrors.getAnnotationValue(this, name)
}

private val TO_TYPE = object : SimpleAnnotationValueVisitor6<TypeMirror, Void>() {
    override fun visitType(typeMirror: TypeMirror, aVoid: Void?): TypeMirror {
        return typeMirror
    }

    override fun defaultAction(o: Any, aVoid: Void?): TypeMirror {
        throw TypeNotPresentException(o.toString(), null)
    }
}

/**
 * 将AnnotationValue转成TypeMirror，TypeMirror带有类型信息
 */
fun AnnotationValue.toTypeMirror(): TypeMirror {
    return TO_TYPE.visit(this)
}

/**
 * TypeMirror转成javapoet的TypeName
 */
fun TypeMirror.toTypeName(): TypeName {
    return this.asTypeName()
}

/**
 * 取类型定义的泛型
 */
fun TypeMirror.getTypeParameters(): List<TypeMirror> {
    return asDeclaredType().typeArguments
}

/**
 * 是否原始类型
 */
fun TypeMirror.isPrimitiveType(): Boolean {
    return kind.isPrimitive
}

/*
 * 是否Array类型
 */
fun TypeMirror.isArrayType(): Boolean {
    return kind == TypeKind.ARRAY
}

/**
 * 是否基本类型的封装类
 */
fun TypeMirror.isPrimitiveBoxer(): Boolean {
    val typeName = toTypeElement().qualifiedName
    when {
        typeName.contentEquals("java.lang.Integer") -> return true
        typeName.contentEquals("java.lang.Long") -> return true
        typeName.contentEquals("java.lang.Boolean") -> return true
        typeName.contentEquals("java.lang.Float") -> return true
        typeName.contentEquals("java.lang.Double") -> return true
        typeName.contentEquals("java.lang.Short") -> return true
        typeName.contentEquals("java.lang.Byte") -> return true
    }
    return false
}

/**
 * 是否String类型
 */
fun TypeMirror.isString(): Boolean {
    val typeName = toTypeElement().qualifiedName
    return typeName.contentEquals("java.lang.String")
}

internal fun createClassName(packageName: String, simpleName: String): ClassName {
    return ClassName(packageName, simpleName)
}