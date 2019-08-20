package net.protoqueue.rpc.gen.struct

import com.squareup.kotlinpoet.ClassName

/**
 *
 * 一个RPC服务类的结构
 *
 * @author linmin1 on 2019-08-14.
 *
 */
data class ServiceStruct(/*服务名*/var serviceName: String = "",
    /*服务包名*/var servicePackage: String = ""
) {
    /*多个rpc接口*/var funList: List<FunctionStruct> = emptyList()
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