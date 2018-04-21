package net.protoqueue;

/**
 * Created by zhongyongsheng on 2018/4/20.
 */
public interface ProtoReceiver<T> {

    void onProto(T proto);
}
