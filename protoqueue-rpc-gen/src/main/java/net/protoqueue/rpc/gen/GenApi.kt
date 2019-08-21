package net.protoqueue.rpc.gen

import net.jbridge.compiler.writer.ProtoDataObjectWriter
import net.jbridge.compiler.writer.ProtoRPCWriter
import net.protoqueue.rpc.gen.struct.DataObjectFileStruct
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

    /**
     * 生成PB Message的转换类
     */
    fun generateProtoDataObjectFile(dataObjectFileStruct: DataObjectFileStruct, outputDirPath: String) {
        println("generateProtoDataObjectFile $dataObjectFileStruct")

        val outputDirFile = File(outputDirPath)
        println("proto data object file output dir:$outputDirFile")
        ProtoDataObjectWriter(dataObjectFileStruct, outputDirFile).write()
    }
}