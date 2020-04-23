package net.protoqueue.rpc

/**
 * Created by zhongyongsheng on 2020/4/22.
 */
interface RPC<REQ, RES> {
    suspend fun request(req: REQ): Response<RES?>

    suspend fun registerResponse(res: RES)
}
