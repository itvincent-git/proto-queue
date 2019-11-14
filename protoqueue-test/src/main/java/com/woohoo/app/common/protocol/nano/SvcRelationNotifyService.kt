// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.google.protobuf.nano.MessageNano
import com.woohoo.app.common.protocol.nano.WhSvcCommon.Empty
import com.woohoo.app.common.protocol.nano.WhSvcCommonKt.EmptyKt
import com.woohoo.app.common.protocol.nano.WhSvcRelation.RelationChangeMsg
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.RelationChangeMsgKt
import kotlin.String
import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine
import net.protoqueue.rpc.gen.RPCApi
import net.protoqueue.rpc.gen.RPCNotifyReceiver
import net.protoqueue.rpc.runtime.RPCError
import net.protoqueue.rpc.runtime.RPCHandlerObserver
import net.protoqueue.rpc.runtime.RPCParameter
import net.protoqueue.rpc.runtime.RPCResponse

private const val serviceName: String = "SvcRelationNotifyService"

class SvcRelationNotifyService {
    object Client {
        suspend fun relationChangeNotify(req: RelationChangeMsgKt, parameter: RPCParameter? = null):
                RPCResponse<EmptyKt> {
            val functionName = "relationChangeNotify"
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
        fun relationChangeNotify(handler: (RelationChangeMsgKt, parameter: RPCParameter?) ->
                EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "relationChangeNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = RelationChangeMsg.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }
    }
}
