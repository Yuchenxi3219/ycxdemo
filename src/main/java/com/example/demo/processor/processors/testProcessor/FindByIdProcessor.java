package com.example.demo.processor.processors.testProcessor;

import com.example.demo.Constants.Constants;
import com.example.demo.annotion.Action;
import com.example.demo.processor.processors.ProcessorMeta;
import com.example.demo.processor.serviceImpls.TestService;
import com.example.demo.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author YuChenXi
 * @date 2022/3/16 7:43 下午
 */
@Action(Constants.FIND_ID)
@Component
public class FindByIdProcessor implements ProcessorMeta {
    @Autowired
    private TestService testService;

    @Override
    public BaseResponse execute(HttpServletRequest request, Map param, Object body) {
        Integer id = (Integer) param.get("id");
        return testService.findById(id);
    }
}
