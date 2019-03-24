package com.yht.demo.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClientResutnDTO {

	/**
	 * 客户端名称
	 */
	private String clientName;
	/**
	 * 客户端类型
	 */
	private String type;

}
