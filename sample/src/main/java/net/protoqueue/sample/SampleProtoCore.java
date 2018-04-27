package net.protoqueue.sample;

import android.util.Log;

import net.protoqueue.ProtoReceiver;

/**
 * Created by zhongyongsheng on 2018/4/20.
 */
public class SampleProtoCore {
    private static final String TAG = "SampleProtoCore";
    private long topSid = 100000;
    private long subSid = 100000;
    int appId = 10086;

    private SampleProtoQueue sampleProtoQueue = SampleProtoQueue.getInstance();

    public void sendGameListReq() {
        SampleProto sampleProto = new SampleProto(new byte[]
                {10, (byte) sampleProtoQueue.incrementAndGetSeqContext(), 100});
        int receiveUri = 11;

        sampleProtoQueue.enqueue(sampleProto, new ProtoReceiver<SampleProto>() {
            @Override
            public void onProto(SampleProto proto) {
                Log.i(TAG, "onProto: " + proto);
            }
        }, receiveUri);
    }

    public void mockOnReceive() {
        SampleProto sampleProto = new SampleProto(new byte[]
                {11, (byte) sampleProtoQueue.getSeqContext(), 100});
        sampleProtoQueue.onReceiveData(appId, sampleProto.toByteArray());
    }
}
