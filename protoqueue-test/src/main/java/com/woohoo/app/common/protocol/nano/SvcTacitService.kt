// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.google.protobuf.nano.MessageNano
import com.woohoo.app.common.protocol.nano.WhSvcTacit.AnswerReq
import com.woohoo.app.common.protocol.nano.WhSvcTacit.AnswerRes
import com.woohoo.app.common.protocol.nano.WhSvcTacit.GetTacitBasicInfoReq
import com.woohoo.app.common.protocol.nano.WhSvcTacit.GetTacitBasicInfoRes
import com.woohoo.app.common.protocol.nano.WhSvcTacit.TacitTitleReq
import com.woohoo.app.common.protocol.nano.WhSvcTacit.TacitTitleRes
import com.woohoo.app.common.protocol.nano.WhSvcTacitKt.AnswerReqKt
import com.woohoo.app.common.protocol.nano.WhSvcTacitKt.AnswerResKt
import com.woohoo.app.common.protocol.nano.WhSvcTacitKt.GetTacitBasicInfoReqKt
import com.woohoo.app.common.protocol.nano.WhSvcTacitKt.GetTacitBasicInfoResKt
import com.woohoo.app.common.protocol.nano.WhSvcTacitKt.TacitTitleReqKt
import com.woohoo.app.common.protocol.nano.WhSvcTacitKt.TacitTitleResKt
import kotlin.String
import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine
import net.protoqueue.rpc.gen.RPCApi
import net.protoqueue.rpc.gen.RPCNotifyReceiver
import net.protoqueue.rpc.runtime.RPCError
import net.protoqueue.rpc.runtime.RPCHandlerObserver
import net.protoqueue.rpc.runtime.RPCParameter
import net.protoqueue.rpc.runtime.RPCResponse

private const val serviceName: String = "SvcTacitService"

class SvcTacitService {
    object Client {
        suspend fun answer(req: AnswerReqKt, parameter: RPCParameter? = null):
                RPCResponse<AnswerResKt> {
            val functionName = "answer"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = AnswerRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun getTacitTitle(req: TacitTitleReqKt, parameter: RPCParameter? = null):
                RPCResponse<TacitTitleResKt> {
            val functionName = "getTacitTitle"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = TacitTitleRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun getTacitBasicInfo(req: GetTacitBasicInfoReqKt, parameter: RPCParameter? = null):
                RPCResponse<GetTacitBasicInfoResKt> {
            val functionName = "getTacitBasicInfo"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetTacitBasicInfoRes.parseFrom(data)
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
        fun answer(handler: (AnswerReqKt, parameter: RPCParameter?) -> AnswerResKt?):
                RPCHandlerObserver {
            val subscribeFuncName = "answer"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = AnswerReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun getTacitTitle(handler: (TacitTitleReqKt, parameter: RPCParameter?) -> TacitTitleResKt?):
                RPCHandlerObserver {
            val subscribeFuncName = "getTacitTitle"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = TacitTitleReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun getTacitBasicInfo(handler: (GetTacitBasicInfoReqKt, parameter: RPCParameter?) ->
                GetTacitBasicInfoResKt?): RPCHandlerObserver {
            val subscribeFuncName = "getTacitBasicInfo"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetTacitBasicInfoReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }
    }
}
