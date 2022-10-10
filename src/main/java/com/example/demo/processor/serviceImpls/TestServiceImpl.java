package com.example.demo.processor.serviceImpls;

import com.alibaba.fastjson.JSON;
import com.example.demo.Constants.ErrorCode;
import com.example.demo.common.ValidEnum;
import com.example.demo.dao.TestDao;
import com.example.demo.exceptions.ServiceException;
import com.example.demo.response.BaseResponse;
import com.example.demo.response.DataResponse;
import com.example.demo.task.ServiceEvent;
import com.example.demo.task.TestTask;
import com.example.demo.task.conditional.ConditionalTask;
import com.example.demo.vo.User;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author YuChenXi
 * @date 2022/3/9 10:32 下午
 */
@Service
@Transactional
@Slf4j
public class TestServiceImpl implements TestService {

    private static final ExecutorService EXECUTOR_SERVICE = new ThreadPoolExecutor(5, 10, 3L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100));

    @Autowired
    private TestDao testDao;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private ConditionalTask conditionalTask;

    @Override
    public DataResponse findAll() {
        List<User> all = testDao.findAll();
        log.info("get users:{}", JSON.toJSONString(all));
        return new DataResponse(ErrorCode.SUCCESS.getErrorCode(), ErrorCode.SUCCESS.getErrorMessage(), all);
    }

    @Override
    public BaseResponse findById(Integer id) {
        List<User> users = testDao.findById(id);
        users.stream().forEach(user -> {
            if (user.getId() == 22){
                System.out.println(111);
            }
        });
        log.info("get user:{}", JSON.toJSONString(users));
        EXECUTOR_SERVICE.execute(new TestTask());
        //发布事件
        applicationEventPublisher.publishEvent(new ServiceEvent(new User(UUID.randomUUID().hashCode(), "testPublisher")));
      if (users != null) {
          try {
              ValidEnum validEnum = ValidEnum.valueOf(users.get(0).getName());
              validEnum.execute();
          } catch (EnumConstantNotPresentException | IllegalArgumentException e){
              log.warn("username neither good nor bad");
              throw new ServiceException(ErrorCode.INVALID_PARAM.getErrorCode(), "not good or bad");
          }
      }
        return new DataResponse(ErrorCode.SUCCESS.getErrorCode(), ErrorCode.SUCCESS.getErrorMessage(), users);
    }

    @Override
    public BaseResponse addUser(User user) {
      //  conditionalTask.execute();
        Optional<List<User>> userById = Optional.ofNullable(testDao.findById(user.getId()));
        if (userById.isPresent()) {
            throw new ServiceException(ErrorCode.EXISTING_DATA_ERROR.getErrorCode(), ErrorCode.EXISTING_DATA_ERROR.getErrorMessage());
        }
        testDao.insert(user);
        return new DataResponse(ErrorCode.SUCCESS.getErrorCode(), ErrorCode.SUCCESS.getErrorMessage(), "ok");
    }
}
