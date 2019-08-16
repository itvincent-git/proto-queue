package net.jbridge.compiler.writer

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.LambdaTypeName
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.buildCodeBlock
import net.protoqueue.rpc.gen.FunctionStruct
import net.protoqueue.rpc.gen.RPCApi
import net.protoqueue.rpc.gen.RPCError
import net.protoqueue.rpc.gen.ServiceStruct
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
        return PropertySpec.builder("serviceName", String::class, KModifier.PRIVATE)
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
             * suspend fun batchGetUserBasicInfo(req: WhSvcUser.GetUserBasicInfoReq): WhSvcUser.GetUserBasicInfoRes
             */
            FunSpec.builder(func.funName)
                .addModifiers(KModifier.SUSPEND)
                .addParameter(
                    ParameterSpec.builder("req", ClassName(func.reqTypePackage, func.reqTypeSimpleName)).build())
                .returns(ClassName(func.rspTypePackage, func.rspTypeSimpleName))
                .let {
                    addRequestInnerCode(it, func)
                    builder.addFunction(it.build())
                }
        }
    }

    //service请求应答内部实现
    private fun addRequestInnerCode(builder: FunSpec.Builder, func: FunctionStruct) {
        val suspendCancellableCoroutine = MemberName("kotlinx.coroutines", "suspendCancellableCoroutine")
        val resumeWithException = MemberName("kotlin.coroutines", "resumeWithException")
        val resume = MemberName("kotlin.coroutines", "resume")
        val messageNanoClassName = ClassName("com.google.protobuf.nano", "MessageNano")
        builder.addCode(buildCodeBlock {
            //val functionName = "batchGetUserBasicInfo"
            addStatement("""val functionName = %S""", func.funName)
            //return suspendCancellableCoroutine { continuation ->
            addStatement("""return %M { continuation -> """, suspendCancellableCoroutine)
            //RPCApi.send(serviceName, functionName, MessageNano.toByteArray(req), { serverName, funcName, data ->
            addStatement(""" %T.send(serviceName, functionName, %T.toByteArray(req),
                | { serviceName, funcName, data ->""".trimMargin(),
                RPCApi::class, messageNanoClassName)
            //val res = GetUserBasicInfoRes.parseFrom(data)
            addStatement(""" val res = %T.parseFrom(data)""",
                ClassName(func.rspTypePackage, func.rspTypeSimpleName))
            //continuation.resume(res)
            addStatement(""" continuation.%M(res)""", resume)
            //}, { sdkResCode, srvResCode ->
            addStatement(""" }, { sdkResCode, srvResCode ->""")
            //    continuation.resumeWithException(RPCError(sdkResCode, srvResCode))
            addStatement("""  continuation.%M(%T(sdkResCode, srvResCode))""", resumeWithException, RPCError::class)
            //           }
            addStatement(" }")
            //           )
            addStatement(" )")
            //       }
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
             * fun subscribeUserFreezeNotify(handler: (UserFreezeNotifyInfo) -> Unit) {
             */
            FunSpec.builder(func.funName)
                .addParameter(
                    ParameterSpec.builder("handler", LambdaTypeName.get(null,
                        listOf(getHandlerParameter(func)),
                        ClassName(func.rspTypePackage, func.rspTypeSimpleName).copy(nullable = true))
                    ).build())
                .let {
                    addHandlerInnerCode(it, func)
                    builder.addFunction(it.build())
                }
        }
    }

    private fun addHandlerInnerCode(builder: FunSpec.Builder, func: FunctionStruct) {
        builder.addCode(buildCodeBlock {
            //val subscribeFuncName = "userFreezeNotify"
            addStatement("""val subscribeFuncName = %S""", func.funName)
            //RPCApi.subscribe(serviceName, subscribeFuncName) { _, functionName, data ->
            addStatement("""RPCApi.subscribe(serviceName, subscribeFuncName) { _, functionName, data ->""",
                RPCApi::class)
            //               if (functionName == subscribeFuncName) {
            beginControlFlow("""if (functionName == subscribeFuncName)""")
            //                   val notify = UserFreezeNotifyInfo.parseFrom(data)
            addStatement("""val notify = %T.parseFrom(data)""", ClassName(func.reqTypePackage, func.reqTypeSimpleName))
            //                   handler(notify)
            addStatement("""handler(notify)""")
            addStatement("""}""")
            endControlFlow()
        })
    }

    private fun getHandlerParameter(func: FunctionStruct): ParameterSpec {
        return ParameterSpec.builder("", ClassName(func.reqTypePackage, func.reqTypeSimpleName)).build()
    }
}
