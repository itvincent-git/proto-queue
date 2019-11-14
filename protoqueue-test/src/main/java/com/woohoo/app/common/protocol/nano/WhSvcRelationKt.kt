// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.woohoo.app.common.protocol.nano.WhSvcCommonKt.ResponseHeaderKt
import com.woohoo.app.common.protocol.nano.WhSvcRelation.BlackInfo
import com.woohoo.app.common.protocol.nano.WhSvcRelation.ChangeBlackListReq
import com.woohoo.app.common.protocol.nano.WhSvcRelation.ChangeBlackListRes
import com.woohoo.app.common.protocol.nano.WhSvcRelation.CheckRelationReq
import com.woohoo.app.common.protocol.nano.WhSvcRelation.CheckRelationRes
import com.woohoo.app.common.protocol.nano.WhSvcRelation.FansInfo
import com.woohoo.app.common.protocol.nano.WhSvcRelation.FollowInfo
import com.woohoo.app.common.protocol.nano.WhSvcRelation.FollowOpReq
import com.woohoo.app.common.protocol.nano.WhSvcRelation.FollowOpRes
import com.woohoo.app.common.protocol.nano.WhSvcRelation.FriendInfo
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
import com.woohoo.app.common.protocol.nano.WhSvcRelation.RelationChangeMsg
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.BlackInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.ChangeBlackListReqKt
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.ChangeBlackListResKt
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.CheckRelationReqKt
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.CheckRelationResKt
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.FansInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.FollowInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.FollowOpReqKt
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.FollowOpResKt
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.FriendInfoKt
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
import com.woohoo.app.common.protocol.nano.WhSvcRelationKt.RelationChangeMsgKt
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf

class WhSvcRelationKt {
    class FansInfoKt(
        var uid: Long? = null
    ) {
        fun convertToMessage(): FansInfo {
            val message = FansInfo()
            message.uid = uid ?: 0L
            return message
        }
    }

    class FollowInfoKt(
        var uid: Long? = null
    ) {
        fun convertToMessage(): FollowInfo {
            val message = FollowInfo()
            message.uid = uid ?: 0L
            return message
        }
    }

    class FriendInfoKt(
        var uid: Long? = null
    ) {
        fun convertToMessage(): FriendInfo {
            val message = FriendInfo()
            message.uid = uid ?: 0L
            return message
        }
    }

    class BlackInfoKt(
        var uid: Long? = null,
        var addTime: Long? = null
    ) {
        fun convertToMessage(): BlackInfo {
            val message = BlackInfo()
            message.uid = uid ?: 0L
            message.addTime = addTime ?: 0L
            return message
        }
    }

    class FollowOpReqKt(
        var targetUid: Long? = null,
        var followSource: Int? = null,
        var opType: Int? = null
    ) {
        fun convertToMessage(): FollowOpReq {
            val message = FollowOpReq()
            message.targetUid = targetUid ?: 0L
            message.followSource = followSource ?: 0
            message.opType = opType ?: 0
            return message
        }
    }

