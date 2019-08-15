package net.protoqueue.rpc.cmd

import net.protoqueue.rpc.desc.DescFileReader
import net.protoqueue.rpc.gen.GenApi
import java.io.File

/**
 * Created by zhongyongsheng on 2019-08-13.
 */

class CmdMain {
    fun run(args: Array<String>) {
//        if (args.isEmpty()) {
//            showUsage()
//            return
//        }
        val descPath = File("proto.desc").absolutePath
        val outFilePath = System.getProperty("user.dir") + File.separator + "output" + File.separator
        DescFileReader(descPath).readFile().getServiceList().forEach {
            GenApi.generateProtoFile(it, outFilePath)
        }
    }

    private fun showUsage() {
        println("-i [proto desc file] -o [out file]")
    }
}
