package com.yht.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.yht.demo.common.Constant;
import com.yht.demo.common.Result;
import com.yht.demo.entity.dto.LoanProductReceiveDTO;
import com.yht.demo.entity.dto.LoanProductReturnDTO;
import com.yht.demo.entity.model.LoanProduct;
import com.yht.demo.mapper.LoanProductMapper;
import com.yht.demo.service.ILoanProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoanProductServiceImpl implements ILoanProductService {

    @Autowired
    private LoanProductMapper loanProductMapper;

    @Override
    public void addLoanProduct(LoanProductReceiveDTO loanProductReceiveDTO) {
        LoanProduct loanProduct = JSON.parseObject(JSON.toJSONString(loanProductReceiveDTO), LoanProduct.class);
        loanProduct.setCreateTime(new Date());
        loanProductMapper.insert(loanProduct);
    }

    @Override
    public void updateLoanProduct(LoanProductReceiveDTO loanProductReceiveDTO) {
        LoanProduct loanProduct = JSON.parseObject(JSON.toJSONString(loanProductReceiveDTO), LoanProduct.class);
        loanProduct.setUpdateTime(new Date());
        loanProductMapper.updateById(loanProduct);
    }

    @Override
    public IPage<LoanProductReturnDTO> getLoanProductList(Integer pageNum, Integer pageSize, String title) {
        Page page = new Page();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        IPage<LoanProductReturnDTO> loanProductReturnDTOIPage = loanProductMapper.getLoanProductList(page, title);
        return loanProductReturnDTOIPage;
    }

    @Override
    public Result getAllProducts() {
        List<Map<String, String>> loanProductList = loanProductMapper.getAllProducts();
        return Result.success(loanProductList);
    }

    @Override
    public Result uploadCredentials(String bucket) {

        // 密钥配置
        Auth auth = Auth.create(Constant.QINIU_ACCESS_KEY, Constant.QINIU_SECRET_KEY);
        // 要上传的空间
        if (bucket == null || "".equals(bucket.trim())) {
            bucket = Constant.QINIU_ICON_BUCKET;
        }
        //上传到七牛后保存的文件名
        String key = bucket + "_" + System.currentTimeMillis() + ".png";
        //上传到七牛云的token
        String token = auth.uploadToken("app_package", key, 300, new StringMap());
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("key", key);
        return Result.success(map);
    }
}
