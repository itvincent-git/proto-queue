package net.jbridge.compiler.writer

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.buildCodeBlock
import net.protoqueue.rpc.gen.FunctionStruct
import net.protoqueue.rpc.gen.NotifyStruct
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
        val builder = TypeSpec.objectBuilder(serviceStruct.serviceClassName)
        addServiceNameField(builder)
        addRequestFun(builder)
        addNotifyFun(builder)
        return builder
    }

    override fun createFileProperty(): PropertySpec.Builder {
        return PropertySpec.builder("serviceName", String::class, KModifier.PRIVATE)
            .initializer("%S", serviceStruct.serviceName)
    }

    // private const val serviceName = "WhSvcUserService"
    private fun addServiceNameField(builder: TypeSpec.Builder) {
        val property = PropertySpec.builder("serviceName", String::class, KModifier.PRIVATE)
            .initializer("%S", serviceStruct.serviceClassName.simpleName)
            .build()
        builder.addProperty(property)
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
        val messageNanoClassName = ClassName("com.google.protobuf.nano", "MessageNano")
        builder.addCode(buildCodeBlock {
            //val functionName = "batchGetUserBasicInfo"
            addStatement("""val functionName = %S""", func.funName)
            //return suspendCancellableCoroutine { continuation ->
            addStatement("""return %M { continuation -> """, suspendCancellableCoroutine)
            //RPCApi.send(serviceName, functionName, MessageNano.toByteArray(req), { serverName, funcName, data ->
            addStatement(""" %T.send(serviceName, functionName, %T.toByteArray(req), { serverName, funcName, data ->""",
                RPCApi::class, messageNanoClassName)
            //val res = GetUserBasicInfoRes.parseFrom(data)
            addStatement(""" val res = %T.parseFrom(data)""",
                ClassName(func.rspTypePackage, func.rspTypeSimpleName))
            //continuation.resume(res)
            addStatement(""" continuation.resume(res)""")
            //}, { sdkResCode, srvResCode ->
            addStatement(""" }, {sdkResCode, srvResCode ->""")
            //    continuation.resumeWithException(RPCError(sdkResCode, srvResCode))
            addStatement("""  continuation.resumeWithException(%T(sdkResCode, srvResCode))""", RPCError::class)
            //           }
            addStatement(" }")
            //           )
            addStatement(" )")
            //       }
            addStatement("}")
        })
    }

    //service注册接收通知的方法
    private fun addNotifyFun(builder: TypeSpec.Builder) {
//        for (notify in serviceStruct.notifyList) {
//            /**
//             * fun subscribeUserFreezeNotify(notifyCallback: (UserFreezeNotifyInfo) -> Unit) {
//             */
//            FunSpec.builder(notify.notifyFunctionGenName)
//                .addParameter(
//                    ParameterSpec.builder("notifyCallback", LambdaTypeName.get(null,
//                        listOf(getNotifyParameter(notify)),
//                        Unit::class.asTypeName())
//
//                    ).build())
//                .let {
//                    addNotifyInnerCode(it, notify)
//                    builder.addFunction(it.build())
//                }
//        }
    }

    private fun addNotifyInnerCode(builder: FunSpec.Builder, notify: NotifyStruct) {
    }

    private fun getNotifyParameter(notify: NotifyStruct): ParameterSpec {
        return ParameterSpec.builder("", ClassName(notify.notifyPackage, notify.notifySimpleName)).build()
    }
}
