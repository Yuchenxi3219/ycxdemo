package com.example.demo.processor.serviceImpls;

import com.example.demo.response.BaseResponse;
import com.example.demo.response.DataResponse;
import com.example.demo.vo.User;

/**
 * @author YuChenXi
 * @date 2022/3/9 10:33 下午
 */
public interface TestService {
    DataResponse findAll();

    BaseResponse findById(Integer id);

    BaseResponse addUser(User user);
}
