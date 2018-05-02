package net.protoqueue.sample;

import android.util.Log;

import net.protoqueue.ProtoQueueBuilder;
import net.protoqueue.ProtoSender;
import net.protoqueue.annotation.ProtoQueueClass;

import java.util.Arrays;

/**
 * Created by zhongyongsheng on 2018/4/20.
 */
@ProtoQueueClass(appId = 10086, protoContextLiteral = "seqId", protoContextType = Integer.class)
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


}
