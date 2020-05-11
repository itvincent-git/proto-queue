package net.protoqueue.sample.dsl

import net.protoqueue.sample.Header

/**
 * 模拟测试的PB协议
 * Created by zhongyongsheng on 2020/4/21.
 */
class DSLProto {
    var req: DSLRequest? = null
    var res: DSLResponse? = null
    var header: Header? = null

    @JvmField
    var uri = 0

    @JvmField
    var seqId = 0
    var data: ByteArray? = null

    fun toByteArray(): ByteArray? {
        return data
    }

    companion object {

        @JvmStatic
        fun parseFrom(data: ByteArray): DSLProto {
            return DSLProto().also { it.data = data }
        }
    }
}

object DSLCommon {
    const val kRequestUri = 1000
    const val kResponseUri = 2000
}

class DSLRequest {
    var uid: Long? = null
}

class DSLResponse {
    var uid: Long? = null
    var name: String? = null
}