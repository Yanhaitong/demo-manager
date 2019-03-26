package com.yht.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yht.demo.entity.dto.AdvertisingAddDTO;
import com.yht.demo.entity.dto.AdvertisingReceiveDTO;
import com.yht.demo.entity.dto.AdvertisingUpdateDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Transactional
public interface IAdvertisingService {

    IPage<Map<String, String>> getAdvertisingList(AdvertisingReceiveDTO advertisingReceiveDTO);

    void addAdvertising(AdvertisingAddDTO advertisingParameterDTO);

    void updateAdvertising(AdvertisingUpdateDTO advertisingUpdateDTO);

    void deleteAdvertisingById(String id);
}
