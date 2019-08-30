package net.protoqueue.rpc.yyservice.runtime

import net.protoqueue.rpc.runtime.RPCParameter

/**
 * yyservice的RPCParameter扩展
 * Created by zhongyongsheng on 2019-08-28.
 */

/**
 * 将回包转成RPCParameter
 */
fun RPCParameter.parseFromResponse(
    resCode: Int? = null,
    resMsg: String? = null,
    serviceHeader: Map<String, String>? = null,
    traceId: String? = null
): RPCParameter {
    return RPCParameter().apply { values["response"] = RPCResponseParameter(resCode, resMsg, serviceHeader, traceId) }
}

/**
 * 将广播包转成RPCParameter
 */
fun RPCParameter.parseNotify(
    isBroadcast: Boolean?,
    groupType: Long?,
    groupId: Long?
): RPCParameter {
    return RPCParameter().apply { values["notify"] = RPCNotifyParameter(isBroadcast, groupType, groupId) }
}

inline fun RPCParameter.getResCode(): Int? {
    return (values["response"] as? RPCResponseParameter)?.resCode
}

inline fun RPCParameter.getResMsg(): String? {
    return (values["response"] as? RPCResponseParameter)?.resMsg
}

inline fun RPCParameter.getServiceHeaders(): Map<String, String>? {
    return (values["response"] as? RPCResponseParameter)?.serviceHeader
}

inline fun RPCParameter.getTraceId(): String? {
    return (values["response"] as? RPCResponseParameter)?.traceId
}

inline fun RPCParameter.getIsBroadcast(): Boolean? {
    return (values["notify"] as? RPCNotifyParameter)?.isBroadcast
}

inline fun RPCParameter.getGroupType(): Long? {
    return (values["notify"] as? RPCNotifyParameter)?.groupType
}

inline fun RPCParameter.getGroupId(): Long? {
    return (values["notify"] as? RPCNotifyParameter)?.groupId
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