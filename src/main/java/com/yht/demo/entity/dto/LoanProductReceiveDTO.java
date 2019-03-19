package com.yht.demo.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * 产品配置参数
 */
@Data
public class LoanProductReceiveDTO {

    /**
     * 产品信息id
     */
    private String productInfoId;
    /**
     * 产品分类id
     */
    private String classifyId;
    /**
     * 客户端名称（多个）
     */
    private List<String> clientNames;
    /**
     * 渠道名称（多个）
     */
    private List<String> channelNames;
    /**
     * 是否推荐
     */
    private String isRecommend;
    /**
     * 是否精选
     */
    private String isCarefullySelect;
    /**
     * 是否最新
     */
    private String isLatestProduct;


}
