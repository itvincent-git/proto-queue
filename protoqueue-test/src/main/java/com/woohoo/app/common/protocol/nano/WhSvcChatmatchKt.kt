// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.AcceptInvitationNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.AcceptInvitationReq
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.AcceptInvitationRes
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.AcceptMatchReq
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.AcceptMatchRes
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.CancelInvitationNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.CancelInvitationReq
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.CancelInvitationRes
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.CancelMatchReq
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.CancelMatchRes
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.GetMatchConfigReq
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.GetMatchConfigRes
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.InviteUserReq
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.InviteUserRes
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.MatchHeartbeatReq
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.MatchHeartbeatRes
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.MatchReadyNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.ReInMatchingNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.RejectInvitationNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.RejectInvitationReq
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.RejectInvitationRes
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.RejectMatchReq
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.RejectMatchRes
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.StartMatchReq
import com.woohoo.app.common.protocol.nano.WhSvcChatmatch.StartMatchRes
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.AcceptInvitationNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.AcceptInvitationReqKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.AcceptInvitationResKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.AcceptMatchReqKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.AcceptMatchResKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.CancelInvitationNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.CancelInvitationReqKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.CancelInvitationResKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.CancelMatchReqKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.CancelMatchResKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.GetMatchConfigReqKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.GetMatchConfigResKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.InviteUserReqKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.InviteUserResKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.MatchHeartbeatReqKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.MatchHeartbeatResKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.MatchReadyNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.ReInMatchingNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.RejectInvitationNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.RejectInvitationReqKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.RejectInvitationResKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.RejectMatchReqKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.RejectMatchResKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.StartMatchReqKt
import com.woohoo.app.common.protocol.nano.WhSvcChatmatchKt.StartMatchResKt
import com.woohoo.app.common.protocol.nano.WhSvcCommonKt.ResponseHeaderKt
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf

class WhSvcChatmatchKt {
    class GetMatchConfigReqKt() {
        fun convertToMessage(): GetMatchConfigReq {
            val message = GetMatchConfigReq()
            return message
        }
    }

    class GetMatchConfigResKt(
        var header: ResponseHeaderKt? = null,
        var interval: Int? = null,
        var matchDelay: Int? = null,
        var acceptDuration: Int? = null,
        var tips: MutableList<String> = mutableListOf()
    ) {
        fun convertToMessage(): GetMatchConfigRes {
            val message = GetMatchConfigRes()
            message.header = header?.convertToMessage()
            message.interval = interval ?: 0
            message.matchDelay = matchDelay ?: 0
            message.acceptDuration = acceptDuration ?: 0
            message.tips = tips.toTypedArray()
            return message
        }
    }

    class StartMatchReqKt(
        var sex: Int? = null,
        var needSex: Int? = null,
        var firstLoginTime: Long? = null,
        var age: Int? = null,
        var latitude: Double? = null,
        var longitude: Double? = null
    ) {
        fun convertToMessage(): StartMatchReq {
            val message = StartMatchReq()
            message.sex = sex ?: 0
            message.needSex = needSex ?: 0
            message.firstLoginTime = firstLoginTime ?: 0L
            message.age = age ?: 0
            message.latitude = latitude ?: 0.0
            message.longitude = longitude ?: 0.0
            return message
        }
    }

    class StartMatchResKt(
        var header: ResponseHeaderKt? = null,
        var restrictedSeconds: Int? = null
    ) {
        fun convertToMessage(): StartMatchRes {
            val message = StartMatchRes()
            message.header = header?.convertToMessage()
            message.restrictedSeconds = restrictedSeconds ?: 0
            return message
        }
    }

    class MatchHeartbeatReqKt(
        var sex: Int? = null,
        var needSex: Int? = null,
        var firstLoginTime: Long? = null,
        var age: Int? = null,
        var latitude: Double? = null,
        var longitude: Double? = null
    ) {
        fun convertToMessage(): MatchHeartbeatReq {
            val message = MatchHeartbeatReq()
            message.sex = sex ?: 0
            message.needSex = needSex ?: 0
            message.firstLoginTime = firstLoginTime ?: 0L
            message.age = age ?: 0
            message.latitude = latitude ?: 0.0
            message.longitude = longitude ?: 0.0
            return message
        }
    }

