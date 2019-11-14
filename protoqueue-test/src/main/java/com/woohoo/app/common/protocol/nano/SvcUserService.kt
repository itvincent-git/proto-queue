// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.google.protobuf.nano.MessageNano
import com.woohoo.app.common.protocol.nano.WhSvcUser.GetUserAccountReq
import com.woohoo.app.common.protocol.nano.WhSvcUser.GetUserAccountRes
import com.woohoo.app.common.protocol.nano.WhSvcUser.GetUserInfoByShareIdReq
import com.woohoo.app.common.protocol.nano.WhSvcUser.GetUserInfoByShareIdRes
import com.woohoo.app.common.protocol.nano.WhSvcUser.GetUserInfoListForTestReq
import com.woohoo.app.common.protocol.nano.WhSvcUser.GetUserInfoListForTestRes
import com.woohoo.app.common.protocol.nano.WhSvcUser.GetUserInfoReq
import com.woohoo.app.common.protocol.nano.WhSvcUser.GetUserInfoRes
import com.woohoo.app.common.protocol.nano.WhSvcUser.GetUserPersonalCardReq
import com.woohoo.app.common.protocol.nano.WhSvcUser.GetUserPersonalCardRes
import com.woohoo.app.common.protocol.nano.WhSvcUser.RefreshAccountTokenReq
import com.woohoo.app.common.protocol.nano.WhSvcUser.RefreshAccountTokenRes
import com.woohoo.app.common.protocol.nano.WhSvcUser.SavePhotoListReq
import com.woohoo.app.common.protocol.nano.WhSvcUser.SavePhotoListRes
import com.woohoo.app.common.protocol.nano.WhSvcUser.SearchUserReq
import com.woohoo.app.common.protocol.nano.WhSvcUser.SearchUserRes
import com.woohoo.app.common.protocol.nano.WhSvcUser.ShareUserReq
import com.woohoo.app.common.protocol.nano.WhSvcUser.ShareUserRes
import com.woohoo.app.common.protocol.nano.WhSvcUser.UpdateUserInfoReq
import com.woohoo.app.common.protocol.nano.WhSvcUser.UpdateUserInfoRes
import com.woohoo.app.common.protocol.nano.WhSvcUser.UserBindAccountReq
import com.woohoo.app.common.protocol.nano.WhSvcUser.UserBindAccountRes
import com.woohoo.app.common.protocol.nano.WhSvcUser.UserLoginReq
import com.woohoo.app.common.protocol.nano.WhSvcUser.UserLoginRes
import com.woohoo.app.common.protocol.nano.WhSvcUser.UserUnBindAccountReq
import com.woohoo.app.common.protocol.nano.WhSvcUser.UserUnBindAccountRes
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.GetUserAccountReqKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.GetUserAccountResKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.GetUserInfoByShareIdReqKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.GetUserInfoByShareIdResKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.GetUserInfoListForTestReqKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.GetUserInfoListForTestResKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.GetUserInfoReqKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.GetUserInfoResKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.GetUserPersonalCardReqKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.GetUserPersonalCardResKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.RefreshAccountTokenReqKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.RefreshAccountTokenResKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.SavePhotoListReqKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.SavePhotoListResKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.SearchUserReqKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.SearchUserResKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.ShareUserReqKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.ShareUserResKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.UpdateUserInfoReqKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.UpdateUserInfoResKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.UserBindAccountReqKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.UserBindAccountResKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.UserLoginReqKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.UserLoginResKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.UserUnBindAccountReqKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.UserUnBindAccountResKt
import kotlin.String
import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine
import net.protoqueue.rpc.gen.RPCApi
import net.protoqueue.rpc.gen.RPCNotifyReceiver
import net.protoqueue.rpc.runtime.RPCError
import net.protoqueue.rpc.runtime.RPCHandlerObserver
import net.protoqueue.rpc.runtime.RPCParameter
import net.protoqueue.rpc.runtime.RPCResponse

private const val serviceName: String = "SvcUserService"

