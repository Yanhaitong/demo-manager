package com.yht.demo.service;

import com.yht.demo.common.Result;
import com.yht.demo.entity.dto.UvStatisticsReceiveDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IUvStatisticsService {


    Result getAPPUVInfo(UvStatisticsReceiveDTO uvStatisticsReceiveDTO);

    Result getLoginRegisterInfo(UvStatisticsReceiveDTO uvStatisticsReceiveDTO);
}
