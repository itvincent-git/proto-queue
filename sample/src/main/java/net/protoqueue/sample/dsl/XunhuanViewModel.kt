package net.protoqueue.sample.dsl

import kotlinx.coroutines.launch
import net.protoqueue.rpc.rpcRegister
import net.protoqueue.sample.proto.nano.TestProtos
import net.slog.SLoggerFactory
import net.stripe.lib.ObservableViewModel
import net.stripe.lib.viewModelScope

/**
 * 寻欢测试的ViewModel
 * Created by zhongyongsheng on 2020/6/8.
 */
class XunhuanViewModel : ObservableViewModel() {
    val log = SLoggerFactory.getLogger("XunhuanViewModel")

    init {
        rpcRegister {
            RPCProtoQueue.instance.globalBroadcast().onResponse { pGlobalBroadcast, responseParameter ->
                log.info("globalBroadcast response code:${responseParameter.resultCode} msg:${responseParameter
                    .resultMsg}")
                log.info("globalBroadcast onResponse:$pGlobalBroadcast")
            }
        }
    }

    fun sendRequest() {
        viewModelScope.launch {
            val request = TestProtos.PUserRequest().apply {
                uid = 10001
            }
            log.info("user request:$request")
            val response = RPCProtoQueue.instance.user().request(request)
            log.info("user response code:${response.parameter.resultCode} msg:${response.parameter
                .resultMsg} body:${response.body} ")
            if (response.parameter.isSuccess) {
                log.info("user response success")
            }
        }
    }
}