package net.jbridge.compiler.writer

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import java.io.File
import java.io.IOException

/**
 * 生成kt文件基类
 * Created by zhongyongsheng on 2018/4/14.
 */
abstract class BaseWriter(
    private val className: ClassName,
    private val outputDir: File
) {

    init {
    }

    @Throws(IOException::class)
    fun write() {
        val typeSpecBuilder = createTypeSpecBuilder()
        FileSpec.builder(className.packageName, className.simpleName)
            .addComment("Generate by protoqueue-rpc, don't edit this file please")
            .addProperty(createFileProperty().build())
            .addType(typeSpecBuilder.build())
            .indent("    ")
            .build()
            .writeTo(outputDir)
    }

    protected abstract fun createTypeSpecBuilder(): TypeSpec.Builder

    protected abstract fun createFileProperty(): PropertySpec.Builder
}
