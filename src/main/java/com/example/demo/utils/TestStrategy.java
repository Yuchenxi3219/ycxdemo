package com.example.demo.utils;

/**
 * @author YuChenXi
 * @date 2022/9/21 9:27 上午
 */
public interface TestStrategy {
    boolean execute(String s);

    default void t1(){
        System.out.println("hhh");
    }
}
