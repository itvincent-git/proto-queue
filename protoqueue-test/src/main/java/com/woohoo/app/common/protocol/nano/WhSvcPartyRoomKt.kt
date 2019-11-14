// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.woohoo.app.common.protocol.nano.WhSvcCommonKt.NotifyHeaderKt
import com.woohoo.app.common.protocol.nano.WhSvcCommonKt.ResponseHeaderKt
import com.woohoo.app.common.protocol.nano.WhSvcCommonKt.RoomVidKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.AcceptJoinChatInvitationNotify
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.AcceptJoinChatInvitationReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.AcceptJoinChatInvitationRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.AgreeJoinChatApplicationReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.AgreeJoinChatApplicationRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.ApplyJoinChatNotify
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.ApplyJoinChatReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.ApplyJoinChatRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.ChatManagerChangeNotify
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.ChatParticipant
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.ChatStatusChangeNotify
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.CreateAndJoinRoomReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.CreateAndJoinRoomRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.GetChatManagersReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.GetChatManagersRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.GetChatParticipantsReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.GetChatParticipantsRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.GetChatTopicsReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.GetChatTopicsRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.GetJoinChatApplicationsReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.GetJoinChatApplicationsRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.GetRoomInfoReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.GetRoomInfoRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.GetUserInRoomStatusReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.GetUserInRoomStatusRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.HeartbeatReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.HeartbeatRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.InviteJoinChatNotify
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.InviteJoinChatReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.InviteJoinChatRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.JoinChatApplication
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.JoinRoomReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.JoinRoomRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.KickUserNotifyNotify
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.KickUserReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.KickUserRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.LeaveChatReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.LeaveChatRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.LeaveRoomReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.LeaveRoomRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.RefuseJoinChatApplicationReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.RefuseJoinChatApplicationRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.RefuseJoinChatInvitationNotify
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.RefuseJoinChatInvitationReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.RefuseJoinChatInvitationRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.RoomInfo
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.RoomInfoChangeNotify
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.SwitchChatModeReq
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.SwitchChatModeRes
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoom.Topic
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.AcceptJoinChatInvitationNotifyKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.AcceptJoinChatInvitationReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.AcceptJoinChatInvitationResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.AgreeJoinChatApplicationReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.AgreeJoinChatApplicationResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.ApplyJoinChatNotifyKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.ApplyJoinChatReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.ApplyJoinChatResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.ChatManagerChangeNotifyKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.ChatParticipantKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.ChatStatusChangeNotifyKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.CreateAndJoinRoomReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.CreateAndJoinRoomResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.GetChatManagersReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.GetChatManagersResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.GetChatParticipantsReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.GetChatParticipantsResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.GetChatTopicsReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.GetChatTopicsResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.GetJoinChatApplicationsReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.GetJoinChatApplicationsResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.GetRoomInfoReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.GetRoomInfoResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.GetUserInRoomStatusReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.GetUserInRoomStatusResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.HeartbeatReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.HeartbeatResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.InviteJoinChatNotifyKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.InviteJoinChatReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.InviteJoinChatResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.JoinChatApplicationKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.JoinRoomReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.JoinRoomResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.KickUserNotifyNotifyKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.KickUserReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.KickUserResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.LeaveChatReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.LeaveChatResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.LeaveRoomReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.LeaveRoomResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.RefuseJoinChatApplicationReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.RefuseJoinChatApplicationResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.RefuseJoinChatInvitationNotifyKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.RefuseJoinChatInvitationReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.RefuseJoinChatInvitationResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.RoomInfoChangeNotifyKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.RoomInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.SwitchChatModeReqKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.SwitchChatModeResKt
import com.woohoo.app.common.protocol.nano.WhSvcPartyRoomKt.TopicKt
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.MutableList
import kotlin.collections.MutableMap
import kotlin.collections.mutableListOf
import kotlin.collections.mutableMapOf
import net.protoqueue.rpc.runtime.util.convertMap

