// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.google.protobuf.nano.MessageNano
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.AcceptJoinChatInvitationReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.AcceptJoinChatInvitationRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.AgreeJoinChatApplicationReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.AgreeJoinChatApplicationRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.ApplyJoinChatReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.ApplyJoinChatRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.CreateAndJoinRoomReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.CreateAndJoinRoomRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.GetChatManagersReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.GetChatManagersRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.GetChatParticipantsReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.GetChatParticipantsRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.GetChatTopicsReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.GetChatTopicsRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.GetJoinChatApplicationsReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.GetJoinChatApplicationsRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.GetRoomInfoReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.GetRoomInfoRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.GetUserInRoomStatusReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.GetUserInRoomStatusRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.HeartbeatReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.HeartbeatRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.InviteJoinChatReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.InviteJoinChatRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.JoinRoomReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.JoinRoomRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.KickUserReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.KickUserRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.LeaveChatReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.LeaveChatRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.LeaveRoomReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.LeaveRoomRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.RefuseJoinChatInvitationReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.RefuseJoinChatInvitationRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.SwitchChatModeReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.SwitchChatModeRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.AcceptJoinChatInvitationReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.AcceptJoinChatInvitationResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.AgreeJoinChatApplicationReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.AgreeJoinChatApplicationResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.ApplyJoinChatReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.ApplyJoinChatResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.CreateAndJoinRoomReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.CreateAndJoinRoomResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.GetChatManagersReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.GetChatManagersResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.GetChatParticipantsReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.GetChatParticipantsResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.GetChatTopicsReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.GetChatTopicsResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.GetJoinChatApplicationsReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.GetJoinChatApplicationsResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.GetRoomInfoReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.GetRoomInfoResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.GetUserInRoomStatusReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.GetUserInRoomStatusResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.HeartbeatReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.HeartbeatResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.InviteJoinChatReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.InviteJoinChatResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.JoinRoomReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.JoinRoomResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.KickUserReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.KickUserResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.LeaveChatReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.LeaveChatResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.LeaveRoomReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.LeaveRoomResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.RefuseJoinChatInvitationReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.RefuseJoinChatInvitationResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.SwitchChatModeReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.SwitchChatModeResKt
import kotlin.String
import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine
import net.protoqueue.rpc.gen.RPCApi
import net.protoqueue.rpc.gen.RPCNotifyReceiver
import net.protoqueue.rpc.runtime.RPCError
import net.protoqueue.rpc.runtime.RPCHandlerObserver
import net.protoqueue.rpc.runtime.RPCParameter
import net.protoqueue.rpc.runtime.RPCResponse

private const val serviceName: String = "SvcPartyRoomService"

