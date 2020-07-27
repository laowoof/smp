package com.oceansoft.szga.smp.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DeliveryLogisticsSafeMapper {

    List<Map<String, Object>> queryDeliveryRank1();

    List<Map<String, Object>> queryDeliveryRank2();

    List<Map<String, Object>> queryDeliveryRank3();

    List<Map<String, Object>> queryDeliveryRank4();

    List<Map<String, Object>> queryDeliveryRank5();

    List<Map<String, Object>> queryDeliveryRank6();

    List<Map<String, Object>> queryDeliveryRank7();

    List<Map<String, Object>> queryDeliveryRank8();

    List<Map<String, Object>> queryDrillRank1(String fjmc);

    List<Map<String, Object>> queryDrillRank2(String fjmc);

    List<Map<String, Object>> queryDrillRank3(String fjmc);

    List<Map<String, Object>> queryDrillRank4(String fjmc);

    List<Map<String, Object>> queryDrillRank5(String fjmc);

    List<Map<String, Object>> queryDrillRank6(String fjmc);

    List<Map<String, Object>> queryDrillRank7(String fjmc);

    List<Map<String, Object>> queryDrillRank8(String fjmc);
}
