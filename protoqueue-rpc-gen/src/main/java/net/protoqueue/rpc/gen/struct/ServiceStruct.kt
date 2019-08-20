package net.protoqueue.rpc.gen.struct

import com.squareup.kotlinpoet.ClassName

/**
 *
 * 生成RPC服务的结构
 *
 * @author linmin1 on 2019-08-14.
 *
 */
data class ServiceStruct(var serviceName: String = "", var servicePackage: String = "") {
    var funList: List<FunctionStruct> = emptyList()
    val serviceClassName: ClassName
        get() {
            return ClassName(servicePackage, serviceName)
        }

    init {
    }

    override fun toString(): String {
        return "ServiceStruct(serviceName='$serviceName', servicePackage='$servicePackage', funList=$funList)"
    }
}