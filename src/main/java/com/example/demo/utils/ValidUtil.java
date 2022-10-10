package com.example.demo.utils;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author YuChenXi
 * @date 2022/3/28 11:01 下午
 * 定义此工具类来校验参数并且返回包含校验信息的set集合
 */
public class ValidUtil {
    public static void validParamWithException(Validator validator, Object value, Class<?> ... groups) {
        Set<ConstraintViolation<Object>> set = validator.validate(value, groups);
        if (!set.isEmpty()) {
            throw new ConstraintViolationException(set);
        }
    }
}
