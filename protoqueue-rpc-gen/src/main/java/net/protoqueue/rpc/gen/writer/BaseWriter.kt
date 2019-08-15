package net.jbridge.compiler.writer

import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.TypeSpec
import net.protoqueue.rpc.gen.ServiceStruct
import java.io.File
import java.io.IOException

/**
 * 生成kt文件基类
 * Created by zhongyongsheng on 2018/4/14.
 */
abstract class BaseWriter(
    serviceStruct: ServiceStruct,
    private val outputDir: File
) {
    private val className = serviceStruct.serviceClassName

    init {
    }

    @Throws(IOException::class)
    fun write() {
        val typeSpecBuilder = createTypeSpecBuilder()
        FileSpec.builder(className.packageName, className.simpleName)
            .addComment("Generate by protoqueue-rpc, don't edit this file please")
            .addType(typeSpecBuilder.build())
            .build()
            .writeTo(outputDir)
    }

    protected abstract fun createTypeSpecBuilder(): TypeSpec.Builder
}
