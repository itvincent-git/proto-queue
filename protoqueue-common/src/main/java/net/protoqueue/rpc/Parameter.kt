package net.protoqueue.rpc

/**
 * RPC参数
 * Created by zhongyongsheng on 2020/4/22.
 */

/**
 * 请求参数
 */
class RequestParameter(val timeout: Int = 10000)

/**
 * 返回参数
 */
class ResponseParameter(val resCode: Int?, val resMsg: String?)