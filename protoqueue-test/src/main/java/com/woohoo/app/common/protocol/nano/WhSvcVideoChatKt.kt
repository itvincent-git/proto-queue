// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.woohoo.app.common.protocol.nano.WhSvcCommonKt.ResponseHeaderKt
import com.woohoo.app.common.protocol.nano.WhSvcCommonKt.RoomVidKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.CancelStartPlayReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.CancelStartPlayRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.CdTime
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.ChatHeartbeatReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.ChatHeartbeatRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.ClickClapReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.ClickClapRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.DelUserChatHistoryReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.DelUserChatHistoryRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.Emoji
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.FinishClapNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.GetChatInfoReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.GetChatInfoRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.GetEmojiListReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.GetEmojiListRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.GetMaskListReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.GetMaskListRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.GetPlayingInfoReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.GetPlayingInfoRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.GetUserChatHistoryReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.GetUserChatHistoryRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.GetUserChatStatusReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.GetUserChatStatusRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.InviteStartPlayReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.InviteStartPlayRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.InviteTakeOffMaskNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.InviteTakeOffMaskReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.InviteTakeOffMaskRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.JoinChatReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.JoinChatRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.LeaveChatReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.LeaveChatRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.Mask
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.Material
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.PeerCancelStartPlayNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.PeerClickClapNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.PeerInviteStartPlayNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.PeerReplyStartPlayNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.PeerUseEmojiNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.PlayingInfo
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.ReadyJoinChatNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.RejectTakeOffMaskNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.ReplyStartPlayReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.ReplyStartPlayRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.ReplyTakeOffMaskReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.ReplyTakeOffMaskRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.TakeOffMaskNotifyInfo
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.UseEmojiReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.UseEmojiRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.UserChatHistory
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.WearMaskReq
import com.woohoo.app.common.protocol.nano.WhSvcVideoChat.WearMaskRes
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.CancelStartPlayReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.CancelStartPlayResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.CdTimeKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.ChatHeartbeatReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.ChatHeartbeatResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.ClickClapReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.ClickClapResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.DelUserChatHistoryReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.DelUserChatHistoryResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.EmojiKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.FinishClapNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.GetChatInfoReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.GetChatInfoResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.GetEmojiListReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.GetEmojiListResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.GetMaskListReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.GetMaskListResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.GetPlayingInfoReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.GetPlayingInfoResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.GetUserChatHistoryReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.GetUserChatHistoryResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.GetUserChatStatusReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.GetUserChatStatusResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.InviteStartPlayReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.InviteStartPlayResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.InviteTakeOffMaskNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.InviteTakeOffMaskReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.InviteTakeOffMaskResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.JoinChatReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.JoinChatResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.LeaveChatReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.LeaveChatResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.MaskKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.MaterialKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.PeerCancelStartPlayNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.PeerClickClapNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.PeerInviteStartPlayNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.PeerReplyStartPlayNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.PeerUseEmojiNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.PlayingInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.ReadyJoinChatNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.RejectTakeOffMaskNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.ReplyStartPlayReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.ReplyStartPlayResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.ReplyTakeOffMaskReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.ReplyTakeOffMaskResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.TakeOffMaskNotifyInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.UseEmojiReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.UseEmojiResKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.UserChatHistoryKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.WearMaskReqKt
import com.woohoo.app.common.protocol.nano.WhSvcVideoChatKt.WearMaskResKt
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf

class WhSvcVideoChatKt {
    class GetMaskListReqKt() {
        fun convertToMessage(): GetMaskListReq {
            val message = GetMaskListReq()
            return message
        }
    }

    class GetMaskListResKt(
        var header: ResponseHeaderKt? = null,
        var maskList: MutableList<MaskKt> = mutableListOf()
    ) {
        fun convertToMessage(): GetMaskListRes {
            val message = GetMaskListRes()
            message.header = header?.convertToMessage()
            message.maskList = maskList.map { it.convertToMessage() }.toTypedArray()
            return message
        }
    }

