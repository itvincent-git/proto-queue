## Protoqueue-RPC 特点

### 一键生成

1. 命令行
2. Gradle Plugin



### 只需要编写一个.pb文件

无论是修改.pb文件里的message类，还是修改service，都只需要一键就可以重新生成，与使用官方protoc般便捷。



### 与业务解耦

跟具体业务无依赖，通过adapter适配不一样的service或sdk，通过extension函数实现了灵活的参数扩展



### 原理

由于使用了protobuf service关键字，可定义rpc方法，旧有流程上对协议关系的描述就可以顺理成章了。基于service上的描述，我们就能自动生成function，无需再编写了。



### 示例

- pb文件中定义的rpc：

```
message GetUserInfoReq {
    repeated int64 uidList = 1;
}
message GetUserInfoRes {
    common.ResponseHeader header = 1;
    repeated UserInfo userInfoList = 2; 
}
service SvcUserService {
    // 批量获取用户基本信息
    rpc batchGetUserInfo (GetUserInfoReq) returns (GetUserInfoRes);
}    
```

#### 一键生成代码：

- RPC Function


```kotlin
class SvcUserService {
    object Client {
      suspend fun batchGetUserInfo(req: GetUserInfoReqKt, parameter: RPCParameter? = null): RPCResponse<GetUserInfoResKt> {
           ...
      }
    }
}
```

- 请求的协议体`GetUserInfoReqKt`:

```kotlin
class GetUserInfoReqKt(
  var uidList: MutableList<Long> = mutableListOf()
  ...
)
```

- 响应的协议休`GetUserInfoResKt`:

```kotlin
class GetUserInfoResKt(
  var header: ResponseHeaderKt? = null,
  var userInfoList: MutableList<UserInfoKt> = mutableListOf()
  ...
) 
```



#### 业务逻辑调用RPC的调用方法:

```kotlin
val res = SvcUserService.Client.batchGetUserInfo(proto)
res.handlerSuccessFailure(res.body?.header, {//这是extension，按照业务自己进行扩展
  log.info("result is $this")
}, {
  log.error(it.error?.message ?: "Server error")
})
```



> function batchGetUserInfo 内部实现了协程调用的实现逻辑，及请求响应协议体kt类转java类的逻辑。



#### 处理通知广播协议：

```kotlin
// 增加业务服务器封禁协议
SvcUserNotifyService.Handler.userFreezeNotify { notify, _ ->
  log.info("[onCreate] server freeze")
  notify.freezeInfo?.let { onBusinessFreeze(it) }
  null
}
```



## 设计

### 按照RPC的理念进行设计

所有RPC方法均生成`Client`方法及`Handler`方法。

`Client`代表向对方请求等待回复

`Handler`代表等待接收对方的请求并回复

**无论生成的是客户端使用还是服务器端下使用，都是可互换并对等的。**



#### 客户端

例如应用到我们客户端的场景下，`Client`代表发送业务请求并等待回复，`Handler`则代表接收服务器的单播/广播无须回复。



#### 服务器端

相对服务器的场景下，`Client`代表发送单播/广播，`Handler`则代表接收客户端的请求并回复。



### 接口设计

#### Service接口协程化

Service方法按suspend协程方式来设计的，有如下特点：

- 可使Service调用过程的连续性

- 避免了在UI线程的占用
- 需要请求多条协议时，组装数据变得容易



```kotlin
viewModelScope.launch {
  val req = WhSvcUserKt.GetUserInfoReqKt(uids)
  val res = SvcUserService.Client.batchGetUserInfo(req)
  res.handlerSuccess(res.body?.header) {
    userInfoLiveData.setOrPostValue(this)
    //在回调里再作请求
    val reqOnline = WhSvcUserOnlineKt.BatchGetUserOnlineStatusReqKt(uid)
    val res = SvcUserOnlineService.Client.batchGetUserOnlineStatus(reqOnline)
    //再拼装2个协议返回的数据
    ...
  }
}
```



#### 适配器

解决使用不同service sdk时的适配，也解除子RPC框架对sdk的依赖

```kotlin
interface RPCAdapter {

    /**
     * 实现发送数据
     *
     * @param serviceName service名
     * @param functionName service方法名
     * @param bytes 发送的数据
     * @param successCallback 成功回调
     * @param errorCallback 失败回调
     * @param parameter 透传的参数
     */
    fun send(
        serviceName: String,
        functionName: String,
        bytes: ByteArray,
        successCallback: RPCResponseCallback,
        errorCallback: RPCErrorCallback? = null,
        parameter: RPCParameter? = null
    )

    /**
     * 实现监听接收数据
     */
    fun subscribe(serviceName: String, functionName: String, receiver: RPCNotifyReceiver)

    /**
     * 实现取消监听接收数据
     */
    fun unsubscribe(serviceName: String, functionName: String, receiver: RPCNotifyReceiver)
}
```



#### 参数可扩展

广播下发的数据可以通过`RPCParameter`

```kotlin
/**
 * 通知接通器
 */
typealias RPCNotifyReceiver = (
    serviceName: String,
    functionName: String,
    data: ByteArray,
    parameter: RPCParameter?
) -> Unit
```



