package com.oceansoft.szga.smp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.mapper.XCJYMapper;
import com.oceansoft.szga.smp.service.XCJYService;
import com.oceansoft.szga.smp.service.impl.XCJYServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author ：pc
 * @date ：Created in 2020/4/21 10:22
 * @description： 宣传教育
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping({"xcjy"})
public class XCJYController {

    @Autowired
    private XCJYService xcjyService;

    /**
     * 统计 基础信息
     * @author pc
     * @return 数据
     */
    @PostMapping("totalNum")
    public Object totalNum(@RequestBody JSONObject json){
        String param = json.getString("param");
        String start = json.getString("start");
        String end = json.getString("end");
        ApiResult apiResult = xcjyService.totalNum(param,start,end);
        return apiResult;
    }
    /**
     * 统计 基础信息
     * @author pc
     * @return 数据
     */
   @PostMapping("JCDSNum")
    public ApiResult JCDSNum(@RequestBody JSONObject json){
        String param = json.getString("param");
        String start = json.getString("start");
        String end = json.getString("end");
        ApiResult apiResult = xcjyService.JCDSNum(param,start,end);
        return apiResult;
    }

     /**
     * 单位宣传进度完成情况
     * @author pc
     * @return 数据
     */
    @PostMapping("Unitpublicity")
    public ApiResult Unitpublicity(@RequestBody JSONObject json){
        String param = json.getString("param");
        String start = json.getString("start");
        String end = json.getString("end");
        ApiResult apiResult = xcjyService.Unitpublicity(param,start,end);
        return apiResult;
    }

    /**
     * 八进宣传任务
     * @author pc
     * @return 数据
     */
    @PostMapping("PublicityTasks")
    public ApiResult PublicityTasks(@RequestBody JSONObject json){
        String param = json.getString("param");
        String start = json.getString("start");
        String end = json.getString("end");
        String dd=json.getString("dd");
        ApiResult apiResult = xcjyService.PublicityTasks(param,start,end,dd);
        return apiResult;
    }

    /**
     * 民警宣传率
     * @author pc
     * @return 数据
     */
    @PostMapping("PromotionalRate")
    public ApiResult PromotionalRate(@RequestBody JSONObject json){
        String param = json.getString("param");
        String start = json.getString("start");
        String end = json.getString("end");
        String dd=json.getString("dd");
        ApiResult apiResult = xcjyService.PromotionalRate(param,start,end,dd);
        return apiResult;
    }

    /**
     * 获取大队名称列表
     * @author pc
     * @return 数据
     */
    @PostMapping("DDMC")
    public ApiResult DDMC(){
        ApiResult apiResult = xcjyService.DDMC();
        return apiResult;
    }

}
