package com.yht.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yht.demo.common.Result;
import com.yht.demo.entity.dto.LoanProductReceiveDTO;
import com.yht.demo.entity.dto.LoanProductReturnDTO;
import com.yht.demo.entity.model.LoanProduct;
import com.yht.demo.entity.model.LoanProductInfo;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ILoanProductService {

    void addProduct(LoanProductReceiveDTO loanProductReceiveDTO);


    IPage<LoanProductReturnDTO> getLoanProductList(Integer pageNum, Integer pageSize, String title);


    Result loanProductConfigParameter(LoanProductInfo loanProductInfo);


    Result getAllProducts();
}
