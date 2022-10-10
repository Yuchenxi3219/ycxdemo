package com.example.demo.response;

/**
 * @author YuChenXi
 * @date 2022/3/9 10:59 下午
 */
public class DataResponse extends BaseResponse{
    public DataResponse(String errorCode, String message, Object data) {
        super(errorCode, message, data);
    }
}
