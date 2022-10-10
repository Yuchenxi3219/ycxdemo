package com.example.demo.task.conditional;

import cn.hutool.setting.Setting;
import cn.hutool.setting.SettingUtil;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author YuChenXi
 * @date 2022/4/5 9:01 下午
 */
@Component
public class AaaCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Setting setting = SettingUtil.get("Test.properties");
        String value = setting.get("conditional");
        return Objects.equals(value,"aaa");
    }
}
