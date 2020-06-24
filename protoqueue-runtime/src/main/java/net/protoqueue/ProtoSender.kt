package net.protoqueue

/**
 * 定义协议发送的接口，子类实现发送到svc
 * Created by zhongyongsheng on 2018/4/20.
 */
interface ProtoSender {
    fun onSend(appId: Int, data: ByteArray, topSid: Long, subSid: Long)

    companion object {
        //兼容旧的写法
        operator fun invoke(block: (Int, ByteArray, Long, Long) -> Unit) = object : ProtoSender {
            override fun onSend(appId: Int, data: ByteArray, topSid: Long, subSid: Long) {
                block(appId, data, topSid, subSid)
            }
        }
    }
}