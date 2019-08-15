package net.jbridge.compiler.writer

import com.squareup.kotlinpoet.TypeSpec
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
        val builder = TypeSpec.classBuilder(serviceStruct.serviceClassName)
//        builder.
//        fieldName = addModuleField(builder)
//        addConstructor(builder)
//        addDispatchMethod(builder)
//        addRouteMethod(builder)
        return builder
    }
//
//    // private Module _module;
//    private fun addModuleField(builder: TypeSpec.Builder): String {
//        val tmpVar = TmpVar()
//        val name = data.typeName.simpleName().decapitalize()
//        val fieldName = tmpVar.getTmpVar("_$name")
//
//        val field = FieldSpec.builder(data.typeName, fieldName, Modifier.PRIVATE)
//                .initializer("new \$T()", data.typeName)
//                .build()
//        builder.addField(field)
//        return fieldName
//    }
//
//    //constructor
//    private fun addConstructor(builder: TypeSpec.Builder) {
//        MethodSpec.constructorBuilder()
//                .addModifiers(Modifier.PUBLIC)
//                .apply {
//                    builder.addMethod(this.build())
//                }
//    }
//
//    //fun dispatch()
//    private fun addDispatchMethod(builder: TypeSpec.Builder) {
//        MethodSpec.methodBuilder("dispatch")
//            .addModifiers(Modifier.PUBLIC)
//            .addParameter(ParameterSpec.builder(
//                    createClassName("net.urigo.runtime", "UriGoParameter"), "parameter").build())
//            .addParameter(ParameterSpec.builder(
//                    createClassName("android.content", "Context"), "context").build())
//            .apply {
//                for (parameter in data.parameterList) {
//                    if (!parameter.isContext) createDispatchSetParameterBlock(this, parameter)
//                }
//                createDispatchInvokeModuleBlock(this)
//                builder.addMethod(this.build())
//            }
//    }
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