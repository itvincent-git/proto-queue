package net.protoqueue.sample.simple;

import net.protoqueue.sample.Header;

import java.util.Arrays;

/**
 * Created by zhongyongsheng on 2018/4/20.
 */
public class SampleProto {
    public byte[] data;
    public int uri;
    public Header header;

    public SampleProto(byte[] data) {
        this.data = data;
        this.uri = data[0];
        this.header = new Header(data[1]);
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
                ", seqId=" + this.header.getSeqid() +
                '}';
    }
}
