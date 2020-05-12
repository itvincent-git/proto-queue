package net.protoqueue.rpc

/**
 * 返回的结果
 * Created by zhongyongsheng on 2020/4/22.
 */
class Response<T>(val result: T, val parameter: ResponseParameter) {

    fun handlerResponse(success: (T) -> Unit, error: (Long, String) -> Unit) {

    }
}