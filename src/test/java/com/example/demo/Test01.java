package com.example.demo;

import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.junit.jupiter.api.Test;


import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author YuChenXi
 * @date 2022/5/5 10:46 下午
 */
public class Test01 {
    private ConcurrentHashMap<String, Item> items = new ConcurrentHashMap<>();

    @Test
    public void tt() {
        IntStream.range(0, 10).forEach(i -> items.put("item" + i, new Item("item" + i)));
        List<Item> cart = createCart();

        System.out.println(cart);
    }

    @Test
    public void tt1() {
        IntStream.rangeClosed(5, 15).parallel().forEach(i -> System.out.println(i)
        );
    }

    @Test
    public void tt2() {
        String payload = IntStream.rangeClosed(1, 10).mapToObj(i -> "a").collect(Collectors.joining(",")) + UUID.randomUUID().toString();
        System.out.println(payload);
    }


    public List<Item> createCart() {
        return IntStream.rangeClosed(1, 3)
                .mapToObj(i -> "item" + ThreadLocalRandom.current().nextInt(items.size()))//将三个元素转换成item3、item7...这种
                .map(name -> items.get(name))//从实例域map集合中获取对应key的value（Item对象）
                .collect(Collectors.toList());
    }

    @Data
    @RequiredArgsConstructor
    static class Item {
        final String name;
        int remaining = 1000;
        @ToString.Exclude
        ReentrantLock lock = new ReentrantLock();
    }
}
