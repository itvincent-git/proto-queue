package net.jbridge.compiler.writer

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
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
                createDataObjects(this)
            }
            .build()
            .writeTo(outputDir)
    }

    private fun createDataObjects(builder: FileSpec.Builder) {
        for (dataObjectStruct in dataObjectFileStruct.objects) {
            TypeSpec.classBuilder(dataObjectStruct.messageTypeSimpleName)
                .addModifiers(KModifier.DATA)
                .apply {
                    createDataObjectFields(this, dataObjectStruct)
                    builder.addType(build())
                }
        }
    }

    private fun createDataObjectFields(builder: TypeSpec.Builder, dataObjectStruct: DataObjectStruct) {
        for (fieldStruct in dataObjectStruct.fields) {
            PropertySpec.builder(fieldStruct.fieldName, fieldStruct.fieldType.fieldTypeClassName)
                .mutable()
                .apply {
                    builder.addProperty(build())
                }
        }
    }

    companion object {
        val suspendCancellableCoroutine = MemberName("kotlinx.coroutines", "suspendCancellableCoroutine")
    }
}
