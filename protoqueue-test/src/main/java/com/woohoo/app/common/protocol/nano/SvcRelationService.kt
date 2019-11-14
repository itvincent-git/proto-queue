// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.google.protobuf.nano.MessageNano
import com.woohoo.app.common.protocol.nano.WhSvcRelation.ChangeBlackListReq
import com.woohoo.app.common.protocol.nano.WhSvcRelation.ChangeBlackListRes
import com.woohoo.app.common.protocol.nano.WhSvcRelation.CheckRelationReq
import com.woohoo.app.common.protocol.nano.WhSvcRelation.CheckRelationRes
import com.woohoo.app.common.protocol.nano.WhSvcRelation.FollowOpReq
import com.woohoo.app.common.protocol.nano.WhSvcRelation.FollowOpRes
import com.woohoo.app.common.protocol.nano.WhSvcRelation.GetBlackListReq
import com.woohoo.app.common.protocol.nano.WhSvcRelation.GetBlackListRes
import com.woohoo.app.common.protocol.nano.WhSvcRelation.GetFansListReq
import com.woohoo.app.common.protocol.nano.WhSvcRelation.GetFansListRes
import com.woohoo.app.common.protocol.nano.WhSvcRelation.GetFollowListReq
import com.woohoo.app.common.protocol.nano.WhSvcRelation.GetFollowListRes
import com.woohoo.app.common.protocol.nano.WhSvcRelation.GetFriendListReq
import com.woohoo.app.common.protocol.nano.WhSvcRelation.GetFriendListRes
import com.woohoo.app.common.protocol.nano.WhSvcRelation.GetRelationCountReq
import com.woohoo.app.common.protocol.nano.WhSvcRelation.GetRelationCountRes
import com.woohoo.app.common.protocol.nano.WhSvcRelation.GreetReq
import com.woohoo.app.common.protocol.nano.WhSvcRelation.GreetRes
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.ChangeBlackListReqKt
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.ChangeBlackListResKt
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.CheckRelationReqKt
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.CheckRelationResKt
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.FollowOpReqKt
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.FollowOpResKt
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.GetBlackListReqKt
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.GetBlackListResKt
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.GetFansListReqKt
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.GetFansListResKt
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.GetFollowListReqKt
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.GetFollowListResKt
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.GetFriendListReqKt
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.GetFriendListResKt
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.GetRelationCountReqKt
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.GetRelationCountResKt
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.GreetReqKt
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.GreetResKt
import kotlin.String
import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine
import net.protoqueue.rpc.gen.RPCApi
import net.protoqueue.rpc.gen.RPCNotifyReceiver
import net.protoqueue.rpc.runtime.RPCError
import net.protoqueue.rpc.runtime.RPCHandlerObserver
import net.protoqueue.rpc.runtime.RPCParameter
import net.protoqueue.rpc.runtime.RPCResponse

private const val serviceName: String = "SvcRelationService"

class SvcRelationService {
    object Client {
        suspend fun changeFollow(req: FollowOpReqKt, parameter: RPCParameter? = null):
                RPCResponse<FollowOpResKt> {
            val functionName = "changeFollow"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = FollowOpRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun getFansList(req: GetFansListReqKt, parameter: RPCParameter? = null):
                RPCResponse<GetFansListResKt> {
            val functionName = "getFansList"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetFansListRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun getFollowList(req: GetFollowListReqKt, parameter: RPCParameter? = null):
                RPCResponse<GetFollowListResKt> {
            val functionName = "getFollowList"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetFollowListRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun getFriendList(req: GetFriendListReqKt, parameter: RPCParameter? = null):
                RPCResponse<GetFriendListResKt> {
            val functionName = "getFriendList"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetFriendListRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun getRelationCount(req: GetRelationCountReqKt, parameter: RPCParameter? = null):
                RPCResponse<GetRelationCountResKt> {
            val functionName = "getRelationCount"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetRelationCountRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun checkRelation(req: CheckRelationReqKt, parameter: RPCParameter? = null):
                RPCResponse<CheckRelationResKt> {
            val functionName = "checkRelation"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = CheckRelationRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun changeBlackList(req: ChangeBlackListReqKt, parameter: RPCParameter? = null):
                RPCResponse<ChangeBlackListResKt> {
            val functionName = "changeBlackList"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = ChangeBlackListRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun getBlackList(req: GetBlackListReqKt, parameter: RPCParameter? = null):
                RPCResponse<GetBlackListResKt> {
            val functionName = "getBlackList"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetBlackListRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun greeting(req: GreetReqKt, parameter: RPCParameter? = null):
                RPCResponse<GreetResKt> {
            val functionName = "greeting"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GreetRes.parseFrom(data)
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
        fun changeFollow(handler: (FollowOpReqKt, parameter: RPCParameter?) -> FollowOpResKt?):
                RPCHandlerObserver {
            val subscribeFuncName = "changeFollow"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = FollowOpReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun getFansList(handler: (GetFansListReqKt, parameter: RPCParameter?) -> GetFansListResKt?):
                RPCHandlerObserver {
            val subscribeFuncName = "getFansList"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetFansListReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun getFollowList(handler: (GetFollowListReqKt, parameter: RPCParameter?) ->
                GetFollowListResKt?): RPCHandlerObserver {
            val subscribeFuncName = "getFollowList"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetFollowListReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun getFriendList(handler: (GetFriendListReqKt, parameter: RPCParameter?) ->
                GetFriendListResKt?): RPCHandlerObserver {
            val subscribeFuncName = "getFriendList"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetFriendListReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun getRelationCount(handler: (GetRelationCountReqKt, parameter: RPCParameter?) ->
                GetRelationCountResKt?): RPCHandlerObserver {
            val subscribeFuncName = "getRelationCount"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetRelationCountReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun checkRelation(handler: (CheckRelationReqKt, parameter: RPCParameter?) ->
                CheckRelationResKt?): RPCHandlerObserver {
            val subscribeFuncName = "checkRelation"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = CheckRelationReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun changeBlackList(handler: (ChangeBlackListReqKt, parameter: RPCParameter?) ->
                ChangeBlackListResKt?): RPCHandlerObserver {
            val subscribeFuncName = "changeBlackList"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = ChangeBlackListReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun getBlackList(handler: (GetBlackListReqKt, parameter: RPCParameter?) ->
                GetBlackListResKt?): RPCHandlerObserver {
            val subscribeFuncName = "getBlackList"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetBlackListReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun greeting(handler: (GreetReqKt, parameter: RPCParameter?) -> GreetResKt?):
                RPCHandlerObserver {
            val subscribeFuncName = "greeting"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GreetReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }
    }
}
