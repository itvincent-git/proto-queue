// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.google.protobuf.nano.MessageNano
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPage.HomePageListReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPage.HomePageListRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPage.RelatedRecommendReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPage.RelatedRecommendRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPageKt.HomePageListReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPageKt.HomePageListResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPageKt.RelatedRecommendReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPageKt.RelatedRecommendResKt
import kotlin.String
import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine
import net.protoqueue.rpc.gen.RPCApi
import net.protoqueue.rpc.gen.RPCNotifyReceiver
import net.protoqueue.rpc.runtime.RPCError
import net.protoqueue.rpc.runtime.RPCHandlerObserver
import net.protoqueue.rpc.runtime.RPCParameter
import net.protoqueue.rpc.runtime.RPCResponse

private const val serviceName: String = "SvcPartyRoomPageService"

class SvcPartyRoomPageService {
    object Client {
        suspend fun relatedRecommendList(req: RelatedRecommendReqKt, parameter: RPCParameter? =
                null): RPCResponse<RelatedRecommendResKt> {
            val functionName = "relatedRecommendList"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = RelatedRecommendRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun homePageList(req: HomePageListReqKt, parameter: RPCParameter? = null):
                RPCResponse<HomePageListResKt> {
            val functionName = "homePageList"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = HomePageListRes.parseFrom(data)
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
        fun relatedRecommendList(handler: (RelatedRecommendReqKt, parameter: RPCParameter?) ->
                RelatedRecommendResKt?): RPCHandlerObserver {
            val subscribeFuncName = "relatedRecommendList"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = RelatedRecommendReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun homePageList(handler: (HomePageListReqKt, parameter: RPCParameter?) ->
                HomePageListResKt?): RPCHandlerObserver {
            val subscribeFuncName = "homePageList"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = HomePageListReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }
    }
}
