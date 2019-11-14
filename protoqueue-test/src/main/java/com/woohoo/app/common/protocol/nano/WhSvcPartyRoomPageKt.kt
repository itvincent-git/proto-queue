// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.woohoo.app.common.protocol.nano.WhSvcCommonKt.ResponseHeaderKt
import com.woohoo.app.common.protocol.nano.WhSvcCommonKt.RoomVidKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPage.HomePageListReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPage.HomePageListRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPage.RelatedRecommendItem
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPage.RelatedRecommendReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPage.RelatedRecommendRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPage.RoomItem
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPageKt.HomePageListReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPageKt.HomePageListResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPageKt.RelatedRecommendItemKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPageKt.RelatedRecommendReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPageKt.RelatedRecommendResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPageKt.RoomItemKt
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf

class WhSvcPartyRoomPageKt {
    class RelatedRecommendReqKt() {
        fun convertToMessage(): RelatedRecommendReq {
            val message = RelatedRecommendReq()
            return message
        }
    }

    class RelatedRecommendResKt(
        var header: ResponseHeaderKt? = null,
        var recommendItems: MutableList<RelatedRecommendItemKt> = mutableListOf()
    ) {
        fun convertToMessage(): RelatedRecommendRes {
            val message = RelatedRecommendRes()
            message.header = header?.convertToMessage()
            message.recommendItems = recommendItems.map { it.convertToMessage() }.toTypedArray()
            return message
        }
    }

    class RelatedRecommendItemKt(
        var uid: Long? = null,
        var roomVid: RoomVidKt? = null
    ) {
        fun convertToMessage(): RelatedRecommendItem {
            val message = RelatedRecommendItem()
            message.uid = uid ?: 0L
            message.roomVid = roomVid?.convertToMessage()
            return message
        }
    }

    class HomePageListReqKt(
        var cursor: String? = null,
        var limit: Int? = null
    ) {
        fun convertToMessage(): HomePageListReq {
            val message = HomePageListReq()
            message.cursor = cursor
            message.limit = limit ?: 0
            return message
        }
    }

    class HomePageListResKt(
        var header: ResponseHeaderKt? = null,
        var roomItems: MutableList<RoomItemKt> = mutableListOf(),
        var nextCursor: String? = null
    ) {
        fun convertToMessage(): HomePageListRes {
            val message = HomePageListRes()
            message.header = header?.convertToMessage()
            message.roomItems = roomItems.map { it.convertToMessage() }.toTypedArray()
            message.nextCursor = nextCursor
            return message
        }
    }

    class RoomItemKt(
        var roomVid: RoomVidKt? = null,
        var hotScore: Long? = null
    ) {
        fun convertToMessage(): RoomItem {
            val message = RoomItem()
            message.roomVid = roomVid?.convertToMessage()
            message.hotScore = hotScore ?: 0L
            return message
        }
    }
}

fun RelatedRecommendReq.convertToDataObject(): RelatedRecommendReqKt {
    val o = RelatedRecommendReqKt()
    return o
}

fun RelatedRecommendRes.convertToDataObject(): RelatedRecommendResKt {
    val o = RelatedRecommendResKt()
    o.header = header?.convertToDataObject()
    o.recommendItems = recommendItems.mapTo(ArrayList(recommendItems.size)) {
            it.convertToDataObject() }
    return o
}

fun RelatedRecommendItem.convertToDataObject(): RelatedRecommendItemKt {
    val o = RelatedRecommendItemKt()
    o.uid = uid
    o.roomVid = roomVid?.convertToDataObject()
    return o
}

fun HomePageListReq.convertToDataObject(): HomePageListReqKt {
    val o = HomePageListReqKt()
    o.cursor = cursor
    o.limit = limit
    return o
}

fun HomePageListRes.convertToDataObject(): HomePageListResKt {
    val o = HomePageListResKt()
    o.header = header?.convertToDataObject()
    o.roomItems = roomItems.mapTo(ArrayList(roomItems.size)) { it.convertToDataObject() }
    o.nextCursor = nextCursor
    return o
}

fun RoomItem.convertToDataObject(): RoomItemKt {
    val o = RoomItemKt()
    o.roomVid = roomVid?.convertToDataObject()
    o.hotScore = hotScore
    return o
}
