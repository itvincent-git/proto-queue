package net.protoqueue

import java.util.concurrent.atomic.AtomicBoolean

/**
 * proto上下文
 * Created by zhongyongsheng on 2018/4/21.
 */
class ProtoContext<P, C>(internal var data: ByteArray?,
                         internal var receiver: (P) -> Unit,
                         internal var appId: Int,
                         internal var context: C?,
                         internal var receiveUri: Int,
                         internal var topSid: Long,
                         internal var subSid: Long,
                         internal var parameter: QueueParameter<P, C>?) {
    internal var protoDisposable: ProtoDisposable = ProtoDisposableImpl()

    internal inner class ProtoDisposableImpl : ProtoDisposable {
        var isDisposed = AtomicBoolean(false)

        override fun dispose() {
            isDisposed.set(true)
        }

        override fun isDisposed(): Boolean {
            return isDisposed.get()
        }
    }
}
