package com.woohoo.db.provider;

import java.lang.System;

/**
 * Create by zhijianz on 2019-09-05
 * IM消息dao操作的实现
 */
@com.silencedut.hub_annotation.HubInject(api = {com.woohoo.app.common.provider.db.api.IIMMessageDaoApi.class})
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001f\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ)\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\nH\u0016J\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\'\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ/\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ\'\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#J!\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\"H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\'J)\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u001dH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010+J \u0010,\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0014\u0018\u00010-*\u00020\"H\u0002R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006."}, d2 = {"Lcom/woohoo/db/provider/IMMessageDaoImpl;", "Lcom/woohoo/app/common/provider/db/api/IIMMessageDaoApi;", "()V", "dao", "Lcom/woohoo/db/dao/IMMessageDao;", "getDao", "()Lcom/woohoo/db/dao/IMMessageDao;", "log", "Lnet/slog/SLogger;", "addMsg", "", "msgList", "", "Lcom/woohoo/app/common/provider/db/bean/IMMessageBean;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMsg", "uid", "", "sendTime", "isSendByMe", "", "(JJZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCreate", "queryAllByUid", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryAllMsgBySendBy", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryMsgByPage", "start", "", "end", "(JIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryReceivedChatInviteMessage", "invitationId", "", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMsgContent", "msgId", "content", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSendMsgState", "receiver", "state", "(JJILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "breakMsgId", "Lcom/woohoo/app/framework/kt/DataObject3;", "db_debug"})
public final class IMMessageDaoImpl implements com.woohoo.app.common.provider.db.api.IIMMessageDaoApi {
    private final net.slog.SLogger log = null;
    
    private final com.woohoo.db.dao.IMMessageDao getDao() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object addMsg(@org.jetbrains.annotations.NotNull()
    java.util.List<com.woohoo.app.common.provider.db.bean.IMMessageBean> msgList, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object updateSendMsgState(long receiver, long sendTime, int state, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p3) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object updateMsgContent(@org.jetbrains.annotations.NotNull()
    java.lang.String msgId, @org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p2) {
        return null;
    }
    
    private final com.woohoo.app.framework.kt.DataObject3<java.lang.Long, java.lang.Long, java.lang.Boolean> breakMsgId(@org.jetbrains.annotations.NotNull()
    java.lang.String $this$breakMsgId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object queryAllByUid(long uid, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.woohoo.app.common.provider.db.bean.IMMessageBean>> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object deleteMsg(long uid, long sendTime, boolean isSendByMe, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p3) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object queryMsgByPage(long uid, int start, int end, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.woohoo.app.common.provider.db.bean.IMMessageBean>> p3) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object queryAllMsgBySendBy(long uid, boolean isSendByMe, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.woohoo.app.common.provider.db.bean.IMMessageBean>> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object queryReceivedChatInviteMessage(long uid, @org.jetbrains.annotations.NotNull()
    java.lang.String invitationId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.woohoo.app.common.provider.db.bean.IMMessageBean>> p2) {
        return null;
    }
    
    public IMMessageDaoImpl() {
        super();
    }
}