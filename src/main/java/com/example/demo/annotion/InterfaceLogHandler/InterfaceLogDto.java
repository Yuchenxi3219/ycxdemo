package com.example.demo.annotion.InterfaceLogHandler;

import lombok.Data;

/**
 * @author YuChenXi
 * @date 2022/8/28 7:53 下午
 */
@Data
public class InterfaceLogDto {
    private String ip;
    private String requestUri;
    private String requestDate;
    private int costTime;
    private String extra;
}
