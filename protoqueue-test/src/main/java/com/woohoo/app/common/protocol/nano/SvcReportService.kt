// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.google.protobuf.nano.MessageNano
import com.woohoo.app.common.protocol.nano.WhSvcReport.ReportViolationReq
import com.woohoo.app.common.protocol.nano.WhSvcReport.ReportViolationRes
import com.woohoo.app.common.protocol.nano.WhSvcReportKt.ReportViolationReqKt
import com.woohoo.app.common.protocol.nano.WhSvcReportKt.ReportViolationResKt
import kotlin.String
import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine
import net.protoqueue.rpc.gen.RPCApi
import net.protoqueue.rpc.gen.RPCNotifyReceiver
import net.protoqueue.rpc.runtime.RPCError
import net.protoqueue.rpc.runtime.RPCHandlerObserver
import net.protoqueue.rpc.runtime.RPCParameter
import net.protoqueue.rpc.runtime.RPCResponse

private const val serviceName: String = "SvcReportService"

class SvcReportService {
    object Client {
        suspend fun reportViolation(req: ReportViolationReqKt, parameter: RPCParameter? = null):
                RPCResponse<ReportViolationResKt> {
            val functionName = "reportViolation"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = ReportViolationRes.parseFrom(data)
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
        fun reportViolation(handler: (ReportViolationReqKt, parameter: RPCParameter?) ->
                ReportViolationResKt?): RPCHandlerObserver {
            val subscribeFuncName = "reportViolation"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = ReportViolationReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }
    }
}