class SvcUserService {
    object Client {
        suspend fun login(req: UserLoginReqKt, parameter: RPCParameter? = null):
                RPCResponse<UserLoginResKt> {
            val functionName = "login"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = UserLoginRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun updateUserInfo(req: UpdateUserInfoReqKt, parameter: RPCParameter? = null):
                RPCResponse<UpdateUserInfoResKt> {
            val functionName = "updateUserInfo"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = UpdateUserInfoRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun savePhotoListRes(req: SavePhotoListReqKt, parameter: RPCParameter? = null):
                RPCResponse<SavePhotoListResKt> {
            val functionName = "savePhotoListRes"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = SavePhotoListRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun getUserPersonalCard(req: GetUserPersonalCardReqKt, parameter: RPCParameter? =
                null): RPCResponse<GetUserPersonalCardResKt> {
            val functionName = "getUserPersonalCard"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetUserPersonalCardRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun batchGetUserInfo(req: GetUserInfoReqKt, parameter: RPCParameter? = null):
                RPCResponse<GetUserInfoResKt> {
            val functionName = "batchGetUserInfo"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetUserInfoRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun bindAccount(req: UserBindAccountReqKt, parameter: RPCParameter? = null):
                RPCResponse<UserBindAccountResKt> {
            val functionName = "bindAccount"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = UserBindAccountRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun unBindAccount(req: UserUnBindAccountReqKt, parameter: RPCParameter? = null):
                RPCResponse<UserUnBindAccountResKt> {
            val functionName = "unBindAccount"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = UserUnBindAccountRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun getUserAccount(req: GetUserAccountReqKt, parameter: RPCParameter? = null):
                RPCResponse<GetUserAccountResKt> {
            val functionName = "getUserAccount"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetUserAccountRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun refreshAccountToken(req: RefreshAccountTokenReqKt, parameter: RPCParameter? =
                null): RPCResponse<RefreshAccountTokenResKt> {
            val functionName = "refreshAccountToken"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = RefreshAccountTokenRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun getUserInfoListForTest(req: GetUserInfoListForTestReqKt,
                parameter: RPCParameter? = null): RPCResponse<GetUserInfoListForTestResKt> {
            val functionName = "getUserInfoListForTest"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetUserInfoListForTestRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun shareUser(req: ShareUserReqKt, parameter: RPCParameter? = null):
                RPCResponse<ShareUserResKt> {
            val functionName = "shareUser"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = ShareUserRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun getUserInfoByShareId(req: GetUserInfoByShareIdReqKt, parameter: RPCParameter? =
                null): RPCResponse<GetUserInfoByShareIdResKt> {
            val functionName = "getUserInfoByShareId"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = GetUserInfoByShareIdRes.parseFrom(data)
                        continuation.resume(RPCResponse(res.convertToDataObject(), parameter =
                                parameter))
                    }, { sdkResCode, srvResCode ->
                        continuation.resume(RPCResponse(error = RPCError(sdkResCode, srvResCode)))
                    }, parameter
                )
            }
        }

        suspend fun searchUser(req: SearchUserReqKt, parameter: RPCParameter? = null):
                RPCResponse<SearchUserResKt> {
            val functionName = "searchUser"
            return suspendCancellableCoroutine { continuation -> 
                RPCApi.send(serviceName, functionName,
                        MessageNano.toByteArray(req.convertToMessage()),
                    { _, _, data, parameter ->
                        val res = SearchUserRes.parseFrom(data)
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
        fun login(handler: (UserLoginReqKt, parameter: RPCParameter?) -> UserLoginResKt?):
                RPCHandlerObserver {
            val subscribeFuncName = "login"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = UserLoginReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun updateUserInfo(handler: (UpdateUserInfoReqKt, parameter: RPCParameter?) ->
                UpdateUserInfoResKt?): RPCHandlerObserver {
            val subscribeFuncName = "updateUserInfo"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = UpdateUserInfoReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun savePhotoListRes(handler: (SavePhotoListReqKt, parameter: RPCParameter?) ->
                SavePhotoListResKt?): RPCHandlerObserver {
            val subscribeFuncName = "savePhotoListRes"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = SavePhotoListReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun getUserPersonalCard(handler: (GetUserPersonalCardReqKt, parameter: RPCParameter?) ->
                GetUserPersonalCardResKt?): RPCHandlerObserver {
            val subscribeFuncName = "getUserPersonalCard"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetUserPersonalCardReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun batchGetUserInfo(handler: (GetUserInfoReqKt, parameter: RPCParameter?) ->
                GetUserInfoResKt?): RPCHandlerObserver {
            val subscribeFuncName = "batchGetUserInfo"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetUserInfoReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun bindAccount(handler: (UserBindAccountReqKt, parameter: RPCParameter?) ->
                UserBindAccountResKt?): RPCHandlerObserver {
            val subscribeFuncName = "bindAccount"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = UserBindAccountReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun unBindAccount(handler: (UserUnBindAccountReqKt, parameter: RPCParameter?) ->
                UserUnBindAccountResKt?): RPCHandlerObserver {
            val subscribeFuncName = "unBindAccount"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = UserUnBindAccountReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun getUserAccount(handler: (GetUserAccountReqKt, parameter: RPCParameter?) ->
                GetUserAccountResKt?): RPCHandlerObserver {
            val subscribeFuncName = "getUserAccount"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetUserAccountReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun refreshAccountToken(handler: (RefreshAccountTokenReqKt, parameter: RPCParameter?) ->
                RefreshAccountTokenResKt?): RPCHandlerObserver {
            val subscribeFuncName = "refreshAccountToken"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = RefreshAccountTokenReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun getUserInfoListForTest(handler: (GetUserInfoListForTestReqKt,
                parameter: RPCParameter?) -> GetUserInfoListForTestResKt?): RPCHandlerObserver {
            val subscribeFuncName = "getUserInfoListForTest"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetUserInfoListForTestReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun shareUser(handler: (ShareUserReqKt, parameter: RPCParameter?) -> ShareUserResKt?):
                RPCHandlerObserver {
            val subscribeFuncName = "shareUser"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = ShareUserReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun getUserInfoByShareId(handler: (GetUserInfoByShareIdReqKt, parameter: RPCParameter?) ->
                GetUserInfoByShareIdResKt?): RPCHandlerObserver {
            val subscribeFuncName = "getUserInfoByShareId"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = GetUserInfoByShareIdReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }

        fun searchUser(handler: (SearchUserReqKt, parameter: RPCParameter?) -> SearchUserResKt?):
                RPCHandlerObserver {
            val subscribeFuncName = "searchUser"
            val receiver: RPCNotifyReceiver = { _, functionName, data, parameter ->
                if (functionName == subscribeFuncName) {
                    val notify = SearchUserReq.parseFrom(data).convertToDataObject()
                    handler(notify, parameter)
                }
            }
            RPCApi.subscribe(serviceName, subscribeFuncName, receiver)
            return RPCHandlerObserver(serviceName, subscribeFuncName, receiver)
        }
    }
}
