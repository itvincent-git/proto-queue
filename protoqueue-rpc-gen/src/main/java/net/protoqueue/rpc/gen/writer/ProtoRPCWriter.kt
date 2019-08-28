package net.jbridge.compiler.writer

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.LambdaTypeName
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asClassName
import com.squareup.kotlinpoet.buildCodeBlock
import net.protoqueue.rpc.gen.RPCApi
import net.protoqueue.rpc.gen.struct.FunctionStruct
import net.protoqueue.rpc.gen.struct.ServiceStruct
import net.protoqueue.rpc.runtime.RPCError
import net.protoqueue.rpc.runtime.RPCHandlerObserver
import net.protoqueue.rpc.runtime.RPCResponse
import java.io.File

/**
 * 生成RPC协议类
 * Created by zhongyongsheng on 2018/4/14.
 */
class ProtoRPCWriter(private val serviceStruct: ServiceStruct, outputDir: File) :
    BaseWriter(serviceStruct.serviceClassName, outputDir
    ) {

    override fun createTypeSpecBuilder(): TypeSpec.Builder {
        val builder = TypeSpec.classBuilder(serviceStruct.serviceClassName)
        addClientObject(builder)
        addHandlerObject(builder)
        return builder
    }

    //private val serviceName = "SvcUserService"
    override fun createFileProperty(): PropertySpec.Builder {
        return PropertySpec.builder("serviceName", String::class, KModifier.PRIVATE, KModifier.CONST)
            .initializer("%S", serviceStruct.serviceName)
    }

    //object Client
    private fun addClientObject(classBuilder: TypeSpec.Builder) {
        val clientBuilder = TypeSpec.objectBuilder("Client")
        addRequestFun(clientBuilder)
        classBuilder.addType(clientBuilder.build())
    }

    //service请求应答的方法
    private fun addRequestFun(builder: TypeSpec.Builder) {
        for (func in serviceStruct.funList) {
            /**
             * suspend fun batchGetUserBasicInfo(req: WhSvcUser.GetUserBasicInfoReq): RPCResponse<GetUserBasicInfoRes>
             */
            FunSpec.builder(func.funName)
                .addModifiers(KModifier.SUSPEND)
                .addParameter(
                    ParameterSpec.builder("req", func.genReqTypeClassName).build())
                .returns(RPCResponse::class.asClassName().parameterizedBy(
                    func.genRspTypeClassName))
                .let {
                    addRequestInnerCode(it, func)
                    builder.addFunction(it.build())
                }
        }
    }

    //service请求应答内部实现
    private fun addRequestInnerCode(builder: FunSpec.Builder, func: FunctionStruct) {
        builder.addCode(buildCodeBlock {
            //val functionName = "batchGetUserBasicInfo"
            addStatement("""val functionName = %S""", func.funName)
            //return suspendCancellableCoroutine { continuation ->
            addStatement("""return %M { continuation -> """, suspendCancellableCoroutine)
            //RPCApi.send(serviceName, functionName, MessageNano.toByteArray(req), { serverName, funcName, data ->
            indent()
            addStatement("""%T.send(serviceName, functionName, %T.toByteArray(req.convertToMessage()), { _, _, data 
                |->""".trimMargin(),
                RPCApi::class, messageNanoClassName)
            //val res = GetUserBasicInfoRes.parseFrom(data)
            indent()
            addStatement("""val res = %T.parseFrom(data)""",
                ClassName(func.rspTypePackage, func.rspTypeSimpleName))
            //continuation.resume(RPCResponse(res))
            addStatement("""continuation.%M(%T(res.convertToDataObject()))""", resume, RPCResponse::class)
            //}, { sdkResCode, srvResCode ->
            unindent()
            addStatement("""}, { sdkResCode, srvResCode ->""")
            //    continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
            indent()
            addStatement("""continuation.%M(%T(error = %T(sdkResCode, srvResCode)))""",
                resume,
                RPCResponse::class.asClassName(),
                RPCError::class.asClassName())
            //           }
            unindent()
            addStatement("}")
            //           )
            addStatement(")")
            //       }
            unindent()
            addStatement("}")
        })
    }

    //object Handler
    private fun addHandlerObject(classBuilder: TypeSpec.Builder) {
        val clientBuilder = TypeSpec.objectBuilder("Handler")
        addHandlerFun(clientBuilder)
        classBuilder.addType(clientBuilder.build())
    }

    //service注册接收通知的方法
    private fun addHandlerFun(builder: TypeSpec.Builder) {
        for (func in serviceStruct.funList) {
            /**
             * fun userFreezeNotify(handler: (UserFreezeNotifyInfo) -> Unit): RPCHandlerObserver {
             */
            FunSpec.builder(func.funName)
                .addParameter(
                    ParameterSpec.builder("handler", LambdaTypeName.get(null,
                        listOf(getHandlerParameter(func)),
                        ClassName(func.rspTypePackage, func.rspTypeSimpleName).copy(nullable = true))
                    ).build())
                .returns(RPCHandlerObserver::class)
                .let {
                    addHandlerInnerCode(it, func)
                    builder.addFunction(it.build())
                }
        }
    }

    //service注册接收通知的方法内部
    private fun addHandlerInnerCode(builder: FunSpec.Builder, func: FunctionStruct) {
        builder.addCode(buildCodeBlock {
            //val subscribeFuncName = "userFreezeNotify"
            addStatement("""val subscribeFuncName = %S""", func.funName)
            //val receiver: RPCNotifyReceiver = { _, functionName, data ->
            addStatement("""val receiver: %T = { _, functionName, data ->""",
                ClassName("net.protoqueue.rpc.gen", "RPCNotifyReceiver"))
            //               if (functionName == subscribeFuncName) {
            indent()
            beginControlFlow("""if (functionName == subscribeFuncName)""")
            //                   val notify = UserFreezeNotifyInfo.parseFrom(data)
            addStatement("""val notify = %T.parseFrom(data)""", ClassName(func.reqTypePackage, func.reqTypeSimpleName))
            //                   handler(notify)
            addStatement("""handler(notify)""")
            unindent()
            addStatement("""}""")
            endControlFlow()
            //RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            addStatement("""%T.subscribe(serviceName, subscribeFuncName, receiver)""", RPCApi::class)
            //return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
            addStatement("""return %T(serviceName, subscribeFuncName, receiver)""", RPCHandlerObserver::class)
        })
    }

    private fun getHandlerParameter(func: FunctionStruct): ParameterSpec {
        return ParameterSpec.builder("", ClassName(func.reqTypePackage, func.reqTypeSimpleName)).build()
    }

    companion object {
        val suspendCancellableCoroutine = MemberName("kotlinx.coroutines", "suspendCancellableCoroutine")
        val resumeWithException = MemberName("kotlin.coroutines", "resumeWithException")
        val resume = MemberName("kotlin.coroutines", "resume")
        val messageNanoClassName = ClassName("com.google.protobuf.nano", "MessageNano")
    }
}
