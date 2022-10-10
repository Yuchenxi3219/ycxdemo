package com.example.demo.foundation;

import com.example.demo.annotion.InterfaceLogHandler.InterfaceLogDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author YuChenXi
 * @date 2022/3/26 9:37 下午
 */
@Slf4j
@Component
public class InterfaceLogEvent {

    public void printLog(InterfaceLogEntity entity) {
        log.info("InterfaceInfo: {} | {}ms | {} ",
                entity.getInterfaceName(),
                entity.getEndTime() - entity.getStartTime(),
                entity.getIpAddress());
    }

    public void printLogV2(InterfaceLogDto dto){
        log.info("InterfaceInfoV2:{}|{}ms|{}|{}",
                dto.getIp(),dto.getCostTime(),dto.getRequestDate(),dto.getExtra());
    }
}
