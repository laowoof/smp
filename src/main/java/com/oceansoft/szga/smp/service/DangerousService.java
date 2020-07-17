package com.oceansoft.szga.smp.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DangerousService {


    List<Map<String, Object>> queryBaseInfo();

    List<Map<String, Object>> querySuperviseUnit();

    List<Map<String, Object>> queryImportPeople();

    List<Map<String, Object>> queryDangerousDw(JSONObject json);

    List<Map<String, Object>> queryImportDw(JSONObject json);

    List<Map<String, Object>> queryHighPoison();

    List<Map<String, Object>> queryEasyBoom();

    List<Map<String, Object>> queryHighPoisonLine(Integer type);

    List<Map<String, Object>> queryEasyBoomLine(Integer type);

    Map<String, Object> queryDangerBaseInfo();

    List<Map<String, Object>> queryDangerHighPoisonDw(JSONObject jsonObject);

    List<Map<String, Object>> queryDangerHighPoisonLx(JSONObject jsonObject);

    List<Map<String, Object>> queryDangerHighPoisonRank(JSONObject jsonObject);

    List<Map<String, Object>> queryCompanyRank();

    List<Map<String, Object>> queryImpPostRank();

    List<Map<String, Object>> queryCompanyCheckRank();

    List<Map<String, Object>> queryHiddenDiscoverRank();

    List<Map<String, Object>> queryHiddenHandleRank();

    List<Map<String, Object>> queryHiddenNoHandleRank();

    List<Map<String, Object>> queryEarlyHandleRank();

    List<Map<String, Object>> queryNumAnalysis(JSONObject jsonObject);

    List<Map<String, Object>> queryDrillRank(JSONObject jsonObject);

    List<Map<String, Object>> queryNumSituation(JSONObject jsonObject);

    List<Map<String, Object>> queryCheckHit(JSONObject jsonObject);

    List<Map<String, Object>> queryPeopleBackgroud();

    List<Map<String, Object>> queryPeopleBusiness(JSONObject jsonObject);

    List<String> queryFjmc();

    Map<String, Object> queryPeopleState(JSONObject jsonObject);

    Map<String, Object> queryPeopleRecord(JSONObject jsonObject);

    List<String> queryAnalysisFjmc();

    Map<String, Object> queryPostKind(JSONObject jsonObject);

    Map<String, Object> queryPostState(JSONObject jsonObject);

    Map<String, Object> queryCheckSituation();

    Map<String, Object> queryCompanySupervise(JSONObject jsonObject);

    Map<String, Object> queryEarlyWarning();

    Map<String, Object> queryEarlyProject(JSONObject jsonObject);
}
