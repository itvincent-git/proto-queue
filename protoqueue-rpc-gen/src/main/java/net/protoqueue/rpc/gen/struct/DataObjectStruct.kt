package net.protoqueue.rpc.gen.struct

import com.squareup.kotlinpoet.ClassName
import net.protoqueue.rpc.gen.util.GenUtil

/**
 * PB Message的转换类
 * Created by zhongyongsheng on 2019-08-20.
 */
internal const val MESSAGE_SURFIX = "Kt"

/**
 * 一个pb文件的结构
 */
class DataObjectFileStruct(/*放置转换类的文件包名*/val filePackage: String,
    /*放置转换类的文件名*/val fileName: String
) {
    val enums = mutableListOf<EnumStruct>()
    val objects = mutableListOf<DataObjectStruct>()
    val fileClassName: ClassName
        get() {
            return ClassName(filePackage, fileName + MESSAGE_SURFIX)
        }

    override fun toString(): String {
        return "DataObjectFileStruct(filePackage='$filePackage', fileName='$fileName', " +
            "objects=$objects, enums='$enums')"
    }
}

/**
 * 枚举类结构
 */
class EnumStruct(/*数组名*/val enumsName: String) {
    /**
     * 数组原生名以及默认值
     */
    val enumFields = mutableListOf<Pair<String, Int>>()
    val messageTypePackage: String = enumsName.substringBeforeLast(".")
    val messageTypeSimpleName: String = enumsName.substringAfterLast(".")
    val genMessageTypeSimpleName: String = messageTypeSimpleName + MESSAGE_SURFIX
    val genMessageTypeClassName =
        ClassName(messageTypePackage + MESSAGE_SURFIX, messageTypeSimpleName + MESSAGE_SURFIX)

    override fun toString(): String {
        return "EnumStruct [enumsName :$enumsName, enumFields $enumFields]"
    }
}

/**
 * message类的结构
 */
class DataObjectStruct(val messageType: String) {
    val fields = mutableListOf<DataFieldStruct>()
    val messageTypePackage: String = messageType.substringBeforeLast(".")
    val messageTypeSimpleName: String = messageType.substringAfterLast(".")
    val genMessageTypeSimpleName: String = messageTypeSimpleName + MESSAGE_SURFIX
    val genMessageTypeClassName =
        ClassName(messageTypePackage + MESSAGE_SURFIX, messageTypeSimpleName + MESSAGE_SURFIX)
    val originMessageTypeClassName = ClassName(messageTypePackage, messageTypeSimpleName)

    override fun toString(): String {
        return "DataObjectStruct(messageType='$messageType', fields=$fields)"
    }
}

/**
 * 字段类型
 */
data class DataFieldStruct(private val originFieldName: String, val fieldType: DataFieldType) {
    val fieldName = GenUtil.underlineToHump(originFieldName)
}

/**
 * 字段数据类型结构
 * @param fieldType 字段的数据类型
 * @param nullable 是否可为空
 * @param isOriginalType 是否基本类型
 * @param hasOneOfIndex 是否使用了oneof {} 来描述的字段
 */
open class DataFieldType protected constructor(
    val fieldType: String, val nullable: Boolean, val isOriginalType: Boolean, val hasOneOfIndex: Boolean
) {
    val fieldTypePackage: String = fieldType.substringBeforeLast(".")
    val fieldTypeSimpleName: String = fieldType.substringAfterLast(".")
    val genFieldTypeClassName =
        ClassName(if (!isOriginalType) fieldTypePackage + MESSAGE_SURFIX else fieldTypePackage,
            fieldTypeSimpleName + if (!isOriginalType) MESSAGE_SURFIX else "").copy(
            nullable = nullable)
    val originFieldTypeClassName =
        ClassName(fieldTypePackage, fieldTypeSimpleName).copy(nullable = nullable)

    override fun toString(): String {
        return "DataFieldType(fieldType='$fieldType', nullable=$nullable, isOriginalType=$isOriginalType, " +
            "hasOneOfIndex=$hasOneOfIndex)"
    }

    companion object {

        /**
         * @param isOriginalType 是否系统支持的类型，例如Int, String, List
         */
        fun get(fieldType: String, nullable: Boolean, isOriginalType: Boolean, isOneOfIndex: Boolean): DataFieldType {
            return DataFieldType(fieldType, nullable, isOriginalType, isOneOfIndex)
        }
    }
}

/**
 * 带泛型的字段数据类型结构
 */
class DataFieldParameterType private constructor(
    fieldType: String, nullable: Boolean, isOriginalType: Boolean, isOneOfIndex: Boolean
) :
    DataFieldType(fieldType, nullable, isOriginalType, isOneOfIndex) {
    val parameterTypes = mutableListOf<DataFieldType>()

    fun addParameterTypes(vararg types: DataFieldType) = apply {
        types.forEach { parameterTypes.add(it) }
    }

    override fun toString(): String {
        return "DataFieldParameterType(parameterTypes=$parameterTypes) ${super.toString()}"
    }

    companion object {

        fun get(
            fieldType: String, nullable: Boolean, isOriginalType: Boolean, isOneOfIndex: Boolean,
            vararg types: DataFieldType
        ):
            DataFieldParameterType {
            return DataFieldParameterType(fieldType, nullable, isOriginalType, isOneOfIndex).addParameterTypes(
                *types)
        }
    }
}