    class MatchHeartbeatResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): MatchHeartbeatRes {
            val message = MatchHeartbeatRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class CancelMatchReqKt() {
        fun convertToMessage(): CancelMatchReq {
            val message = CancelMatchReq()
            return message
        }
    }

    class CancelMatchResKt(
        var header: ResponseHeaderKt? = null,
        var success: Boolean? = null
    ) {
        fun convertToMessage(): CancelMatchRes {
            val message = CancelMatchRes()
            message.header = header?.convertToMessage()
            message.success = success ?: false
            return message
        }
    }

    class MatchReadyNotifyInfoKt(
        var matchId: String? = null,
        var hisUid: Long? = null,
        var seqId: Long? = null
    ) {
        fun convertToMessage(): MatchReadyNotifyInfo {
            val message = MatchReadyNotifyInfo()
            message.matchId = matchId
            message.hisUid = hisUid ?: 0L
            message.seqId = seqId ?: 0L
            return message
        }
    }

    class AcceptMatchReqKt(
        var matchId: String? = null
    ) {
        fun convertToMessage(): AcceptMatchReq {
            val message = AcceptMatchReq()
            message.matchId = matchId
            return message
        }
    }

    class AcceptMatchResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): AcceptMatchRes {
            val message = AcceptMatchRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class RejectMatchReqKt(
        var matchId: String? = null,
        var reInQueue: Boolean? = null,
        var notBlacklist: Boolean? = null
    ) {
        fun convertToMessage(): RejectMatchReq {
            val message = RejectMatchReq()
            message.matchId = matchId
            message.reInQueue = reInQueue ?: false
            message.notBlacklist = notBlacklist ?: false
            return message
        }
    }

    class RejectMatchResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): RejectMatchRes {
            val message = RejectMatchRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class ReInMatchingNotifyInfoKt(
        var uid: Long? = null,
        var seqId: Long? = null
    ) {
        fun convertToMessage(): ReInMatchingNotifyInfo {
            val message = ReInMatchingNotifyInfo()
            message.uid = uid ?: 0L
            message.seqId = seqId ?: 0L
            return message
        }
    }

    class InviteUserReqKt(
        var invitee: Long? = null
    ) {
        fun convertToMessage(): InviteUserReq {
            val message = InviteUserReq()
            message.invitee = invitee ?: 0L
            return message
        }
    }

    class InviteUserResKt(
        var header: ResponseHeaderKt? = null,
        var invitationId: String? = null,
        var expireTimestamp: Long? = null
    ) {
        fun convertToMessage(): InviteUserRes {
            val message = InviteUserRes()
            message.header = header?.convertToMessage()
            message.invitationId = invitationId
            message.expireTimestamp = expireTimestamp ?: 0L
            return message
        }
    }

    class AcceptInvitationReqKt(
        var invitationId: String? = null
    ) {
        fun convertToMessage(): AcceptInvitationReq {
            val message = AcceptInvitationReq()
            message.invitationId = invitationId
            return message
        }
    }

    class AcceptInvitationResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): AcceptInvitationRes {
            val message = AcceptInvitationRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class RejectInvitationReqKt(
        var invitationId: String? = null
    ) {
        fun convertToMessage(): RejectInvitationReq {
            val message = RejectInvitationReq()
            message.invitationId = invitationId
            return message
        }
    }

    class RejectInvitationResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): RejectInvitationRes {
            val message = RejectInvitationRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class CancelInvitationNotifyInfoKt(
        var invitationId: String? = null,
        var inviter: Long? = null
    ) {
        fun convertToMessage(): CancelInvitationNotifyInfo {
            val message = CancelInvitationNotifyInfo()
            message.invitationId = invitationId
            message.inviter = inviter ?: 0L
            return message
        }
    }

    class RejectInvitationNotifyInfoKt(
        var invitationId: String? = null,
        var invitee: Long? = null
    ) {
        fun convertToMessage(): RejectInvitationNotifyInfo {
            val message = RejectInvitationNotifyInfo()
            message.invitationId = invitationId
            message.invitee = invitee ?: 0L
            return message
        }
    }

    class AcceptInvitationNotifyInfoKt(
        var invitationId: String? = null,
        var invitee: Long? = null
    ) {
        fun convertToMessage(): AcceptInvitationNotifyInfo {
            val message = AcceptInvitationNotifyInfo()
            message.invitationId = invitationId
            message.invitee = invitee ?: 0L
            return message
        }
    }

    class CancelInvitationReqKt(
        var invitationId: String? = null
    ) {
        fun convertToMessage(): CancelInvitationReq {
            val message = CancelInvitationReq()
            message.invitationId = invitationId
            return message
        }
    }

    class CancelInvitationResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): CancelInvitationRes {
            val message = CancelInvitationRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    interface NeedSexKt {
        companion object {
            val Whatever: Int = 0

            val NeedFemale: Int = 1

            val NeedMale: Int = 2
        }
    }
}

fun GetMatchConfigReq.convertToDataObject(): GetMatchConfigReqKt {
    val o = GetMatchConfigReqKt()
    return o
}

