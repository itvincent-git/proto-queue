// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.google.protobuf.nano.MessageNano
import com.woohoo.app.common.protocol.nano.WhSvcChatroom.CreateMediaTokenReq
import com.woohoo.app.common.protocol.nano.WhSvcChatroom.CreateMediaTokenRes
import com.woohoo.app.common.protocol.nano.WhSvcChatroomKt.CreateMediaTokenReqKt
import com.woohoo.app.common.protocol.nano.WhSvcChatroomKt.CreateMediaTokenResKt
import kotlin.String
import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine
import net.protoqueue.rpc.gen.RPCApi
import net.protoqueue.rpc.gen.RPCNotifyReceiver
import net.protoqueue.rpc.runtime.RPCError
import net.protoqueue.rpc.runtime.RPCHandlerObserver
import net.protoqueue.rpc.runtime.RPCParameter
import net.protoqueue.rpc.runtime.RPCResponse

private const val serviceName: String = "SvcChatRoomService"

class SvcChatRoomService {
    object Client {
        suspend fun createMediaToken(req: CreateMediaTokenReqKt, parameter: RPCParameter? = null):
                RPCResponse<CreateMediaTokenResKt> {
            val functionName = "createMediaToken"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = CreateMediaTokenRes.parseFrom(data)
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
        fun createMediaToken(handler: (CreateMediaTokenReqKt, parameter: RPCParameter?) ->
                CreateMediaTokenResKt?): RPCHandlerObserver {
            val subscribeFuncName = "createMediaToken"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = CreateMediaTokenReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }
    }
}
