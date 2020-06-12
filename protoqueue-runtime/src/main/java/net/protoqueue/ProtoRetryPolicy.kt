package net.protoqueue

/**
 * 重试策略
 * Created by zhongyongsheng on 2018/4/21.
 */
interface ProtoRetryPolicy {
    var currentTimeout: Int
    var currentRetryCount: Int

    @Throws(ProtoException::class)
    fun retry(exception: ProtoException)
}

/**
 * 默认重试策略
 */
class DefaultRetryPolicy(
    initialTimeoutMs: Int = 10000, val maxNumRetries: Int = 2, val backoffMultiplier: Float = 0.3f
) : ProtoRetryPolicy {
    override var currentTimeout = initialTimeoutMs
    override var currentRetryCount = 0

    override fun retry(exception: ProtoException) {
        currentRetryCount++
        currentTimeout += (currentTimeout * backoffMultiplier).toInt()
        if (!hasAttemptRemaining()) {
            throw exception
        }
    }

    protected fun hasAttemptRemaining(): Boolean {
        return currentRetryCount <= maxNumRetries
    }
}