package net.protoqueue

import android.arch.lifecycle.Lifecycle
import net.stripe.lib.ICloseableObserver

/**
 * 可取消协议回包
 * Created by zhongyongsheng on 2018/4/20.
 */
interface ProtoDisposable {
    /**
     * 取消接收回包
     */
    fun dispose()

    /**
     * 是否已取消接收
     * @return
     */
    fun isDisposed(): Boolean

    /**
     * 已经接收回包，或超时调用
     */
    fun finish()

    /**
     * 注册到Lifecycle生命周期，在lifecycle.onDestory的时候dispose
     */
    fun registerLifecycle(lifecycle: Lifecycle)

    /**
     * 注册到[ICloseableObserver]，在生命周期结束的时候dispose
     */
    fun registerCloseableObserver(observer: ICloseableObserver)
}