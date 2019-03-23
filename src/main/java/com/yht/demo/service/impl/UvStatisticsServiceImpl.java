package com.yht.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yht.demo.common.BaseService;
import com.yht.demo.common.Result;
import com.yht.demo.entity.dto.UvStatisticsReceiveDTO;
import com.yht.demo.mapper.UserMapper;
import com.yht.demo.mapper.UvStatisticsMapper;
import com.yht.demo.service.IUvStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Service
public class UvStatisticsServiceImpl extends BaseService implements IUvStatisticsService {


    @Autowired
    private UvStatisticsMapper uvStatisticsMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result getAPPUVInfo(UvStatisticsReceiveDTO uvStatisticsReceiveDTO) {
        Page page = new Page();
        page.setSize(uvStatisticsReceiveDTO.getPageSize());
        page.setCurrent(uvStatisticsReceiveDTO.getPageNum());
        if (!StringUtils.isEmpty(uvStatisticsReceiveDTO.getEndTime())){
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date sDate = sdf.parse(uvStatisticsReceiveDTO.getEndTime());
                Calendar c = Calendar.getInstance();
                c.setTime(sDate);
                c.add(Calendar.DAY_OF_MONTH, 1);
                sDate = c.getTime();
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                uvStatisticsReceiveDTO.setEndTime(sdf1.format(sDate));
            }catch (Exception e){
                log.error("日期加一天========" + e.getMessage());
            }
        }
        //uv点击数
        IPage<Map> list = uvStatisticsMapper.getUVClickCount(page, uvStatisticsReceiveDTO);
        return Result.success(list);
    }

    @Override
    public Result getLoginRegisterInfo(UvStatisticsReceiveDTO uvStatisticsReceiveDTO) {
        Page page = new Page();
        page.setSize(uvStatisticsReceiveDTO.getPageSize());
        page.setCurrent(uvStatisticsReceiveDTO.getPageNum());
        //用户登录注册统计
        IPage<Map> list = userMapper.getLoginRegisterInfo(page, uvStatisticsReceiveDTO);

        return Result.success(list);
    }
}
