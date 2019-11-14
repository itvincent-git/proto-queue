// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.woohoo.app.common.protocol.nano.WhSvcApi.CommandCallbackReq
import com.woohoo.app.common.protocol.nano.WhSvcApi.CommandCallbackRes
import com.woohoo.app.common.protocol.nano.WhSvcApi.CommandInfo
import com.woohoo.app.common.protocol.nano.WhSvcApi.GetPendingCommandReq
import com.woohoo.app.common.protocol.nano.WhSvcApi.GetPendingCommandRes
import com.woohoo.app.common.protocol.nano.WhSvcApi.GetPrivacySettingReq
import com.woohoo.app.common.protocol.nano.WhSvcApi.GetPrivacySettingRes
import com.woohoo.app.common.protocol.nano.WhSvcApi.LogCondition
import com.woohoo.app.common.protocol.nano.WhSvcApi.LogResult
import com.woohoo.app.common.protocol.nano.WhSvcApi.SetPrivacySettingReq
import com.woohoo.app.common.protocol.nano.WhSvcApi.SetPrivacySettingRes
import com.woohoo.app.common.protocol.nano.WhSvcApiKt.CommandCallbackReqKt
import com.woohoo.app.common.protocol.nano.WhSvcApiKt.CommandCallbackResKt
import com.woohoo.app.common.protocol.nano.WhSvcApiKt.CommandInfoKt
import com.woohoo.app.common.protocol.nano.WhSvcApiKt.GetPendingCommandReqKt
import com.woohoo.app.common.protocol.nano.WhSvcApiKt.GetPendingCommandResKt
import com.woohoo.app.common.protocol.nano.WhSvcApiKt.GetPrivacySettingReqKt
import com.woohoo.app.common.protocol.nano.WhSvcApiKt.GetPrivacySettingResKt
import com.woohoo.app.common.protocol.nano.WhSvcApiKt.LogConditionKt
import com.woohoo.app.common.protocol.nano.WhSvcApiKt.LogResultKt
import com.woohoo.app.common.protocol.nano.WhSvcApiKt.SetPrivacySettingReqKt
import com.woohoo.app.common.protocol.nano.WhSvcApiKt.SetPrivacySettingResKt
import com.woohoo.app.common.protocol.nano.WhSvcCommonKt.ResponseHeaderKt
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf

class WhSvcApiKt {
    class SetPrivacySettingReqKt(
        var type: Int? = null,
        var status: Boolean? = null
    ) {
        fun convertToMessage(): SetPrivacySettingReq {
            val message = SetPrivacySettingReq()
            message.type = type ?: 0
            message.status = status ?: false
            return message
        }
    }

