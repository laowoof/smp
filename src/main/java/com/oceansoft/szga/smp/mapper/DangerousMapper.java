package com.oceansoft.szga.smp.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DangerousMapper {


    List<Map<String, Object>> queryBaseInfo();

    Integer querySuperviseUnit(String str);

    Integer queryAllSuperviseUnit();

    Integer querySfgyl();

    Integer querySfczy();

    Integer querySfzabwy();

    List<Map<String, Object>> queryDangerousDw(@Param("zawxpdjdmList") List<String> zawxpdjdmList,@Param("hwlxList") List<String> hwlxList);

    List<Map<String, Object>> queryImportDw(@Param("ywlxdmList") List<String> ywlxdmList);

    List<Map<String, Object>> queryHighPoison();

    List<Map<String, Object>> queryEasyBoom();

    List<Map<String, Object>> queryHighPoisonLine(@Param("type") Integer type);

    List<Map<String, Object>> queryEasyBoomLine(@Param("type") Integer type);
}
