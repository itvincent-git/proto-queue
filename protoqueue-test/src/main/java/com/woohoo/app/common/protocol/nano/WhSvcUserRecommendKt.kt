// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.woohoo.app.common.protocol.nano.WhSvcCommonKt.ResponseHeaderKt
import com.woohoo.app.common.protocol.nano.WhSvcUserRecommend.FaceBookRecommendUser
import com.woohoo.app.common.protocol.nano.WhSvcUserRecommend.GetRecommendUserReq
import com.woohoo.app.common.protocol.nano.WhSvcUserRecommend.GetRecommendUserRes
import com.woohoo.app.common.protocol.nano.WhSvcUserRecommend.NearByRecommendUser
import com.woohoo.app.common.protocol.nano.WhSvcUserRecommend.RecommendUserLocation
import com.woohoo.app.common.protocol.nano.WhSvcUserRecommend.ReportThirdFriendReq
import com.woohoo.app.common.protocol.nano.WhSvcUserRecommend.ReportThirdFriendRes
import com.woohoo.app.common.protocol.nano.WhSvcUserRecommend.ThirdFriend
import com.woohoo.app.common.protocol.nano.WhSvcUserRecommendKt.FaceBookRecommendUserKt
import com.woohoo.app.common.protocol.nano.WhSvcUserRecommendKt.GetRecommendUserReqKt
import com.woohoo.app.common.protocol.nano.WhSvcUserRecommendKt.GetRecommendUserResKt
import com.woohoo.app.common.protocol.nano.WhSvcUserRecommendKt.NearByRecommendUserKt
import com.woohoo.app.common.protocol.nano.WhSvcUserRecommendKt.RecommendUserLocationKt
import com.woohoo.app.common.protocol.nano.WhSvcUserRecommendKt.ReportThirdFriendReqKt
import com.woohoo.app.common.protocol.nano.WhSvcUserRecommendKt.ReportThirdFriendResKt
import com.woohoo.app.common.protocol.nano.WhSvcUserRecommendKt.ThirdFriendKt
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf

class WhSvcUserRecommendKt {
    class GetRecommendUserReqKt() {
        fun convertToMessage(): GetRecommendUserReq {
            val message = GetRecommendUserReq()
            return message
        }
    }

    class GetRecommendUserResKt(
        var header: ResponseHeaderKt? = null,
        var faceBookList: MutableList<FaceBookRecommendUserKt> = mutableListOf(),
        var nearByList: MutableList<NearByRecommendUserKt> = mutableListOf()
    ) {
        fun convertToMessage(): GetRecommendUserRes {
            val message = GetRecommendUserRes()
            message.header = header?.convertToMessage()
            message.faceBookList = faceBookList.map { it.convertToMessage() }.toTypedArray()
            message.nearByList = nearByList.map { it.convertToMessage() }.toTypedArray()
            return message
        }
    }

    class FaceBookRecommendUserKt(
        var uid: Long? = null
    ) {
        fun convertToMessage(): FaceBookRecommendUser {
            val message = FaceBookRecommendUser()
            message.uid = uid ?: 0L
            return message
        }
    }

    class NearByRecommendUserKt(
        var uid: Long? = null,
        var location: RecommendUserLocationKt? = null
    ) {
        fun convertToMessage(): NearByRecommendUser {
            val message = NearByRecommendUser()
            message.uid = uid ?: 0L
            message.location = location?.convertToMessage()
            return message
        }
    }

    class RecommendUserLocationKt(
        var distance: Double? = null,
        var city: String? = null
    ) {
        fun convertToMessage(): RecommendUserLocation {
            val message = RecommendUserLocation()
            message.distance = distance ?: 0.0
            message.city = city
            return message
        }
    }

    class ReportThirdFriendReqKt(
        var accountType: Int? = null,
        var thirdFriendList: MutableList<ThirdFriendKt> = mutableListOf()
    ) {
        fun convertToMessage(): ReportThirdFriendReq {
            val message = ReportThirdFriendReq()
            message.accountType = accountType ?: 0
            message.thirdFriendList = thirdFriendList.map { it.convertToMessage() }.toTypedArray()
            return message
        }
    }

    class ReportThirdFriendResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): ReportThirdFriendRes {
            val message = ReportThirdFriendRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class ThirdFriendKt(
        var openId: String? = null,
        var nick: String? = null,
        var avatar: String? = null,
        var sex: Int? = null
    ) {
        fun convertToMessage(): ThirdFriend {
            val message = ThirdFriend()
            message.openId = openId
            message.nick = nick
            message.avatar = avatar
            message.sex = sex ?: 0
            return message
        }
    }
}

fun GetRecommendUserReq.convertToDataObject(): GetRecommendUserReqKt {
    val o = GetRecommendUserReqKt()
    return o
}

fun GetRecommendUserRes.convertToDataObject(): GetRecommendUserResKt {
    val o = GetRecommendUserResKt()
    o.header = header?.convertToDataObject()
    o.faceBookList = faceBookList.mapTo(ArrayList(faceBookList.size)) { it.convertToDataObject() }
    o.nearByList = nearByList.mapTo(ArrayList(nearByList.size)) { it.convertToDataObject() }
    return o
}

fun FaceBookRecommendUser.convertToDataObject(): FaceBookRecommendUserKt {
    val o = FaceBookRecommendUserKt()
    o.uid = uid
    return o
}

fun NearByRecommendUser.convertToDataObject(): NearByRecommendUserKt {
    val o = NearByRecommendUserKt()
    o.uid = uid
    o.location = location?.convertToDataObject()
    return o
}

fun RecommendUserLocation.convertToDataObject(): RecommendUserLocationKt {
    val o = RecommendUserLocationKt()
    o.distance = distance
    o.city = city
    return o
}

fun ReportThirdFriendReq.convertToDataObject(): ReportThirdFriendReqKt {
    val o = ReportThirdFriendReqKt()
    o.accountType = accountType
    o.thirdFriendList = thirdFriendList.mapTo(ArrayList(thirdFriendList.size)) {
            it.convertToDataObject() }
    return o
}

fun ReportThirdFriendRes.convertToDataObject(): ReportThirdFriendResKt {
    val o = ReportThirdFriendResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun ThirdFriend.convertToDataObject(): ThirdFriendKt {
    val o = ThirdFriendKt()
    o.openId = openId
    o.nick = nick
    o.avatar = avatar
    o.sex = sex
    return o
}
