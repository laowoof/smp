package com.oceansoft.szga.smp.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DeliverylogisticsMapper {

    Map<String,Object> sumDeliverylogistics();

    List<Map<String, Object>> dwfl();

    List<Map<String, Object>> cyry();

    List<Map<String, Object>> jdfl();

    List<Map<String, Object>> ryfl();

}