class SvcPartyRoomService {
    object Client {
        suspend fun createAndJoinRoom(req: CreateAndJoinRoomReqKt, parameter: RPCParameter? = null):
                RPCResponse<CreateAndJoinRoomResKt> {
            val functionName = "createAndJoinRoom"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = CreateAndJoinRoomRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun joinRoom(req: JoinRoomReqKt, parameter: RPCParameter? = null):
                RPCResponse<JoinRoomResKt> {
            val functionName = "joinRoom"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = JoinRoomRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun leaveRoom(req: LeaveRoomReqKt, parameter: RPCParameter? = null):
                RPCResponse<LeaveRoomResKt> {
            val functionName = "leaveRoom"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = LeaveRoomRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun heartbeat(req: HeartbeatReqKt, parameter: RPCParameter? = null):
                RPCResponse<HeartbeatResKt> {
            val functionName = "heartbeat"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = HeartbeatRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun getChatTopics(req: GetChatTopicsReqKt, parameter: RPCParameter? = null):
                RPCResponse<GetChatTopicsResKt> {
            val functionName = "getChatTopics"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetChatTopicsRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun getChatManagers(req: GetChatManagersReqKt, parameter: RPCParameter? = null):
                RPCResponse<GetChatManagersResKt> {
            val functionName = "getChatManagers"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetChatManagersRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun getChatParticipants(req: GetChatParticipantsReqKt, parameter: RPCParameter? =
                null): RPCResponse<GetChatParticipantsResKt> {
            val functionName = "getChatParticipants"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetChatParticipantsRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun applyJoinChat(req: ApplyJoinChatReqKt, parameter: RPCParameter? = null):
                RPCResponse<ApplyJoinChatResKt> {
            val functionName = "applyJoinChat"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = ApplyJoinChatRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun agreeJoinChatApplication(req: AgreeJoinChatApplicationReqKt,
                parameter: RPCParameter? = null): RPCResponse<AgreeJoinChatApplicationResKt> {
            val functionName = "agreeJoinChatApplication"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = AgreeJoinChatApplicationRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun getJoinChatApplications(req: GetJoinChatApplicationsReqKt,
                parameter: RPCParameter? = null): RPCResponse<GetJoinChatApplicationsResKt> {
            val functionName = "getJoinChatApplications"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetJoinChatApplicationsRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun inviteJoinChat(req: InviteJoinChatReqKt, parameter: RPCParameter? = null):
                RPCResponse<InviteJoinChatResKt> {
            val functionName = "inviteJoinChat"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = InviteJoinChatRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun acceptJoinChatInvitation(req: AcceptJoinChatInvitationReqKt,
                parameter: RPCParameter? = null): RPCResponse<AcceptJoinChatInvitationResKt> {
            val functionName = "acceptJoinChatInvitation"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = AcceptJoinChatInvitationRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun refuseJoinChatInvitation(req: RefuseJoinChatInvitationReqKt,
                parameter: RPCParameter? = null): RPCResponse<RefuseJoinChatInvitationResKt> {
            val functionName = "refuseJoinChatInvitation"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = RefuseJoinChatInvitationRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun leaveChat(req: LeaveChatReqKt, parameter: RPCParameter? = null):
                RPCResponse<LeaveChatResKt> {
            val functionName = "leaveChat"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = LeaveChatRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun switchChatMode(req: SwitchChatModeReqKt, parameter: RPCParameter? = null):
                RPCResponse<SwitchChatModeResKt> {
            val functionName = "switchChatMode"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = SwitchChatModeRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun kickUser(req: KickUserReqKt, parameter: RPCParameter? = null):
                RPCResponse<KickUserResKt> {
            val functionName = "kickUser"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = KickUserRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun getUserInRoomStatus(req: GetUserInRoomStatusReqKt, parameter: RPCParameter? =
                null): RPCResponse<GetUserInRoomStatusResKt> {
            val functionName = "getUserInRoomStatus"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetUserInRoomStatusRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun getRoomInfo(req: GetRoomInfoReqKt, parameter: RPCParameter? = null):
                RPCResponse<GetRoomInfoResKt> {
            val functionName = "getRoomInfo"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetRoomInfoRes.parseFrom(data)
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
        fun createAndJoinRoom(handler: (CreateAndJoinRoomReqKt, parameter: RPCParameter?) ->
                CreateAndJoinRoomResKt?): RPCHandlerObserver {
            val subscribeFuncName = "createAndJoinRoom"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = CreateAndJoinRoomReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun joinRoom(handler: (JoinRoomReqKt, parameter: RPCParameter?) -> JoinRoomResKt?):
                RPCHandlerObserver {
            val subscribeFuncName = "joinRoom"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = JoinRoomReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun leaveRoom(handler: (LeaveRoomReqKt, parameter: RPCParameter?) -> LeaveRoomResKt?):
                RPCHandlerObserver {
            val subscribeFuncName = "leaveRoom"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = LeaveRoomReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun heartbeat(handler: (HeartbeatReqKt, parameter: RPCParameter?) -> HeartbeatResKt?):
                RPCHandlerObserver {
            val subscribeFuncName = "heartbeat"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = HeartbeatReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun getChatTopics(handler: (GetChatTopicsReqKt, parameter: RPCParameter?) ->
                GetChatTopicsResKt?): RPCHandlerObserver {
            val subscribeFuncName = "getChatTopics"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetChatTopicsReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun getChatManagers(handler: (GetChatManagersReqKt, parameter: RPCParameter?) ->
                GetChatManagersResKt?): RPCHandlerObserver {
            val subscribeFuncName = "getChatManagers"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetChatManagersReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun getChatParticipants(handler: (GetChatParticipantsReqKt, parameter: RPCParameter?) ->
                GetChatParticipantsResKt?): RPCHandlerObserver {
            val subscribeFuncName = "getChatParticipants"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetChatParticipantsReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun applyJoinChat(handler: (ApplyJoinChatReqKt, parameter: RPCParameter?) ->
                ApplyJoinChatResKt?): RPCHandlerObserver {
            val subscribeFuncName = "applyJoinChat"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = ApplyJoinChatReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun agreeJoinChatApplication(handler: (AgreeJoinChatApplicationReqKt,
                parameter: RPCParameter?) -> AgreeJoinChatApplicationResKt?): RPCHandlerObserver {
            val subscribeFuncName = "agreeJoinChatApplication"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = AgreeJoinChatApplicationReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun getJoinChatApplications(handler: (GetJoinChatApplicationsReqKt,
                parameter: RPCParameter?) -> GetJoinChatApplicationsResKt?): RPCHandlerObserver {
            val subscribeFuncName = "getJoinChatApplications"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetJoinChatApplicationsReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun inviteJoinChat(handler: (InviteJoinChatReqKt, parameter: RPCParameter?) ->
                InviteJoinChatResKt?): RPCHandlerObserver {
            val subscribeFuncName = "inviteJoinChat"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = InviteJoinChatReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun acceptJoinChatInvitation(handler: (AcceptJoinChatInvitationReqKt,
                parameter: RPCParameter?) -> AcceptJoinChatInvitationResKt?): RPCHandlerObserver {
            val subscribeFuncName = "acceptJoinChatInvitation"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = AcceptJoinChatInvitationReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun refuseJoinChatInvitation(handler: (RefuseJoinChatInvitationReqKt,
                parameter: RPCParameter?) -> RefuseJoinChatInvitationResKt?): RPCHandlerObserver {
            val subscribeFuncName = "refuseJoinChatInvitation"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = RefuseJoinChatInvitationReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun leaveChat(handler: (LeaveChatReqKt, parameter: RPCParameter?) -> LeaveChatResKt?):
                RPCHandlerObserver {
            val subscribeFuncName = "leaveChat"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = LeaveChatReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun switchChatMode(handler: (SwitchChatModeReqKt, parameter: RPCParameter?) ->
                SwitchChatModeResKt?): RPCHandlerObserver {
            val subscribeFuncName = "switchChatMode"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = SwitchChatModeReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun kickUser(handler: (KickUserReqKt, parameter: RPCParameter?) -> KickUserResKt?):
                RPCHandlerObserver {
            val subscribeFuncName = "kickUser"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = KickUserReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun getUserInRoomStatus(handler: (GetUserInRoomStatusReqKt, parameter: RPCParameter?) ->
                GetUserInRoomStatusResKt?): RPCHandlerObserver {
            val subscribeFuncName = "getUserInRoomStatus"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetUserInRoomStatusReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun getRoomInfo(handler: (GetRoomInfoReqKt, parameter: RPCParameter?) -> GetRoomInfoResKt?):
                RPCHandlerObserver {
            val subscribeFuncName = "getRoomInfo"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetRoomInfoReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }
    }
}