    class FollowOpResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): FollowOpRes {
            val message = FollowOpRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class GetFansListReqKt(
        var targetUid: Long? = null,
        var lastId: String? = null,
        var limit: Int? = null
    ) {
        fun convertToMessage(): GetFansListReq {
            val message = GetFansListReq()
            message.targetUid = targetUid ?: 0L
            message.lastId = lastId
            message.limit = limit ?: 0
            return message
        }
    }

    class GetFansListResKt(
        var header: ResponseHeaderKt? = null,
        var lastId: String? = null,
        var fansInfos: MutableList<FansInfoKt> = mutableListOf()
    ) {
        fun convertToMessage(): GetFansListRes {
            val message = GetFansListRes()
            message.header = header?.convertToMessage()
            message.lastId = lastId
            message.fansInfos = fansInfos.map { it.convertToMessage() }.toTypedArray()
            return message
        }
    }

    class GetFollowListReqKt(
        var targetUid: Long? = null,
        var lastId: String? = null,
        var limit: Int? = null
    ) {
        fun convertToMessage(): GetFollowListReq {
            val message = GetFollowListReq()
            message.targetUid = targetUid ?: 0L
            message.lastId = lastId
            message.limit = limit ?: 0
            return message
        }
    }

    class GetFollowListResKt(
        var header: ResponseHeaderKt? = null,
        var lastId: String? = null,
        var followInfos: MutableList<FollowInfoKt> = mutableListOf()
    ) {
        fun convertToMessage(): GetFollowListRes {
            val message = GetFollowListRes()
            message.header = header?.convertToMessage()
            message.lastId = lastId
            message.followInfos = followInfos.map { it.convertToMessage() }.toTypedArray()
            return message
        }
    }

    class GetFriendListReqKt(
        var targetUid: Long? = null,
        var lastId: String? = null,
        var limit: Int? = null
    ) {
        fun convertToMessage(): GetFriendListReq {
            val message = GetFriendListReq()
            message.targetUid = targetUid ?: 0L
            message.lastId = lastId
            message.limit = limit ?: 0
            return message
        }
    }

    class GetFriendListResKt(
        var header: ResponseHeaderKt? = null,
        var lastId: String? = null,
        var friendInfos: MutableList<FriendInfoKt> = mutableListOf()
    ) {
        fun convertToMessage(): GetFriendListRes {
            val message = GetFriendListRes()
            message.header = header?.convertToMessage()
            message.lastId = lastId
            message.friendInfos = friendInfos.map { it.convertToMessage() }.toTypedArray()
            return message
        }
    }

    class GetRelationCountReqKt(
        var targetUid: Long? = null
    ) {
        fun convertToMessage(): GetRelationCountReq {
            val message = GetRelationCountReq()
            message.targetUid = targetUid ?: 0L
            return message
        }
    }

    class GetRelationCountResKt(
        var header: ResponseHeaderKt? = null,
        var fansNum: Long? = null,
        var followNum: Long? = null,
        var friendNum: Long? = null
    ) {
        fun convertToMessage(): GetRelationCountRes {
            val message = GetRelationCountRes()
            message.header = header?.convertToMessage()
            message.fansNum = fansNum ?: 0L
            message.followNum = followNum ?: 0L
            message.friendNum = friendNum ?: 0L
            return message
        }
    }

    class ChangeBlackListReqKt(
        var targetUid: Long? = null,
        var opType: Int? = null
    ) {
        fun convertToMessage(): ChangeBlackListReq {
            val message = ChangeBlackListReq()
            message.targetUid = targetUid ?: 0L
            message.opType = opType ?: 0
            return message
        }
    }

    class ChangeBlackListResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): ChangeBlackListRes {
            val message = ChangeBlackListRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class GetBlackListReqKt(
        var targetUid: Long? = null,
        var lastId: String? = null,
        var limit: Int? = null
    ) {
        fun convertToMessage(): GetBlackListReq {
            val message = GetBlackListReq()
            message.targetUid = targetUid ?: 0L
            message.lastId = lastId
            message.limit = limit ?: 0
            return message
        }
    }

    class GetBlackListResKt(
        var header: ResponseHeaderKt? = null,
        var lastId: String? = null,
        var blackInfos: MutableList<BlackInfoKt> = mutableListOf()
    ) {
        fun convertToMessage(): GetBlackListRes {
            val message = GetBlackListRes()
            message.header = header?.convertToMessage()
            message.lastId = lastId
            message.blackInfos = blackInfos.map { it.convertToMessage() }.toTypedArray()
            return message
        }
    }

    class CheckRelationReqKt(
        var targetUid: Long? = null,
        var checkFollow: Boolean? = null,
        var checkFans: Boolean? = null,
        var checkFriend: Boolean? = null,
        var checkBlackList: Boolean? = null
    ) {
        fun convertToMessage(): CheckRelationReq {
            val message = CheckRelationReq()
            message.targetUid = targetUid ?: 0L
            message.checkFollow = checkFollow ?: false
            message.checkFans = checkFans ?: false
            message.checkFriend = checkFriend ?: false
            message.checkBlackList = checkBlackList ?: false
            return message
        }
    }

    class CheckRelationResKt(
        var header: ResponseHeaderKt? = null,
        var follow: Boolean? = null,
        var fans: Boolean? = null,
        var friend: Boolean? = null,
        var blackList: Boolean? = null
    ) {
        fun convertToMessage(): CheckRelationRes {
            val message = CheckRelationRes()
            message.header = header?.convertToMessage()
            message.follow = follow ?: false
            message.fans = fans ?: false
            message.friend = friend ?: false
            message.blackList = blackList ?: false
            return message
        }
    }

    class GreetReqKt(
        var targetUid: Long? = null
    ) {
        fun convertToMessage(): GreetReq {
            val message = GreetReq()
            message.targetUid = targetUid ?: 0L
            return message
        }
    }

    class GreetResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): GreetRes {
            val message = GreetRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class RelationChangeMsgKt(
        var srcUid: Long? = null,
        var followSource: Int? = null,
        var changeType: Int? = null
    ) {
        fun convertToMessage(): RelationChangeMsg {
            val message = RelationChangeMsg()
            message.srcUid = srcUid ?: 0L
            message.followSource = followSource ?: 0
            message.changeType = changeType ?: 0
            return message
        }
    }

    interface FollowSourceKt {
        companion object {
            val SourceUnknown: Int = 0

            val Profile: Int = 1

            val MinProfileCard: Int = 2

            val IM: Int = 3

            val Recommend: Int = 4

            val AutoFollow: Int = 5

            val PartyRoom: Int = 6
        }
    }

    interface FollowOpTypeKt {
        companion object {
            val FollowOpUnknown: Int = 0

            val OpFollow: Int = 1

            val OpUnFollow: Int = 2
        }
    }

    interface BlackOpTypeKt {
        companion object {
            val BlackOpUnknown: Int = 0

            val Add: Int = 1

            val Remove: Int = 2
        }
    }

    interface RelationTypeKt {
        companion object {
            val RelationUnknown: Int = 0

            val Fans: Int = 1

            val Follow: Int = 2

            val Friend: Int = 3

            val BlackList: Int = 4
        }
    }

    interface RelationChangeTypeKt {
        companion object {
            val OpUnknown: Int = 0

            val OpBeFollowed: Int = 1

            val OpRemoveFollow: Int = 2

            val OpBeFriend: Int = 3

            val OpRemoveFriend: Int = 4
        }
    }
}

