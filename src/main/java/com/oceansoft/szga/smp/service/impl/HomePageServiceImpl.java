package com.oceansoft.szga.smp.service.impl;

import com.oceansoft.szga.smp.mapper.HomePageMapper;
import com.oceansoft.szga.smp.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 首页实现类
 *
 * @author JackChan
 * @Date 2020/6/24 0024 下午 3:11
 */
@Service
public class HomePageServiceImpl implements HomePageService {

    @Autowired
    private HomePageMapper homePageMapper;

    /**
     * 首页道路交通安全监管
     *
     * @return
     */
    @Override
    public Map<String, Integer> getRoadBaseInfo() {
        Map<String, Integer> roadBaseInfo = homePageMapper.getRoadBaseInfo();
        return roadBaseInfo;
    }

    /**
     * 首页群租房安全监管
     *
     * @return
     */
    @Override
    public Map<String, Integer> getRentSafe() {
        Map<String, Integer> rentSafe = homePageMapper.getRentSafe();
        return rentSafe;
    }

    @Override
    public Map<String, Integer> getImpTarget() {
        Map<String, Integer> impTarget = homePageMapper.getImpTarget();
        return impTarget;
    }

    @Override
    public List<Map<String, Integer>> getImpTargetPie() {
        List<Map<String, Integer>> impTargetPie = homePageMapper.getImpTargetPie();
        return impTargetPie;
    }
}
