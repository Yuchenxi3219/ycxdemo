package com.example.demo.processor.processors.testProcessor;

import com.example.demo.Constants.Constants;
import com.example.demo.annotion.Action;
import com.example.demo.processor.processors.ProcessorMeta;
import com.example.demo.processor.serviceImpls.TestService;
import com.example.demo.response.BaseResponse;
import com.example.demo.utils.ValidUtil;
import com.example.demo.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Map;

/**
 * @author YuChenXi
 * @date 2022/3/27 3:24 下午
 */
@Action(Constants.ADD_USER)
@Component
@Slf4j
public class AddUserProcessor implements ProcessorMeta {
    @Autowired
    private Validator validator;

    @Autowired
    private TestService testService;

    @Override
    public BaseResponse execute(HttpServletRequest request, Map param, Object body) {
        User user = (User) body;
        ValidUtil.validParamWithException(validator, user);
        BaseResponse response = testService.addUser(user);
        return response;
    }
}
