package net.protoqueue.sample.dsl

import net.protoqueue.ProtoQueueBuilder
import net.protoqueue.annotation.ProtoQueueClass
import net.protoqueue.rpc.NoRequest
import net.protoqueue.rpc.ProtoQueueRPC
import net.protoqueue.rpc.RPC
import net.protoqueue.sample.proto.nano.TestProtos
import net.protoqueue.sample.proto.nano.TestProtos.kGlobalBroadcast
import net.protoqueue.sample.proto.nano.TestProtos.kUserRequestUri
import net.protoqueue.sample.proto.nano.TestProtos.kUserResponseUri
import net.protoqueue.sample.simple.BaseProtoQueue
import net.slog.SLoggerFactory

/**
 * DSL例子
 * Created by zhongyongsheng on 2020/4/17.
 */
@ProtoQueueClass
abstract class DslProtoQueue : BaseProtoQueue<TestProtos.DslProto, Long>() {
    private val log = SLoggerFactory.getLogger("DslProtoQueue")

    override fun getOwnAppId(): Int {
        return 10000
    }

    override fun onNotificationData(proto: TestProtos.DslProto) {
        log.info("onNotificationData: $proto")
    }

    override fun onProtoPreProcess(proto: TestProtos.DslProto) {
        proto.header = TestProtos.PHeader()
        proto.header.seqid = incrementAndGetSeqContext()
    }

    @ProtoQueueRPC(requestUri = kUserRequestUri, responseUri = kUserResponseUri,
        requestProperty = "userRequest", responseProperty = "userResponse")
    abstract fun user(): RPC<TestProtos.PUserRequest, TestProtos.PUserResponse>

    @ProtoQueueRPC(responseUri = kGlobalBroadcast, responseProperty = "broadcast")
    abstract fun globalBroadcast(): RPC<NoRequest, TestProtos.PGlobalBroadcast>

    companion object {
        @JvmStatic
        val instance: DslProtoQueue by lazy {
            ProtoQueueBuilder.newBuilder(DslProtoQueue::class.java,
                mSender).build()
        }
    }
}
