package com.example.demo.task.concurrentTest;

import cn.hutool.setting.Setting;
import cn.hutool.setting.SettingUtil;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author YuChenXi
 * @date 2022/4/5 8:52 下午
 */
public class tt {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Long> collect = LongStream
                .rangeClosed(1, 10) // 1到count的数据范围的创建
                .boxed()// 装箱
                .collect(Collectors.toConcurrentMap(i -> UUID.randomUUID().toString(), Function.identity(), (o1, o2) -> o1, ConcurrentHashMap::new));

        System.out.println(collect);
    }
    }

