package net.protoqueue

import android.arch.lifecycle.Lifecycle
import net.stripe.lib.ObservableViewModel

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
     * 注册到Lifecycle生命周期，在lifecycle.onDestory的时候dispose
     */
    fun registerLifecycle(lifecycle: Lifecycle)

    /**
     * 注册到[ObservableViewModel]，在[ObservableViewModel.onCleared]的时候dispose
     */
    fun registerObservableViewModel(viewModel: ObservableViewModel)
}