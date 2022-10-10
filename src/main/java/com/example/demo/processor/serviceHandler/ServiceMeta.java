package com.example.demo.processor.serviceHandler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author YuChenXi
 * @date 2022/3/13 9:29 下午
 */
@Getter
@Setter
@Accessors(fluent = true)
public class ServiceMeta {
    private String processorName;
    private String url;
}
