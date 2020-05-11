package net.protoqueue.compiler.writer

import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asTypeName
import net.protoqueue.compiler.data.ProtoQueueClassData
import net.protoqueue.util.TmpVar
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong

/**
 * 生成Protoqueue RPC子类
 * Created by zhongyongsheng on 2020/4/23.
 */
class ProtoQueueRPCWriter(internal var protoQueueClassData: ProtoQueueClassData) :
    BaseWriter(protoQueueClassData.implTypeName) {

    override fun createTypeSpecBuilder(): TypeSpec.Builder {
        val builder = TypeSpec.classBuilder(protoQueueClassData.implTypeName)
            .superclass(protoQueueClassData.typeName)
        addBuildProtoMethod(builder)
        addToByteArrayMethod(builder)
        addGetProtoContextMethod(builder)
        addSeqFieldAndMethod(builder)
        addGetReceiveUriMethod(builder)
        return builder
    }

    private fun addBuildProtoMethod(builder: TypeSpec.Builder) {
        protoQueueClassData.buildProtoMethod?.let {
            builder.addFunction(FunSpec.builder(it.simpleName.toString())
                .addModifiers(KModifier.PROTECTED, KModifier.OVERRIDE)
                .addParameter(ParameterSpec("data", ByteArray::class.asTypeName()))
                .returns(protoQueueClassData.protoClassTypeName)
                .addStatement(protoQueueClassData.buildProtoLiteral,
                    protoQueueClassData.protoClassTypeName, "data")
                .build())
        }
    }

    private fun addToByteArrayMethod(builder: TypeSpec.Builder) {
        protoQueueClassData.toByteArrayMethod?.let {
            builder.addFunction(
                FunSpec.builder(it.simpleName.toString())
                    .returns(ByteArray::class)
                    .addParameter(ParameterSpec("proto", protoQueueClassData.protoClassTypeName))
                    .addStatement(protoQueueClassData.toByteArrayLiteral)
                    .addModifiers(KModifier.PROTECTED, KModifier.OVERRIDE)
                    .build()
            )
        }
    }

    private fun addGetProtoContextMethod(builder: TypeSpec.Builder) {
        protoQueueClassData.getProtoContextMethod?.let {
            builder.addFunction(
                FunSpec.builder(it.simpleName.toString())
                    .returns(protoQueueClassData.protoContextKotlinTypeName)
                    .addParameter(ParameterSpec("proto", protoQueueClassData.protoClassTypeName))
                    .addStatement(protoQueueClassData.protoContextLiteral, "proto")
                    .addModifiers(KModifier.PROTECTED, KModifier.OVERRIDE)
                    .build()
            )
        }
    }

    private fun addSeqFieldAndMethod(builder: TypeSpec.Builder) {
        val tmpVar = TmpVar()
        val seqClass = when (protoQueueClassData.protoContextTypeName.toString()) {
            "java.lang.Integer" -> AtomicInteger::class.asTypeName()
            "java.lang.Long" -> AtomicLong::class.asTypeName()
            else -> AtomicInteger::class.asTypeName()
        }

        val name = seqClass.simpleName.decapitalize()
        val fieldName = tmpVar.getTmpVar("_$name")
        val field = PropertySpec.builder(fieldName, seqClass, KModifier.PRIVATE)
            .initializer("%T()", seqClass)
            .build()
        builder.addProperty(field)
        addSeqMethod(field, builder)
    }

    private fun addSeqMethod(field: PropertySpec, builder: TypeSpec.Builder) {
        builder.addFunction(
            FunSpec.builder(protoQueueClassData.incrementAndGetSeqContextMethod!!.simpleName.toString())
                .returns(protoQueueClassData.protoContextKotlinTypeName)
                .addModifiers(KModifier.OVERRIDE)
                .addStatement("return %N.incrementAndGet()", field)
                .build()
        )
    }

    private fun addGetReceiveUriMethod(builder: TypeSpec.Builder) {
        builder.addFunction(
            FunSpec.builder(protoQueueClassData.getReceiveUriMethod!!.simpleName.toString())
                .returns(protoQueueClassData.getReceiveUriMethod!!.returnType.asTypeName())
                .addParameter(ParameterSpec.builder("proto", protoQueueClassData.protoClassTypeName).build())
                .addStatement("return proto.%L", protoQueueClassData.uriLiteral)
                .addModifiers(KModifier.PROTECTED, KModifier.OVERRIDE)
                .build()
        )
    }
//
//    //private val serviceName = "SvcUserService"
//    override fun createFileProperty(): PropertySpec.Builder {
//        return PropertySpec.builder("serviceName", String::class, KModifier.PRIVATE,
//            KModifier.CONST)
//            .initializer("%S", protoQueueClassData.serviceName)
//    }


    companion object {
        val suspendCancellableCoroutine =
            MemberName("kotlinx.coroutines", "suspendCancellableCoroutine")
    }
}
