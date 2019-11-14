package com.woohoo.db.dao;

import java.lang.System;

/**
 * Create by zhijianz on 2019-09-05
 * im 消息的dao
 */
@android.arch.persistence.room.Dao()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\'J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\'J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0004\u001a\u00020\u0005H\'J \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\'J&\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\'J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\'J(\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0016H\'J(\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0003H\'\u00a8\u0006\u001b"}, d2 = {"Lcom/woohoo/db/dao/IMMessageDao;", "", "deleteMsg", "", "uid", "", "sendTime", "isSendByMe", "", "deleteMsgByUid", "insertMsg", "", "msg", "", "Lcom/woohoo/app/common/provider/db/bean/IMMessageBean;", "queryAllByUid", "queryAllMsgBySendBy", "queryMsgByPage", "start", "end", "queryReceiveChatInviteMsg", "invitationId", "", "updateMsgContent", "content", "updateMsgState", "state", "db_debug"})
public abstract interface IMMessageDao {
    
    /**
     * 插入消息
     */
    @android.arch.persistence.room.Insert(onConflict = android.arch.persistence.room.OnConflictStrategy.REPLACE)
    public abstract void insertMsg(@org.jetbrains.annotations.NotNull()
    java.util.List<com.woohoo.app.common.provider.db.bean.IMMessageBean> msg);
    
    /**
     * 更新消息状态值
     */
    @android.arch.persistence.room.Query(value = "UPDATE IMMessageBean SET status = :state WHERE uid = :uid AND sendTime = :sendTime AND isSendByMe = :isSendByMe")
    public abstract int updateMsgState(long uid, long sendTime, boolean isSendByMe, int state);
    
    /**
     * 删除某条消息
     */
    @android.arch.persistence.room.Query(value = "DELETE FROM IMMessageBean WHERE uid = :uid AND sendTime = :sendTime AND isSendByMe = :isSendByMe")
    public abstract int deleteMsg(long uid, long sendTime, boolean isSendByMe);
    
    /**
     * 删除某条消息
     */
    @android.arch.persistence.room.Query(value = "DELETE FROM IMMessageBean WHERE uid = :uid")
    public abstract int deleteMsgByUid(long uid);
    
    /**
     * 查询和某个uid的所有聊天记录
     */
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM IMMessageBean WHERE uid = :uid ORDER BY sendTime")
    public abstract java.util.List<com.woohoo.app.common.provider.db.bean.IMMessageBean> queryAllByUid(long uid);
    
    /**
     * 分页查询消息查询消息
     */
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM IMMessageBean WHERE uid = :uid ORDER BY sendTime LIMIT :start, :end")
    public abstract java.util.List<com.woohoo.app.common.provider.db.bean.IMMessageBean> queryMsgByPage(long uid, int start, int end);
    
    /**
     * 通过uid，查询收到或者是发出的消息
     */
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM IMMessageBean WHERE uid = :uid AND isSendByMe = :isSendByMe ORDER BY sendTime")
    public abstract java.util.List<com.woohoo.app.common.provider.db.bean.IMMessageBean> queryAllMsgBySendBy(long uid, boolean isSendByMe);
    
    /**
     * 更新消息内容
     */
    @android.arch.persistence.room.Query(value = "UPDATE IMMessageBean SET content = :content WHERE uid = :uid AND sendTime = :sendTime AND isSendByMe = :isSendByMe")
    public abstract int updateMsgContent(long uid, long sendTime, boolean isSendByMe, @org.jetbrains.annotations.NotNull()
    java.lang.String content);
    
    /**
     * 通过邀请id查找收到的视频邀请的消息
     */
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM IMMessageBean WHERE uid = :uid AND isSendByMe = 0 AND msgType = 3 AND funcType = 101 AND content LIKE :invitationId")
    public abstract java.util.List<com.woohoo.app.common.provider.db.bean.IMMessageBean> queryReceiveChatInviteMsg(long uid, @org.jetbrains.annotations.NotNull()
    java.lang.String invitationId);
    
    /**
     * Create by zhijianz on 2019-09-05
     * im 消息的dao
     */
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
    }
}