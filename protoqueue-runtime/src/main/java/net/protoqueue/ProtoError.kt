package net.protoqueue

/**
 * ProtoQueue异常类型
 * Created by zhongyongsheng on 2018/5/6.
 */
open class ProtoError : Exception {
    constructor() {}
    constructor(message: String?) : super(message) {}
    constructor(message: String?, cause: Throwable?) : super(message, cause) {}
}