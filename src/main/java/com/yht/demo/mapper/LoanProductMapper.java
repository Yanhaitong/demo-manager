package com.yht.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yht.demo.entity.dto.LoanProductReturnDTO;
import com.yht.demo.entity.model.LoanProduct;

/**
 * <p>
 * 产品配置表 Mapper 接口
 * </p>
 *
 * @author
 * @since 2019-03-02
 */
public interface LoanProductMapper extends BaseMapper<LoanProduct> {

	IPage<LoanProductReturnDTO> getLoanProductList(Page page);


}
