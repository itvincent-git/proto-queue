package net.protoqueue;

import android.os.Handler;
import android.os.Message;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhongyongsheng on 2018/4/20.
 */
public abstract class ProtoQueue<P> {
    protected ProtoSender mProtoSender;
    protected Map<Integer, ProtoContext> mContextMap = new ConcurrentHashMap<>();

    public void init(ProtoSender protoSender) {
        mProtoSender = protoSender;
    }

    public ProtoSenderDisposable enqueue(P proto,
                                         ProtoReceiver<P> receiver,
                                         int receiveUri) {
        return enqueue(toByteArray(proto), receiver, getSendContext(proto), receiveUri, getTopSid(), getSubSid());
    }

    protected ProtoSenderDisposable enqueue(byte[] data,
                                         ProtoReceiver<P> receiver,
                                         int context,
                                         int receiveUri,
                                         long topSid,
                                         long subSid) {
        Checker.checkDataNotNull(data);
        Checker.checkReceiverNotNull(receiver);

        mProtoSender.onSend(getOwnAppId(), data, topSid, subSid);
        ProtoContext<P> protoContext = new ProtoContext<>(data, receiver, getOwnAppId(), context, receiveUri, topSid, subSid);
        mContextMap.put(context, protoContext);
        return null;
    }

    protected void onNotifyData(int appId, byte[] data) {
        try {
            if (getOwnAppId() != appId) return;
            P proto = buildProto(data);
            int protoContext = getProtoContext(proto);

            ProtoContext context = mContextMap.remove(protoContext);
            if (context == null) return;
            context.mReceiver.onProto(proto);
        } catch (Exception e) {
            //todo exception issue
        }

    }

    protected abstract P buildProto(byte[] data);

    protected abstract byte[] toByteArray(P proto);

    protected abstract int getProtoContext(P proto);

    protected abstract int getOwnAppId();

    protected abstract long getTopSid();

    protected abstract long getSubSid();

    protected abstract int getSendContext(P proto);

    protected Handler mTimeoutHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
}
