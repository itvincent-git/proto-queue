package net.protoqueue.sample.dsl

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_xunhuan.global_broadcast
import kotlinx.android.synthetic.main.activity_xunhuan.user_request
import kotlinx.android.synthetic.main.activity_xunhuan.vm_request
import kotlinx.coroutines.launch
import net.protoqueue.rpc.rpcRegister
import net.protoqueue.sample.R
import net.protoqueue.sample.proto.nano.TestProtos
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

        //请求数据
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

        //发送测试广播
        global_broadcast.setOnClickListener {
            DslProtoQueue.instance.testBroadcast()
        }

        //注册监听广播
        rpcRegister {
            DslProtoQueue.instance.globalBroadcast().onResponse { pGlobalBroadcast, responseParameter ->
                log.info("globalBroadcast response code:${responseParameter.resultCode} msg:${responseParameter
                    .resultMsg}")
                log.info("globalBroadcast onResponse:$pGlobalBroadcast")
            }
        }

        vm_request.setOnClickListener {
            viewModel.sendRequest()
        }
    }
}
