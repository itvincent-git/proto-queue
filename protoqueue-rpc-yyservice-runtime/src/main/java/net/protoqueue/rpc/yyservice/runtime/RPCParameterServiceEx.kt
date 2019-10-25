package net.protoqueue.rpc.yyservice.runtime

import net.protoqueue.rpc.runtime.RPCParameter

/**
 * yyservice的RPCParameter扩展
 * Created by zhongyongsheng on 2019-08-28.
 */

const val SERVICE_RES = "response"
const val SERVICE_NOTIFY = "notify"
const val SERVICE_REQ = "request"
/**
 * 将回包转成RPCParameter
 */
fun parseFromResponse(
    resCode: Int? = null,
    resMsg: String? = null,
    serviceHeader: Map<String, String>? = null,
    traceId: String? = null
): RPCParameter {
    return RPCParameter().apply { values[SERVICE_RES] = RPCResponseParameter(resCode, resMsg, serviceHeader, traceId) }
}

/**
 * 将广播包转成RPCParameter
 */
fun parseNotify(
    isBroadcast: Boolean? = null,
    groupType: Long? = null,
    groupId: Long? = null
): RPCParameter {
    return RPCParameter().apply { values[SERVICE_NOTIFY] = RPCNotifyParameter(isBroadcast, groupType, groupId) }
}

/**
 * 将请求参数转成RPCRequestParameter
 */
fun parseRequest(
    neverBind: Boolean = false,
    needBind: Boolean = true,
    timeOut: Long = 10 * 1000L,
    businessContext: String = "",
    traceId: String? = null,
    retryStrategy: ArrayList<Int>? = null
): RPCParameter {
    return RPCParameter().apply {
        values[SERVICE_REQ] = RPCRequestParameter(neverBind, needBind, timeOut,
            businessContext, traceId, retryStrategy)
    }
}

fun RPCParameter.getResCode(): Int? {
    return (values[SERVICE_RES] as? RPCResponseParameter)?.resCode
}

fun RPCParameter.getResMsg(): String? {
    return (values[SERVICE_RES] as? RPCResponseParameter)?.resMsg
}

fun RPCParameter.getServiceHeaders(): Map<String, String>? {
    return (values[SERVICE_RES] as? RPCResponseParameter)?.serviceHeader
}

fun RPCParameter.getTraceId(): String? {
    return (values[SERVICE_RES] as? RPCResponseParameter)?.traceId
}

fun RPCParameter.getIsBroadcast(): Boolean? {
    return (values[SERVICE_NOTIFY] as? RPCNotifyParameter)?.isBroadcast
}

fun RPCParameter.getGroupType(): Long? {
    return (values[SERVICE_NOTIFY] as? RPCNotifyParameter)?.groupType
}

fun RPCParameter.getGroupId(): Long? {
    return (values[SERVICE_NOTIFY] as? RPCNotifyParameter)?.groupId
}

fun RPCParameter.getNeverBind(): Boolean? {
    return (values[SERVICE_REQ] as? RPCRequestParameter)?.neverBind
}

fun RPCParameter.getNeedBind(): Boolean? {
    return (values[SERVICE_REQ] as? RPCRequestParameter)?.needBind
}

fun RPCParameter.getTimeout(): Long? {
    return (values[SERVICE_REQ] as? RPCRequestParameter)?.timeOut
}

fun RPCParameter.getBusinessContext(): String? {
    return (values[SERVICE_REQ] as? RPCRequestParameter)?.businessContext
}

fun RPCParameter.getRequestTraceId(): String? {
    return (values[SERVICE_REQ] as? RPCRequestParameter)?.traceId
}

fun RPCParameter.getRetryStrategy(): ArrayList<Int>? {
    return (values[SERVICE_REQ] as? RPCRequestParameter)?.retryStrategy
}

data class RPCResponseParameter(
    val resCode: Int?,
    val resMsg: String?,
    val serviceHeader: Map<String, String>?,
    val traceId: String?
)

data class RPCNotifyParameter(
    val isBroadcast: Boolean?,
    val groupType: Long?,
    val groupId: Long?
)

data class RPCRequestParameter(
    val neverBind: Boolean?,
    val needBind: Boolean?,
    val timeOut: Long?,
    val businessContext: String?,
    val traceId: String?,
    val retryStrategy: ArrayList<Int>?
)