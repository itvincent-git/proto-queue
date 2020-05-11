package net.protoqueue

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * 使用这个方法来执行protoqueue任务，由于protoqueue请求并不会阻塞，只会异步等待服务器返回数据，因此专门指定了context=Dispatchers.Default
 * Created by zhongyongsheng on 2018/9/24.
 */

internal val dispatcher = Dispatchers.Default//newSingleThreadContext("ProtoQueueDispatcher")

/**
 * 运行协议协程
 */
fun protoQueueLaunch(
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
) = GlobalScope.launch(dispatcher, start, block)

/**
 * 运行协程协程并有返回值
 */
fun <T> protoQueueAsync(
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> T
) = GlobalScope.async(dispatcher, start, block)


/**
 * 使用协程的方式发送协议，调用后会抛异常：<br/>
 * <li>如调用job.cancel()会抛 JobCancellationException</li>
 * <li>超时会抛 ProtoTimeoutError</li>
 */
suspend fun <P, C, T : ProtoQueue<P, C>> T.enqueueAwait(
    proto: P,
    receiveUri: Int,
    timeout: Int = QueueParameter.DEFAULT_TIMEOUT
): P {

    return suspendCancellableCoroutine { continuation ->
        val disposable = QueueParameter(this, proto, receiveUri) { continuation.resume(it) }
            .error { continuation.resumeWithException(it) }
            .timeout(timeout)
            .enqueue()
        continuation.invokeOnCancellation {
            if (!disposable.isDisposed) disposable.dispose()
        }
    }
}

/**
 * 使用协程的方式发送协议，如果有异常则返回null
 */
suspend fun <P, C, T : ProtoQueue<P, C>> T.enqueueAwaitOrNull(
    proto: P,
    receiveUri: Int,
    timeout: Int = QueueParameter.DEFAULT_TIMEOUT
): P? {
    return try {
        enqueueAwait(proto, receiveUri, timeout)
    } catch (t: Throwable) {
        return null
    }
}