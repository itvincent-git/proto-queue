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
    protected Handler mHandler = new ProtoHandler();

    public void init(ProtoSender protoSender) {
        mProtoSender = protoSender;
    }

    /**
     * 发送协议，回调接收协议
     * @param proto 发送协议
     * @param receiveUri 接收协议的uri
     * @param receiver 接收协议回调
     * @return
     */
    protected ProtoDisposable enqueue(@NonNull P proto,
                                   @NonNull int receiveUri,
                                   @NonNull ProtoReceiver<P> receiver) {
        return enqueue(proto, getProtoContext(proto), receiveUri, getTopSid(), getSubSid(), receiver, null);
    }

    /**
     * 发送协议，回调接收协议，自定义topSid, subSid
     * @param proto 发送协议
     * @param receiveUri 接收协议的uri
     * @param topSid 顶级频道号
     * @param subSid 子频道号
     * @param receiver 接收协议回调
     * @return
     */
    protected ProtoDisposable enqueue(@NonNull P proto,
                                   @NonNull int receiveUri,
                                   @NonNull long topSid,
                                   @NonNull long subSid,
                                   @NonNull ProtoReceiver<P> receiver) {
        return enqueue(proto, getProtoContext(proto), receiveUri, topSid, subSid, receiver, null);
    }

    protected ProtoDisposable enqueue(@NonNull P proto,
                                      @NonNull C context,
                                      @NonNull int receiveUri,
                                      @NonNull long topSid,
                                      @NonNull long subSid,
                                      @NonNull ProtoReceiver<P> receiver,
                                      @NonNull QueueParameter parameter) {
        Checker.checkProtoNotNull(proto);
        Checker.checkReceiverNotNull(receiver);

        byte[] data = null;
        try {
            onProtoPreProcess(proto);
            data = toByteArray(proto);
        } catch (Throwable t) {
            onProtoException(t);
        }

        ProtoContext<P, C> protoContext = new ProtoContext<>(data, receiver, getOwnAppId(), context,
                    receiveUri, topSid, subSid, parameter);

        if (data != null) {
            mContextMap.put(context, protoContext);
            if (mProtoSender != null)
                mProtoSender.onSend(getOwnAppId(), data, topSid, subSid);

            if (parameter != null && parameter.timeout > 0) {
                Message message = mHandler.obtainMessage();
                message.what = 1;
                message.obj = context;
                mHandler.sendMessageDelayed(message, parameter.timeout);
            }
        }

        return protoContext.protoDisposable;
    }

    /**
     * 返回带自定义参数的QueueParameter，调用
     * @param proto
     * @param receiveUri
     * @param receiver
     * @return
     */
    protected QueueParameter newQueueParameter(@NonNull P proto,
                                               @NonNull int receiveUri,
                                               @NonNull ProtoReceiver<P> receiver) {
        QueueParameter queueParameter = new QueueParameter();
        queueParameter.protoQueue = this;
        queueParameter.proto = proto;
        queueParameter.receiveUri = receiveUri;
        queueParameter.receiver = receiver;
        return queueParameter;
    }

    protected void onNotifyData(int appId, byte[] data) {
        try {
            if (getOwnAppId() != appId) return;
            P proto = buildProto(data);
            C protoContext = getProtoContext(proto);

            ProtoContext context = mContextMap.get(protoContext);
            if (context != null && getReceiveUri(proto) == context.receiveUri) {
                mContextMap.remove(protoContext);
                if (!context.protoDisposable.isDisposed())
                    context.receiver.onProto(proto);
            } else {
                onNotificationData(proto);
            }
        } catch (Throwable t) {
            onProtoException(t);
        }
    }

    private void handleTimeout(Message msg) {
        C context = (C) msg.obj;
        ProtoContext protoContext = mContextMap.get(context);
        if (protoContext == null) return;
        if (protoContext.protoDisposable.isDisposed()) return;
        if (protoContext.parameter != null && protoContext.parameter.error != null) {
            ProtoError error = new ProtoTimeoutError("Wait for response timeout");
            protoContext.parameter.error.onError(error);
        }
        mContextMap.remove(context);
    }

    class ProtoHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            try {
                switch (msg.what) {
                    case 1:
                        handleTimeout(msg);
                        break;
                }
            } catch (Throwable t) {
                onProtoException(t);
            }
        }
    }

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

    /**
     * 发送协议前的处理，可用于加header等处理
     * @param proto
     */
    protected abstract void onProtoPreProcess(@NonNull P proto);

}
