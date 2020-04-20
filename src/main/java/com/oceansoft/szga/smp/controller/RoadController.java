package com.oceansoft.szga.smp.controller;

import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.service.RoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