fun FansInfo.convertToDataObject(): FansInfoKt {
    val o = FansInfoKt()
    o.uid = uid
    return o
}

fun FollowInfo.convertToDataObject(): FollowInfoKt {
    val o = FollowInfoKt()
    o.uid = uid
    return o
}

fun FriendInfo.convertToDataObject(): FriendInfoKt {
    val o = FriendInfoKt()
    o.uid = uid
    return o
}

fun BlackInfo.convertToDataObject(): BlackInfoKt {
    val o = BlackInfoKt()
    o.uid = uid
    o.addTime = addTime
    return o
}

fun FollowOpReq.convertToDataObject(): FollowOpReqKt {
    val o = FollowOpReqKt()
    o.targetUid = targetUid
    o.followSource = followSource
    o.opType = opType
    return o
}

fun FollowOpRes.convertToDataObject(): FollowOpResKt {
    val o = FollowOpResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun GetFansListReq.convertToDataObject(): GetFansListReqKt {
    val o = GetFansListReqKt()
    o.targetUid = targetUid
    o.lastId = lastId
    o.limit = limit
    return o
}

fun GetFansListRes.convertToDataObject(): GetFansListResKt {
    val o = GetFansListResKt()
    o.header = header?.convertToDataObject()
    o.lastId = lastId
    o.fansInfos = fansInfos.mapTo(ArrayList(fansInfos.size)) { it.convertToDataObject() }
    return o
}

fun GetFollowListReq.convertToDataObject(): GetFollowListReqKt {
    val o = GetFollowListReqKt()
    o.targetUid = targetUid
    o.lastId = lastId
    o.limit = limit
    return o
}

fun GetFollowListRes.convertToDataObject(): GetFollowListResKt {
    val o = GetFollowListResKt()
    o.header = header?.convertToDataObject()
    o.lastId = lastId
    o.followInfos = followInfos.mapTo(ArrayList(followInfos.size)) { it.convertToDataObject() }
    return o
}

fun GetFriendListReq.convertToDataObject(): GetFriendListReqKt {
    val o = GetFriendListReqKt()
    o.targetUid = targetUid
    o.lastId = lastId
    o.limit = limit
    return o
}

fun GetFriendListRes.convertToDataObject(): GetFriendListResKt {
    val o = GetFriendListResKt()
    o.header = header?.convertToDataObject()
    o.lastId = lastId
    o.friendInfos = friendInfos.mapTo(ArrayList(friendInfos.size)) { it.convertToDataObject() }
    return o
}

fun GetRelationCountReq.convertToDataObject(): GetRelationCountReqKt {
    val o = GetRelationCountReqKt()
    o.targetUid = targetUid
    return o
}

fun GetRelationCountRes.convertToDataObject(): GetRelationCountResKt {
    val o = GetRelationCountResKt()
    o.header = header?.convertToDataObject()
    o.fansNum = fansNum
    o.followNum = followNum
    o.friendNum = friendNum
    return o
}

fun ChangeBlackListReq.convertToDataObject(): ChangeBlackListReqKt {
    val o = ChangeBlackListReqKt()
    o.targetUid = targetUid
    o.opType = opType
    return o
}

fun ChangeBlackListRes.convertToDataObject(): ChangeBlackListResKt {
    val o = ChangeBlackListResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun GetBlackListReq.convertToDataObject(): GetBlackListReqKt {
    val o = GetBlackListReqKt()
    o.targetUid = targetUid
    o.lastId = lastId
    o.limit = limit
    return o
}

fun GetBlackListRes.convertToDataObject(): GetBlackListResKt {
    val o = GetBlackListResKt()
    o.header = header?.convertToDataObject()
    o.lastId = lastId
    o.blackInfos = blackInfos.mapTo(ArrayList(blackInfos.size)) { it.convertToDataObject() }
    return o
}

fun CheckRelationReq.convertToDataObject(): CheckRelationReqKt {
    val o = CheckRelationReqKt()
    o.targetUid = targetUid
    o.checkFollow = checkFollow
    o.checkFans = checkFans
    o.checkFriend = checkFriend
    o.checkBlackList = checkBlackList
    return o
}

fun CheckRelationRes.convertToDataObject(): CheckRelationResKt {
    val o = CheckRelationResKt()
    o.header = header?.convertToDataObject()
    o.follow = follow
    o.fans = fans
    o.friend = friend
    o.blackList = blackList
    return o
}

fun GreetReq.convertToDataObject(): GreetReqKt {
    val o = GreetReqKt()
    o.targetUid = targetUid
    return o
}

fun GreetRes.convertToDataObject(): GreetResKt {
    val o = GreetResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun RelationChangeMsg.convertToDataObject(): RelationChangeMsgKt {
    val o = RelationChangeMsgKt()
    o.srcUid = srcUid
    o.followSource = followSource
    o.changeType = changeType
    return o
}
