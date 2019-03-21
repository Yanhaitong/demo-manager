package com.yht.demo.service.impl;

import com.yht.demo.common.BaseService;
import com.yht.demo.common.Result;
import com.yht.demo.entity.dto.UvStatisticsReceiveDTO;
import com.yht.demo.mapper.UvStatisticsMapper;
import com.yht.demo.service.IUvStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UvStatisticsServiceImpl extends BaseService implements IUvStatisticsService {


    @Autowired
    private UvStatisticsMapper uvStatisticsMapper;

    @Override
    public Result getAPPUVInfo(UvStatisticsReceiveDTO uvStatisticsReceiveDTO) {
        //app注册数
        //app登录数
        //uv点击数
        uvStatisticsMapper.getUVClickCount(uvStatisticsReceiveDTO);

        return null;
    }
}
