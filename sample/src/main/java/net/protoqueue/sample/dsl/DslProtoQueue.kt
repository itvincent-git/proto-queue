package net.protoqueue.sample.dsl

import android.util.Log
import kotlinx.coroutines.Job
import net.protoqueue.ProtoQueueBuilder
import net.protoqueue.annotation.ProtoQueueClass
import net.protoqueue.rpc.ProtoQueueRPC
import net.protoqueue.rpc.RPC
import net.protoqueue.sample.proto.nano.TestProtos
import net.protoqueue.sample.proto.nano.TestProtos.kRequestUri
import net.protoqueue.sample.proto.nano.TestProtos.kResponseUri
import net.protoqueue.sample.simple.BaseProtoQueue

/**
 * DSL例子
 * Created by zhongyongsheng on 2020/4/17.
 */
@ProtoQueueClass
abstract class DslProtoQueue : BaseProtoQueue<TestProtos.DslProto, Long>() {
    val TAG = "DslProtoQueue"
    private var job: Job? = null

    override fun getOwnAppId(): Int {
        return 10000
    }

    override fun onNotificationData(proto: TestProtos.DslProto) {
        Log.i(TAG, "onNotificationData: $proto")
    }

    override fun onProtoPreProcess(proto: TestProtos.DslProto) {
        proto.header = TestProtos.PHeader()
        proto.header.seqid = incrementAndGetSeqContext()
    }

//    @ProtoQueueDsl
//    val serviceConfig = service {
//        rpc(name = "DSL", request = DSLRequest::class.java, response = DSLResponse::class.java,
//            requestUri = DSLCommon.kRequestUri, responseUri = DSLCommon.kResponseUri)
//    }

    @ProtoQueueRPC(requestUri = kRequestUri, responseUri = kResponseUri,
        requestProperty = "request", responseProperty = "response")
    abstract fun rpcOne(): RPC<TestProtos.PRequest, TestProtos.PResponse>

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
