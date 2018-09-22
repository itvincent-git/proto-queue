package net.protoqueue

import kotlinx.coroutines.experimental.Deferred

/**
 * 包含了Deferred的ProtoDisposable
 * Created by zhongyongsheng on 2018/9/22.
 */
class DeferredProtoDisposable<T> (val deferred: Deferred<T>): ProtoDisposable {
    override fun dispose() {
        deferred.cancel()
    }

    override fun isDisposed(): Boolean {
        return deferred.isCancelled
    }

}