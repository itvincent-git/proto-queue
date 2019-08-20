package net.protoqueue.rpc.gen

import net.jbridge.compiler.writer.ProtoRPCWriter
import net.protoqueue.rpc.gen.struct.ServiceStruct
import java.io.File

/**
 * 生成rpc api入口
 * Created by zhongyongsheng on 2019-08-13.
 */
object GenApi {

    /**
     * 生成rpc接口文件
     */
    fun generateProtoFile(serviceStruct: ServiceStruct, outputDirPath: String) {
        println("generateProtoFile $serviceStruct")

        val outputDirFile = File(outputDirPath)
        println("proto file output dir:$outputDirFile")
        ProtoRPCWriter(serviceStruct, outputDirFile).write()
    }

    fun generateProtoDataObjectFile() {
    }
}