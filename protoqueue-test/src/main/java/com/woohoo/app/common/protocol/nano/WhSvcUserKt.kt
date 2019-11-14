// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.woohoo.app.common.protocol.nano.WhSvcCommonKt.ResponseHeaderKt
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
import com.woohoo.app.common.protocol.nano.WhSvcUser.UserAccount
import com.woohoo.app.common.protocol.nano.WhSvcUser.UserBindAccountReq
import com.woohoo.app.common.protocol.nano.WhSvcUser.UserBindAccountRes
import com.woohoo.app.common.protocol.nano.WhSvcUser.UserFreezeInfo
import com.woohoo.app.common.protocol.nano.WhSvcUser.UserFreezeNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcUser.UserInfo
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
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.UserAccountKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.UserBindAccountReqKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.UserBindAccountResKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.UserFreezeInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.UserFreezeNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.UserInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.UserLoginReqKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.UserLoginResKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.UserUnBindAccountReqKt
import com.woohoo.app.common.protocol.nano.WhSvcUserKt.UserUnBindAccountResKt
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf

class WhSvcUserKt {
    class UserFreezeNotifyInfoKt(
        var freezeInfo: UserFreezeInfoKt? = null
    ) {
        fun convertToMessage(): UserFreezeNotifyInfo {
            val message = UserFreezeNotifyInfo()
            message.freezeInfo = freezeInfo?.convertToMessage()
            return message
        }
    }

    class UserFreezeInfoKt(
        var freezeUnixTimestamp: Long? = null,
        var reason: String? = null
    ) {
        fun convertToMessage(): UserFreezeInfo {
            val message = UserFreezeInfo()
            message.freezeUnixTimestamp = freezeUnixTimestamp ?: 0L
            message.reason = reason
            return message
        }
    }

    class UserLoginReqKt() {
        fun convertToMessage(): UserLoginReq {
            val message = UserLoginReq()
            return message
        }
    }

    class UserLoginResKt(
        var header: ResponseHeaderKt? = null,
        var firstLoginTime: Long? = null,
        var isFirstLogin: Boolean? = null,
        var userInfo: UserInfoKt? = null,
        var freezeInfo: UserFreezeInfoKt? = null
    ) {
        fun convertToMessage(): UserLoginRes {
            val message = UserLoginRes()
            message.header = header?.convertToMessage()
            message.firstLoginTime = firstLoginTime ?: 0L
            message.isFirstLogin = isFirstLogin ?: false
            message.userInfo = userInfo?.convertToMessage()
            message.freezeInfo = freezeInfo?.convertToMessage()
            return message
        }
    }

    class UpdateUserInfoReqKt(
        var userInfo: UserInfoKt? = null
    ) {
        fun convertToMessage(): UpdateUserInfoReq {
            val message = UpdateUserInfoReq()
            message.userInfo = userInfo?.convertToMessage()
            return message
        }
    }

    class UpdateUserInfoResKt(
        var header: ResponseHeaderKt? = null,
        var userInfo: UserInfoKt? = null
    ) {
        fun convertToMessage(): UpdateUserInfoRes {
            val message = UpdateUserInfoRes()
            message.header = header?.convertToMessage()
            message.userInfo = userInfo?.convertToMessage()
            return message
        }
    }

    class UserInfoKt(
        var uid: Long? = null,
        var vid: Long? = null,
        var nick: String? = null,
        var avatar: String? = null,
        var sex: Int? = null,
        var intro: String? = null,
        var birthday: Long? = null,
        var voiceUrl: String? = null,
        var city: String? = null,
        var country: String? = null,
        var constellation: Int? = null
    ) {
        fun convertToMessage(): UserInfo {
            val message = UserInfo()
            message.uid = uid ?: 0L
            message.vid = vid ?: 0L
            message.nick = nick
            message.avatar = avatar
            message.sex = sex ?: 0
            message.intro = intro
            message.birthday = birthday ?: 0L
            message.voiceUrl = voiceUrl
            message.city = city
            message.country = country
            message.constellation = constellation ?: 0
            return message
        }
    }

    class SavePhotoListReqKt(
        var photoList: MutableList<String> = mutableListOf()
    ) {
        fun convertToMessage(): SavePhotoListReq {
            val message = SavePhotoListReq()
            message.photoList = photoList.toTypedArray()
            return message
        }
    }

