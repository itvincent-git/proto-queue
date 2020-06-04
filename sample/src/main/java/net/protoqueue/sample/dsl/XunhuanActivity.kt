package net.protoqueue.sample.dsl

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.protobuf.nano.MessageNano
import kotlinx.android.synthetic.main.activity_xunhuan.global_broadcast
import kotlinx.android.synthetic.main.activity_xunhuan.user_request
import kotlinx.android.synthetic.main.activity_xunhuan.user_response
import kotlinx.coroutines.launch
import net.protoqueue.sample.R
import net.protoqueue.sample.proto.nano.TestProtos
import net.protoqueue.sample.proto.nano.TestProtos.kGlobalBroadcast
import net.protoqueue.sample.proto.nano.TestProtos.kUserResponseUri
import net.slog.SLoggerFactory
import net.stripe.lib.lifecycleScope

class XunhuanActivity : AppCompatActivity() {
    val log = SLoggerFactory.getLogger("Xunhuan")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xunhuan)

        user_request.setOnClickListener {
            lifecycleScope.launch {
                val request = TestProtos.PUserRequest().apply {
                    uid = 10001
                }
                log.info("rpcOne request:$request")
                val response = DslProtoQueue.instance.user().request(request)
                log.info("rpcOne response:${response.result}")
            }
        }

        user_response.setOnClickListener {
            val proto = TestProtos.DslProto().apply {
                userResponse = TestProtos.PUserResponse().apply {
                    uid = 10001
                    name = "jack"
                    uri = kUserResponseUri
                    header = TestProtos.PHeader().apply {
                        seqid = DslProtoQueue.instance.getSeqContext()
                        result = TestProtos.Result()
                        result.code = 0
                        result.resMsg = "success"
                    }
                }
            }
            DslProtoQueue.instance.onReceiveData(10000, MessageNano.toByteArray(proto))
        }

        DslProtoQueue.instance.globalBroadcast().registerResponse { pResponse, responseParameter ->
            log.info("globalBroadcast onResponse:$pResponse")
        }
        global_broadcast.setOnClickListener {
            val proto = TestProtos.DslProto().apply {
                broadcast = TestProtos.PGlobalBroadcast().apply {
                    payload = "Hello"
                    header = TestProtos.PHeader().apply {
                        uri = kGlobalBroadcast
                        seqid = DslProtoQueue.instance.getSeqContext() + 1L
                        result = TestProtos.Result()
                        result.code = 0
                        result.resMsg = "success"
                    }
                }
            }
            DslProtoQueue.instance.onReceiveData(10000, MessageNano.toByteArray(proto))
        }
    }
}
