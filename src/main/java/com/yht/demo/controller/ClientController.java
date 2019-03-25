package com.yht.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yht.demo.common.BaseController;
import com.yht.demo.common.Result;
import com.yht.demo.service.IClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api("客户端管理")
@RequestMapping("/clientManager")
@RestController
public class ClientController extends BaseController {

    @Autowired
    private IClientService clientService;

    @PostMapping("/addClient")
    @ApiOperation(value = "新增客户端")
    public Result addClient(@RequestParam String clientName, @RequestParam String type) {
        clientService.addClient(clientName, type);
        return Result.success("成功");
    }

    @PostMapping("/getClientList")
    @ApiOperation(value = "获取客户端列表")
    public Result getClientList(@RequestParam(value = "pageNum") Integer pageNum,
                                @RequestParam(value = "pageSize") Integer pageSize,
                                @RequestParam(value = "clientName") String clientName) {
        IPage<Map<String, String>> clientList = clientService.getClientList(pageNum, pageSize, clientName);
        return Result.success(clientList);
    }

    @PostMapping("/updateClient")
    @ApiOperation(value = "更新客户端")
    public Result updateClient(@RequestParam String id, String clientName) {
        clientService.updateClient(id, clientName);
        return Result.success("成功");
    }

    @PostMapping("/getAllClients")
    @ApiOperation(value = "获取客户端列表（条件查询使用）")
    public Result getAllClients() {
        List<String> clients = clientService.getAllClients();
        return Result.success(clients);
    }

}
