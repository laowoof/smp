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
}
