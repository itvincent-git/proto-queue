package net.protoqueue.sample

import net.protoqueue.ProtoQueueBuilder
import net.protoqueue.annotation.ProtoQueueClass

/**
 * Created by zhongyongsheng on 2018/4/20.
 */
@ProtoQueueClass(protoContextLiteral = "seqId")
abstract class SampleProtoQueue : BaseProtoQueue<SampleProto, Int>() {

    override fun getOwnAppId(): Int {
        return 10086
    }

    companion object {
        @JvmStatic
        val instance: SampleProtoQueue by lazy {
            ProtoQueueBuilder.newBuilder(SampleProtoQueue::class.java, BaseProtoQueue.mSender).build()
        }
    }
}
