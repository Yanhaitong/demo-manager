package com.yht.demo.entity.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@ApiModel(value = "获取广告配参数")
@Data
public class AdvertisingAddDTO {

	/**
	 * 产品信息id
	 */
	private String productInfoId;
	/**
	 * 广告位置
	 */
	private String type;
	/**
	 * 客户端名称（多个）
	 */
	private List<String> clientNames;




}
