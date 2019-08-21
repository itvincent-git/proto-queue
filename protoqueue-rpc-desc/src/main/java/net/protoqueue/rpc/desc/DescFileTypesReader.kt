package net.protoqueue.rpc.desc

import com.google.protobuf.DescriptorProtos
import net.protoqueue.rpc.desc.DescUtil.getClassNameFromFdpName
import net.protoqueue.rpc.gen.struct.DataFieldParameterType
import net.protoqueue.rpc.gen.struct.DataFieldStruct
import net.protoqueue.rpc.gen.struct.DataFieldType
import net.protoqueue.rpc.gen.struct.DataObjectFileStruct
import net.protoqueue.rpc.gen.struct.DataObjectStruct
import net.protoqueue.rpc.gen.struct.EnumStruct
import java.io.File
import java.lang.RuntimeException

/**
 *
 *
 *
 * @author linmin1 on 2019-08-20.
 *
 */
class DescFileTypesReader(private val descFilePath: String) {
    private val typeMap = mutableMapOf<String, String>()

    val dataObjectFileStructs = mutableListOf<DataObjectFileStruct>()

    /**
     * 解析文件
     */
    fun parseFile(): DescFileTypesReader {
        val fileDescriptorSet = File(descFilePath).inputStream().use {
            DescriptorProtos.FileDescriptorSet.parseFrom(it)
        }
        readMessageTypeMap(fileDescriptorSet)
        dataObjectFileStructs.addAll(fileDescriptorSet.fileList.map {
            readFileDescriptor(it)
        })
//        println(typeMap)
        return this
    }

    /**
     * 获取类型对应
     */
    private fun readMessageTypeMap(fileDescriptorSet: DescriptorProtos.FileDescriptorSet) {
        typeMap.clear()
        fileDescriptorSet.fileList?.forEach { fdp ->
            val outClassName = if (fdp.options.hasJavaOuterClassname()) {
                fdp.options.javaOuterClassname
            } else {
                getClassNameFromFdpName(fdp.name)
            }
            val packageName = fdp.readPackageName()
            fdp.messageTypeList.forEach {
                val protoType = "." + fdp.`package` + "." + it.name
                val className = packageName + "." + outClassName + "." + it.name
                typeMap[protoType] = className
            }
        }
    }

    private fun readFileDescriptor(fdp: DescriptorProtos.FileDescriptorProto): DataObjectFileStruct {
        val packageName = fdp.readPackageName()
        val outClassName = fdp.readOutClassName()
        val messageTypes = fdp.messageTypeList.map {
            val nestedMap = it.readNestedType()
            val struct = DataObjectStruct(packageName + "." + outClassName + "." + it.name)
            struct.fields.addAll(it.fieldList.map {
                DataFieldStruct(it.name, convertType(it, nestedMap))
            })
            struct
        }
        val enumTypes = fdp.enumTypeList.map {
            val struct = EnumStruct(packageName + "." + it.name)
            struct.enumFields.addAll(it.valueList.map {
                Pair(it.name, it.number)
            })
            struct
        }
        return DataObjectFileStruct(packageName, outClassName).apply {
            this.objects.addAll(messageTypes)
            this.enums.addAll(enumTypes)
        }
    }

    private fun convertType(
        fdp: DescriptorProtos.FieldDescriptorProto,
        nestedMap: Map<String, DataFieldType>
    ): DataFieldType {
        val nullable = fdp.label != DescriptorProtos.FieldDescriptorProto.Label.LABEL_REQUIRED
        var firstType = when (fdp.type.name) {
            "TYPE_INT32" -> "Int"
            "TYPE_STRING" -> "String"
            "TYPE_BOOL" -> "Boolean"
            "TYPE_DOUBLE" -> "Double"
            "TYPE_INT64" -> "Long"
            "TYPE_UINT64" -> "Long"
            "TYPE_MESSAGE" -> ""
            "TYPE_ENUM" -> "Int"
            else -> throw RuntimeException("${fdp.type.name} now unSupport")
        }
        if (firstType.isEmpty()) {
            //复杂类型
            firstType = typeMap[fdp.typeName] ?: ""
        }
        if (firstType.isNotEmpty()) {
            //数组
            if (fdp.label == DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED) {
                return DataFieldParameterType.get("List", nullable,
                    DataFieldType.get(firstType, false))
            }
            return DataFieldType.get(firstType, nullable)
        }
        //map
        return nestedMap[fdp.typeName.split(".").last()]
            ?: throw RuntimeException("${fdp.typeName} error")
    }

    private fun DescriptorProtos.DescriptorProto.readNestedType(): Map<String, DataFieldParameterType> {
        val map = mutableMapOf<String, DataFieldParameterType>()
        this.nestedTypeList.filter { it.options.mapEntry }.forEach {
            val keyType = convertType(it.fieldList.find { it.name == "key" }!!, emptyMap())
            val valType = convertType(it.fieldList.find { it.name == "value" }!!, emptyMap())
            map[it.name] = DataFieldParameterType.get("Map",
                false, keyType, valType)
        }
        return map
    }
}