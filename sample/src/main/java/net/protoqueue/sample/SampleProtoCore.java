package net.protoqueue.sample;

import android.util.Log;

import net.protoqueue.ProtoReceiver;
import net.protoqueue.ProtoSender;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhongyongsheng on 2018/4/20.
 */
public class SampleProtoCore {
    private static final String TAG = "SampleProtoCore";
    private static AtomicInteger seq = new AtomicInteger();
    private long topSid = 100000;
    private long subSid = 100000;
    int appId = 10086;

    private SampleProtoQueue sampleProtoQueue = SampleProtoQueue.getInstance();

    public void sendGameListReq() {
        int context = seq.incrementAndGet();
        SampleProto sampleProto = new SampleProto(new byte[] {10, (byte) context, 100});
        int receiveUri = 11;

        sampleProtoQueue.enqueue(sampleProto, new ProtoReceiver<SampleProto>() {
            @Override
            public void onProto(SampleProto proto) {
                Log.i(TAG, "onProto: " + proto);
            }
        }, receiveUri);
    }

    public void mockOnReceive() {
        int context = seq.get();
        SampleProto sampleProto = new SampleProto(new byte[] {11, (byte) context, 100});
        sampleProtoQueue.onReceiveData(appId, sampleProto.toByteArray());
    }
}
