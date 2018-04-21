package net.protoqueue.sample;

import java.util.Arrays;

/**
 * Created by zhongyongsheng on 2018/4/20.
 */
public class SampleProto {
    public byte[] data;
    public int uri;
    public int seqId;

    public SampleProto(byte[] data) {
        this.data = data;
        this.uri = data[0];
        this.seqId = data[1];
    }

    public static SampleProto parseFrom(byte[] data) {
        return new SampleProto(data);
    }

    public byte[] toByteArray() {
        return data;
    }

    @Override
    public String toString() {
        return "SampleProto{" +
                "data=" + Arrays.toString(data) +
                ", uri=" + uri +
                ", seqId=" + seqId +
                '}';
    }
}
