package com.oceansoft.szga.smp.mapper;

import com.oceansoft.szga.smp.entity.Queryparems;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DeliverylogisticsMapper {

    Map<String,Object> sumDeliverylogistics();

    List<Map<String, Object>> dwfl();

    List<Map<String, Object>> cyry();

    List<Map<String, Object>> yhlx();

    List<Map<String, Object>> jdfl(@Param("mc") List<String> mc);

    List<Map<String, Object>> ryfl(@Param("mc") List<String> mc);

    List<Map<String, Object>> dwfx(@Param("xzqhs") List<String> xzqhs);

    Integer dwfltsyf(Queryparems queryparems);

    Integer dwfltsrq(Queryparems queryparems);

    Integer ryfltsyf(Queryparems queryparems);

    Integer ryfltsrq(Queryparems queryparems);

    List<Map<String, Object>> dwdj(@Param("xzqhs") List<String> xzqhs);

    List<Map<String, Object>> zabw();

    Integer zabwzsl();

    List<Map<String, Object>> aqzr(Queryparems queryparems);

    Integer aqzrzsl(Queryparems queryparems);

    List<Map<String, Object>> dwjc(@Param("jcztdm") String jcztdm,@Param("jclxdm") String jclxdm);

    Integer jgyf(Queryparems queryparems);

    Integer jgrq(Queryparems queryparems);

    Integer cgyf(Queryparems queryparems);

    Integer cgrq(Queryparems queryparems);

    Integer cgzs();

    Integer jgzs();

    List<Float> smsj (Queryparems queryparems);

    Integer yhlxzsl(Queryparems queryparems);

    Integer yhlxyzg(Queryparems queryparems);

    List<Map<String,Object>> yhlxzsl1(Queryparems queryparems);

    List<Map<String,Object>> yhlxyzg1(Queryparems queryparems);



}
