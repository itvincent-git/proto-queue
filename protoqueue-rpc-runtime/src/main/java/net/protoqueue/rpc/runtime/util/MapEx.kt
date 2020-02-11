package net.protoqueue.rpc.runtime.util

/**
 * Map的扩展
 * Created by zhongyongsheng on 2019-08-22.
 */
/**
 * 转换Map<A, B>为一个新的Map<B, C>
 */
fun <K, V, K1, V1> Map<K, V>.convertMap(
    transformKey: (Map.Entry<K, V>) -> K1,
    transformValue: (Map.Entry<K, V>) -> V1
): HashMap<K1, V1> {
    return convertMapTo(HashMap(size), transformKey, transformValue)
}

/**
 * 将Map<A, B>转换为destination
 */
fun <K, V, K1, V1, M : MutableMap<in K1, in V1>> Map<K, V>.convertMapTo(
    destination: M,
    transformKey: (Map.Entry<K, V>) -> K1,
    transformValue: (Map.Entry<K, V>) -> V1
): M {
    return entries.associateByTo(destination, transformKey, transformValue)
}

/**
 * 循环，加上index序号
 */
inline fun <K, V> Map<out K, V>.forEachIndex(action: (Map.Entry<K, V>, Int) -> Unit): Unit {
    var index = 0
    for (element in this)
        action(element, index++)
}