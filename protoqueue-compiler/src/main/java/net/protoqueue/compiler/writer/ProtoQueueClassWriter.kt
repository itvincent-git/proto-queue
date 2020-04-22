package net.protoqueue.compiler.writer

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterSpec
import com.squareup.javapoet.TypeName
import com.squareup.javapoet.TypeSpec
import net.protoqueue.compiler.data.ProtoQueueClassData
import net.protoqueue.util.TmpVar
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong
import javax.lang.model.element.Modifier

/**
 * 生成ProtoQueue的子类
 * Created by zhongyongsheng on 2018/4/14.
 */
class ProtoQueueClassWriter(internal var protoQueueClassData: ProtoQueueClassData) :
    ProtoQueueBaseWriter(protoQueueClassData.implTypeName) {

    override fun createTypeSpecBuilder(): TypeSpec.Builder {
        val builder = TypeSpec.classBuilder(protoQueueClassData.implTypeName)
        builder.addModifiers(Modifier.PUBLIC)
            .superclass(protoQueueClassData.typeName)
        addBuildProtoMethod(builder)
        addToByteArrayMethod(builder)
        addGetProtoContextMethod(builder)
        addSeqFieldAndMethod(builder)
        addGetReceiveUriMethod(builder)
        return builder
    }

    private fun addBuildProtoMethod(builder: TypeSpec.Builder) {
        builder.addMethod(MethodSpec.overriding(protoQueueClassData.buildProtoMethod)
            .returns(TypeName.get(protoQueueClassData.protoClass))
            .addStatement("return \$T.${protoQueueClassData.buildProtoLiteral}",
                ClassName.get(protoQueueClassData.protoClass),
                protoQueueClassData.buildProtoMethod!!.parameters[0].simpleName)
            .build())
    }

    private fun addToByteArrayMethod(builder: TypeSpec.Builder) {
        builder.addMethod(
            MethodSpec.methodBuilder(protoQueueClassData.toByteArrayMethod!!.simpleName.toString())
                .returns(TypeName.get(protoQueueClassData.toByteArrayMethod!!.returnType))
                .addParameter(ParameterSpec.builder(TypeName.get(protoQueueClassData.protoClass), "proto").build())
                .addStatement("return \$L", protoQueueClassData.toByteArrayLiteral)
                .addModifiers(Modifier.PROTECTED)
                .addAnnotation(Override::class.java)
                .build()
        )
    }

    private fun addGetProtoContextMethod(builder: TypeSpec.Builder) {
        builder.addMethod(
            MethodSpec.methodBuilder(protoQueueClassData.getProtoContextMethod!!.simpleName.toString())
                .returns(TypeName.get(protoQueueClassData.protoContextType))
                .addParameter(ParameterSpec.builder(TypeName.get(protoQueueClassData.protoClass), "proto").build())
                .addStatement("return \$L", "proto." + protoQueueClassData.protoContextLiteral)
                .addModifiers(Modifier.PROTECTED)
                .addAnnotation(Override::class.java)
                .build()
        )
    }

    private fun addSeqFieldAndMethod(builder: TypeSpec.Builder) {
        val tmpVar = TmpVar()
        var seqClass: ClassName?

        when (protoQueueClassData.protoContextType.toString()) {
            "java.lang.Integer" -> seqClass = ClassName.get(AtomicInteger::class.java)
            "java.lang.Long" -> seqClass = ClassName.get(AtomicLong::class.java)
            else -> seqClass = ClassName.get(AtomicInteger::class.java)
        }

        val name = seqClass!!.simpleName().decapitalize()
        val fieldName = tmpVar.getTmpVar("_$name")
        val field = FieldSpec.builder(seqClass,
            fieldName,
            Modifier.PRIVATE)
            .initializer("new \$T()", seqClass)
            .build()
        builder.addField(field)
        addSeqMethod(field, builder)
    }

    private fun addSeqMethod(field: FieldSpec, builder: TypeSpec.Builder) {
        builder.addMethod(
            MethodSpec.methodBuilder(protoQueueClassData.incrementAndGetSeqContextMethod!!.simpleName.toString())
                .returns(TypeName.get(protoQueueClassData.protoContextType))
                .addStatement("return \$N.incrementAndGet()", field)
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override::class.java)
                .build()
        )

        builder.addMethod(
            MethodSpec.methodBuilder(protoQueueClassData.getSeqContextMethod!!.simpleName.toString())
                .returns(TypeName.get(protoQueueClassData.protoContextType))
                .addStatement("return \$N.get()", field)
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(Override::class.java)
                .build()
        )
    }

    private fun addGetReceiveUriMethod(builder: TypeSpec.Builder) {
        builder.addMethod(
            MethodSpec.methodBuilder(protoQueueClassData.getReceiveUriMethod!!.simpleName.toString())
                .returns(TypeName.get(protoQueueClassData.getReceiveUriMethod!!.returnType))
                .addParameter(ParameterSpec.builder(TypeName.get(protoQueueClassData.protoClass), "proto").build())
                .addStatement("return proto.\$L", protoQueueClassData.uriLiteral)
                .addModifiers(Modifier.PROTECTED)
                .addAnnotation(Override::class.java)
                .build()
        )
    }
}
