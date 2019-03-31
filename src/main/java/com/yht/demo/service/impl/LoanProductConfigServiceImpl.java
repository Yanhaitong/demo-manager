package com.yht.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yht.demo.common.BaseService;
import com.yht.demo.common.Result;
import com.yht.demo.entity.dto.LoanProductConfigReceiveDTO;
import com.yht.demo.entity.dto.LoanProductConfigReturnDTO;
import com.yht.demo.entity.model.LoanProductConfig;
import com.yht.demo.mapper.LoanProductConfigMapper;
import com.yht.demo.service.ILoanProductConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LoanProductConfigServiceImpl extends BaseService implements ILoanProductConfigService {

	@Autowired
	private LoanProductConfigMapper loanProductConfigMapper;


	@Override
	public void addLoanProductConfig(LoanProductConfigReceiveDTO loanProductConfigReceiveDTO) {
		List<String> clientNames = loanProductConfigReceiveDTO.getClientNames();
		List<String> channelNames = loanProductConfigReceiveDTO.getChannelNames();
		LoanProductConfig loanProductConfig = new LoanProductConfig();
		loanProductConfig.setProductId(Integer.valueOf(loanProductConfigReceiveDTO.getProductInfoId()));
		loanProductConfig.setClassifyId(Integer.valueOf(loanProductConfigReceiveDTO.getClassifyId()));
		loanProductConfig.setIsRecommend(Integer.valueOf(loanProductConfigReceiveDTO.getRecommend()));
		loanProductConfig.setIsCarefullySelect(Integer.valueOf(loanProductConfigReceiveDTO.getCarefullySelect()));
		loanProductConfig.setIsLatestProduct(Integer.valueOf(loanProductConfigReceiveDTO.getLatestProduct()));
		loanProductConfig.setCreateTime(new Date());
		for (String clientName: clientNames) {
			for (String channelName: channelNames) {
				loanProductConfig.setClientName(clientName);
				loanProductConfig.setChannelName(channelName);
				loanProductConfigMapper.insert(loanProductConfig);
			}
		}
	}

	@Override
	public IPage<LoanProductConfigReturnDTO> getLoanProductConfigList(Integer pageNum, Integer pageSize, String title) {
		Page page = new Page();
		page.setCurrent(pageNum);
		page.setSize(pageSize);
		IPage<LoanProductConfigReturnDTO> loanProductConfigReturnDTOIPage = loanProductConfigMapper.getLoanProductConfigList(page, title);
		return loanProductConfigReturnDTOIPage;
	}

	@Override
	public void hiddenOrShowProduct(String productId, String isHide) {
		loanProductConfigMapper.hiddenOrShowProduct(productId, isHide);
	}

	@Override
	public Result loanProductConfigParameter() {
		return null;
	}

}