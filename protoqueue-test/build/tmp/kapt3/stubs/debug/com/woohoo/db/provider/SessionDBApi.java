package com.woohoo.db.provider;

import java.lang.System;

/**
 * @author SilenceDut
 * @date 2019-09-04
 */
@com.silencedut.hub_annotation.HubInject(api = {com.woohoo.app.common.provider.db.api.ISessionDBApi.class})
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0019\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001a\u001a\u00020\u0018H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u000fH\u0016J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0018H\u0016J\u0018\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0016R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lcom/woohoo/db/provider/SessionDBApi;", "Lcom/woohoo/app/common/provider/db/api/ISessionDBApi;", "()V", "dao", "Lcom/woohoo/db/dao/SessionDao;", "getDao", "()Lcom/woohoo/db/dao/SessionDao;", "dbApi", "Lcom/woohoo/db/api/IBusinessApi;", "kotlin.jvm.PlatformType", "msgDao", "Lcom/woohoo/db/dao/IMMessageDao;", "getMsgDao", "()Lcom/woohoo/db/dao/IMMessageDao;", "addOrUpdateSession", "", "sessionDBData", "Lcom/woohoo/app/common/provider/db/bean/SessionDBData;", "allSession", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clear", "deleteSession", "sessionId", "", "getSession", "updateSessionId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCreate", "saveResetSendLimitCountTime", "time", "saveSendLimitCount", "count", "", "db_debug"})
public final class SessionDBApi implements com.woohoo.app.common.provider.db.api.ISessionDBApi {
    private final com.woohoo.db.api.IBusinessApi dbApi = null;
    
    private final com.woohoo.db.dao.SessionDao getDao() {
        return null;
    }
    
    private final com.woohoo.db.dao.IMMessageDao getMsgDao() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object allSession(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.woohoo.app.common.provider.db.bean.SessionDBData>> p0) {
        return null;
    }
    
    @java.lang.Override()
    public void deleteSession(long sessionId) {
    }
    
    @java.lang.Override()
    public void addOrUpdateSession(@org.jetbrains.annotations.Nullable()
    com.woohoo.app.common.provider.db.bean.SessionDBData sessionDBData) {
    }
    
    @java.lang.Override()
    public void clear() {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getSession(long updateSessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.woohoo.app.common.provider.db.bean.SessionDBData> p1) {
        return null;
    }
    
    @java.lang.Override()
    public void saveSendLimitCount(long updateSessionId, int count) {
    }
    
    @java.lang.Override()
    public void saveResetSendLimitCountTime(long updateSessionId, long time) {
    }
    
    public SessionDBApi() {
        super();
    }
}