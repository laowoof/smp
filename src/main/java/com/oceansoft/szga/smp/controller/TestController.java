package com.oceansoft.szga.smp.controller;

import com.alibaba.fastjson.JSON;
//import com.github.pagehelper.Page;
//import com.github.pagehelper.PageHelper;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.oceansoft.szga.smp.config.domain.ApiPager;
import com.oceansoft.szga.smp.config.domain.ApiQueryBase;
import com.oceansoft.szga.smp.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping("test")
    public Object test(@RequestParam String type){
        System.out.println(type);
//        PageHelper.startPage(1, 20, true);
//        Page<Map<String,Object>> page = (Page)mapper.list();
//        ApiPager<Map<String,Object>> pager = new ApiPager(20, 1, page.getTotal(), page.getResult());
//        return pager;
        return "";
    }
    @RequestMapping("test1")
    public String test1(ApiQueryBase query){
       return JSON.toJSONString(query);
    }

    @RequestMapping("test2")
    public String test2(){
        return JSON.toJSONString(mapper.test());
    }

    @RequestMapping("test3")
    public JSONObject test3(@RequestBody JSONObject json){
        return json;
    }

}
