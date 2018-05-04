package net.protoqueue;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * P代表ProtoBuffer类，C代表上下文的类型（例如seqId是Integer类型）
 * Created by zhongyongsheng on 2018/4/20.
 */
public abstract class ProtoQueue<P, C> {
    protected ProtoSender mProtoSender;
    protected Map<C, ProtoContext> mContextMap = new ConcurrentHashMap<>();

    public void init(ProtoSender protoSender) {
        mProtoSender = protoSender;
    }

    /**
     * 发送协议，回调接收协议
     * @param proto 发送协议
     * @param receiver 接收协议回调
     * @return
     */
    public ProtoSenderDisposable enqueue(P proto,
                                         int receiveUri,
                                         ProtoReceiver<P> receiver) {
        return enqueue(toByteArray(proto), getProtoContext(proto), receiveUri, getTopSid(), getSubSid(), receiver);
    }

    protected ProtoSenderDisposable enqueue(byte[] data,
                                         C context,
                                         int receiveUri,
                                         long topSid,
                                         long subSid,
                                         ProtoReceiver<P> receiver) {
        Checker.checkDataNotNull(data);
        Checker.checkReceiverNotNull(receiver);

        ProtoContext<P, C> protoContext = new ProtoContext<>(data, receiver, getOwnAppId(), context, receiveUri, topSid, subSid);
        mContextMap.put(context, protoContext);
        mProtoSender.onSend(getOwnAppId(), data, topSid, subSid);
        return null;
    }

    protected void onNotifyData(int appId, byte[] data) {
        try {
            if (getOwnAppId() != appId) return;
            P proto = buildProto(data);
            C protoContext = getProtoContext(proto);

            ProtoContext context = mContextMap.remove(protoContext);
            if (context != null && getReceiveUri(proto) == context.receiveUri) {
                context.mReceiver.onProto(proto);
            } else {
                onNotificationData(proto);
            }
        } catch (Throwable t) {
            onProtoException(t);
        }
    }

    protected Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {

            }
        }
    };

    /**
     * 自动生成不需要实现
     * @return
     */
    public abstract C incrementAndGetSeqContext();

    /**
     * 自动生成不需要实现
     * @return
     */
    public abstract C getSeqContext();

    /**
     * 自动生成不需要实现
     * @param data
     * @return
     * @throws Exception
     */
    protected abstract P buildProto(byte[] data) throws Exception;

    /**
     * 自动生成不需要实现
     * @param proto
     * @return
     */
    protected abstract byte[] toByteArray(P proto);

    /**
     * 自动生成不需要实现
     * @param proto
     * @return
     */
    protected abstract C getProtoContext(P proto);

    /**
     * 自动生成不需要实现
     * @param proto
     * @return
     */
    protected abstract int getReceiveUri(P proto);

    //=============== 以下需要子类实现 ===========
    /**
     * 本协议的appid
     * @return
     */
    protected abstract int getOwnAppId();

    /**
     * 顶级频道号
     * @return
     */
    protected abstract long getTopSid();

    /**
     * 子频道号
     * @return
     */
    protected abstract long getSubSid();

    /**
     * 解协议时出现异常
     * @param throwable
     */
    protected abstract void onProtoException(Throwable throwable);

    /**
     * 不是发-》收的协议，纯广播的协议
     */
    protected abstract void onNotificationData(@NonNull P proto);

}