class WhSvcPartyRoomKt {
    class CreateAndJoinRoomReqKt(
        var title: String? = null,
        var topicId: String? = null
    ) {
        fun convertToMessage(): CreateAndJoinRoomReq {
            val message = CreateAndJoinRoomReq()
            message.title = title
            message.topicId = topicId
            return message
        }
    }

    class CreateAndJoinRoomResKt(
        var header: ResponseHeaderKt? = null,
        var roomVid: RoomVidKt? = null,
        var roomId: Long? = null,
        var token: String? = null,
        var hbInterval: Int? = null,
        var session: String? = null,
        var manager: Boolean? = null
    ) {
        fun convertToMessage(): CreateAndJoinRoomRes {
            val message = CreateAndJoinRoomRes()
            message.header = header?.convertToMessage()
            message.roomVid = roomVid?.convertToMessage()
            message.roomId = roomId ?: 0L
            message.token = token
            message.hbInterval = hbInterval ?: 0
            message.session = session
            message.manager = manager ?: false
            return message
        }
    }

    class JoinRoomReqKt(
        var roomVid: RoomVidKt? = null
    ) {
        fun convertToMessage(): JoinRoomReq {
            val message = JoinRoomReq()
            message.roomVid = roomVid?.convertToMessage()
            return message
        }
    }

    class JoinRoomResKt(
        var header: ResponseHeaderKt? = null,
        var roomId: Long? = null,
        var session: String? = null,
        var hbInterval: Int? = null,
        var manager: Boolean? = null
    ) {
        fun convertToMessage(): JoinRoomRes {
            val message = JoinRoomRes()
            message.header = header?.convertToMessage()
            message.roomId = roomId ?: 0L
            message.session = session
            message.hbInterval = hbInterval ?: 0
            message.manager = manager ?: false
            return message
        }
    }

    class LeaveRoomReqKt(
        var roomVid: RoomVidKt? = null,
        var session: String? = null
    ) {
        fun convertToMessage(): LeaveRoomReq {
            val message = LeaveRoomReq()
            message.roomVid = roomVid?.convertToMessage()
            message.session = session
            return message
        }
    }

