package com.oceansoft.szga.smp.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.oceansoft.szga.smp.entity.bean.QuestionQueryBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProcessChargeMapper {

    List<Map<String, Object>> queryRoadSafeTable(Page<Map<String, Object>> page, @Param("questionQueryBean") QuestionQueryBean questionQueryBean,@Param("firstDay") String firstDay);

    Map<String, Object> queryRoadSafePointById(String id);

    List<Map<String, Object>> queryQzfTable(Page<Map<String, Object>> page, @Param("questionQueryBean") QuestionQueryBean questionQueryBean, @Param("type") Integer type);

    Map<String, Object> queryQzfPoint(Integer id);

    List<Map<String, Object>> queryImpTable(Page<Map<String, Object>> page, @Param("questionQueryBean") QuestionQueryBean questionQueryBean, @Param("type") Integer type);

    Map<String, Object> queryImpPoint(String id);

    Map<String, Object> queryImpProcessPic(@Param("type") Integer type);

    List<Map<String, Object>> queryDeliveryTable(Page<Map<String, Object>> page, @Param("questionQueryBean") QuestionQueryBean questionQueryBean, @Param("type") Integer type);

    Map<String, Object> queryTrafficData(String firstDay);
}
