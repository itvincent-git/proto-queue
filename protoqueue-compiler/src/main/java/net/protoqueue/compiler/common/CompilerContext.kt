package net.protoqueue.compiler.common

import javax.annotation.processing.ProcessingEnvironment

/**
 * 保存编译的上下文信息
 * Created by zhongyongsheng on 2018/4/13.
 */
object CompilerContext {
    lateinit var log: Log
    lateinit var processingEnvironment: ProcessingEnvironment

    fun init(processingEnvironment: ProcessingEnvironment) {
        this.processingEnvironment = processingEnvironment
        this.log = Log(processingEnvironment.messager)
    }
}
