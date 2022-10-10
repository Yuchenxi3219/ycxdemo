package com.example.demo.processor.processors.testProcessor;

import cn.hutool.core.collection.CollectionUtil;
import com.example.demo.Constants.Constants;
import com.example.demo.annotion.Action;
import com.example.demo.processor.processors.ProcessorMeta;
import com.example.demo.processor.serviceImpls.TestService;
import com.example.demo.response.DataResponse;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author YuChenXi
 * @date 2022/3/13 10:09 下午
 */
@Action(Constants.TEST)
@Component
@Slf4j
public class FindAllProcessor implements ProcessorMeta {

    @Autowired
    private TestService testService;

    /**
     * @param null
     * @return null
     * @author YuChenXi
     * 使用caffeine将数据提前加载进缓存，同步加载方式
     * 也可以普通的put，get方式
     */
    private LoadingCache<String, DataResponse> cache = Caffeine.newBuilder()
            .maximumSize(10000)
            .expireAfterWrite(5, TimeUnit.MINUTES)
            .refreshAfterWrite(1, TimeUnit.MINUTES)
            .build(key -> getDataFromDataBase(key));


    private DataResponse getDataFromDataBase(String key) {
        DataResponse response = testService.findAll();
        log.info("get data from dataBase");
        return response;
    }

    @Override
    public DataResponse execute(HttpServletRequest request, Map param, Object body) {
        //如果无法命中key的话则直接加载getDataFromDataBase()方法，并将return的value和key关联起来
        DataResponse response = cache.get("key");
        return response;
    }
}
