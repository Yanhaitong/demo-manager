package com.yht.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yht.demo.entity.dto.AdvertisingReceiveDTO;
import com.yht.demo.entity.model.LoanProductAdvertising;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 * 产品广告配置表 Mapper 接口
 * </p>
 *
 * @author
 * @since 2019-03-08
 */
public interface LoanProductAdvertisingMapper extends BaseMapper<LoanProductAdvertising> {

    IPage<Map<String, String>> getAdvertisingList(@Param("page") Page page, @Param("advertisingReceiveDTO")AdvertisingReceiveDTO advertisingReceiveDTO);

    void deleteAdvertisingById(String id);
}
