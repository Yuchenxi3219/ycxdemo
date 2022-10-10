package com.example.demo.common;

import lombok.extern.slf4j.Slf4j;

/**
 * @author YuChenXi
 * @date 2022/4/1 9:11 下午
 * 专门定义枚举确定几种固定的任务类型，在业务类中进行判断是否是这几种类型中的一个并且执行业务execute处理
 */
@Slf4j
public enum ValidEnum {
    GOOD {
        @Override
        public void execute() {
            log.info("it is really good");
        }
    },
    BAD {
        @Override
        public void execute() {
            log.info("it is really bad");
        }
    };
    public abstract void execute();
}
