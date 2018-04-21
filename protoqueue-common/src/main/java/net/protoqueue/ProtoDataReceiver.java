package net.protoqueue;

/**
 * Created by zhongyongsheng on 2018/4/20.
 */
public abstract class ProtoDataReceiver {

    abstract void onData(byte[] data);
}
