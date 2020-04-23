package com.google.protobuf.nano;

import net.protoqueue.sample.SampleProto;
import net.protoqueue.sample.dsl.DSLProto;

/**
 * 模拟Protobuf的MessageNano
 * Created by zhongyongsheng on 2018/5/4.
 */
public class MessageNano {
    public static byte[] toByteArray(SampleProto proto) {
        return proto.toByteArray();
    }

    public static byte[] toByteArray(DSLProto proto) {
        return proto.toByteArray();
    }
}
