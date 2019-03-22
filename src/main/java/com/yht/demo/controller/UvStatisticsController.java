package com.yht.demo.controller;

import com.yht.demo.common.BaseController;
import com.yht.demo.common.Result;
import com.yht.demo.entity.dto.UvStatisticsReceiveDTO;
import com.yht.demo.service.IUvStatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("统计相关")
@RestController
@RequestMapping("/statistics")
public class UvStatisticsController extends BaseController {

    @Autowired
    private IUvStatisticsService uvStatisticsService;


    @PostMapping("/getAPPUVInfo")
    @ApiOperation(value = "获取APPUV统计数据")
    public Result getAPPUVInfo(UvStatisticsReceiveDTO uvStatisticsReceiveDTO) {
        Result result = uvStatisticsService.getAPPUVInfo(uvStatisticsReceiveDTO);
        return result;
    }


    @PostMapping("/getLoginRegisterInfo")
    @ApiOperation(value = "获取登录注册统计数据")
    public Result getLoginRegisterInfo(UvStatisticsReceiveDTO uvStatisticsReceiveDTO) {
        Result result = uvStatisticsService.getLoginRegisterInfo(uvStatisticsReceiveDTO);
        return result;
    }

}
