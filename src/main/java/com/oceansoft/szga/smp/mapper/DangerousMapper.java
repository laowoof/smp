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

    List<Map<String, Object>> queryPeopleBackgroud();

    List<String> queryFjmc();

    Integer queryAllPeopleCount();

    List<Map<String, Object>> queryPeopleBusiness(@Param("fjmcList") List<String> fjmcList);

    List<Map<String, Object>> queryPeopleZcState1(@Param("fjmcList") List<String> fjmcList,@Param("type") String type,@Param("beginTime") String beginTime,@Param("endTime") String endTime);

    List<Map<String, Object>> queryPeopleZcState2(@Param("fjmcList") List<String> fjmcList,@Param("type") String type,@Param("beginTime") String beginTime,@Param("endTime") String endTime);

    List<Map<String, Object>> queryPeopleZcState3(@Param("fjmcList") List<String> fjmcList,@Param("type") String type,@Param("beginTime") String beginTime,@Param("endTime") String endTime);

    List<Map<String, Object>> queryPeopleBaState1(@Param("fjmcList") List<String> fjmcList,@Param("type") String type,@Param("beginTime") String beginTime,@Param("endTime") String endTime);

    List<Map<String, Object>> queryPeopleBaState2(@Param("fjmcList") List<String> fjmcList,@Param("type") String type,@Param("beginTime") String beginTime,@Param("endTime") String endTime);

    List<Map<String, Object>> queryPeopleBaState3(@Param("fjmcList") List<String> fjmcList,@Param("type") String type,@Param("beginTime") String beginTime,@Param("endTime") String endTime);

    List<Map<String, Object>> queryPeopleRecord(String ywlxdm);

    List<Map<String, Integer>> queryPeopleNumByDm(String ywlxdm);

    List<String> queryAnalysisFjmc();

    List<Map<String, Object>> queryPostKind1(@Param("fjmcList") List<String> fjmcList);

    List<Map<String, Object>> queryPostKind3(@Param("fjmcList") List<String> fjmcList);

    Integer queryNormalCount();

    List<Map<String, Object>> queryPostState1(@Param("fjmcList") List<String> fjmcList, @Param("beginTime") String beginTime,@Param("endTime") String endTime);

    List<Map<String, Object>> queryPostState2(@Param("fjmcList") List<String> fjmcList, @Param("beginTime") String beginTime,@Param("endTime") String endTime);

    List<Map<String, Object>> queryPostState3(@Param("lockTypeList") List<String> lockTypeList, @Param("fjmcList") List<String> fjmcList, @Param("beginTime") String beginTime,@Param("endTime") String endTime);

    List<Map<String, Object>> queryPostState4(@Param("lockTypeList") List<String> lockTypeList, @Param("fjmcList") List<String> fjmcList, @Param("beginTime") String beginTime,@Param("endTime") String endTime);

    Integer queryHasRecordCount();

    List<Map<String, Object>> queryHasRecordList(@Param("fjmcList") List<String> fjmcList, @Param("beginTime") String beginTime,@Param("endTime") String endTime);

    List<Map<String, Object>> queryNoRecordingList(@Param("fjmcList") List<String> fjmcList, @Param("beginTime") String beginTime,@Param("endTime") String endTime);

    Integer queryCheckAllCount();

    List<Map<String, Object>> queryEveryCount();

    List<Map<String, Object>> queryCompanySuperviseByMon(@Param("beginTime") String beginTime,@Param("endTime") String endTime);

    List<Map<String, Object>> queryCompanySuperviseByDay(@Param("beginDay") String beginDay,@Param("endDay") String endDay);

    Integer queryEarlyWarningAllCount();

    List<Map<String, Object>> queryEarlyWarning();

    List<Map<String, Object>> queryEarlyProjectJd();

    Integer queryJdCount();

    Integer queryYzbCount();

    List<Map<String, Object>> queryEarlyProjectYzb();
}
