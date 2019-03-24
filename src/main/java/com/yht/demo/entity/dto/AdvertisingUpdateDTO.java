package com.yht.demo.entity.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(value = "获取广告配参数")
@Data
public class AdvertisingUpdateDTO {

	/**
	 * 广告id
	 */
	private String id;
	/**
	 * 产品信息id
	 */
	private String productInfoId;
	/**
	 * 广告位置
	 */
	private String type;
	/**
	 * 客户端名称
	 */
	private String clientName;




}
