package com.yht.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yht.demo.common.BaseController;
import com.yht.demo.common.Result;
import com.yht.demo.entity.dto.LoanProductReceiveDTO;
import com.yht.demo.entity.dto.LoanProductReturnDTO;
import com.yht.demo.service.ILoanProductClassifyService;
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
    private ILoanProductService loanProductService;
    @Autowired
    private ILoanProductClassifyService loanProductClassifyService;


    @PostMapping("/addLoanProduct")
    @ApiOperation(value = "新增产品")
    public Result addLoanProduct(@RequestBody LoanProductReceiveDTO loanProductReceiveDTO) {
        loanProductService.addLoanProduct(loanProductReceiveDTO);
        return Result.success("成功");
    }

    @PostMapping("/updateLoanProduct")
    @ApiOperation(value = "更新产品")
    public Result updateLoanProduct(@RequestBody LoanProductReceiveDTO loanProductReceiveDTO) {
        loanProductService.updateLoanProduct(loanProductReceiveDTO);
        return Result.success("成功");
    }

    @PostMapping("/getLoanProductList")
    @ApiOperation(value = "获取产品列表")
    public Result getLoanProductList(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam String title) {
        IPage<LoanProductReturnDTO> loanProductReturnDTOIPage = loanProductService.getLoanProductList(pageNum, pageSize, title);
        return Result.success(loanProductReturnDTOIPage);
    }

    @PostMapping("/getAllProducts")
    @ApiOperation(value = "获取产品信息列表（条件查询使用）")
    public Result getAllProducts() {
        return loanProductService.getAllProducts();
    }

    @PostMapping("/getAllClassifys")
    @ApiOperation(value = "获取产品分类列表（条件查询使用）")
    public Result getAllClassifys() {
        List<Map<String, String>> getAllClassifys = loanProductClassifyService.getAllClassifys();
        return Result.success(getAllClassifys);
    }

    @PostMapping("/getUpLoadToken")
    @ApiOperation(value = "获取产品分类列表（条件查询使用）")
    public Result getUpLoadToken(@RequestParam String bucketName) {
        Result result = loanProductService.uploadCredentials(bucketName);
        return Result.success(result);
    }

}
