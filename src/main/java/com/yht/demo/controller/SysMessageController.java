package com.yht.demo.controller;

import com.yht.demo.common.BaseController;
import com.yht.demo.common.Result;
import com.yht.demo.entity.dto.PushMessageReceiveDTO;
import com.yht.demo.service.ISystemMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api("系统消息")
@RestController
@RequestMapping("/systemMessage")
public class SysMessageController extends BaseController {

	@Autowired
	private ISystemMessageService systemMessageService;


	@PostMapping("/pushSystemMessage")
	@ApiOperation(value = "推送系统消息")
	public Result pushSystemMessage(@RequestParam PushMessageReceiveDTO pushMessageReceiveDTO) {
		systemMessageService.pushSystemMessage(pushMessageReceiveDTO);
		return Result.success("发送成功！");
	}

}
