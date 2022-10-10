package com.example.demo.annotion;

import java.lang.annotation.*;

/**
 * @author YuChenXi
 * @date 2022/8/28 7:43 下午
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface InterfaceLog {
    String value() default "";

    boolean isInnerInterface() default false;
}
