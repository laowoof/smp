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

    Map<String, Object> queryCurrentStockNum();

    Map<String, Object> queryHalfYearNum();

    Long queryHousingAllNum();

    Long queryBuyNum();

    Long queryProductNum();

    List<Map<String, Object>> queryWpcrk();

    Long queryUseHousingNum();

    List<Map<String, Object>> queryDangerHighPoisonDw(@Param("hwlb") String hwlb,@Param("year") String year);

    Long queryDangerHighPoisonLxAllCount(String wpdl);

    List<Map<String, Object>> queryEveryKindNum(@Param("wpdl") String wpdl, @Param("year") String year,@Param("type") String type);

    List<Map<String, Object>> queryDangerHighPoisonRank(@Param("wpdl") String wpdl,@Param("year") String year,@Param("type") String type);

    List<Map<String, Object>> queryCompanyRank();

    List<Map<String, Object>> queryImpPostRank();

    List<Map<String, Object>> queryCompanyCheckRank();

    List<Map<String, Object>> queryHiddenDiscoverRank();

    List<Map<String, Object>> queryHiddenHandleRank();

    List<Map<String, Object>> queryHiddenNoHandleRank();

    List<Map<String, Object>> queryEarlyHandleRank();

    List<Map<String, Object>> queryNumAnalysisZg(@Param("hwlb") String hwlb,@Param("jcjgList") List<String> jcjgList);

    List<Map<String, Object>> queryNumAnalysisWzg(@Param("hwlb") String hwlb,@Param("jcjgList") List<String> jcjgList);

    List<Map<String, Object>> queryDrillRank1(String fjmc);

    List<Map<String, Object>> queryDrillRank2(String fjmc);

    List<Map<String, Object>> queryDrillRank3(String fjmc);

    List<Map<String, Object>> queryDrillRank5(String fjmc);

    List<Map<String, Object>> queryDrillRank6(String fjmc);

    List<Map<String, Object>> queryDrillRank7(String fjmc);

    List<Map<String, Object>> queryDrillRank8(String fjmc);

    List<Map<String, Object>> queryNumSituation(@Param("type") String type,@Param("hwlb") String hwlb,@Param("beginTime") String beginTime,@Param("endTime") String endTime);

    Integer queryAjAllCount();

    List<Map<String, Object>> queryCheckHit(@Param("ajlbdm") String ajlbdm);
}
