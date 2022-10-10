package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.Constants.Constants;
import com.example.demo.annotion.InterfaceLog;
import com.example.demo.processor.serviceHandler.ServiceHandler;
import com.example.demo.processor.serviceHandler.ServiceMeta;
import com.example.demo.redis.RedisService;
import com.example.demo.response.BaseResponse;
import com.example.demo.response.HealthCheckResponse;
import com.example.demo.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author YuChenXi
 * @date 2022/2/22 12:07 上午
 */
@RestController
@RequestMapping("/test")
@Validated
public class TestController {

    @Autowired
    private ServiceHandler serviceHandler;

    @Autowired
    private RedisService redisService;

    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping("/hc")
    @InterfaceLog(isInnerInterface = true)
    public BaseResponse hello(@RequestParam String id) {
        String s = redisService.get(id);
        Map<String, ? extends ServiceHandler> beansOfType = applicationContext.getBeansOfType(serviceHandler.getClass());
        return new HealthCheckResponse("1", "ok", s);
    }

    @RequestMapping("/findAll")
    public BaseResponse findAll(HttpServletRequest request) {
        ServiceMeta serviceMeta = new ServiceMeta()
                .processorName(Constants.TEST)
                .url(Constants.TEST_URL);
        return serviceHandler.execute(request, serviceMeta, null, null);
    }

    @RequestMapping("/findById")
    public BaseResponse findById(@RequestParam Integer id, HttpServletRequest request) {
        ServiceMeta serviceMeta = new ServiceMeta()
                .processorName(Constants.FIND_ID)
                .url(Constants.FIND_ID_URL);
        Map map = new HashMap<>();
        map.put("id", id);
        return serviceHandler.execute(request, serviceMeta, map, null);
    }

    @RequestMapping("/addUser")
    public BaseResponse addUser(@RequestBody User user, HttpServletRequest request) {
        ServiceMeta serviceMeta = new ServiceMeta()
                .processorName(Constants.ADD_USER)
                .url(Constants.ADD_USER_URL);
        return serviceHandler.execute(request, serviceMeta, null, user);
    }
}
