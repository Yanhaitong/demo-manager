package com.yht.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yht.demo.entity.dto.AdvertisingAddDTO;
import com.yht.demo.entity.dto.AdvertisingReceiveDTO;
import com.yht.demo.entity.dto.AdvertisingUpdateDTO;
import com.yht.demo.entity.model.LoanProductAdvertising;
import com.yht.demo.mapper.LoanProductAdvertisingMapper;
import com.yht.demo.service.IAdvertisingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class AdvertisingServiceImpl implements IAdvertisingService {

    @Autowired
    private LoanProductAdvertisingMapper loanProductAdvertisingMapper;
    @Override
    public IPage<Map<String, String>> getAdvertisingList(AdvertisingReceiveDTO advertisingReceiveDTO) {
        Page page = new Page();
        page.setSize(advertisingReceiveDTO.getPageSize());
        page.setCurrent(advertisingReceiveDTO.getPageNum());
        IPage<Map<String, String>> list = loanProductAdvertisingMapper.getAdvertisingList(page, advertisingReceiveDTO);
        return list;
    }

    @Override
    public void addAdvertising(AdvertisingAddDTO advertisingAddDTO) {
        LoanProductAdvertising loanProductAdvertising = new LoanProductAdvertising();
        loanProductAdvertising.setProductInfoId(Integer.valueOf(advertisingAddDTO.getProductInfoId()));
        loanProductAdvertising.setLocation(Integer.valueOf(advertisingAddDTO.getLocation()));
        loanProductAdvertising.setCover(advertisingAddDTO.getImageUrl());
        loanProductAdvertising.setCreateTime(new Date());
        for (String clientName: advertisingAddDTO.getClientNames()) {
            loanProductAdvertising.setClientName(clientName);
            loanProductAdvertisingMapper.insert(loanProductAdvertising);
        }
    }

    @Override
    public void updateAdvertising(AdvertisingUpdateDTO advertisingUpdateDTO) {
        LoanProductAdvertising loanProductAdvertising = new LoanProductAdvertising();
        loanProductAdvertising.setProductInfoId(Integer.valueOf(advertisingUpdateDTO.getProductInfoId()));
        loanProductAdvertising.setLocation(Integer.valueOf(advertisingUpdateDTO.getLocation()));
        loanProductAdvertising.setClientName(advertisingUpdateDTO.getClientName());
        loanProductAdvertising.setCover(advertisingUpdateDTO.getImageUrl());
        loanProductAdvertising.setUpdateTime(new Date());
        loanProductAdvertising.setId(Integer.valueOf(advertisingUpdateDTO.getId()));
        loanProductAdvertisingMapper.updateById(loanProductAdvertising);
    }

    @Override
    public void deleteAdvertisingById(String id) {
        loanProductAdvertisingMapper.deleteAdvertisingById(id);
    }
}
