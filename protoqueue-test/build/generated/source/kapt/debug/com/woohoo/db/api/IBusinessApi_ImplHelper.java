package com.woohoo.db.api;

import com.silencedut.hub_annotation.IFindImplClz;
import java.lang.Class;
import java.lang.Object;
import java.lang.Override;
import java.util.HashSet;
import java.util.Set;

public final class IBusinessApi_ImplHelper implements IFindImplClz {
  private static final Set<Class> sameImplClass;

  private static final Object sImplInstance;

  static {
    sameImplClass = new HashSet();
    sImplInstance = new com.woohoo.db.provider.BusinessDbApiImpl();
    sameImplClass.add(com.woohoo.db.api.IBusinessApi.class);
    sameImplClass.add(com.woohoo.app.common.provider.db.api.IBusinessDbInitApi.class);
  }

  @Override
  public Object getInstance() {
    return sImplInstance;
  }

  @Override
  public Set getApis() {
    return sameImplClass;
  }
}
