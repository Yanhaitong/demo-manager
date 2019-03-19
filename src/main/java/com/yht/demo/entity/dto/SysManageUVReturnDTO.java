package com.yht.demo.entity.dto;

import lombok.Data;

/**
 * 后台管理H5推广UV统计返回值
 */
@Data
public class SysManageUVReturnDTO {

    /**
     * 日期
     */
    private String date;
    /**
     * 注册数量
     */
    private String count;


}