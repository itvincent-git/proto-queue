package net.protoqueue.sample;

import android.util.Log;

import net.protoqueue.ProtoQueue;
import net.protoqueue.ProtoQueueBuilder;
import net.protoqueue.ProtoReceiver;
import net.protoqueue.ProtoSender;
import net.protoqueue.annotation.ProtoQueueClass;

import java.util.Arrays;

/**
 * Created by zhongyongsheng on 2018/4/20.
 */
@ProtoQueueClass(appId = 10086)
public abstract class SampleProtoQueue extends ProtoQueue<SampleProto> {
    private static final String TAG = "SampleProtoQueue";
    private static volatile SampleProtoQueue sInstance;

    private static ProtoSender mSender = new ProtoSender() {
        @Override
        public void onSend(int appId, byte[] data, long topSid, long subSid) {
            Log.i(TAG, String.format("onSend: %d, %s, %d, %d", appId, Arrays.toString(data), topSid, subSid));
        }
    };

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

    public void onReceiveData(int appId, byte[] data) {
        super.onNotifyData(appId, data);
    }

    @Override
    protected long getTopSid() {
        return 0;
    }

    @Override
    protected long getSubSid() {
        return 0;
    }

    @Override
    protected int getSendContext(SampleProto proto) {
        return proto.seqId;
    }
}