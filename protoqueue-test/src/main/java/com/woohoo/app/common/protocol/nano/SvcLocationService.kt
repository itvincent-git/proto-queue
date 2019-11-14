// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.google.protobuf.nano.MessageNano
import com.woohoo.app.common.protocol.nano.WhSvcLocation.GetReportConfigReq
import com.woohoo.app.common.protocol.nano.WhSvcLocation.GetReportConfigRes
import com.woohoo.app.common.protocol.nano.WhSvcLocation.ReportLocationReq
import com.woohoo.app.common.protocol.nano.WhSvcLocation.ReportLocationRes
import com.woohoo.app.common.protocol.nano.WhSvcLocation.SwitchLocationReq
import com.woohoo.app.common.protocol.nano.WhSvcLocation.SwitchLocationRes
import com.woohoo.app.common.protocol.nano.WhSvcLocationKt.GetReportConfigReqKt
import com.woohoo.app.common.protocol.nano.WhSvcLocationKt.GetReportConfigResKt
import com.woohoo.app.common.protocol.nano.WhSvcLocationKt.ReportLocationReqKt
import com.woohoo.app.common.protocol.nano.WhSvcLocationKt.ReportLocationResKt
import com.woohoo.app.common.protocol.nano.WhSvcLocationKt.SwitchLocationReqKt
import com.woohoo.app.common.protocol.nano.WhSvcLocationKt.SwitchLocationResKt
import kotlin.String
import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine
import net.protoqueue.rpc.gen.RPCApi
import net.protoqueue.rpc.gen.RPCNotifyReceiver
import net.protoqueue.rpc.runtime.RPCError
import net.protoqueue.rpc.runtime.RPCHandlerObserver
import net.protoqueue.rpc.runtime.RPCParameter
import net.protoqueue.rpc.runtime.RPCResponse

private const val serviceName: String = "SvcLocationService"

class SvcLocationService {
    object Client {
        suspend fun getReportConfig(req: GetReportConfigReqKt, parameter: RPCParameter? = null):
                RPCResponse<GetReportConfigResKt> {
            val functionName = "getReportConfig"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetReportConfigRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun reportLocation(req: ReportLocationReqKt, parameter: RPCParameter? = null):
                RPCResponse<ReportLocationResKt> {
            val functionName = "reportLocation"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = ReportLocationRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun switchLocation(req: SwitchLocationReqKt, parameter: RPCParameter? = null):
                RPCResponse<SwitchLocationResKt> {
            val functionName = "switchLocation"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = SwitchLocationRes.parseFrom(data)
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
        fun getReportConfig(handler: (GetReportConfigReqKt, parameter: RPCParameter?) ->
                GetReportConfigResKt?): RPCHandlerObserver {
            val subscribeFuncName = "getReportConfig"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetReportConfigReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun reportLocation(handler: (ReportLocationReqKt, parameter: RPCParameter?) ->
                ReportLocationResKt?): RPCHandlerObserver {
            val subscribeFuncName = "reportLocation"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = ReportLocationReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun switchLocation(handler: (SwitchLocationReqKt, parameter: RPCParameter?) ->
                SwitchLocationResKt?): RPCHandlerObserver {
            val subscribeFuncName = "switchLocation"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = SwitchLocationReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }
    }
}
