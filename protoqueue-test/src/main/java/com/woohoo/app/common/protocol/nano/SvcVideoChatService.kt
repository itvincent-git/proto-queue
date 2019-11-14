// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.google.protobuf.nano.MessageNano
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.CancelStartPlayReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.CancelStartPlayRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.ClickClapReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.ClickClapRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.DelUserChatHistoryReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.DelUserChatHistoryRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.GetChatInfoReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.GetChatInfoRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.GetEmojiListReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.GetEmojiListRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.GetMaskListReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.GetMaskListRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.GetPlayingInfoReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.GetPlayingInfoRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.GetUserChatHistoryReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.GetUserChatHistoryRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.GetUserChatStatusReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.GetUserChatStatusRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.InviteStartPlayReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.InviteStartPlayRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.InviteTakeOffMaskReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.InviteTakeOffMaskRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.JoinChatReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.JoinChatRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.ReplyStartPlayReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.ReplyStartPlayRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.ReplyTakeOffMaskReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.ReplyTakeOffMaskRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.UseEmojiReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.UseEmojiRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.WearMaskReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.WearMaskRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.CancelStartPlayReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.CancelStartPlayResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.ClickClapReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.ClickClapResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.DelUserChatHistoryReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.DelUserChatHistoryResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.GetChatInfoReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.GetChatInfoResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.GetEmojiListReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.GetEmojiListResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.GetMaskListReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.GetMaskListResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.GetPlayingInfoReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.GetPlayingInfoResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.GetUserChatHistoryReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.GetUserChatHistoryResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.GetUserChatStatusReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.GetUserChatStatusResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.InviteStartPlayReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.InviteStartPlayResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.InviteTakeOffMaskReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.InviteTakeOffMaskResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.JoinChatReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.JoinChatResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.ReplyStartPlayReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.ReplyStartPlayResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.ReplyTakeOffMaskReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.ReplyTakeOffMaskResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.UseEmojiReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.UseEmojiResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.WearMaskReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.WearMaskResKt
import kotlin.String
import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine
import net.protoqueue.rpc.gen.RPCApi
import net.protoqueue.rpc.gen.RPCNotifyReceiver
import net.protoqueue.rpc.runtime.RPCError
import net.protoqueue.rpc.runtime.RPCHandlerObserver
import net.protoqueue.rpc.runtime.RPCParameter
import net.protoqueue.rpc.runtime.RPCResponse

private const val serviceName: String = "SvcVideoChatService"

