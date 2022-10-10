package com.example.demo.utils;

/**
 * @author YuChenXi
 * @date 2022/9/22 9:25 上午
 */
public class SingletonTest {
    private int xxx=111;
    //私有化构造器
    private SingletonTest(){}

    private static   SingletonTest instance =new SingletonTest();

    public static enum SingEnum{
        SINGLETON_TEST;
        private SingletonTest instance =null;
        private SingEnum(){
            System.out.println("构造枚举");
            instance=new SingletonTest();
        }

        public SingletonTest getInstance(){
            return instance;
        }
    }

    public static SingletonTest getInstance(){
        return instance;
    }
}
