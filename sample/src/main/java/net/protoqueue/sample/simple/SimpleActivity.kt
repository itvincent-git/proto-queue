package net.protoqueue.sample.simple

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_simple.*
import net.protoqueue.sample.R

class SimpleActivity : AppCompatActivity() {
    var core = SampleProtoCore()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)

        send_report.setOnClickListener { core.sendGameListReq() }

        send_report_with_parameter.setOnClickListener { core.sendGameListReqByQueueParameter() }

        mock_receive.setOnClickListener { core.mockOnReceive() }

        dispose_receive.setOnClickListener { core.dispose() }

        send_report_in_coroutine.setOnClickListener { core.sendGameListReqInCoroutine() }
    }
}
