package com.example.demo.utils;

import java.util.function.Predicate;

/**
 * @author YuChenXi
 * @date 2022/9/21 9:28 上午
 */
public class ValidStrategy {

    // 函数式接口
    private TestStrategy testStrategy;
    private Predicate test;

    public ValidStrategy(Predicate t) {
        test=t;
    }

    public String validate(String str){
       if(test.test(str)){
           return "good";
       }else {
           return "bad";
       }
    }
}
