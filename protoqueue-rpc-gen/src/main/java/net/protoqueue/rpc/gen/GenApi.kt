package net.protoqueue.rpc.gen

import net.jbridge.compiler.writer.ProtoRPCWriter
import java.io.File

/**
 * Created by zhongyongsheng on 2019-08-13.
 */
object GenApi {
    fun generateProtoFile(serviceStruct: ServiceStruct, outputDirPath: String) {
        println("generateProtoFile $serviceStruct")

        val outputDirFile = File(outputDirPath)
        println("proto file output dir:$outputDirFile")
        ProtoRPCWriter(serviceStruct, outputDirFile).write()
    }
}