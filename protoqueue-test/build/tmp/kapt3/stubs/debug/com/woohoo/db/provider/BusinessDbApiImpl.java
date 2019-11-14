package com.woohoo.db.provider;

import java.lang.System;

/**
 * Create by zhijianz on 2019-09-02
 */
@com.silencedut.hub_annotation.HubInject(api = {com.woohoo.app.common.provider.db.api.IBusinessDbInitApi.class, com.woohoo.db.api.IBusinessApi.class})
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0014H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/woohoo/db/provider/BusinessDbApiImpl;", "Lcom/woohoo/app/common/provider/db/api/IBusinessDbInitApi;", "Lcom/woohoo/db/api/IBusinessApi;", "Lcom/woohoo/app/common/provider/login/ILoginNotification$IUserLogoutNotify;", "()V", "database", "Lcom/woohoo/db/BusinessDataBase;", "dbScheduler", "Lio/reactivex/Scheduler;", "kotlin.jvm.PlatformType", "log", "Lnet/slog/SLogger;", "uid", "Ljava/util/concurrent/atomic/AtomicLong;", "getDB", "getScheduler", "hasDbInit", "", "init", "", "", "onCreate", "onUserLogoutNotify", "db_debug"})
public final class BusinessDbApiImpl implements com.woohoo.app.common.provider.db.api.IBusinessDbInitApi, com.woohoo.db.api.IBusinessApi, com.woohoo.app.common.provider.login.ILoginNotification.IUserLogoutNotify {
    private final net.slog.SLogger log = null;
    private java.util.concurrent.atomic.AtomicLong uid;
    private volatile com.woohoo.db.BusinessDataBase database;
    private final io.reactivex.Scheduler dbScheduler = null;
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @java.lang.Override()
    public void init(long uid) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public com.woohoo.db.BusinessDataBase getDB() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Scheduler getScheduler() {
        return null;
    }
    
    @java.lang.Override()
    public void onUserLogoutNotify(long uid) {
    }
    
    @java.lang.Override()
    public boolean hasDbInit() {
        return false;
    }
    
    public BusinessDbApiImpl() {
        super();
    }
}