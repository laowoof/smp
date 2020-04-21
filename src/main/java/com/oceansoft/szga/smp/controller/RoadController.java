package com.oceansoft.szga.smp.controller;

import com.alibaba.fastjson.JSONObject;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.service.RoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
