package com.yht.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yht.demo.entity.dto.H5RegisterInfoReceiveDTO;
import com.yht.demo.entity.dto.UvStatisticsReceiveDTO;
import com.yht.demo.entity.dto.UvStatisticsReturnDTO;
import com.yht.demo.entity.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author 
 * @since 2019-03-02
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    IPage<UvStatisticsReturnDTO> getH5UserRegster(@Param("page") Page page, @Param("h5RegisterInfoReceiveDTO") H5RegisterInfoReceiveDTO h5RegisterInfoReceiveDTO);

    IPage<Map> getLoginRegisterInfo(@Param("page") Page page, @Param("uvStatisticsReceiveDTO") UvStatisticsReceiveDTO uvStatisticsReceiveDTO);
}
