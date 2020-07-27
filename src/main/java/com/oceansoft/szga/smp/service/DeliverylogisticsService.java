package com.oceansoft.szga.smp.service;

import com.oceansoft.szga.smp.entity.Queryparems;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DeliverylogisticsService {

    Map<String,Object> sumDeliverylogistics();

    List<Map<String, Object>> dwfl();

    List<Map<String, Object>> cyry();

    List<Map<String, Object>> yhlx();

    List<Map<String, Object>> jdadnryfl(Queryparems queryparems);

    List<Map<String, Object>> dwfx(Queryparems queryparems);

    List<Map<String, Object>> dwdj(Queryparems queryparems);

    List<Map<String, Object>> zabw();

    List<Map<String, Object>> aqzr();

    List<Map<String, Object>> dwjc(Queryparems queryparems);
}
