package net.protoqueue;

/**
 * Created by zhongyongsheng on 2018/4/21.
 */
public interface ProtoRetryPolicy {

    int getCurrentTimeout();

    int getCurrentRetryCount();

    void retry(ProtoException exception) throws ProtoException;

}
