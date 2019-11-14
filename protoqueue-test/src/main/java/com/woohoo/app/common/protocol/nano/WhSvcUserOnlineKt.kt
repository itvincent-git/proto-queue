// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.woohoo.app.common.protocol.nano.WhSvcCommonKt.ResponseHeaderKt
import com.woohoo.app.common.protocol.nano.WhSvcUserOnline.BatchGetUserOnlineStatusReq
import com.woohoo.app.common.protocol.nano.WhSvcUserOnline.BatchGetUserOnlineStatusRes
import com.woohoo.app.common.protocol.nano.WhSvcUserOnline.HeartbeatReq
import com.woohoo.app.common.protocol.nano.WhSvcUserOnline.HeartbeatRes
import com.woohoo.app.common.protocol.nano.WhSvcUserOnline.StartHeartbeatReq
import com.woohoo.app.common.protocol.nano.WhSvcUserOnline.StartHeartbeatRes
import com.woohoo.app.common.protocol.nano.WhSvcUserOnline.UserBizStatus
import com.woohoo.app.common.protocol.nano.WhSvcUserOnline.UserOnlineStatus
import com.woohoo.app.common.protocol.nano.WhSvcUserOnlineKt.BatchGetUserOnlineStatusReqKt
import com.woohoo.app.common.protocol.nano.WhSvcUserOnlineKt.BatchGetUserOnlineStatusResKt
import com.woohoo.app.common.protocol.nano.WhSvcUserOnlineKt.HeartbeatReqKt
import com.woohoo.app.common.protocol.nano.WhSvcUserOnlineKt.HeartbeatResKt
import com.woohoo.app.common.protocol.nano.WhSvcUserOnlineKt.StartHeartbeatReqKt
import com.woohoo.app.common.protocol.nano.WhSvcUserOnlineKt.StartHeartbeatResKt
import com.woohoo.app.common.protocol.nano.WhSvcUserOnlineKt.UserBizStatusKt
import com.woohoo.app.common.protocol.nano.WhSvcUserOnlineKt.UserOnlineStatusKt
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.MutableList
import kotlin.collections.MutableMap
import kotlin.collections.mutableListOf
import kotlin.collections.mutableMapOf
import net.protoqueue.rpc.runtime.util.convertMap

class WhSvcUserOnlineKt {
    class StartHeartbeatReqKt() {
        fun convertToMessage(): StartHeartbeatReq {
            val message = StartHeartbeatReq()
            return message
        }
    }

    class StartHeartbeatResKt(
        var header: ResponseHeaderKt? = null,
        var interval: Long? = null
    ) {
        fun convertToMessage(): StartHeartbeatRes {
            val message = StartHeartbeatRes()
            message.header = header?.convertToMessage()
            message.interval = interval ?: 0L
            return message
        }
    }

    class HeartbeatReqKt() {
        fun convertToMessage(): HeartbeatReq {
            val message = HeartbeatReq()
            return message
        }
    }

    class HeartbeatResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): HeartbeatRes {
            val message = HeartbeatRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class UserBizStatusKt(
        var bizType: String? = null,
        var status: Long? = null
    ) {
        fun convertToMessage(): UserBizStatus {
            val message = UserBizStatus()
            message.bizType = bizType
            message.status = status ?: 0L
            return message
        }
    }

    class UserOnlineStatusKt(
        var online: Boolean? = null,
        var status: MutableList<UserBizStatusKt> = mutableListOf(),
        var latestLoginTimestamp: Long? = null
    ) {
        fun convertToMessage(): UserOnlineStatus {
            val message = UserOnlineStatus()
            message.online = online ?: false
            message.status = status.map { it.convertToMessage() }.toTypedArray()
            message.latestLoginTimestamp = latestLoginTimestamp ?: 0L
            return message
        }
    }

    class BatchGetUserOnlineStatusReqKt(
        var uidList: MutableList<Long> = mutableListOf()
    ) {
        fun convertToMessage(): BatchGetUserOnlineStatusReq {
            val message = BatchGetUserOnlineStatusReq()
            message.uidList = uidList.toLongArray()
            return message
        }
    }

    class BatchGetUserOnlineStatusResKt(
        var header: ResponseHeaderKt? = null,
        var statusMap: MutableMap<Long?, UserOnlineStatusKt?> = mutableMapOf()
    ) {
        fun convertToMessage(): BatchGetUserOnlineStatusRes {
            val message = BatchGetUserOnlineStatusRes()
            message.header = header?.convertToMessage()
            message.statusMap = statusMap.convertMap({ it.key }, { it.value?.convertToMessage() })
            return message
        }
    }
}

fun StartHeartbeatReq.convertToDataObject(): StartHeartbeatReqKt {
    val o = StartHeartbeatReqKt()
    return o
}

fun StartHeartbeatRes.convertToDataObject(): StartHeartbeatResKt {
    val o = StartHeartbeatResKt()
    o.header = header?.convertToDataObject()
    o.interval = interval
    return o
}

fun HeartbeatReq.convertToDataObject(): HeartbeatReqKt {
    val o = HeartbeatReqKt()
    return o
}

fun HeartbeatRes.convertToDataObject(): HeartbeatResKt {
    val o = HeartbeatResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun UserBizStatus.convertToDataObject(): UserBizStatusKt {
    val o = UserBizStatusKt()
    o.bizType = bizType
    o.status = status
    return o
}

fun UserOnlineStatus.convertToDataObject(): UserOnlineStatusKt {
    val o = UserOnlineStatusKt()
    o.online = online
    o.status = status.mapTo(ArrayList(status.size)) { it.convertToDataObject() }
    o.latestLoginTimestamp = latestLoginTimestamp
    return o
}

fun BatchGetUserOnlineStatusReq.convertToDataObject(): BatchGetUserOnlineStatusReqKt {
    val o = BatchGetUserOnlineStatusReqKt()
    o.uidList = uidList.toMutableList()
    return o
}

fun BatchGetUserOnlineStatusRes.convertToDataObject(): BatchGetUserOnlineStatusResKt {
    val o = BatchGetUserOnlineStatusResKt()
    o.header = header?.convertToDataObject()
    o.statusMap = statusMap.convertMap({ it.key }, { it.value?.convertToDataObject() })
    return o
}
