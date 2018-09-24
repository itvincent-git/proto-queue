package net.protoqueue

import kotlinx.coroutines.experimental.CompletableDeferred

/**
 * proto上下文
 * Created by zhongyongsheng on 2018/4/21.
 */
class ProtoContext<P, C>(internal val data: ByteArray?,
                         internal val receiver: (P) -> Unit,
                         internal val appId: Int,
                         internal val context: C?,
                         internal val receiveUri: Int,
                         internal val topSid: Long,
                         internal val subSid: Long,
                         internal val parameter: QueueParameter<P, C>?,
                         internal val deferred: CompletableDeferred<P>?) {
    internal val protoDisposable: ProtoDisposable = ProtoDisposableImpl()
}
