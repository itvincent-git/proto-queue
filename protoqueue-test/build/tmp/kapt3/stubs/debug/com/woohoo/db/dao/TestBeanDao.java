package com.woohoo.db.dao;

import java.lang.System;

/**
 * Create by zhijianz on 2019-09-03
 */
@android.arch.persistence.room.Dao()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\'J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\'J\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\'J\u001c\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r2\u0006\u0010\u0012\u001a\u00020\u0010H\'J,\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r2\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\'J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r2\u0006\u0010\u0012\u001a\u00020\u0010H\'J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u0012\u001a\u00020\u0010H\'J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0010H\'J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0019\u001a\u00020\u0006H\'J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J \u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eH\'\u00a8\u0006\u001f"}, d2 = {"Lcom/woohoo/db/dao/TestBeanDao;", "", "clear", "", "deleteMsg", "msgId", "", "insertTestBean", "", "beans", "", "Lcom/woohoo/app/common/provider/db/bean/TestBean;", "queryAllCount", "Lio/reactivex/Single;", "queryByUid", "targetUid", "", "queryByUidWithOrder", "uid", "start", "end", "queryUnreadByUid", "queryUnreadCount", "readAllMessage", "readByContent", "content", "readMessage", "readMessageByTime", "time", "isSendByMe", "", "db_debug"})
public abstract interface TestBeanDao {
    
    @android.arch.persistence.room.Insert(onConflict = android.arch.persistence.room.OnConflictStrategy.REPLACE)
    public abstract void insertTestBean(@org.jetbrains.annotations.NotNull()
    java.util.List<com.woohoo.app.common.provider.db.bean.TestBean> beans);
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM TestBean WHERE uid = :targetUid")
    public abstract io.reactivex.Single<java.util.List<com.woohoo.app.common.provider.db.bean.TestBean>> queryByUid(long targetUid);
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM TestBean WHERE uid = :uid ORDER BY createTime")
    public abstract io.reactivex.Single<java.util.List<com.woohoo.app.common.provider.db.bean.TestBean>> queryByUidWithOrder(long uid);
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM TestBean WHERE uid = :uid AND hasRead = 0")
    public abstract io.reactivex.Single<java.util.List<com.woohoo.app.common.provider.db.bean.TestBean>> queryUnreadByUid(long uid);
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM TestBean WHERE uid = :uid ORDER BY createTime DESC LIMIT :start, :end")
    public abstract io.reactivex.Single<java.util.List<com.woohoo.app.common.provider.db.bean.TestBean>> queryByUidWithOrder(long uid, int start, int end);
    
    @android.arch.persistence.room.Query(value = "DELETE FROM TestBean")
    public abstract int clear();
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT COUNT(*) FROM TestBean WHERE uid = :uid AND hasRead = 0")
    public abstract io.reactivex.Single<java.lang.Integer> queryUnreadCount(long uid);
    
    @android.arch.persistence.room.Query(value = "UPDATE TestBean SET hasRead = 1 WHERE uid = :uid AND hasRead = 0")
    public abstract int readAllMessage(long uid);
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT COUNT(*) FROM TestBean")
    public abstract io.reactivex.Single<java.lang.Integer> queryAllCount();
    
    @android.arch.persistence.room.Query(value = "UPDATE TestBean SET hasRead = 1 WHERE msgId = :msgId")
    public abstract int readMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String msgId);
    
    @android.arch.persistence.room.Query(value = "DELETE FROM TestBean WHERE msgId = :msgId")
    public abstract int deleteMsg(@org.jetbrains.annotations.NotNull()
    java.lang.String msgId);
    
    @android.arch.persistence.room.Query(value = "UPDATE TestBean SET hasRead = 1 WHERE uid = :uid AND createTime = :time AND isSendByMe = :isSendByMe")
    public abstract int readMessageByTime(long uid, long time, boolean isSendByMe);
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM TestBean WHERE msgText LIKE :content")
    public abstract java.util.List<com.woohoo.app.common.provider.db.bean.TestBean> readByContent(@org.jetbrains.annotations.NotNull()
    java.lang.String content);
}