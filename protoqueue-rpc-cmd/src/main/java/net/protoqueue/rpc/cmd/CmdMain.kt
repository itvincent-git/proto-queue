package net.protoqueue.rpc.cmd

import net.protoqueue.rpc.desc.DescFileReader
import net.protoqueue.rpc.gen.GenApi

/**
 * Created by zhongyongsheng on 2019-08-13.
 */

class CmdMain {
    private data class Args(var descPath: String, var outDir: String, var outPackageName: String)

    fun run(param: Array<String>) {


        val args = param.getArgsFromParams()
        if (args == null) {
            showUsage()
            return
        }
        //描述文件路径
        val descPath = args.descPath
        //输出文件夹路径
        val outFilePath = args.outDir
        //输出包名
        val outPackageName = args.outPackageName

        //如果开发完成，注释这些代码
//        val descPath = File("proto.desc").absolutePath
//        val outFilePath = System.getProperty("user.dir") + File.separator + "output" + File.separator
//        val outPackageName = "com.woohoo.app.common.protocol.rpc"
        //
        DescFileReader(descPath).readFile().getServiceList().forEach {
            GenApi.generateProtoFile(it, outFilePath)
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
