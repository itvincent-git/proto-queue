// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.google.protobuf.nano.MessageNano
import com.woohoo.app.common.protocol.nano.WhSvcCommon.Empty
import com.woohoo.app.common.protocol.nano.WhSvcCommonKt.EmptyKt
import com.woohoo.app.common.protocol.nano.WhSvcTacit.FinishTacitNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcTacit.NextQuestionNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcTacit.StartTacitNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcTacit.UserAnswerNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcTacitKt.FinishTacitNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcTacitKt.NextQuestionNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcTacitKt.StartTacitNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcTacitKt.UserAnswerNotifyInfoKt
import kotlin.String
import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine
import net.protoqueue.rpc.gen.RPCApi
import net.protoqueue.rpc.gen.RPCNotifyReceiver
import net.protoqueue.rpc.runtime.RPCError
import net.protoqueue.rpc.runtime.RPCHandlerObserver
import net.protoqueue.rpc.runtime.RPCParameter
import net.protoqueue.rpc.runtime.RPCResponse

private const val serviceName: String = "SvcTacitNotifyService"

class SvcTacitNotifyService {
    object Client {
        suspend fun startTacitNotify(req: StartTacitNotifyInfoKt, parameter: RPCParameter? = null):
                RPCResponse<EmptyKt> {
            val functionName = "startTacitNotify"
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

        suspend fun userAnswerNotify(req: UserAnswerNotifyInfoKt, parameter: RPCParameter? = null):
                RPCResponse<EmptyKt> {
            val functionName = "userAnswerNotify"
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

        suspend fun nextQuestionNotify(req: NextQuestionNotifyInfoKt, parameter: RPCParameter? =
                null): RPCResponse<EmptyKt> {
            val functionName = "nextQuestionNotify"
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

        suspend fun finishTacitNotify(req: FinishTacitNotifyInfoKt, parameter: RPCParameter? =
                null): RPCResponse<EmptyKt> {
            val functionName = "finishTacitNotify"
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
        fun startTacitNotify(handler: (StartTacitNotifyInfoKt, parameter: RPCParameter?) ->
                EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "startTacitNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = StartTacitNotifyInfo.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun userAnswerNotify(handler: (UserAnswerNotifyInfoKt, parameter: RPCParameter?) ->
                EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "userAnswerNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = UserAnswerNotifyInfo.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun nextQuestionNotify(handler: (NextQuestionNotifyInfoKt, parameter: RPCParameter?) ->
                EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "nextQuestionNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = NextQuestionNotifyInfo.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun finishTacitNotify(handler: (FinishTacitNotifyInfoKt, parameter: RPCParameter?) ->
                EmptyKt?): RPCHandlerObserver {
            val subscribeFuncName = "finishTacitNotify"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = FinishTacitNotifyInfo.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }
    }
}
