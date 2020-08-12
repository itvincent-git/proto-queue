package net.protoqueue.rpc

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import net.protoqueue.ProtoDisposable
import net.stripe.lib.ICloseableObserver

/**
 * RPC参数
 * Created by zhongyongsheng on 2020/4/22.
 */

/**
 * 请求参数
 */
class RequestParameter @JvmOverloads constructor(
    var timeout: Int = 10000,
    var lifecycleOwner: LifecycleOwner? = null,
    var lifecycle: Lifecycle? = null,
    var closeableObserver: ICloseableObserver? = null
)

/**
 * 将RequestParameter的[lifecycle]/[observableViewModel]注册到生命周期管理中，在生命周期结束时，会自动dispose任务
 */
fun ProtoDisposable.registerRequestParameter(requestParameter: RequestParameter?) {
    if (!isDisposed() && requestParameter != null) {
        requestParameter.lifecycleOwner?.let {
            registerLifecycle(it.lifecycle)
        }
        requestParameter.lifecycle?.let {
            registerLifecycle(it)
        }
        requestParameter.closeableObserver?.let {
            registerCloseableObserver(it)
        }
    }
}

/**
 * 返回参数
 */
class ResponseParameter(val payload: Any?)