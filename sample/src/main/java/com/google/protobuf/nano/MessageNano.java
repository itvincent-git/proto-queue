package com.google.protobuf.nano;

import net.protoqueue.sample.SampleProto;

/**
 * Created by zhongyongsheng on 2018/5/4.
 */
public class MessageNano {
    public static byte[] toByteArray(SampleProto proto) {
        return proto.toByteArray();
    }
}
