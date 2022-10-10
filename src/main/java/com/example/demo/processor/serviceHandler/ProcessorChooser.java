package com.example.demo.processor.serviceHandler;

import cn.hutool.core.annotation.AnnotationUtil;
import com.example.demo.annotion.Action;
import com.example.demo.exceptions.ServiceException;
import com.example.demo.processor.processors.ProcessorMeta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * @author YuChenXi
 * @date 2022/3/14 11:18 下午
 */
@Slf4j
@Component
public class ProcessorChooser implements ApplicationContextAware {
    public static Map<String, ProcessorChooser.ProcessorInfo> PROCESSOR_MAP = new HashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //优雅地获取ProcessorMeta接口的所有实现类
        Map<String, ProcessorMeta> processorMetaMap = applicationContext.getBeansOfType(ProcessorMeta.class);
        for (ProcessorMeta processorMeta : processorMetaMap.values()) {
            Class<? extends ProcessorMeta> clazz = processorMeta.getClass();
            Action annotation = clazz.getAnnotation(Action.class);
            //有添加@Action注解的processsor都添加到Map中
            if (Objects.nonNull(annotation)) {
                PROCESSOR_MAP.put(annotation.value(), new ProcessorChooser.ProcessorInfo(processorMeta, annotation));
            } else {
                log.warn("processorChooser failed");
            }
        }
    }

    /**
     * @param actionName
     * @return Optional<ProcessorInfo>
     * 根据注解名称选择对应的processor
     */
    public Optional<ProcessorChooser.ProcessorInfo> getProcessor(String actionName) {
        if (PROCESSOR_MAP.containsKey(actionName)) {
            return Optional.of(PROCESSOR_MAP.get(actionName));
        } else {
           // return Optional.empty();
            throw new ServiceException();
        }
    }

    /**
     * 内部类，封装两个关联属性
     */
    @Getter
    @AllArgsConstructor
    public static class ProcessorInfo {
        private final ProcessorMeta processor;
        private final Action action;
    }
}
