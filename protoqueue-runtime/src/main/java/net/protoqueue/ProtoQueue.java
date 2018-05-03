package net.protoqueue;

import android.os.Handler;
import android.os.Message;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * P代表ProtoBuffer类，C代表上下文的类型（例如seqId是Integer类型）
 * Created by zhongyongsheng on 2018/4/20.
 */
public abstract class ProtoQueue<P, C> {
    protected ProtoSender mProtoSender;
    protected Map<C, ProtoContext> mContextMap = new ConcurrentHashMap<>();

    public void init(ProtoSender protoSender) {
        mProtoSender = protoSender;
    }

    public ProtoSenderDisposable enqueue(P proto,
                                         ProtoReceiver<P> receiver,
                                         int receiveUri) {
        return enqueue(toByteArray(proto), receiver, getProtoContext(proto), receiveUri, getTopSid(), getSubSid());
    }

    protected ProtoSenderDisposable enqueue(byte[] data,
                                         ProtoReceiver<P> receiver,
                                         C context,
                                         int receiveUri,
                                         long topSid,
                                         long subSid) {
        Checker.checkDataNotNull(data);
        Checker.checkReceiverNotNull(receiver);

        ProtoContext<P, C> protoContext = new ProtoContext<>(data, receiver, getOwnAppId(), context, receiveUri, topSid, subSid);
        mContextMap.put(context, protoContext);
        mProtoSender.onSend(getOwnAppId(), data, topSid, subSid);
        return null;
    }

    protected void onNotifyData(int appId, byte[] data) {
        try {
            if (getOwnAppId() != appId) return;
            P proto = buildProto(data);
            C protoContext = getProtoContext(proto);

            ProtoContext context = mContextMap.remove(protoContext);
            if (context == null) return;
            context.mReceiver.onProto(proto);
        } catch (Throwable t) {
            onProtoException(t);
        }

    }

    protected Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {

            }
        }
    };

    public abstract C incrementAndGetSeqContext();

    public abstract C getSeqContext();

    protected abstract P buildProto(byte[] data);

    protected abstract byte[] toByteArray(P proto);

    protected abstract C getProtoContext(P proto);

    protected abstract int getOwnAppId();

    protected abstract long getTopSid();

    protected abstract long getSubSid();

    protected abstract void onProtoException(Throwable throwable);

}
