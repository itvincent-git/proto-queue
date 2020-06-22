package net.protoqueue.compiler.writer

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.TypeSpec
import java.io.IOException
import javax.annotation.processing.ProcessingEnvironment

/**
 * 生成kt文件基类
 * Created by zhongyongsheng on 2020/4/14.
 */
abstract class BaseWriter(private val className: ClassName) {

    @Throws(IOException::class)
    fun write(processingEnvironment: ProcessingEnvironment) {
        val typeSpecBuilder = createTypeSpecBuilder()
        FileSpec.builder(className.packageName, className.simpleName)
            .addComment("Generate by protoqueue-xh, don't edit this file please")
            .addType(typeSpecBuilder.build())
            .indent("    ")
            .build()
            .writeTo(processingEnvironment.filer)
    }

    protected abstract fun createTypeSpecBuilder(): TypeSpec.Builder
}
