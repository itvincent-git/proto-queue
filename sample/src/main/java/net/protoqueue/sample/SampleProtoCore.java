package net.protoqueue.sample;

import android.util.Log;

import net.protoqueue.ProtoReceiver;
import net.protoqueue.ProtoSender;

/**
 * Created by zhongyongsheng on 2018/4/20.
 */
public class SampleProtoCore {
    private static final String TAG = "SampleProtoCore";
    private static int seq = 0;

    private SampleProtoQueue sampleProtoQueue = SampleProtoQueue.getInstance();

    public void sendGameListReq() {
        SampleProto sampleProto = new SampleProto(new byte[] {1, 2, 3});
        String context = seq++ + "";
        int receiveUri = 3;
        int appId = 10000;
        sampleProtoQueue.enqueue(sampleProto.toByteArray(), sampleProtoQueue.bindSampleProtoReceiver(new ProtoReceiver<SampleProto>() {
            @Override
            public void onProto(SampleProto proto) {

            }
        }), appId, context, receiveUri, 100000, 100000);
    }

    public void mockOnReceive() {
        SampleProto sampleProto = new SampleProto(new byte[] {11, 12, 13});
        String context = seq + "";
        int receiveUri = 3;
        int appId = 10000;
        sampleProtoQueue.onReceiveData(appId, sampleProto.toByteArray());
    }
}
