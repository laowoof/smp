package com.oceansoft.szga.smp.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface HomePageMapper {

    /**
     * 首页道路交通安全监管
     *
     * @return
     */
    Map<String, Integer> getRoadBaseInfo();

    /**
     * 首页群租房安全监管
     *
     * @return
     */
    Map<String, Integer> getRentSafe();

    /**
     * 首页重点目标安全监管基本信息
     *
     * @return
     */
    Map<String, Integer> getImpTarget();

    /**
     * 首页重点目标安全监管基本信息饼图
     *
     * @return
     */
    List<Map<String, Integer>> getImpTargetPie();
}
