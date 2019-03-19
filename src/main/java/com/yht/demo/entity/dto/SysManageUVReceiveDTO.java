package com.yht.demo.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 后台管理查询appUV统计参数
 */
@Data
public class SysManageUVReceiveDTO {

    @ApiModelProperty(name = "startTime", value = "开始时间", required = false)
    private String startTime;
    @ApiModelProperty(name = "endTime", value = "结束时间", required = false)
    private String endTime;
    @ApiModelProperty(name = "clientName", value = "客户端名称", required = false)
    private String clientName;
    @ApiModelProperty(name = "channelName", value = "渠道名称", required = false)
    private String channelName;
    @ApiModelProperty(name = "pageNum", value = "当前页数", required = true)
    private Integer pageNum;
    @ApiModelProperty(name = "pageSize", value = "每页数量", required = true)
    private Integer pageSize;

}