package com.yht.demo.entity.dto;

import lombok.Data;

import java.util.Date;

/**
 * 系统消息列表返回值
 */
@Data
public class SysMessageReturnDTO {
	/**
	 * 推送标题
	 */
	private String title;
	/**
	 * 推送内容
	 */
	private String content;
	/**
	 * 封面url
	 */
	private String icon;
	/**
	 * 项目外链url
	 */
	private String productUrl;
	/**
	 * 创建时间
	 */
	private Date createTime;


}
