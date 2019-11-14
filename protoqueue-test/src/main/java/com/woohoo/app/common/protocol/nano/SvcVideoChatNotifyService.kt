// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.google.protobuf.nano.MessageNano
import com.woohoo.app.common.protocol.nano.WhSvcCommon.Empty
import com.woohoo.app.common.protocol.nano.WhSvcCommonKt.EmptyKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.FinishClapNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.InviteTakeOffMaskNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.PeerCancelStartPlayNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.PeerClickClapNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.PeerInviteStartPlayNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.PeerReplyStartPlayNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.PeerUseEmojiNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.ReadyJoinChatNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.RejectTakeOffMaskNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.TakeOffMaskNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.FinishClapNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.InviteTakeOffMaskNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.PeerCancelStartPlayNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.PeerClickClapNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.PeerInviteStartPlayNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.PeerReplyStartPlayNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.PeerUseEmojiNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.ReadyJoinChatNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.RejectTakeOffMaskNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.TakeOffMaskNotifyInfoKt
import kotlin.String
import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine
import net.protoqueue.rpc.gen.RPCApi
import net.protoqueue.rpc.gen.RPCNotifyReceiver
import net.protoqueue.rpc.runtime.RPCError
import net.protoqueue.rpc.runtime.RPCHandlerObserver
import net.protoqueue.rpc.runtime.RPCParameter
import net.protoqueue.rpc.runtime.RPCResponse

private const val serviceName: String = "SvcVideoChatNotifyService"

class SvcVideoChatNotifyService {
    object Client {
        suspend fun peerUseEmojiNotify(req: PeerUseEmojiNotifyInfoKt, parameter: RPCParameter? =
                null): RPCResponse<EmptyKt> {
            val functionName = "peerUseEmojiNotify"
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

        suspend fun readyJoinChatNotify(req: ReadyJoinChatNotifyInfoKt, parameter: RPCParameter? =
                null): RPCResponse<EmptyKt> {
            val functionName = "readyJoinChatNotify"
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

        suspend fun inviteTakeOffMaskNotify(req: InviteTakeOffMaskNotifyInfoKt,
                parameter: RPCParameter? = null): RPCResponse<EmptyKt> {
            val functionName = "inviteTakeOffMaskNotify"
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

        suspend fun rejectTakeOffMaskNotify(req: RejectTakeOffMaskNotifyInfoKt,
                parameter: RPCParameter? = null): RPCResponse<EmptyKt> {
            val functionName = "rejectTakeOffMaskNotify"
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

        suspend fun takeoffMaskNotify(req: TakeOffMaskNotifyInfoKt, parameter: RPCParameter? =
                null): RPCResponse<EmptyKt> {
            val functionName = "takeoffMaskNotify"
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

        suspend fun peerClickClapNotify(req: PeerClickClapNotifyInfoKt, parameter: RPCParameter? =
                null): RPCResponse<EmptyKt> {
            val functionName = "peerClickClapNotify"
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

        suspend fun finishClapNotify(req: FinishClapNotifyInfoKt, parameter: RPCParameter? = null):
                RPCResponse<EmptyKt> {
            val functionName = "finishClapNotify"
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

        suspend fun peerInviteStartPlayNotify(req: PeerInviteStartPlayNotifyInfoKt,
                parameter: RPCParameter? = null): RPCResponse<EmptyKt> {
            val functionName = "peerInviteStartPlayNotify"
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

        suspend fun peerReplyStartPlayNotify(req: PeerReplyStartPlayNotifyInfoKt,
                parameter: RPCParameter? = null): RPCResponse<EmptyKt> {
            val functionName = "peerReplyStartPlayNotify"
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

        suspend fun peerCancelStartPlayNotify(req: PeerCancelStartPlayNotifyInfoKt,
                parameter: RPCParameter? = null): RPCResponse<EmptyKt> {
            val functionName = "peerCancelStartPlayNotify"
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
        fun peerUseEmojiNotify(handler: (PeerUseEmojiNotifyInfoKt, parameter: RPCParameter?) ->
                EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "peerUseEmojiNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = PeerUseEmojiNotifyInfo.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun readyJoinChatNotify(handler: (ReadyJoinChatNotifyInfoKt, parameter: RPCParameter?) ->
                EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "readyJoinChatNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = ReadyJoinChatNotifyInfo.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun inviteTakeOffMaskNotify(handler: (InviteTakeOffMaskNotifyInfoKt,
                parameter: RPCParameter?) -> EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "inviteTakeOffMaskNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = InviteTakeOffMaskNotifyInfo.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun rejectTakeOffMaskNotify(handler: (RejectTakeOffMaskNotifyInfoKt,
                parameter: RPCParameter?) -> EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "rejectTakeOffMaskNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = RejectTakeOffMaskNotifyInfo.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun takeoffMaskNotify(handler: (TakeOffMaskNotifyInfoKt, parameter: RPCParameter?) ->
                EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "takeoffMaskNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = TakeOffMaskNotifyInfo.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun peerClickClapNotify(handler: (PeerClickClapNotifyInfoKt, parameter: RPCParameter?) ->
                EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "peerClickClapNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = PeerClickClapNotifyInfo.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun finishClapNotify(handler: (FinishClapNotifyInfoKt, parameter: RPCParameter?) ->
                EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "finishClapNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = FinishClapNotifyInfo.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun peerInviteStartPlayNotify(handler: (PeerInviteStartPlayNotifyInfoKt,
                parameter: RPCParameter?) -> EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "peerInviteStartPlayNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = PeerInviteStartPlayNotifyInfo.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun peerReplyStartPlayNotify(handler: (PeerReplyStartPlayNotifyInfoKt,
                parameter: RPCParameter?) -> EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "peerReplyStartPlayNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = PeerReplyStartPlayNotifyInfo.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun peerCancelStartPlayNotify(handler: (PeerCancelStartPlayNotifyInfoKt,
                parameter: RPCParameter?) -> EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "peerCancelStartPlayNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = PeerCancelStartPlayNotifyInfo.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }
    }
}
