package net.protoqueue;

/**
 * Created by zhongyongsheng on 2018/4/21.
 */
public class ProtoException extends Exception{
    public ProtoException() {
    }

    public ProtoException(String s) {
        super(s);
    }

    public ProtoException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ProtoException(Throwable throwable) {
        super(throwable);
    }
}
