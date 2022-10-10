package com.example.demo;

import com.example.demo.annotion.Action;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author YuChenXi
 * @date 2022/5/15 9:13 下午
 */
public class Test03ArraysList {

    @Test
    public void t1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {


       /* Stu stu = new Stu();
        Method eat = stu.getClass().getDeclaredMethod("eat", String.class);
        eat.invoke(stu, "shit");*/

        ArrayList<Object> data = new ArrayList<>();
        data.add(IntStream.rangeClosed(1, 1000000)
                .mapToObj(__ -> "a")
                .collect(Collectors.joining(",")) + UUID.randomUUID().toString());

    }
        }


class Stu {
    private int age = 1;

    public Stu(int age) {
        this.age = age;
    }

    int getAge() {
        return this.age;
    }

    void setAge(int age) {
        this.age=age;
    }

    void eat(String s) {
        System.out.println(s);
    }
}