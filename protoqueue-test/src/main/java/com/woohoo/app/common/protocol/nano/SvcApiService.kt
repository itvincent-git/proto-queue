// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.google.protobuf.nano.MessageNano
import com.woohoo.app.common.protocol.nano.WhSvcApi.CommandCallbackReq
import com.woohoo.app.common.protocol.nano.WhSvcApi.CommandCallbackRes
import com.woohoo.app.common.protocol.nano.WhSvcApi.GetPendingCommandReq
import com.woohoo.app.common.protocol.nano.WhSvcApi.GetPendingCommandRes
import com.woohoo.app.common.protocol.nano.WhSvcApi.GetPrivacySettingReq
import com.woohoo.app.common.protocol.nano.WhSvcApi.GetPrivacySettingRes
import com.woohoo.app.common.protocol.nano.WhSvcApi.SetPrivacySettingReq
import com.woohoo.app.common.protocol.nano.WhSvcApi.SetPrivacySettingRes
import com.woohoo.app.common.protocol.nano.WhSvcApiKt.CommandCallbackReqKt
import com.woohoo.app.common.protocol.nano.WhSvcApiKt.CommandCallbackResKt
import com.woohoo.app.common.protocol.nano.WhSvcApiKt.GetPendingCommandReqKt
import com.woohoo.app.common.protocol.nano.WhSvcApiKt.GetPendingCommandResKt
import com.woohoo.app.common.protocol.nano.WhSvcApiKt.GetPrivacySettingReqKt
import com.woohoo.app.common.protocol.nano.WhSvcApiKt.GetPrivacySettingResKt
import com.woohoo.app.common.protocol.nano.WhSvcApiKt.SetPrivacySettingReqKt
import com.woohoo.app.common.protocol.nano.WhSvcApiKt.SetPrivacySettingResKt
import kotlin.String
import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine
import net.protoqueue.rpc.gen.RPCApi
import net.protoqueue.rpc.gen.RPCNotifyReceiver
import net.protoqueue.rpc.runtime.RPCError
import net.protoqueue.rpc.runtime.RPCHandlerObserver
import net.protoqueue.rpc.runtime.RPCParameter
import net.protoqueue.rpc.runtime.RPCResponse

private const val serviceName: String = "SvcApiService"

class SvcApiService {
    object Client {
        suspend fun setPrivacySetting(req: SetPrivacySettingReqKt, parameter: RPCParameter? = null):
                RPCResponse<SetPrivacySettingResKt> {
            val functionName = "setPrivacySetting"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = SetPrivacySettingRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun getPrivacySetting(req: GetPrivacySettingReqKt, parameter: RPCParameter? = null):
                RPCResponse<GetPrivacySettingResKt> {
            val functionName = "getPrivacySetting"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetPrivacySettingRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun getPendingCommand(req: GetPendingCommandReqKt, parameter: RPCParameter? = null):
                RPCResponse<GetPendingCommandResKt> {
            val functionName = "getPendingCommand"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetPendingCommandRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun commandCallback(req: CommandCallbackReqKt, parameter: RPCParameter? = null):
                RPCResponse<CommandCallbackResKt> {
            val functionName = "commandCallback"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = CommandCallbackRes.parseFrom(data)
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
        fun setPrivacySetting(handler: (SetPrivacySettingReqKt, parameter: RPCParameter?) ->
                SetPrivacySettingResKt?): RPCHandlerObserver {
            val subscribeFuncName = "setPrivacySetting"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = SetPrivacySettingReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun getPrivacySetting(handler: (GetPrivacySettingReqKt, parameter: RPCParameter?) ->
                GetPrivacySettingResKt?): RPCHandlerObserver {
            val subscribeFuncName = "getPrivacySetting"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetPrivacySettingReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun getPendingCommand(handler: (GetPendingCommandReqKt, parameter: RPCParameter?) ->
                GetPendingCommandResKt?): RPCHandlerObserver {
            val subscribeFuncName = "getPendingCommand"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetPendingCommandReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun commandCallback(handler: (CommandCallbackReqKt, parameter: RPCParameter?) ->
                CommandCallbackResKt?): RPCHandlerObserver {
            val subscribeFuncName = "commandCallback"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = CommandCallbackReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }
    }
}
