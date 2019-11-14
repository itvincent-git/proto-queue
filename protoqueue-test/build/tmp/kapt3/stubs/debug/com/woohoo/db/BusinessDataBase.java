package com.woohoo.db;

import java.lang.System;

/**
 * Create by zhijianz on 2019-09-02
 */
@android.arch.persistence.room.Database(entities = {com.woohoo.app.common.provider.db.bean.TestBean.class, com.woohoo.app.common.provider.db.bean.SessionDBData.class, com.woohoo.app.common.provider.db.bean.IMMessageBean.class}, version = 2, exportSchema = false)
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/woohoo/db/BusinessDataBase;", "Landroid/arch/persistence/room/RoomDatabase;", "()V", "getIMMessageDao", "Lcom/woohoo/db/dao/IMMessageDao;", "getSessionDao", "Lcom/woohoo/db/dao/SessionDao;", "getTestBeanDao", "Lcom/woohoo/db/dao/TestBeanDao;", "Companion", "db_debug"})
public abstract class BusinessDataBase extends android.arch.persistence.room.RoomDatabase {
    private static final net.slog.SLogger log = null;
    private static final android.arch.persistence.room.migration.Migration MIGRATION_1_2 = null;
    public static final com.woohoo.db.BusinessDataBase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.woohoo.db.dao.TestBeanDao getTestBeanDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.woohoo.db.dao.SessionDao getSessionDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.woohoo.db.dao.IMMessageDao getIMMessageDao();
    
    public BusinessDataBase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/woohoo/db/BusinessDataBase$Companion;", "", "()V", "MIGRATION_1_2", "Landroid/arch/persistence/room/migration/Migration;", "log", "Lnet/slog/SLogger;", "getDataBase", "Lcom/woohoo/db/BusinessDataBase;", "uid", "", "db_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.Nullable()
        public final com.woohoo.db.BusinessDataBase getDataBase(long uid) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}