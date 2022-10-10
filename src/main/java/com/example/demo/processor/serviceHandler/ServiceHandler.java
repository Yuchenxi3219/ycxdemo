package com.example.demo.processor.serviceHandler;

import com.example.demo.response.BaseResponse;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author YuChenXi
 * @date 2022/3/13 9:02 下午
 */
public interface ServiceHandler {
    BaseResponse execute(HttpServletRequest request, ServiceMeta serviceMeta, Map params,Object body);
}
