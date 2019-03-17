package com.yht.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yht.demo.entity.model.Client;
import com.yht.demo.mapper.ClientMapper;
import com.yht.demo.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	private ClientMapper clientMapper;

	@Override
	public void addClient(String clientName, String type) {
		Client client = new Client();
		client.setName(clientName);
		client.setType(Integer.valueOf(type));
		client.setCreateTime(new Date());
		clientMapper.insert(client);
	}


	@Override
	public IPage<Map<String, String>> getClientList(Integer pageNum, Integer pageSize) {
		Page page = new Page();
		page.setCurrent(pageNum);
		page.setSize(pageSize);
		IPage<Map<String, String>> clientList = clientMapper.getClientList(page);
		return clientList;
	}


}
