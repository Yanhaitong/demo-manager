package com.yht.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yht.demo.common.BaseController;
import com.yht.demo.common.Result;
import com.yht.demo.entity.dto.LoanProductInfoReceiveDTO;
import com.yht.demo.entity.dto.LoanProductInfoReturnDTO;
import com.yht.demo.entity.dto.LoanProductReceiveDTO;
import com.yht.demo.entity.dto.LoanProductReturnDTO;
import com.yht.demo.entity.model.LoanProduct;
import com.yht.demo.entity.model.LoanProductInfo;
import com.yht.demo.service.ILoanProductClassifyService;
import com.yht.demo.service.ILoanProductInfoService;
import com.yht.demo.service.ILoanProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api("产品配置管理")
@RequestMapping("/loanProduct")
@RestController
public class LoanProductController extends BaseController {

    @Autowired
    private ILoanProductInfoService loanProductInfoService;
    @Autowired
    private ILoanProductService loanProductService;
    @Autowired
    private ILoanProductClassifyService loanProductClassifyService;


    @PostMapping("/addLoanProductInfo")
    @ApiOperation(value = "新增产品信息")
    public Result addLoanProduct(@RequestBody LoanProductInfoReceiveDTO loanProductInfoReceiveDTO) {
        loanProductInfoService.addLoanProductInfo(loanProductInfoReceiveDTO);
        return Result.success("成功");
    }


    @PostMapping("/addLoanProduct")
    @ApiOperation(value = "添加产品配置")
    public Result addLoanProduct(@RequestBody LoanProductReceiveDTO loanProductReceiveDTO) {
        loanProductService.addProduct(loanProductReceiveDTO);
        return Result.success("成功");
    }


    @PostMapping("/getLoanProductInfoList")
    @ApiOperation(value = "获取产品信息列表")
    public Result getLoanProductInfoList(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam String title) {
        IPage<LoanProductInfoReturnDTO> loanProductInfoReturnDTOIPage = loanProductInfoService.getLoanProductInfoList(pageNum, pageSize, title);
        return Result.success(loanProductInfoReturnDTOIPage);
    }


    @PostMapping("/getLoanProductList")
    @ApiOperation(value = "获取产品列表")
    public Result getLoanProductList(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam String title) {
        IPage<LoanProductReturnDTO> loanProductIPage = loanProductService.getLoanProductList(pageNum, pageSize, title);
        return Result.success(loanProductIPage);
    }


    @PostMapping("/hiddenOrShowProduct")
    @ApiOperation(value = "隐藏或显示产品信息")
    public Result hiddenOrShowProduct(@RequestParam String productId, @RequestParam String isHide) {
        loanProductInfoService.hiddenOrShowProduct(productId, isHide);
        return Result.success("成功");
    }


    @PostMapping("/loanProductConfigParameter")
    @ApiOperation(value = "产品配置参数")
    public Result loanProductConfigParameter(@ModelAttribute LoanProductInfo loanProductInfo) {
        return loanProductService.loanProductConfigParameter(loanProductInfo);
    }

    @PostMapping("/getAllProducts")
    @ApiOperation(value = "获取产品信息列表（条件查询使用）")
    public Result getAllProducts() {
        return loanProductService.getAllProducts();
    }


    @PostMapping("/updateLoanProduct")
    @ApiOperation(value = "更新产品")
    public Result updateLoanProduct(@ModelAttribute LoanProductInfo loanProductInfo) {
        loanProductInfoService.updateLoanProduct(loanProductInfo);
        return Result.success("成功");
    }

    @PostMapping("/getAllClassifys")
    @ApiOperation(value = "获取产品分类列表（条件查询使用）")
    public Result getAllClassifys() {
        List<Map<String, String>> getAllClassifys = loanProductClassifyService.getAllClassifys();
        return Result.success(getAllClassifys);
    }


    @PostMapping("/getToken")
    @ApiOperation(value = "获取产品分类列表（条件查询使用）")
    public Result getToken(@RequestParam String bucket) {
        Result result = loanProductInfoService.uploadCredentials(bucket);
        return Result.success(result);
    }


}
