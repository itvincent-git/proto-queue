package net.protoqueue.compiler.writer

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.INT
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.LambdaTypeName
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asTypeName
import net.protoqueue.compiler.common.CompilerContext
import net.protoqueue.compiler.data.ProtoQueueClassData
import net.protoqueue.compiler.data.ProtoQueueRPCData
import net.protoqueue.rpc.RequestParameter
import net.protoqueue.rpc.Response
import net.protoqueue.rpc.ResponseParameter
import net.protoqueue.util.TmpVar
import net.protoqueue.util.toNullableType
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
        addRPCFunctions(builder)
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
                .returns(protoQueueClassData.protoContextKotlinTypeName.toNullableType())
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

    /**
     * override fun rpcOne(): RPC<DSLRequest, DSLResponse> {
     *   return object : RPC<DSLRequest, DSLResponse> {
     *   }
     * }
     */
    //方法外部的实现
    private fun addRPCFunctions(builder: TypeSpec.Builder) {
        for (rpc in protoQueueClassData.rpcDatas) {
            val rpcClass = rpcInterface
                .parameterizedBy(rpc.requestProtoClassTypeName, rpc.responseProtoClassTypeName)
            val rpcObject = TypeSpec.anonymousClassBuilder().addSuperinterface(rpcClass)
                .apply {
                    addRPCRequestFunction(this, rpc)
                    addRPCRequestCallbackFunction(this, rpc)
                    addRpcResponseFunction(this, rpc)
                }
                .build()
            builder.addFunction(FunSpec.overriding(rpc.executableElement)
                .addStatement("return %L", rpcObject)
                .build())
        }
    }

    //request方法的实现
    /**
     * override suspend fun request(req: DSLRequest, parameter: RequestParameter?): Response<DSLResponse?> {
     *           val proto = DSLProto()
     *           proto.req = req
     *           proto.uri = TestProtos.kUserRequestUri
     *           return catchThrowable {
     *              val resProto = enqueueAwait(proto, DSLCommon.kResponseUri, parameter?.timeout ?: 10000)
     *              val resParameter = ResponseParameter(resProto?.header)
     *              Response(resProto?.res, resParameter)
     *           }
     *       }
     */
    private fun addRPCRequestFunction(builder: TypeSpec.Builder, rpcData: ProtoQueueRPCData) {
        builder.addFunction(
            FunSpec.builder("request")
                .addParameter(ParameterSpec.builder("req", rpcData.requestProtoClassTypeName)
                    .build())
                .returns(Response::class.asTypeName().parameterizedBy(
                    rpcData.responseProtoClassTypeName.toNullableType()))
                .addParameter(
                    ParameterSpec.builder("parameter", RequestParameter::class.asTypeName()
                        .toNullableType()).build())
                .addModifiers(KModifier.OVERRIDE, KModifier.SUSPEND)
                .apply {
                    if (rpcData.requestProtoClassTypeName.toString() == "net.protoqueue.rpc.NoRequest") {
                        addStatement("throw IllegalAccessException(%S)",
                            "Cannot invoke request when use [NoRequest] as request type")
                        return@apply
                    }
                    if (rpcData.requestUri == Int.MIN_VALUE) {
                        CompilerContext.log.error("ProtoQueueRPC.requestUri must set value")
                        return@apply
                    }
                    if (rpcData.requestProperty.isEmpty()) {
                        CompilerContext.log.error("ProtoQueueRPC.requestProperty must set value")
                        return@apply
                    }
                    addStatement("val proto = %T()", protoQueueClassData.protoClassTypeName)
                    addStatement("proto.%L = req", rpcData.requestProperty)
                    addStatement("proto.%L = %L", protoQueueClassData.uriLiteral, rpcData.requestUri)
                    beginControlFlow("return %M {", catchThrowable)
                    addStatement("val resProto = %M(proto, %L, parameter?.timeout ?: %T.DEFAULT_TIMEOUT)",
                        enqueueAwait, rpcData.responseUri, queueParameter)
                    if (protoQueueClassData.resHeaderLiteralHas2Param) {
                        addStatement(
                            "val resParameter = %T(${protoQueueClassData.resHeaderLiteral})",
                            ResponseParameter::class.asTypeName(), "resProto", rpcData.responseProperty)
                    } else {
                        addStatement(
                            "val resParameter = %T(${protoQueueClassData.resHeaderLiteral})",
                            ResponseParameter::class.asTypeName(), "resProto")
                    }
                    addStatement("%T(resProto?.%L, resParameter)", Response::class, rpcData.responseProperty)
                    endControlFlow()
                }
                .build()
        )
    }

    //registerResponse的实现
    /**
     * override fun registerResponse(block: (DSLResponse?, ResponseParameter?) -> Unit) {
     *           mResponseRegister.addRegister(DSLCommon.kResponseUri) {
     *              val responseParameter = ResponseParameter(it.header?.resCode, it.header?.resMsg)
     *              block(it.res, responseParameter)
     *           }
     *       }
     */
    private fun addRpcResponseFunction(builder: TypeSpec.Builder, rpcData: ProtoQueueRPCData) {
        val blockTypeName = LambdaTypeName.get(null,
            listOf(ParameterSpec.builder("", rpcData.responseProtoClassTypeName.toNullableType()).build(),
                ParameterSpec.builder("", ResponseParameter::class.asTypeName()).build()),
            Unit::class.asTypeName())
        builder.addFunction(
            FunSpec.builder("registerResponse")
                .addParameter(ParameterSpec.builder("block", blockTypeName).build())
                .returns(responseRegisterDisposable).apply {
                    beginControlFlow("return mResponseRegister.addRegister(%L) {", rpcData.responseUri)
                    if (protoQueueClassData.resHeaderLiteralHas2Param) {
                        addStatement(
                            "val responseParameter = %T(${protoQueueClassData.resHeaderLiteral})",
                            ResponseParameter::class.asTypeName(), "it", rpcData.responseProperty)
                    } else {
                        addStatement(
                            "val responseParameter = %T(${protoQueueClassData.resHeaderLiteral})",
                            ResponseParameter::class.asTypeName(), "it")
                    }
                    addStatement("block(it.%L, responseParameter)", rpcData.responseProperty)
                    endControlFlow()
                }

                .addModifiers(KModifier.OVERRIDE)
                .build()
        )
    }

    /**
     * override fun requestCallback(
     *  req: TestProtos.PLevelRequest, parameter: RequestParameter?,
     *  callback: (Response<TestProtos.PLevelResponse?>) -> Unit
     *) {
     *  val proto = TestProtos.DslProto()
     *  proto.levelRequest = req
     *  newQueueParameter(proto, 3) {
     *      val resParameter = ResponseParameter(it?.header)
     *      callback(Response(it?.levelResponse, resParameter))
     *  }.error {
     *      callback(Response(null, ResponseParameter(null), it))
     *  }.enqueue()
     * }
     */
    private fun addRPCRequestCallbackFunction(builder: TypeSpec.Builder, rpcData: ProtoQueueRPCData) {
        val callbackTypeName = LambdaTypeName.get(null,
            listOf(ParameterSpec.builder("", Response::class.asTypeName().parameterizedBy(
                rpcData.responseProtoClassTypeName.toNullableType())).build()),
            Unit::class.asTypeName())
        builder.addFunction(
            FunSpec.builder("requestCallback")
                .addParameter(ParameterSpec.builder("req", rpcData.requestProtoClassTypeName)
                    .build())
                .addParameter(
                    ParameterSpec.builder("parameter", RequestParameter::class.asTypeName()
                        .toNullableType()).build())
                .addParameter(ParameterSpec.builder("callback", callbackTypeName).build())
                .addModifiers(KModifier.OVERRIDE)
                .apply {
                    if (rpcData.requestProtoClassTypeName.toString() == "net.protoqueue.rpc.NoRequest") {
                        addStatement("throw IllegalAccessException(%S)",
                            "Cannot invoke request when use [NoRequest] as request type")
                        return@apply
                    }
                    if (rpcData.requestUri == Int.MIN_VALUE) {
                        CompilerContext.log.error("ProtoQueueRPC.requestUri must set value")
                        return@apply
                    }
                    if (rpcData.requestProperty.isEmpty()) {
                        CompilerContext.log.error("ProtoQueueRPC.requestProperty must set value")
                        return@apply
                    }
                    addStatement("val proto = %T()", protoQueueClassData.protoClassTypeName)
                    addStatement("proto.%L = req", rpcData.requestProperty)
                    addStatement("proto.%L = %L", protoQueueClassData.uriLiteral, rpcData.requestUri)
                    beginControlFlow("newQueueParameter(proto, %L) {", rpcData.responseUri)
                    if (protoQueueClassData.resHeaderLiteralHas2Param) {
                        addStatement(
                            "val resParameter = %T(${protoQueueClassData.resHeaderLiteral})",
                            ResponseParameter::class.asTypeName(), "it", rpcData.responseProperty)
                    } else {
                        addStatement(
                            "val resParameter = %T(${protoQueueClassData.resHeaderLiteral})",
                            ResponseParameter::class.asTypeName(), "it")
                    }
                    addStatement("callback(%T(it?.%L, resParameter))", Response::class, rpcData.responseProperty)
                    endControlFlow()
                    beginControlFlow(".error {")
                    addStatement("callback(%T(null, %T(null), it))", Response::class,
                        ResponseParameter::class)
                    endControlFlow()
                    addStatement(".enqueue()")
                }
                .build()
        )
    }

    companion object {
        val enqueueAwait = MemberName("net.protoqueue", "enqueueAwait")
        val catchThrowable = MemberName("net.protoqueue.rpc", "catchThrowable")
        val queueParameter = ClassName("net.protoqueue", "QueueParameter")
        val rpcInterface = ClassName("net.protoqueue.rpc", "RPC")
        val responseRegisterDisposable = ClassName("net.protoqueue.rpc", "ResponseRegisterDisposable")
    }
}
