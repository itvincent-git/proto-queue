// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.google.protobuf.nano.MessageNano
import com.woohoo.app.common.protocol.nano.WhSvcCommon.Empty
import com.woohoo.app.common.protocol.nano.WhSvcCommonKt.EmptyKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.AcceptJoinChatInvitationNotify
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.ApplyJoinChatNotify
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.ChatManagerChangeNotify
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.ChatStatusChangeNotify
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.InviteJoinChatNotify
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.KickUserNotifyNotify
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.RefuseJoinChatInvitationNotify
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.RoomInfoChangeNotify
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.AcceptJoinChatInvitationNotifyKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.ApplyJoinChatNotifyKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.ChatManagerChangeNotifyKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.ChatStatusChangeNotifyKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.InviteJoinChatNotifyKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.KickUserNotifyNotifyKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.RefuseJoinChatInvitationNotifyKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.RoomInfoChangeNotifyKt
import kotlin.String
import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine
import net.protoqueue.rpc.gen.RPCApi
import net.protoqueue.rpc.gen.RPCNotifyReceiver
import net.protoqueue.rpc.runtime.RPCError
import net.protoqueue.rpc.runtime.RPCHandlerObserver
import net.protoqueue.rpc.runtime.RPCParameter
import net.protoqueue.rpc.runtime.RPCResponse

private const val serviceName: String = "SvcPartyRoomNotifyService"

class SvcPartyRoomNotifyService {
    object Client {
        suspend fun onApplyJoinChatNotify(req: ApplyJoinChatNotifyKt, parameter: RPCParameter? =
                null): RPCResponse<EmptyKt> {
            val functionName = "onApplyJoinChatNotify"
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

        suspend fun onInviteJoinChatNotify(req: InviteJoinChatNotifyKt, parameter: RPCParameter? =
                null): RPCResponse<EmptyKt> {
            val functionName = "onInviteJoinChatNotify"
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

        suspend fun onAcceptJoinChatInvitationNotify(req: AcceptJoinChatInvitationNotifyKt,
                parameter: RPCParameter? = null): RPCResponse<EmptyKt> {
            val functionName = "onAcceptJoinChatInvitationNotify"
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

        suspend fun onRefuseJoinChatInvitationNotify(req: RefuseJoinChatInvitationNotifyKt,
                parameter: RPCParameter? = null): RPCResponse<EmptyKt> {
            val functionName = "onRefuseJoinChatInvitationNotify"
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

        suspend fun onChatStatusChangeNotify(req: ChatStatusChangeNotifyKt, parameter: RPCParameter?
                = null): RPCResponse<EmptyKt> {
            val functionName = "onChatStatusChangeNotify"
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

        suspend fun onChatManagerChangeNotify(req: ChatManagerChangeNotifyKt,
                parameter: RPCParameter? = null): RPCResponse<EmptyKt> {
            val functionName = "onChatManagerChangeNotify"
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

        suspend fun onRoomInfoChangeNotify(req: RoomInfoChangeNotifyKt, parameter: RPCParameter? =
                null): RPCResponse<EmptyKt> {
            val functionName = "onRoomInfoChangeNotify"
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

        suspend fun onKickUserNotify(req: KickUserNotifyNotifyKt, parameter: RPCParameter? = null):
                RPCResponse<EmptyKt> {
            val functionName = "onKickUserNotify"
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
        fun onApplyJoinChatNotify(handler: (ApplyJoinChatNotifyKt, parameter: RPCParameter?) ->
                EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "onApplyJoinChatNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = ApplyJoinChatNotify.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun onInviteJoinChatNotify(handler: (InviteJoinChatNotifyKt, parameter: RPCParameter?) ->
                EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "onInviteJoinChatNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = InviteJoinChatNotify.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun onAcceptJoinChatInvitationNotify(handler: (AcceptJoinChatInvitationNotifyKt,
                parameter: RPCParameter?) -> EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "onAcceptJoinChatInvitationNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify =
                            AcceptJoinChatInvitationNotify.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun onRefuseJoinChatInvitationNotify(handler: (RefuseJoinChatInvitationNotifyKt,
                parameter: RPCParameter?) -> EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "onRefuseJoinChatInvitationNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify =
                            RefuseJoinChatInvitationNotify.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun onChatStatusChangeNotify(handler: (ChatStatusChangeNotifyKt,
                parameter: RPCParameter?) -> EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "onChatStatusChangeNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = ChatStatusChangeNotify.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun onChatManagerChangeNotify(handler: (ChatManagerChangeNotifyKt,
                parameter: RPCParameter?) -> EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "onChatManagerChangeNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = ChatManagerChangeNotify.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun onRoomInfoChangeNotify(handler: (RoomInfoChangeNotifyKt, parameter: RPCParameter?) ->
                EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "onRoomInfoChangeNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = RoomInfoChangeNotify.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun onKickUserNotify(handler: (KickUserNotifyNotifyKt, parameter: RPCParameter?) ->
                EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "onKickUserNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = KickUserNotifyNotify.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }
    }
}
