package net.protoqueue.rpc

/**
 * 返回的结果
 * Created by zhongyongsheng on 2020/4/22.
 */
class Response<T>(val body: T, val parameter: ResponseParameter, val throwable: Throwable? = null)