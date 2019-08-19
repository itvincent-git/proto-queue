package net.protoqueue.rpc.plugin

import net.protoqueue.rpc.cmd.CmdMain
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.JavaExec

/**
 *
 */
class RPCPlugin implements Plugin<Project> {
    public static final String EXT_NAME = 'genProtocols'

    static class RPCExtension {
        String inputDesc;
        String outDir;
        String outPackage;
    }

    @Override
    void apply(Project project) {
        def extension = project.extensions.create('protoqueueRpc', RPCExtension)
        project.task(EXT_NAME, group: "exshell", description: "生成PB协议相关", type: JavaExec) << {
            def inputFile = extension.inputDesc
            def outDir = extension.outDir
            def outPackage = extension.outPackage
            new CmdMain().doRun(inputFile, outDir, outPackage)
        }
    }
}