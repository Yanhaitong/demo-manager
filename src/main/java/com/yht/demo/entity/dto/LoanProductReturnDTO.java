package com.yht.demo.entity.dto;

import lombok.Data;

/**
 * UV统计返回值
 */
@Data
public class LoanProductReturnDTO {

    /**
     * 产品id
     */
    private String id;
    /**
     * 渠道名称
     */
    private String channelName;
    /**
     * 客户端名称
     */
    private String clientName;
    /**
     * 产品名称
     */
    private String name;
    /**
     * 分类标题
     */
    private String title;
    /**
     * 推荐
     */
    private String recommend;
    /**
     * 精选
     */
    private String carefullySelect;
    /**
     * 最新
     */
    private String latestProduct;


}
