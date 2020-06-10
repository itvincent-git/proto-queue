package net.protoqueue.sample.dsl

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.protobuf.nano.MessageNano
import kotlinx.android.synthetic.main.activity_xunhuan.global_broadcast
import kotlinx.android.synthetic.main.activity_xunhuan.user_request
import kotlinx.android.synthetic.main.activity_xunhuan.user_response
import kotlinx.coroutines.launch
import net.protoqueue.rpc.rpcRegister
import net.protoqueue.sample.R
import net.protoqueue.sample.proto.nano.TestProtos
import net.protoqueue.sample.proto.nano.TestProtos.kUserResponseUri
import net.slog.SLoggerFactory
import net.stripe.lib.lifecycleScope

/**
 * 寻欢rpc例子
 */
class XunhuanActivity : AppCompatActivity() {
    val log = SLoggerFactory.getLogger("Xunhuan")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xunhuan)
        val viewModel = ViewModelProviders.of(this).get(XunhuanViewModel::class.java)

        user_request.setOnClickListener {
            lifecycleScope.launch {
                val request = TestProtos.PUserRequest().apply {
                    uid = 10001
                }
                log.info("user request:$request")
                val response = DslProtoQueue.instance.user().request(request)
                log.info("user response code:${response.parameter.resultCode} msg:${response.parameter
                    .resultMsg} body:${response.body} ")
                if (response.parameter.isSuccess) {
                    log.info("user response success")
                }
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

        global_broadcast.setOnClickListener {
            DslProtoQueue.instance.testBroadcast()
        }

        rpcRegister {
            DslProtoQueue.instance.globalBroadcast().onRegister { pGlobalBroadcast, responseParameter ->
                log.info("globalBroadcast response code:${responseParameter.resultCode} msg:${responseParameter
                    .resultMsg}")
                log.info("globalBroadcast onResponse:$pGlobalBroadcast")
            }
        }
    }
}
