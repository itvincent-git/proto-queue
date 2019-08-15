package net.protoqueue.rpc.gen

/**
 *
 *
 *
 * @author linmin1 on 2019-08-14.
 *
 */
data class FunctionStruct(val funName: String, val reqType: String, val rspType: String) {
    val reqTypePackage: String
    val reqTypeSimpleName: String
    val rspTypePackage: String
    val rspTypeSimpleName: String

    init {
        reqTypePackage = reqType.substringBeforeLast(".")
        reqTypeSimpleName = reqType.substringAfterLast(".")
        rspTypePackage = rspType.substringBeforeLast(".")
        rspTypeSimpleName = rspType.substringAfterLast(".")
    }
}