    class WearMaskReqKt(
        var maskId: String? = null
    ) {
        fun convertToMessage(): WearMaskReq {
            val message = WearMaskReq()
            message.maskId = maskId
            return message
        }
    }

    class WearMaskResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): WearMaskRes {
            val message = WearMaskRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class GetEmojiListReqKt(
        var lastModifyTime: Long? = null
    ) {
        fun convertToMessage(): GetEmojiListReq {
            val message = GetEmojiListReq()
            message.lastModifyTime = lastModifyTime ?: 0L
            return message
        }
    }

    class GetEmojiListResKt(
        var header: ResponseHeaderKt? = null,
        var emojiList: MutableList<EmojiKt> = mutableListOf(),
        var lastModifyTime: Long? = null
    ) {
        fun convertToMessage(): GetEmojiListRes {
            val message = GetEmojiListRes()
            message.header = header?.convertToMessage()
            message.emojiList = emojiList.map { it.convertToMessage() }.toTypedArray()
            message.lastModifyTime = lastModifyTime ?: 0L
            return message
        }
    }

    class UseEmojiReqKt(
        var chatId: String? = null,
        var emojiId: String? = null
    ) {
        fun convertToMessage(): UseEmojiReq {
            val message = UseEmojiReq()
            message.chatId = chatId
            message.emojiId = emojiId
            return message
        }
    }

    class UseEmojiResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): UseEmojiRes {
            val message = UseEmojiRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class CdTimeKt(
        var totalSecs: Long? = null,
        var remainSecs: Long? = null
    ) {
        fun convertToMessage(): CdTime {
            val message = CdTime()
            message.totalSecs = totalSecs ?: 0L
            message.remainSecs = remainSecs ?: 0L
            return message
        }
    }

    class JoinChatReqKt(
        var chatId: String? = null
    ) {
        fun convertToMessage(): JoinChatReq {
            val message = JoinChatReq()
            message.chatId = chatId
            return message
        }
    }

    class JoinChatResKt(
        var header: ResponseHeaderKt? = null,
        var cdTime: CdTimeKt? = null,
        var peerUid: Long? = null,
        var maskStatus: Int? = null
    ) {
        fun convertToMessage(): JoinChatRes {
            val message = JoinChatRes()
            message.header = header?.convertToMessage()
            message.cdTime = cdTime?.convertToMessage()
            message.peerUid = peerUid ?: 0L
            message.maskStatus = maskStatus ?: 0
            return message
        }
    }

    class LeaveChatReqKt(
        var chatId: String? = null
    ) {
        fun convertToMessage(): LeaveChatReq {
            val message = LeaveChatReq()
            message.chatId = chatId
            return message
        }
    }

    class LeaveChatResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): LeaveChatRes {
            val message = LeaveChatRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class ChatHeartbeatReqKt(
        var chatId: String? = null
    ) {
        fun convertToMessage(): ChatHeartbeatReq {
            val message = ChatHeartbeatReq()
            message.chatId = chatId
            return message
        }
    }

    class ChatHeartbeatResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): ChatHeartbeatRes {
            val message = ChatHeartbeatRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class GetUserChatStatusReqKt(
        var chatId: String? = null
    ) {
        fun convertToMessage(): GetUserChatStatusReq {
            val message = GetUserChatStatusReq()
            message.chatId = chatId
            return message
        }
    }

    class GetUserChatStatusResKt(
        var header: ResponseHeaderKt? = null,
        var chatExist: Boolean? = null
    ) {
        fun convertToMessage(): GetUserChatStatusRes {
            val message = GetUserChatStatusRes()
            message.header = header?.convertToMessage()
            message.chatExist = chatExist ?: false
            return message
        }
    }

    class GetChatInfoReqKt(
        var chatId: String? = null,
        var peerUid: Long? = null
    ) {
        fun convertToMessage(): GetChatInfoReq {
            val message = GetChatInfoReq()
            message.chatId = chatId
            message.peerUid = peerUid ?: 0L
            return message
        }
    }

    class GetChatInfoResKt(
        var header: ResponseHeaderKt? = null,
        var maskStatus: Int? = null,
        var clapStatus: Int? = null,
        var peerClapStatus: Int? = null,
        var cdTime: CdTimeKt? = null
    ) {
        fun convertToMessage(): GetChatInfoRes {
            val message = GetChatInfoRes()
            message.header = header?.convertToMessage()
            message.maskStatus = maskStatus ?: 0
            message.clapStatus = clapStatus ?: 0
            message.peerClapStatus = peerClapStatus ?: 0
            message.cdTime = cdTime?.convertToMessage()
            return message
        }
    }

    class InviteTakeOffMaskReqKt(
        var chatId: String? = null
    ) {
        fun convertToMessage(): InviteTakeOffMaskReq {
            val message = InviteTakeOffMaskReq()
            message.chatId = chatId
            return message
        }
    }

    class InviteTakeOffMaskResKt(
        var header: ResponseHeaderKt? = null,
        var cdTime: CdTimeKt? = null
    ) {
        fun convertToMessage(): InviteTakeOffMaskRes {
            val message = InviteTakeOffMaskRes()
            message.header = header?.convertToMessage()
            message.cdTime = cdTime?.convertToMessage()
            return message
        }
    }

    class ReplyTakeOffMaskReqKt(
        var chatId: String? = null,
        var agree: Boolean? = null
    ) {
        fun convertToMessage(): ReplyTakeOffMaskReq {
            val message = ReplyTakeOffMaskReq()
            message.chatId = chatId
            message.agree = agree ?: false
            return message
        }
    }

    class ReplyTakeOffMaskResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): ReplyTakeOffMaskRes {
            val message = ReplyTakeOffMaskRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class ClickClapReqKt(
        var chatId: String? = null,
        var peerUid: Long? = null
    ) {
        fun convertToMessage(): ClickClapReq {
            val message = ClickClapReq()
            message.chatId = chatId
            message.peerUid = peerUid ?: 0L
            return message
        }
    }

    class ClickClapResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): ClickClapRes {
            val message = ClickClapRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class UserChatHistoryKt(
        var uid: Long? = null,
        var matchTime: Long? = null
    ) {
        fun convertToMessage(): UserChatHistory {
            val message = UserChatHistory()
            message.uid = uid ?: 0L
            message.matchTime = matchTime ?: 0L
            return message
        }
    }

    class GetUserChatHistoryReqKt(
        var lastMatchTime: Long? = null,
        var limit: Int? = null
    ) {
        fun convertToMessage(): GetUserChatHistoryReq {
            val message = GetUserChatHistoryReq()
            message.lastMatchTime = lastMatchTime ?: 0L
            message.limit = limit ?: 0
            return message
        }
    }

    class GetUserChatHistoryResKt(
        var header: ResponseHeaderKt? = null,
        var lastMatchTime: Long? = null,
        var histories: MutableList<UserChatHistoryKt> = mutableListOf()
    ) {
        fun convertToMessage(): GetUserChatHistoryRes {
            val message = GetUserChatHistoryRes()
            message.header = header?.convertToMessage()
            message.lastMatchTime = lastMatchTime ?: 0L
            message.histories = histories.map { it.convertToMessage() }.toTypedArray()
            return message
        }
    }

    class DelUserChatHistoryReqKt(
        var targetUid: Long? = null
    ) {
        fun convertToMessage(): DelUserChatHistoryReq {
            val message = DelUserChatHistoryReq()
            message.targetUid = targetUid ?: 0L
            return message
        }
    }

    class DelUserChatHistoryResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): DelUserChatHistoryRes {
            val message = DelUserChatHistoryRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class InviteStartPlayReqKt(
        var chatId: String? = null,
        var playType: Int? = null
    ) {
        fun convertToMessage(): InviteStartPlayReq {
            val message = InviteStartPlayReq()
            message.chatId = chatId
            message.playType = playType ?: 0
            return message
        }
    }

    class InviteStartPlayResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): InviteStartPlayRes {
            val message = InviteStartPlayRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class ReplyStartPlayReqKt(
        var chatId: String? = null,
        var playType: Int? = null,
        var reply: Int? = null
    ) {
        fun convertToMessage(): ReplyStartPlayReq {
            val message = ReplyStartPlayReq()
            message.chatId = chatId
            message.playType = playType ?: 0
            message.reply = reply ?: 0
            return message
        }
    }

    class ReplyStartPlayResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): ReplyStartPlayRes {
            val message = ReplyStartPlayRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class CancelStartPlayReqKt(
        var chatId: String? = null,
        var playType: Int? = null
    ) {
        fun convertToMessage(): CancelStartPlayReq {
            val message = CancelStartPlayReq()
            message.chatId = chatId
            message.playType = playType ?: 0
            return message
        }
    }

    class CancelStartPlayResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): CancelStartPlayRes {
            val message = CancelStartPlayRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class GetPlayingInfoReqKt(
        var chatId: String? = null
    ) {
        fun convertToMessage(): GetPlayingInfoReq {
            val message = GetPlayingInfoReq()
            message.chatId = chatId
            return message
        }
    }

    class GetPlayingInfoResKt(
        var header: ResponseHeaderKt? = null,
        var playingInfos: MutableList<PlayingInfoKt> = mutableListOf()
    ) {
        fun convertToMessage(): GetPlayingInfoRes {
            val message = GetPlayingInfoRes()
            message.header = header?.convertToMessage()
            message.playingInfos = playingInfos.map { it.convertToMessage() }.toTypedArray()
            return message
        }
    }

    class MaskKt(
        var maskId: String? = null,
        var name: String? = null,
        var picUrl: String? = null,
        var wearMaterialList: MutableList<MaterialKt> = mutableListOf(),
        var takeoffMaterialList: MutableList<MaterialKt> = mutableListOf(),
        var pureMaterialList: MutableList<MaterialKt> = mutableListOf()
    ) {
        fun convertToMessage(): Mask {
            val message = Mask()
            message.maskId = maskId
            message.name = name
            message.picUrl = picUrl
            message.wearMaterialList = wearMaterialList.map { it.convertToMessage() }.toTypedArray()
            message.takeoffMaterialList = takeoffMaterialList.map { it.convertToMessage()
                    }.toTypedArray()
            message.pureMaterialList = pureMaterialList.map { it.convertToMessage() }.toTypedArray()
            return message
        }
    }

    class MaterialKt(
        var materialType: Int? = null,
        var materialId: Long? = null,
        var name: String? = null,
        var zipUrl: String? = null,
        var md5: String? = null
    ) {
        fun convertToMessage(): Material {
            val message = Material()
            message.materialType = materialType ?: 0
            message.materialId = materialId ?: 0L
            message.name = name
            message.zipUrl = zipUrl
            message.md5 = md5
            return message
        }
    }

    class EmojiKt(
        var emojiId: String? = null,
        var name: String? = null,
        var picUrl: String? = null,
        var resourceType: Int? = null,
        var resourceUrl: String? = null
    ) {
        fun convertToMessage(): Emoji {
            val message = Emoji()
            message.emojiId = emojiId
            message.name = name
            message.picUrl = picUrl
            message.resourceType = resourceType ?: 0
            message.resourceUrl = resourceUrl
            return message
        }
    }

    class PlayingInfoKt(
        var playType: Int? = null,
        var playingId: String? = null
    ) {
        fun convertToMessage(): PlayingInfo {
            val message = PlayingInfo()
            message.playType = playType ?: 0
            message.playingId = playingId
            return message
        }
    }

    class PeerUseEmojiNotifyInfoKt(
        var chatId: String? = null,
        var emojiId: String? = null
    ) {
        fun convertToMessage(): PeerUseEmojiNotifyInfo {
            val message = PeerUseEmojiNotifyInfo()
            message.chatId = chatId
            message.emojiId = emojiId
            return message
        }
    }

    class ReadyJoinChatNotifyInfoKt(
        var chatId: String? = null,
        var roomId: Long? = null,
        var chatSource: Int? = null,
        var uid1: Long? = null,
        var uid2: Long? = null,
        var roomVId: RoomVidKt? = null,
        var token: String? = null
    ) {
        fun convertToMessage(): ReadyJoinChatNotifyInfo {
            val message = ReadyJoinChatNotifyInfo()
            message.chatId = chatId
            message.roomId = roomId ?: 0L
            message.chatSource = chatSource ?: 0
            message.uid1 = uid1 ?: 0L
            message.uid2 = uid2 ?: 0L
            message.roomVId = roomVId?.convertToMessage()
            message.token = token
            return message
        }
    }

    class InviteTakeOffMaskNotifyInfoKt(
        var chatId: String? = null,
        var inviterUid: Long? = null
    ) {
        fun convertToMessage(): InviteTakeOffMaskNotifyInfo {
            val message = InviteTakeOffMaskNotifyInfo()
            message.chatId = chatId
            message.inviterUid = inviterUid ?: 0L
            return message
        }
    }

    class RejectTakeOffMaskNotifyInfoKt(
        var chatId: String? = null,
        var rejectUid: Long? = null
    ) {
        fun convertToMessage(): RejectTakeOffMaskNotifyInfo {
            val message = RejectTakeOffMaskNotifyInfo()
            message.chatId = chatId
            message.rejectUid = rejectUid ?: 0L
            return message
        }
    }

    class TakeOffMaskNotifyInfoKt(
        var chatId: String? = null
    ) {
        fun convertToMessage(): TakeOffMaskNotifyInfo {
            val message = TakeOffMaskNotifyInfo()
            message.chatId = chatId
            return message
        }
    }

    class PeerClickClapNotifyInfoKt(
        var chatId: String? = null,
        var clapUid: Long? = null
    ) {
        fun convertToMessage(): PeerClickClapNotifyInfo {
            val message = PeerClickClapNotifyInfo()
            message.chatId = chatId
            message.clapUid = clapUid ?: 0L
            return message
        }
    }

    class FinishClapNotifyInfoKt(
        var chatId: String? = null
    ) {
        fun convertToMessage(): FinishClapNotifyInfo {
            val message = FinishClapNotifyInfo()
            message.chatId = chatId
            return message
        }
    }

    class PeerInviteStartPlayNotifyInfoKt(
        var chatId: String? = null,
        var playType: Int? = null
    ) {
        fun convertToMessage(): PeerInviteStartPlayNotifyInfo {
            val message = PeerInviteStartPlayNotifyInfo()
            message.chatId = chatId
            message.playType = playType ?: 0
            return message
        }
    }

    class PeerReplyStartPlayNotifyInfoKt(
        var chatId: String? = null,
        var playType: Int? = null,
        var reply: Int? = null
    ) {
        fun convertToMessage(): PeerReplyStartPlayNotifyInfo {
            val message = PeerReplyStartPlayNotifyInfo()
            message.chatId = chatId
            message.playType = playType ?: 0
            message.reply = reply ?: 0
            return message
        }
    }

    class PeerCancelStartPlayNotifyInfoKt(
        var chatId: String? = null,
        var playType: Int? = null
    ) {
        fun convertToMessage(): PeerCancelStartPlayNotifyInfo {
            val message = PeerCancelStartPlayNotifyInfo()
            message.chatId = chatId
            message.playType = playType ?: 0
            return message
        }
    }

    interface MaskStatusKt {
        companion object {
            val Unknown: Int = 0

            val On: Int = 1

            val Off: Int = 2
        }
    }

    interface MaterialTypeKt {
        companion object {
            val UnknownMaterialType: Int = 0

            val Decal: Int = 1

            val Effect: Int = 2

            val Filter: Int = 3

            val Emotion: Int = 4

            val Dance: Int = 5
        }
    }

    interface ChatSourceKt {
        companion object {
            val UnKnown: Int = 0

            val MatchPlaza: Int = 1

            val IM: Int = 2
        }
    }

    interface ResourceTypeKt {
        companion object {
            val UnknownResourceType: Int = 0

            val SVGA: Int = 1
        }
    }

    interface ClapStatusKt {
        companion object {
            val UnKnownClapStatus: Int = 0

            val ExistClapInvite: Int = 1

            val NotExistClapInvite: Int = 2
        }
    }

    interface InviteReplyTypeKt {
        companion object {
            val UnKnownInviteReplyStatus: Int = 0

            val Agree: Int = 1

            val Reject: Int = 2

            val NotSupportPlayType: Int = 3
        }
    }

    interface PlayTypeKt {
        companion object {
            val PlayTypeUnknown: Int = 0

            val Tacit: Int = 1
        }
    }
}

