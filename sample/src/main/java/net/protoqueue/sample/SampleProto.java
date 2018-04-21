package net.protoqueue.sample;

/**
 * Created by zhongyongsheng on 2018/4/20.
 */
public class SampleProto {
    private int size;
    private byte[] data;
    private int uri;

    public SampleProto(byte[] data) {
        this.data = data;
        this.uri = data.length;
    }

    public SampleProto parseFrom(byte[] data) {
        return new SampleProto(data);
    }

    public byte[] toByteArray() {
        return data;
    }
}
