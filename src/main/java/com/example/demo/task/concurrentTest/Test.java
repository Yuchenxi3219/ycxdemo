package com.example.demo.task.concurrentTest;

import com.example.demo.task.concurrentTest.t1;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author YuChenXi
 * @date 2022/4/27 10:44 下午
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Object> list = new ArrayList<>();
        list.addAll(IntStream.rangeClosed(1,1000).boxed().collect(Collectors.toList()));
        System.out.println(list);
    }
}
