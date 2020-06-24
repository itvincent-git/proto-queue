package net.protoqueue.sample.simple

import net.protoqueue.ProtoQueue
import net.protoqueue.ProtoSender
import net.slog.SLog
import java.util.Arrays

/**
 * 业务实现ProtoQueue的基类
 * Created by zhongyongsheng on 2018/4/27.
 */
abstract class BaseProtoQueue<P, C> : ProtoQueue<P, C>() {
    override fun getTopSid(): Long {
        return 0
    }

    override fun getSubSid(): Long {
        return 0
    }

    fun onReceiveData(appId: Int, data: ByteArray?) {
        super.onNotifyData(appId, data!!)
    }

    override fun onProtoException(throwable: Throwable) {}
    override fun onProtoPreProcess(proto: P) {}

    companion object {
        private const val TAG = "BaseProtoQueue"
        protected var mSender = object : ProtoSender {
            override fun onSend(appId: Int, data: ByteArray?, topSid: Long, subSid: Long) {
                SLog.info(TAG,
                    String.format("onSend: %d, %s, %d, %d", appId, Arrays.toString(data),
                        topSid, subSid))
            }
        }
    }
}