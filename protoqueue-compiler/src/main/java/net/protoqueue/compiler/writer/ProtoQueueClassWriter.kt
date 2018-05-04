package net.protoqueue.compiler.writer

import com.google.auto.common.MoreTypes
import com.squareup.javapoet.*

import net.protoqueue.compiler.data.ProtoQueueClassData
import net.protoqueue.util.Util

import javax.lang.model.element.Modifier

/**
 * Created by zhongyongsheng on 2018/4/14.
 */
class ProtoQueueClassWriter(internal var protoQueueClassData: ProtoQueueClassData) : ProtoQueueBaseWriter(protoQueueClassData.implTypeName) {

    override fun createTypeSpecBuilder(): TypeSpec.Builder {
        val builder = TypeSpec.classBuilder(protoQueueClassData.implTypeName)
        builder.addModifiers(Modifier.PUBLIC)
                .superclass(protoQueueClassData.typeName)
        addBuildProtoMethod(builder)
        addToByteArrayMethod(builder)
        addGetProtoContextMethod(builder)
        addGetOwnAppIdMethod(builder)
        return builder
    }

    private fun addBuildProtoMethod(builder: TypeSpec.Builder) {
        builder.addMethod(MethodSpec.overriding(protoQueueClassData.buildProtoMethod)
                .returns(TypeName.get(protoQueueClassData.protoClass))
                .addStatement("return \$T.parseFrom(\$L)", ClassName.get(protoQueueClassData.protoClass), protoQueueClassData.buildProtoMethod!!.parameters[0].simpleName)
                .build())
    }

    private fun addToByteArrayMethod(builder: TypeSpec.Builder) {
        builder.addMethod(
                MethodSpec.methodBuilder(protoQueueClassData.toByteArrayMethod!!.simpleName.toString())
                .returns(TypeName.get(protoQueueClassData.toByteArrayMethod!!.returnType))
                .addParameter(ParameterSpec.builder(TypeName.get(protoQueueClassData.protoClass), "proto").build())
                .addStatement("return \$L.toByteArray()", "proto")
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

    private fun addGetOwnAppIdMethod(builder: TypeSpec.Builder) {
        builder.addMethod(MethodSpec.overriding(protoQueueClassData.getOwnAppIdMethod)
                .addStatement("return \$L", protoQueueClassData.appId)
                .build())
    }
}
