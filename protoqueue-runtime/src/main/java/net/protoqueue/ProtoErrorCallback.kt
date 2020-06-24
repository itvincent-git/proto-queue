package net.protoqueue

/**
 * 错误回调
 * Created by zhongyongsheng on 2018/5/6.
 */
interface ProtoErrorCallback {
    fun onError(error: ProtoError?)
}