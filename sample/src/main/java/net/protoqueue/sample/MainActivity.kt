package net.protoqueue.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var core = SampleProtoCore()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        send_report.setOnClickListener { core.sendGameListReq() }

        mock_receive.setOnClickListener { core.mockOnReceive() }
    }
}
