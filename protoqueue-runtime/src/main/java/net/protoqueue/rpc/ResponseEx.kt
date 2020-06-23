package net.protoqueue.rpc

/**
 * 处理请求的block，捕获异常返回带异常信息的[Response]
 */
suspend fun <T, REQ, RES> RPC<REQ, RES>.catchThrowable(block: suspend () -> Response<T?>): Response<T?> {
    return try {
        block()
    } catch (t: Throwable) {
        Response(null, ResponseParameter(null), t)
    }
}
