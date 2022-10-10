package com.example.demo.task;

import com.example.demo.vo.User;
import org.springframework.context.ApplicationEvent;

/**
 * @author YuChenXi
 * @date 2022/3/20 10:30 下午
 * 此类为事件类
 */
public class ServiceEvent extends ApplicationEvent {
    private User user;

    public ServiceEvent(User user) {
        super(user);
        this.user=user;
    }

    public User getUser() {
        return user;
    }
}
