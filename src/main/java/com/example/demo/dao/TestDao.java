package com.example.demo.dao;

import com.example.demo.vo.PerformanceDataBean;
import com.example.demo.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author YuChenXi
 * @date 2022/3/9 10:10 下午
 */
@Mapper
public interface TestDao {
    List<User> findAll();

    List<User> findById(Integer id);

    void insert(User user);

    void insertIntoPerformanceData(@Param("beans") List<PerformanceDataBean> beans);
}
