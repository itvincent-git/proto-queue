package net.protoqueue;

import android.support.annotation.NonNull;

/**
 * 创建enqueue的参数
 * Created by zhongyongsheng on 2018/6/7.
 */
public class QueueParameter<P, C> {

    @NonNull ProtoQueue<P, C> protoQueue;

    @NonNull P proto;

    @NonNull int receiveUri;

    @NonNull ProtoReceiver<P> receiver;

    @NonNull ProtoErrorCallback error;

    int timeout = 10000;//默认10s

    /**
     * 错误回调
     * @param error
     * @return
     */
    public QueueParameter error(@NonNull ProtoErrorCallback error) {
        this.error = error;
        return this;
    }

    /**
     * 超时时长ms
     * @param timeout
     * @return
     */
    public QueueParameter timeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    public ProtoDisposable enqueue() {
        return this.protoQueue.enqueue(proto,
                protoQueue.getProtoContext(proto),
                receiveUri,
                protoQueue.getTopSid(),
                protoQueue.getSubSid(),
                receiver,
                this);
    }
}
