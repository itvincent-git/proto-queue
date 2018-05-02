package net.port.transformer.processor;

import com.google.auto.common.BasicAnnotationProcessor;
import com.google.auto.service.AutoService;
import com.google.common.collect.SetMultimap;

import net.port.transformer.compiler.common.CompilerContext;
import net.port.transformer.compiler.data.ProtoQueueClassData;
import net.port.transformer.util.Util;
import net.protoqueue.annotation.ProtoQueueClass;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import javax.annotation.processing.Processor;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;

/**
 * Processor 入口类
 * Created by zhongyongsheng on 2018/4/13.
 */
@AutoService(Processor.class)
public class PortQueueProcessor extends BasicAnnotationProcessor {
    CompilerContext portContext;
    @Override
    protected Iterable<? extends ProcessingStep> initSteps() {
        portContext = new CompilerContext(processingEnv);
        CompilerContext.defaultIntance = portContext;
        return Arrays.asList(new ProtoQueueProcessingStep(portContext));
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }

    class ProtoQueueProcessingStep extends ProtoQueueProcessing {

        ProtoQueueProcessingStep(CompilerContext context) {
            compilerContext = context;
        }

        @Override
        public Set<? extends Class<? extends Annotation>> annotations() {
            Set<Class<? extends Annotation>> set = new HashSet<>();
            set.add(ProtoQueueClass.class);
            return set;
        }

        @Override
        public Set<? extends Element> process(SetMultimap<Class<? extends Annotation>, Element> elementsByAnnotation) {
            Set<Element> classSet = elementsByAnnotation.get(ProtoQueueClass.class);
            compilerContext.log.debug("ProtoQueueProcessingStep process %s", classSet);
            classSet.stream().forEach(element -> {
                compilerContext.log.debug("ProtoQueueProcessingStep1 process %s", element);
            });
            classSet.stream().map(element -> {
                compilerContext.log.debug("ProtoQueueProcessingStep2 process %s", element);
                return element;
//                return new ProtoQueueClassProcessor(compilerContext, Util.toTypeElement(element)).process();
            });
            compilerContext.log.debug("ProtoQueueProcessingStep process end");

//            portTransformerDataStream.forEach(portTransformerData -> {
//                try {
//                    new PortTransformerWriter(portTransformerData).write(processingEnv);
//                } catch (IOException e) {
//                    portContext.log.error("PortTransformerWriter error", e.getMessage());
//                }
//            });

            return new HashSet<>();
        }
    }

    abstract class ProtoQueueProcessing implements ProcessingStep {
        CompilerContext compilerContext;
    }
}
