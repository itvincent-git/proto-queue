package net.protoqueue.compiler.writer

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import java.io.File
import java.io.IOException
import javax.annotation.processing.ProcessingEnvironment

/**
 * 生成kt文件基类
 * Created by zhongyongsheng on 2018/4/14.
 */
abstract class BaseWriter(private val className: ClassName) {

    init {
    }

    @Throws(IOException::class)
    fun write(processingEnvironment: ProcessingEnvironment) {
        val typeSpecBuilder = createTypeSpecBuilder()
        FileSpec.builder(className.packageName, className.simpleName)
            .addComment("Generate by protoqueue-xh, don't edit this file please")
//            .addProperty(createFileProperty().build())
            .addType(typeSpecBuilder.build())
            .indent("    ")
            .build()
            .writeTo(processingEnvironment.filer)
    }

    protected abstract fun createTypeSpecBuilder(): TypeSpec.Builder

//    protected abstract fun createFileProperty(): PropertySpec.Builder
}
