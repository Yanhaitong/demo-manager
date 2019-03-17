package com.yht.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yht.demo.entity.model.Channel;
import com.yht.demo.mapper.ChannelMapper;
import com.yht.demo.service.IChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class ChannelServiceImpl implements IChannelService {

    @Autowired
    private ChannelMapper channelMapper;

    @Override
    public void addChannel(String channelName) {
        Channel channel = new Channel();
        channel.setName(channelName);
        channel.setCreateTime(new Date());
        channelMapper.insert(channel);
    }

    @Override
    public IPage<Map<String, String>> getChannelList(Integer pageNum, Integer pageSize) {
        Page page = new Page();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        IPage<Map<String, String>> channelList = channelMapper.getChannelList(page);
        return channelList;
    }
}
