package net.protoqueue.sample.simple

import net.protoqueue.ProtoDisposable

/**
 * Created by zhongyongsheng on 2018/4/20.
 */
class SampleProtoCore {
    private val topSid: Long = 100000
    private val subSid: Long = 100000
    internal var appId = 10086
    internal var mDisposable: ProtoDisposable? = null


    private val sampleProtoQueue = SampleProtoQueue.instance

    fun sendGameListReq() {
        mDisposable = sampleProtoQueue.sendSampleProto()
    }

    fun sendGameListReqByQueueParameter() {
        mDisposable = sampleProtoQueue.sendSampleProtoByQueueParameter()
    }

    fun mockOnReceive() {
        val sampleProto = SampleProto(
            byteArrayOf(11, sampleProtoQueue.getSeqContext().toByte(), 100))
        sampleProtoQueue.onReceiveData(appId, sampleProto.toByteArray())
    }

    fun dispose() {
        mDisposable?.dispose()
        sampleProtoQueue.cancel()
    }

    fun sendGameListReqInCoroutine() {
        sampleProtoQueue.sendSampleProtoInCoroutine()
    }

    companion object {
        private val TAG = "SampleProtoCore"
    }

}
