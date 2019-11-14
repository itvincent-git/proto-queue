// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.google.protobuf.nano.MessageNano
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.AcceptInvitationNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.CancelInvitationNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.MatchReadyNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.ReInMatchingNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.RejectInvitationNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.AcceptInvitationNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.CancelInvitationNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.MatchReadyNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.ReInMatchingNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.RejectInvitationNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcCommon.Empty
import com.woohoo.app.common.protocol.nano.WhSvcCommonKt.EmptyKt
import kotlin.String
import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine
import net.protoqueue.rpc.gen.RPCApi
import net.protoqueue.rpc.gen.RPCNotifyReceiver
import net.protoqueue.rpc.runtime.RPCError
import net.protoqueue.rpc.runtime.RPCHandlerObserver
import net.protoqueue.rpc.runtime.RPCParameter
import net.protoqueue.rpc.runtime.RPCResponse

private const val serviceName: String = "SvcChatMatchNotifyService"

class SvcChatMatchNotifyService {
    object Client {
        suspend fun matchReadyNotify(req: MatchReadyNotifyInfoKt, parameter: RPCParameter? = null):
                RPCResponse<EmptyKt> {
            val functionName = "matchReadyNotify"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = Empty.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun reInMatchingNotify(req: ReInMatchingNotifyInfoKt, parameter: RPCParameter? =
                null): RPCResponse<EmptyKt> {
            val functionName = "reInMatchingNotify"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = Empty.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun cancelInvitationNotify(req: CancelInvitationNotifyInfoKt,
                parameter: RPCParameter? = null): RPCResponse<EmptyKt> {
            val functionName = "cancelInvitationNotify"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = Empty.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun rejectInvitationNotify(req: RejectInvitationNotifyInfoKt,
                parameter: RPCParameter? = null): RPCResponse<EmptyKt> {
            val functionName = "rejectInvitationNotify"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = Empty.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun acceptInvitationNotify(req: AcceptInvitationNotifyInfoKt,
                parameter: RPCParameter? = null): RPCResponse<EmptyKt> {
            val functionName = "acceptInvitationNotify"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = Empty.parseFrom(data)
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
        fun matchReadyNotify(handler: (MatchReadyNotifyInfoKt, parameter: RPCParameter?) ->
                EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "matchReadyNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = MatchReadyNotifyInfo.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun reInMatchingNotify(handler: (ReInMatchingNotifyInfoKt, parameter: RPCParameter?) ->
                EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "reInMatchingNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = ReInMatchingNotifyInfo.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun cancelInvitationNotify(handler: (CancelInvitationNotifyInfoKt,
                parameter: RPCParameter?) -> EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "cancelInvitationNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = CancelInvitationNotifyInfo.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun rejectInvitationNotify(handler: (RejectInvitationNotifyInfoKt,
                parameter: RPCParameter?) -> EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "rejectInvitationNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = RejectInvitationNotifyInfo.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun acceptInvitationNotify(handler: (AcceptInvitationNotifyInfoKt,
                parameter: RPCParameter?) -> EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "acceptInvitationNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = AcceptInvitationNotifyInfo.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }
    }
}
