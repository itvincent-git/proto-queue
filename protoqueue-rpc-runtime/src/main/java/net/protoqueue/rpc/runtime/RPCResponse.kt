package net.protoqueue.rpc.runtime

/**
 * RPC请求的回包，正常时返回body，异常时返回error
 * Created by zhongyongsheng on 2019-08-19.
 */
class RPCResponse<T>(val body: T? = null, val error: RPCError? = null, val parameter: RPCParameter? = null)