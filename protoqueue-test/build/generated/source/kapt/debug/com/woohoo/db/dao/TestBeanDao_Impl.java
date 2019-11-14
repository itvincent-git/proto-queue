package com.woohoo.db.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EmptyResultSetException;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import com.woohoo.app.common.provider.db.bean.TestBean;
import io.reactivex.Single;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings("unchecked")
public class TestBeanDao_Impl implements TestBeanDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfTestBean;

  private final SharedSQLiteStatement __preparedStmtOfClear;

  private final SharedSQLiteStatement __preparedStmtOfReadAllMessage;

  private final SharedSQLiteStatement __preparedStmtOfReadMessage;

  private final SharedSQLiteStatement __preparedStmtOfDeleteMsg;

  private final SharedSQLiteStatement __preparedStmtOfReadMessageByTime;

  public TestBeanDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTestBean = new EntityInsertionAdapter<TestBean>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `TestBean`(`id`,`uid`,`createTime`,`isSendByMe`,`hasRead`,`msgText`,`msgId`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TestBean value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getUid());
        stmt.bindLong(3, value.getCreateTime());
        final int _tmp;
        _tmp = value.isSendByMe() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        final int _tmp_1;
        _tmp_1 = value.getHasRead() ? 1 : 0;
        stmt.bindLong(5, _tmp_1);
        if (value.getMsgText() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMsgText());
        }
        if (value.getMsgId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getMsgId());
        }
      }
    };
    this.__preparedStmtOfClear = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM TestBean";
        return _query;
      }
    };
    this.__preparedStmtOfReadAllMessage = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE TestBean SET hasRead = 1 WHERE uid = ? AND hasRead = 0";
        return _query;
      }
    };
    this.__preparedStmtOfReadMessage = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE TestBean SET hasRead = 1 WHERE msgId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteMsg = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM TestBean WHERE msgId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfReadMessageByTime = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE TestBean SET hasRead = 1 WHERE uid = ? AND createTime = ? AND isSendByMe = ?";
        return _query;
      }
    };
  }

  @Override
  public void insertTestBean(List<TestBean> beans) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfTestBean.insert(beans);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int clear() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfClear.acquire();
    __db.beginTransaction();
    try {
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfClear.release(_stmt);
    }
  }

  @Override
  public int readAllMessage(long uid) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfReadAllMessage.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      _stmt.bindLong(_argIndex, uid);
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfReadAllMessage.release(_stmt);
    }
  }

  @Override
  public int readMessage(String msgId) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfReadMessage.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (msgId == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, msgId);
      }
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfReadMessage.release(_stmt);
    }
  }

  @Override
  public int deleteMsg(String msgId) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteMsg.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (msgId == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, msgId);
      }
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteMsg.release(_stmt);
    }
  }

  @Override
  public int readMessageByTime(long uid, long time, boolean isSendByMe) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfReadMessageByTime.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      _stmt.bindLong(_argIndex, uid);
      _argIndex = 2;
      _stmt.bindLong(_argIndex, time);
      _argIndex = 3;
      final int _tmp;
      _tmp = isSendByMe ? 1 : 0;
      _stmt.bindLong(_argIndex, _tmp);
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
      __preparedStmtOfReadMessageByTime.release(_stmt);
    }
  }

  @Override
  public Single<List<TestBean>> queryByUid(long targetUid) {
    final String _sql = "SELECT * FROM TestBean WHERE uid = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, targetUid);
    return Single.fromCallable(new Callable<List<TestBean>>() {
      @Override
      public List<TestBean> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfUid = _cursor.getColumnIndexOrThrow("uid");
          final int _cursorIndexOfCreateTime = _cursor.getColumnIndexOrThrow("createTime");
          final int _cursorIndexOfIsSendByMe = _cursor.getColumnIndexOrThrow("isSendByMe");
          final int _cursorIndexOfHasRead = _cursor.getColumnIndexOrThrow("hasRead");
          final int _cursorIndexOfMsgText = _cursor.getColumnIndexOrThrow("msgText");
          final int _cursorIndexOfMsgId = _cursor.getColumnIndexOrThrow("msgId");
          final java.util.List<com.woohoo.app.common.provider.db.bean.TestBean> _result = new java.util.ArrayList<com.woohoo.app.common.provider.db.bean.TestBean>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final com.woohoo.app.common.provider.db.bean.TestBean _item;
            _item = new com.woohoo.app.common.provider.db.bean.TestBean();
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            _item.setId(_tmpId);
            final long _tmpUid;
            _tmpUid = _cursor.getLong(_cursorIndexOfUid);
            _item.setUid(_tmpUid);
            final long _tmpCreateTime;
            _tmpCreateTime = _cursor.getLong(_cursorIndexOfCreateTime);
            _item.setCreateTime(_tmpCreateTime);
            final boolean _tmpIsSendByMe;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsSendByMe);
            _tmpIsSendByMe = _tmp != 0;
            _item.setSendByMe(_tmpIsSendByMe);
            final boolean _tmpHasRead;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfHasRead);
            _tmpHasRead = _tmp_1 != 0;
            _item.setHasRead(_tmpHasRead);
            final java.lang.String _tmpMsgText;
            _tmpMsgText = _cursor.getString(_cursorIndexOfMsgText);
            _item.setMsgText(_tmpMsgText);
            final java.lang.String _tmpMsgId;
            _tmpMsgId = _cursor.getString(_cursorIndexOfMsgId);
            _item.setMsgId(_tmpMsgId);
            _result.add(_item);
          }
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Single<List<TestBean>> queryByUidWithOrder(long uid) {
    final String _sql = "SELECT * FROM TestBean WHERE uid = ? ORDER BY createTime";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, uid);
    return Single.fromCallable(new Callable<List<TestBean>>() {
      @Override
      public List<TestBean> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfUid = _cursor.getColumnIndexOrThrow("uid");
          final int _cursorIndexOfCreateTime = _cursor.getColumnIndexOrThrow("createTime");
          final int _cursorIndexOfIsSendByMe = _cursor.getColumnIndexOrThrow("isSendByMe");
          final int _cursorIndexOfHasRead = _cursor.getColumnIndexOrThrow("hasRead");
          final int _cursorIndexOfMsgText = _cursor.getColumnIndexOrThrow("msgText");
          final int _cursorIndexOfMsgId = _cursor.getColumnIndexOrThrow("msgId");
          final java.util.List<com.woohoo.app.common.provider.db.bean.TestBean> _result = new java.util.ArrayList<com.woohoo.app.common.provider.db.bean.TestBean>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final com.woohoo.app.common.provider.db.bean.TestBean _item;
            _item = new com.woohoo.app.common.provider.db.bean.TestBean();
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            _item.setId(_tmpId);
            final long _tmpUid;
            _tmpUid = _cursor.getLong(_cursorIndexOfUid);
            _item.setUid(_tmpUid);
            final long _tmpCreateTime;
            _tmpCreateTime = _cursor.getLong(_cursorIndexOfCreateTime);
            _item.setCreateTime(_tmpCreateTime);
            final boolean _tmpIsSendByMe;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsSendByMe);
            _tmpIsSendByMe = _tmp != 0;
            _item.setSendByMe(_tmpIsSendByMe);
            final boolean _tmpHasRead;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfHasRead);
            _tmpHasRead = _tmp_1 != 0;
            _item.setHasRead(_tmpHasRead);
            final java.lang.String _tmpMsgText;
            _tmpMsgText = _cursor.getString(_cursorIndexOfMsgText);
            _item.setMsgText(_tmpMsgText);
            final java.lang.String _tmpMsgId;
            _tmpMsgId = _cursor.getString(_cursorIndexOfMsgId);
            _item.setMsgId(_tmpMsgId);
            _result.add(_item);
          }
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Single<List<TestBean>> queryUnreadByUid(long uid) {
    final String _sql = "SELECT * FROM TestBean WHERE uid = ? AND hasRead = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, uid);
    return Single.fromCallable(new Callable<List<TestBean>>() {
      @Override
      public List<TestBean> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfUid = _cursor.getColumnIndexOrThrow("uid");
          final int _cursorIndexOfCreateTime = _cursor.getColumnIndexOrThrow("createTime");
          final int _cursorIndexOfIsSendByMe = _cursor.getColumnIndexOrThrow("isSendByMe");
          final int _cursorIndexOfHasRead = _cursor.getColumnIndexOrThrow("hasRead");
          final int _cursorIndexOfMsgText = _cursor.getColumnIndexOrThrow("msgText");
          final int _cursorIndexOfMsgId = _cursor.getColumnIndexOrThrow("msgId");
          final java.util.List<com.woohoo.app.common.provider.db.bean.TestBean> _result = new java.util.ArrayList<com.woohoo.app.common.provider.db.bean.TestBean>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final com.woohoo.app.common.provider.db.bean.TestBean _item;
            _item = new com.woohoo.app.common.provider.db.bean.TestBean();
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            _item.setId(_tmpId);
            final long _tmpUid;
            _tmpUid = _cursor.getLong(_cursorIndexOfUid);
            _item.setUid(_tmpUid);
            final long _tmpCreateTime;
            _tmpCreateTime = _cursor.getLong(_cursorIndexOfCreateTime);
            _item.setCreateTime(_tmpCreateTime);
            final boolean _tmpIsSendByMe;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsSendByMe);
            _tmpIsSendByMe = _tmp != 0;
            _item.setSendByMe(_tmpIsSendByMe);
            final boolean _tmpHasRead;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfHasRead);
            _tmpHasRead = _tmp_1 != 0;
            _item.setHasRead(_tmpHasRead);
            final java.lang.String _tmpMsgText;
            _tmpMsgText = _cursor.getString(_cursorIndexOfMsgText);
            _item.setMsgText(_tmpMsgText);
            final java.lang.String _tmpMsgId;
            _tmpMsgId = _cursor.getString(_cursorIndexOfMsgId);
            _item.setMsgId(_tmpMsgId);
            _result.add(_item);
          }
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Single<List<TestBean>> queryByUidWithOrder(long uid, int start, int end) {
    final String _sql = "SELECT * FROM TestBean WHERE uid = ? ORDER BY createTime DESC LIMIT ?, ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, uid);
    _argIndex = 2;
    _statement.bindLong(_argIndex, start);
    _argIndex = 3;
    _statement.bindLong(_argIndex, end);
    return Single.fromCallable(new Callable<List<TestBean>>() {
      @Override
      public List<TestBean> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfUid = _cursor.getColumnIndexOrThrow("uid");
          final int _cursorIndexOfCreateTime = _cursor.getColumnIndexOrThrow("createTime");
          final int _cursorIndexOfIsSendByMe = _cursor.getColumnIndexOrThrow("isSendByMe");
          final int _cursorIndexOfHasRead = _cursor.getColumnIndexOrThrow("hasRead");
          final int _cursorIndexOfMsgText = _cursor.getColumnIndexOrThrow("msgText");
          final int _cursorIndexOfMsgId = _cursor.getColumnIndexOrThrow("msgId");
          final java.util.List<com.woohoo.app.common.provider.db.bean.TestBean> _result = new java.util.ArrayList<com.woohoo.app.common.provider.db.bean.TestBean>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final com.woohoo.app.common.provider.db.bean.TestBean _item;
            _item = new com.woohoo.app.common.provider.db.bean.TestBean();
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            _item.setId(_tmpId);
            final long _tmpUid;
            _tmpUid = _cursor.getLong(_cursorIndexOfUid);
            _item.setUid(_tmpUid);
            final long _tmpCreateTime;
            _tmpCreateTime = _cursor.getLong(_cursorIndexOfCreateTime);
            _item.setCreateTime(_tmpCreateTime);
            final boolean _tmpIsSendByMe;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsSendByMe);
            _tmpIsSendByMe = _tmp != 0;
            _item.setSendByMe(_tmpIsSendByMe);
            final boolean _tmpHasRead;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfHasRead);
            _tmpHasRead = _tmp_1 != 0;
            _item.setHasRead(_tmpHasRead);
            final java.lang.String _tmpMsgText;
            _tmpMsgText = _cursor.getString(_cursorIndexOfMsgText);
            _item.setMsgText(_tmpMsgText);
            final java.lang.String _tmpMsgId;
            _tmpMsgId = _cursor.getString(_cursorIndexOfMsgId);
            _item.setMsgId(_tmpMsgId);
            _result.add(_item);
          }
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Single<Integer> queryUnreadCount(long uid) {
    final String _sql = "SELECT COUNT(*) FROM TestBean WHERE uid = ? AND hasRead = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, uid);
    return Single.fromCallable(new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final java.lang.Integer _result;
          if(_cursor.moveToFirst()) {
            final java.lang.Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Single<Integer> queryAllCount() {
    final String _sql = "SELECT COUNT(*) FROM TestBean";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return Single.fromCallable(new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final java.lang.Integer _result;
          if(_cursor.moveToFirst()) {
            final java.lang.Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public List<TestBean> readByContent(String content) {
    final String _sql = "SELECT * FROM TestBean WHERE msgText LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (content == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, content);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfUid = _cursor.getColumnIndexOrThrow("uid");
      final int _cursorIndexOfCreateTime = _cursor.getColumnIndexOrThrow("createTime");
      final int _cursorIndexOfIsSendByMe = _cursor.getColumnIndexOrThrow("isSendByMe");
      final int _cursorIndexOfHasRead = _cursor.getColumnIndexOrThrow("hasRead");
      final int _cursorIndexOfMsgText = _cursor.getColumnIndexOrThrow("msgText");
      final int _cursorIndexOfMsgId = _cursor.getColumnIndexOrThrow("msgId");
      final List<TestBean> _result = new ArrayList<TestBean>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TestBean _item;
        _item = new TestBean();
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        _item.setId(_tmpId);
        final long _tmpUid;
        _tmpUid = _cursor.getLong(_cursorIndexOfUid);
        _item.setUid(_tmpUid);
        final long _tmpCreateTime;
        _tmpCreateTime = _cursor.getLong(_cursorIndexOfCreateTime);
        _item.setCreateTime(_tmpCreateTime);
        final boolean _tmpIsSendByMe;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsSendByMe);
        _tmpIsSendByMe = _tmp != 0;
        _item.setSendByMe(_tmpIsSendByMe);
        final boolean _tmpHasRead;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfHasRead);
        _tmpHasRead = _tmp_1 != 0;
        _item.setHasRead(_tmpHasRead);
        final String _tmpMsgText;
        _tmpMsgText = _cursor.getString(_cursorIndexOfMsgText);
        _item.setMsgText(_tmpMsgText);
        final String _tmpMsgId;
        _tmpMsgId = _cursor.getString(_cursorIndexOfMsgId);
        _item.setMsgId(_tmpMsgId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
