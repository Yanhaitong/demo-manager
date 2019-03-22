package com.yht.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
public interface IClientService {

    void addClient(String clientName, String type);

    IPage<Map<String, String>> getClientList(Integer pageNum, Integer pageSize, String clientName);

    void updateClient(String id, String clientName);

    List<String> getAllClients();
}
