package com.yht.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yht.demo.common.Result;
import com.yht.demo.entity.dto.LoanProductConfigReceiveDTO;
import com.yht.demo.entity.dto.LoanProductConfigReturnDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ILoanProductConfigService {

    void addLoanProductConfig(LoanProductConfigReceiveDTO loanProductConfigReceiveDTO);

    IPage<LoanProductConfigReturnDTO> getLoanProductConfigList(Integer pageNum, Integer pageSize, String title);

    void hiddenOrShowProduct(String productId, String isHide);

    Result loanProductConfigParameter();
}
