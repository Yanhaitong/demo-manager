package com.yht.demo.service;

import com.yht.demo.entity.dto.PushMessageReceiveDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ISystemMessageService {

    void pushSystemMessage(PushMessageReceiveDTO pushMessageReceiveDTO);

}
