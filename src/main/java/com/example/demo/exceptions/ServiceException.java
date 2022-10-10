package com.example.demo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author YuChenXi
 * @date 2022/3/13 8:39 下午
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ServiceException extends RuntimeException{
    private String errorCode;
    private String errorMessage;
}
