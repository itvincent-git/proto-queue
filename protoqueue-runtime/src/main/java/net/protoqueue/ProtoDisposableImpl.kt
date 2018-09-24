package net.protoqueue

import java.util.concurrent.atomic.AtomicBoolean

/**
 * 取消回包的实现
 * Created by zhongyongsheng on 2018/9/24.
 */
internal class ProtoDisposableImpl : ProtoDisposable {
    var isDisposed = AtomicBoolean(false)

    override fun dispose() {
        isDisposed.set(true)
    }

    override fun isDisposed(): Boolean {
        return isDisposed.get()
    }
}