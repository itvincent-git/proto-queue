package net.protoqueue.rpc.desc

import com.google.protobuf.DescriptorProtos
import net.protoqueue.rpc.gen.FunctionStruct
import net.protoqueue.rpc.gen.NotifyStruct
import net.protoqueue.rpc.gen.ServiceStruct
import java.io.File
import java.lang.StringBuilder

/**
 *
 *
 *
 * @author linmin1 on 2019-08-14.
 *
 */
class DescFileReader(private val descFilePath: String) {
    private val typeMap = mutableMapOf<String, String>()

    private val serviceList = mutableListOf<ServiceStruct>()
    private var curService: ServiceStruct? = null

    fun readFile(): DescFileReader {
        val fileDescriptorSet = File(descFilePath).inputStream().use {
            DescriptorProtos.FileDescriptorSet.parseFrom(it)
        }
        readMessageTypeMap(fileDescriptorSet)
        fileDescriptorSet.fileList.forEach { fdp ->
            readProto(fdp)
        }
//        println(serviceList)
        return this
    }

    fun getServiceList() = serviceList

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
            val packageName = if (fdp.options.hasJavaPackage()) {
                fdp.options.javaPackage
            } else {
                fdp.`package`
            }
            fdp.messageTypeList.forEach {
                val protoType = "." + fdp.`package` + "." + it.name
                val className = packageName + "." + outClassName + "$" + it.name
                typeMap[protoType] = className
            }
        }
    }

    private fun readProto(fdp: DescriptorProtos.FileDescriptorProto) {
        fdp.serviceList?.forEach { service ->
            val name = service.name
            curService = ServiceStruct()
            if (name.endsWith("Service") && !name.endsWith("NotifyService")) {
                curService?.serviceName = service.name
                readService(service)
            } else if (name.endsWith("NotifyService")) {
                readNotify(service)
            }
            curService?.let {
                serviceList.add(it)
            }
            curService = null
        }
    }

    private fun readService(service: DescriptorProtos.ServiceDescriptorProto) {
        println("---- ${service.name}")
        curService?.funList = service.methodList?.map {
            FunctionStruct(it.name, typeMap[it.inputType] ?: "", typeMap[it
                .outputType] ?: "")
        } ?: emptyList()
//        service.methodList?.forEach {
//            println("${it.name} ===>>>> ${typeMap[it.inputType]} -> ${typeMap[it.outputType]}")
//        }
    }

    private fun readNotify(service: DescriptorProtos.ServiceDescriptorProto) {
        println("----> ${service.name}")
//        service.methodList?.forEach {
//            println("${it.name} ===>>>> ${typeMap[it.inputType]}")
//        }
        curService?.notifyList = service.methodList?.map {
            NotifyStruct(it.name, typeMap[it.inputType] ?: "")
        } ?: emptyList()
    }

    /**
     * 获取默认类名
     */
    private fun getClassNameFromFdpName(fdpName: String): String {
        val name = fdpName.replace(".proto", "")
        val result = StringBuilder()
        val a = name.split("_".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        for (s in a) {
            if (!name.contains("_")) {
                result.append(s)
                continue
            }
            result.append(s.substring(0, 1).toUpperCase())
            result.append(s.substring(1).toLowerCase())
        }
        return result.toString()
    }
}