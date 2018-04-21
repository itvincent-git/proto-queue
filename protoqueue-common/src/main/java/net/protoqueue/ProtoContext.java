package net.protoqueue;

/**
 * Created by zhongyongsheng on 2018/4/21.
 */
public class ProtoContext<P> {
    byte[] mData;
    ProtoReceiver mReceiver;
    int appId;
    int context;
    int receiveUri;
    long topSid;
    long subSid;
    P proto;

    public ProtoContext(byte[] data, ProtoReceiver receiver, int appId, int context, int receiveUri, long topSid, long subSid) {
        this.mData = data;
        this.mReceiver = receiver;
        this.appId = appId;
        this.context = context;
        this.receiveUri = receiveUri;
        this.topSid = topSid;
        this.subSid = subSid;
    }
}
