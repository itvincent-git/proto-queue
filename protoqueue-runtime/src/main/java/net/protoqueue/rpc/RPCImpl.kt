package net.protoqueue.rpc

//import net.protoqueue.ProtoQueue

/**
 * Created by zhongyongsheng on 2020/4/22.
 */
//class RPCImpl<PROTO, REQ, RES> : RPC<PROTO, REQ, RES> {
//    override suspend fun <C> ProtoQueue<PROTO, C>.request(req: REQ): Response<RES> {
//        val proto = PROTO::class.java.newInstance()
//        val req = REQ::class.java.newInstance()
//        try {
//            val uri = PROTO::class.java.getDeclaredField("uri")
//            uri.setInt(proto, reqUri)
//            enqueueAwaitOrNull(proto, resUri)?.let {
//                return resBlock(it as PROTO)
//            } ?: return null
//        } catch (t: Throwable) {
//            SLog.error(TAG, "$this onProtoException ", t)
//            return null
//        }
//    }
//
//    override suspend fun registerResponse(res: RES) {
//        TODO("Not yet implemented")
//    }
//}