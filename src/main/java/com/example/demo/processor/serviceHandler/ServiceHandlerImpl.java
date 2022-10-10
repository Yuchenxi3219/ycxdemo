package com.example.demo.processor.serviceHandler;

import cn.hutool.core.collection.CollectionUtil;
import com.example.demo.Constants.ErrorCode;
import com.example.demo.exceptions.ServiceException;
import com.example.demo.processor.processors.ProcessorMeta;
import com.example.demo.response.BaseResponse;
import com.example.demo.utils.ValidUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * @author YuChenXi
 * @date 2022/3/13 9:03 下午
 */
@Component
public class ServiceHandlerImpl implements ServiceHandler {

    @Autowired
    private ProcessorChooser processorChooser;

    @Override
    public BaseResponse execute(HttpServletRequest request, ServiceMeta serviceMeta, Map params, Object body) {
        BaseResponse response = new BaseResponse();
        try {
            Optional<ProcessorChooser.ProcessorInfo> processor = processorChooser.getProcessor(serviceMeta.processorName());
            ProcessorChooser.ProcessorInfo processorInfo = processor.get();
            ProcessorMeta theProcessor = processorInfo.getProcessor();
            response = theProcessor.execute(request, params, body);
            return response;
        } catch (ConstraintViolationException e) { //处理参数校验
            Set<ConstraintViolation<?>> set = e.getConstraintViolations();
            StringBuilder errorMessage = new StringBuilder();
            if (!CollectionUtil.isEmpty(set)) {
                set.forEach(item -> errorMessage.append(item.getMessageTemplate()).append(","));
            }
            response.setMessage(errorMessage.toString());
            response.setErrorCode(ErrorCode.INVALID_PARAM.getErrorCode());
        } catch (ServiceException e) {
            response.setMessage(e.getErrorMessage());
            response.setErrorCode(e.getErrorCode());
        } catch (Exception e) {
            response.setMessage(ErrorCode.INTERNAL_ERROR.getErrorCode());
            response.setErrorCode(ErrorCode.INTERNAL_ERROR.getErrorMessage());
        }
        return response;
    }
}
