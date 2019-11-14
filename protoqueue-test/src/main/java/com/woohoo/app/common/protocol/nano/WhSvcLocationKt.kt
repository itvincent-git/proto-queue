// Generate by protoqueue-rpc, don't edit this file please
package com.woohoo.app.common.protocol.nano

import com.woohoo.app.common.protocol.nano.WhSvcCommonKt.ResponseHeaderKt
import com.woohoo.app.common.protocol.nano.WhSvcLocation.GetReportConfigReq
import com.woohoo.app.common.protocol.nano.WhSvcLocation.GetReportConfigRes
import com.woohoo.app.common.protocol.nano.WhSvcLocation.ReportLocationReq
import com.woohoo.app.common.protocol.nano.WhSvcLocation.ReportLocationRes
import com.woohoo.app.common.protocol.nano.WhSvcLocation.SwitchLocationReq
import com.woohoo.app.common.protocol.nano.WhSvcLocation.SwitchLocationRes
import com.woohoo.app.common.protocol.nano.WhSvcLocationKt.GetReportConfigReqKt
import com.woohoo.app.common.protocol.nano.WhSvcLocationKt.GetReportConfigResKt
import com.woohoo.app.common.protocol.nano.WhSvcLocationKt.ReportLocationReqKt
import com.woohoo.app.common.protocol.nano.WhSvcLocationKt.ReportLocationResKt
import com.woohoo.app.common.protocol.nano.WhSvcLocationKt.SwitchLocationReqKt
import com.woohoo.app.common.protocol.nano.WhSvcLocationKt.SwitchLocationResKt
import kotlin.Boolean
import kotlin.Double
import kotlin.Long
import kotlin.String

class WhSvcLocationKt {
    class GetReportConfigReqKt() {
        fun convertToMessage(): GetReportConfigReq {
            val message = GetReportConfigReq()
            return message
        }
    }

    class GetReportConfigResKt(
        var header: ResponseHeaderKt? = null,
        var interval: Long? = null
    ) {
        fun convertToMessage(): GetReportConfigRes {
            val message = GetReportConfigRes()
            message.header = header?.convertToMessage()
            message.interval = interval ?: 0L
            return message
        }
    }

    class ReportLocationReqKt(
        var latitude: Double? = null,
        var longitude: Double? = null,
        var city: String? = null,
        var country: String? = null
    ) {
        fun convertToMessage(): ReportLocationReq {
            val message = ReportLocationReq()
            message.latitude = latitude ?: 0.0
            message.longitude = longitude ?: 0.0
            message.city = city
            message.country = country
            return message
        }
    }

    class ReportLocationResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): ReportLocationRes {
            val message = ReportLocationRes()
            message.header = header?.convertToMessage()
            return message
        }
    }

    class SwitchLocationReqKt(
        var disable: Boolean? = null
    ) {
        fun convertToMessage(): SwitchLocationReq {
            val message = SwitchLocationReq()
            message.disable = disable ?: false
            return message
        }
    }

    class SwitchLocationResKt(
        var header: ResponseHeaderKt? = null
    ) {
        fun convertToMessage(): SwitchLocationRes {
            val message = SwitchLocationRes()
            message.header = header?.convertToMessage()
            return message
        }
    }
}

fun GetReportConfigReq.convertToDataObject(): GetReportConfigReqKt {
    val o = GetReportConfigReqKt()
    return o
}

fun GetReportConfigRes.convertToDataObject(): GetReportConfigResKt {
    val o = GetReportConfigResKt()
    o.header = header?.convertToDataObject()
    o.interval = interval
    return o
}

fun ReportLocationReq.convertToDataObject(): ReportLocationReqKt {
    val o = ReportLocationReqKt()
    o.latitude = latitude
    o.longitude = longitude
    o.city = city
    o.country = country
    return o
}

fun ReportLocationRes.convertToDataObject(): ReportLocationResKt {
    val o = ReportLocationResKt()
    o.header = header?.convertToDataObject()
    return o
}

fun SwitchLocationReq.convertToDataObject(): SwitchLocationReqKt {
    val o = SwitchLocationReqKt()
    o.disable = disable
    return o
}

fun SwitchLocationRes.convertToDataObject(): SwitchLocationResKt {
    val o = SwitchLocationResKt()
    o.header = header?.convertToDataObject()
    return o
}
