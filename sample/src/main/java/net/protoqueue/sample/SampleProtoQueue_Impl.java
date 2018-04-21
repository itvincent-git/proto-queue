package net.protoqueue.sample;

import net.protoqueue.ProtoReceiver;

/**
 * Created by zhongyongsheng on 2018/4/20.
 */
public class SampleProtoQueue_Impl extends SampleProtoQueue{
    @Override
    void bindSampleProtoReceiver(ProtoReceiver<SampleProto> receiver) {


        return null;
    }

    @Override
    protected int getOwnAppId() {
        return 10000;
    }
}
