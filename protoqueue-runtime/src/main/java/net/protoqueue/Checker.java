package net.protoqueue;

/**
 * Created by zhongyongsheng on 2018/4/21.
 */
public class Checker {
    static void checkDataNotNull(byte[] bytes) throws RuntimeException {
        if (bytes == null) throw new RuntimeException("data cannot be null");
    }

    static void checkReceiverNotNull(ProtoReceiver receiver) throws RuntimeException {
        if (receiver == null) throw new RuntimeException("ProtoReceiver cannot be null");
    }
}
