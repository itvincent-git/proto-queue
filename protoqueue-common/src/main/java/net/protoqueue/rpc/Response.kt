package net.protoqueue.rpc

/**
 * 返回的结果
 * Created by zhongyongsheng on 2020/4/22.
 */
class Response<T>(val body: T, val parameter: ResponseParameter, val throwable: Throwable? = null)

/**
 * 处理请求的block，捕获异常返回带异常信息的[Response]
 */
suspend fun <T> catchThrowable(block: suspend () -> Response<T?>): Response<T?> {
    return try {
        block()
    } catch (t: Throwable) {
        Response(null, ResponseParameter(null), t)
    }
}