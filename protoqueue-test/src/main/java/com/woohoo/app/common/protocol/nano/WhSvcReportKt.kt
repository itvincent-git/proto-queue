// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.woohoo.app.common.protocol.nano.WhSvcCommonKt.ResponseHeaderKt
import com.woohoo.app.common.protocol.nano.WhSvcReport.IMChatMessage
import com.woohoo.app.common.protocol.nano.WhSvcReport.ReportViolationReq
import com.woohoo.app.common.protocol.nano.WhSvcReport.ReportViolationRes
import com.woohoo.app.common.protocol.nano.WhSvcReportKt.IMChatMessageKt
import com.woohoo.app.common.protocol.nano.WhSvcReportKt.ReportViolationReqKt
import com.woohoo.app.common.protocol.nano.WhSvcReportKt.ReportViolationResKt
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf

class WhSvcReportKt {
    class ReportViolationReqKt(
        var bizType: Int? = null,
        var violationType: Int? = null,
        var targetUid: Long? = null,
        var desc: String? = null,
        var picList: MutableList<String> = mutableListOf(),
        var roomId: Long? = null,
        var chatId: String? = null,
        var messageList: MutableList<IMChatMessageKt> = mutableListOf()
    ) {
        fun convertToMessage(): ReportViolationReq {
            val message = ReportViolationReq()
            message.bizType = bizType ?: 0
            message.violationType = violationType ?: 0
            message.targetUid = targetUid ?: 0L
            message.desc = desc
            message.picList = picList.toTypedArray()
            message.roomId = roomId ?: 0L
            message.chatId = chatId
            message.messageList = messageList.map { it.convertToMessage() }.toTypedArray()
            return message
        }
    }

    class IMChatMessageKt(
        var selfSend: Boolean? = null,
        var contentType: Int? = null,
        var content: String? = null,
        var timestamp: Long? = null
    ) {
        fun convertToMessage(): IMChatMessage {
            val message = IMChatMessage()
            message.selfSend = selfSend ?: false
            message.contentType = contentType ?: 0
            message.content = content
            message.timestamp = timestamp ?: 0L
            return message
        }
    }

    class ReportViolationResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): ReportViolationRes {
            val message = ReportViolationRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    interface BizTypeKt {
        companion object {
            val BizTypeUnknown: Int = 0

            val PersonalInfo: Int = 1

            val VideoRoom: Int = 2

            val ChatMatchRecord: Int = 3

            val IM: Int = 4
        }
    }

    interface ViolationTypeKt {
        companion object {
            val ViolationTypeUnknown: Int = 0

            val Advertisement: Int = 1

            val Salacity: Int = 2

            val Harass: Int = 3

            val Illegal: Int = 4
        }
    }

    interface IMChatContentTypeKt {
        companion object {
            val ContentTypeUnknown: Int = 0

            val TEXT: Int = 1

            val IMG: Int = 2
        }
    }
}

fun ReportViolationReq.convertToDataObject(): ReportViolationReqKt {
    val o = ReportViolationReqKt()
    o.bizType = bizType
    o.violationType = violationType
    o.targetUid = targetUid
    o.desc = desc
    o.picList = picList.toMutableList()
    o.roomId = roomId
    o.chatId = chatId
    o.messageList = messageList.mapTo(ArrayList(messageList.size)) { it.convertToDataObject() }
    return o
}

fun IMChatMessage.convertToDataObject(): IMChatMessageKt {
    val o = IMChatMessageKt()
    o.selfSend = selfSend
    o.contentType = contentType
    o.content = content
    o.timestamp = timestamp
    return o
}

fun ReportViolationRes.convertToDataObject(): ReportViolationResKt {
    val o = ReportViolationResKt()
    o.header = header?.convertToDataObject()
    return o
}
