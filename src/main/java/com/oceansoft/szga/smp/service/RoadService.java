package com.oceansoft.szga.smp.service;
import com.alibaba.fastjson.JSONObject;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;


import java.util.HashMap;

/**
 *  道路交通
 * @author wzj
 * @date 2020/4/20
 */

@Mapper
public interface RoadService {
    ApiResult test();

    /**
     *  重要设施分类统计
     * @param map
     * @return
     */
    ApiResult anTotleNum(Map map);

    /**
     *  各大队隐患处理情况分析
     * @param map
     * @param type
     * @return
     */
    ApiResult yhQusFx(String type,Map map);

    /**
     *  重要节点分析
     * @param map
     * @return
     */
    ApiResult zyJdFx(Map map);

    /**
     *  隐患类型分析
     * @param map
     * @return
     */
    ApiResult getAnYhDdFx(Map map);

    /**
     *  隐患类型分析
     * @param map
     * @return
     */
    ApiResult yhLxFx(Map map);

    /**
     *  隐患治理列表
     * @param map
     * @return
     */
    ApiResult getYhZlLb(Map map);

    /**
     *   各大队隐患处理情况分析  点击事件获取 中队数据
     * @param map
     * @param clickName
     * @return
     */
    ApiResult getDataClick(String clickName,Map map);

    /**
     *   各大队隐患处理情况分析  点击事件获取 中队数据  道路top5
     * @param map
     * @param clickName
     * @return
     */
    ApiResult getDataClickTop5(String clickName,Map map);

    /**
     *  top5
     * @param map
     * @return
     */
    ApiResult getSqTop5(String typeName,Map map);

    /**
     * 获取十一个区县和全区
     * @return 区划代码和名称
     */
    ApiResult getAddress();

    /**
     * 页面按年/月/1月的查询按钮
     * @param json
     * @return 企业总量、重点车辆数、重点人员数
     */
    HashMap getSourceSum(JSONObject json);

    /**
     * 企业性质/类型分析
     * @param json
     * @return 处理后的数据
     */
    ApiResult getFirmAnalzeSum(JSONObject json);

    /**
     * 治理成果统计/类型分析、完成率
     * @param json
     * @return 处理后的数据
     */
    ApiResult getAchievCount(JSONObject json);

    /**
     * 违法打击 数量总计
     * @param map
     * @return 处理后的数据
     */
    ApiResult getWfDj(HashMap map);
    /**
     * 违法打击 执法数据
     * @param map
     * @return 处理后的数据
     */
    ApiResult getZfSj(HashMap map);

    /**
     * 违法打击 执法中队 数据
     * @param map
     * @param clickName
     * @return 处理后的数据
     */
    ApiResult getZfSjZd(String clickName,HashMap map);

    /**
     * 违法打击 违法黑名单
     * @param map
     * @return 处理后的数据
     */
    ApiResult getWfHmd(HashMap map);

    /**
     * 违法打击 查缉布控
     * @param map
     * @return 处理后的数据
     */
    ApiResult getDataCjBk(HashMap map);
    /**
     * 违法打击 人像识别
     * @param map
     * @return 处理后的数据
     */
    ApiResult getDataRxSb(HashMap map);
    /**
     * 违法打击 交通违法时间段分析
     * @param name
     * @return 处理后的数据
     */
    ApiResult getDataJtWf(String name);
    /**
     * 违法打击 重点违量统计
     * @param map
     * @param TypeName
     * @return 处理后的数据
     */
    ApiResult getDataZdWlTj(String TypeName,HashMap map);
    /**
     * 违法打击 重点违法类型分析
     * @param map
     * @param typeName
     * @return 处理后的数据
     */
    ApiResult getDataWfLx(String typeName,HashMap map);
    /**
     * 违法打击 重点违法类型分析type
     * @param map
     * @param typeName
     * @return 处理后的数据
     */
    ApiResult getDataWfLxType(String typeName,HashMap map);

    /**
     * 违法打击 违法打击 重点违量统计点击事件
     * @param map
     * @param name
     * @return 处理后的数据
     */
    ApiResult getClickDataWfLxType(String name,HashMap map);

    /**
     * 违法打击 违法打击 重点违量统计点击事件
     * @param map
     * @param typeName
     * @return 处理后的数据
     */
    ApiResult getDataCar(String typeName,HashMap map);

    /**
     * 违法打击 车辆问题类型分析
     * @param map
     * @param typeName
     * @return 处理后的数据
     */
    ApiResult getDataCarQue(String typeName,HashMap map);

    /**
     * 违法打击 大队列表
     * @param typeName
     * @return 处理后的数据
     */
    ApiResult getDataDdList(String typeName);
    /**
     * 违法打击 大队选择
     * @param titleName
     * @param  map
     * @return 处理后的数据
     */
    ApiResult getDataDdListChange(String titleName,Map map);

    /**
     * 违法打击 大队选择后 车辆问题变化趋势分析
     * @param titleName
     * @param  map
     * @return 处理后的数据
     */
    ApiResult getDataDdListChangeCar(String titleName,Map map);

    /**
     * 违法打击 点击事件
     * @param name
     * @param  map
     * @return 处理后的数据
     */
    ApiResult getDataClickCarAndChange(String name,Map map);

    ApiResult carYhData(Map map);

    ApiResult getZdCarData(Map map);

    ApiResult getIllegalCar(JSONObject json);
}

