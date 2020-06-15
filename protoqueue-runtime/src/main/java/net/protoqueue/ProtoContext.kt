//package net.protoqueue
//
///**
// * proto上下文
// * Created by zhongyongsheng on 2018/4/21.
// */
//class ProtoContext<P, C>(
//    val data: ByteArray?,
//    val receiver: (P) -> Unit,
//    val receiveUri: Int,
//    val parameter: QueueParameter<P, C>?,
//    val protoQueue: ProtoQueue<P, C>
//) {
//    val protoDisposable: ProtoDisposable = ProtoQueue.ProtoDisposableImpl()
//}
