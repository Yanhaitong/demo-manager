package com.yht.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yht.demo.common.BaseController;
import com.yht.demo.common.Result;
import com.yht.demo.entity.dto.LoanProductConfigReceiveDTO;
import com.yht.demo.entity.dto.LoanProductConfigReturnDTO;
import com.yht.demo.service.ILoanProductConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("产品配置管理")
@RequestMapping("/loanProductConfig")
@RestController
public class LoanProductConfigController extends BaseController {

    @Autowired
    private ILoanProductConfigService loanProductConfigService;


    @PostMapping("/addLoanProductConfig")
    @ApiOperation(value = "添加产品配置")
    public Result addLoanProductConfig(@RequestBody LoanProductConfigReceiveDTO loanProductConfigReceiveDTO) {
        loanProductConfigService.addLoanProductConfig(loanProductConfigReceiveDTO);
        return Result.success("成功");
    }

    @PostMapping("/getLoanProductConfigList")
    @ApiOperation(value = "获取产品配置列表")
    public Result getLoanProductConfigList(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam String title) {
        IPage<LoanProductConfigReturnDTO> loanProductConfigReturnDTOIPage = loanProductConfigService.getLoanProductConfigList(pageNum, pageSize, title);
        return Result.success(loanProductConfigReturnDTOIPage);
    }

    @PostMapping("/hiddenOrShowProduct")
    @ApiOperation(value = "隐藏或显示产品信息")
    public Result hiddenOrShowProduct(@RequestParam String productId, @RequestParam String isHide) {
        loanProductConfigService.hiddenOrShowProduct(productId, isHide);
        return Result.success("成功");
    }

    /*@PostMapping("/loanProductConfigParameter")
    @ApiOperation(value = "产品配置参数")
    public Result loanProductConfigParameter(@RequestBody LoanProductInfo loanProductInfo) {
        return loanProductService.loanProductConfigParameter(loanProductInfo);
    }*/

}
