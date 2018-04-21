package net.protoqueue;

/**
 * Created by zhongyongsheng on 2018/4/20.
 */
public interface ProtoSender {

    void onSend(int appId, byte[] data, long topSid, long subSid);
}
