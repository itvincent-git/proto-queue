package net.protoqueue.rpc.desc

import com.google.protobuf.DescriptorProtos
import com.google.protobuf.ExtensionRegistry
import com.woohoo.app.common.protocol.OldserviceOptions
import net.protoqueue.rpc.desc.DescUtil.getClassNameFromFdpName
import net.protoqueue.rpc.gen.struct.FunctionStruct
import net.protoqueue.rpc.gen.struct.ServiceStruct
import net.protoqueue.rpc.gen.struct.XhAppId
import java.io.File

/**
 *
 *
 *
 * @author linmin1 on 2019-08-14.
 *
 */
class DescFileServiceReader(private val descFilePath: String) {
    private val typeMap = mutableMapOf<String, String>()

    private val serviceList = mutableListOf<ServiceStruct>()
    private var curService: ServiceStruct? = null

    fun readFile(): DescFileServiceReader {
        val fileDescriptorSet = File(descFilePath).inputStream().use {
            val extensionRegistry = ExtensionRegistry.newInstance()
            OldserviceOptions.registerAllExtensions(extensionRegistry)
            DescriptorProtos.FileDescriptorSet.parseFrom(it, extensionRegistry)
        }
        readMessageTypeMap(fileDescriptorSet)
        fileDescriptorSet.fileList.forEach { fdp ->
            serviceList.addAll(readProto(fdp))
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
            val packageName = fdp.readPackageName()
            fdp.messageTypeList.forEach {
                val protoType = "." + fdp.`package` + "." + it.name
                val className = packageName + "." + outClassName + "." + it.name
                typeMap[protoType] = className
            }
        }
    }

    private fun readProto(fdp: DescriptorProtos.FileDescriptorProto): List<ServiceStruct> {
        val packageName = fdp.readPackageName()
        return fdp.serviceList?.map { service ->
            val rst = ServiceStruct().apply {
                this.servicePackage = packageName
                this.serviceName = service.name
                this.funList = service.methodList?.map { it.convert() } ?: emptyList()
            }
            if (service.hasOptions() && service.options.hasExtension(OldserviceOptions.xhAppid)) {
                val xhAppId = service.options.getExtension(OldserviceOptions.xhAppid)
                rst.updateXhAppId(XhAppId(xhAppId.product, xhAppId.test))
            }
            rst
        } ?: emptyList()
//        fdp.serviceList?.forEach { service ->
//            val packageName = fdp.readPackageName()
//            curService = ServiceStruct()
//            curService?.servicePackage = packageName
//            curService?.serviceName = service.name
//            readService(service)
//            curService?.let {
//                if (it.serviceName.isNotEmpty()) {
//                    serviceList.add(it)
//                }
//            }
//            curService = null
//        }
    }

    private fun DescriptorProtos.MethodDescriptorProto.convert(): FunctionStruct {
        return FunctionStruct(this.name, typeMap[this.inputType] ?: "", typeMap[this
            .outputType] ?: "")
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

//    private fun readNotify(service: DescriptorProtos.ServiceDescriptorProto) {
//        println("----> ${service.name}")
////        service.methodList?.forEach {
////            println("${it.name} ===>>>> ${typeMap[it.inputType]}")
////        }
//        curService?.notifyList = service.methodList?.map {
//            NotifyStruct(it.name, typeMap[it.inputType] ?: "")
//        } ?: emptyList()
//    }

    private fun ServiceStruct.updateXhAppId(appId: XhAppId?) {
        if (appId != null) {
            paramMap["xh_appid_product"] = appId.product.toString()
            paramMap["xh_appid_product"] = appId.test.toString()
        } else {
            paramMap.remove("xh_appid_product")
            paramMap.remove("xh_appid_product")
        }
    }
}