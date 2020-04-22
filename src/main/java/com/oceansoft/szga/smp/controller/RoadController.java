package com.oceansoft.szga.smp.controller;

import com.alibaba.fastjson.JSONObject;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.service.RoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import java.util.HashMap;

/**
 * @author  wzj
 * @date  2020/4/20
 */
@RestController
@RequestMapping({"road"})
public class RoadController {
    @Autowired
    private RoadService roadService;


    @GetMapping("test")
    public ApiResult test(){
        ApiResult data = roadService.test();
        return data;
    }
    /**
     * 数据统计
     * @author wzj
     * @return 数据
     * @param map
     */
    @PostMapping("anTotleNum")
    public ApiResult anTotleNum(@RequestBody Map map){
        ApiResult data = roadService.anTotleNum(map);
        return data;
    }
    /**
     * 各大队隐患处理情况分析
     * @author wzj
     * @return 数据
     * @param map
     */
    @PostMapping("yhQusFx/{type}")
    public ApiResult yhQusFx(@PathVariable("type") String type,@RequestBody Map map){
        ApiResult data = roadService.yhQusFx(type,map);
        return data;
    }

    /**
     * 重要节点分析
     * @author wzj
     * @return 数据
     * @param map
     */
    @PostMapping("zyJdFx")
    public ApiResult zyJdFx(@RequestBody Map map){
        ApiResult data = roadService.zyJdFx(map);
        return data;
    }

    /**
     * 隐患类型分析
     * @author wzj
     * @return 数据
     * @param map
     */
    @PostMapping("yhLxFx")
    public ApiResult yhLxFx(@RequestBody Map map){
        ApiResult data = roadService.yhLxFx(map);
        return data;
    }

    @GetMapping("getAddress")
    public ApiResult getAddresses(){
        return roadService.getAddress();
    }

    @PostMapping("getSourceSum")
    @ResponseBody
    public ApiResult getSourceSum(@RequestBody JSONObject json){
        HashMap result = roadService.getSourceSum(json);
        return new ApiResult().success(200, "获取数据成功!", result);
    }

    @PostMapping("getFirmAnalzeSum")
    @ResponseBody
    public ApiResult getFirmAnalzeSum(@RequestBody JSONObject json){
        return roadService.getFirmAnalzeSum(json);

    }

    @PostMapping("getAchievCount")
    @ResponseBody
    public ApiResult getAchievCount(@RequestBody JSONObject json){
        return roadService.getAchievCount(json);

    }
}
