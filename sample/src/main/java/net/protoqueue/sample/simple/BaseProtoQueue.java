package net.protoqueue.sample.simple;

import net.protoqueue.ProtoQueue;
import net.protoqueue.ProtoSender;
import net.slog.SLog;

import java.util.Arrays;

/**
 * Created by zhongyongsheng on 2018/4/27.
 */
public abstract class BaseProtoQueue<P, C> extends ProtoQueue<P, C> {

    private static final String TAG = "BaseProtoQueue";

    protected static ProtoSender mSender = new ProtoSender() {
        @Override
        public void onSend(int appId, byte[] data, long topSid, long subSid) {
            SLog.info(TAG, String.format("onSend: %d, %s, %d, %d", appId, Arrays.toString(data),
                    topSid, subSid));
        }
    };

    @Override
    protected long getTopSid() {
        return 0;
    }

    @Override
    protected long getSubSid() {
        return 0;
    }

    public void onReceiveData(int appId, byte[] data) {
        super.onNotifyData(appId, data);
    }

    @Override
    protected void onProtoException(Throwable throwable) {

    }

    @Override
    protected void onProtoPreProcess(P proto) {

    }
}
