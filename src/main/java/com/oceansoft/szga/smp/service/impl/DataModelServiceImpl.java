package com.oceansoft.szga.smp.service.impl;

//import com.baomidou.mybatisplus.plugins.Page;

import com.baomidou.mybatisplus.plugins.Page;
import com.oceansoft.szga.smp.config.domain.ApiPager;
import com.oceansoft.szga.smp.config.domain.ApiQueryBase;
import com.oceansoft.szga.smp.mapper.DataModelMapper;
import com.oceansoft.szga.smp.service.DataModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/*
 * @author  zhangxh
 * @date  2020/7/22 10:24
 * @Email:zhangxh@oceansoft.com.cn
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DataModelServiceImpl implements DataModelService {
    @Autowired
    private DataModelMapper mapper;

    @Override
    public ApiPager pageJjaj(ApiQueryBase query) {

//        PageHelper.startPage(query.getPi(), query.getPs(), true);
//        Page<Map<String,Object>> page = (Page)mapper.selectPageJjaj(query);
//        return new ApiPager(query.getPs(), query.getPi(), page.getTotal(), page.getResult());

        Page<Map<String, Object>> page = new Page<>(query.getPi(), query.getPs());
        page.setRecords(mapper.selectPageJjaj(page, query));
        return new ApiPager<>(query.getPs(), query.getPi(), page.getTotal(), page.getRecords());
    }

    @Override
    public ApiPager pageWxjs(ApiQueryBase query) {
//        PageHelper.startPage(query.getPi(), query.getPs(), true);
//        Page<Map<String,Object>> page = (Page)mapper.selectPageWxjs(query);
//        return new ApiPager(query.getPs(), query.getPi(), page.getTotal(), page.getResult());
        Page<Map<String, Object>> page = new Page<>(query.getPi(), query.getPs());
        page.setRecords(mapper.selectPageWxjs(page, query));
        return new ApiPager<>(query.getPs(), query.getPi(), page.getTotal(), page.getRecords());
    }
}
