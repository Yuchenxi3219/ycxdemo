package com.example.demo.task.conditional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * @author YuChenXi
 * @date 2022/4/5 8:36 下午
 */
@Component
@Slf4j
@Conditional(BbbCondition.class)
public class ConditionalTaskTwo implements ConditionalTask{
    @Override
    public void execute() {
        log.info("ConditionalTaskTwo2222222222222");
    }
}
