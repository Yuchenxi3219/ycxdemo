package com.example.demo;

import com.example.demo.utils.SingletonEnum;
import com.example.demo.utils.SingletonTest;
import com.example.demo.utils.TestStrategyImp;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author YuChenXi
 * @date 2022/9/21 11:30 下午
 */
public class tt11 {
    private HashMap<String, String> testMap;
    @Test
    public void t1(){
     //   SingletonTest instance = SingletonTest.SingEnum.SINGLETON_TEST.getInstance();
      //  SingletonTest instance1 = SingletonTest.SingEnum.SINGLETON_TEST.getInstance();
        SingletonTest instance = SingletonTest.getInstance();
        SingletonTest instance1 = SingletonTest.getInstance();
        System.out.println(instance1==instance);
    }
}