fun GetMaskListReq.convertToDataObject(): GetMaskListReqKt {
    val o = GetMaskListReqKt()
    return o
}

fun GetMaskListRes.convertToDataObject(): GetMaskListResKt {
    val o = GetMaskListResKt()
    o.header = header?.convertToDataObject()
    o.maskList = maskList.mapTo(ArrayList(maskList.size)) { it.convertToDataObject() }
    return o
}

fun WearMaskReq.convertToDataObject(): WearMaskReqKt {
    val o = WearMaskReqKt()
    o.maskId = maskId
    return o
}

fun WearMaskRes.convertToDataObject(): WearMaskResKt {
    val o = WearMaskResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun GetEmojiListReq.convertToDataObject(): GetEmojiListReqKt {
    val o = GetEmojiListReqKt()
    o.lastModifyTime = lastModifyTime
    return o
}

fun GetEmojiListRes.convertToDataObject(): GetEmojiListResKt {
    val o = GetEmojiListResKt()
    o.header = header?.convertToDataObject()
    o.emojiList = emojiList.mapTo(ArrayList(emojiList.size)) { it.convertToDataObject() }
    o.lastModifyTime = lastModifyTime
    return o
}

fun UseEmojiReq.convertToDataObject(): UseEmojiReqKt {
    val o = UseEmojiReqKt()
    o.chatId = chatId
    o.emojiId = emojiId
    return o
}

fun UseEmojiRes.convertToDataObject(): UseEmojiResKt {
    val o = UseEmojiResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun CdTime.convertToDataObject(): CdTimeKt {
    val o = CdTimeKt()
    o.totalSecs = totalSecs
    o.remainSecs = remainSecs
    return o
}

fun JoinChatReq.convertToDataObject(): JoinChatReqKt {
    val o = JoinChatReqKt()
    o.chatId = chatId
    return o
}

fun JoinChatRes.convertToDataObject(): JoinChatResKt {
    val o = JoinChatResKt()
    o.header = header?.convertToDataObject()
    o.cdTime = cdTime?.convertToDataObject()
    o.peerUid = peerUid
    o.maskStatus = maskStatus
    return o
}

fun LeaveChatReq.convertToDataObject(): LeaveChatReqKt {
    val o = LeaveChatReqKt()
    o.chatId = chatId
    return o
}

fun LeaveChatRes.convertToDataObject(): LeaveChatResKt {
    val o = LeaveChatResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun ChatHeartbeatReq.convertToDataObject(): ChatHeartbeatReqKt {
    val o = ChatHeartbeatReqKt()
    o.chatId = chatId
    return o
}

fun ChatHeartbeatRes.convertToDataObject(): ChatHeartbeatResKt {
    val o = ChatHeartbeatResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun GetUserChatStatusReq.convertToDataObject(): GetUserChatStatusReqKt {
    val o = GetUserChatStatusReqKt()
    o.chatId = chatId
    return o
}

fun GetUserChatStatusRes.convertToDataObject(): GetUserChatStatusResKt {
    val o = GetUserChatStatusResKt()
    o.header = header?.convertToDataObject()
    o.chatExist = chatExist
    return o
}

fun GetChatInfoReq.convertToDataObject(): GetChatInfoReqKt {
    val o = GetChatInfoReqKt()
    o.chatId = chatId
    o.peerUid = peerUid
    return o
}

fun GetChatInfoRes.convertToDataObject(): GetChatInfoResKt {
    val o = GetChatInfoResKt()
    o.header = header?.convertToDataObject()
    o.maskStatus = maskStatus
    o.clapStatus = clapStatus
    o.peerClapStatus = peerClapStatus
    o.cdTime = cdTime?.convertToDataObject()
    return o
}

fun InviteTakeOffMaskReq.convertToDataObject(): InviteTakeOffMaskReqKt {
    val o = InviteTakeOffMaskReqKt()
    o.chatId = chatId
    return o
}

fun InviteTakeOffMaskRes.convertToDataObject(): InviteTakeOffMaskResKt {
    val o = InviteTakeOffMaskResKt()
    o.header = header?.convertToDataObject()
    o.cdTime = cdTime?.convertToDataObject()
    return o
}

fun ReplyTakeOffMaskReq.convertToDataObject(): ReplyTakeOffMaskReqKt {
    val o = ReplyTakeOffMaskReqKt()
    o.chatId = chatId
    o.agree = agree
    return o
}

fun ReplyTakeOffMaskRes.convertToDataObject(): ReplyTakeOffMaskResKt {
    val o = ReplyTakeOffMaskResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun ClickClapReq.convertToDataObject(): ClickClapReqKt {
    val o = ClickClapReqKt()
    o.chatId = chatId
    o.peerUid = peerUid
    return o
}

fun ClickClapRes.convertToDataObject(): ClickClapResKt {
    val o = ClickClapResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun UserChatHistory.convertToDataObject(): UserChatHistoryKt {
    val o = UserChatHistoryKt()
    o.uid = uid
    o.matchTime = matchTime
    return o
}

fun GetUserChatHistoryReq.convertToDataObject(): GetUserChatHistoryReqKt {
    val o = GetUserChatHistoryReqKt()
    o.lastMatchTime = lastMatchTime
    o.limit = limit
    return o
}

fun GetUserChatHistoryRes.convertToDataObject(): GetUserChatHistoryResKt {
    val o = GetUserChatHistoryResKt()
    o.header = header?.convertToDataObject()
    o.lastMatchTime = lastMatchTime
    o.histories = histories.mapTo(ArrayList(histories.size)) { it.convertToDataObject() }
    return o
}

fun DelUserChatHistoryReq.convertToDataObject(): DelUserChatHistoryReqKt {
    val o = DelUserChatHistoryReqKt()
    o.targetUid = targetUid
    return o
}

fun DelUserChatHistoryRes.convertToDataObject(): DelUserChatHistoryResKt {
    val o = DelUserChatHistoryResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun InviteStartPlayReq.convertToDataObject(): InviteStartPlayReqKt {
    val o = InviteStartPlayReqKt()
    o.chatId = chatId
    o.playType = playType
    return o
}

fun InviteStartPlayRes.convertToDataObject(): InviteStartPlayResKt {
    val o = InviteStartPlayResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun ReplyStartPlayReq.convertToDataObject(): ReplyStartPlayReqKt {
    val o = ReplyStartPlayReqKt()
    o.chatId = chatId
    o.playType = playType
    o.reply = reply
    return o
}

fun ReplyStartPlayRes.convertToDataObject(): ReplyStartPlayResKt {
    val o = ReplyStartPlayResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun CancelStartPlayReq.convertToDataObject(): CancelStartPlayReqKt {
    val o = CancelStartPlayReqKt()
    o.chatId = chatId
    o.playType = playType
    return o
}

fun CancelStartPlayRes.convertToDataObject(): CancelStartPlayResKt {
    val o = CancelStartPlayResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun GetPlayingInfoReq.convertToDataObject(): GetPlayingInfoReqKt {
    val o = GetPlayingInfoReqKt()
    o.chatId = chatId
    return o
}

fun GetPlayingInfoRes.convertToDataObject(): GetPlayingInfoResKt {
    val o = GetPlayingInfoResKt()
    o.header = header?.convertToDataObject()
    o.playingInfos = playingInfos.mapTo(ArrayList(playingInfos.size)) { it.convertToDataObject() }
    return o
}

fun Mask.convertToDataObject(): MaskKt {
    val o = MaskKt()
    o.maskId = maskId
    o.name = name
    o.picUrl = picUrl
    o.wearMaterialList = wearMaterialList.mapTo(ArrayList(wearMaterialList.size)) {
            it.convertToDataObject() }
    o.takeoffMaterialList = takeoffMaterialList.mapTo(ArrayList(takeoffMaterialList.size)) {
            it.convertToDataObject() }
    o.pureMaterialList = pureMaterialList.mapTo(ArrayList(pureMaterialList.size)) {
            it.convertToDataObject() }
    return o
}

fun Material.convertToDataObject(): MaterialKt {
    val o = MaterialKt()
    o.materialType = materialType
    o.materialId = materialId
    o.name = name
    o.zipUrl = zipUrl
    o.md5 = md5
    return o
}

fun Emoji.convertToDataObject(): EmojiKt {
    val o = EmojiKt()
    o.emojiId = emojiId
    o.name = name
    o.picUrl = picUrl
    o.resourceType = resourceType
    o.resourceUrl = resourceUrl
    return o
}

fun PlayingInfo.convertToDataObject(): PlayingInfoKt {
    val o = PlayingInfoKt()
    o.playType = playType
    o.playingId = playingId
    return o
}

fun PeerUseEmojiNotifyInfo.convertToDataObject(): PeerUseEmojiNotifyInfoKt {
    val o = PeerUseEmojiNotifyInfoKt()
    o.chatId = chatId
    o.emojiId = emojiId
    return o
}

fun ReadyJoinChatNotifyInfo.convertToDataObject(): ReadyJoinChatNotifyInfoKt {
    val o = ReadyJoinChatNotifyInfoKt()
    o.chatId = chatId
    o.roomId = roomId
    o.chatSource = chatSource
    o.uid1 = uid1
    o.uid2 = uid2
    o.roomVId = roomVId?.convertToDataObject()
    o.token = token
    return o
}

fun InviteTakeOffMaskNotifyInfo.convertToDataObject(): InviteTakeOffMaskNotifyInfoKt {
    val o = InviteTakeOffMaskNotifyInfoKt()
    o.chatId = chatId
    o.inviterUid = inviterUid
    return o
}

fun RejectTakeOffMaskNotifyInfo.convertToDataObject(): RejectTakeOffMaskNotifyInfoKt {
    val o = RejectTakeOffMaskNotifyInfoKt()
    o.chatId = chatId
    o.rejectUid = rejectUid
    return o
}

fun TakeOffMaskNotifyInfo.convertToDataObject(): TakeOffMaskNotifyInfoKt {
    val o = TakeOffMaskNotifyInfoKt()
    o.chatId = chatId
    return o
}

fun PeerClickClapNotifyInfo.convertToDataObject(): PeerClickClapNotifyInfoKt {
    val o = PeerClickClapNotifyInfoKt()
    o.chatId = chatId
    o.clapUid = clapUid
    return o
}

fun FinishClapNotifyInfo.convertToDataObject(): FinishClapNotifyInfoKt {
    val o = FinishClapNotifyInfoKt()
    o.chatId = chatId
    return o
}

fun PeerInviteStartPlayNotifyInfo.convertToDataObject(): PeerInviteStartPlayNotifyInfoKt {
    val o = PeerInviteStartPlayNotifyInfoKt()
    o.chatId = chatId
    o.playType = playType
    return o
}

fun PeerReplyStartPlayNotifyInfo.convertToDataObject(): PeerReplyStartPlayNotifyInfoKt {
    val o = PeerReplyStartPlayNotifyInfoKt()
    o.chatId = chatId
    o.playType = playType
    o.reply = reply
    return o
}

fun PeerCancelStartPlayNotifyInfo.convertToDataObject(): PeerCancelStartPlayNotifyInfoKt {
    val o = PeerCancelStartPlayNotifyInfoKt()
    o.chatId = chatId
    o.playType = playType
    return o
}
