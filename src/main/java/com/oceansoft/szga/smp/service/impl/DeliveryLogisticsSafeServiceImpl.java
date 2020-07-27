package com.oceansoft.szga.smp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.oceansoft.szga.smp.mapper.DeliveryLogisticsSafeMapper;
import com.oceansoft.szga.smp.service.DeliveryLogisticsSafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * 寄递物流实现层
 *
 * @author JackChan
 * @Date 2020/7/10 0010 上午 11:15
 */
@Service
public class DeliveryLogisticsSafeServiceImpl implements DeliveryLogisticsSafeService {

    @Autowired
    private DeliveryLogisticsSafeMapper deliveryLogisticsSafeMapper;

    @Override
    public Map<String, Object> queryDeliveryRank() {
        Map<String, Object> resultMap = new HashMap<>();
        // 单位登记量排名
        List<Map<String, Object>> mapList1 = deliveryLogisticsSafeMapper.queryDeliveryRank1();
        List<Map<String, Object>> resultList1 = orderMethod(mapList1);
        // 从业人员登记量排名
        List<Map<String, Object>> mapList2 = deliveryLogisticsSafeMapper.queryDeliveryRank2();
        List<Map<String, Object>> resultList2 = orderMethod(mapList2);
        // 单位检查量排名
        List<Map<String, Object>> mapList3 = deliveryLogisticsSafeMapper.queryDeliveryRank3();
        List<Map<String, Object>> resultList3 = orderMethod(mapList3);
        // 单位缺检查量排名
        List<Map<String, Object>> mapList4 = deliveryLogisticsSafeMapper.queryDeliveryRank4();
        List<Map<String, Object>> resultList4 = orderMethod(mapList4);
        // 隐患发现量排名
        List<Map<String, Object>> mapList5 = deliveryLogisticsSafeMapper.queryDeliveryRank5();
        List<Map<String, Object>> resultList5 = orderMethod(mapList5);
        // 隐患整改量排名
        List<Map<String, Object>> mapList6 = deliveryLogisticsSafeMapper.queryDeliveryRank6();
        List<Map<String, Object>> resultList6 = orderMethod(mapList6);
        // 隐患未整改量排名
        List<Map<String, Object>> mapList7 = deliveryLogisticsSafeMapper.queryDeliveryRank7();
        List<Map<String, Object>> resultList7 = orderMethod(mapList7);
        // 安全责任书签订量排名
        List<Map<String, Object>> mapList8 = deliveryLogisticsSafeMapper.queryDeliveryRank8();
        List<Map<String, Object>> resultList8 = orderMethod(mapList8);
        // 放结果
        resultMap.put("companyRegister", resultList1);
        resultMap.put("peopleRegister", resultList2);
        resultMap.put("companyCheck", resultList3);
        resultMap.put("companyNoCheck", resultList4);
        resultMap.put("hiddenDangerDiscover", resultList5);
        resultMap.put("hiddenDangerFix", resultList6);
        resultMap.put("hiddenDangerNoFix", resultList7);
        resultMap.put("safeDuty", resultList8);
        return resultMap;
    }

    @Override
    public List<Map<String, Object>> queryDutyDrill(JSONObject jsonObject) {
        String id = jsonObject.getString("id");
        String fjmc = jsonObject.getString("fjmc");
        List<Map<String, Object>> mapList = new ArrayList<>();
        switch (id) {
            case "1":
                mapList = deliveryLogisticsSafeMapper.queryDrillRank1(fjmc);
                break;
            case "2":
                mapList = deliveryLogisticsSafeMapper.queryDrillRank2(fjmc);
                break;
            case "3":
                mapList = deliveryLogisticsSafeMapper.queryDrillRank3(fjmc);
                break;
            case "4":
                mapList = deliveryLogisticsSafeMapper.queryDrillRank4(fjmc);
                break;
            case "5":
                mapList = deliveryLogisticsSafeMapper.queryDrillRank5(fjmc);
                break;
            case "6":
                mapList = deliveryLogisticsSafeMapper.queryDrillRank6(fjmc);
                break;
            case "7":
                mapList = deliveryLogisticsSafeMapper.queryDrillRank7(fjmc);
                break;
            case "8":
                mapList = deliveryLogisticsSafeMapper.queryDrillRank8(fjmc);
                break;
            default:
                break;
        }
        return mapList;
    }

    private List<Map<String, Object>> orderMethod(List<Map<String, Object>> mapList) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        List<String> orderList = Arrays.asList("张家港","常熟","昆山","太仓","吴江","园区","姑苏","高新区","吴中","相城","度假区");
        if (!CollectionUtils.isEmpty(mapList)) {
            for (String name : orderList) {
                for (Map<String, Object> map : mapList) {
                    if (map.get("fjmc").toString().contains(name)) {
                        resultList.add(map);
                    } else {
                        continue;
                    }
                }
            }
        }
        return resultList;
    }
}
