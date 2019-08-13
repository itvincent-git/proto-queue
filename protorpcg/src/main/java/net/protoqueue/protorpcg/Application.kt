package net.protoqueue.protorpcg

/**
 *
 *
 *
 * @author linmin1 on 2019-08-12.
 *
 */
private const val usage = "-p proto3 executable file path\n-d proto files dir\n-o out path file"

class Application {
    fun run(args: Array<String>?) {
        println(args?.contentToString())
        if (args == null || args.isEmpty()) {
            showUsage()
            return
        }
    }

    private fun showUsage() {
        println(usage)
    }
}