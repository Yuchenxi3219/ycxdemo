package com.example.demo.processor.processors;

import com.example.demo.request.BaseRequest;
import com.example.demo.response.BaseResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author YuChenXi
 * @date 2022/3/14 10:46 下午
 */
public interface ProcessorMeta<S extends HttpServletRequest, T extends BaseResponse> {
    /**
     * @param request
     * @return T
     * @author YuChenXi
     * @date 2022/3/14 10:51 下午
     */
    T execute(S request, Map<String, Object> param,Object body);
}
