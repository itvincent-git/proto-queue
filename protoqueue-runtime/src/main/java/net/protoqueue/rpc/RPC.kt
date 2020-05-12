package net.protoqueue.rpc

/**
 * Created by zhongyongsheng on 2020/4/22.
 */
interface RPC<REQ, RES> {
    suspend fun request(req: REQ, parameter: RequestParameter? = null): Response<RES?>

    suspend fun registerResponse(res: RES?, parameter: RequestParameter? = null)
}
