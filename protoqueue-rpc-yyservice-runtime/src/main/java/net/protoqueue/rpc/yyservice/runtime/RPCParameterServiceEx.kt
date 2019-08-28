package net.protoqueue.rpc.yyservice.runtime

import net.protoqueue.rpc.runtime.RPCParameter

/**
 * yyservice的RPCParameter扩展
 * Created by zhongyongsheng on 2019-08-28.
 */

/**
 * 将回包转成RPCParameter
 */
fun parseFromResponse(
    resCode: Int?,
    resMsg: String?,
    serviceHeader: Map<String, String>?,
    traceId: String?
): RPCParameter {
    val p = RPCParameter()
    p.values["response"] = RPCResponseParameter(resCode, resMsg, serviceHeader, traceId)
    return p
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

data class RPCResponseParameter(
    val resCode: Int?,
    val resMsg: String?,
    val serviceHeader: Map<String, String>?,
    val traceId: String?
)