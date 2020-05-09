package net.protoqueue.compiler.writer

import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asTypeName
import net.protoqueue.compiler.common.CompilerContext
import net.protoqueue.compiler.data.ProtoQueueClassData

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
                .addModifiers(KModifier.OVERRIDE)
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
                    .addModifiers(KModifier.OVERRIDE)
                    .build()
            )
        }
    }

    private fun addGetProtoContextMethod(builder: TypeSpec.Builder) {
        val typeName = protoQueueClassData.protoContextTypeName
        CompilerContext.log.warn("protoContextType %s", typeName)
        protoQueueClassData.getProtoContextMethod?.let {
            builder.addFunction(
                FunSpec.builder(it.simpleName.toString())
                    .returns(protoQueueClassData.protoContextTypeName)
                    .addParameter(ParameterSpec("proto", protoQueueClassData.protoClassTypeName))
                    .addStatement(protoQueueClassData.protoContextLiteral, "proto")
                    .addModifiers(KModifier.OVERRIDE)
                    .build()
            )
        }
    }

    private fun addSeqFieldAndMethod(builder: TypeSpec.Builder) {
//        val tmpVar = TmpVar()
//        var seqClass: ClassName?
//
//        when (protoQueueClassData.protoContextType.toString()) {
//            "java.lang.Integer" -> seqClass = ClassName.get(AtomicInteger::class.java)
//            "java.lang.Long" -> seqClass = ClassName.get(AtomicLong::class.java)
//            else -> seqClass = ClassName.get(AtomicInteger::class.java)
//        }
//
//        val name = seqClass!!.simpleName().decapitalize()
//        val fieldName = tmpVar.getTmpVar("_$name")
//        val field = FieldSpec.builder(seqClass,
//            fieldName,
//            Modifier.PRIVATE)
//            .initializer("new \$T()", seqClass)
//            .build()
//        builder.addField(field)
//        addSeqMethod(field, builder)
    }

    private fun addSeqMethod(field: PropertySpec, builder: TypeSpec.Builder) {
//        builder.addMethod(
//            MethodSpec.methodBuilder(protoQueueClassData.incrementAndGetSeqContextMethod!!.simpleName.toString())
//                .returns(TypeName.get(protoQueueClassData.protoContextType))
//                .addStatement("return \$N.incrementAndGet()", field)
//                .addModifiers(Modifier.PUBLIC)
//                .addAnnotation(Override::class.java)
//                .build()
//        )
//
//        builder.addMethod(
//            MethodSpec.methodBuilder(protoQueueClassData.getSeqContextMethod!!.simpleName.toString())
//                .returns(TypeName.get(protoQueueClassData.protoContextType))
//                .addStatement("return \$N.get()", field)
//                .addModifiers(Modifier.PUBLIC)
//                .addAnnotation(Override::class.java)
//                .build()
//        )
    }

    private fun addGetReceiveUriMethod(builder: TypeSpec.Builder) {
//        builder.addMethod(
//            MethodSpec.methodBuilder(protoQueueClassData.getReceiveUriMethod!!.simpleName.toString())
//                .returns(TypeName.get(protoQueueClassData.getReceiveUriMethod!!.returnType))
//                .addParameter(ParameterSpec.builder(TypeName.get(protoQueueClassData.protoClass), "proto").build())
//                .addStatement("return proto.\$L", protoQueueClassData.uriLiteral)
//                .addModifiers(Modifier.PROTECTED)
//                .addAnnotation(Override::class.java)
//                .build()
//        )
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
