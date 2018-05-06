package net.protoqueue;

/**
 * Created by zhongyongsheng on 2018/5/6.
 */
public class ProtoError extends Exception{

    public ProtoError() {
    }

    public ProtoError(String message) {
        super(message);
    }

    public ProtoError(String message, Throwable cause) {
        super(message, cause);
    }
}
