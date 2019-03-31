package com.yht.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yht.demo.entity.dto.LoanProductConfigReturnDTO;
import com.yht.demo.entity.model.LoanProductConfig;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 产品配置表 Mapper 接口
 * </p>
 *
 * @author
 * @since 2019-03-02
 */
public interface LoanProductConfigMapper extends BaseMapper<LoanProductConfig> {

	IPage<LoanProductConfigReturnDTO> getLoanProductConfigList(@Param("page") Page page, @Param("title") String title);

	void hiddenOrShowProduct(String productId, String isHide);
}
