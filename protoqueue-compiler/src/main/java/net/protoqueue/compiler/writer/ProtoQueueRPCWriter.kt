package net.protoqueue.compiler.writer

import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.INT
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
        addSetUriMethod(builder)
        return builder
    }

    private fun addBuildProtoMethod(builder: TypeSpec.Builder) {
        //protected override fun buildProto(data: ByteArray): SampleProto = SampleProto.parseFrom(data)
        builder.addFunction(FunSpec.builder("buildProto")
            .addModifiers(KModifier.PROTECTED, KModifier.OVERRIDE)
            .addParameter(ParameterSpec("data", ByteArray::class.asTypeName()))
            .returns(protoQueueClassData.protoClassTypeName)
            .addStatement(protoQueueClassData.buildProtoLiteral,
                protoQueueClassData.protoClassTypeName, "data")
            .build())
    }

    private fun addToByteArrayMethod(builder: TypeSpec.Builder) {
        //protected override fun toByteArray(proto: SampleProto): ByteArray =
        //            com.google.protobuf.nano.MessageNano.toByteArray(proto)
        builder.addFunction(
            FunSpec.builder("toByteArray")
                .returns(ByteArray::class)
                .addParameter(ParameterSpec("proto", protoQueueClassData.protoClassTypeName))
                .addStatement(protoQueueClassData.toByteArrayLiteral)
                .addModifiers(KModifier.PROTECTED, KModifier.OVERRIDE)
                .build()
        )
    }

    private fun addGetProtoContextMethod(builder: TypeSpec.Builder) {
        //protected override fun getProtoContext(proto: SampleProto): Long = proto?.header?.seqid
        builder.addFunction(
            FunSpec.builder("getProtoContext")
                .returns(protoQueueClassData.protoContextKotlinTypeName.copy(nullable = true))
                .addParameter(ParameterSpec("proto", protoQueueClassData.protoClassTypeName))
                .addStatement(protoQueueClassData.protoContextLiteral, "proto")
                .addModifiers(KModifier.PROTECTED, KModifier.OVERRIDE)
                .build()
        )
    }

    private fun addSeqFieldAndMethod(builder: TypeSpec.Builder) {
        //private val _atomicLong: AtomicLong = AtomicLong()
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
        //override fun incrementAndGetSeqContext(): Long = _atomicLong.incrementAndGet()
        builder.addFunction(
            FunSpec.builder("incrementAndGetSeqContext")
                .returns(protoQueueClassData.protoContextKotlinTypeName)
                .addModifiers(KModifier.OVERRIDE)
                .addStatement("return %N.incrementAndGet()", field)
                .build()
        )

        //override fun getSeqContext(): Long = _atomicLong.get()
        builder.addFunction(
            FunSpec.builder("getSeqContext")
                .returns(protoQueueClassData.protoContextKotlinTypeName)
                .addStatement("return %N.get()", field)
                .addModifiers(KModifier.OVERRIDE)
                .build()
        )
    }

    private fun addGetReceiveUriMethod(builder: TypeSpec.Builder) {
        //protected override fun getReceiveUri(proto: SampleProto): Int = proto.uri
        builder.addFunction(
            FunSpec.builder("getReceiveUri")
                .returns(INT)
                .addParameter(ParameterSpec.builder("proto", protoQueueClassData.protoClassTypeName).build())
                .addStatement("return proto.%L", protoQueueClassData.uriLiteral)
                .addModifiers(KModifier.OVERRIDE)
                .build()
        )
    }

    private fun addSetUriMethod(builder: TypeSpec.Builder) {
        //override fun setUri(proto: SampleProto, uri: Int) {
        //  proto.uri = uri
        //}
        builder.addFunction(
            FunSpec.builder("setUri")
                .addParameter(ParameterSpec.builder("proto", protoQueueClassData.protoClassTypeName).build())
                .addParameter(ParameterSpec.builder("uri", INT).build())
                .addStatement("proto.%L = uri", protoQueueClassData.uriLiteral)
                .addModifiers(KModifier.PROTECTED, KModifier.OVERRIDE)
                .build()
        )
    }

    companion object {
        val suspendCancellableCoroutine =
            MemberName("kotlinx.coroutines", "suspendCancellableCoroutine")
    }
}
