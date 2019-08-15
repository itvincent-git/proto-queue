package net.protoqueue.rpc.gen

import com.squareup.kotlinpoet.ClassName

/**
 *
 *
 *
 * @author linmin1 on 2019-08-14.
 *
 */
data class ServiceStruct(var serviceName: String = "", var servicePackage: String = "") {
    var funList: List<FunctionStruct> = emptyList()
    var notifyList: List<NotifyStruct> = emptyList()
    val serviceClassName: ClassName
        get() {
            return ClassName(servicePackage, serviceName)
            //return ClassName("test", "TestService")
        }

    init {
    }

    override fun toString(): String {
        return "ServiceStruct(serviceName='$serviceName', servicePackage='$servicePackage', funList=$funList, notifyList=$notifyList)"
    }
}