fun GetMatchConfigRes.convertToDataObject(): GetMatchConfigResKt {
    val o = GetMatchConfigResKt()
    o.header = header?.convertToDataObject()
    o.interval = interval
    o.matchDelay = matchDelay
    o.acceptDuration = acceptDuration
    o.tips = tips.toMutableList()
    return o
}

fun StartMatchReq.convertToDataObject(): StartMatchReqKt {
    val o = StartMatchReqKt()
    o.sex = sex
    o.needSex = needSex
    o.firstLoginTime = firstLoginTime
    o.age = age
    o.latitude = latitude
    o.longitude = longitude
    return o
}

fun StartMatchRes.convertToDataObject(): StartMatchResKt {
    val o = StartMatchResKt()
    o.header = header?.convertToDataObject()
    o.restrictedSeconds = restrictedSeconds
    return o
}

fun MatchHeartbeatReq.convertToDataObject(): MatchHeartbeatReqKt {
    val o = MatchHeartbeatReqKt()
    o.sex = sex
    o.needSex = needSex
    o.firstLoginTime = firstLoginTime
    o.age = age
    o.latitude = latitude
    o.longitude = longitude
    return o
}

fun MatchHeartbeatRes.convertToDataObject(): MatchHeartbeatResKt {
    val o = MatchHeartbeatResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun CancelMatchReq.convertToDataObject(): CancelMatchReqKt {
    val o = CancelMatchReqKt()
    return o
}

fun CancelMatchRes.convertToDataObject(): CancelMatchResKt {
    val o = CancelMatchResKt()
    o.header = header?.convertToDataObject()
    o.success = success
    return o
}

fun MatchReadyNotifyInfo.convertToDataObject(): MatchReadyNotifyInfoKt {
    val o = MatchReadyNotifyInfoKt()
    o.matchId = matchId
    o.hisUid = hisUid
    o.seqId = seqId
    return o
}

fun AcceptMatchReq.convertToDataObject(): AcceptMatchReqKt {
    val o = AcceptMatchReqKt()
    o.matchId = matchId
    return o
}

fun AcceptMatchRes.convertToDataObject(): AcceptMatchResKt {
    val o = AcceptMatchResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun RejectMatchReq.convertToDataObject(): RejectMatchReqKt {
    val o = RejectMatchReqKt()
    o.matchId = matchId
    o.reInQueue = reInQueue
    o.notBlacklist = notBlacklist
    return o
}

fun RejectMatchRes.convertToDataObject(): RejectMatchResKt {
    val o = RejectMatchResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun ReInMatchingNotifyInfo.convertToDataObject(): ReInMatchingNotifyInfoKt {
    val o = ReInMatchingNotifyInfoKt()
    o.uid = uid
    o.seqId = seqId
    return o
}

fun InviteUserReq.convertToDataObject(): InviteUserReqKt {
    val o = InviteUserReqKt()
    o.invitee = invitee
    return o
}

fun InviteUserRes.convertToDataObject(): InviteUserResKt {
    val o = InviteUserResKt()
    o.header = header?.convertToDataObject()
    o.invitationId = invitationId
    o.expireTimestamp = expireTimestamp
    return o
}

fun AcceptInvitationReq.convertToDataObject(): AcceptInvitationReqKt {
    val o = AcceptInvitationReqKt()
    o.invitationId = invitationId
    return o
}

fun AcceptInvitationRes.convertToDataObject(): AcceptInvitationResKt {
    val o = AcceptInvitationResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun RejectInvitationReq.convertToDataObject(): RejectInvitationReqKt {
    val o = RejectInvitationReqKt()
    o.invitationId = invitationId
    return o
}

fun RejectInvitationRes.convertToDataObject(): RejectInvitationResKt {
    val o = RejectInvitationResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun CancelInvitationNotifyInfo.convertToDataObject(): CancelInvitationNotifyInfoKt {
    val o = CancelInvitationNotifyInfoKt()
    o.invitationId = invitationId
    o.inviter = inviter
    return o
}

fun RejectInvitationNotifyInfo.convertToDataObject(): RejectInvitationNotifyInfoKt {
    val o = RejectInvitationNotifyInfoKt()
    o.invitationId = invitationId
    o.invitee = invitee
    return o
}

fun AcceptInvitationNotifyInfo.convertToDataObject(): AcceptInvitationNotifyInfoKt {
    val o = AcceptInvitationNotifyInfoKt()
    o.invitationId = invitationId
    o.invitee = invitee
    return o
}

fun CancelInvitationReq.convertToDataObject(): CancelInvitationReqKt {
    val o = CancelInvitationReqKt()
    o.invitationId = invitationId
    return o
}

fun CancelInvitationRes.convertToDataObject(): CancelInvitationResKt {
    val o = CancelInvitationResKt()
    o.header = header?.convertToDataObject()
    return o
}
