package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author YuChenXi
 * @date 2022/4/24 10:39 下午
 */
@Getter
@Setter
@AllArgsConstructor
public class PerformanceDataBean {
    private String id;

    private String name;

    private Long createTime;

    private Integer succNum;

    private Integer failNum;
}
