package com.yht.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yht.demo.entity.model.Client;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 客户端表 Mapper 接口
 * </p>
 *
 * @author
 * @since 2019-03-02
 */
@Repository
public interface ClientMapper extends BaseMapper<Client> {

	List<String> getAllClients();


	IPage<Map<String, String>> getClientList(IPage page);


}
