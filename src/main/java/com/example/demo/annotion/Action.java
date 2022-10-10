package com.example.demo.annotion;

import java.lang.annotation.*;

/**
 * @author YuChenXi
 * @date 2022/3/13 10:10 下午
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface Action {
    String value() default "";
}
