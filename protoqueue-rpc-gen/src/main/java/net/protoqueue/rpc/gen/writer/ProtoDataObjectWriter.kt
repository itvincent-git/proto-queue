package net.jbridge.compiler.writer

import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import net.protoqueue.rpc.gen.struct.DataFieldParameterType
import net.protoqueue.rpc.gen.struct.DataFieldType
import net.protoqueue.rpc.gen.struct.DataObjectFileStruct
import net.protoqueue.rpc.gen.struct.DataObjectStruct
import java.io.File
import java.io.IOException

/**
 * 生成RPC DataObject类
 * Created by zhongyongsheng on 2018/4/14.
 */
class ProtoDataObjectWriter(private val dataObjectFileStruct: DataObjectFileStruct, val outputDir: File) {

    @Throws(IOException::class)
    fun write() {
        FileSpec.builder(dataObjectFileStruct.fileClassName.packageName, dataObjectFileStruct.fileClassName.simpleName)
            .addComment("Generate by protoqueue-rpc, don't edit this file please")
            .indent("    ")
            .apply {
                createDataObjectWrapperClass(this)
            }
            .build()
            .writeTo(outputDir)
    }

    private fun createDataObjectWrapperClass(builder: FileSpec.Builder) {
        TypeSpec.classBuilder(dataObjectFileStruct.fileClassName)
            .apply {
                createDataObjects(this)
                builder.addType(build())
            }
    }

    private fun createDataObjects(builder: TypeSpec.Builder) {
        for (dataObjectStruct in dataObjectFileStruct.objects) {
            TypeSpec.classBuilder(dataObjectStruct.genMessageTypeSimpleName)
                .apply {
                    createDataObjectFields(this, dataObjectStruct)
                    createConvertToMessageFunction(this, dataObjectStruct)
                    builder.addType(build())
                }
        }
    }

    private fun createDataObjectFields(builder: TypeSpec.Builder, dataObjectStruct: DataObjectStruct) {
        for (fieldStruct in dataObjectStruct.fields) {
            PropertySpec.builder(fieldStruct.fieldName, getFieldTypeName(fieldStruct.fieldType))
                .mutable()
                .initializer("null")
                .apply {
                    builder.addProperty(build())
                }
        }
    }

    fun getFieldTypeName(type: DataFieldType): TypeName = when (type) {
        is DataFieldParameterType -> {
            val parameterTypes = type.parameterTypes.map {
                it.genFieldTypeClassName
            }
            type.genFieldTypeClassName.parameterizedBy(*parameterTypes.toTypedArray())
        }
        else -> {
            type.genFieldTypeClassName
        }
    }

    private fun createConvertToMessageFunction(builder: TypeSpec.Builder, dataObjectStruct: DataObjectStruct) {
        FunSpec.builder("convertToMessage")
            .returns(dataObjectStruct.originMessageTypeClassName)
            .apply {

                builder.addFunction(build())
            }
    }

    companion object {
        val suspendCancellableCoroutine = MemberName("kotlinx.coroutines", "suspendCancellableCoroutine")
    }
}