    class SetPrivacySettingResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): SetPrivacySettingRes {
            val message = SetPrivacySettingRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class GetPrivacySettingReqKt() {
        fun convertToMessage(): GetPrivacySettingReq {
            val message = GetPrivacySettingReq()
            return message
        }
    }

    class GetPrivacySettingResKt(
        var header: ResponseHeaderKt? = null,
        var recommendToFbFriend: Boolean? = null,
        var recommendToGFriend: Boolean? = null,
        var recommendToNear: Boolean? = null
    ) {
        fun convertToMessage(): GetPrivacySettingRes {
            val message = GetPrivacySettingRes()
            message.header = header?.convertToMessage()
            message.recommendToFbFriend = recommendToFbFriend ?: false
            message.recommendToGFriend = recommendToGFriend ?: false
            message.recommendToNear = recommendToNear ?: false
            return message
        }
    }

    class CommandInfoKt(
        var cmdId: String? = null,
        var cmdType: Int? = null,
        var logCondition: LogConditionKt? = null
    ) {
        fun convertToMessage(): CommandInfo {
            val message = CommandInfo()
            message.cmdId = cmdId
            message.cmdType = cmdType ?: 0
            message.logCondition = logCondition?.convertToMessage()
            return message
        }
    }

    class LogConditionKt(
        var startTime: Long? = null,
        var endTime: Long? = null,
        var containSdk: Boolean? = null
    ) {
        fun convertToMessage(): LogCondition {
            val message = LogCondition()
            message.startTime = startTime ?: 0L
            message.endTime = endTime ?: 0L
            message.containSdk = containSdk ?: false
            return message
        }
    }

    class GetPendingCommandReqKt() {
        fun convertToMessage(): GetPendingCommandReq {
            val message = GetPendingCommandReq()
            return message
        }
    }

    class GetPendingCommandResKt(
        var header: ResponseHeaderKt? = null,
        var commandInfos: MutableList<CommandInfoKt> = mutableListOf()
    ) {
        fun convertToMessage(): GetPendingCommandRes {
            val message = GetPendingCommandRes()
            message.header = header?.convertToMessage()
            message.commandInfos = commandInfos.map { it.convertToMessage() }.toTypedArray()
            return message
        }
    }

    class CommandCallbackReqKt(
        var cmdId: String? = null,
        var ack: Boolean? = null,
        var logResult: LogResultKt? = null
    ) {
        fun convertToMessage(): CommandCallbackReq {
            val message = CommandCallbackReq()
            message.cmdId = cmdId
            message.ack = ack ?: false
            message.logResult = logResult?.convertToMessage()
            return message
        }
    }

    class LogResultKt(
        var logUrl: String? = null
    ) {
        fun convertToMessage(): LogResult {
            val message = LogResult()
            message.logUrl = logUrl
            return message
        }
    }

    class CommandCallbackResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): CommandCallbackRes {
            val message = CommandCallbackRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    interface CmdTypeKt {
        companion object {
            val CmdUnknown: Int = 0

            val LogPull: Int = 1
        }
    }

    interface PrivacySettingTypeKt {
        companion object {
            val PrivacyTypeUnknown: Int = 0

            val RecommendToFbFriend: Int = 1

            val RecommendToGFriend: Int = 2

            val RecommendToNear: Int = 3
        }
    }
}

fun SetPrivacySettingReq.convertToDataObject(): SetPrivacySettingReqKt {
    val o = SetPrivacySettingReqKt()
    o.type = type
    o.status = status
    return o
}

fun SetPrivacySettingRes.convertToDataObject(): SetPrivacySettingResKt {
    val o = SetPrivacySettingResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun GetPrivacySettingReq.convertToDataObject(): GetPrivacySettingReqKt {
    val o = GetPrivacySettingReqKt()
    return o
}

fun GetPrivacySettingRes.convertToDataObject(): GetPrivacySettingResKt {
    val o = GetPrivacySettingResKt()
    o.header = header?.convertToDataObject()
    o.recommendToFbFriend = recommendToFbFriend
    o.recommendToGFriend = recommendToGFriend
    o.recommendToNear = recommendToNear
    return o
}

fun CommandInfo.convertToDataObject(): CommandInfoKt {
    val o = CommandInfoKt()
    o.cmdId = cmdId
    o.cmdType = cmdType
    o.logCondition = logCondition?.convertToDataObject()
    return o
}

fun LogCondition.convertToDataObject(): LogConditionKt {
    val o = LogConditionKt()
    o.startTime = startTime
    o.endTime = endTime
    o.containSdk = containSdk
    return o
}

fun GetPendingCommandReq.convertToDataObject(): GetPendingCommandReqKt {
    val o = GetPendingCommandReqKt()
    return o
}

fun GetPendingCommandRes.convertToDataObject(): GetPendingCommandResKt {
    val o = GetPendingCommandResKt()
    o.header = header?.convertToDataObject()
    o.commandInfos = commandInfos.mapTo(ArrayList(commandInfos.size)) { it.convertToDataObject() }
    return o
}

fun CommandCallbackReq.convertToDataObject(): CommandCallbackReqKt {
    val o = CommandCallbackReqKt()
    o.cmdId = cmdId
    o.ack = ack
    o.logResult = logResult?.convertToDataObject()
    return o
}

fun LogResult.convertToDataObject(): LogResultKt {
    val o = LogResultKt()
    o.logUrl = logUrl
    return o
}

fun CommandCallbackRes.convertToDataObject(): CommandCallbackResKt {
    val o = CommandCallbackResKt()
    o.header = header?.convertToDataObject()
    return o
}
