package com.woohoo.db.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import com.woohoo.app.common.provider.db.bean.SessionDBData;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class SessionDao_Impl implements SessionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfSessionDBData;

  private final SharedSQLiteStatement __preparedStmtOfDeleteSession;

  private final SharedSQLiteStatement __preparedStmtOfClear;

  private final SharedSQLiteStatement __preparedStmtOfSaveSendLimitCount;

  private final SharedSQLiteStatement __preparedStmtOfSaveResetSendLimitCountTime;

  public SessionDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSessionDBData = new EntityInsertionAdapter<SessionDBData>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `im_session`(`sessionId`,`portrait`,`title`,`content`,`sendTime`,`unreadCount`,`sessionType`,`extStr0`,`extStr1`,`extStr2`,`extLong0`,`extLong1`,`extLong2`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SessionDBData value) {
        stmt.bindLong(1, value.getSessionId());
        if (value.getPortrait() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPortrait());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTitle());
        }
        if (value.getContent() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getContent());
        }
        stmt.bindLong(5, value.getSendTime());
        stmt.bindLong(6, value.getUnreadCount());
        stmt.bindLong(7, value.getSessionType());
        if (value.getExtStr0() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getExtStr0());
        }
        if (value.getExtStr1() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getExtStr1());
        }
        if (value.getExtStr2() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getExtStr2());
        }
        stmt.bindLong(11, value.getExtLong0());
        stmt.bindLong(12, value.getExtLong1());
        stmt.bindLong(13, value.getExtLong2());
      }
    };
    this.__preparedStmtOfDeleteSession = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM im_session WHERE  sessionId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfClear = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM im_session";
        return _query;
      }
    };
    this.__preparedStmtOfSaveSendLimitCount = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE im_session SET extLong0 = ? WHERE sessionId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfSaveResetSendLimitCountTime = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE im_session SET extLong1 = ? WHERE sessionId = ?";
        return _query;
      }
    };
  }

  @Override
  public void saveOrReplaceSession(SessionDBData bean) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfSessionDBData.insert(bean);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteSession(long deleteSessionId) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteSession.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      _stmt.bindLong(_argIndex, deleteSessionId);
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteSession.release(_stmt);
    }
  }

  @Override
  public void clear() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfClear.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfClear.release(_stmt);
    }
  }

  @Override
  public void saveSendLimitCount(long updateSessionId, int count) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfSaveSendLimitCount.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      _stmt.bindLong(_argIndex, count);
      _argIndex = 2;
      _stmt.bindLong(_argIndex, updateSessionId);
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfSaveSendLimitCount.release(_stmt);
    }
  }

  @Override
  public void saveResetSendLimitCountTime(long updateSessionId, long time) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfSaveResetSendLimitCountTime.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      _stmt.bindLong(_argIndex, time);
      _argIndex = 2;
      _stmt.bindLong(_argIndex, updateSessionId);
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfSaveResetSendLimitCountTime.release(_stmt);
    }
  }

  @Override
  public List<SessionDBData> getAllSessions() {
    final String _sql = "Select * from im_session order by sendTime desc";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfSessionId = _cursor.getColumnIndexOrThrow("sessionId");
      final int _cursorIndexOfPortrait = _cursor.getColumnIndexOrThrow("portrait");
      final int _cursorIndexOfTitle = _cursor.getColumnIndexOrThrow("title");
      final int _cursorIndexOfContent = _cursor.getColumnIndexOrThrow("content");
      final int _cursorIndexOfSendTime = _cursor.getColumnIndexOrThrow("sendTime");
      final int _cursorIndexOfUnreadCount = _cursor.getColumnIndexOrThrow("unreadCount");
      final int _cursorIndexOfSessionType = _cursor.getColumnIndexOrThrow("sessionType");
      final int _cursorIndexOfExtStr0 = _cursor.getColumnIndexOrThrow("extStr0");
      final int _cursorIndexOfExtStr1 = _cursor.getColumnIndexOrThrow("extStr1");
      final int _cursorIndexOfExtStr2 = _cursor.getColumnIndexOrThrow("extStr2");
      final int _cursorIndexOfExtLong0 = _cursor.getColumnIndexOrThrow("extLong0");
      final int _cursorIndexOfExtLong1 = _cursor.getColumnIndexOrThrow("extLong1");
      final int _cursorIndexOfExtLong2 = _cursor.getColumnIndexOrThrow("extLong2");
      final List<SessionDBData> _result = new ArrayList<SessionDBData>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SessionDBData _item;
        final long _tmpSessionId;
        _tmpSessionId = _cursor.getLong(_cursorIndexOfSessionId);
        final String _tmpPortrait;
        _tmpPortrait = _cursor.getString(_cursorIndexOfPortrait);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpContent;
        _tmpContent = _cursor.getString(_cursorIndexOfContent);
        final long _tmpSendTime;
        _tmpSendTime = _cursor.getLong(_cursorIndexOfSendTime);
        final int _tmpUnreadCount;
        _tmpUnreadCount = _cursor.getInt(_cursorIndexOfUnreadCount);
        final int _tmpSessionType;
        _tmpSessionType = _cursor.getInt(_cursorIndexOfSessionType);
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
        _item = new SessionDBData(_tmpSessionId,_tmpPortrait,_tmpTitle,_tmpContent,_tmpSendTime,_tmpUnreadCount,_tmpSessionType,_tmpExtStr0,_tmpExtStr1,_tmpExtStr2,_tmpExtLong0,_tmpExtLong1,_tmpExtLong2);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public SessionDBData getSession(long updateSessionId) {
    final String _sql = "Select * from im_session WHERE sessionId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, updateSessionId);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfSessionId = _cursor.getColumnIndexOrThrow("sessionId");
      final int _cursorIndexOfPortrait = _cursor.getColumnIndexOrThrow("portrait");
      final int _cursorIndexOfTitle = _cursor.getColumnIndexOrThrow("title");
      final int _cursorIndexOfContent = _cursor.getColumnIndexOrThrow("content");
      final int _cursorIndexOfSendTime = _cursor.getColumnIndexOrThrow("sendTime");
      final int _cursorIndexOfUnreadCount = _cursor.getColumnIndexOrThrow("unreadCount");
      final int _cursorIndexOfSessionType = _cursor.getColumnIndexOrThrow("sessionType");
      final int _cursorIndexOfExtStr0 = _cursor.getColumnIndexOrThrow("extStr0");
      final int _cursorIndexOfExtStr1 = _cursor.getColumnIndexOrThrow("extStr1");
      final int _cursorIndexOfExtStr2 = _cursor.getColumnIndexOrThrow("extStr2");
      final int _cursorIndexOfExtLong0 = _cursor.getColumnIndexOrThrow("extLong0");
      final int _cursorIndexOfExtLong1 = _cursor.getColumnIndexOrThrow("extLong1");
      final int _cursorIndexOfExtLong2 = _cursor.getColumnIndexOrThrow("extLong2");
      final SessionDBData _result;
      if(_cursor.moveToFirst()) {
        final long _tmpSessionId;
        _tmpSessionId = _cursor.getLong(_cursorIndexOfSessionId);
        final String _tmpPortrait;
        _tmpPortrait = _cursor.getString(_cursorIndexOfPortrait);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpContent;
        _tmpContent = _cursor.getString(_cursorIndexOfContent);
        final long _tmpSendTime;
        _tmpSendTime = _cursor.getLong(_cursorIndexOfSendTime);
        final int _tmpUnreadCount;
        _tmpUnreadCount = _cursor.getInt(_cursorIndexOfUnreadCount);
        final int _tmpSessionType;
        _tmpSessionType = _cursor.getInt(_cursorIndexOfSessionType);
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
        _result = new SessionDBData(_tmpSessionId,_tmpPortrait,_tmpTitle,_tmpContent,_tmpSendTime,_tmpUnreadCount,_tmpSessionType,_tmpExtStr0,_tmpExtStr1,_tmpExtStr2,_tmpExtLong0,_tmpExtLong1,_tmpExtLong2);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
