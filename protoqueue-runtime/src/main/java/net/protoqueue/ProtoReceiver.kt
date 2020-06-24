package net.protoqueue

/**
 * proto协议回包
 * Created by zhongyongsheng on 2018/4/20.
 */
interface ProtoReceiver<T> {
    fun onProto(proto: T)

    companion object {
        //兼容旧的写法
        operator fun <T> invoke(block: (T) -> Unit) = block
    }
}