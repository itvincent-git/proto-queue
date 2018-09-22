package net.protoqueue

import kotlinx.coroutines.experimental.Deferred

/**
 * 包含了Deferred的ProtoDisposable
 * Created by zhongyongsheng on 2018/9/22.
 */
class DeferredProtoDisposable<T> (val responseDeferred: Deferred<T>/*请求结果的Deferred对象*/
    ): ProtoDisposable {
    override fun dispose() {
        responseDeferred.cancel()
    }

    override fun isDisposed(): Boolean {
        return responseDeferred.isCancelled
    }

}