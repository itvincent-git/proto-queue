package net.protoqueue.rpc.gen.struct

import kotlin.reflect.KClass

/**
 * PB Message的转换类
 * Created by zhongyongsheng on 2019-08-20.
 */
class DataObjectFileStruct(/*放置转换类的文件包名*/val filePackage: String,
    /*放置转换类的文件名*/val fileName: String
) {
    val objects = mutableListOf<DataObjectStruct>()

    override fun toString(): String {
        return "DataObjectFileStruct(filePackage='$filePackage', fileName='$fileName', objects=$objects)"
    }
}

class DataObjectStruct(val messageType: String) {
    val fields = mutableListOf<DataFieldStruct>()
    override fun toString(): String {
        return "DataObjectStruct(messageType='$messageType', fields=$fields)"
    }
}

class DataFieldStruct(val fieldName: String)

open class DataFieldType protected constructor(
    val fieldTypeClass: KClass<*>?, val fieldType: String?, val nullable: Boolean
) {
    companion object {
        fun get(fieldTypeClass: KClass<*>, nullable: Boolean): DataFieldType {
            return DataFieldType(fieldTypeClass, null, nullable)
        }

        fun get(fieldType: String, nullable: Boolean): DataFieldType {
            return DataFieldType(null, fieldType, nullable)
        }
    }
}

class DataFieldParameterType private constructor(fieldTypeClass: KClass<*>?, fieldType: String?, nullable: Boolean) :
    DataFieldType(fieldTypeClass, fieldType, nullable) {
    val parameterTypes = mutableListOf<DataFieldType>()

    fun addParameterTypes(vararg types: DataFieldType) = apply {
        types.forEach { parameterTypes.add(it) }
    }

    companion object {
        fun get(fieldTypeClass: KClass<*>, nullable: Boolean, vararg types: DataFieldType):
            DataFieldParameterType {
            return DataFieldParameterType(fieldTypeClass, null, nullable).addParameterTypes(*types)
        }

        fun get(fieldType: String, nullable: Boolean, vararg types: DataFieldType):
            DataFieldParameterType {
            return DataFieldParameterType(null, fieldType, nullable).addParameterTypes(*types)
        }
    }
}
