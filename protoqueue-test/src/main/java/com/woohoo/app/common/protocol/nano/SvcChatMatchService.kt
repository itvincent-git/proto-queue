// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.google.protobuf.nano.MessageNano
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.AcceptInvitationReq
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.AcceptInvitationRes
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.AcceptMatchReq
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.AcceptMatchRes
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.CancelInvitationReq
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.CancelInvitationRes
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.CancelMatchReq
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.CancelMatchRes
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.GetMatchConfigReq
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.GetMatchConfigRes
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.InviteUserReq
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.InviteUserRes
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.MatchHeartbeatReq
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.MatchHeartbeatRes
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.RejectInvitationReq
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.RejectInvitationRes
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.RejectMatchReq
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.RejectMatchRes
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.StartMatchReq
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.StartMatchRes
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.AcceptInvitationReqKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.AcceptInvitationResKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.AcceptMatchReqKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.AcceptMatchResKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.CancelInvitationReqKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.CancelInvitationResKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.CancelMatchReqKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.CancelMatchResKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.GetMatchConfigReqKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.GetMatchConfigResKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.InviteUserReqKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.InviteUserResKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.MatchHeartbeatReqKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.MatchHeartbeatResKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.RejectInvitationReqKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.RejectInvitationResKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.RejectMatchReqKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.RejectMatchResKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.StartMatchReqKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.StartMatchResKt
import kotlin.String
import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine
import net.protoqueue.rpc.gen.RPCApi
import net.protoqueue.rpc.gen.RPCNotifyReceiver
import net.protoqueue.rpc.runtime.RPCError
import net.protoqueue.rpc.runtime.RPCHandlerObserver
import net.protoqueue.rpc.runtime.RPCParameter
import net.protoqueue.rpc.runtime.RPCResponse

private const val serviceName: String = "SvcChatMatchService"

class SvcChatMatchService {
    object Client {
        suspend fun getMatchConfigs(req: GetMatchConfigReqKt, parameter: RPCParameter? = null):
                RPCResponse<GetMatchConfigResKt> {
            val functionName = "getMatchConfigs"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetMatchConfigRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun startMatch(req: StartMatchReqKt, parameter: RPCParameter? = null):
                RPCResponse<StartMatchResKt> {
            val functionName = "startMatch"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = StartMatchRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun matchHeartbeat(req: MatchHeartbeatReqKt, parameter: RPCParameter? = null):
                RPCResponse<MatchHeartbeatResKt> {
            val functionName = "matchHeartbeat"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = MatchHeartbeatRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun cancelMatch(req: CancelMatchReqKt, parameter: RPCParameter? = null):
                RPCResponse<CancelMatchResKt> {
            val functionName = "cancelMatch"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = CancelMatchRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun acceptMatch(req: AcceptMatchReqKt, parameter: RPCParameter? = null):
                RPCResponse<AcceptMatchResKt> {
            val functionName = "acceptMatch"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = AcceptMatchRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun rejectMatch(req: RejectMatchReqKt, parameter: RPCParameter? = null):
                RPCResponse<RejectMatchResKt> {
            val functionName = "rejectMatch"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = RejectMatchRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun inviteUser(req: InviteUserReqKt, parameter: RPCParameter? = null):
                RPCResponse<InviteUserResKt> {
            val functionName = "inviteUser"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = InviteUserRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun cancelInvitation(req: CancelInvitationReqKt, parameter: RPCParameter? = null):
                RPCResponse<CancelInvitationResKt> {
            val functionName = "cancelInvitation"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = CancelInvitationRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun acceptInvitation(req: AcceptInvitationReqKt, parameter: RPCParameter? = null):
                RPCResponse<AcceptInvitationResKt> {
            val functionName = "acceptInvitation"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = AcceptInvitationRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun rejectInvitation(req: RejectInvitationReqKt, parameter: RPCParameter? = null):
                RPCResponse<RejectInvitationResKt> {
            val functionName = "rejectInvitation"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = RejectInvitationRes.parseFrom(data)
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
        fun getMatchConfigs(handler: (GetMatchConfigReqKt, parameter: RPCParameter?) ->
                GetMatchConfigResKt?): RPCHandlerObserver {
            val subscribeFuncName = "getMatchConfigs"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetMatchConfigReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun startMatch(handler: (StartMatchReqKt, parameter: RPCParameter?) -> StartMatchResKt?):
                RPCHandlerObserver {
            val subscribeFuncName = "startMatch"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = StartMatchReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun matchHeartbeat(handler: (MatchHeartbeatReqKt, parameter: RPCParameter?) ->
                MatchHeartbeatResKt?): RPCHandlerObserver {
            val subscribeFuncName = "matchHeartbeat"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = MatchHeartbeatReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun cancelMatch(handler: (CancelMatchReqKt, parameter: RPCParameter?) -> CancelMatchResKt?):
                RPCHandlerObserver {
            val subscribeFuncName = "cancelMatch"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = CancelMatchReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun acceptMatch(handler: (AcceptMatchReqKt, parameter: RPCParameter?) -> AcceptMatchResKt?):
                RPCHandlerObserver {
            val subscribeFuncName = "acceptMatch"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = AcceptMatchReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun rejectMatch(handler: (RejectMatchReqKt, parameter: RPCParameter?) -> RejectMatchResKt?):
                RPCHandlerObserver {
            val subscribeFuncName = "rejectMatch"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = RejectMatchReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun inviteUser(handler: (InviteUserReqKt, parameter: RPCParameter?) -> InviteUserResKt?):
                RPCHandlerObserver {
            val subscribeFuncName = "inviteUser"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = InviteUserReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun cancelInvitation(handler: (CancelInvitationReqKt, parameter: RPCParameter?) ->
                CancelInvitationResKt?): RPCHandlerObserver {
            val subscribeFuncName = "cancelInvitation"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = CancelInvitationReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun acceptInvitation(handler: (AcceptInvitationReqKt, parameter: RPCParameter?) ->
                AcceptInvitationResKt?): RPCHandlerObserver {
            val subscribeFuncName = "acceptInvitation"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = AcceptInvitationReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun rejectInvitation(handler: (RejectInvitationReqKt, parameter: RPCParameter?) ->
                RejectInvitationResKt?): RPCHandlerObserver {
            val subscribeFuncName = "rejectInvitation"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = RejectInvitationReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }
    }
}
