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
                {10, sampleProtoQueue.incrementAndGetSeqContext().byteValue(), 100});
        int receiveUri = 11;

        sampleProtoQueue.enqueue(sampleProto, receiveUri, new ProtoReceiver<SampleProto>() {
            @Override
            public void onProto(SampleProto proto) {
                Log.i(TAG, "onProto: " + proto);
            }
        });
    }

    public void mockOnReceive() {
        SampleProto sampleProto = new SampleProto(new byte[]
                {11, sampleProtoQueue.getSeqContext().byteValue(), 100});
        sampleProtoQueue.onReceiveData(appId, sampleProto.toByteArray());
    }
}
