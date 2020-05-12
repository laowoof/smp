package com.oceansoft.szga.smp.controller;

import com.alibaba.fastjson.JSONObject;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.service.DLAQTJService;
import com.oceansoft.szga.smp.util.ParamUtils;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author ：pc
 * @date ：Created in 2020/4/24 14:54
 * @description：接收 统计分析/道路安全统计分析
 * @modified By：
 * @version: 1.0.0$
 */
@RestController
@RequestMapping({"DLAQTJ"})
public class DLAQTJController {

    @Autowired
    private DLAQTJService dlaqtjService;

    /**
     * 源头底数统计
     * @param json
     */
    @PostMapping("YTDSTJ")
    public ApiResult YTDSTJ(@RequestBody JSONObject json){
        String param = json.getString("param");
        String date = json.getString("date");
        ApiResult apiResult = dlaqtjService.YTDSTJ(param,date);
        return  apiResult;
    }


    /**
     * 源头任务统计
     * @param json
     */
    @PostMapping("YTRWTJ")
    public ApiResult YTRWTJ(@RequestBody JSONObject json){
        String param = json.getString("param");
        String choiceDate = json.getString("choiceDate");
        ApiResult apiResult = dlaqtjService.YTRWTJ(param,choiceDate);
        return  apiResult;
    }

    /**
     * 源头任务统计 子项
     * @param json
     */
    @PostMapping("YTRWTJZX")
    public ApiResult YTRWTJZX(@RequestBody JSONObject json){
        String param = json.getString("param");
        String choiceDate = json.getString("choiceDate");
        String name=json.getString("name");
        ApiResult apiResult = dlaqtjService.YTRWTJZX(param,choiceDate,name);
        return  apiResult;
    }


    /**
     *  隐患完成情况统计
     * @param json
     */
    @PostMapping("YHWCQKTJ")
    public ApiResult YHWCQKTJ(@RequestBody JSONObject json){
        String param = json.getString("param");
        String choiceDate = json.getString("choiceDate");
        String status=json.getString("status");
        ApiResult apiResult = dlaqtjService.YHWCQKTJ(param, choiceDate, status);
        return  apiResult;
    }

    /**
     *  隐患完成情况统计 子项
     * @param json
     */
    @PostMapping("YHWCQKTJZX")
    public ApiResult YHWCQKTJZX(@RequestBody JSONObject json){
        String param = json.getString("param");
        String choiceDate = json.getString("choiceDate");
        String status=json.getString("status");
        String name=json.getString("name");
        ApiResult apiResult = dlaqtjService.YHWCQKTJZX(param, choiceDate, status, name);
        return  apiResult;
    }


    /**
     *  隐患类型统计
     * @param json
     */
    @PostMapping("YHLXTJ")
    public ApiResult YHLXTJ(@RequestBody JSONObject json){
        String param = json.getString("param");
        String choiceDate = json.getString("choiceDate");
        String status=json.getString("status");
        ApiResult apiResult = dlaqtjService.YHLXTJ(param, choiceDate, status);
        return  apiResult;
    }

    /**
     *  八进宣传统计
     * @param json
     */
    @PostMapping("BJXCTJ")
    public ApiResult BJXCTJ(@RequestBody JSONObject json){
        String param = json.getString("param");
        String start = json.getString("start");
        String end=json.getString("end");
        ApiResult apiResult = dlaqtjService.BJXCTJ(param, start, end);
        return  apiResult;
    }

    /**
     *  八进宣传统计 子项
     * @param json
     */
    @PostMapping("BJXCTJZX")
    public ApiResult BJXCTJZX(@RequestBody JSONObject json){
        String param = json.getString("param");
        String start = json.getString("start");
        String end=json.getString("end");
        String name=json.getString("name");
        ApiResult apiResult = dlaqtjService.BJXCTJZX(param, start, end,name);
        return  apiResult;
    }

    /**
     *  单位重点违法统计
     * @param json
     */
    @PostMapping("DWZDWFTJ")
    public ApiResult DWZDWFTJ(@RequestBody JSONObject json){
        String param = json.getString("param");
        String start = json.getString("start");
        String end=json.getString("end");
        ApiResult apiResult = dlaqtjService.DWZDWFTJ(param, start, end);
        return apiResult;
    }

    /**
     *  单位重点违法统计 子项
     * @param json
     */
    @PostMapping("DWZDWFTJZX")
    public ApiResult DWZDWFTJZX(@RequestBody JSONObject json){
        String param = json.getString("param");
        String start = json.getString("start");
        String end=json.getString("end");
        String name=json.getString("name");
        ApiResult apiResult = dlaqtjService.DWZDWFTJZX(param, start, end,name);
        return apiResult;
    }
}