    class SavePhotoListResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): SavePhotoListRes {
            val message = SavePhotoListRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class GetUserPersonalCardReqKt(
        var uid: Long? = null
    ) {
        fun convertToMessage(): GetUserPersonalCardReq {
            val message = GetUserPersonalCardReq()
            message.uid = uid ?: 0L
            return message
        }
    }

    class GetUserPersonalCardResKt(
        var header: ResponseHeaderKt? = null,
        var userInfo: UserInfoKt? = null,
        var photoUrl: MutableList<String> = mutableListOf()
    ) {
        fun convertToMessage(): GetUserPersonalCardRes {
            val message = GetUserPersonalCardRes()
            message.header = header?.convertToMessage()
            message.userInfo = userInfo?.convertToMessage()
            message.photoUrl = photoUrl.toTypedArray()
            return message
        }
    }

    class GetUserInfoReqKt(
        var uidList: MutableList<Long> = mutableListOf()
    ) {
        fun convertToMessage(): GetUserInfoReq {
            val message = GetUserInfoReq()
            message.uidList = uidList.toLongArray()
            return message
        }
    }

    class GetUserInfoResKt(
        var header: ResponseHeaderKt? = null,
        var userInfoList: MutableList<UserInfoKt> = mutableListOf()
    ) {
        fun convertToMessage(): GetUserInfoRes {
            val message = GetUserInfoRes()
            message.header = header?.convertToMessage()
            message.userInfoList = userInfoList.map { it.convertToMessage() }.toTypedArray()
            return message
        }
    }

    class UserAccountKt(
        var accountType: Int? = null,
        var openId: String? = null,
        var token: String? = null
    ) {
        fun convertToMessage(): UserAccount {
            val message = UserAccount()
            message.accountType = accountType ?: 0
            message.openId = openId
            message.token = token
            return message
        }
    }

    class UserBindAccountReqKt(
        var account: UserAccountKt? = null
    ) {
        fun convertToMessage(): UserBindAccountReq {
            val message = UserBindAccountReq()
            message.account = account?.convertToMessage()
            return message
        }
    }

    class UserBindAccountResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): UserBindAccountRes {
            val message = UserBindAccountRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class RefreshAccountTokenReqKt(
        var account: UserAccountKt? = null
    ) {
        fun convertToMessage(): RefreshAccountTokenReq {
            val message = RefreshAccountTokenReq()
            message.account = account?.convertToMessage()
            return message
        }
    }

    class RefreshAccountTokenResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): RefreshAccountTokenRes {
            val message = RefreshAccountTokenRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class UserUnBindAccountReqKt(
        var accountType: Int? = null
    ) {
        fun convertToMessage(): UserUnBindAccountReq {
            val message = UserUnBindAccountReq()
            message.accountType = accountType ?: 0
            return message
        }
    }

    class UserUnBindAccountResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): UserUnBindAccountRes {
            val message = UserUnBindAccountRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class GetUserAccountReqKt(
        var queryAccountType: MutableList<Int> = mutableListOf(),
        var loginAccount: UserAccountKt? = null
    ) {
        fun convertToMessage(): GetUserAccountReq {
            val message = GetUserAccountReq()
            message.queryAccountType = queryAccountType.toIntArray()
            message.loginAccount = loginAccount?.convertToMessage()
            return message
        }
    }

    class GetUserAccountResKt(
        var header: ResponseHeaderKt? = null,
        var accountList: MutableList<UserAccountKt> = mutableListOf()
    ) {
        fun convertToMessage(): GetUserAccountRes {
            val message = GetUserAccountRes()
            message.header = header?.convertToMessage()
            message.accountList = accountList.map { it.convertToMessage() }.toTypedArray()
            return message
        }
    }

    class GetUserInfoListForTestReqKt() {
        fun convertToMessage(): GetUserInfoListForTestReq {
            val message = GetUserInfoListForTestReq()
            return message
        }
    }

    class GetUserInfoListForTestResKt(
        var header: ResponseHeaderKt? = null,
        var userInfoList: MutableList<UserInfoKt> = mutableListOf()
    ) {
        fun convertToMessage(): GetUserInfoListForTestRes {
            val message = GetUserInfoListForTestRes()
            message.header = header?.convertToMessage()
            message.userInfoList = userInfoList.map { it.convertToMessage() }.toTypedArray()
            return message
        }
    }

    class ShareUserReqKt() {
        fun convertToMessage(): ShareUserReq {
            val message = ShareUserReq()
            return message
        }
    }

    class ShareUserResKt(
        var header: ResponseHeaderKt? = null,
        var shareId: String? = null
    ) {
        fun convertToMessage(): ShareUserRes {
            val message = ShareUserRes()
            message.header = header?.convertToMessage()
            message.shareId = shareId
            return message
        }
    }

    class GetUserInfoByShareIdReqKt(
        var shareId: String? = null
    ) {
        fun convertToMessage(): GetUserInfoByShareIdReq {
            val message = GetUserInfoByShareIdReq()
            message.shareId = shareId
            return message
        }
    }

    class GetUserInfoByShareIdResKt(
        var header: ResponseHeaderKt? = null,
        var userInfo: UserInfoKt? = null
    ) {
        fun convertToMessage(): GetUserInfoByShareIdRes {
            val message = GetUserInfoByShareIdRes()
            message.header = header?.convertToMessage()
            message.userInfo = userInfo?.convertToMessage()
            return message
        }
    }

    class SearchUserReqKt(
        var keyword: String? = null
    ) {
        fun convertToMessage(): SearchUserReq {
            val message = SearchUserReq()
            message.keyword = keyword
            return message
        }
    }

    class SearchUserResKt(
        var uidList: MutableList<Long> = mutableListOf()
    ) {
        fun convertToMessage(): SearchUserRes {
            val message = SearchUserRes()
            message.uidList = uidList.toLongArray()
            return message
        }
    }

    interface ConstellationKt {
        companion object {
            val ConstellationUnknown: Int = 0

            val Aquarius: Int = 1

            val Pisces: Int = 2

            val Aries: Int = 3

            val Taurus: Int = 4

            val Gemini: Int = 5

            val Cancer: Int = 6

            val Leo: Int = 7

            val Virgo: Int = 8

            val Libra: Int = 9

            val Scorpio: Int = 10

            val Sagittarius: Int = 11

            val Capricorn: Int = 12
        }
    }
}

