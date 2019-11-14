// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.google.protobuf.nano.MessageNano
import com.woohoo.app.common.protocol.nano.WhSvcUserOnline.BatchGetUserOnlineStatusReq
import com.woohoo.app.common.protocol.nano.WhSvcUserOnline.BatchGetUserOnlineStatusRes
import com.woohoo.app.common.protocol.nano.WhSvcUserOnline.HeartbeatReq
import com.woohoo.app.common.protocol.nano.WhSvcUserOnline.HeartbeatRes
import com.woohoo.app.common.protocol.nano.WhSvcUserOnline.StartHeartbeatReq
import com.woohoo.app.common.protocol.nano.WhSvcUserOnline.StartHeartbeatRes
import com.woohoo.app.common.protocol.nano.WhSvcUserOnlineKt.BatchGetUserOnlineStatusReqKt
import com.woohoo.app.common.protocol.nano.WhSvcUserOnlineKt.BatchGetUserOnlineStatusResKt
import com.woohoo.app.common.protocol.nano.WhSvcUserOnlineKt.HeartbeatReqKt
import com.woohoo.app.common.protocol.nano.WhSvcUserOnlineKt.HeartbeatResKt
import com.woohoo.app.common.protocol.nano.WhSvcUserOnlineKt.StartHeartbeatReqKt
import com.woohoo.app.common.protocol.nano.WhSvcUserOnlineKt.StartHeartbeatResKt
import kotlin.String
import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine
import net.protoqueue.rpc.gen.RPCApi
import net.protoqueue.rpc.gen.RPCNotifyReceiver
import net.protoqueue.rpc.runtime.RPCError
import net.protoqueue.rpc.runtime.RPCHandlerObserver
import net.protoqueue.rpc.runtime.RPCParameter
import net.protoqueue.rpc.runtime.RPCResponse

private const val serviceName: String = "SvcUserOnlineService"

class SvcUserOnlineService {
    object Client {
        suspend fun startHeartbeat(req: StartHeartbeatReqKt, parameter: RPCParameter? = null):
                RPCResponse<StartHeartbeatResKt> {
            val functionName = "startHeartbeat"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = StartHeartbeatRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun heatBeat(req: HeartbeatReqKt, parameter: RPCParameter? = null):
                RPCResponse<HeartbeatResKt> {
            val functionName = "heatBeat"
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

        suspend fun batchGetUserOnlineStatus(req: BatchGetUserOnlineStatusReqKt,
                parameter: RPCParameter? = null): RPCResponse<BatchGetUserOnlineStatusResKt> {
            val functionName = "batchGetUserOnlineStatus"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = BatchGetUserOnlineStatusRes.parseFrom(data)
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
        fun startHeartbeat(handler: (StartHeartbeatReqKt, parameter: RPCParameter?) ->
                StartHeartbeatResKt?): RPCHandlerObserver {
            val subscribeFuncName = "startHeartbeat"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = StartHeartbeatReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun heatBeat(handler: (HeartbeatReqKt, parameter: RPCParameter?) -> HeartbeatResKt?):
                RPCHandlerObserver {
            val subscribeFuncName = "heatBeat"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = HeartbeatReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun batchGetUserOnlineStatus(handler: (BatchGetUserOnlineStatusReqKt,
                parameter: RPCParameter?) -> BatchGetUserOnlineStatusResKt?): RPCHandlerObserver {
            val subscribeFuncName = "batchGetUserOnlineStatus"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = BatchGetUserOnlineStatusReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }
    }
}
