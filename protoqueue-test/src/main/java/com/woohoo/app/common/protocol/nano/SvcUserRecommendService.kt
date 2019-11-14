// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.google.protobuf.nano.MessageNano
import com.woohoo.app.common.protocol.nano.WhSvcUserRecommend.GetRecommendUserReq
import com.woohoo.app.common.protocol.nano.WhSvcUserRecommend.GetRecommendUserRes
import com.woohoo.app.common.protocol.nano.WhSvcUserRecommend.ReportThirdFriendReq
import com.woohoo.app.common.protocol.nano.WhSvcUserRecommend.ReportThirdFriendRes
import com.woohoo.app.common.protocol.nano.WhSvcUserRecommendKt.GetRecommendUserReqKt
import com.woohoo.app.common.protocol.nano.WhSvcUserRecommendKt.GetRecommendUserResKt
import com.woohoo.app.common.protocol.nano.WhSvcUserRecommendKt.ReportThirdFriendReqKt
import com.woohoo.app.common.protocol.nano.WhSvcUserRecommendKt.ReportThirdFriendResKt
import kotlin.String
import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine
import net.protoqueue.rpc.gen.RPCApi
import net.protoqueue.rpc.gen.RPCNotifyReceiver
import net.protoqueue.rpc.runtime.RPCError
import net.protoqueue.rpc.runtime.RPCHandlerObserver
import net.protoqueue.rpc.runtime.RPCParameter
import net.protoqueue.rpc.runtime.RPCResponse

private const val serviceName: String = "SvcUserRecommendService"

class SvcUserRecommendService {
    object Client {
        suspend fun getRecommendUserList(req: GetRecommendUserReqKt, parameter: RPCParameter? =
                null): RPCResponse<GetRecommendUserResKt> {
            val functionName = "getRecommendUserList"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetRecommendUserRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun reportThirdFriend(req: ReportThirdFriendReqKt, parameter: RPCParameter? = null):
                RPCResponse<ReportThirdFriendResKt> {
            val functionName = "reportThirdFriend"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = ReportThirdFriendRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }
    }

    object Handler {
        fun getRecommendUserList(handler: (GetRecommendUserReqKt, parameter: RPCParameter?) ->
                GetRecommendUserResKt?): RPCHandlerObserver {
            val subscribeFuncName = "getRecommendUserList"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetRecommendUserReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun reportThirdFriend(handler: (ReportThirdFriendReqKt, parameter: RPCParameter?) ->
                ReportThirdFriendResKt?): RPCHandlerObserver {
            val subscribeFuncName = "reportThirdFriend"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = ReportThirdFriendReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }
    }
}
