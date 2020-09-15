package net.protoqueue.sample.dsl

import android.os.Handler
import android.os.Looper
import com.google.protobuf.nano.MessageNano
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import net.protoqueue.ProtoIntercepter
import net.protoqueue.ProtoReceiver
import net.protoqueue.ProtoSender
import net.protoqueue.annotation.ProtoQueueClass
import net.protoqueue.protoQueueCreator
import net.protoqueue.rpc.NoRequest
import net.protoqueue.rpc.ProtoQueueRPC
import net.protoqueue.rpc.RPC
import net.protoqueue.sample.proto.nano.TestProtos
import net.protoqueue.sample.proto.nano.TestProtos.kGlobalBroadcast
import net.protoqueue.sample.proto.nano.TestProtos.kLevelRequestUri
import net.protoqueue.sample.proto.nano.TestProtos.kLevelResponseUri
import net.protoqueue.sample.proto.nano.TestProtos.kUserRequestUri
import net.protoqueue.sample.proto.nano.TestProtos.kUserResponseUri
import net.protoqueue.sample.simple.BaseProtoQueue
import net.slog.SLoggerFactory
import net.stripe.lib.appScope
import java.util.Arrays

/**
 * DSL例子
 * Created by zhongyongsheng on 2020/4/17.
 */
private val log = SLoggerFactory.getLogger("DslProtoQueue")

//@ProtoQueueClass(resHeaderLiteral = "%L?.%L.response")
@ProtoQueueClass
abstract class RPCProtoQueue : BaseProtoQueue<TestProtos.DslProto, Long>() {

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

    @ProtoQueueRPC(requestUri = kLevelRequestUri, responseUri = kLevelResponseUri,
        requestProperty = "levelRequest", responseProperty = "levelResponse")
    abstract fun level(): RPC<TestProtos.PLevelRequest, TestProtos.PLevelResponse>

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

    /**
     * 测试用api的方式来请求
     */
    fun apiResquest() {
        val request = TestProtos.PUserRequest().apply {
            uid = 20001
        }
        val proto = TestProtos.DslProto()
        proto.userRequest = request
        proto.uri = 0
        enqueue(proto, 1, ProtoReceiver {
            log.debug("apiResquest res: ${it.userResponse}")
        })
    }

    companion object {
        var testSender = ProtoSender { appId, data, topSid, subSid ->
            log.info("onSend: $appId, ${Arrays.toString(data)}, $topSid, $subSid")

            //模拟服务器收包并回复
            handler.postDelayed({
                val sendProto = TestProtos.DslProto.parseFrom(data)
                //测试回复数据
                if (sendProto.uri == kUserRequestUri) {
                    val proto = TestProtos.DslProto().apply {
                        userResponse = TestProtos.PUserResponse().apply {
                            uid = sendProto.userRequest.uid
                            name = "jack"
                            uri = kUserResponseUri
                            header = TestProtos.PHeader().apply {
                                seqid = sendProto.header.seqid
                                result = TestProtos.Result()
                                result.code = 0
                                result.resMsg = "success"
                            }
                        }
                    }

                    instance.onReceiveData(appId, MessageNano.toByteArray(proto))
                }
            }, 100)
        }

        val intercepter: ProtoIntercepter = {
            log.debug("onIntercept ${it.javaClass}")
        }

        @JvmStatic
        val instance: RPCProtoQueue by protoQueueCreator(testSender, intercepter)
        private val handler = Handler(Looper.getMainLooper())
    }
}
