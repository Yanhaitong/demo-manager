package com.yht.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yht.demo.entity.dto.LoanProductReturnDTO;
import com.yht.demo.entity.model.LoanProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 基础产品表 Mapper 接口
 * </p>
 *
 * @author
 * @since 2019-03-02
 */
@Repository
public interface LoanProductMapper extends BaseMapper<LoanProduct> {

	List<Map<String, String>> getAllProducts();

	IPage<LoanProductReturnDTO> getLoanProductList(@Param("page") Page page, @Param("title") String title);

}
