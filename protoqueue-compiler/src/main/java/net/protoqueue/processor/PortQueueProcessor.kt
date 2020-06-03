package net.protoqueue.processor

import com.google.auto.common.BasicAnnotationProcessor
import com.google.common.collect.SetMultimap
import net.protoqueue.annotation.ProtoQueueClass
import net.protoqueue.compiler.common.CompilerContext
import net.protoqueue.compiler.writer.ProtoQueueRPCWriter
import net.protoqueue.util.toTypeElement
import java.util.HashSet
import javax.lang.model.SourceVersion
import javax.lang.model.element.Element

/**
 * Processor 入口类
 * Created by zhongyongsheng on 2018/4/13.
 */
class PortQueueProcessor : BasicAnnotationProcessor() {
    override fun initSteps(): Iterable<BasicAnnotationProcessor.ProcessingStep> {
        CompilerContext.init(processingEnv)
        return listOf(ProtoQueueProcessingStep())
    }

    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latest()
    }

    internal inner class ProtoQueueProcessingStep() : ProcessingStep {

        override fun annotations(): Set<Class<out Annotation>> {
            val set = HashSet<Class<out Annotation>>()
            set.add(ProtoQueueClass::class.java)
            return set
        }

        override fun process(elementsByAnnotation: SetMultimap<Class<out Annotation>, Element>): Set<Element> {
            val classSet = elementsByAnnotation.get(ProtoQueueClass::class.java)
            classSet.map { element ->
                ProtoQueueClassProcessor(element.toTypeElement()).process()
            }
                .forEach {
                    try {
                        ProtoQueueRPCWriter(it).write(processingEnv)
                    } catch (e: Throwable) {
                        CompilerContext.log.error("ProtoQueueClassWriter error %s", e.message ?: "")
                    }
                }

            return emptySet()
        }
    }
}
