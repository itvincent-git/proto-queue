package com.woohoo.db.dao;

import java.lang.System;

/**
 * @author SilenceDut
 * @date 2019-09-04
 */
@android.arch.persistence.room.Dao()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\'J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006H\'J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\tH\'J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\'J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\'\u00a8\u0006\u0013"}, d2 = {"Lcom/woohoo/db/dao/SessionDao;", "", "clear", "", "deleteSession", "deleteSessionId", "", "getAllSessions", "", "Lcom/woohoo/app/common/provider/db/bean/SessionDBData;", "getSession", "updateSessionId", "saveOrReplaceSession", "bean", "saveResetSendLimitCountTime", "time", "saveSendLimitCount", "count", "", "db_debug"})
public abstract interface SessionDao {
    
    @org.jetbrains.annotations.Nullable()
    @android.arch.persistence.room.Query(value = "Select * from im_session order by sendTime desc")
    public abstract java.util.List<com.woohoo.app.common.provider.db.bean.SessionDBData> getAllSessions();
    
    @android.arch.persistence.room.Insert(onConflict = android.arch.persistence.room.OnConflictStrategy.REPLACE)
    public abstract void saveOrReplaceSession(@org.jetbrains.annotations.NotNull()
    com.woohoo.app.common.provider.db.bean.SessionDBData bean);
    
    @android.arch.persistence.room.Query(value = "DELETE FROM im_session WHERE  sessionId = :deleteSessionId")
    public abstract void deleteSession(long deleteSessionId);
    
    @android.arch.persistence.room.Query(value = "DELETE FROM im_session")
    public abstract void clear();
    
    @android.arch.persistence.room.Query(value = "UPDATE im_session SET extLong0 = :count WHERE sessionId = :updateSessionId")
    public abstract void saveSendLimitCount(long updateSessionId, int count);
    
    @android.arch.persistence.room.Query(value = "UPDATE im_session SET extLong1 = :time WHERE sessionId = :updateSessionId")
    public abstract void saveResetSendLimitCountTime(long updateSessionId, long time);
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "Select * from im_session WHERE sessionId = :updateSessionId")
    public abstract com.woohoo.app.common.provider.db.bean.SessionDBData getSession(long updateSessionId);
}