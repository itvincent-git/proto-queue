package net.protoqueue.rpc.gen

/**
 *
 *
 *
 * @author linmin1 on 2019-08-14.
 *
 */
class ServiceStruct {
    var serviceName: String = ""
    var funList: List<FunctionStruct> = emptyList()
    var notifyList: List<NotifyStruct> = emptyList()

    override fun toString(): String {
        return "< serviceName $serviceName \n" +
            "funList $funList \n" +
            "notifyList $notifyList >\n"
    }
}