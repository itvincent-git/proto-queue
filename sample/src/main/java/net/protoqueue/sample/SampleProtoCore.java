package net.protoqueue.sample;

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
        sampleProtoQueue.sendSampleProto();
    }

    public void mockOnReceive() {
        SampleProto sampleProto = new SampleProto(new byte[]
                {11, sampleProtoQueue.getSeqContext().byteValue(), 100});
        sampleProtoQueue.onReceiveData(appId, sampleProto.toByteArray());
    }
}
