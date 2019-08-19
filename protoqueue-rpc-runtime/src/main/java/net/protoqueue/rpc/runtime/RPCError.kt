package net.protoqueue.rpc.runtime

/**
 * 异常信息
 */
class RPCError : Exception {
    /**
     * 客户端sdk的错误码
     */
    var sdkResCode: Int? = null
    /**
     * 服务端的错误码
     */
    var srvResCode: Int? = null

    constructor(message: String, ex: Throwable?) : super(message, ex) {}
    constructor(message: String) : super(message) {}
    constructor(ex: Throwable) : super(ex) {}
    constructor(_sdkResCode: Int, _srvResCode: Int) : super() {
        sdkResCode = _sdkResCode
        srvResCode = _srvResCode
    }

    override fun toString(): String {
        return "RPCError(sdkResCode=$sdkResCode, srvResCode=$srvResCode)"
    }
}