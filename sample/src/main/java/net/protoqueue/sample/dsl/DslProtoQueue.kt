package net.protoqueue.sample.dsl

import com.google.protobuf.nano.MessageNano
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
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
import net.stripe.lib.appScope

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

    //用于测试下发广播
    fun testBroadcast() {
        val proto = TestProtos.DslProto().apply {
            broadcast = TestProtos.PGlobalBroadcast().apply {
                payload = "Hello"
                header = TestProtos.PHeader().apply {
                    uri = kGlobalBroadcast
                    seqid = getSeqContext() + 1L
                    result = TestProtos.Result()
                    result.code = 0
                    result.resMsg = "success"
                }
            }
        }

        appScope.launch(Dispatchers.Main) {
            delay(2000)
            onReceiveData(10000, MessageNano.toByteArray(proto))
        }
    }

    companion object {
        @JvmStatic
        val instance: DslProtoQueue by lazy {
            ProtoQueueBuilder.newBuilder(DslProtoQueue::class.java, mSender).build()
        }
    }
}
