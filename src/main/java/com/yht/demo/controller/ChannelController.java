package com.yht.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yht.demo.common.BaseController;
import com.yht.demo.common.Result;
import com.yht.demo.service.IChannelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api("渠道管理")
@RequestMapping("/channelManager")
@RestController
public class ChannelController extends BaseController {

    @Autowired
    private IChannelService channelService;

    @PostMapping("/addChannel")
    @ApiOperation(value = "新增渠道")
    public Result addChannel(@RequestParam String channelName) {
        channelService.addChannel(channelName);
        return Result.success("成功");
    }


    @PostMapping("/getChannelList")
    @ApiOperation(value = "获取渠道列表")
    public Result getChannelList(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        IPage<Map<String, String>> channelList = channelService.getChannelList(pageNum, pageSize);
        return Result.success(channelList);
    }


}
