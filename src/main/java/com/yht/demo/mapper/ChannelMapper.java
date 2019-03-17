package com.yht.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yht.demo.entity.model.Channel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 渠道表 Mapper 接口
 * </p>
 *
 * @author
 * @since 2019-03-02
 */
@Repository
public interface ChannelMapper extends BaseMapper<Channel> {

	List<String> getAllChannels();


	IPage<Map<String, String>> getChannelList(Page page);


}
