package com.example.demo.utils;

/**
 * @author YuChenXi
 * @date 2022/6/7 11:06 下午
 */
public interface TtInterface {
    void t1();

    default void t2() {
        System.out.println("哈哈");
    }
}
