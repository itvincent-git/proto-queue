package net.protoqueue.sample.dsl

import net.protoqueue.rpc.ResponseParameter
import net.protoqueue.sample.proto.nano.TestProtos

/**
 * ResponseParameter的扩展
 * Created by zhongyongsheng on 2020/6/4.
 */
val ResponseParameter.resultCode: Int
    get() = if (payload is TestProtos.PHeader) {
        (payload as TestProtos.PHeader).result.code
    } else Int.MIN_VALUE

val ResponseParameter.resultMsg: String
    get() = if (payload is TestProtos.PHeader) {
        (payload as TestProtos.PHeader).result.resMsg
    } else ""

val ResponseParameter.isSuccess: Boolean
    get() = if (payload is TestProtos.PHeader) {
        (payload as TestProtos.PHeader).result.code == 0
    } else false