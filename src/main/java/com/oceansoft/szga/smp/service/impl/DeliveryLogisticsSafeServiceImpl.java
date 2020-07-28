package com.oceansoft.szga.smp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.oceansoft.szga.smp.mapper.DeliveryLogisticsSafeMapper;
import com.oceansoft.szga.smp.service.DeliveryLogisticsSafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
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

    @Override
    public Map<String, Object> queryHiddenNumAnalysis() {
        Map<String, Object> map = new HashMap<>();
        Integer outerRingCount = 0;
        Integer innerRingCount = 0;
        // 外环
        List<Map<String, Object>> outerRingList = deliveryLogisticsSafeMapper.queryHiddenNumAnalysisFind();
        if (!CollectionUtils.isEmpty(outerRingList)) {
            for (Map<String, Object> stringObjectMap : outerRingList) {
                outerRingCount = outerRingCount + Integer.valueOf(stringObjectMap.get("sum").toString());
            }
            for (Map<String, Object> stringObjectMap : outerRingList) {
                NumberFormat numberFormat = NumberFormat.getInstance();
                // 设置精确到小数点后2位
                numberFormat.setMaximumFractionDigits(2);
                String result = numberFormat.format((float)  Integer.valueOf(stringObjectMap.get("sum").toString())/ (float)outerRingCount* 100);//所占百分比
                map.put("percent", result+"%");
            }
        }
        // 内环
        List<Map<String, Object>> innerRingList = deliveryLogisticsSafeMapper.queryHiddenNumAnalysisHandler();
        if (!CollectionUtils.isEmpty(innerRingList)) {
            for (Map<String, Object> stringObjectMap : innerRingList) {
                innerRingCount = innerRingCount + Integer.valueOf(stringObjectMap.get("sum").toString());
            }
            for (Map<String, Object> stringObjectMap : innerRingList) {
                NumberFormat numberFormat = NumberFormat.getInstance();
                // 设置精确到小数点后2位
                numberFormat.setMaximumFractionDigits(2);
                String result = numberFormat.format((float)  Integer.valueOf(stringObjectMap.get("sum").toString())/ (float)innerRingCount* 100);//所占百分比
                map.put("percent", result+"%");
            }
        }
        map.put("outerRingList", outerRingList);
        map.put("innerRingList", innerRingList);
        return map;
    }

    @Override
    public Map<String, Object> queryHiddenCompanyLevel() {
        Map<String, Object> resultMap = new HashMap<>();
        // 内环
        List<Map<String, Object>> innerRingList = deliveryLogisticsSafeMapper.queryHiddenCompanyLevelDw();
        Integer innerCount = 0;
        if (!CollectionUtils.isEmpty(innerRingList)) {
            for (Map<String, Object> map : innerRingList) {
                innerCount = innerCount + Integer.valueOf(map.get("sum").toString());
            }
            for (Map<String, Object> map : innerRingList) {
                NumberFormat numberFormat = NumberFormat.getInstance();
                // 设置精确到小数点后2位
                numberFormat.setMaximumFractionDigits(2);
                String result = numberFormat.format((float)  Integer.valueOf(map.get("sum").toString())/ (float)innerCount* 100);//所占百分比
                map.put("percent", result+"%");
            }
        }
        // 外环
        List<Map<String, Object>> outerRingList = deliveryLogisticsSafeMapper.queryHiddenCompanyLevelYh();
        Integer outerCount = 0;
        if (!CollectionUtils.isEmpty(outerRingList)) {
            for (Map<String, Object> map : outerRingList) {
                if (map.get("dwdj").equals("0")) {
                    map.put("dwdjmc", "A级");
                } else if (map.get("dwdj").equals("1")) {
                    map.put("dwdjmc", "B级");
                } else if (map.get("dwdj").equals("2")) {
                    map.put("dwdjmc", "C级");
                } else if (map.get("dwdj").equals("3")) {
                    map.put("dwdjmc", "不定级");
                } else if (map.get("dwdj").equals("")) {
                    map.put("dwdjmc", "");
                }
                outerCount = outerCount + Integer.valueOf(map.get("sum").toString());
            }
        }
        for (Map<String, Object> map : outerRingList) {
            NumberFormat numberFormat = NumberFormat.getInstance();
            // 设置精确到小数点后2位
            numberFormat.setMaximumFractionDigits(2);
            String result = numberFormat.format((float)  Integer.valueOf(map.get("sum").toString())/ (float)outerCount* 100);//所占百分比
            map.put("percent", result+"%");
        }
        resultMap.put("innerRingList", innerRingList);
        resultMap.put("outerRingList", outerRingList);
        return resultMap;
    }

    @Override
    public Map<String, Object> queryImpTop() {
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> mapList = deliveryLogisticsSafeMapper.queryImpTop();
        Integer count = 0;
        if (!CollectionUtils.isEmpty(mapList)) {
            for (Map<String, Object> stringObjectMap : mapList) {
                count = count + Integer.valueOf(stringObjectMap.get("sum").toString());
            }
        }
        for (Map<String, Object> stringObjectMap : mapList) {
            NumberFormat numberFormat = NumberFormat.getInstance();
            // 设置精确到小数点后2位
            numberFormat.setMaximumFractionDigits(2);
            String result = numberFormat.format((float)  Integer.valueOf(stringObjectMap.get("sum").toString())/ (float)count* 100);//所占百分比
            map.put("percent", result+"%");
        }
        map.put("mapList", mapList);
        return map;
    }

    @Override
    public Map<String, Object> queryAnalysisNum(JSONObject jsonObject) {
        String type = jsonObject.getString("type");
        List<String> typeList = null;
        if (!StringUtils.isEmpty(type)) {
            String[] split = type.split(",");
            typeList = Arrays.asList(split);
        }
        List<Map<String, Object>> mapList = deliveryLogisticsSafeMapper.queryAnalysisNum(typeList);

        return null;
    }

    @Override
    public Map<String, Object> queryNumTrend(JSONObject jsonObject) {
        String fjmc = jsonObject.getString("fjmc");
        String type = jsonObject.getString("type");
        List<String> typeList = null;
        if (!StringUtils.isEmpty(type)) {
            String[] split = type.split(",");
            typeList = Arrays.asList(split);
        }
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (int i=11; i>=0; i--) {
            String month = getLast12Months(i);
            Map<String, Object> mapList = deliveryLogisticsSafeMapper.queryNumTrend(fjmc, typeList, month);
            resultList.add(mapList);
        }

        return null;
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

    /**
     * 获取前多少月的月份 带0
     * @param i
     * @return
     */
    public String getLast12Months(int i) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -i);
        Date m = c.getTime();
        return sdf.format(m);
    }
}