class SvcVideoChatService {
    object Client {
        suspend fun getMaskList(req: GetMaskListReqKt, parameter: RPCParameter? = null):
                RPCResponse<GetMaskListResKt> {
            val functionName = "getMaskList"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetMaskListRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun wearMask(req: WearMaskReqKt, parameter: RPCParameter? = null):
                RPCResponse<WearMaskResKt> {
            val functionName = "wearMask"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = WearMaskRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun getEmojiList(req: GetEmojiListReqKt, parameter: RPCParameter? = null):
                RPCResponse<GetEmojiListResKt> {
            val functionName = "getEmojiList"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetEmojiListRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun useEmoji(req: UseEmojiReqKt, parameter: RPCParameter? = null):
                RPCResponse<UseEmojiResKt> {
            val functionName = "useEmoji"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = UseEmojiRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun joinChat(req: JoinChatReqKt, parameter: RPCParameter? = null):
                RPCResponse<JoinChatResKt> {
            val functionName = "joinChat"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = JoinChatRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun getUserChatStatus(req: GetUserChatStatusReqKt, parameter: RPCParameter? = null):
                RPCResponse<GetUserChatStatusResKt> {
            val functionName = "getUserChatStatus"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetUserChatStatusRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun getChatInfo(req: GetChatInfoReqKt, parameter: RPCParameter? = null):
                RPCResponse<GetChatInfoResKt> {
            val functionName = "getChatInfo"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetChatInfoRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun inviteTakeOffMask(req: InviteTakeOffMaskReqKt, parameter: RPCParameter? = null):
                RPCResponse<InviteTakeOffMaskResKt> {
            val functionName = "inviteTakeOffMask"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = InviteTakeOffMaskRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun replyTakeOffMask(req: ReplyTakeOffMaskReqKt, parameter: RPCParameter? = null):
                RPCResponse<ReplyTakeOffMaskResKt> {
            val functionName = "replyTakeOffMask"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = ReplyTakeOffMaskRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun clickClap(req: ClickClapReqKt, parameter: RPCParameter? = null):
                RPCResponse<ClickClapResKt> {
            val functionName = "clickClap"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = ClickClapRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun getUserChatHistory(req: GetUserChatHistoryReqKt, parameter: RPCParameter? =
                null): RPCResponse<GetUserChatHistoryResKt> {
            val functionName = "getUserChatHistory"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetUserChatHistoryRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun delUserChatHistory(req: DelUserChatHistoryReqKt, parameter: RPCParameter? =
                null): RPCResponse<DelUserChatHistoryResKt> {
            val functionName = "delUserChatHistory"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = DelUserChatHistoryRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun inviteStartPlay(req: InviteStartPlayReqKt, parameter: RPCParameter? = null):
                RPCResponse<InviteStartPlayResKt> {
            val functionName = "inviteStartPlay"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = InviteStartPlayRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun replyStartPlay(req: ReplyStartPlayReqKt, parameter: RPCParameter? = null):
                RPCResponse<ReplyStartPlayResKt> {
            val functionName = "replyStartPlay"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = ReplyStartPlayRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun cancelStartPlay(req: CancelStartPlayReqKt, parameter: RPCParameter? = null):
                RPCResponse<CancelStartPlayResKt> {
            val functionName = "cancelStartPlay"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = CancelStartPlayRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun getPlayingInfo(req: GetPlayingInfoReqKt, parameter: RPCParameter? = null):
                RPCResponse<GetPlayingInfoResKt> {
            val functionName = "getPlayingInfo"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetPlayingInfoRes.parseFrom(data)
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
        fun getMaskList(handler: (GetMaskListReqKt, parameter: RPCParameter?) -> GetMaskListResKt?):
                RPCHandlerObserver {
            val subscribeFuncName = "getMaskList"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetMaskListReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun wearMask(handler: (WearMaskReqKt, parameter: RPCParameter?) -> WearMaskResKt?):
                RPCHandlerObserver {
            val subscribeFuncName = "wearMask"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = WearMaskReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun getEmojiList(handler: (GetEmojiListReqKt, parameter: RPCParameter?) ->
                GetEmojiListResKt?): RPCHandlerObserver {
            val subscribeFuncName = "getEmojiList"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetEmojiListReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun useEmoji(handler: (UseEmojiReqKt, parameter: RPCParameter?) -> UseEmojiResKt?):
                RPCHandlerObserver {
            val subscribeFuncName = "useEmoji"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = UseEmojiReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun joinChat(handler: (JoinChatReqKt, parameter: RPCParameter?) -> JoinChatResKt?):
                RPCHandlerObserver {
            val subscribeFuncName = "joinChat"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = JoinChatReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun getUserChatStatus(handler: (GetUserChatStatusReqKt, parameter: RPCParameter?) ->
                GetUserChatStatusResKt?): RPCHandlerObserver {
            val subscribeFuncName = "getUserChatStatus"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetUserChatStatusReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun getChatInfo(handler: (GetChatInfoReqKt, parameter: RPCParameter?) -> GetChatInfoResKt?):
                RPCHandlerObserver {
            val subscribeFuncName = "getChatInfo"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetChatInfoReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun inviteTakeOffMask(handler: (InviteTakeOffMaskReqKt, parameter: RPCParameter?) ->
                InviteTakeOffMaskResKt?): RPCHandlerObserver {
            val subscribeFuncName = "inviteTakeOffMask"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = InviteTakeOffMaskReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun replyTakeOffMask(handler: (ReplyTakeOffMaskReqKt, parameter: RPCParameter?) ->
                ReplyTakeOffMaskResKt?): RPCHandlerObserver {
            val subscribeFuncName = "replyTakeOffMask"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = ReplyTakeOffMaskReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun clickClap(handler: (ClickClapReqKt, parameter: RPCParameter?) -> ClickClapResKt?):
                RPCHandlerObserver {
            val subscribeFuncName = "clickClap"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = ClickClapReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun getUserChatHistory(handler: (GetUserChatHistoryReqKt, parameter: RPCParameter?) ->
                GetUserChatHistoryResKt?): RPCHandlerObserver {
            val subscribeFuncName = "getUserChatHistory"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetUserChatHistoryReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun delUserChatHistory(handler: (DelUserChatHistoryReqKt, parameter: RPCParameter?) ->
                DelUserChatHistoryResKt?): RPCHandlerObserver {
            val subscribeFuncName = "delUserChatHistory"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = DelUserChatHistoryReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun inviteStartPlay(handler: (InviteStartPlayReqKt, parameter: RPCParameter?) ->
                InviteStartPlayResKt?): RPCHandlerObserver {
            val subscribeFuncName = "inviteStartPlay"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = InviteStartPlayReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun replyStartPlay(handler: (ReplyStartPlayReqKt, parameter: RPCParameter?) ->
                ReplyStartPlayResKt?): RPCHandlerObserver {
            val subscribeFuncName = "replyStartPlay"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = ReplyStartPlayReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun cancelStartPlay(handler: (CancelStartPlayReqKt, parameter: RPCParameter?) ->
                CancelStartPlayResKt?): RPCHandlerObserver {
            val subscribeFuncName = "cancelStartPlay"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = CancelStartPlayReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun getPlayingInfo(handler: (GetPlayingInfoReqKt, parameter: RPCParameter?) ->
                GetPlayingInfoResKt?): RPCHandlerObserver {
            val subscribeFuncName = "getPlayingInfo"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetPlayingInfoReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }
    }
}
