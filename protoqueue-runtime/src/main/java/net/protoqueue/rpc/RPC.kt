package net.protoqueue.rpc

/**
 * RPC调用的接口
 * Created by zhongyongsheng on 2020/4/22.
 */
interface RPC<REQ, RES> {
    /**
     * 发送请求并接收回复
     */
    suspend fun request(req: REQ, parameter: RequestParameter? = null): Response<RES?>

    /**
     * 注册监听广播或单播
     */
    fun registerResponse(block: (RES?, ResponseParameter) -> Unit): ResponseRegisterDisposable
}
