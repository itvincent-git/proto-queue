package net.jbridge.compiler.writer

import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.buildCodeBlock
import net.protoqueue.rpc.gen.struct.DataFieldParameterType
import net.protoqueue.rpc.gen.struct.DataFieldStruct
import net.protoqueue.rpc.gen.struct.DataFieldType
import net.protoqueue.rpc.gen.struct.DataObjectFileStruct
import net.protoqueue.rpc.gen.struct.DataObjectStruct
import net.protoqueue.rpc.gen.struct.EnumStruct
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
                createMessageConvertToDataObjectExFunction(this)
            }
            .build()
            .writeTo(outputDir)
    }

    //创建DO外部类
    private fun createDataObjectWrapperClass(builder: FileSpec.Builder) {
        TypeSpec.classBuilder(dataObjectFileStruct.fileClassName)
            .apply {
                createDataObjects(this)
                createEnumClasses(this)
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
                    createDataObjectConstructor(this, dataObjectStruct)
                    builder.addType(build())
                }
        }
    }

    //创建DO类字段属性
    private fun createDataObjectFields(builder: TypeSpec.Builder, dataObjectStruct: DataObjectStruct) {
        for (fieldStruct in dataObjectStruct.fields) {
            PropertySpec.builder(fieldStruct.fieldName, getFieldTypeName(fieldStruct.fieldType))
                .mutable()
                .apply {
                    initializer(fieldStruct.fieldName)
                    builder.addProperty(build())
                }
        }
    }

    //创建DO constructor方法
    private fun createDataObjectConstructor(
        builder: TypeSpec.Builder,
        dataObjectStruct: DataObjectStruct
    ) {
        FunSpec.constructorBuilder()
            .apply {
                for (fieldStruct in dataObjectStruct.fields) {
                    val parameterBuilder = ParameterSpec.builder(fieldStruct.fieldName,
                        getFieldTypeName(fieldStruct.fieldType))
                    getConstructorInitializer(fieldStruct.fieldType, parameterBuilder)
                    addParameter(parameterBuilder.build())
                }
                builder.primaryConstructor(build())
            }
    }

    //生成字段初始化值
    private fun getConstructorInitializer(type: DataFieldType, propertyBuilder: ParameterSpec.Builder) =
        when (type.fieldType) {
            "kotlin.collections.MutableList" -> propertyBuilder.defaultValue("%M()", mutableListOf)
            "kotlin.collections.MutableMap" -> propertyBuilder.defaultValue("%M()", mutableMapOf)
            else -> {
                propertyBuilder.defaultValue("null")
            }
        }

    //生成DO类字段类型
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

    //创建DO转Message类方法
    private fun createConvertToMessageFunction(builder: TypeSpec.Builder, dataObjectStruct: DataObjectStruct) {
        FunSpec.builder("convertToMessage")
            .returns(dataObjectStruct.originMessageTypeClassName)
            .apply {
                //val message = UserLoginRes()
                addStatement("val message = %T()", dataObjectStruct.originMessageTypeClassName)
                for (field in dataObjectStruct.fields) {
                    if (field.fieldType.isOriginalType) {
                        addStatement("message.%L = %L%L",
                            field.fieldName,
                            field.fieldName,
                            createFieldStatementCodeBlock(field))
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

    //创建DO转Message类字段赋值语句
    private fun createFieldStatementCodeBlock(field: DataFieldStruct) = buildCodeBlock {
        //message.firstLoginTime = firstLoginTime ?: 0
        when (field.fieldType.fieldType) {
            "kotlin.Int" -> add(" ?: 0")
            "kotlin.Boolean" -> add(" ?: false")
            "kotlin.Double" -> add(" ?: 0.0")
            "kotlin.Float" -> add(" ?: 0.0f")
            "kotlin.Long" -> add(" ?: 0L")
            //message.accountList = accountList.map { it.convertToMessage() }.toTypedArray()
            "kotlin.collections.MutableList" -> createFieldStatementListBlock(field)
            //message.statusMap = statusMap.convertMap({ it.key }, { it.value?.convertToMessage() })
            //TODO 处理内部泛型
            "kotlin.collections.MutableMap" -> createFieldStatementMapBlock(field)
            else -> ""
        }
    }

    //创建message.list 数组类型的转换
    private fun CodeBlock.Builder.createFieldStatementListBlock(
        field: DataFieldStruct
    ) {
        if (field.fieldType is DataFieldParameterType) {
            val firstParameterType = field.fieldType.parameterTypes.firstOrNull()
            if (firstParameterType != null) {
                if (!firstParameterType.isOriginalType) {
                    add(".map { it.convertToMessage() }.toTypedArray()")
                } else {
                    //系统类型时
                    when (firstParameterType.fieldType) {
                        "kotlin.Int" -> add(".toIntArray()")
                        "kotlin.Boolean" -> add(".toBooleanArray()")
                        "kotlin.Double" -> add(".toDoubleArray()")
                        "kotlin.Float" -> add(".toFloatArray()")
                        "kotlin.Long" -> add(".toLongArray()")
                        //TODO 处理更多子类型
                        //"kotlin.collections.MutableList" -> add("")
                        //"kotlin.collections.MutableMap" ->
                        else -> add(".toTypedArray()")
                    }
                }
            } else {
                add(".toTypedArray()")
            }
        } else {
            //没有泛型定义时，使用转array
            add(".toTypedArray()")
        }
    }

    //创建message.map 数组类型的转换
    private fun CodeBlock.Builder.createFieldStatementMapBlock(
        field: DataFieldStruct
    ) {
        //map must has 2 ParameterType
        if (field.fieldType is DataFieldParameterType && field.fieldType.parameterTypes.size == 2) {
            val firstParameterType = field.fieldType.parameterTypes[0]
            val secondParameterType = field.fieldType.parameterTypes[1]
            if (firstParameterType != null) {
                if (!firstParameterType.isOriginalType) {
                    add(".%M({ it.key?.convertToMessage() }, ", convertMap)
                } else {
                    //系统类型时
                    add(".%M({ it.key }, ", convertMap)
                }
            } else {
                add(".%M({ it.key }, ", convertMap)
            }
            if (secondParameterType != null) {
                if (!secondParameterType.isOriginalType) {
                    add("{ it.value?.convertToMessage() })")
                } else {
                    //系统类型时
                    add("{ it.value })")
                }
            } else {
                add("{ it.value })")
            }
        } else {
            //没有泛型定义时，使用转array
            add(".%M({ it.key }, { it.value })", convertMap)
        }
    }

    //创建Message转DO的扩展方法
    private fun createMessageConvertToDataObjectExFunction(builder: FileSpec.Builder) {
        //fun UserFreezeInfo.convertToDataObject(): WhSvcUserDO.UserFreezeInfoDO {
        for (dataObjectStruct in dataObjectFileStruct.objects) {
            FunSpec.builder("convertToDataObject")
                .receiver(dataObjectStruct.originMessageTypeClassName)
                .returns(dataObjectStruct.genMessageTypeClassName)
                .apply {
                    //    val o = WhSvcUserDO.UserFreezeInfoDO()
                    addStatement("val o = %T()", dataObjectStruct.genMessageTypeClassName)
                    //    o.freezeUnixTimestamp = freezeUnixTimestamp
                    for (field in dataObjectStruct.fields) {
                        if (field.fieldType.isOriginalType) {
                            addStatement("o.%L = %L%L",
                                field.fieldName,
                                field.fieldName,
                                createConvertToDataObjectFieldStatementCodeBlock(field))
                        } else {
                            //message.header = header?.convertToMessage()
                            addStatement("o.%L = %L?.convertToDataObject()", field.fieldName, field.fieldName)
                        }
                    }
                    //    return o
                    addStatement("return o")
                    builder.addFunction(build())
                }
        }
    }

    //创建Message转DO的字段赋值语句
    private fun createConvertToDataObjectFieldStatementCodeBlock(field: DataFieldStruct) = buildCodeBlock {
        //message.firstLoginTime = firstLoginTime ?: 0
        when (field.fieldType.fieldType) {
            //o.status = status.mapTo(ArrayList(status.size)) { it.convertToDataObject() }
            "kotlin.collections.MutableList" -> {
                if (field.fieldType is DataFieldParameterType) {
                    val firstParameterType = field.fieldType.parameterTypes.firstOrNull()
                    if (firstParameterType != null) {
                        if (!firstParameterType.isOriginalType) {
                            add(".mapTo(ArrayList(%L.size)) { it.%M() }",
                                field.fieldName,
                                MemberName(
                                    firstParameterType
                                        .fieldTypePackage
                                        .substringBeforeLast("."), "convertToDataObject"))
                        } else {
                            //系统类型时
                            when (firstParameterType.fieldType) {
                                //TODO 处理更多子类型
                                //"kotlin.collections.MutableList" -> add("")
                                //"kotlin.collections.MutableMap" ->
                                else -> add(".toMutableList()")
                            }
                        }
                    } else {
                        add(".toMutableList()")
                    }
                } else {
                    //没有泛型定义时，使用转array
                    add(".toMutableList()")
                }
            }
            //message.statusMap = statusMap.convertMap({ it.key }, { it.value?.convertToMessage() })
            //TODO 处理内部泛型
            "kotlin.collections.MutableMap" -> add(".%M({ it.key }, { it.value?.convertToDataObject() })", convertMap)
            else -> ""
        }
    }

    //创建enum类
    private fun createEnumClasses(builder: TypeSpec.Builder) {
        for (enumStruct in dataObjectFileStruct.enums) {
            TypeSpec.interfaceBuilder(enumStruct.genMessageTypeSimpleName)
                .addType(TypeSpec.companionObjectBuilder().apply {
                    createEnumFields(this, enumStruct)
                }.build())
                .apply {
                    builder.addType(build())
                }
        }
    }

    //创建enum字段
    private fun createEnumFields(builder: TypeSpec.Builder, enumStruct: EnumStruct) {
        for ((name, value) in enumStruct.enumFields) {
            PropertySpec.builder(name, Int::class)
                .initializer("%L", value)
                .apply {
                    builder.addProperty(build())
                }
        }
    }

    companion object {
        val mutableListOf = MemberName("kotlin.collections", "mutableListOf")
        val mutableMapOf = MemberName("kotlin.collections", "mutableMapOf")
        val convertMap = MemberName("net.protoqueue.rpc.runtime.util", "convertMap")
    }
}
