package net.protoqueue

/**
 * 创建enqueue的参数
 * Created by zhongyongsheng on 2018/6/7.
 */
class QueueParameter<P, C> internal constructor(private var protoQueue: ProtoQueue<P, C>,
                                                private var proto: P,
                                                private var receiveUri: Int,
                                                private var receiver: (P) -> Unit) {
    internal var error: ((ProtoError) -> Unit?)? = null
    internal var timeout = 10000//默认10s

    /**
     * 错误回调
     * @param error
     * @return QueueParameter
     */
    fun error(error: (ProtoError) -> Unit): QueueParameter<P, C> {
        this.error = error
        return this
    }

    /**
     * 超时时长ms
     * @param timeout
     * @return QueueParameter
     */
    fun timeout(timeout: Int): QueueParameter<P, C> {
        this.timeout = timeout
        return this
    }

    /**
     * 进请求队列
     * @return ProtoDisposable
     */
    fun enqueue(): ProtoDisposable {
        return this.protoQueue.enqueue(proto,
                receiveUri,
                protoQueue.iGetTopSid(),
                protoQueue.iGetSubSid(),
                receiver,
                this)
    }
}
