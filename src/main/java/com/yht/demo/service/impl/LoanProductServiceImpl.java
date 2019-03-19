package com.yht.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yht.demo.common.BaseService;
import com.yht.demo.common.Result;
import com.yht.demo.entity.dto.LoanProductReceiveDTO;
import com.yht.demo.entity.dto.LoanProductReturnDTO;
import com.yht.demo.entity.model.LoanProduct;
import com.yht.demo.entity.model.LoanProductInfo;
import com.yht.demo.mapper.*;
import com.yht.demo.service.ILoanProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoanProductServiceImpl extends BaseService implements ILoanProductService {

	@Autowired
	private ChannelMapper channelMapper;
	@Autowired
	private ClientMapper clientMapper;
	@Autowired
	private LoanProductClassifyMapper loanProductClassifyMapper;
	@Autowired
	private LoanProductInfoMapper loanProductInfoMapper;
	@Autowired
	private LoanProductMapper loanProductMapper;

	@Override
	public void addProduct(LoanProductReceiveDTO loanProductReceiveDTO) {

		List<String> clientNames = loanProductReceiveDTO.getClientNames();
		List<String> channelNames = loanProductReceiveDTO.getChannelNames();

		LoanProduct loanProduct = new LoanProduct();
		loanProduct.setClassifyId(Integer.valueOf(loanProductReceiveDTO.getClassifyId()));
		loanProduct.setIsRecommend(Integer.valueOf(loanProductReceiveDTO.getIsRecommend()));
		loanProduct.setIsCarefullySelect(Integer.valueOf(loanProductReceiveDTO.getIsCarefullySelect()));
		loanProduct.setIsLatestProduct(Integer.valueOf(loanProductReceiveDTO.getIsLatestProduct()));
		loanProduct.setCreateTime(new Date());
		for (String clientName: clientNames) {
			for (String channelName: channelNames) {
				loanProduct.setClientName(clientName);
				loanProduct.setChannelName(channelName);
				loanProductMapper.insert(loanProduct);
			}
		}
	}


	@Override
	public IPage<LoanProductReturnDTO> getLoanProductList(Integer pageNum, Integer pageSize, String title) {
		Page page = new Page();
		page.setCurrent(pageNum);
		page.setSize(pageSize);
		IPage<LoanProductReturnDTO> loanProductIPage = loanProductMapper.getLoanProductList(page, title);
		return loanProductIPage;
	}


	@Override
	public Result loanProductConfigParameter(LoanProductInfo loanProductInfo) {
		List<Map<String, String>> loanProductList = loanProductInfoMapper.getAllProducts();
		List<String> clientList = clientMapper.getAllClients();
		List<String> channelList = channelMapper.getAllChannels();
		List<Map<String, String>> classifysList = loanProductClassifyMapper.getAllClassifys();
		Map<String, Object> map = new HashMap<>();
		map.put("loanProductList", loanProductList);
		map.put("clientList", clientList);
		map.put("channelList", channelList);
		map.put("classifysList", classifysList);
		return Result.success(map);
	}


}
