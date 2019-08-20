package net.protoqueue.rpc.gen.struct

/**
 * PB Message的转换类
 * Created by zhongyongsheng on 2019-08-20.
 */
data class DataObjectFileStruct(/*放置转换类的文件包名*/val filePackage: String,
    /*放置转换类的文件名*/val fileName: String
) {
    val objects = listOf<DataObjectStruct>()
}

data class DataObjectStruct(val messageType: String) {
    val fields = listOf<DataFieldStruct>()
}

data class DataFieldStruct(val fieldName: String, val fieldTypeClass: Class<*>?, val fieldType: String?)