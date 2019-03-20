package com.yht.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yht.demo.common.Result;
import com.yht.demo.entity.dto.LoanProductInfoReceiveDTO;
import com.yht.demo.entity.dto.LoanProductInfoReturnDTO;
import com.yht.demo.entity.model.LoanProductInfo;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ILoanProductInfoService {

    void addLoanProductInfo(LoanProductInfoReceiveDTO loanProductInfoReceiveDTO);


    IPage<LoanProductInfoReturnDTO> getLoanProductInfoList(Integer pageNum, Integer pageSize, String title);


    void hiddenOrShowProduct(String productId, String isHide);


    void updateLoanProduct(LoanProductInfo loanProductInfo);


    Result uploadCredentials(String bucket);


}
