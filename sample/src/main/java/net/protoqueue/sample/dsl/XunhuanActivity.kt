package net.protoqueue.sample.dsl

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_xunhuan.btn_0
import kotlinx.coroutines.launch
import net.protoqueue.sample.R
import net.slog.SLoggerFactory
import net.stripe.lib.lifecycleScope

class XunhuanActivity : AppCompatActivity() {
    val log = SLoggerFactory.getLogger("Xunhuan")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xunhuan)

        btn_0.setOnClickListener {
            lifecycleScope.launch {
                val request = DSLRequest().apply {
                    uid = 10001
                }
                val response = DslProtoQueue.instance.rpcOne().request(request)
                log.info("rpcOne response:${response.result}")
            }
        }
    }
}
