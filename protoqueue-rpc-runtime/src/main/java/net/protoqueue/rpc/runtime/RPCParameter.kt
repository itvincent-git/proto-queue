package net.protoqueue.rpc.runtime

/**
 * 扩展参数
 *
 * Created by zhongyongsheng on 2019-08-28.
 */
inline class RPCParameter(val values: MutableMap<String, Any> = mutableMapOf())

/**
 * 合并map
 */
fun RPCParameter.mergeListPair(listPairs: Array<out Pair<String, Any>>) = apply {
    for (item in listPairs) {
        values[item.first] = item.second
    }
}

/**
 * 合并key, value
 */
fun RPCParameter?.mergePairs(vararg pairs: Pair<String, String>) =
        this?.mergeListPair(pairs) ?: RPCParameter().mergeListPair(pairs)
