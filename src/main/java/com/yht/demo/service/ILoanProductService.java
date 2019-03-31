package com.yht.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yht.demo.common.Result;
import com.yht.demo.entity.dto.LoanProductReturnDTO;
import com.yht.demo.entity.dto.LoanProductReceiveDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ILoanProductService {

    void addLoanProduct(LoanProductReceiveDTO loanProductReceiveDTO);

    void updateLoanProduct(LoanProductReceiveDTO loanProductReceiveDTO);

    IPage<LoanProductReturnDTO> getLoanProductList(Integer pageNum, Integer pageSize, String title);

    Result getAllProducts();

    Result uploadCredentials(String bucket);

    void hiddenProduct(String productId, String isHide);
}
