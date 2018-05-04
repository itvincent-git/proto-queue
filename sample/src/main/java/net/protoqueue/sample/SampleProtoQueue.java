package net.protoqueue.sample;

import net.protoqueue.ProtoQueueBuilder;
import net.protoqueue.annotation.ProtoQueueClass;

/**
 * Created by zhongyongsheng on 2018/4/20.
 */
@ProtoQueueClass(protoContextLiteral = "seqId")
public abstract class SampleProtoQueue extends BaseProtoQueue<SampleProto, Integer> {
    private static final String TAG = "SampleProtoQueue";
    private static volatile SampleProtoQueue sInstance;

    public static SampleProtoQueue getInstance() {
        if (sInstance != null) {
            return sInstance;
        } else {
            synchronized (SampleProtoQueue.class) {
                if (sInstance == null)
                    sInstance = ProtoQueueBuilder.newBuilder(SampleProtoQueue.class, mSender).build();
                return sInstance;
            }
        }
    }

    @Override
    protected int getOwnAppId() {
        return 10086;
    }
}
