package net.protoqueue.rpc.gen.struct

/**
 * 一个rpc接口结构
 * @author linmin1 on 2019-08-14.
 */
data class FunctionStruct(
    /*rpc方法名*/val funName: String,
    /*rpc方法发送message类型*/val reqType: String,
    /*rpc方法返回message类型*/val rspType: String,
              val reqTypeClass: TypeClass? = null,
              val rspTypeClass: TypeClass? = null
) {
    val reqTypePackage: String = reqType.substringBeforeLast(".")
    val reqTypeSimpleName: String = reqType.substringAfterLast(".")
    val rspTypePackage: String = rspType.substringBeforeLast(".")
    val rspTypeSimpleName: String = rspType.substringAfterLast(".")
}

data class TypeClass(
    val packageName: String, val simpleName: String, val nullable: Boolean, val properties:
    List<PropertyClass>
)

data class PropertyClass(val propertyName: String, val propertyType: String, val propertyTypeClass: TypeClass)
