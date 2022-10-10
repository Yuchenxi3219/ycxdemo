package com.example.demo.task;

import com.example.demo.dao.TestDao;
import com.example.demo.utils.SpringBeanUtils;
import com.example.demo.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author YuChenXi
 * @date 2022/3/20 10:25 下午
 * 此类功能是监听
 */
@Component
@Slf4j
public class EventHandler {
    @EventListener(classes = ServiceEvent.class)
    public void listener(ServiceEvent event) {
        //将事件发布传过来的测试User写进数据库
        TestDao bean = SpringBeanUtils.getBean(TestDao.class);
        bean.insert(event.getUser());
        log.info("处理事件：{}",event.getUser().toString());
    }
}
