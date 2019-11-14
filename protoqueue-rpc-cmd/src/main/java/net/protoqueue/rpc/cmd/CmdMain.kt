package net.protoqueue.rpc.cmd

import net.protoqueue.rpc.desc.DescFileServiceReader
import net.protoqueue.rpc.desc.DescFileTypesReader
import net.protoqueue.rpc.gen.GenApi
import java.io.File

/**
 * Created by zhongyongsheng on 2019-08-13.
 */

class CmdMain {
    private data class Args(var descPath: String, var outDir: String, var outPackageName: String)

    fun run(param: Array<String>) {
        val descPath = File("./../protoqueue-test/protocols/desc/proto.desc").absolutePath
//        val outFilePath = System.getProperty("user.dir") + File.separator + "output" + File.separator
        val outFilePath = File("./../protoqueue-test/src/main/java/").absolutePath
        val outPackageName = "com.woohoo.app.common.protocol.rpc"
        doRun(descPath, outFilePath, outPackageName)
    }

    @Suppress("MemberVisibilityCanBePrivate")
    fun doRun(descPath: String, outDir: String, outPackageName: String) {
        DescFileServiceReader(descPath).readFile().getServiceList().forEach {
            GenApi.generateProtoFile(it, outDir)
        }
        DescFileTypesReader(descPath).parseFile().dataObjectFileStructs.forEach {
            GenApi.generateProtoDataObjectFile(it, outDir)
        }
    }

    private fun showUsage() {
        println("-i [proto desc file] -o [out file] -p [out package name]")
    }

    private fun Array<String>.getArgsFromParams(): Args? {
        val param = this
        if (param.size != 6) {
            return null
        }
        val args = Args("", "", "")
        for (i in 0 until param.size step 2) {
            when (param[i]) {
                "-i" -> args.descPath = param[i + 1]
                "-o" -> args.outDir = param[i + 1]
                "-p" -> args.outPackageName = param[i + 1]
            }
        }
        return args
    }
}
