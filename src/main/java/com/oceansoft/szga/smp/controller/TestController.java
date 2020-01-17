package com.oceansoft.szga.smp.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.oceansoft.szga.smp.config.domain.ApiPager;
import com.oceansoft.szga.smp.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zhangxh
 * @create 2020/1/14
 * @email zhangxh@oceansoft.com.cn
 */
@RestController
public class TestController{
    @Autowired
    private TestMapper mapper;
    @GetMapping("test")
    public Object test(){
        PageHelper.startPage(1, 20, true);
        Page<Map<String,Object>> page = (Page)mapper.list();
        ApiPager<Map<String,Object>> pager = new ApiPager(20, 1, page.getTotal(), page.getResult());
        return pager;
    }
}
