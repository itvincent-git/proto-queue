package net.protoqueue;

/**
 * Created by zhongyongsheng on 2018/4/20.
 */
public abstract class ProtoQueue {
    ProtoSender mProtoSender = null;

    public void init(ProtoSender protoSender) {
        mProtoSender = protoSender;
    }

    public ProtoSenderDisposable enqueue(byte[] data,
                                         ProtoDataReceiver receiver,
                                         int appId,
                                         String context,
                                         int receiveUri,
                                         long topSid,
                                         long subSid) {

        mProtoSender.onSend(appId, data, topSid, subSid);
        return null;
    }

    protected void onNotifyData(int appId, byte[] data) {
        if (getOwnAppId() != appId) return;
        ProtoDataReceiver protoDataReceiver = getProtoDataReceiver(appId);
        protoDataReceiver.onData(data);
    }

    public ProtoDataReceiver getProtoDataReceiver(int appId) {

    }

    protected abstract int getOwnAppId();
}
