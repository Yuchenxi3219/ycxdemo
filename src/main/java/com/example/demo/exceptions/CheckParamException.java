package com.example.demo.exceptions;

import com.example.demo.Constants.ErrorCode;
import com.example.demo.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author YuChenXi
 * @date 2022/3/27 10:44 下午
 * 定义全局异常类来处理校验参数抛出的异常,若产生异常直接返回response
 */
@ControllerAdvice
@Slf4j
public class CheckParamException {

    /*@ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public BaseResponse check(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            String message = fieldError.getDefaultMessage();
            log.error("Check parameter error:{}",message);
            return new BaseResponse(ErrorCode.INVALID_PARAM.getErrorCode(), message, "");
        }
        return null;
    }*/
}