fun UserFreezeNotifyInfo.convertToDataObject(): UserFreezeNotifyInfoKt {
    val o = UserFreezeNotifyInfoKt()
    o.freezeInfo = freezeInfo?.convertToDataObject()
    return o
}

fun UserFreezeInfo.convertToDataObject(): UserFreezeInfoKt {
    val o = UserFreezeInfoKt()
    o.freezeUnixTimestamp = freezeUnixTimestamp
    o.reason = reason
    return o
}

fun UserLoginReq.convertToDataObject(): UserLoginReqKt {
    val o = UserLoginReqKt()
    return o
}

fun UserLoginRes.convertToDataObject(): UserLoginResKt {
    val o = UserLoginResKt()
    o.header = header?.convertToDataObject()
    o.firstLoginTime = firstLoginTime
    o.isFirstLogin = isFirstLogin
    o.userInfo = userInfo?.convertToDataObject()
    o.freezeInfo = freezeInfo?.convertToDataObject()
    return o
}

fun UpdateUserInfoReq.convertToDataObject(): UpdateUserInfoReqKt {
    val o = UpdateUserInfoReqKt()
    o.userInfo = userInfo?.convertToDataObject()
    return o
}

fun UpdateUserInfoRes.convertToDataObject(): UpdateUserInfoResKt {
    val o = UpdateUserInfoResKt()
    o.header = header?.convertToDataObject()
    o.userInfo = userInfo?.convertToDataObject()
    return o
}

fun UserInfo.convertToDataObject(): UserInfoKt {
    val o = UserInfoKt()
    o.uid = uid
    o.vid = vid
    o.nick = nick
    o.avatar = avatar
    o.sex = sex
    o.intro = intro
    o.birthday = birthday
    o.voiceUrl = voiceUrl
    o.city = city
    o.country = country
    o.constellation = constellation
    return o
}

fun SavePhotoListReq.convertToDataObject(): SavePhotoListReqKt {
    val o = SavePhotoListReqKt()
    o.photoList = photoList.toMutableList()
    return o
}

