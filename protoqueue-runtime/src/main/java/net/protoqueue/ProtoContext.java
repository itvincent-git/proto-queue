package net.protoqueue;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * proto上下文
 * Created by zhongyongsheng on 2018/4/21.
 */
public class ProtoContext<P, C> {
    byte[] data;
    ProtoReceiver receiver;
    int appId;
    C context;
    int receiveUri;
    long topSid;
    long subSid;
    ProtoDisposable protoDisposable = new ProtoDisposableImpl();
    QueueParameter parameter;


    public ProtoContext(byte[] data, ProtoReceiver receiver, int appId, C context, int receiveUri,
                        long topSid, long subSid, QueueParameter parameter) {
        this.data = data;
        this.receiver = receiver;
        this.appId = appId;
        this.context = context;
        this.receiveUri = receiveUri;
        this.topSid = topSid;
        this.subSid = subSid;
        this.parameter = parameter;
    }

    class ProtoDisposableImpl implements ProtoDisposable {
        AtomicBoolean isDisposed = new AtomicBoolean(false);

        @Override
        public void dispose() {
            isDisposed.set(true);
        }

        @Override
        public boolean isDisposed() {
            return isDisposed.get();
        }
    }
}
