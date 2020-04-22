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
    ApiResult yhLxFx(Map map);

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
}

