package net.protoqueue.sample;

import net.protoqueue.ProtoQueue;

/**
 * Created by zhongyongsheng on 2018/4/27.
 */
public abstract class BaseProtoQueue<P, C> extends ProtoQueue<P, C>{

    @Override
    protected long getTopSid() {
        return 0;
    }

    @Override
    protected long getSubSid() {
        return 0;
    }

}
