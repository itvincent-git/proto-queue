package net.protoqueue.rpc

import net.protoqueue.ProtoQueue

/**
 * 回包的回调注册器
 * Created by zhongyongsheng on 2020/5/11.
 */
class ResponseRegister<PROTO, C>(private val protoqueue: ProtoQueue<PROTO, C>) {
    private val registerMap = mutableMapOf<Int, MutableList<(PROTO) -> Unit>>()

    fun addRegister(uri: Int, block: (PROTO) -> Unit) {
        registerMap[uri]?.let {
            it.add(block)
        } ?: kotlin.run {
            registerMap.put(uri, mutableListOf(block))
        }
    }

    fun onReceive(value: PROTO) {
        val uri = protoqueue.getReceiveUri(value)
        val registerList = registerMap[uri]
        if (registerList != null) {
            for (register in registerList) {
                register(value)
            }
        }
    }
}