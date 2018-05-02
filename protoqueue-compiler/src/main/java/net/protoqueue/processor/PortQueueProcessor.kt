package net.protoqueue.processor

import com.google.auto.common.BasicAnnotationProcessor
import com.google.common.collect.SetMultimap
import net.protoqueue.compiler.common.CompilerContext
import net.protoqueue.util.Util
import net.protoqueue.annotation.ProtoQueueClass
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
            //compilerContext!!.log.debug("ProtoQueueProcessingStep process %s", classSet)
            classSet.map { element ->
                //compilerContext!!.log.debug("ProtoQueueProcessingStep2 process %s", element)
                ProtoQueueClassProcessor(compilerContext!!, Util.toTypeElement(element)).process();
            }.forEach({compilerContext!!.log.debug("ProtoQueueProcessingStep process %s", it)})
            //compilerContext!!.log.debug("ProtoQueueProcessingStep process end")

            //            portTransformerDataStream.forEach(portTransformerData -> {
            //                try {
            //                    new PortTransformerWriter(portTransformerData).write(processingEnv);
            //                } catch (IOException e) {
            //                    portContext.log.error("PortTransformerWriter error", e.getMessage());
            //                }
            //            });

            return HashSet()
        }
    }

    internal abstract inner class ProtoQueueProcessing : BasicAnnotationProcessor.ProcessingStep {
        var compilerContext: CompilerContext? = null
    }
}
