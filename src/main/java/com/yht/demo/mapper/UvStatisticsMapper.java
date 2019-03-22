package com.yht.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yht.demo.entity.dto.UvStatisticsReceiveDTO;
import com.yht.demo.entity.model.UvStatistics;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 * UV统计表 Mapper 接口
 * </p>
 *
 * @author 
 * @since 2019-03-06
 */
public interface UvStatisticsMapper extends BaseMapper<UvStatistics> {
    
    IPage<Map> getUVClickCount(@Param("page") Page page, @Param("uvStatisticsReceiveDTO") UvStatisticsReceiveDTO uvStatisticsReceiveDTO);
}
