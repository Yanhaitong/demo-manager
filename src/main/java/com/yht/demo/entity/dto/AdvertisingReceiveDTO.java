package com.yht.demo.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "获取广告配置列表参数")
@Data
public class AdvertisingReceiveDTO {

	@ApiModelProperty(name = "productName", value = "产品名称", required = true)
	private String productName;

	@ApiModelProperty(name = "clientName", value = "客户端名称", required = true)
	private String clientName;

	@ApiModelProperty(name = "pageNum", value = "当前页数", required = true)
	private Integer pageNum;

	@ApiModelProperty(name = "pageSize", value = "每页数量", required = true)
	private Integer pageSize;


}
