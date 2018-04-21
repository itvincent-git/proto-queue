package net.protoqueue;

/**
 * Created by zhongyongsheng on 2018/4/21.
 */
public interface ProtoRetryPolicy {
    public int getCurrentTimeout();

    public int getCurrentRetryCount();

    public void retry(ProtoException exception) throws ProtoException;

}
