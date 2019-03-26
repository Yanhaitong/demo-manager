package com.yht.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yht.demo.common.BaseController;
import com.yht.demo.common.Result;
import com.yht.demo.entity.dto.AdvertisingAddDTO;
import com.yht.demo.entity.dto.AdvertisingReceiveDTO;
import com.yht.demo.entity.dto.AdvertisingUpdateDTO;
import com.yht.demo.service.IAdvertisingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api("产品广告配置管理")
@RequestMapping("/advertising")
@RestController
public class AdvertisingController extends BaseController {

    @Autowired
    private IAdvertisingService advertisingService;

    @PostMapping("/getAdvertisingList")
    @ApiOperation(value = "获取广告列表")
    public Result getAdvertisingList(@RequestBody AdvertisingReceiveDTO advertisingReceiveDTO) {
        IPage<Map<String, String>> advertisingList = advertisingService.getAdvertisingList(advertisingReceiveDTO);
        return Result.success(advertisingList);
    }

    @PostMapping("/addAdvertising")
    @ApiOperation(value = "添加产品广告")
    public Result addAdvertising(@RequestBody AdvertisingAddDTO advertisingParameterDTO) {
        advertisingService.addAdvertising(advertisingParameterDTO);
        return Result.success("成功");
    }

    @PostMapping("/upDateAdvertising")
    @ApiOperation(value = "更新产品广告")
    public Result updateAdvertising(@RequestBody AdvertisingUpdateDTO advertisingUpdateDTO) {
        advertisingService.updateAdvertising(advertisingUpdateDTO);
        return Result.success("成功");
    }

    @PostMapping("/deleteAdvertising")
    @ApiOperation(value = "删除产品广告")
    public Result deleteAdvertisingById(@RequestParam String id) {
        advertisingService.deleteAdvertisingById(id);
        return Result.success("成功");
    }

}
