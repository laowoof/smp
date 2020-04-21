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

    ApiResult getAddress();

    HashMap getSourceSum(JSONObject json);

    ApiResult getFirmAnalzeSum(JSONObject json);
}

