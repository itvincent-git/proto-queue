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

open class DataFieldType(val fieldTypeClass: KClass<*>?, val fieldType: String?)

class DataFieldParameterType(fieldTypeClass: KClass<*>?, fieldType: String?) :
    DataFieldType(fieldTypeClass, fieldType) {
    val parameterTypes = mutableListOf<DataFieldType>()

    fun addParameterTypes(vararg types: DataFieldType) = apply {
        types.forEach { parameterTypes.add(it) }
    }

    companion object {
        fun get(fieldTypeClass: KClass<*>?, fieldType: String?, vararg types: DataFieldType): DataFieldParameterType {
            return DataFieldParameterType(fieldTypeClass, fieldType).addParameterTypes(*types)
        }
    }
}
