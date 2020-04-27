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

    /**
     *  主要隐患高发地分析
     * @author wzj
     * @return 数据
     * @param map
     */
    @PostMapping("getAnYhDdFx")
    public ApiResult getAnYhDdFx(@RequestBody Map map){
        ApiResult data = roadService.getAnYhDdFx(map);
        return data;
    }
    /**
     *  隐患治理列表
     * @author wzj
     * @return 数据
     * @param map
     */
    @PostMapping("getYhZlLb")
    public ApiResult getYhZlLb(@RequestBody Map map){
        ApiResult data = roadService.getYhZlLb(map);
        return data;
    }

    /**
     *  top5
     * @author wzj
     * @return 数据
     * @param map
     */
    @PostMapping("getSqTop5/{typeName}")
    public ApiResult getSqTop5(@PathVariable("typeName") String typeName, @RequestBody Map map){
        ApiResult data = roadService.getSqTop5(typeName,map);
        return data;
    }

    /**
     *  各大队隐患处理情况分析  点击事件获取 中队数据
     * @author wzj
     * @return 数据
     * @param map
     */
    @PostMapping("getDataClick/{clickName}")
    public ApiResult getDataClick(@PathVariable("clickName") String clickName, @RequestBody Map map){
        ApiResult data = roadService.getDataClick(clickName,map);
        return data;
    }

    /**
     *  各大队隐患处理情况分析  点击事件获取 中队数据 道路top5
     * @author wzj
     * @return 数据
     * @param map
     */
    @PostMapping("getDataClickTop5/{clickName}")
    public ApiResult getDataClickTop5(@PathVariable("clickName") String clickName, @RequestBody Map map){
        ApiResult data = roadService.getDataClickTop5(clickName,map);
        return data;
    }

    /**
     * 获取十一个区县和全区
     * @return 区划代码和名称
     */
    @GetMapping("getAddress")
    public ApiResult getAddresses(){
        return roadService.getAddress();
    }

    /**
     * 页面按年/月/1月的查询按钮
     * @param json
     * @return 企业总量、重点车辆数、重点人员数
     */
    @PostMapping("getSourceSum")
    @ResponseBody
    public ApiResult getSourceSum(@RequestBody JSONObject json){
        HashMap result = roadService.getSourceSum(json);
        return new ApiResult().success(200, "获取数据成功!", result);
    }

    /**
     * 企业性质/类型分析
     * @param json
     * @return 处理后的数据
     */
    @PostMapping("getFirmAnalzeSum")
    @ResponseBody
    public ApiResult getFirmAnalzeSum(@RequestBody JSONObject json){
        return roadService.getFirmAnalzeSum(json);

    }

    /**
     * 治理成果统计/类型分析、完成率
     * @param json
     * @return 处理后的数据
     */
    @PostMapping("getAchievCount")
    @ResponseBody
    public ApiResult getAchievCount(@RequestBody JSONObject json){
        return roadService.getAchievCount(json);

    }

    /**
     * 违法打击 数量总计
     * @return 处理后的数据
     * @param map
     */
    @PostMapping("getWfDj")
    public ApiResult getWfDj(@RequestBody HashMap map){
        return roadService.getWfDj(map);
    }

    /**
     * 违法打击 执法数据
     * @return 处理后的数据
     * @param map
     */
    @PostMapping("getZfSj")
    public ApiResult getZfSj(@RequestBody HashMap map){
        return roadService.getZfSj(map);
    }

    /**
     * 违法打击 执法中队数据
     * @return 处理后的数据
     * @param map
     */
    @PostMapping("getZfSjZd/{clickName}")
    public ApiResult getZfSjZd(@PathVariable("clickName") String clickName,@RequestBody HashMap map){
        return roadService.getZfSjZd(clickName,map);
    }

    /**
     * 违法打击 违法黑名单
     * @return 处理后的数据
     * @param map
     */
    @PostMapping("getWfHmd")
    public ApiResult getWfHmd(@RequestBody HashMap map){
        return roadService.getWfHmd(map);
    }
    /**
     * 违法打击 查缉布控
     * @return 处理后的数据
     * @param map
     */
    @PostMapping("getDataCjBk")
    public ApiResult getDataCjBk(@RequestBody HashMap map){
        return roadService.getDataCjBk(map);
    }
    /**
     * 违法打击 人像识别
     * @return 处理后的数据
     * @param map
     */
    @PostMapping("getDataRxSb")
    public ApiResult getDataRxSb(@RequestBody HashMap map){
        return roadService.getDataRxSb(map);
    }
    /**
     * 违法打击 交通违法时间段分析
     * @return 处理后的数据
     * @param name
     */
    @GetMapping("getDataJtWf/{name}")
    public ApiResult getDataJtWf(@PathVariable("name") String name){
        return roadService.getDataJtWf(name);
    }
    /**
     * 违法打击 重点违量统计
     * @return 处理后的数据
     * @param map
     */
    @PostMapping("getDataZdWlTj/{TypeName}")
    public ApiResult getDataZdWlTj(@PathVariable("TypeName") String TypeName,@RequestBody HashMap map){
        return roadService.getDataZdWlTj(TypeName,map);
    }
    /**
     * 违法打击 重点违法类型分析
     * @return 处理后的数据
     * @param map
     */
    @PostMapping("getDataWfLx/{typeName}")
    public ApiResult getDataWfLx(@PathVariable("typeName") String typeName,@RequestBody HashMap map){
        return roadService.getDataWfLx(typeName,map);
    }
    /**
     * 违法打击 重点违法类型分析type
     * @return 处理后的数据
     * @param map
     */
    @PostMapping("getDataWfLxType/{typeName}")
    public ApiResult getDataWfLxType(@PathVariable("typeName") String typeName,@RequestBody HashMap map){
        return roadService.getDataWfLxType(typeName,map);
    }

    /**
     * 违法打击 重点违量统计点击事件
     * @return 处理后的数据
     * @param map
     */
    @PostMapping("getClickDataWfLxType/{name}")
    public ApiResult getClickDataWfLxType(@PathVariable("name") String name,@RequestBody HashMap map){
        return roadService.getClickDataWfLxType(name,map);
    }
    /**
     * 违法打击 车辆问题变化趋势分析
     * @return 处理后的数据
     * @param map
     */
    @PostMapping("getDataCar/{typeName}")
    public ApiResult getDataCar(@PathVariable("typeName") String typeName,@RequestBody HashMap map){
        return roadService.getDataCar(typeName,map);
    }

    /**
     * 违法打击 车辆问题类型分析
     * @return 处理后的数据
     * @param map
     */
    @PostMapping("getDataCarQue/{typeName}")
    public ApiResult getDataCarQue(@PathVariable("typeName") String typeName,@RequestBody HashMap map){
        return roadService.getDataCarQue(typeName,map);
    }

    /**
     * 违法打击 大队列表
     * @return 处理后的数据
     * @param typeName
     */
    @GetMapping("getDataDdList/{typeName}")
    public ApiResult getDataDdList(@PathVariable("typeName") String typeName){
        return roadService.getDataDdList(typeName);
    }

    /**
     * 违法打击 大队选择
     * @return 处理后的数据
     * @param titleName
     * @param map
     */
    @PostMapping("getDataDdListChange/{titleName}")
    public ApiResult getDataDdListChange(@PathVariable("titleName") String titleName,@RequestBody HashMap map){
        return roadService.getDataDdListChange(titleName,map);
    }

    /**
     * 违法打击 大队选择车辆问题变化趋势分析数据
     * @return 处理后的数据
     * @param titleName
     * @param map
     */

    @PostMapping("getDataDdListChangeCar/{titleName}")
    public ApiResult getDataDdListChangeCar(@PathVariable("titleName") String titleName,@RequestBody HashMap map){
        return roadService.getDataDdListChangeCar(titleName,map);
    }
    /**
     * 违法打击 大队选择车辆问题变化趋势分析   点击事件
     * @return 处理后的数据
     * @param name
     * @param map
     */

    @PostMapping("getDataClickCarAndChange/{name}")
    public ApiResult getDataClickCarAndChange(@PathVariable("name") String name,@RequestBody HashMap map){
        return roadService.getDataClickCarAndChange(name,map);
    }
}
