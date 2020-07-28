package com.oceansoft.szga.smp.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DeliveryLogisticsSafeService {

    Map<String, Object> queryDeliveryRank();

    List<Map<String, Object>> queryDutyDrill(JSONObject jsonObject);

    Map<String, Object> queryHiddenNumAnalysis();

    Map<String, Object> queryHiddenCompanyLevel();

    Map<String, Object> queryImpTop();

    Map<String, Object> queryAnalysisNum(JSONObject jsonObject);

    Map<String, Object> queryNumTrend(JSONObject jsonObject);
}
