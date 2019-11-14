package com.woohoo.db.api;

import java.lang.System;

/**
 * Create by zhijianz on 2019-09-02
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/woohoo/db/api/IBusinessApi;", "Lcom/woohoo/app/framework/moduletransfer/ICoreApi;", "getDB", "Lcom/woohoo/db/BusinessDataBase;", "getScheduler", "Lio/reactivex/Scheduler;", "db_debug"})
public abstract interface IBusinessApi extends com.woohoo.app.framework.moduletransfer.ICoreApi {
    
    @org.jetbrains.annotations.Nullable()
    public abstract com.woohoo.db.BusinessDataBase getDB();
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Scheduler getScheduler();
}