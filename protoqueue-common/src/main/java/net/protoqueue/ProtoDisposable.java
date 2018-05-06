package net.protoqueue;

/**
 * 可取消协议回包
 * Created by zhongyongsheng on 2018/4/20.
 */
public interface ProtoDisposable {

    /**
     * 取消接收回包
     */
    void dispose();

    /**
     * 是否已取消接收
     * @return
     */
    boolean isDisposed();
}
