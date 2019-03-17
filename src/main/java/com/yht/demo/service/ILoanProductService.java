package com.yht.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yht.demo.common.Result;
import com.yht.demo.entity.dto.LoanProductReturnDTO;
import com.yht.demo.entity.model.LoanProduct;
import com.yht.demo.entity.model.LoanProductInfo;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ILoanProductService {

	void addProduct(LoanProduct loanProduct);


	IPage<LoanProductReturnDTO> getLoanProductList(Integer pageNum, Integer pageSize);


	Result loanProductConfigParameter(LoanProductInfo loanProductInfo);


}
