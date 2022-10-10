package com.example.demo.response;

import lombok.*;

/**
 * @author YuChenXi
 * @date 2022/3/9 9:08 下午
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseResponse {
    public String errorCode;
    public String message;
    public Object data;
}
