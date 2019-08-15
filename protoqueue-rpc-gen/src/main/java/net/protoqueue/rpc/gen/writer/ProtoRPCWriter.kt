package net.jbridge.compiler.writer

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.buildCodeBlock
import net.protoqueue.rpc.gen.FunctionStruct
import net.protoqueue.rpc.gen.ServiceStruct
import java.io.File

/**
 * 生成XXXProtoRPC
 * Created by zhongyongsheng on 2018/4/14.
 */
class ProtoRPCWriter(val serviceStruct: ServiceStruct, outputDir: File) : BaseWriter(serviceStruct, outputDir
) {
    var fieldName: String? = null

    override fun createTypeSpecBuilder(): TypeSpec.Builder {
        val builder = TypeSpec.objectBuilder(serviceStruct.serviceClassName)
        addServiceNameField(builder)
        addRequestFun(builder)
//        addRouteMethod(builder)
        return builder
    }

    //
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
                    addInnerCode(it, func)
                    builder.addFunction(it.build())
                }
//                .addModifiers(Modifier.PUBLIC)
//                .addParameter(ParameterSpec.builder(
//                    createClassName("net.urigo.runtime", "UriGoParameter"), "parameter").build())
//                .addParameter(ParameterSpec.builder(
//                    createClassName("android.content", "Context"), "context").build())
//                .apply {
//                    for (parameter in data.parameterList) {
//                        if (!parameter.isContext) createDispatchSetParameterBlock(this, parameter)
//                    }
//                    createDispatchInvokeModuleBlock(this)
//                    builder.addMethod(this.build())
//                }
        }
    }

    private fun addInnerCode(builder: FunSpec.Builder, func: FunctionStruct) {
        builder.addCode(buildCodeBlock {
            //val functionName = "batchGetUserBasicInfo"
            addStatement("""val functionName = %S""", func.funName)
        })
    }
//
//    //fun dispatcher > java.lang.String msg = parameter.getString("msg");
//    private fun createDispatchSetParameterBlock(builder: MethodSpec.Builder, parameter: UriRouteParameter) {
//        builder.addCode(
//            CodeBlock.builder()
//                    .add("\$L \$L = parameter.\$L(\$S);\n", parameter.typeName, parameter.name, parameter.getMethod, parameter.name)
//            .build())
//    }
//
//    //fun dispatcher > _module.showToast(context, msg, duration);
//    private fun createDispatchInvokeModuleBlock(builder: MethodSpec.Builder) {
//        builder.addCode(
//                CodeBlock.builder()
//                        .add("\$L.\$L(\$L);\n", fieldName, data.methodElement.simpleName,
//                                data.parameterList.joinToString {
//                                    if (it.isContext) return@joinToString "context" else it.name
//                                })
//                        .build())
//    }
//
//    //fun route()
//    private fun addRouteMethod(builder: TypeSpec.Builder) {
//        MethodSpec.methodBuilder("route")
//                .addModifiers(Modifier.PUBLIC)
//                .returns(ClassName.get(String::class.java))
//                .addStatement("return \$S", data.route)
//                .apply {
//                    builder.addMethod(this.build())
//                }
//    }
}
