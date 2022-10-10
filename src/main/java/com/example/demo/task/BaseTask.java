package com.example.demo.task;

import java.util.concurrent.Callable;

/**
 * @author YuChenXi
 * @date 2022/3/20 5:34 下午
 */
public class BaseTask implements Runnable {
    @Override
    public void run() {
    }
}
// 有返回值值，区别于Runnble的run方法
class BaseTask1 implements Callable{

    @Override
    public Object call() throws Exception {
        return null;
    }
}