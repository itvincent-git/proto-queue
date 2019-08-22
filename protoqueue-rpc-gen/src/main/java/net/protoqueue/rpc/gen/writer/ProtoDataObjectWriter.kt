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

    //创建DO外部类
    private fun createDataObjectWrapperClass(builder: FileSpec.Builder) {
        TypeSpec.classBuilder(dataObjectFileStruct.fileClassName)
            .apply {
                createDataObjects(this)
                builder.addType(build())
            }
    }

    //创建多个DO类
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

    //创建字段属性
    private fun createDataObjectFields(builder: TypeSpec.Builder, dataObjectStruct: DataObjectStruct) {
        for (fieldStruct in dataObjectStruct.fields) {
            PropertySpec.builder(fieldStruct.fieldName, getFieldTypeName(fieldStruct.fieldType))
                .mutable()
                .apply {
                    getFieldInitializer(fieldStruct.fieldType, this)
                    builder.addProperty(build())
                }
        }
    }

    //生成字段类型
    private fun getFieldTypeName(type: DataFieldType): TypeName = when (type) {
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

    //生成字段初始化值
    private fun getFieldInitializer(type: DataFieldType, propertyBuilder: PropertySpec.Builder) =
        when (type.fieldType) {
            "kotlin.collections.MutableList" -> {
                propertyBuilder.initializer("%M()", mutableListOf)
            }
            else -> {
                propertyBuilder.initializer("null")
            }
        }

    //创建DO转Message类方法
    private fun createConvertToMessageFunction(builder: TypeSpec.Builder, dataObjectStruct: DataObjectStruct) {
        FunSpec.builder("convertToMessage")
            .returns(dataObjectStruct.originMessageTypeClassName)
            .apply {
                //val message = UserLoginRes()
                addStatement("val message = %T()", dataObjectStruct.originMessageTypeClassName)
                for (field in dataObjectStruct.fields) {
                    if (field.fieldType.isOriginalType) {
                        //message.firstLoginTime = firstLoginTime ?: 0
                        val fieldSetStatement = when (field.fieldType.fieldType) {
                            "kotlin.Int" -> " ?: 0"
                            "kotlin.Boolean" -> " ?: false"
                            "kotlin.Double" -> " ?: 0.0"
                            "kotlin.Float" -> " ?: 0.0f"
                            "kotlin.Long" -> " ?: 0L"
                            //message.accountList = accountList.map { it.convertToMessage() }.toTypedArray()
                            "kotlin.collections.MutableList" -> ".map { it.convertToMessage() }.toTypedArray()"
                            else -> ""
                        }
                        addStatement("message.%L = %L%L", field.fieldName, field.fieldName, fieldSetStatement)
                    } else {
                        //message.header = header?.convertToMessage()
                        addStatement("message.%L = %L?.convertToMessage()", field.fieldName, field.fieldName)
                    }
                }
                //return message
                addStatement("return message")
                builder.addFunction(build())
            }
    }

    companion object {
        val mutableListOf = MemberName("kotlin.collections", "mutableListOf")
    }
}
