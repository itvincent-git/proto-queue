package net.protoqueue.sample.simple

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.withContext
import net.protoqueue.ProtoDisposable
import net.protoqueue.ProtoQueueBuilder
import net.protoqueue.annotation.ProtoQueueClass
import net.protoqueue.enqueueAwaitOrNull
import net.protoqueue.protoQueueLaunch

/**
 * Created by zhongyongsheng on 2018/4/20.
 */
@ProtoQueueClass
abstract class SampleProtoQueue : BaseProtoQueue<SampleProto, Long>() {
    val TAG = "SampleProtoQueue"
    private var job: Job? = null

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
        val sampleProto = SampleProto(
            byteArrayOf(10, instance.incrementAndGetSeqContext().toByte(), 100))

        return instance.enqueue(sampleProto, 11,
            { proto -> Log.i(TAG, "onProto: $proto") })
    }

    fun sendSampleProtoByQueueParameter(): ProtoDisposable? {
        val sampleProto = SampleProto(
            byteArrayOf(10, instance.incrementAndGetSeqContext().toByte(), 100))

        return instance.newQueueParameter(sampleProto, 11) { proto -> Log.i(TAG, "onProto: $proto") }
            .timeout(3000)
            .error { error -> Log.i(TAG, "onError: $error") }
            .enqueue()
    }

    fun sendSampleProtoInCoroutine() {
        val sampleProto = SampleProto(
            byteArrayOf(10, instance.incrementAndGetSeqContext().toByte(), 100))

        //enqueueAwait
        /*job = protoQueueLaunch {
            try {
                val ret = enqueueAwait(sampleProto, 11)

                //test something do in the ui thread
                withContext(Dispatchers.Main) {
                    Log.i(TAG, "[${Thread.currentThread().name}]sendSampleProtoInCoroutine onProto: $ret")
                }
            } catch (e: Exception) {
                Log.e(TAG, "sendSampleProtoInCoroutine error: $e")
                SampleProto(byteArrayOf(0, 0, 0))
            }
        }*/

        //enqueueAwaitOrNull and timeout
        job = protoQueueLaunch {
            val ret = enqueueAwaitOrNull(sampleProto, 11, 3000)

            //test something do in the ui thread
            withContext(Dispatchers.Main) {
                Log.i(TAG, "[${Thread.currentThread().name}]sendSampleProtoInCoroutine onProto: $ret")
            }
        }
    }

    fun cancel() {
        job?.cancel()
    }
}
