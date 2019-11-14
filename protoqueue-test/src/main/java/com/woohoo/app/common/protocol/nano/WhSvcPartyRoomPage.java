// Generated by the protocol buffer compiler.  DO NOT EDIT!

package com.woohoo.app.common.protocol.nano;

import org.jetbrains.annotations.Nullable;
@SuppressWarnings("hiding")
public interface WhSvcPartyRoomPage {

  public static final class RelatedRecommendReq extends
      com.google.protobuf.nano.MessageNano {

    private static volatile RelatedRecommendReq[] _emptyArray;
    public static RelatedRecommendReq[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new RelatedRecommendReq[0];
          }
        }
      }
      return _emptyArray;
    }

    public RelatedRecommendReq() {
      clear();
    }

    public RelatedRecommendReq clear() {
      cachedSize = -1;
      return this;
    }

    @Override
    public RelatedRecommendReq mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
        }
      }
    }

    public static RelatedRecommendReq parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new RelatedRecommendReq(), data);
    }

    public static RelatedRecommendReq parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new RelatedRecommendReq().mergeFrom(input);
    }
  }

  public static final class RelatedRecommendRes extends
      com.google.protobuf.nano.MessageNano {

    private static volatile RelatedRecommendRes[] _emptyArray;
    public static RelatedRecommendRes[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new RelatedRecommendRes[0];
          }
        }
      }
      return _emptyArray;
    }

    // optional .wh.svc.common.ResponseHeader header = 1;
    @Nullable
    public com.woohoo.app.common.protocol.nano.WhSvcCommon.ResponseHeader header;

    // repeated .wh.svc.partyroom.page.RelatedRecommendItem recommendItems = 2;
    public com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPage.RelatedRecommendItem[] recommendItems;

    public RelatedRecommendRes() {
      clear();
    }

    public RelatedRecommendRes clear() {
      header = null;
      recommendItems = com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPage.RelatedRecommendItem.emptyArray();
      cachedSize = -1;
      return this;
    }

    @Override
    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
        throws java.io.IOException {
      if (this.header != null) {
        output.writeMessage(1, this.header);
      }
      if (this.recommendItems != null && this.recommendItems.length > 0) {
        for (int i = 0; i < this.recommendItems.length; i++) {
          com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPage.RelatedRecommendItem element = this.recommendItems[i];
          if (element != null) {
            output.writeMessage(2, element);
          }
        }
      }
      super.writeTo(output);
    }

    @Override
    protected int computeSerializedSize() {
      int size = super.computeSerializedSize();
      if (this.header != null) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeMessageSize(1, this.header);
      }
      if (this.recommendItems != null && this.recommendItems.length > 0) {
        for (int i = 0; i < this.recommendItems.length; i++) {
          com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPage.RelatedRecommendItem element = this.recommendItems[i];
          if (element != null) {
            size += com.google.protobuf.nano.CodedOutputByteBufferNano
              .computeMessageSize(2, element);
          }
        }
      }
      return size;
    }

    @Override
    public RelatedRecommendRes mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 10: {
            if (this.header == null) {
              this.header = new com.woohoo.app.common.protocol.nano.WhSvcCommon.ResponseHeader();
            }
            input.readMessage(this.header);
            break;
          }
          case 18: {
            int arrayLength = com.google.protobuf.nano.WireFormatNano
                .getRepeatedFieldArrayLength(input, 18);
            int i = this.recommendItems == null ? 0 : this.recommendItems.length;
            com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPage.RelatedRecommendItem[] newArray =
                new com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPage.RelatedRecommendItem[i + arrayLength];
            if (i != 0) {
              java.lang.System.arraycopy(this.recommendItems, 0, newArray, 0, i);
            }
            for (; i < newArray.length - 1; i++) {
              newArray[i] = new com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPage.RelatedRecommendItem();
              input.readMessage(newArray[i]);
              input.readTag();
            }
            // Last one without readTag.
            newArray[i] = new com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPage.RelatedRecommendItem();
            input.readMessage(newArray[i]);
            this.recommendItems = newArray;
            break;
          }
        }
      }
    }

    public static RelatedRecommendRes parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new RelatedRecommendRes(), data);
    }

    public static RelatedRecommendRes parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new RelatedRecommendRes().mergeFrom(input);
    }
  }

  public static final class RelatedRecommendItem extends
      com.google.protobuf.nano.MessageNano {

    private static volatile RelatedRecommendItem[] _emptyArray;
    public static RelatedRecommendItem[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new RelatedRecommendItem[0];
          }
        }
      }
      return _emptyArray;
    }

    private int bitField0_;

    // optional int64 uid = 1;
    private long uid_;
    public long getUid() {
      return uid_;
    }
    public RelatedRecommendItem setUid(long value) {
      uid_ = value;
      bitField0_ |= 0x00000001;
      return this;
    }
    public boolean hasUid() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    public RelatedRecommendItem clearUid() {
      uid_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    // optional .wh.svc.common.RoomVid roomVid = 2;
    @Nullable
    public com.woohoo.app.common.protocol.nano.WhSvcCommon.RoomVid roomVid;

    public RelatedRecommendItem() {
      clear();
    }

    public RelatedRecommendItem clear() {
      bitField0_ = 0;
      uid_ = 0L;
      roomVid = null;
      cachedSize = -1;
      return this;
    }

    @Override
    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) != 0)) {
        output.writeInt64(1, uid_);
      }
      if (this.roomVid != null) {
        output.writeMessage(2, this.roomVid);
      }
      super.writeTo(output);
    }

    @Override
    protected int computeSerializedSize() {
      int size = super.computeSerializedSize();
      if (((bitField0_ & 0x00000001) != 0)) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeInt64Size(1, uid_);
      }
      if (this.roomVid != null) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeMessageSize(2, this.roomVid);
      }
      return size;
    }

    @Override
    public RelatedRecommendItem mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 8: {
            uid_ = input.readInt64();
            bitField0_ |= 0x00000001;
            break;
          }
          case 18: {
            if (this.roomVid == null) {
              this.roomVid = new com.woohoo.app.common.protocol.nano.WhSvcCommon.RoomVid();
            }
            input.readMessage(this.roomVid);
            break;
          }
        }
      }
    }

    public static RelatedRecommendItem parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new RelatedRecommendItem(), data);
    }

    public static RelatedRecommendItem parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new RelatedRecommendItem().mergeFrom(input);
    }
  }

  public static final class HomePageListReq extends
      com.google.protobuf.nano.MessageNano {

    private static volatile HomePageListReq[] _emptyArray;
    public static HomePageListReq[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new HomePageListReq[0];
          }
        }
      }
      return _emptyArray;
    }

    private int bitField0_;

    // optional string cursor = 1;
    private java.lang.String cursor_;
    @Nullable
    public java.lang.String getCursor() {
      return cursor_;
    }
    public HomePageListReq setCursor(java.lang.String value) {
      if (value == null) {
        throw new java.lang.NullPointerException();
      }
      cursor_ = value;
      bitField0_ |= 0x00000001;
      return this;
    }
    public boolean hasCursor() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    public HomePageListReq clearCursor() {
      cursor_ = "";
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    // optional int32 limit = 2;
    private int limit_;
    public int getLimit() {
      return limit_;
    }
    public HomePageListReq setLimit(int value) {
      limit_ = value;
      bitField0_ |= 0x00000002;
      return this;
    }
    public boolean hasLimit() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    public HomePageListReq clearLimit() {
      limit_ = 0;
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    public HomePageListReq() {
      clear();
    }

    public HomePageListReq clear() {
      bitField0_ = 0;
      cursor_ = "";
      limit_ = 0;
      cachedSize = -1;
      return this;
    }

    @Override
    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) != 0)) {
        output.writeString(1, cursor_);
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        output.writeInt32(2, limit_);
      }
      super.writeTo(output);
    }

    @Override
    protected int computeSerializedSize() {
      int size = super.computeSerializedSize();
      if (((bitField0_ & 0x00000001) != 0)) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeStringSize(1, cursor_);
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeInt32Size(2, limit_);
      }
      return size;
    }

    @Override
    public HomePageListReq mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 10: {
            cursor_ = input.readString();
            bitField0_ |= 0x00000001;
            break;
          }
          case 16: {
            limit_ = input.readInt32();
            bitField0_ |= 0x00000002;
            break;
          }
        }
      }
    }

    public static HomePageListReq parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new HomePageListReq(), data);
    }

    public static HomePageListReq parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new HomePageListReq().mergeFrom(input);
    }
  }

  public static final class HomePageListRes extends
      com.google.protobuf.nano.MessageNano {

    private static volatile HomePageListRes[] _emptyArray;
    public static HomePageListRes[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new HomePageListRes[0];
          }
        }
      }
      return _emptyArray;
    }

    private int bitField0_;

    // optional .wh.svc.common.ResponseHeader header = 1;
    @Nullable
    public com.woohoo.app.common.protocol.nano.WhSvcCommon.ResponseHeader header;

    // repeated .wh.svc.partyroom.page.RoomItem roomItems = 2;
    public com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPage.RoomItem[] roomItems;

    // optional string nextCursor = 3;
    private java.lang.String nextCursor_;
    @Nullable
    public java.lang.String getNextCursor() {
      return nextCursor_;
    }
    public HomePageListRes setNextCursor(java.lang.String value) {
      if (value == null) {
        throw new java.lang.NullPointerException();
      }
      nextCursor_ = value;
      bitField0_ |= 0x00000001;
      return this;
    }
    public boolean hasNextCursor() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    public HomePageListRes clearNextCursor() {
      nextCursor_ = "";
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    public HomePageListRes() {
      clear();
    }

    public HomePageListRes clear() {
      bitField0_ = 0;
      header = null;
      roomItems = com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPage.RoomItem.emptyArray();
      nextCursor_ = "";
      cachedSize = -1;
      return this;
    }

    @Override
    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
        throws java.io.IOException {
      if (this.header != null) {
        output.writeMessage(1, this.header);
      }
      if (this.roomItems != null && this.roomItems.length > 0) {
        for (int i = 0; i < this.roomItems.length; i++) {
          com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPage.RoomItem element = this.roomItems[i];
          if (element != null) {
            output.writeMessage(2, element);
          }
        }
      }
      if (((bitField0_ & 0x00000001) != 0)) {
        output.writeString(3, nextCursor_);
      }
      super.writeTo(output);
    }

    @Override
    protected int computeSerializedSize() {
      int size = super.computeSerializedSize();
      if (this.header != null) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeMessageSize(1, this.header);
      }
      if (this.roomItems != null && this.roomItems.length > 0) {
        for (int i = 0; i < this.roomItems.length; i++) {
          com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPage.RoomItem element = this.roomItems[i];
          if (element != null) {
            size += com.google.protobuf.nano.CodedOutputByteBufferNano
              .computeMessageSize(2, element);
          }
        }
      }
      if (((bitField0_ & 0x00000001) != 0)) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeStringSize(3, nextCursor_);
      }
      return size;
    }

    @Override
    public HomePageListRes mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 10: {
            if (this.header == null) {
              this.header = new com.woohoo.app.common.protocol.nano.WhSvcCommon.ResponseHeader();
            }
            input.readMessage(this.header);
            break;
          }
          case 18: {
            int arrayLength = com.google.protobuf.nano.WireFormatNano
                .getRepeatedFieldArrayLength(input, 18);
            int i = this.roomItems == null ? 0 : this.roomItems.length;
            com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPage.RoomItem[] newArray =
                new com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPage.RoomItem[i + arrayLength];
            if (i != 0) {
              java.lang.System.arraycopy(this.roomItems, 0, newArray, 0, i);
            }
            for (; i < newArray.length - 1; i++) {
              newArray[i] = new com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPage.RoomItem();
              input.readMessage(newArray[i]);
              input.readTag();
            }
            // Last one without readTag.
            newArray[i] = new com.woohoo.app.common.protocol.nano.WhSvcPartyRoomPage.RoomItem();
            input.readMessage(newArray[i]);
            this.roomItems = newArray;
            break;
          }
          case 26: {
            nextCursor_ = input.readString();
            bitField0_ |= 0x00000001;
            break;
          }
        }
      }
    }

    public static HomePageListRes parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new HomePageListRes(), data);
    }

    public static HomePageListRes parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new HomePageListRes().mergeFrom(input);
    }
  }

  public static final class RoomItem extends
      com.google.protobuf.nano.MessageNano {

    private static volatile RoomItem[] _emptyArray;
    public static RoomItem[] emptyArray() {
      // Lazily initializes the empty array
      if (_emptyArray == null) {
        synchronized (
            com.google.protobuf.nano.InternalNano.LAZY_INIT_LOCK) {
          if (_emptyArray == null) {
            _emptyArray = new RoomItem[0];
          }
        }
      }
      return _emptyArray;
    }

    private int bitField0_;

    // optional .wh.svc.common.RoomVid roomVid = 1;
    @Nullable
    public com.woohoo.app.common.protocol.nano.WhSvcCommon.RoomVid roomVid;

    // optional int64 hotScore = 2;
    private long hotScore_;
    public long getHotScore() {
      return hotScore_;
    }
    public RoomItem setHotScore(long value) {
      hotScore_ = value;
      bitField0_ |= 0x00000001;
      return this;
    }
    public boolean hasHotScore() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    public RoomItem clearHotScore() {
      hotScore_ = 0L;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    public RoomItem() {
      clear();
    }

    public RoomItem clear() {
      bitField0_ = 0;
      roomVid = null;
      hotScore_ = 0L;
      cachedSize = -1;
      return this;
    }

    @Override
    public void writeTo(com.google.protobuf.nano.CodedOutputByteBufferNano output)
        throws java.io.IOException {
      if (this.roomVid != null) {
        output.writeMessage(1, this.roomVid);
      }
      if (((bitField0_ & 0x00000001) != 0)) {
        output.writeInt64(2, hotScore_);
      }
      super.writeTo(output);
    }

    @Override
    protected int computeSerializedSize() {
      int size = super.computeSerializedSize();
      if (this.roomVid != null) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
          .computeMessageSize(1, this.roomVid);
      }
      if (((bitField0_ & 0x00000001) != 0)) {
        size += com.google.protobuf.nano.CodedOutputByteBufferNano
            .computeInt64Size(2, hotScore_);
      }
      return size;
    }

    @Override
    public RoomItem mergeFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      while (true) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            return this;
          default: {
            if (!com.google.protobuf.nano.WireFormatNano.parseUnknownField(input, tag)) {
              return this;
            }
            break;
          }
          case 10: {
            if (this.roomVid == null) {
              this.roomVid = new com.woohoo.app.common.protocol.nano.WhSvcCommon.RoomVid();
            }
            input.readMessage(this.roomVid);
            break;
          }
          case 16: {
            hotScore_ = input.readInt64();
            bitField0_ |= 0x00000001;
            break;
          }
        }
      }
    }

    public static RoomItem parseFrom(byte[] data)
        throws com.google.protobuf.nano.InvalidProtocolBufferNanoException {
      return com.google.protobuf.nano.MessageNano.mergeFrom(new RoomItem(), data);
    }

    public static RoomItem parseFrom(
            com.google.protobuf.nano.CodedInputByteBufferNano input)
        throws java.io.IOException {
      return new RoomItem().mergeFrom(input);
    }
  }
}