package com.oceansoft.szga.smp.service;

import com.oceansoft.szga.smp.entity.bean.QuestionQueryBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ProcessChargeService {

    Map<String, Object> queryRoadSafeTable(QuestionQueryBean questionQueryBean);

    Map<String, Object> queryRoadSafePoint(String id);

    Map<String, Object> queryQzfTable(QuestionQueryBean questionQueryBean, Integer type);

    Map<String, Object> queryQzfPoint(Integer id);

    Map<String, Object> queryImpTable(QuestionQueryBean questionQueryBean, Integer type);

    Map<String, Object> queryImpPoint(String id);
}
