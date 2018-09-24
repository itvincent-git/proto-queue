package net.protoqueue

import kotlinx.coroutines.experimental.*

/**
 * 使用这个方法来执行protoqueue任务，由于protoqueue请求并不会阻塞，只会异步等待服务器返回数据，因此专门指定了context=Dispatchers.Default
 * Created by zhongyongsheng on 2018/9/24.
 */
fun <T> protoQueueAsync(start: CoroutineStart = CoroutineStart.DEFAULT,
                    onCompletion: CompletionHandler? = null,
                    block: suspend CoroutineScope.() -> T
) = GlobalScope.async(Dispatchers.Default, start, onCompletion, block)