fun SavePhotoListRes.convertToDataObject(): SavePhotoListResKt {
    val o = SavePhotoListResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun GetUserPersonalCardReq.convertToDataObject(): GetUserPersonalCardReqKt {
    val o = GetUserPersonalCardReqKt()
    o.uid = uid
    return o
}

fun GetUserPersonalCardRes.convertToDataObject(): GetUserPersonalCardResKt {
    val o = GetUserPersonalCardResKt()
    o.header = header?.convertToDataObject()
    o.userInfo = userInfo?.convertToDataObject()
    o.photoUrl = photoUrl.toMutableList()
    return o
}

fun GetUserInfoReq.convertToDataObject(): GetUserInfoReqKt {
    val o = GetUserInfoReqKt()
    o.uidList = uidList.toMutableList()
    return o
}

fun GetUserInfoRes.convertToDataObject(): GetUserInfoResKt {
    val o = GetUserInfoResKt()
    o.header = header?.convertToDataObject()
    o.userInfoList = userInfoList.mapTo(ArrayList(userInfoList.size)) { it.convertToDataObject() }
    return o
}

fun UserAccount.convertToDataObject(): UserAccountKt {
    val o = UserAccountKt()
    o.accountType = accountType
    o.openId = openId
    o.token = token
    return o
}

fun UserBindAccountReq.convertToDataObject(): UserBindAccountReqKt {
    val o = UserBindAccountReqKt()
    o.account = account?.convertToDataObject()
    return o
}

fun UserBindAccountRes.convertToDataObject(): UserBindAccountResKt {
    val o = UserBindAccountResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun RefreshAccountTokenReq.convertToDataObject(): RefreshAccountTokenReqKt {
    val o = RefreshAccountTokenReqKt()
    o.account = account?.convertToDataObject()
    return o
}

fun RefreshAccountTokenRes.convertToDataObject(): RefreshAccountTokenResKt {
    val o = RefreshAccountTokenResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun UserUnBindAccountReq.convertToDataObject(): UserUnBindAccountReqKt {
    val o = UserUnBindAccountReqKt()
    o.accountType = accountType
    return o
}

fun UserUnBindAccountRes.convertToDataObject(): UserUnBindAccountResKt {
    val o = UserUnBindAccountResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun GetUserAccountReq.convertToDataObject(): GetUserAccountReqKt {
    val o = GetUserAccountReqKt()
    o.queryAccountType = queryAccountType.toMutableList()
    o.loginAccount = loginAccount?.convertToDataObject()
    return o
}

fun GetUserAccountRes.convertToDataObject(): GetUserAccountResKt {
    val o = GetUserAccountResKt()
    o.header = header?.convertToDataObject()
    o.accountList = accountList.mapTo(ArrayList(accountList.size)) { it.convertToDataObject() }
    return o
}

fun GetUserInfoListForTestReq.convertToDataObject(): GetUserInfoListForTestReqKt {
    val o = GetUserInfoListForTestReqKt()
    return o
}

fun GetUserInfoListForTestRes.convertToDataObject(): GetUserInfoListForTestResKt {
    val o = GetUserInfoListForTestResKt()
    o.header = header?.convertToDataObject()
    o.userInfoList = userInfoList.mapTo(ArrayList(userInfoList.size)) { it.convertToDataObject() }
    return o
}

fun ShareUserReq.convertToDataObject(): ShareUserReqKt {
    val o = ShareUserReqKt()
    return o
}

fun ShareUserRes.convertToDataObject(): ShareUserResKt {
    val o = ShareUserResKt()
    o.header = header?.convertToDataObject()
    o.shareId = shareId
    return o
}

fun GetUserInfoByShareIdReq.convertToDataObject(): GetUserInfoByShareIdReqKt {
    val o = GetUserInfoByShareIdReqKt()
    o.shareId = shareId
    return o
}

fun GetUserInfoByShareIdRes.convertToDataObject(): GetUserInfoByShareIdResKt {
    val o = GetUserInfoByShareIdResKt()
    o.header = header?.convertToDataObject()
    o.userInfo = userInfo?.convertToDataObject()
    return o
}

fun SearchUserReq.convertToDataObject(): SearchUserReqKt {
    val o = SearchUserReqKt()
    o.keyword = keyword
    return o
}

fun SearchUserRes.convertToDataObject(): SearchUserResKt {
    val o = SearchUserResKt()
    o.uidList = uidList.toMutableList()
    return o
}
