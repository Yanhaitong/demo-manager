package com.yht.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yht.demo.common.BaseService;
import com.yht.demo.common.Result;
import com.yht.demo.entity.dto.UvStatisticsReceiveDTO;
import com.yht.demo.entity.model.UserManager;
import com.yht.demo.mapper.UserMapper;
import com.yht.demo.mapper.UvStatisticsMapper;
import com.yht.demo.service.IUvStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UvStatisticsServiceImpl extends BaseService implements IUvStatisticsService {


    @Autowired
    private UvStatisticsMapper uvStatisticsMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result getAPPUVInfo(UvStatisticsReceiveDTO uvStatisticsReceiveDTO) {
        Page page = new Page();
        page.setSize(uvStatisticsReceiveDTO.getPageSize());
        page.setCurrent(uvStatisticsReceiveDTO.getPageNum());
        //uv点击数
        IPage<Map> list = uvStatisticsMapper.getUVClickCount(page, uvStatisticsReceiveDTO);

        return Result.success(list);
    }

    @Override
    public Result getLoginRegisterInfo(UvStatisticsReceiveDTO uvStatisticsReceiveDTO) {
        Page page = new Page();
        page.setSize(uvStatisticsReceiveDTO.getPageSize());
        page.setCurrent(uvStatisticsReceiveDTO.getPageNum());
        //用户登录注册统计
        IPage<Map> list = userMapper.getLoginRegisterInfo(page, uvStatisticsReceiveDTO);

        return Result.success(list);
    }
}
