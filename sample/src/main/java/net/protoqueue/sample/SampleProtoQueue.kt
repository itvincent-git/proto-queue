package net.protoqueue.sample

import android.util.Log
import kotlinx.coroutines.experimental.Deferred
import net.protoqueue.ProtoDisposable
import net.protoqueue.ProtoQueueBuilder
import net.protoqueue.annotation.ProtoQueueClass
import net.protoqueue.protoQueueLaunch

/**
 * Created by zhongyongsheng on 2018/4/20.
 */
@ProtoQueueClass(protoContextLiteral = "seqId")
abstract class SampleProtoQueue : BaseProtoQueue<SampleProto, Int>() {
    val TAG = "SampleProtoQueue"
    internal var mDeferred: Deferred<SampleProto>? = null

    override fun getOwnAppId(): Int {
        return 10086
    }

    override fun onNotificationData(proto: SampleProto) {
        Log.i(TAG, "onNotificationData: $proto")
    }

    companion object {
        @JvmStatic
        val instance: SampleProtoQueue by lazy {
            ProtoQueueBuilder.newBuilder(SampleProtoQueue::class.java, BaseProtoQueue.mSender).build()
        }
    }

    fun sendSampleProto(): ProtoDisposable? {
        val sampleProto = SampleProto(byteArrayOf(10, instance.incrementAndGetSeqContext().toByte(), 100))

        return instance.enqueue(sampleProto, 11,
                { proto -> Log.i(TAG, "onProto: $proto") })
    }

    fun sendSampleProtoByQueueParameter(): ProtoDisposable? {
        val sampleProto = SampleProto(byteArrayOf(10, instance.incrementAndGetSeqContext().toByte(), 100))

        return instance.newQueueParameter(sampleProto, 11) { proto -> Log.i(TAG, "onProto: $proto") }
                .timeout(3000)
                .error { error -> Log.i(TAG, "onError: $error")}
                .enqueue()
    }

    fun sendSampleProtoInCoroutine() {
        val sampleProto = SampleProto(byteArrayOf(10, instance.incrementAndGetSeqContext().toByte(), 100))

        //val disposable = enqueueInCoroutine(sampleProto, 11)
        protoQueueLaunch {
            try {
                mDeferred = newQueryParameterInCoroutine(sampleProto, 11)
                    .timeout(3000)
                    .enqueueInCoroutine()
                val ret = mDeferred?.await()
                Log.i(TAG, "sendSampleProtoInCoroutine onProto: $ret")
                ret
            } catch (e: Exception) {
                Log.e(TAG, "sendSampleProtoInCoroutine error: $e")
                SampleProto(byteArrayOf(0, 0, 0))
            }

        }
    }

    fun cancel() {
        mDeferred?.cancel()
    }
}
