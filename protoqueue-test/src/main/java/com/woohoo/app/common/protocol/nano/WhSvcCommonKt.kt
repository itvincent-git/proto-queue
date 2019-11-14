// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.woohoo.app.common.protocol.nano.WhSvcCommon.Empty
import com.woohoo.app.common.protocol.nano.WhSvcCommon.NotifyHeader
import com.woohoo.app.common.protocol.nano.WhSvcCommon.ResponseHeader
import com.woohoo.app.common.protocol.nano.WhSvcCommon.RoomVid
import com.woohoo.app.common.protocol.nano.WhSvcCommonKt.EmptyKt
import com.woohoo.app.common.protocol.nano.WhSvcCommonKt.NotifyHeaderKt
import com.woohoo.app.common.protocol.nano.WhSvcCommonKt.ResponseHeaderKt
import com.woohoo.app.common.protocol.nano.WhSvcCommonKt.RoomVidKt
import kotlin.Int
import kotlin.Long
import kotlin.String

class WhSvcCommonKt {
    class ResponseHeaderKt(
        var resCode: Int? = null,
        var resMsg: String? = null,
        var resTips: String? = null
    ) {
        fun convertToMessage(): ResponseHeader {
            val message = ResponseHeader()
            message.resCode = resCode ?: 0
            message.resMsg = resMsg
            message.resTips = resTips
            return message
        }
    }

    class NotifyHeaderKt(
        var seqId: Long? = null
    ) {
        fun convertToMessage(): NotifyHeader {
            val message = NotifyHeader()
            message.seqId = seqId ?: 0L
            return message
        }
    }

    class EmptyKt() {
        fun convertToMessage(): Empty {
            val message = Empty()
            return message
        }
    }

    class RoomVidKt(
        var owner: Long? = null,
        var type: Int? = null,
        var session: String? = null
    ) {
        fun convertToMessage(): RoomVid {
            val message = RoomVid()
            message.owner = owner ?: 0L
            message.type = type ?: 0
            message.session = session
            return message
        }
    }

    interface AppKt {
        companion object {
            val AppUnknown: Int = 0

            val WooHoo: Int = 1
        }
    }

    interface PlatformKt {
        companion object {
            val PlatformUnknown: Int = 0

            val PlatformAndroid: Int = 1

            val PlatformIos: Int = 2
        }
    }

    interface ResponseCodeKt {
        companion object {
            val Success: Int = 0

            val ErrSystem: Int = 1

            val ErrUnauthorized: Int = 2

            val ErrInvalidParameter: Int = 3

            val ErrServerBusy: Int = 4

            val ErrTooFrequency: Int = 5

            val ErrRestricted: Int = 6

            val ErrMaintenance: Int = 7

            val ErrLowVersion: Int = 8

            val ErrCensorWords: Int = 9

            val ErrNotExists: Int = 10

            val ErrExists: Int = 11

            val ErrExceedLimit: Int = 12

            val ErrUserFrozen: Int = 1000

            val ErrRelationGreetSendMax: Int = 1100

            val ErrRelationGreetToOneMax: Int = 1101

            val ErrPartyRoomLimitedByKicked: Int = 1200
        }
    }

    interface SexKt {
        companion object {
            val SexUnknown: Int = 0

            val FeMale: Int = 1

            val Male: Int = 2
        }
    }

    interface UserAccountTypeKt {
        companion object {
            val AccountUnknown: Int = 0

            val AccountFaceBook: Int = 1

            val AccountGoogle: Int = 2

            val AccountPhone: Int = 3
        }
    }

    interface RoomTypeKt {
        companion object {
            val RoomTypeUnknown: Int = 0

            val VideoChat: Int = 1

            val PartyRoom: Int = 2
        }
    }
}

fun ResponseHeader.convertToDataObject(): ResponseHeaderKt {
    val o = ResponseHeaderKt()
    o.resCode = resCode
    o.resMsg = resMsg
    o.resTips = resTips
    return o
}

fun NotifyHeader.convertToDataObject(): NotifyHeaderKt {
    val o = NotifyHeaderKt()
    o.seqId = seqId
    return o
}

fun Empty.convertToDataObject(): EmptyKt {
    val o = EmptyKt()
    return o
}

fun RoomVid.convertToDataObject(): RoomVidKt {
    val o = RoomVidKt()
    o.owner = owner
    o.type = type
    o.session = session
    return o
}
