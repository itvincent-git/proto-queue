package net.protoqueue.sample.dsl

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.protobuf.nano.MessageNano
import com.google.protobuf.nano.MessageNano.toByteArray
import kotlinx.android.synthetic.main.activity_simple.mock_receive
import kotlinx.android.synthetic.main.activity_xunhuan.rpc_one_request
import kotlinx.coroutines.launch
import net.protoqueue.sample.R
import net.protoqueue.sample.proto.nano.TestProtos
import net.slog.SLoggerFactory
import net.stripe.lib.lifecycleScope

class XunhuanActivity : AppCompatActivity() {
    val log = SLoggerFactory.getLogger("Xunhuan")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xunhuan)

        rpc_one_request.setOnClickListener {
            lifecycleScope.launch {
                val request = TestProtos.PRequest().apply {
                    uid = 10001
                }
                val response = DslProtoQueue.instance.rpcOne().request(request)
                log.info("rpcOne response:${response.result}")
            }
        }

        mock_receive.setOnClickListener {
            val proto = TestProtos.DslProto().apply {
                val res = TestProtos.PResponse().apply {
                    uid = 10001
                    name = "jack"
                    header = TestProtos.PHeader().apply {
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
