package net.protoqueue.compiler.writer

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.TypeSpec

import java.io.IOException

import javax.annotation.processing.ProcessingEnvironment

/**
 * Created by zhongyongsheng on 2018/4/14.
 */
abstract class ProtoQueueBaseWriter(internal var className: ClassName) {

    @Throws(IOException::class)
    fun write(processingEnvironment: ProcessingEnvironment) {
        val typeSpecBuilder = createTypeSpecBuilder()
        JavaFile.builder(className.packageName(),
                typeSpecBuilder.build())
                .build()
                .writeTo(processingEnvironment.filer)
    }

    protected abstract fun createTypeSpecBuilder(): TypeSpec.Builder
}
