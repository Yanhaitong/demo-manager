package com.yht.demo.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 后台管理APPUV统计返回值
 */
@Data
public class UvStatisticsReturnDTO {


	@ApiModelProperty(name = "date", value = "日期", required = true)
	private String date;

	@ApiModelProperty(name = "productName", value = "产品名称", required = true)
	private String productName;

	@ApiModelProperty(name = "appRegisterCount", value = "APP注册", required = true)
	private String appRegisterCount;

	@ApiModelProperty(name = "appLoginCount", value = "APP登录", required = true)
	private String appLoginCount;

	@ApiModelProperty(name = "clickUVCount", value = "产品点击UV", required = true)
	private String clickUVCount;

}