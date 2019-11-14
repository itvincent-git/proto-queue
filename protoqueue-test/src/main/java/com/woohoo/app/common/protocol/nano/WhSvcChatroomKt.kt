// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.woohoo.app.common.protocol.nano.WhSvcChatroom.CreateMediaTokenReq
import com.woohoo.app.common.protocol.nano.WhSvcChatroom.CreateMediaTokenRes
import com.woohoo.app.common.protocol.nano.WhSvcChatroom.PublicScreenMessageNotify
import com.woohoo.app.common.protocol.nano.WhSvcChatroomKt.CreateMediaTokenReqKt
import com.woohoo.app.common.protocol.nano.WhSvcChatroomKt.CreateMediaTokenResKt
import com.woohoo.app.common.protocol.nano.WhSvcChatroomKt.PublicScreenMessageNotifyKt
import com.woohoo.app.common.protocol.nano.WhSvcCommonKt.ResponseHeaderKt
import com.woohoo.app.common.protocol.nano.WhSvcCommonKt.RoomVidKt
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.MutableMap
import kotlin.collections.mutableMapOf
import net.protoqueue.rpc.runtime.util.convertMap

class WhSvcChatroomKt {
    class CreateMediaTokenReqKt(
        var roomVid: RoomVidKt? = null,
        var roomId: Long? = null,
        var type: Int? = null
    ) {
        fun convertToMessage(): CreateMediaTokenReq {
            val message = CreateMediaTokenReq()
            message.roomVid = roomVid?.convertToMessage()
            message.roomId = roomId ?: 0L
            message.type = type ?: 0
            return message
        }
    }

    class CreateMediaTokenResKt(
        var header: ResponseHeaderKt? = null,
        var token: String? = null
    ) {
        fun convertToMessage(): CreateMediaTokenRes {
            val message = CreateMediaTokenRes()
            message.header = header?.convertToMessage()
            message.token = token
            return message
        }
    }

    class PublicScreenMessageNotifyKt(
        var roomId: Long? = null,
        var sender: Long? = null,
        var system: Boolean? = null,
        var content: MutableMap<String?, String?> = mutableMapOf()
    ) {
        fun convertToMessage(): PublicScreenMessageNotify {
            val message = PublicScreenMessageNotify()
            message.roomId = roomId ?: 0L
            message.sender = sender ?: 0L
            message.system = system ?: false
            message.content = content.convertMap({ it.key }, { it.value })
            return message
        }
    }

    interface TokenTypeKt {
        companion object {
            val TokenUnknown: Int = 0

            val TokenVideo: Int = 1

            val TokenAudio: Int = 2
        }
    }
}

fun CreateMediaTokenReq.convertToDataObject(): CreateMediaTokenReqKt {
    val o = CreateMediaTokenReqKt()
    o.roomVid = roomVid?.convertToDataObject()
    o.roomId = roomId
    o.type = type
    return o
}

fun CreateMediaTokenRes.convertToDataObject(): CreateMediaTokenResKt {
    val o = CreateMediaTokenResKt()
    o.header = header?.convertToDataObject()
    o.token = token
    return o
}

fun PublicScreenMessageNotify.convertToDataObject(): PublicScreenMessageNotifyKt {
    val o = PublicScreenMessageNotifyKt()
    o.roomId = roomId
    o.sender = sender
    o.system = system
    o.content = content.convertMap({ it.key }, { it.value })
    return o
}
