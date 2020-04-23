package net.protoqueue.sample.dsl

import android.util.Log
import kotlinx.coroutines.Job
import net.protoqueue.ProtoQueueBuilder
import net.protoqueue.annotation.ProtoQueueClass
import net.protoqueue.enqueueAwaitOrNull
import net.protoqueue.rpc.Extension
import net.protoqueue.rpc.ProtoQueueRPC
import net.protoqueue.rpc.RPC
import net.protoqueue.rpc.Response
import net.protoqueue.sample.BaseProtoQueue

/**
 * DSL例子
 * Created by zhongyongsheng on 2020/4/17.
 */
@ProtoQueueClass(protoContextLiteral = "seqId")
abstract class DslProtoQueue : BaseProtoQueue<DSLProto, Int>() {
    val TAG = "DslProtoQueue"
    private var job: Job? = null

    override fun getOwnAppId(): Int {
        return 10000
    }

    override fun onNotificationData(proto: DSLProto) {
        Log.i(TAG, "onNotificationData: $proto")
    }

//    @ProtoQueueDsl
//    val serviceConfig = service {
//        rpc(name = "DSL", request = DSLRequest::class.java, response = DSLResponse::class.java,
//            requestUri = DSLCommon.kRequestUri, responseUri = DSLCommon.kResponseUri)
//    }

    @ProtoQueueRPC(requestUri = DSLCommon.kRequestUri, responseUri = DSLCommon.kResponseUri,
        requestProperty = "req", responseProperty = "res")
    fun rpcOne(): RPC<DSLRequest, DSLResponse> {
        return object : RPC<DSLRequest, DSLResponse> {
            override suspend fun request(req: DSLRequest): Response<DSLResponse?> {
                val proto = DSLProto()
                proto.req = req
                setUri(proto, DSLCommon.kRequestUri)
                val ret = enqueueAwaitOrNull(proto, DSLCommon.kResponseUri)
                return Response(ret?.res, Extension())
            }

            override suspend fun registerResponse(res: DSLResponse) {
                TODO("Not yet implemented")
            }
        }
    }

    companion object {
        @JvmStatic
        val instance: DslProtoQueue by lazy {
            ProtoQueueBuilder.newBuilder(DslProtoQueue::class.java,
                mSender).build()
        }
    }

    fun cancel() {
        job?.cancel()
    }
}
