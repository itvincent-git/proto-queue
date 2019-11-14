package com.woohoo.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import com.woohoo.db.dao.IMMessageDao;
import com.woohoo.db.dao.IMMessageDao_Impl;
import com.woohoo.db.dao.SessionDao;
import com.woohoo.db.dao.SessionDao_Impl;
import com.woohoo.db.dao.TestBeanDao;
import com.woohoo.db.dao.TestBeanDao_Impl;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class BusinessDataBase_Impl extends BusinessDataBase {
  private volatile TestBeanDao _testBeanDao;

  private volatile SessionDao _sessionDao;

  private volatile IMMessageDao _iMMessageDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `TestBean` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `uid` INTEGER NOT NULL, `createTime` INTEGER NOT NULL, `isSendByMe` INTEGER NOT NULL, `hasRead` INTEGER NOT NULL, `msgText` TEXT NOT NULL, `msgId` TEXT NOT NULL)");
        _db.execSQL("CREATE  INDEX `index_TestBean_uid_createTime` ON `TestBean` (`uid`, `createTime`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `im_session` (`sessionId` INTEGER NOT NULL, `portrait` TEXT NOT NULL, `title` TEXT NOT NULL, `content` TEXT NOT NULL, `sendTime` INTEGER NOT NULL, `unreadCount` INTEGER NOT NULL, `sessionType` INTEGER NOT NULL, `extStr0` TEXT NOT NULL, `extStr1` TEXT NOT NULL, `extStr2` TEXT NOT NULL, `extLong0` INTEGER NOT NULL, `extLong1` INTEGER NOT NULL, `extLong2` INTEGER NOT NULL, PRIMARY KEY(`sessionId`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `IMMessageBean` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `uid` INTEGER NOT NULL, `isSendByMe` INTEGER NOT NULL, `sendTime` INTEGER NOT NULL, `msgType` INTEGER NOT NULL, `status` INTEGER NOT NULL, `content` TEXT NOT NULL, `funcType` INTEGER NOT NULL, `extStr0` TEXT NOT NULL, `extStr1` TEXT NOT NULL, `extStr2` TEXT NOT NULL, `extLong0` INTEGER NOT NULL, `extLong1` INTEGER NOT NULL, `extLong2` INTEGER NOT NULL)");
        _db.execSQL("CREATE  INDEX `index_IMMessageBean_uid_sendTime` ON `IMMessageBean` (`uid`, `sendTime`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"9aae1e8409a7b0d94dce68007d967b02\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `TestBean`");
        _db.execSQL("DROP TABLE IF EXISTS `im_session`");
        _db.execSQL("DROP TABLE IF EXISTS `IMMessageBean`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsTestBean = new HashMap<String, TableInfo.Column>(7);
        _columnsTestBean.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsTestBean.put("uid", new TableInfo.Column("uid", "INTEGER", true, 0));
        _columnsTestBean.put("createTime", new TableInfo.Column("createTime", "INTEGER", true, 0));
        _columnsTestBean.put("isSendByMe", new TableInfo.Column("isSendByMe", "INTEGER", true, 0));
        _columnsTestBean.put("hasRead", new TableInfo.Column("hasRead", "INTEGER", true, 0));
        _columnsTestBean.put("msgText", new TableInfo.Column("msgText", "TEXT", true, 0));
        _columnsTestBean.put("msgId", new TableInfo.Column("msgId", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTestBean = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTestBean = new HashSet<TableInfo.Index>(1);
        _indicesTestBean.add(new TableInfo.Index("index_TestBean_uid_createTime", false, Arrays.asList("uid","createTime")));
        final TableInfo _infoTestBean = new TableInfo("TestBean", _columnsTestBean, _foreignKeysTestBean, _indicesTestBean);
        final TableInfo _existingTestBean = TableInfo.read(_db, "TestBean");
        if (! _infoTestBean.equals(_existingTestBean)) {
          throw new IllegalStateException("Migration didn't properly handle TestBean(com.woohoo.app.common.provider.db.bean.TestBean).\n"
                  + " Expected:\n" + _infoTestBean + "\n"
                  + " Found:\n" + _existingTestBean);
        }
        final HashMap<String, TableInfo.Column> _columnsImSession = new HashMap<String, TableInfo.Column>(13);
        _columnsImSession.put("sessionId", new TableInfo.Column("sessionId", "INTEGER", true, 1));
        _columnsImSession.put("portrait", new TableInfo.Column("portrait", "TEXT", true, 0));
        _columnsImSession.put("title", new TableInfo.Column("title", "TEXT", true, 0));
        _columnsImSession.put("content", new TableInfo.Column("content", "TEXT", true, 0));
        _columnsImSession.put("sendTime", new TableInfo.Column("sendTime", "INTEGER", true, 0));
        _columnsImSession.put("unreadCount", new TableInfo.Column("unreadCount", "INTEGER", true, 0));
        _columnsImSession.put("sessionType", new TableInfo.Column("sessionType", "INTEGER", true, 0));
        _columnsImSession.put("extStr0", new TableInfo.Column("extStr0", "TEXT", true, 0));
        _columnsImSession.put("extStr1", new TableInfo.Column("extStr1", "TEXT", true, 0));
        _columnsImSession.put("extStr2", new TableInfo.Column("extStr2", "TEXT", true, 0));
        _columnsImSession.put("extLong0", new TableInfo.Column("extLong0", "INTEGER", true, 0));
        _columnsImSession.put("extLong1", new TableInfo.Column("extLong1", "INTEGER", true, 0));
        _columnsImSession.put("extLong2", new TableInfo.Column("extLong2", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysImSession = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesImSession = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoImSession = new TableInfo("im_session", _columnsImSession, _foreignKeysImSession, _indicesImSession);
        final TableInfo _existingImSession = TableInfo.read(_db, "im_session");
        if (! _infoImSession.equals(_existingImSession)) {
          throw new IllegalStateException("Migration didn't properly handle im_session(com.woohoo.app.common.provider.db.bean.SessionDBData).\n"
                  + " Expected:\n" + _infoImSession + "\n"
                  + " Found:\n" + _existingImSession);
        }
        final HashMap<String, TableInfo.Column> _columnsIMMessageBean = new HashMap<String, TableInfo.Column>(14);
        _columnsIMMessageBean.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsIMMessageBean.put("uid", new TableInfo.Column("uid", "INTEGER", true, 0));
        _columnsIMMessageBean.put("isSendByMe", new TableInfo.Column("isSendByMe", "INTEGER", true, 0));
        _columnsIMMessageBean.put("sendTime", new TableInfo.Column("sendTime", "INTEGER", true, 0));
        _columnsIMMessageBean.put("msgType", new TableInfo.Column("msgType", "INTEGER", true, 0));
        _columnsIMMessageBean.put("status", new TableInfo.Column("status", "INTEGER", true, 0));
        _columnsIMMessageBean.put("content", new TableInfo.Column("content", "TEXT", true, 0));
        _columnsIMMessageBean.put("funcType", new TableInfo.Column("funcType", "INTEGER", true, 0));
        _columnsIMMessageBean.put("extStr0", new TableInfo.Column("extStr0", "TEXT", true, 0));
        _columnsIMMessageBean.put("extStr1", new TableInfo.Column("extStr1", "TEXT", true, 0));
        _columnsIMMessageBean.put("extStr2", new TableInfo.Column("extStr2", "TEXT", true, 0));
        _columnsIMMessageBean.put("extLong0", new TableInfo.Column("extLong0", "INTEGER", true, 0));
        _columnsIMMessageBean.put("extLong1", new TableInfo.Column("extLong1", "INTEGER", true, 0));
        _columnsIMMessageBean.put("extLong2", new TableInfo.Column("extLong2", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysIMMessageBean = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesIMMessageBean = new HashSet<TableInfo.Index>(1);
        _indicesIMMessageBean.add(new TableInfo.Index("index_IMMessageBean_uid_sendTime", false, Arrays.asList("uid","sendTime")));
        final TableInfo _infoIMMessageBean = new TableInfo("IMMessageBean", _columnsIMMessageBean, _foreignKeysIMMessageBean, _indicesIMMessageBean);
        final TableInfo _existingIMMessageBean = TableInfo.read(_db, "IMMessageBean");
        if (! _infoIMMessageBean.equals(_existingIMMessageBean)) {
          throw new IllegalStateException("Migration didn't properly handle IMMessageBean(com.woohoo.app.common.provider.db.bean.IMMessageBean).\n"
                  + " Expected:\n" + _infoIMMessageBean + "\n"
                  + " Found:\n" + _existingIMMessageBean);
        }
      }
    }, "9aae1e8409a7b0d94dce68007d967b02", "78ee291f786f89da06c635b27850008a");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "TestBean","im_session","IMMessageBean");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `TestBean`");
      _db.execSQL("DELETE FROM `im_session`");
      _db.execSQL("DELETE FROM `IMMessageBean`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public TestBeanDao getTestBeanDao() {
    if (_testBeanDao != null) {
      return _testBeanDao;
    } else {
      synchronized(this) {
        if(_testBeanDao == null) {
          _testBeanDao = new TestBeanDao_Impl(this);
        }
        return _testBeanDao;
      }
    }
  }

  @Override
  public SessionDao getSessionDao() {
    if (_sessionDao != null) {
      return _sessionDao;
    } else {
      synchronized(this) {
        if(_sessionDao == null) {
          _sessionDao = new SessionDao_Impl(this);
        }
        return _sessionDao;
      }
    }
  }

  @Override
  public IMMessageDao getIMMessageDao() {
    if (_iMMessageDao != null) {
      return _iMMessageDao;
    } else {
      synchronized(this) {
        if(_iMMessageDao == null) {
          _iMMessageDao = new IMMessageDao_Impl(this);
        }
        return _iMMessageDao;
      }
    }
  }
}
