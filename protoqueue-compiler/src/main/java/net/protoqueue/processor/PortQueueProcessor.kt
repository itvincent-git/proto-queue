package net.protoqueue.processor

import com.google.auto.common.BasicAnnotationProcessor
import com.google.common.collect.SetMultimap
import net.protoqueue.compiler.common.CompilerContext
import net.protoqueue.util.Util
import net.protoqueue.annotation.ProtoQueueClass
import net.protoqueue.compiler.writer.ProtoQueueBaseWriter
import net.protoqueue.compiler.writer.ProtoQueueClassWriter
import java.util.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.Element

/**
 * Processor 入口类
 * Created by zhongyongsheng on 2018/4/13.
 */
class PortQueueProcessor : BasicAnnotationProcessor() {
    internal var portContext: CompilerContext? = null
    override fun initSteps(): Iterable<BasicAnnotationProcessor.ProcessingStep> {
        portContext = CompilerContext(processingEnv)
        CompilerContext.defaultIntance = portContext
        return Arrays.asList(ProtoQueueProcessingStep(portContext!!))
    }

    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latest()
    }

    internal inner class ProtoQueueProcessingStep(context: CompilerContext) : ProtoQueueProcessing() {

        init {
            compilerContext = context
        }

        override fun annotations(): Set<Class<out Annotation>> {
            val set = HashSet<Class<out Annotation>>()
            set.add(ProtoQueueClass::class.java)
            return set
        }

        override fun process(elementsByAnnotation: SetMultimap<Class<out Annotation>, Element>): Set<Element> {
            val classSet = elementsByAnnotation.get(ProtoQueueClass::class.java)
            classSet.map { element ->
                ProtoQueueClassProcessor(compilerContext!!, Util.toTypeElement(element)).process()
            }
            .forEach {
                try {
                    ProtoQueueClassWriter(it).write(processingEnv)
                } catch (e: Throwable) {
                    portContext!!.log.error("ProtoQueueClassWriter error %s", e.message ?: "")
                }
            }

            return HashSet()
        }
    }

    internal abstract inner class ProtoQueueProcessing : BasicAnnotationProcessor.ProcessingStep {
        var compilerContext: CompilerContext? = null
    }
}
