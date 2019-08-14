package net.protoqueue.rpc.cmd

import net.protoqueue.rpc.desc.DescFileReader
import java.io.File

/**
 * Created by zhongyongsheng on 2019-08-13.
 */

class CmdMain {
    fun run(args: Array<String>) {
//        if (args.isEmpty()) {
//            showUsage()
//        }
        val descPath = File("proto.desc").absolutePath
        val outFilePath = ""
        DescFileReader(descPath).readFile().getServiceList().forEach {
            println(it)
        }
    }

    private fun showUsage() {
        println("-i [proto desc file] -o [out file]")
    }
}
