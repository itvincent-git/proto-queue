package net.protoqueue.sample;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhongyongsheng on 2018/4/20.
 */
public class SampleProtoQueue_Impl extends SampleProtoQueue{

    protected AtomicInteger mSeq = new AtomicInteger();

    @Override
    protected SampleProto buildProto(byte[] data) {
        return SampleProto.parseFrom(data);
    }

    @Override
    protected byte[] toByteArray(SampleProto proto) {
        return proto.toByteArray();
    }

    @Override
    protected Integer getProtoContext(SampleProto proto) {
        return proto.seqId;
    }

    @Override
    protected int getOwnAppId() {
        return 10086;
    }

    @Override
    public Integer incrementAndGetSeqContext() {
        return mSeq.incrementAndGet();
    }

    @Override
    public Integer getSeqContext() {
        return mSeq.get();
    }
}
