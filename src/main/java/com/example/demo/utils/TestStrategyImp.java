package com.example.demo.utils;

import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author YuChenXi
 * @date 2022/9/21 1:37 下午
 */
@Component
public class TestStrategyImp implements TestStrategy{
    @Override
    public boolean execute(String s) {
        return false;
    }

    public Optional<String> executeV11(String s) {
       String ss = null;
        return ss == null ? Optional.empty() : Optional.of(ss);
    }
}