    class LeaveRoomResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): LeaveRoomRes {
            val message = LeaveRoomRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class HeartbeatReqKt(
        var roomVid: RoomVidKt? = null
    ) {
        fun convertToMessage(): HeartbeatReq {
            val message = HeartbeatReq()
            message.roomVid = roomVid?.convertToMessage()
            return message
        }
    }

    class HeartbeatResKt(
        var header: ResponseHeaderKt? = null,
        var hbInterval: Int? = null
    ) {
        fun convertToMessage(): HeartbeatRes {
            val message = HeartbeatRes()
            message.header = header?.convertToMessage()
            message.hbInterval = hbInterval ?: 0
            return message
        }
    }

    class GetChatTopicsReqKt() {
        fun convertToMessage(): GetChatTopicsReq {
            val message = GetChatTopicsReq()
            return message
        }
    }

    class TopicKt(
        var id: String? = null,
        var icon: String? = null
    ) {
        fun convertToMessage(): Topic {
            val message = Topic()
            message.id = id
            message.icon = icon
            return message
        }
    }

    class GetChatTopicsResKt(
        var header: ResponseHeaderKt? = null,
        var topics: MutableList<TopicKt> = mutableListOf()
    ) {
        fun convertToMessage(): GetChatTopicsRes {
            val message = GetChatTopicsRes()
            message.header = header?.convertToMessage()
            message.topics = topics.map { it.convertToMessage() }.toTypedArray()
            return message
        }
    }

    class GetChatManagersReqKt(
        var roomVid: RoomVidKt? = null
    ) {
        fun convertToMessage(): GetChatManagersReq {
            val message = GetChatManagersReq()
            message.roomVid = roomVid?.convertToMessage()
            return message
        }
    }

    class GetChatManagersResKt(
        var header: ResponseHeaderKt? = null,
        var managers: MutableList<Long> = mutableListOf()
    ) {
        fun convertToMessage(): GetChatManagersRes {
            val message = GetChatManagersRes()
            message.header = header?.convertToMessage()
            message.managers = managers.toLongArray()
            return message
        }
    }

    class ChatParticipantKt(
        var uid: Long? = null,
        var chatMode: Int? = null
    ) {
        fun convertToMessage(): ChatParticipant {
            val message = ChatParticipant()
            message.uid = uid ?: 0L
            message.chatMode = chatMode ?: 0
            return message
        }
    }

    class GetChatParticipantsReqKt(
        var roomVid: RoomVidKt? = null
    ) {
        fun convertToMessage(): GetChatParticipantsReq {
            val message = GetChatParticipantsReq()
            message.roomVid = roomVid?.convertToMessage()
            return message
        }
    }

    class GetChatParticipantsResKt(
        var header: ResponseHeaderKt? = null,
        var participants: MutableList<ChatParticipantKt> = mutableListOf()
    ) {
        fun convertToMessage(): GetChatParticipantsRes {
            val message = GetChatParticipantsRes()
            message.header = header?.convertToMessage()
            message.participants = participants.map { it.convertToMessage() }.toTypedArray()
            return message
        }
    }

    class ApplyJoinChatReqKt(
        var roomVid: RoomVidKt? = null
    ) {
        fun convertToMessage(): ApplyJoinChatReq {
            val message = ApplyJoinChatReq()
            message.roomVid = roomVid?.convertToMessage()
            return message
        }
    }

    class ApplyJoinChatResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): ApplyJoinChatRes {
            val message = ApplyJoinChatRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class AgreeJoinChatApplicationReqKt(
        var roomVid: RoomVidKt? = null,
        var applyUid: Long? = null
    ) {
        fun convertToMessage(): AgreeJoinChatApplicationReq {
            val message = AgreeJoinChatApplicationReq()
            message.roomVid = roomVid?.convertToMessage()
            message.applyUid = applyUid ?: 0L
            return message
        }
    }

    class AgreeJoinChatApplicationResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): AgreeJoinChatApplicationRes {
            val message = AgreeJoinChatApplicationRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class RefuseJoinChatApplicationReqKt(
        var roomVid: RoomVidKt? = null,
        var applyUid: Long? = null
    ) {
        fun convertToMessage(): RefuseJoinChatApplicationReq {
            val message = RefuseJoinChatApplicationReq()
            message.roomVid = roomVid?.convertToMessage()
            message.applyUid = applyUid ?: 0L
            return message
        }
    }

    class RefuseJoinChatApplicationResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): RefuseJoinChatApplicationRes {
            val message = RefuseJoinChatApplicationRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class GetJoinChatApplicationsReqKt(
        var roomVid: RoomVidKt? = null
    ) {
        fun convertToMessage(): GetJoinChatApplicationsReq {
            val message = GetJoinChatApplicationsReq()
            message.roomVid = roomVid?.convertToMessage()
            return message
        }
    }

    class JoinChatApplicationKt(
        var uid: Long? = null
    ) {
        fun convertToMessage(): JoinChatApplication {
            val message = JoinChatApplication()
            message.uid = uid ?: 0L
            return message
        }
    }

    class GetJoinChatApplicationsResKt(
        var header: ResponseHeaderKt? = null,
        var list: MutableList<JoinChatApplicationKt> = mutableListOf()
    ) {
        fun convertToMessage(): GetJoinChatApplicationsRes {
            val message = GetJoinChatApplicationsRes()
            message.header = header?.convertToMessage()
            message.list = list.map { it.convertToMessage() }.toTypedArray()
            return message
        }
    }

    class InviteJoinChatReqKt(
        var roomVid: RoomVidKt? = null,
        var targetUid: Long? = null
    ) {
        fun convertToMessage(): InviteJoinChatReq {
            val message = InviteJoinChatReq()
            message.roomVid = roomVid?.convertToMessage()
            message.targetUid = targetUid ?: 0L
            return message
        }
    }

    class InviteJoinChatResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): InviteJoinChatRes {
            val message = InviteJoinChatRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class AcceptJoinChatInvitationReqKt(
        var roomVid: RoomVidKt? = null,
        var inviteId: String? = null,
        var chatMode: Int? = null
    ) {
        fun convertToMessage(): AcceptJoinChatInvitationReq {
            val message = AcceptJoinChatInvitationReq()
            message.roomVid = roomVid?.convertToMessage()
            message.inviteId = inviteId
            message.chatMode = chatMode ?: 0
            return message
        }
    }

    class AcceptJoinChatInvitationResKt(
        var header: ResponseHeaderKt? = null,
        var token: String? = null
    ) {
        fun convertToMessage(): AcceptJoinChatInvitationRes {
            val message = AcceptJoinChatInvitationRes()
            message.header = header?.convertToMessage()
            message.token = token
            return message
        }
    }

    class RefuseJoinChatInvitationReqKt(
        var roomVid: RoomVidKt? = null,
        var inviteId: String? = null
    ) {
        fun convertToMessage(): RefuseJoinChatInvitationReq {
            val message = RefuseJoinChatInvitationReq()
            message.roomVid = roomVid?.convertToMessage()
            message.inviteId = inviteId
            return message
        }
    }

    class RefuseJoinChatInvitationResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): RefuseJoinChatInvitationRes {
            val message = RefuseJoinChatInvitationRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class LeaveChatReqKt(
        var roomVid: RoomVidKt? = null
    ) {
        fun convertToMessage(): LeaveChatReq {
            val message = LeaveChatReq()
            message.roomVid = roomVid?.convertToMessage()
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

    class SwitchChatModeReqKt(
        var roomVid: RoomVidKt? = null,
        var chatMode: Int? = null
    ) {
        fun convertToMessage(): SwitchChatModeReq {
            val message = SwitchChatModeReq()
            message.roomVid = roomVid?.convertToMessage()
            message.chatMode = chatMode ?: 0
            return message
        }
    }

    class SwitchChatModeResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): SwitchChatModeRes {
            val message = SwitchChatModeRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class KickUserReqKt(
        var roomVid: RoomVidKt? = null,
        var kickedUid: Long? = null,
        var type: Int? = null
    ) {
        fun convertToMessage(): KickUserReq {
            val message = KickUserReq()
            message.roomVid = roomVid?.convertToMessage()
            message.kickedUid = kickedUid ?: 0L
            message.type = type ?: 0
            return message
        }
    }

    class KickUserResKt() {
        fun convertToMessage(): KickUserRes {
            val message = KickUserRes()
            return message
        }
    }

    class GetUserInRoomStatusReqKt(
        var uids: MutableList<Long> = mutableListOf()
    ) {
        fun convertToMessage(): GetUserInRoomStatusReq {
            val message = GetUserInRoomStatusReq()
            message.uids = uids.toLongArray()
            return message
        }
    }

    class GetUserInRoomStatusResKt(
        var header: ResponseHeaderKt? = null,
        var uid2RoomVids: MutableMap<Long?, RoomVidKt?> = mutableMapOf()
    ) {
        fun convertToMessage(): GetUserInRoomStatusRes {
            val message = GetUserInRoomStatusRes()
            message.header = header?.convertToMessage()
            message.uid2RoomVids = uid2RoomVids.convertMap({ it.key }, {
                    it.value?.convertToMessage() })
            return message
        }
    }

    class RoomInfoKt(
        var roomVid: RoomVidKt? = null,
        var title: String? = null,
        var topic: String? = null,
        var participants: MutableList<Long> = mutableListOf(),
        var userCount: Long? = null
    ) {
        fun convertToMessage(): RoomInfo {
            val message = RoomInfo()
            message.roomVid = roomVid?.convertToMessage()
            message.title = title
            message.topic = topic
            message.participants = participants.toLongArray()
            message.userCount = userCount ?: 0L
            return message
        }
    }

    class GetRoomInfoReqKt(
        var roomVids: MutableList<RoomVidKt> = mutableListOf()
    ) {
        fun convertToMessage(): GetRoomInfoReq {
            val message = GetRoomInfoReq()
            message.roomVids = roomVids.map { it.convertToMessage() }.toTypedArray()
            return message
        }
    }

    class GetRoomInfoResKt(
        var header: ResponseHeaderKt? = null,
        var roomInfos: MutableList<RoomInfoKt> = mutableListOf()
    ) {
        fun convertToMessage(): GetRoomInfoRes {
            val message = GetRoomInfoRes()
            message.header = header?.convertToMessage()
            message.roomInfos = roomInfos.map { it.convertToMessage() }.toTypedArray()
            return message
        }
    }

    class ApplyJoinChatNotifyKt(
        var header: NotifyHeaderKt? = null,
        var roomVid: RoomVidKt? = null,
        var applyUid: Long? = null
    ) {
        fun convertToMessage(): ApplyJoinChatNotify {
            val message = ApplyJoinChatNotify()
            message.header = header?.convertToMessage()
            message.roomVid = roomVid?.convertToMessage()
            message.applyUid = applyUid ?: 0L
            return message
        }
    }

    class InviteJoinChatNotifyKt(
        var header: NotifyHeaderKt? = null,
        var roomVid: RoomVidKt? = null,
        var inviteId: String? = null
    ) {
        fun convertToMessage(): InviteJoinChatNotify {
            val message = InviteJoinChatNotify()
            message.header = header?.convertToMessage()
            message.roomVid = roomVid?.convertToMessage()
            message.inviteId = inviteId
            return message
        }
    }

    class AcceptJoinChatInvitationNotifyKt(
        var header: NotifyHeaderKt? = null,
        var roomVid: RoomVidKt? = null,
        var uid: Long? = null,
        var inviteId: String? = null
    ) {
        fun convertToMessage(): AcceptJoinChatInvitationNotify {
            val message = AcceptJoinChatInvitationNotify()
            message.header = header?.convertToMessage()
            message.roomVid = roomVid?.convertToMessage()
            message.uid = uid ?: 0L
            message.inviteId = inviteId
            return message
        }
    }

    class RefuseJoinChatInvitationNotifyKt(
        var header: NotifyHeaderKt? = null,
        var roomVid: RoomVidKt? = null,
        var uid: Long? = null,
        var inviteId: String? = null
    ) {
        fun convertToMessage(): RefuseJoinChatInvitationNotify {
            val message = RefuseJoinChatInvitationNotify()
            message.header = header?.convertToMessage()
            message.roomVid = roomVid?.convertToMessage()
            message.uid = uid ?: 0L
            message.inviteId = inviteId
            return message
        }
    }

    class ChatStatusChangeNotifyKt(
        var header: NotifyHeaderKt? = null,
        var roomVid: RoomVidKt? = null,
        var participants: MutableList<ChatParticipantKt> = mutableListOf()
    ) {
        fun convertToMessage(): ChatStatusChangeNotify {
            val message = ChatStatusChangeNotify()
            message.header = header?.convertToMessage()
            message.roomVid = roomVid?.convertToMessage()
            message.participants = participants.map { it.convertToMessage() }.toTypedArray()
            return message
        }
    }

    class ChatManagerChangeNotifyKt(
        var header: NotifyHeaderKt? = null,
        var roomVid: RoomVidKt? = null,
        var managers: MutableList<Long> = mutableListOf()
    ) {
        fun convertToMessage(): ChatManagerChangeNotify {
            val message = ChatManagerChangeNotify()
            message.header = header?.convertToMessage()
            message.roomVid = roomVid?.convertToMessage()
            message.managers = managers.toLongArray()
            return message
        }
    }

    class RoomInfoChangeNotifyKt(
        var header: NotifyHeaderKt? = null,
        var roomInfo: RoomInfoKt? = null
    ) {
        fun convertToMessage(): RoomInfoChangeNotify {
            val message = RoomInfoChangeNotify()
            message.header = header?.convertToMessage()
            message.roomInfo = roomInfo?.convertToMessage()
            return message
        }
    }

    class KickUserNotifyNotifyKt(
        var header: NotifyHeaderKt? = null,
        var roomVid: RoomVidKt? = null,
        var kickedUid: Long? = null,
        var type: Int? = null
    ) {
        fun convertToMessage(): KickUserNotifyNotify {
            val message = KickUserNotifyNotify()
            message.header = header?.convertToMessage()
            message.roomVid = roomVid?.convertToMessage()
            message.kickedUid = kickedUid ?: 0L
            message.type = type ?: 0
            return message
        }
    }

    interface ChatModeKt {
        companion object {
            val Unkonwn: Int = 0

            val Audio: Int = 1

            val Video: Int = 2

            val AllClose: Int = 3
        }
    }

    interface KickTypeKt {
        companion object {
            val Unknown: Int = 0

            val Room: Int = 1

            val Chat: Int = 2
        }
    }
}

fun CreateAndJoinRoomReq.convertToDataObject(): CreateAndJoinRoomReqKt {
    val o = CreateAndJoinRoomReqKt()
    o.title = title
    o.topicId = topicId
    return o
}

fun CreateAndJoinRoomRes.convertToDataObject(): CreateAndJoinRoomResKt {
    val o = CreateAndJoinRoomResKt()
    o.header = header?.convertToDataObject()
    o.roomVid = roomVid?.convertToDataObject()
    o.roomId = roomId
    o.token = token
    o.hbInterval = hbInterval
    o.session = session
    o.manager = manager
    return o
}

fun JoinRoomReq.convertToDataObject(): JoinRoomReqKt {
    val o = JoinRoomReqKt()
    o.roomVid = roomVid?.convertToDataObject()
    return o
}

fun JoinRoomRes.convertToDataObject(): JoinRoomResKt {
    val o = JoinRoomResKt()
    o.header = header?.convertToDataObject()
    o.roomId = roomId
    o.session = session
    o.hbInterval = hbInterval
    o.manager = manager
    return o
}

fun LeaveRoomReq.convertToDataObject(): LeaveRoomReqKt {
    val o = LeaveRoomReqKt()
    o.roomVid = roomVid?.convertToDataObject()
    o.session = session
    return o
}

fun LeaveRoomRes.convertToDataObject(): LeaveRoomResKt {
    val o = LeaveRoomResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun HeartbeatReq.convertToDataObject(): HeartbeatReqKt {
    val o = HeartbeatReqKt()
    o.roomVid = roomVid?.convertToDataObject()
    return o
}

fun HeartbeatRes.convertToDataObject(): HeartbeatResKt {
    val o = HeartbeatResKt()
    o.header = header?.convertToDataObject()
    o.hbInterval = hbInterval
    return o
}

fun GetChatTopicsReq.convertToDataObject(): GetChatTopicsReqKt {
    val o = GetChatTopicsReqKt()
    return o
}

fun Topic.convertToDataObject(): TopicKt {
    val o = TopicKt()
    o.id = id
    o.icon = icon
    return o
}

fun GetChatTopicsRes.convertToDataObject(): GetChatTopicsResKt {
    val o = GetChatTopicsResKt()
    o.header = header?.convertToDataObject()
    o.topics = topics.mapTo(ArrayList(topics.size)) { it.convertToDataObject() }
    return o
}

fun GetChatManagersReq.convertToDataObject(): GetChatManagersReqKt {
    val o = GetChatManagersReqKt()
    o.roomVid = roomVid?.convertToDataObject()
    return o
}

fun GetChatManagersRes.convertToDataObject(): GetChatManagersResKt {
    val o = GetChatManagersResKt()
    o.header = header?.convertToDataObject()
    o.managers = managers.toMutableList()
    return o
}

fun ChatParticipant.convertToDataObject(): ChatParticipantKt {
    val o = ChatParticipantKt()
    o.uid = uid
    o.chatMode = chatMode
    return o
}

fun GetChatParticipantsReq.convertToDataObject(): GetChatParticipantsReqKt {
    val o = GetChatParticipantsReqKt()
    o.roomVid = roomVid?.convertToDataObject()
    return o
}

fun GetChatParticipantsRes.convertToDataObject(): GetChatParticipantsResKt {
    val o = GetChatParticipantsResKt()
    o.header = header?.convertToDataObject()
    o.participants = participants.mapTo(ArrayList(participants.size)) { it.convertToDataObject() }
    return o
}

fun ApplyJoinChatReq.convertToDataObject(): ApplyJoinChatReqKt {
    val o = ApplyJoinChatReqKt()
    o.roomVid = roomVid?.convertToDataObject()
    return o
}

fun ApplyJoinChatRes.convertToDataObject(): ApplyJoinChatResKt {
    val o = ApplyJoinChatResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun AgreeJoinChatApplicationReq.convertToDataObject(): AgreeJoinChatApplicationReqKt {
    val o = AgreeJoinChatApplicationReqKt()
    o.roomVid = roomVid?.convertToDataObject()
    o.applyUid = applyUid
    return o
}

fun AgreeJoinChatApplicationRes.convertToDataObject(): AgreeJoinChatApplicationResKt {
    val o = AgreeJoinChatApplicationResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun RefuseJoinChatApplicationReq.convertToDataObject(): RefuseJoinChatApplicationReqKt {
    val o = RefuseJoinChatApplicationReqKt()
    o.roomVid = roomVid?.convertToDataObject()
    o.applyUid = applyUid
    return o
}

fun RefuseJoinChatApplicationRes.convertToDataObject(): RefuseJoinChatApplicationResKt {
    val o = RefuseJoinChatApplicationResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun GetJoinChatApplicationsReq.convertToDataObject(): GetJoinChatApplicationsReqKt {
    val o = GetJoinChatApplicationsReqKt()
    o.roomVid = roomVid?.convertToDataObject()
    return o
}

fun JoinChatApplication.convertToDataObject(): JoinChatApplicationKt {
    val o = JoinChatApplicationKt()
    o.uid = uid
    return o
}

fun GetJoinChatApplicationsRes.convertToDataObject(): GetJoinChatApplicationsResKt {
    val o = GetJoinChatApplicationsResKt()
    o.header = header?.convertToDataObject()
    o.list = list.mapTo(ArrayList(list.size)) { it.convertToDataObject() }
    return o
}

fun InviteJoinChatReq.convertToDataObject(): InviteJoinChatReqKt {
    val o = InviteJoinChatReqKt()
    o.roomVid = roomVid?.convertToDataObject()
    o.targetUid = targetUid
    return o
}

fun InviteJoinChatRes.convertToDataObject(): InviteJoinChatResKt {
    val o = InviteJoinChatResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun AcceptJoinChatInvitationReq.convertToDataObject(): AcceptJoinChatInvitationReqKt {
    val o = AcceptJoinChatInvitationReqKt()
    o.roomVid = roomVid?.convertToDataObject()
    o.inviteId = inviteId
    o.chatMode = chatMode
    return o
}

fun AcceptJoinChatInvitationRes.convertToDataObject(): AcceptJoinChatInvitationResKt {
    val o = AcceptJoinChatInvitationResKt()
    o.header = header?.convertToDataObject()
    o.token = token
    return o
}

fun RefuseJoinChatInvitationReq.convertToDataObject(): RefuseJoinChatInvitationReqKt {
    val o = RefuseJoinChatInvitationReqKt()
    o.roomVid = roomVid?.convertToDataObject()
    o.inviteId = inviteId
    return o
}

fun RefuseJoinChatInvitationRes.convertToDataObject(): RefuseJoinChatInvitationResKt {
    val o = RefuseJoinChatInvitationResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun LeaveChatReq.convertToDataObject(): LeaveChatReqKt {
    val o = LeaveChatReqKt()
    o.roomVid = roomVid?.convertToDataObject()
    return o
}

fun LeaveChatRes.convertToDataObject(): LeaveChatResKt {
    val o = LeaveChatResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun SwitchChatModeReq.convertToDataObject(): SwitchChatModeReqKt {
    val o = SwitchChatModeReqKt()
    o.roomVid = roomVid?.convertToDataObject()
    o.chatMode = chatMode
    return o
}

fun SwitchChatModeRes.convertToDataObject(): SwitchChatModeResKt {
    val o = SwitchChatModeResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun KickUserReq.convertToDataObject(): KickUserReqKt {
    val o = KickUserReqKt()
    o.roomVid = roomVid?.convertToDataObject()
    o.kickedUid = kickedUid
    o.type = type
    return o
}

fun KickUserRes.convertToDataObject(): KickUserResKt {
    val o = KickUserResKt()
    return o
}

fun GetUserInRoomStatusReq.convertToDataObject(): GetUserInRoomStatusReqKt {
    val o = GetUserInRoomStatusReqKt()
    o.uids = uids.toMutableList()
    return o
}

fun GetUserInRoomStatusRes.convertToDataObject(): GetUserInRoomStatusResKt {
    val o = GetUserInRoomStatusResKt()
    o.header = header?.convertToDataObject()
    o.uid2RoomVids = uid2RoomVids.convertMap({ it.key }, { it.value?.convertToDataObject() })
    return o
}

fun RoomInfo.convertToDataObject(): RoomInfoKt {
    val o = RoomInfoKt()
    o.roomVid = roomVid?.convertToDataObject()
    o.title = title
    o.topic = topic
    o.participants = participants.toMutableList()
    o.userCount = userCount
    return o
}

fun GetRoomInfoReq.convertToDataObject(): GetRoomInfoReqKt {
    val o = GetRoomInfoReqKt()
    o.roomVids = roomVids.mapTo(ArrayList(roomVids.size)) { it.convertToDataObject() }
    return o
}

fun GetRoomInfoRes.convertToDataObject(): GetRoomInfoResKt {
    val o = GetRoomInfoResKt()
    o.header = header?.convertToDataObject()
    o.roomInfos = roomInfos.mapTo(ArrayList(roomInfos.size)) { it.convertToDataObject() }
    return o
}

fun ApplyJoinChatNotify.convertToDataObject(): ApplyJoinChatNotifyKt {
    val o = ApplyJoinChatNotifyKt()
    o.header = header?.convertToDataObject()
    o.roomVid = roomVid?.convertToDataObject()
    o.applyUid = applyUid
    return o
}

fun InviteJoinChatNotify.convertToDataObject(): InviteJoinChatNotifyKt {
    val o = InviteJoinChatNotifyKt()
    o.header = header?.convertToDataObject()
    o.roomVid = roomVid?.convertToDataObject()
    o.inviteId = inviteId
    return o
}

fun AcceptJoinChatInvitationNotify.convertToDataObject(): AcceptJoinChatInvitationNotifyKt {
    val o = AcceptJoinChatInvitationNotifyKt()
    o.header = header?.convertToDataObject()
    o.roomVid = roomVid?.convertToDataObject()
    o.uid = uid
    o.inviteId = inviteId
    return o
}

fun RefuseJoinChatInvitationNotify.convertToDataObject(): RefuseJoinChatInvitationNotifyKt {
    val o = RefuseJoinChatInvitationNotifyKt()
    o.header = header?.convertToDataObject()
    o.roomVid = roomVid?.convertToDataObject()
    o.uid = uid
    o.inviteId = inviteId
    return o
}

fun ChatStatusChangeNotify.convertToDataObject(): ChatStatusChangeNotifyKt {
    val o = ChatStatusChangeNotifyKt()
    o.header = header?.convertToDataObject()
    o.roomVid = roomVid?.convertToDataObject()
    o.participants = participants.mapTo(ArrayList(participants.size)) { it.convertToDataObject() }
    return o
}

fun ChatManagerChangeNotify.convertToDataObject(): ChatManagerChangeNotifyKt {
    val o = ChatManagerChangeNotifyKt()
    o.header = header?.convertToDataObject()
    o.roomVid = roomVid?.convertToDataObject()
    o.managers = managers.toMutableList()
    return o
}

fun RoomInfoChangeNotify.convertToDataObject(): RoomInfoChangeNotifyKt {
    val o = RoomInfoChangeNotifyKt()
    o.header = header?.convertToDataObject()
    o.roomInfo = roomInfo?.convertToDataObject()
    return o
}

fun KickUserNotifyNotify.convertToDataObject(): KickUserNotifyNotifyKt {
    val o = KickUserNotifyNotifyKt()
    o.header = header?.convertToDataObject()
    o.roomVid = roomVid?.convertToDataObject()
    o.kickedUid = kickedUid
    o.type = type
    return o
}
