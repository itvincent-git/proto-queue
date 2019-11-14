package com.woohoo.db.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import com.woohoo.app.common.provider.db.bean.IMMessageBean;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class IMMessageDao_Impl implements IMMessageDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfIMMessageBean;

  private final SharedSQLiteStatement __preparedStmtOfUpdateMsgState;

  private final SharedSQLiteStatement __preparedStmtOfDeleteMsg;

  private final SharedSQLiteStatement __preparedStmtOfDeleteMsgByUid;

  private final SharedSQLiteStatement __preparedStmtOfUpdateMsgContent;

  public IMMessageDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfIMMessageBean = new EntityInsertionAdapter<IMMessageBean>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `IMMessageBean`(`id`,`uid`,`isSendByMe`,`sendTime`,`msgType`,`status`,`content`,`funcType`,`extStr0`,`extStr1`,`extStr2`,`extLong0`,`extLong1`,`extLong2`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, IMMessageBean value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getUid());
        final int _tmp;
        _tmp = value.isSendByMe() ? 1 : 0;
        stmt.bindLong(3, _tmp);
        stmt.bindLong(4, value.getSendTime());
        stmt.bindLong(5, value.getMsgType());
        stmt.bindLong(6, value.getStatus());
        if (value.getContent() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getContent());
        }
        stmt.bindLong(8, value.getFuncType());
        if (value.getExtStr0() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getExtStr0());
        }
        if (value.getExtStr1() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getExtStr1());
        }
        if (value.getExtStr2() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getExtStr2());
        }
        stmt.bindLong(12, value.getExtLong0());
        stmt.bindLong(13, value.getExtLong1());
        stmt.bindLong(14, value.getExtLong2());
      }
    };
    this.__preparedStmtOfUpdateMsgState = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE IMMessageBean SET status = ? WHERE uid = ? AND sendTime = ? AND isSendByMe = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteMsg = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM IMMessageBean WHERE uid = ? AND sendTime = ? AND isSendByMe = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteMsgByUid = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM IMMessageBean WHERE uid = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateMsgContent = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE IMMessageBean SET content = ? WHERE uid = ? AND sendTime = ? AND isSendByMe = ?";
        return _query;
      }
    };
  }

  @Override
  public void insertMsg(List<IMMessageBean> msg) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfIMMessageBean.insert(msg);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateMsgState(long uid, long sendTime, boolean isSendByMe, int state) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateMsgState.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      _stmt.bindLong(_argIndex, state);
      _argIndex = 2;
      _stmt.bindLong(_argIndex, uid);
      _argIndex = 3;
      _stmt.bindLong(_argIndex, sendTime);
      _argIndex = 4;
      final int _tmp;
      _tmp = isSendByMe ? 1 : 0;
      _stmt.bindLong(_argIndex, _tmp);
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateMsgState.release(_stmt);
    }
  }

  @Override
  public int deleteMsg(long uid, long sendTime, boolean isSendByMe) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteMsg.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      _stmt.bindLong(_argIndex, uid);
      _argIndex = 2;
      _stmt.bindLong(_argIndex, sendTime);
      _argIndex = 3;
      final int _tmp;
      _tmp = isSendByMe ? 1 : 0;
      _stmt.bindLong(_argIndex, _tmp);
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteMsg.release(_stmt);
    }
  }

  @Override
  public int deleteMsgByUid(long uid) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteMsgByUid.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      _stmt.bindLong(_argIndex, uid);
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteMsgByUid.release(_stmt);
    }
  }

  @Override
  public int updateMsgContent(long uid, long sendTime, boolean isSendByMe, String content) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateMsgContent.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (content == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, content);
      }
      _argIndex = 2;
      _stmt.bindLong(_argIndex, uid);
      _argIndex = 3;
      _stmt.bindLong(_argIndex, sendTime);
      _argIndex = 4;
      final int _tmp;
      _tmp = isSendByMe ? 1 : 0;
      _stmt.bindLong(_argIndex, _tmp);
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateMsgContent.release(_stmt);
    }
  }

  @Override
  public List<IMMessageBean> queryAllByUid(long uid) {
    final String _sql = "SELECT * FROM IMMessageBean WHERE uid = ? ORDER BY sendTime";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, uid);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfUid = _cursor.getColumnIndexOrThrow("uid");
      final int _cursorIndexOfIsSendByMe = _cursor.getColumnIndexOrThrow("isSendByMe");
      final int _cursorIndexOfSendTime = _cursor.getColumnIndexOrThrow("sendTime");
      final int _cursorIndexOfMsgType = _cursor.getColumnIndexOrThrow("msgType");
      final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("status");
      final int _cursorIndexOfContent = _cursor.getColumnIndexOrThrow("content");
      final int _cursorIndexOfFuncType = _cursor.getColumnIndexOrThrow("funcType");
      final int _cursorIndexOfExtStr0 = _cursor.getColumnIndexOrThrow("extStr0");
      final int _cursorIndexOfExtStr1 = _cursor.getColumnIndexOrThrow("extStr1");
      final int _cursorIndexOfExtStr2 = _cursor.getColumnIndexOrThrow("extStr2");
      final int _cursorIndexOfExtLong0 = _cursor.getColumnIndexOrThrow("extLong0");
      final int _cursorIndexOfExtLong1 = _cursor.getColumnIndexOrThrow("extLong1");
      final int _cursorIndexOfExtLong2 = _cursor.getColumnIndexOrThrow("extLong2");
      final List<IMMessageBean> _result = new ArrayList<IMMessageBean>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final IMMessageBean _item;
        final long _tmpUid;
        _tmpUid = _cursor.getLong(_cursorIndexOfUid);
        final boolean _tmpIsSendByMe;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsSendByMe);
        _tmpIsSendByMe = _tmp != 0;
        final long _tmpSendTime;
        _tmpSendTime = _cursor.getLong(_cursorIndexOfSendTime);
        final int _tmpMsgType;
        _tmpMsgType = _cursor.getInt(_cursorIndexOfMsgType);
        final int _tmpStatus;
        _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        final String _tmpContent;
        _tmpContent = _cursor.getString(_cursorIndexOfContent);
        final int _tmpFuncType;
        _tmpFuncType = _cursor.getInt(_cursorIndexOfFuncType);
        final String _tmpExtStr0;
        _tmpExtStr0 = _cursor.getString(_cursorIndexOfExtStr0);
        final String _tmpExtStr1;
        _tmpExtStr1 = _cursor.getString(_cursorIndexOfExtStr1);
        final String _tmpExtStr2;
        _tmpExtStr2 = _cursor.getString(_cursorIndexOfExtStr2);
        final long _tmpExtLong0;
        _tmpExtLong0 = _cursor.getLong(_cursorIndexOfExtLong0);
        final long _tmpExtLong1;
        _tmpExtLong1 = _cursor.getLong(_cursorIndexOfExtLong1);
        final long _tmpExtLong2;
        _tmpExtLong2 = _cursor.getLong(_cursorIndexOfExtLong2);
        _item = new IMMessageBean(_tmpUid,_tmpIsSendByMe,_tmpSendTime,_tmpMsgType,_tmpStatus,_tmpContent,_tmpFuncType,_tmpExtStr0,_tmpExtStr1,_tmpExtStr2,_tmpExtLong0,_tmpExtLong1,_tmpExtLong2);
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<IMMessageBean> queryMsgByPage(long uid, int start, int end) {
    final String _sql = "SELECT * FROM IMMessageBean WHERE uid = ? ORDER BY sendTime LIMIT ?, ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, uid);
    _argIndex = 2;
    _statement.bindLong(_argIndex, start);
    _argIndex = 3;
    _statement.bindLong(_argIndex, end);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfUid = _cursor.getColumnIndexOrThrow("uid");
      final int _cursorIndexOfIsSendByMe = _cursor.getColumnIndexOrThrow("isSendByMe");
      final int _cursorIndexOfSendTime = _cursor.getColumnIndexOrThrow("sendTime");
      final int _cursorIndexOfMsgType = _cursor.getColumnIndexOrThrow("msgType");
      final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("status");
      final int _cursorIndexOfContent = _cursor.getColumnIndexOrThrow("content");
      final int _cursorIndexOfFuncType = _cursor.getColumnIndexOrThrow("funcType");
      final int _cursorIndexOfExtStr0 = _cursor.getColumnIndexOrThrow("extStr0");
      final int _cursorIndexOfExtStr1 = _cursor.getColumnIndexOrThrow("extStr1");
      final int _cursorIndexOfExtStr2 = _cursor.getColumnIndexOrThrow("extStr2");
      final int _cursorIndexOfExtLong0 = _cursor.getColumnIndexOrThrow("extLong0");
      final int _cursorIndexOfExtLong1 = _cursor.getColumnIndexOrThrow("extLong1");
      final int _cursorIndexOfExtLong2 = _cursor.getColumnIndexOrThrow("extLong2");
      final List<IMMessageBean> _result = new ArrayList<IMMessageBean>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final IMMessageBean _item;
        final long _tmpUid;
        _tmpUid = _cursor.getLong(_cursorIndexOfUid);
        final boolean _tmpIsSendByMe;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsSendByMe);
        _tmpIsSendByMe = _tmp != 0;
        final long _tmpSendTime;
        _tmpSendTime = _cursor.getLong(_cursorIndexOfSendTime);
        final int _tmpMsgType;
        _tmpMsgType = _cursor.getInt(_cursorIndexOfMsgType);
        final int _tmpStatus;
        _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        final String _tmpContent;
        _tmpContent = _cursor.getString(_cursorIndexOfContent);
        final int _tmpFuncType;
        _tmpFuncType = _cursor.getInt(_cursorIndexOfFuncType);
        final String _tmpExtStr0;
        _tmpExtStr0 = _cursor.getString(_cursorIndexOfExtStr0);
        final String _tmpExtStr1;
        _tmpExtStr1 = _cursor.getString(_cursorIndexOfExtStr1);
        final String _tmpExtStr2;
        _tmpExtStr2 = _cursor.getString(_cursorIndexOfExtStr2);
        final long _tmpExtLong0;
        _tmpExtLong0 = _cursor.getLong(_cursorIndexOfExtLong0);
        final long _tmpExtLong1;
        _tmpExtLong1 = _cursor.getLong(_cursorIndexOfExtLong1);
        final long _tmpExtLong2;
        _tmpExtLong2 = _cursor.getLong(_cursorIndexOfExtLong2);
        _item = new IMMessageBean(_tmpUid,_tmpIsSendByMe,_tmpSendTime,_tmpMsgType,_tmpStatus,_tmpContent,_tmpFuncType,_tmpExtStr0,_tmpExtStr1,_tmpExtStr2,_tmpExtLong0,_tmpExtLong1,_tmpExtLong2);
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<IMMessageBean> queryAllMsgBySendBy(long uid, boolean isSendByMe) {
    final String _sql = "SELECT * FROM IMMessageBean WHERE uid = ? AND isSendByMe = ? ORDER BY sendTime";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, uid);
    _argIndex = 2;
    final int _tmp;
    _tmp = isSendByMe ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfUid = _cursor.getColumnIndexOrThrow("uid");
      final int _cursorIndexOfIsSendByMe = _cursor.getColumnIndexOrThrow("isSendByMe");
      final int _cursorIndexOfSendTime = _cursor.getColumnIndexOrThrow("sendTime");
      final int _cursorIndexOfMsgType = _cursor.getColumnIndexOrThrow("msgType");
      final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("status");
      final int _cursorIndexOfContent = _cursor.getColumnIndexOrThrow("content");
      final int _cursorIndexOfFuncType = _cursor.getColumnIndexOrThrow("funcType");
      final int _cursorIndexOfExtStr0 = _cursor.getColumnIndexOrThrow("extStr0");
      final int _cursorIndexOfExtStr1 = _cursor.getColumnIndexOrThrow("extStr1");
      final int _cursorIndexOfExtStr2 = _cursor.getColumnIndexOrThrow("extStr2");
      final int _cursorIndexOfExtLong0 = _cursor.getColumnIndexOrThrow("extLong0");
      final int _cursorIndexOfExtLong1 = _cursor.getColumnIndexOrThrow("extLong1");
      final int _cursorIndexOfExtLong2 = _cursor.getColumnIndexOrThrow("extLong2");
      final List<IMMessageBean> _result = new ArrayList<IMMessageBean>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final IMMessageBean _item;
        final long _tmpUid;
        _tmpUid = _cursor.getLong(_cursorIndexOfUid);
        final boolean _tmpIsSendByMe;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsSendByMe);
        _tmpIsSendByMe = _tmp_1 != 0;
        final long _tmpSendTime;
        _tmpSendTime = _cursor.getLong(_cursorIndexOfSendTime);
        final int _tmpMsgType;
        _tmpMsgType = _cursor.getInt(_cursorIndexOfMsgType);
        final int _tmpStatus;
        _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        final String _tmpContent;
        _tmpContent = _cursor.getString(_cursorIndexOfContent);
        final int _tmpFuncType;
        _tmpFuncType = _cursor.getInt(_cursorIndexOfFuncType);
        final String _tmpExtStr0;
        _tmpExtStr0 = _cursor.getString(_cursorIndexOfExtStr0);
        final String _tmpExtStr1;
        _tmpExtStr1 = _cursor.getString(_cursorIndexOfExtStr1);
        final String _tmpExtStr2;
        _tmpExtStr2 = _cursor.getString(_cursorIndexOfExtStr2);
        final long _tmpExtLong0;
        _tmpExtLong0 = _cursor.getLong(_cursorIndexOfExtLong0);
        final long _tmpExtLong1;
        _tmpExtLong1 = _cursor.getLong(_cursorIndexOfExtLong1);
        final long _tmpExtLong2;
        _tmpExtLong2 = _cursor.getLong(_cursorIndexOfExtLong2);
        _item = new IMMessageBean(_tmpUid,_tmpIsSendByMe,_tmpSendTime,_tmpMsgType,_tmpStatus,_tmpContent,_tmpFuncType,_tmpExtStr0,_tmpExtStr1,_tmpExtStr2,_tmpExtLong0,_tmpExtLong1,_tmpExtLong2);
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<IMMessageBean> queryReceiveChatInviteMsg(long uid, String invitationId) {
    final String _sql = "SELECT * FROM IMMessageBean WHERE uid = ? AND isSendByMe = 0 AND msgType = 3 AND funcType = 101 AND content LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, uid);
    _argIndex = 2;
    if (invitationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, invitationId);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfUid = _cursor.getColumnIndexOrThrow("uid");
      final int _cursorIndexOfIsSendByMe = _cursor.getColumnIndexOrThrow("isSendByMe");
      final int _cursorIndexOfSendTime = _cursor.getColumnIndexOrThrow("sendTime");
      final int _cursorIndexOfMsgType = _cursor.getColumnIndexOrThrow("msgType");
      final int _cursorIndexOfStatus = _cursor.getColumnIndexOrThrow("status");
      final int _cursorIndexOfContent = _cursor.getColumnIndexOrThrow("content");
      final int _cursorIndexOfFuncType = _cursor.getColumnIndexOrThrow("funcType");
      final int _cursorIndexOfExtStr0 = _cursor.getColumnIndexOrThrow("extStr0");
      final int _cursorIndexOfExtStr1 = _cursor.getColumnIndexOrThrow("extStr1");
      final int _cursorIndexOfExtStr2 = _cursor.getColumnIndexOrThrow("extStr2");
      final int _cursorIndexOfExtLong0 = _cursor.getColumnIndexOrThrow("extLong0");
      final int _cursorIndexOfExtLong1 = _cursor.getColumnIndexOrThrow("extLong1");
      final int _cursorIndexOfExtLong2 = _cursor.getColumnIndexOrThrow("extLong2");
      final List<IMMessageBean> _result = new ArrayList<IMMessageBean>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final IMMessageBean _item;
        final long _tmpUid;
        _tmpUid = _cursor.getLong(_cursorIndexOfUid);
        final boolean _tmpIsSendByMe;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsSendByMe);
        _tmpIsSendByMe = _tmp != 0;
        final long _tmpSendTime;
        _tmpSendTime = _cursor.getLong(_cursorIndexOfSendTime);
        final int _tmpMsgType;
        _tmpMsgType = _cursor.getInt(_cursorIndexOfMsgType);
        final int _tmpStatus;
        _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        final String _tmpContent;
        _tmpContent = _cursor.getString(_cursorIndexOfContent);
        final int _tmpFuncType;
        _tmpFuncType = _cursor.getInt(_cursorIndexOfFuncType);
        final String _tmpExtStr0;
        _tmpExtStr0 = _cursor.getString(_cursorIndexOfExtStr0);
        final String _tmpExtStr1;
        _tmpExtStr1 = _cursor.getString(_cursorIndexOfExtStr1);
        final String _tmpExtStr2;
        _tmpExtStr2 = _cursor.getString(_cursorIndexOfExtStr2);
        final long _tmpExtLong0;
        _tmpExtLong0 = _cursor.getLong(_cursorIndexOfExtLong0);
        final long _tmpExtLong1;
        _tmpExtLong1 = _cursor.getLong(_cursorIndexOfExtLong1);
        final long _tmpExtLong2;
        _tmpExtLong2 = _cursor.getLong(_cursorIndexOfExtLong2);
        _item = new IMMessageBean(_tmpUid,_tmpIsSendByMe,_tmpSendTime,_tmpMsgType,_tmpStatus,_tmpContent,_tmpFuncType,_tmpExtStr0,_tmpExtStr1,_tmpExtStr2,_tmpExtLong0,_tmpExtLong1,_tmpExtLong2);
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
