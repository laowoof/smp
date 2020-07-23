package com.oceansoft.szga.smp.mapper;

import com.oceansoft.szga.smp.entity.bean.QuestionQueryBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProcessChargeMapper {

    List<Map<String, Object>> queryRoadSafeTable(@Param("questionQueryBean") QuestionQueryBean questionQueryBean);

    Map<String, Object> queryRoadSafePointById(String id);

    List<Map<String, Object>> queryQzfTable(@Param("questionQueryBean") QuestionQueryBean questionQueryBean, @Param("type") Integer type);

    Map<String, Object> queryQzfPoint(Integer id);

    List<Map<String, Object>> queryImpTable(@Param("questionQueryBean") QuestionQueryBean questionQueryBean, @Param("type") Integer type);

    Map<String, Object> queryImpPoint(String id);

    Map<String, Object> queryImpProcessPic(@Param("type") Integer type);
}
