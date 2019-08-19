package net.urigo.plugin


import com.android.build.gradle.AppPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 *
 */
class RPCPlugin implements Plugin<Project> {
    public static final String EXT_NAME = 'protoquerpc'

    @Override
    void apply(Project project) {
        println("project(:${project.name}) apply net.protoqueue.rpc.plugin")
        def isApp = project.plugins.hasPlugin(AppPlugin)
        //project.extensions.create(EXT_NAME, UriGoConfiguration)
        if (isApp) {
        }
    }

    static void init(Project project, RegisterTransform transformImpl) {
//        UriGoConfiguration config = project.extensions.findByName(EXT_NAME) as UriGoConfiguration
//        config.project = project
//        config.convertConfig()
//        transformImpl.config = config
//        println("UriGoConfiguration init $config")
    }
}