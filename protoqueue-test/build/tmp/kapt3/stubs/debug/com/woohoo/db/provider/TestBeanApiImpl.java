package com.woohoo.db.provider;

import java.lang.System;

/**
 * Create by zhijianz on 2019-09-03
 */
@com.silencedut.hub_annotation.HubInject(api = {com.woohoo.app.common.provider.db.api.ITestBeanApi.class})
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0017J\b\u0010\u001f\u001a\u00020\u001eH\u0017J\b\u0010 \u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\u001eH\u0017J\b\u0010\"\u001a\u00020\u001cH\u0002J\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020\u001cH\u0002J\b\u0010\'\u001a\u00020\u0005H\u0002J\b\u0010(\u001a\u00020\u001eH\u0017J\b\u0010)\u001a\u00020\u001eH\u0016J\b\u0010*\u001a\u00020\u001eH\u0017J\b\u0010+\u001a\u00020\u001eH\u0017J\b\u0010,\u001a\u00020\u001eH\u0017J\b\u0010-\u001a\u00020\u001eH\u0017J\b\u0010.\u001a\u00020\u001eH\u0017J\b\u0010/\u001a\u00020\u001eH\u0016J\b\u00100\u001a\u00020\u001eH\u0016J\b\u00101\u001a\u00020\u001eH\u0016J\b\u00102\u001a\u00020\u001eH\u0017R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/woohoo/db/provider/TestBeanApiImpl;", "Lcom/woohoo/app/common/provider/db/api/ITestBeanApi;", "()V", "counter", "", "", "", "createTime", "dao", "Lcom/woohoo/db/dao/TestBeanDao;", "getDao", "()Lcom/woohoo/db/dao/TestBeanDao;", "dbApi", "Lcom/woohoo/db/api/IBusinessApi;", "kotlin.jvm.PlatformType", "friendUids", "", "idBase", "isSendByMe", "", "log", "Lnet/slog/SLogger;", "scheduler", "Lio/reactivex/Scheduler;", "sendTimeBase", "strangerUids", "testUid", "uuid", "", "append", "", "clear", "deleteById", "getAllCount", "getMsgText", "getTestBean", "Lcom/woohoo/app/common/provider/db/bean/TestBean;", "uid", "content", "getUid", "insertTestData", "onCreate", "queryByPage", "queryByUid", "queryByUidWithOrder", "queryCount", "queryUnread", "readById", "readByLike", "readByTime", "readMsg", "db_debug"})
public final class TestBeanApiImpl implements com.woohoo.app.common.provider.db.api.ITestBeanApi {
    private final net.slog.SLogger log = null;
    private final com.woohoo.db.api.IBusinessApi dbApi = null;
    private final io.reactivex.Scheduler scheduler = null;
    private final java.util.Map<java.lang.Long, java.lang.Integer> counter = null;
    private final java.util.List<java.lang.Long> friendUids = null;
    private final java.util.List<java.lang.Long> strangerUids = null;
    private int sendTimeBase;
    private long idBase;
    private java.lang.String uuid;
    private final long testUid = 10000L;
    private long createTime;
    private boolean isSendByMe;
    
    private final com.woohoo.db.dao.TestBeanDao getDao() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @android.annotation.SuppressLint(value = {"CheckResult"})
    @java.lang.Override()
    public void insertTestData() {
    }
    
    /**
     * 获取消息的uid，尽量保证uid的是散列的
     */
    private final long getUid() {
        return 0L;
    }
    
    private final java.lang.String getMsgText() {
        return null;
    }
    
    private final com.woohoo.app.common.provider.db.bean.TestBean getTestBean(long uid, java.lang.String content) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"CheckResult"})
    @java.lang.Override()
    public void queryUnread() {
    }
    
    @android.annotation.SuppressLint(value = {"CheckResult"})
    @java.lang.Override()
    public void queryByUid() {
    }
    
    @android.annotation.SuppressLint(value = {"CheckResult"})
    @java.lang.Override()
    public void queryByUidWithOrder() {
    }
    
    @android.annotation.SuppressLint(value = {"CheckResult"})
    @java.lang.Override()
    public void queryByPage() {
    }
    
    @android.annotation.SuppressLint(value = {"CheckResult"})
    @java.lang.Override()
    public void clear() {
    }
    
    @android.annotation.SuppressLint(value = {"CheckResult"})
    @java.lang.Override()
    public void queryCount() {
    }
    
    @android.annotation.SuppressLint(value = {"CheckResult"})
    @java.lang.Override()
    public void append() {
    }
    
    @android.annotation.SuppressLint(value = {"CheckResult"})
    @java.lang.Override()
    public void readMsg() {
    }
    
    @android.annotation.SuppressLint(value = {"CheckResult"})
    @java.lang.Override()
    public void getAllCount() {
    }
    
    @java.lang.Override()
    public void readById() {
    }
    
    @java.lang.Override()
    public void deleteById() {
    }
    
    @java.lang.Override()
    public void readByTime() {
    }
    
    @java.lang.Override()
    public void readByLike() {
    }
    
    public TestBeanApiImpl() {
        super();
    }
}