package net.protoqueue.sample.simple

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import net.protoqueue.sample.R
import net.protoqueue.sample.dsl.RPCProtoQueue

/**
 * 测试ProtoQueue的api
 */
class ApiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api)

        RPCProtoQueue.instance.apiResquest()
    }
}
