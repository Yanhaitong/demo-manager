package com.yht.demo.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 产品基础信息参数表
 * </p>
 *
 * @author
 * @since 2019-03-08
 */
@Data
public class LoanProductInfoReceiveDTO {

	@ApiModelProperty(name = "applyCondition", value = "申请条件", required = true)
	private String applyCondition;
	@ApiModelProperty(name = "applyNum", value = "申请人数", required = true)
	private String applyNum;
	@ApiModelProperty(name = "description", value = "产品描述", required = true)
	private String description;
	@ApiModelProperty(name = "explainLabel", value = "产品说明", required = true)
	private String explainLabel;
	@ApiModelProperty(name = "iconUrl", value = "图标链接地址", required = true)
	private String iconUrl;
	@ApiModelProperty(name = "interestRate", value = "贷款利率", required = true)
	private String interestRate;
	@ApiModelProperty(name = "interestRateType", value = "贷款利率类型（0:日利率 1:月利率 2:年利率", required = true)
	private Integer interestRateType;
	@ApiModelProperty(name = "loanAmountScope", value = "贷款金额范围", required = true)
	private String loanAmountScope;
	@ApiModelProperty(name = "loanTimeScope", value = "贷款期限范围", required = true)
	private String loanTimeScope;
	@ApiModelProperty(name = "name", value = "产品名称", required = true)
	private String name;
	@ApiModelProperty(name = "needDatum", value = "所需资料", required = true)
	private String needDatum;
	@ApiModelProperty(name = "obtainTime", value = "下款时间", required = true)
	private String obtainTime;
	@ApiModelProperty(name = "title", value = "产品标题", required = true)
	private String title;
	@ApiModelProperty(name = "url", value = "产品url", required = true)
	private String url;

}
