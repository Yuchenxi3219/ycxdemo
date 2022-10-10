package com.example.demo.task;

import com.example.demo.dao.TestDao;
import com.example.demo.utils.SpringBeanUtils;
import com.example.demo.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * @author YuChenXi
 * @date 2022/3/20 5:32 下午
 * 用新的线程测试下ApplicationEventPublisher监听;此类功能是发布
 */
@Slf4j
@Component
public class TestTask extends BaseTask{

    @Override
    public void run(){
        log.info("多线程启动");
        //多线程中，用getBean代替Autowired
    }

    private ConcurrentHashMap getData(int count) {
        return LongStream
                .rangeClosed(1, count) // 1到count的数据范围的创建
                .boxed()// 装箱
                .collect(Collectors.toConcurrentMap(i -> UUID.randomUUID().toString(), Function.identity(), (o1, o2) -> o1, ConcurrentHashMap::new));}
}
