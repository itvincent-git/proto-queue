package net.protoqueue;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * 创建enqueue的参数
 * Created by zhongyongsheng on 2018/6/7.
 */
public class QueueParameter<P, C> {

    @NonNull ProtoQueue<P, C> protoQueue;
    @NonNull P proto;
    @NonNull int receiveUri;
    @NonNull ProtoReceiver<P> receiver;
    @Nullable ProtoErrorCallback error;
    int timeout = 10000;//默认10s

    QueueParameter(@NonNull ProtoQueue<P, C> protoQueue, @NonNull P proto, @NonNull int receiveUri,
                   @NonNull ProtoReceiver<P> receiver) {
        this.protoQueue = protoQueue;
        this.proto = proto;
        this.receiveUri = receiveUri;
        this.receiver = receiver;
    }

    /**
     * 错误回调
     * @param error
     * @return QueueParameter
     */
    public QueueParameter error(@NonNull ProtoErrorCallback error) {
        this.error = error;
        return this;
    }

    /**
     * 超时时长ms
     * @param timeout
     * @return QueueParameter
     */
    public QueueParameter timeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    /**
     * 进请求队列
     * @return ProtoDisposable
     */
    public ProtoDisposable enqueue() {
        return this.protoQueue.enqueue(proto,
                receiveUri,
                protoQueue.getTopSid(),
                protoQueue.getSubSid(),
                receiver,
                this);
    }
}
