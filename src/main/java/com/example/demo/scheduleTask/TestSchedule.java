package com.example.demo.scheduleTask;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.example.demo.dao.TestDao;
import com.example.demo.redis.RedisService;
import com.example.demo.vo.PerformanceDataBean;
import com.example.demo.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

/**
 * @author YuChenXi
 * @date 2022/3/30 8:57 下午
 */
@Component
@Slf4j
public class TestSchedule {
    @Autowired
    private TestDao testDao;

    @Autowired
    private RedisService redisService;


    //每隔2分钟执行一次
    //@Scheduled(cron = "0 0/2 * * * ?")
    public void test() {
        Random random = new Random();
        int id = random.nextInt(2022);
        User user = new User(id, "createdBySchedule");
        String s = JSON.toJSONString(user);
        String id1 = Integer.toString(id);
        System.out.println(id1);
        redisService.set(id1, s);
    }


    //@Scheduled(cron = "*/1 * * * * ?")
    public void addDataToMySql() {
        Random random = new Random();
        ArrayList<PerformanceDataBean> beans = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            beans.add(new PerformanceDataBean(UUID.randomUUID().toString(),"Aname",System.currentTimeMillis(), random.nextInt(10),random.nextInt(10)));
        }
        testDao.insertIntoPerformanceData(beans);

    }
}
