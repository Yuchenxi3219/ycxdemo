package com.example.demo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author YuChenXi
 * @date 2022/3/9 9:10 下午
 */
public class HealthCheckResponse extends BaseResponse{
    public HealthCheckResponse(String errorCode, String message, Object data) {
        super(errorCode, message, data);
    }
}
