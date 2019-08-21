package net.protoqueue.rpc.gen.struct

import com.squareup.kotlinpoet.ClassName

/**
 * PB Message的转换类
 * Created by zhongyongsheng on 2019-08-20.
 */
private const val DO_SURFIX = "DO"

class DataObjectFileStruct(/*放置转换类的文件包名*/val filePackage: String,
    /*放置转换类的文件名*/val fileName: String
) {
    val enums = mutableListOf<EnumStruct>()
    val objects = mutableListOf<DataObjectStruct>()
    val fileClassName: ClassName
        get() {
            return ClassName(filePackage, fileName)
        }

    override fun toString(): String {
        return "DataObjectFileStruct(filePackage='$filePackage', fileName='$fileName', objects=$objects)"
    }
}

class EnumStruct(/*数组名*/val enumsName: String) {
    /**
     * 数组原生名以及默认值
     */
    val enumFields = mutableListOf<Pair<String, Int>>()
}

class DataObjectStruct(val messageType: String) {
    val fields = mutableListOf<DataFieldStruct>()
    val messageTypePackage: String = messageType.substringBeforeLast(".")
    val messageTypeSimpleName: String = messageType.substringAfterLast(".") + DO_SURFIX

    override fun toString(): String {
        return "DataObjectStruct(messageType='$messageType', fields=$fields)"
    }
}

data class DataFieldStruct(val fieldName: String, val fieldType: DataFieldType)

open class DataFieldType protected constructor(
    val fieldType: String, val nullable: Boolean, val isOriginalType: Boolean
) {
    val fieldTypeClassName = ClassName
        .bestGuess(fieldType + if (!isOriginalType) DO_SURFIX else "")
        .copy(nullable = nullable)

    override fun toString(): String {
        return "DataFieldType(fieldType='$fieldType', nullable=$nullable, isOriginalType=$isOriginalType, fieldTypeClassName=$fieldTypeClassName)"
    }

    companion object {

        /**
         * @param isOriginalType 是否系统支持的类型，例如Int, String, List
         */
        fun get(fieldType: String, nullable: Boolean, isOriginalType: Boolean): DataFieldType {
            return DataFieldType(fieldType, nullable, isOriginalType)
        }
    }
}

class DataFieldParameterType private constructor(
    fieldType: String, nullable: Boolean, isOriginalType: Boolean
) :
    DataFieldType(fieldType, nullable, isOriginalType) {
    val parameterTypes = mutableListOf<DataFieldType>()

    fun addParameterTypes(vararg types: DataFieldType) = apply {
        types.forEach { parameterTypes.add(it) }
    }

    companion object {

        fun get(fieldType: String, nullable: Boolean, isOriginalType: Boolean, vararg types: DataFieldType):
            DataFieldParameterType {
            return DataFieldParameterType(fieldType, nullable, isOriginalType).addParameterTypes(*types)
        }
    }
}
