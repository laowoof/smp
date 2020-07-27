package com.oceansoft.szga.smp.service;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DeliverylogisticsService {

    Map<String,Object> sumDeliverylogistics();

    List<Map<String, Object>> dwfl();

    List<Map<String, Object>> cyry();

    List<Map<String, Object>> jdadnryfl(String type);


}
