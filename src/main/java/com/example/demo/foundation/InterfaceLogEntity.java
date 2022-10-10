package com.example.demo.foundation;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author YuChenXi
 * @date 2022/3/26 9:43 下午
 */
@Accessors(chain = true)
@Getter
@Setter
public class InterfaceLogEntity {
    private String interfaceName;
    private Long startTime;
    private Long endTime;
    private String ipAddress;
    private String responseData;
}
