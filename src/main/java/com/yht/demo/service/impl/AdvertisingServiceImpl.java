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
    public IPage<Map<String, Object>> getAdvertisingList(AdvertisingReceiveDTO advertisingReceiveDTO) {
        Page page = new Page();
        page.setSize(advertisingReceiveDTO.getPageSize());
        page.setCurrent(advertisingReceiveDTO.getPageNum());
        IPage<Map<String, Object>> list = loanProductAdvertisingMapper.getAdvertisingList(page, advertisingReceiveDTO);
        return list;
    }

    @Override
    public void addAdvertising(AdvertisingAddDTO advertisingAddDTO) {
        LoanProductAdvertising loanProductAdvertising = new LoanProductAdvertising();
        loanProductAdvertising.setProductInfoId(Integer.valueOf(advertisingAddDTO.getProductInfoId()));
        loanProductAdvertising.setType(Integer.valueOf(advertisingAddDTO.getType()));
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
        loanProductAdvertising.setType(Integer.valueOf(advertisingUpdateDTO.getType()));
        loanProductAdvertising.setClientName(advertisingUpdateDTO.getClientName());
        loanProductAdvertising.setUpdateTime(new Date());
        loanProductAdvertising.setId(Integer.valueOf(advertisingUpdateDTO.getId()));
        loanProductAdvertisingMapper.updateById(loanProductAdvertising);
    }

    @Override
    public void deleteAdvertisingById(String id) {
        loanProductAdvertisingMapper.deleteAdvertisingById(id);
    }
}
