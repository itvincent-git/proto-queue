package net.protoqueue;

/**
 * Created by zhongyongsheng on 2018/5/6.
 */
public class ProtoTimeoutError extends ProtoError{
    public ProtoTimeoutError() {
    }

    public ProtoTimeoutError(String message) {
        super(message);
    }

    public ProtoTimeoutError(String message, Throwable cause) {
        super(message, cause);
    }
}
