package net.protoqueue.rpc.gen

/**
 *
 *
 *
 * @author linmin1 on 2019-08-14.
 *
 */
data class FunctionStruct(
    val funName: String, val reqType: String, val rspType: String, val reqTypeClass: TypeClass?,
    val rspTypeClass: TypeClass?
) {
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

data class TypeClass(val packageName: String, val simpleName: String, val properties: List<PropertyClass>)

data class PropertyClass(val propertyName: String, val propertyType: String, val propertyTypeClass: TypeClass)
