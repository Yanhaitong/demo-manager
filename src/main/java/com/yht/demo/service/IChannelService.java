package com.yht.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
public interface IChannelService {

    void addChannel(String channelName);

    IPage<Map<String, String>> getChannelList(Integer pageNum, Integer pageSize, String channelName);

    void updateChannel(String id, String channelName);

    List<String> getAllChannels();
}
