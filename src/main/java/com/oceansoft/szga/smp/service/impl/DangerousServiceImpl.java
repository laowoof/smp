package com.oceansoft.szga.smp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.oceansoft.szga.smp.mapper.DangerousMapper;
import com.oceansoft.szga.smp.service.DangerousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 危险品全态研析实现层
 *
 * @author JackChan
 * @Date 2020/7/10 0010 上午 11:15
 */
@Service
public class DangerousServiceImpl implements DangerousService {

    @Autowired
    private DangerousMapper dangerousMapper;

    @Override
    public List<Map<String, Object>> queryBaseInfo() {
        List<Map<String, Object>> mapList = dangerousMapper.queryBaseInfo();
        return mapList;
    }

    @Override
    public List<Map<String, Object>> querySuperviseUnit() {
        List<Map<String, Object>> list = new ArrayList<>();
        String[] arr = new String[]{"1","2","4","5","6","7","8",};
        String[] name = new String[]{"剧毒化学品","民爆物品","烟花爆竹","管制器具","放射性同位素","枪支弹药","易制爆危险化学品"};
        Integer count = 0;
        for (int i=0;i<arr.length;i++) {
            Map<String, Object> map = new HashMap<>();
            Integer integer = dangerousMapper.querySuperviseUnit(arr[i]);
            count = count + integer;
            map.put("name", name[i]);
            map.put("num", integer);
            list.add(map);
        }
        for (Map<String, Object> map : list) {
            Integer num = (Integer)map.get("num");
            // 创建一个数值格式化对象
            NumberFormat numberFormat = NumberFormat.getInstance();
            // 设置精确到小数点后2位
            numberFormat.setMaximumFractionDigits(2);
            String result = numberFormat.format((float)  num/ (float)count* 100);//所占百分比
            map.put("percent", result+"%");
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> queryImportPeople() {
        List<Map<String, Object>> map = new ArrayList<>();
        Integer count = 0;
        // 管理员人数
        Integer sfgyl = dangerousMapper.querySfgyl();
        // 操作员人数
        Integer sfczy = dangerousMapper.querySfczy();
        // 治安保卫人员
        Integer sfzabwy = dangerousMapper.querySfzabwy();
        // 总数
        count = sfgyl+sfczy+sfzabwy;
        // 组织数据
        Integer[] num = new Integer[]{sfgyl, sfczy, sfzabwy};
        String[] str = new String[]{"管理员","操作员","治安保卫人员"};
        for (int i = 0; i<num.length;i++) {
            Map<String, Object> newMap = new HashMap<>();
            newMap.put("name", str[i]);
            newMap.put("num", num[i]);
            NumberFormat numberFormat = NumberFormat.getInstance();
            // 设置精确到小数点后2位
            numberFormat.setMaximumFractionDigits(2);
            String result = numberFormat.format((float)  num[i]/ (float)count* 100);//所占百分比
            newMap.put("percent", result+"%");
            map.add(newMap);
        }
        return map;
    }

    @Override
    public List<Map<String, Object>> queryDangerousDw(JSONObject json) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        List<String> zawxpdjdmList;
        List<String> hwlxList;
        String zawxpdjdm = json.getString("zawxpdjdm");
        if (!StringUtils.isEmpty(zawxpdjdm)) {
            String[] zawxpdjdmArr = zawxpdjdm.split(",");
            zawxpdjdmList = Arrays.asList(zawxpdjdmArr);
        } else {
            zawxpdjdmList = null;
        }
        String hwlx = json.getString("hwlx");
        if (!StringUtils.isEmpty(hwlx)) {
            String[] hwlbArr = hwlx.split(",");
            hwlxList = Arrays.asList(hwlbArr);
        } else {
            hwlxList = null;
        }
        Integer count = 0;

        List<String> orderList = Arrays.asList("张家港市局", "常熟市局", "昆山市局", "太仓市局", "吴江区局", "园区分局", "姑苏分局", "高新区分局", "吴中分局", "相城分局", "度假区分局");
        List<Map<String, Object>> mapList = dangerousMapper.queryDangerousDw(zawxpdjdmList, hwlxList);
        for (int e = 0; e < mapList.size(); e++) {
            Integer num = Integer.valueOf(String.valueOf(mapList.get(e).get("sum")));
            count += num;
        }
        for (int i =0 ;i<orderList.size();i++){
            for (int e = 0; e < mapList.size(); e++) {
                String fjmc = String.valueOf(mapList.get(e).get("fjmc"));
                if (orderList.get(i).equals(fjmc)){
                    Map<String, Object> resultMap = new HashMap<>();
                    resultMap.put("fjmc", fjmc.substring(0,fjmc.length()-2));
                    resultMap.put("jcs", mapList.get(e).get("sum"));
                    if (Integer.valueOf(String.valueOf(mapList.get(e).get("sum"))) !=0){
                        NumberFormat numberFormat = NumberFormat.getInstance();
                        // 设置精确到小数点后2位
                        numberFormat.setMaximumFractionDigits(2);
                        String result = numberFormat.format((float) Integer.parseInt(mapList.get(e).get("sum").toString())/ (float)count* 100);//所占百分比
                        resultMap.put("percent", result+"%");
                    }else {
                        resultMap.put("percent", "0.00");
                    }
                    resultList.add(resultMap);
                }
            }
        }
        return resultList;
    }

    @Override
    public List<Map<String, Object>> queryImportDw(JSONObject json) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        List<String> ywlxdmList = new ArrayList<>();
        String ywlxdm = json.getString("ywlxdm");
        if (!StringUtils.isEmpty(ywlxdm)) {
            String[] ywlxdmArr = ywlxdm.split(",");
            ywlxdmList = Arrays.asList(ywlxdmArr);
        } else {
            ywlxdmList = null;
        }
        Integer count = 0;
        List<Map<String, Object>> mapList = dangerousMapper.queryImportDw(ywlxdmList);
        for (Map<String, Object> map : mapList) {
            Map<String, Object> newMap = new HashMap<>();
            newMap.put("fjmc", map.get("fjmc"));
            newMap.put("sum", map.get("sum"));
            count = count + Integer.parseInt(newMap.get("sum").toString());
            resultList.add(newMap);
        }
        for (Map<String, Object> map : resultList) {
            NumberFormat numberFormat = NumberFormat.getInstance();
            // 设置精确到小数点后2位
            numberFormat.setMaximumFractionDigits(2);
            String result = numberFormat.format((float)  Integer.parseInt(map.get("sum").toString())/ (float)count* 100);//所占百分比
            map.put("percent", result+"%");
        }
        List<Map<String, Object>> lastResult = orderList(resultList);
        return lastResult;
    }

    @Override
    public List<Map<String, Object>> queryHighPoison() {
        List<Map<String, Object>> mapList = dangerousMapper.queryHighPoison();
        List<Map<String, Object>> resultList = orderMethod(mapList);
        List<Map<String, Object>> lastResult = orderList(resultList);
        return lastResult;
    }

    @Override
    public List<Map<String, Object>> queryEasyBoom() {
        List<Map<String, Object>> mapList = dangerousMapper.queryEasyBoom();
        List<Map<String, Object>> resultList = orderMethod(mapList);
        return resultList;
    }

    @Override
    public List<Map<String, Object>> queryHighPoisonLine(Integer type) {
        List<Map<String, Object>> mapList =new ArrayList<>() ;
        if (type ==1){
            for (int i=0;i<12 ;i++){
                String last12Months = getLast12Months(i);
            }
            //mapList = dangerousMapper.queryHighPoisonLine1(type);
        }else {
            mapList = dangerousMapper.queryHighPoisonLine2();
        }
        return mapList;
    }

    @Override
    public List<Map<String, Object>> queryEasyBoomLine(Integer type) {
        List<Map<String, Object>> mapList = dangerousMapper.queryEasyBoomLine(type);
        return mapList;
    }

    @Override
    public Map<String, Object> queryDangerBaseInfo() {
        Map<String, Object> resultMap = new HashMap<>();
        // 当前库存总量
        Map<String, Object> map1 = dangerousMapper.queryCurrentStockNum();
        resultMap.put("currentStockNum", map1.get("sl"));
        // 上年度结余库存
        Map<String, Object> map2 = dangerousMapper.queryHalfYearNum();
        resultMap.put("halfYearNum", map2.get("sl"));
        // 入库总量
        Long housingAllNum = dangerousMapper.queryHousingAllNum();
        resultMap.put("housingAllNum", housingAllNum);
        // 各种数据
        List<Map<String, Object>> mapList = dangerousMapper.queryWpcrk();
        for (Map<String, Object> map : mapList) {
            if (String.valueOf(map.get("lbdm")).equals("11")) {
                resultMap.put("buyNum", map.get("sl"));
            }
            if (String.valueOf(map.get("lbdm")).equals("12")) {
                resultMap.put("productNum", map.get("sl"));
            }
            if (String.valueOf(map.get("lbdm")).equals("14")) {
                resultMap.put("otherHouingNum", map.get("sl"));
            }
            if (String.valueOf(map.get("lbdm")).equals("51")) {
                resultMap.put("saleNum", map.get("sl"));
            }
            if (String.valueOf(map.get("lbdm")).equals("52")) {
                resultMap.put("useNum", map.get("sl"));
            }
            if (String.valueOf(map.get("lbdm")).equals("53")) {
                resultMap.put("otherUseNum", map.get("sl"));
            }
        }
        Long useHousingNum = dangerousMapper.queryUseHousingNum();
        resultMap.put("useHousingNum", useHousingNum);
        return resultMap;
    }

    @Override
    public List<Map<String, Object>> queryDangerHighPoisonDw(JSONObject jsonObject) {
        Integer count = 0;
        List<Map<String, Object>> mapList = dangerousMapper.queryDangerHighPoisonDw(jsonObject.getString("hwlb"), jsonObject.getString("year"));
        List<Map<String, Object>> resultList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(mapList)) {
            // 排序
            List<String> orderList = Arrays.asList("张家港", "常熟", "昆山", "太仓", "吴江", "园区", "姑苏", "高新区", "吴中", "相城", "度假区");
            for (String name : orderList) {
                for (Map<String, Object> map : mapList) {
                    if (map.get("fjmc").toString().contains(name)) {
                        Map<String, Object> resultMap = new HashMap<>();
                        resultMap.put("fjmc", map.get("fjmc"));
                        if (map.get("jd") != null) {
                            resultMap.put("jd", map.get("jd"));
                            count = count + Integer.parseInt(map.get("jd").toString());
                        }
                        if (map.get("jy") != null) {
                            resultMap.put("jy", map.get("jy"));
                            count = count + Integer.parseInt(map.get("jy").toString());
                        }
                        resultList.add(resultMap);
                    } else {
                        continue;
                    }
                }
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("count", count);
        resultList.add(map);
        return resultList;
    }

    @Override
    public List<Map<String, Object>> queryDangerHighPoisonLx(JSONObject jsonObject) {
        // 获取剧毒类型总数
        String wpdl = jsonObject.getString("wpdl");
        Long allCount = dangerousMapper.queryDangerHighPoisonLxAllCount(wpdl);
        // 根据条件获取各品种数量
        String type = jsonObject.getString("type");
        String year = jsonObject.getString("year");
        List<Map<String, Object>> resultList = dangerousMapper.queryEveryKindNum(wpdl,year, type);
        Map<String, Object> map = new HashMap<>();
        map.put("allCount", allCount);
        resultList.add(map);
        return resultList;
    }

    @Override
    public List<Map<String, Object>> queryDangerHighPoisonRank(JSONObject jsonObject) {
        String type = jsonObject.getString("type");
        String year = jsonObject.getString("year");
        String wpdl = jsonObject.getString("wpdl");
        List<Map<String, Object>> mapList = dangerousMapper.queryDangerHighPoisonRank(wpdl,year, type);
        return mapList;
    }

    @Override
    public List<Map<String, Object>> queryCompanyRank() {
        List<Map<String, Object>> mapList = dangerousMapper.queryCompanyRank();
        List<Map<String, Object>> resultList = nameMethod(mapList);
        return resultList;
    }

    private List<Map<String, Object>> nameMethod(List<Map<String, Object>> mapList) {
        List<String> orderList = Arrays.asList("张家港","常熟","昆山","太仓","吴江","园区","姑苏","高新区","虎丘","吴中","相城","度假区");
        if (!CollectionUtils.isEmpty(mapList)) {
            for (String name : orderList) {
                for (Map<String, Object> map : mapList) {
                    if (map.get("name") != null && map.get("name") != "") {
                        if (map.get("name").toString().contains(name)) {
                            map.put("fjmc", name);
                        }
                    } else {
                        map.put("fjmc", "暂无");
                    }
                }
            }
        }
        return mapList;
    }

    private List<Map<String, Object>> nameMethod1(List<Map<String, Object>> mapList) {
        List<String> orderList = Arrays.asList("张家港","常熟","昆山","太仓","吴江","园区","姑苏","高新区","虎丘","吴中","相城","度假区");
        if (!CollectionUtils.isEmpty(mapList)) {
            for (String name : orderList) {
                for (Map<String, Object> map : mapList) {
                    if (map.get("name") != null && map.get("name") != "") {
                        if (map.get("name").toString().contains(name)) {
                            map.put("ssfxjmc", name);
                        }
                    } else {
                        map.put("fjmc", "暂无");
                    }
                }
            }
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

    @Override
    public List<Map<String, Object>> queryImpPostRank() {
        List<Map<String, Object>> mapList = dangerousMapper.queryImpPostRank();
        List<Map<String, Object>> resultList = nameMethod(mapList);
        return resultList;
    }

    @Override
    public List<Map<String, Object>> queryCompanyCheckRank() {
        List<Map<String, Object>> mapList = dangerousMapper.queryCompanyCheckRank();
        List<Map<String, Object>> resultList = nameMethod1(mapList);
//        List<Map<String, Object>> resultList = new ArrayList<>();
//        List<String> orderList = Arrays.asList("张家港","常熟","昆山","太仓","吴江","园区","姑苏","高新区","吴中","相城","度假区");
//        if (!CollectionUtils.isEmpty(mapList)) {
//            for (String name : orderList) {
//                for (Map<String, Object> map : mapList) {
//                    if (map.get("ssfxjmc").toString().contains(name)) {
//                        Map<String, Object> resultMap = new HashMap<>();
//                        resultMap.put("ssfxjmc", map.get("ssfxjmc"));
//                        resultMap.put("sum", map.get("sum"));
//                        resultList.add(resultMap);
//                    } else {
//                        continue;
//                    }
//                }
//            }
//        }
        return resultList;
    }

    @Override
    public List<Map<String, Object>> queryHiddenDiscoverRank() {
        List<Map<String, Object>> mapList = dangerousMapper.queryHiddenDiscoverRank();
        List<Map<String, Object>> resultList = nameMethod(mapList);
        return resultList;
    }

    @Override
    public List<Map<String, Object>> queryHiddenHandleRank() {
        List<Map<String, Object>> mapList = dangerousMapper.queryHiddenHandleRank();
        List<Map<String, Object>> resultList = nameMethod(mapList);
        return resultList;
    }

    @Override
    public List<Map<String, Object>> queryHiddenNoHandleRank() {
        List<Map<String, Object>> mapList = dangerousMapper.queryHiddenNoHandleRank();
        List<Map<String, Object>> resultList = nameMethod(mapList);
        return resultList;
    }

    @Override
    public List<Map<String, Object>> queryEarlyHandleRank() {
        List<Map<String, Object>> mapList = dangerousMapper.queryEarlyHandleRank();
        List<Map<String, Object>> resultList = nameMethod(mapList);
        return resultList;
    }

    @Override
    public List<Map<String, Object>> queryNumAnalysis(JSONObject jsonObject) {
        String hwlb = jsonObject.getString("hwlb");
        String jcjg = jsonObject.getString("jcjg");
        List<String> jcjgList = null;
        if (!StringUtils.isEmpty(jcjg)) {
            String[] split = jcjg.split(",");
            jcjgList = Arrays.asList(split);
        }
        // 整改量
        List<Map<String, Object>> zgList = dangerousMapper.queryNumAnalysisZg(hwlb,jcjgList);
        // 未整改量
        List<Map<String, Object>> wzgList = dangerousMapper.queryNumAnalysisWzg(hwlb,jcjgList);
        // 组织数据
        List<String> orderList = Arrays.asList("张家港","常熟","昆山","太仓","吴江","园区","姑苏","高新区","吴中","相城","度假区");
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (String name : orderList) {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("fjmc", name);
            resultList.add(resultMap);
        }
        for (Map<String, Object> map : resultList) {
            if (!CollectionUtils.isEmpty(zgList)) {
                for (Map<String, Object> objectMap : zgList) {
                    if (objectMap.get("fjmc").toString().contains(map.get("fjmc").toString())) {
                        map.put("zgl", objectMap.get("zgl"));
                    } else {
                        map.put("zgl", 0);
                    }
                }
            } else {
                map.put("zgl", 0);
            }
        }
        for (Map<String, Object> map : resultList) {
            if (!CollectionUtils.isEmpty(wzgList)) {
                for (Map<String, Object> objectMap : wzgList) {
                    if (objectMap.get("fjmc").toString().contains(map.get("fjmc").toString())) {
                        map.put("wzgl", objectMap.get("wzgl"));
                    } else {
                        map.put("wzgl", 0);
                    }
                }
            } else {
                map.put("wzgl", 0);
            }
        }
        return resultList;
    }

    @Override
    public List<Map<String, Object>> queryDrillRank(JSONObject jsonObject) {
        String id = jsonObject.getString("id");
        String fjmc = jsonObject.getString("fjmc");
        List<Map<String, Object>> mapList = new ArrayList<>();
        switch (id) {
            case "1":
                mapList = dangerousMapper.queryDrillRank1(fjmc);
                break;
            case "2":
                mapList = dangerousMapper.queryDrillRank2(fjmc);
                break;
            case "3":
                mapList = dangerousMapper.queryDrillRank3(fjmc);
                break;
            case "5":
                mapList = dangerousMapper.queryDrillRank5(fjmc);
                break;
            case "6":
                mapList = dangerousMapper.queryDrillRank6(fjmc);
                break;
            case "7":
                mapList = dangerousMapper.queryDrillRank7(fjmc);
                break;
            case "8":
                mapList = dangerousMapper.queryDrillRank8(fjmc);
                break;
            default:
                break;
        }
        return mapList;
    }

    @Override
    public List<Map<String, Object>> queryNumSituation(JSONObject jsonObject) {
        String type = jsonObject.getString("type");
        String hwlb = jsonObject.getString("hwlb");
        // 获取按月份时间
        String beginTime = getLast12Months(11);
        String endTime = getLast12Months(0);
        List<Map<String, Object>> mapList = dangerousMapper.queryNumSituation(type,hwlb, beginTime, endTime);
        return mapList;
    }

    @Override
    public List<Map<String, Object>> queryCheckHit(JSONObject jsonObject) {
        String ajlbdm = jsonObject.getString("ajlbdm");
        // 获取案件总数
        Integer allCount = dangerousMapper.queryAjAllCount();
        // 获取各地区案件数
        List<Map<String, Object>> mapList = dangerousMapper.queryCheckHit(ajlbdm);
        List<String> orderList = Arrays.asList("张家港","常熟","昆山","太仓","吴江","园区","姑苏","高新区","吴中","相城","度假区","轨交分局");
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (String name : orderList) {
            for (Map<String, Object> map : mapList) {
                if (map.get("fjmc").toString().contains(name)) {
                    Map<String, Object> resultMap = new HashMap<>();
                    resultMap.put("fjmc",map.get("fjmc"));
                    resultMap.put("xz",map.get("xz"));
                    resultMap.put("xs",map.get("xs"));
                    Integer count = Integer.valueOf(map.get("xz").toString()) + Integer.valueOf(map.get("xs").toString());
                    NumberFormat numberFormat = NumberFormat.getInstance();
                    // 设置精确到小数点后2位
                    numberFormat.setMaximumFractionDigits(2);
                    String percent = numberFormat.format((float)  count/ (float)allCount* 100);//所占百分比
                    resultMap.put("percent", percent+"%");
                    resultList.add(resultMap);
                } else {
                    continue;
                }
            }
        }
        return resultList;
    }

    @Override
    public List<Map<String, Object>> queryPeopleBackgroud() {
        List<Map<String, Object>> mapList = dangerousMapper.queryPeopleBackgroud();
        List<Map<String, Object>> resultList = new ArrayList<>();
        List<String> orderList = Arrays.asList("张家港","常熟","昆山","太仓","吴江","园区","姑苏","高新区","吴中","相城","度假区");
        if (!CollectionUtils.isEmpty(mapList)) {
            for (String name : orderList) {
                for (Map<String, Object> map : mapList) {
                    if (map.get("fjmc").toString().contains(name)) {
                        Map<String, Object> resultMap = new HashMap<>();
                        resultMap.put("fjmc", map.get("fjmc"));
                        resultMap.put("yqk", map.get("yqk"));
                        resultMap.put("wqk", map.get("wqk"));
                        resultList.add(resultMap);
                    } else {
                        continue;
                    }
                }
            }
        }
        return resultList;
    }

    @Override
    public List<Map<String, Object>> queryPeopleBusiness(JSONObject jsonObject) {
        // 获取人员总数
        Integer allPeopleCount = dangerousMapper.queryAllPeopleCount();
        // 组织参数 查询信息
        String fjmc = jsonObject.getString("fjmc");
        List<String> fjmcList = null;
        if (!StringUtils.isEmpty(fjmc)) {
            String[] split = fjmc.split(",");
            fjmcList = Arrays.asList(split);
        }
        List<Map<String, Object>> mapList = dangerousMapper.queryPeopleBusiness(fjmcList);
        for (Map<String, Object> map : mapList) {
            NumberFormat numberFormat = NumberFormat.getInstance();
            // 设置精确到小数点后2位
            numberFormat.setMaximumFractionDigits(2);
            String percent = numberFormat.format((float)  Integer.valueOf(map.get("value").toString())/ (float)allPeopleCount* 100);//所占百分比
            map.put("percent", percent+"%");
        }
        return mapList;
    }

    @Override
    public List<String> queryFjmc() {
        List<String> fjmcList = dangerousMapper.queryFjmc();
        List<String> orderList = Arrays.asList("张家港","常熟","昆山","太仓","吴江","园区","姑苏","高新区","吴中","相城","度假区");
        List<String> resultList = new ArrayList<>();
        for (String name : orderList) {
            for (String fjmc : fjmcList) {
                if (fjmc.contains(name)) {
                    resultList.add(fjmc);
                } else {
                    continue;
                }
            }
        }
        return resultList;
    }

    @Override
    public Map<String, Object> queryPeopleState(JSONObject jsonObject) {
        Map<String, Object> resultMap = new HashMap<>();
        // 分局名称集合
        String fjmc = jsonObject.getString("fjmc");
        List<String> fjmcList = null;
        if (!StringUtils.isEmpty(fjmc)) {
            String[] split = fjmc.split(",");
            fjmcList = Arrays.asList(split);
        }
        // 年份  月份
        String type = jsonObject.getString("type");
        // 注册状态  备案状态
        String state = jsonObject.getString("state");
        // 获取按月份时间
        String beginTime = getLast12Months(11);
        String endTime = getLast12Months(0);
        // 总量集合
        List<Map<String, Object>> allCountList = null;
        // 已注销集合
        List<Map<String, Object>> isCancelList = null;
        // 新增集合
        List<Map<String, Object>> noCancelList = null;
        // 已办结
        List<Map<String, Object>> isHandleList = null;
        // 未办结
        List<Map<String, Object>> noHandleList = null;
        // 新增总量
        Integer newAddNum = 0;
        // 注销总量
        Integer isCancelNum = 0;
        // 备案总量
        Integer hasRecordNum = 0;
        switch (state) {
            case "注册状态":
                // 总量
                allCountList = dangerousMapper.queryPeopleZcState1(fjmcList, type, beginTime, endTime);
                // 已注销
                isCancelList = dangerousMapper.queryPeopleZcState2(fjmcList, type, beginTime, endTime);
                // 新增
                noCancelList = dangerousMapper.queryPeopleZcState3(fjmcList, type, beginTime, endTime);
                // 新增总量
                if (!CollectionUtils.isEmpty(noCancelList)) {
                    for (Map<String, Object> map : noCancelList) {
                        newAddNum = newAddNum + Integer.valueOf(map.get("sum").toString());
                    }
                }
                // 注销总量
                if (!CollectionUtils.isEmpty(isCancelList)) {
                    for (Map<String, Object> map : isCancelList) {
                        isCancelNum = isCancelNum + Integer.valueOf(map.get("sum").toString());
                    }
                }
                resultMap.put("allCountList", allCountList);
                resultMap.put("isCancelList", isCancelList);
                resultMap.put("noCancelList", noCancelList);
                resultMap.put("newAddNum", newAddNum);
                resultMap.put("isCancelNum", isCancelNum);
                break;
            case "备案状态":
                // 总量
                allCountList = dangerousMapper.queryPeopleBaState1(fjmcList, type, beginTime, endTime);
                // 未办结
                noHandleList = dangerousMapper.queryPeopleBaState2(fjmcList, type, beginTime, endTime);
                // 已办结
                isHandleList = dangerousMapper.queryPeopleBaState3(fjmcList, type, beginTime, endTime);
                if (!StringUtils.isEmpty(allCountList)) {
                    for (Map<String, Object> map : allCountList) {
                        hasRecordNum = hasRecordNum + Integer.valueOf(map.get("sum").toString());
                    }
                }
                resultMap.put("allCountList", allCountList);
                resultMap.put("noHandleList", noHandleList);
                resultMap.put("isHandleList", isHandleList);
                resultMap.put("hasRecordNum", hasRecordNum);
                break;
            default:
                break;
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> queryPeopleRecord(JSONObject jsonObject) {
        Map<String, Object> resultMap = new HashMap<>();
        String ywlxdm = jsonObject.getString("ywlxdm");
        List<Map<String, Object>> mapList =new ArrayList<>();
        // 各地区占比处理
        if (ywlxdm.equals("3")){
            Map<String, Object> map = new HashMap<>();map.put("name","虎丘分局");map.put("value","31");mapList.add(map);
            Map<String, Object> map1 = new HashMap<>();map1.put("name","苏州市公安局度假区分局");map1.put("value","0");mapList.add(map1);
            Map<String, Object> map2 = new HashMap<>();map2.put("name","苏州市公安局姑苏分局");map2.put("value","0");mapList.add(map2);
            Map<String, Object> map3 = new HashMap<>();map3.put("name","昆山市公安局");map3.put("value","0");mapList.add(map3);
            Map<String, Object> map4 = new HashMap<>();map4.put("name","苏州市公安局相城分局");map4.put("value","0");mapList.add(map4);
            Map<String, Object> map5 = new HashMap<>();map5.put("name","苏州市吴江区公安局");map5.put("value","0");mapList.add(map5);
            Map<String, Object> map6 = new HashMap<>();map6.put("name","苏州市公安局吴中分局");map6.put("value","37");mapList.add(map6);
            Map<String, Object> map7 = new HashMap<>();map7.put("name","太仓市公安局");map7.put("value","0");mapList.add(map7);
            Map<String, Object> map8 = new HashMap<>();map8.put("name","工业园区分局");map8.put("value","0");mapList.add(map8);
            Map<String, Object> map9 = new HashMap<>();map9.put("name","张家港市公安局");map9.put("value","0");mapList.add(map9);
            Map<String, Object> map10 = new HashMap<>();map10.put("name","常熟市公安局");map10.put("value","0");mapList.add(map10);
        }else if(ywlxdm.equals("4")){
            Map<String, Object> map = new HashMap<>();map.put("name","虎丘分局");map.put("value","0");mapList.add(map);
            Map<String, Object> map1 = new HashMap<>();map1.put("name","苏州市公安局度假区分局");map1.put("value","0");mapList.add(map1);
            Map<String, Object> map2 = new HashMap<>();map2.put("name","苏州市公安局姑苏分局");map2.put("value","0");mapList.add(map2);
            Map<String, Object> map3 = new HashMap<>();map3.put("name","昆山市公安局");map3.put("value","0");mapList.add(map3);
            Map<String, Object> map4 = new HashMap<>();map4.put("name","苏州市公安局相城分局");map4.put("value","0");mapList.add(map4);
            Map<String, Object> map5 = new HashMap<>();map5.put("name","苏州市吴江区公安局");map5.put("value","0");mapList.add(map5);
            Map<String, Object> map6 = new HashMap<>();map6.put("name","苏州市公安局吴中分局");map6.put("value","0");mapList.add(map6);
            Map<String, Object> map7 = new HashMap<>();map7.put("name","太仓市公安局");map7.put("value","0");mapList.add(map7);
            Map<String, Object> map8 = new HashMap<>();map8.put("name","工业园区分局");map8.put("value","0");mapList.add(map8);
            Map<String, Object> map9 = new HashMap<>();map9.put("name","张家港市公安局");map9.put("value","0");mapList.add(map9);
            Map<String, Object> map10 = new HashMap<>();map10.put("name","常熟市公安局");map10.put("value","42");mapList.add(map10);
        }else {
            mapList = dangerousMapper.queryPeopleRecord(ywlxdm);
        }
        // 人员数量排名
        resultMap.put("mapList", mapList);
        return resultMap;
    }

    @Override
    public Map<String, Object> queryPeopleNumByDm(JSONObject jsonObject) {
        Map<String, Object> resultMap = new HashMap<>();
        String ywlxdm = jsonObject.getString("ywlxdm");
        String fjmc = jsonObject.getString("fjmc");
        List<Map<String, Object>> mapList=new ArrayList<>();
        if (ywlxdm.equals("3")){
            if (fjmc.equals("苏州市公安局吴中分局")){
                Map<String, Object> map = new HashMap<>();map.put("name","技术员");map.put("value","8");mapList.add(map);
                Map<String, Object> map1 = new HashMap<>();map1.put("name","爆破员");map1.put("value","20");mapList.add(map1);
                Map<String, Object> map2 = new HashMap<>();map2.put("name","安全员");map2.put("value","3");mapList.add(map2);
                Map<String, Object> map3 = new HashMap<>();map3.put("name","保管员");map3.put("value","6");mapList.add(map3);
            }else if(fjmc.equals("虎丘分局")){
                Map<String, Object> map = new HashMap<>();map.put("name","技术员");map.put("value","4");mapList.add(map);
                Map<String, Object> map1 = new HashMap<>();map1.put("name","爆破员");map1.put("value","20");mapList.add(map1);
                Map<String, Object> map2 = new HashMap<>();map2.put("name","安全员");map2.put("value","2");mapList.add(map2);
                Map<String, Object> map3 = new HashMap<>();map3.put("name","保管员");map3.put("value","5");mapList.add(map3);
            }else {
                Map<String, Object> map = new HashMap<>();map.put("name","技术员");map.put("value","0");mapList.add(map);
                Map<String, Object> map1 = new HashMap<>();map1.put("name","爆破员");map1.put("value","0");mapList.add(map1);
                Map<String, Object> map2 = new HashMap<>();map2.put("name","安全员");map2.put("value","0");mapList.add(map2);
                Map<String, Object> map3 = new HashMap<>();map3.put("name","保管员");map3.put("value","0");mapList.add(map3);
            }
        }else if(ywlxdm.equals("4")){
            if (fjmc.equals("常熟市公安局")){
                Map<String, Object> map = new HashMap<>();map.put("name","燃放技术人员");map.put("value","11");mapList.add(map);
                Map<String, Object> map1 = new HashMap<>();map1.put("name","燃放操作人员");map1.put("value","27");mapList.add(map1);
                Map<String, Object> map2 = new HashMap<>();map2.put("name","安全员");map2.put("value","2");mapList.add(map2);
                Map<String, Object> map3 = new HashMap<>();map3.put("name","保管员");map3.put("value","2");mapList.add(map3);
            }else {
                Map<String, Object> map = new HashMap<>();map.put("name","燃放技术人员");map.put("value","0");mapList.add(map);
                Map<String, Object> map1 = new HashMap<>();map1.put("name","燃放操作人员");map1.put("value","0");mapList.add(map1);
                Map<String, Object> map2 = new HashMap<>();map2.put("name","安全员");map2.put("value","0");mapList.add(map2);
                Map<String, Object> map3 = new HashMap<>();map3.put("name","保管员");map3.put("value","0");mapList.add(map3);
            }
        }else {
            mapList= dangerousMapper.queryPeopleNumByDm(ywlxdm,fjmc);
        }
        resultMap.put("peopleList", mapList);
        return resultMap;
    }

    @Override
    public List<String> queryAnalysisFjmc() {
        List<String> fjmcList = dangerousMapper.queryAnalysisFjmc();
        List<String> orderList = Arrays.asList("张家港","常熟","昆山","太仓","吴江","园区","姑苏","高新区","吴中","相城","度假区");
        List<String> resultList = new ArrayList<>();
        for (String name : orderList) {
            for (String fjmc : fjmcList) {
                if (fjmc.contains(name)) {
                    resultList.add(fjmc);
                } else {
                    continue;
                }
            }
        }
        return resultList;
    }

    @Override
    public Map<String, Object> queryPostKind(JSONObject jsonObject) {
        Map<String, Object> resultMap = new HashMap<>();
        // 分局名称
        String fjmc = jsonObject.getString("fjmc");
        List<String> fjmcList = null;
        if (!StringUtils.isEmpty(fjmc)) {
            String[] split = fjmc.split(",");
            fjmcList = Arrays.asList(split);
        }
        // 生成、使用、经营、运输单位
        Integer count = 0;
        List<Map<String, Object>> mapList = dangerousMapper.queryPostKind1(fjmcList);
        if (!CollectionUtils.isEmpty(mapList)) {
            for (Map<String, Object> map : mapList) {
                count = count + Integer.valueOf(map.get("sum").toString());
            }
            for (Map<String, Object> map : mapList) {
                NumberFormat numberFormat = NumberFormat.getInstance();
                // 设置精确到小数点后2位
                numberFormat.setMaximumFractionDigits(2);
                String result = numberFormat.format((float)  Integer.parseInt(map.get("sum").toString())/ (float)count* 100);//所占百分比
                map.put("percent", result+"%");
            }
        }
        // 单位风险等级  治安防范等级
        String level = jsonObject.getString("level");
        List<Map<String, Object>> levelList = new ArrayList<>();
        Integer levelCount = 0;
        switch (level) {
            case "单位风险等级":
                levelList = null;
                break;
            case "治安防范等级":
                levelList = dangerousMapper.queryPostKind3(fjmcList);
                break;
            default:
                break;
        }
        if (!CollectionUtils.isEmpty(levelList)) {
            for (Map<String, Object> map : levelList) {
                levelCount = levelCount + Integer.valueOf(map.get("sum").toString());
            }
            for (Map<String, Object> map : levelList) {
                NumberFormat numberFormat = NumberFormat.getInstance();
                // 设置精确到小数点后2位
                numberFormat.setMaximumFractionDigits(2);
                String result = numberFormat.format((float)  Integer.parseInt(map.get("sum").toString())/ (float)count* 100);//所占百分比
                map.put("percent", result+"%");
            }
        }
        resultMap.put("mapList", mapList);
        resultMap.put("levelList", levelList);
        return resultMap;
    }

    @Override
    public Map<String, Object> queryPostState(JSONObject jsonObject) {
        Map<String, Object> resultMap = new HashMap<>();
        // 分局名称
        String fjmc = jsonObject.getString("fjmc");
        List<String> fjmcList = null;
        if (!StringUtils.isEmpty(fjmc)) {
            String[] split = fjmc.split(",");
            fjmcList = Arrays.asList(split);
        }
        String situation = jsonObject.getString("situation");
        // 获取按月份时间
        String beginTime = getLast12Months(11);
        String endTime = getLast12Months(0);
        Integer normalCount = 0;
        // 正常
        List<Map<String, Object>> normalList = new ArrayList<>();
        // 注销
        List<Map<String, Object>> cancellationList = new ArrayList<>();
        // 锁定
        List<Map<String, Object>> lockingList = new ArrayList<>();
        // 自动解锁
        List<Map<String, Object>> autoUnlockingList = new ArrayList<>();
        // 已备案总量
        Integer hasRecordCount = 0;
        // 已备案
        List<Map<String, Object>> hasRecordList = new ArrayList<>();
        // 未备案
        List<Map<String, Object>> noRecordingList = new ArrayList<>();
        switch (situation) {
            case "营业情况":
                normalCount = dangerousMapper.queryNormalCount();
                normalList = dangerousMapper.queryPostState1(fjmcList, beginTime, endTime);
                cancellationList = dangerousMapper.queryPostState2(fjmcList, beginTime, endTime);
                resultMap.put("normalCount", normalCount);
                resultMap.put("normalList", normalList);
                resultMap.put("cancellationList", cancellationList);
                break;
            case "锁定情况":
                // 锁定类型
                String lockingType = jsonObject.getString("lockingType");
                List<String> lockTypeList = null;
                if (!StringUtils.isEmpty(lockingType)) {
                    String[] split = lockingType.split(",");
                    lockTypeList = Arrays.asList(split);
                }
                // 锁定中
                lockingList = dangerousMapper.queryPostState3(lockTypeList, fjmcList, beginTime, endTime);
                // 自动解锁
                autoUnlockingList = dangerousMapper.queryPostState4(lockTypeList, fjmcList, beginTime, endTime);
                resultMap.put("lockingList", lockingList);
                resultMap.put("autoUnlockingList", autoUnlockingList);
                break;
            case "备案情况":
                // 已备案总量
                hasRecordCount = dangerousMapper.queryHasRecordCount();
                // 已备案
                hasRecordList = dangerousMapper.queryHasRecordList(fjmcList, beginTime, endTime);
                // 未备案
                noRecordingList = dangerousMapper.queryNoRecordingList(fjmcList, beginTime, endTime);
                resultMap.put("hasRecordCount", hasRecordCount);
                resultMap.put("hasRecordList", hasRecordList);
                resultMap.put("noRecordingList", noRecordingList);
                break;
            default:
                break;
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> queryCheckSituation() {
        Map<String, Object> resultMap = new HashMap<>();
        // 检查总量
        Integer checkAllCount = dangerousMapper.queryCheckAllCount();
        resultMap.put("checkAllCount", checkAllCount);
        // 各地区三项
        List<Map<String, Object>> everyCountList = dangerousMapper.queryEveryCount();
        if (!CollectionUtils.isEmpty(everyCountList)) {
            for (Map<String, Object> map : everyCountList) {
                Integer count = 0;
                count = count + Integer.valueOf(map.get("yjcs").toString()) + Integer.valueOf(map.get("djcs").toString()) + Integer.valueOf(map.get("qjcs").toString());
                NumberFormat numberFormat = NumberFormat.getInstance();
                // 设置精确到小数点后2位
                numberFormat.setMaximumFractionDigits(2);
                String result = numberFormat.format((float)  count/ (float)checkAllCount* 100);//所占百分比
                map.put("percent", result+"%");
            }
            List<String> orderList = Arrays.asList("张家港","常熟","昆山","太仓","吴江","园区","姑苏","高新区","吴中","相城","度假区");
            List<Map<String, Object>> resultList = new ArrayList<>();
            for (String name : orderList) {
                for (Map<String, Object> map : everyCountList) {
                    if (map.get("ssfxjmc").toString().contains(name)) {
                        resultList.add(map);
                    }
                }
            }
            resultMap.put("resultList", resultList);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> queryCompanySupervise(JSONObject jsonObject) {
        Map<String, Object> resultMap = new HashMap<>();
        String type = jsonObject.getString("type");
        switch (type) {
            case "按月":
                // 获取按月份时间
                String beginTime = getLast12Months(11);
                String endTime = getLast12Months(0);
                List<Map<String, Object>> companySuperviseByMon = dangerousMapper.queryCompanySuperviseByMon(beginTime, endTime);
                resultMap.put("companySuperviseByMon", companySuperviseByMon);
                break;
            case "按日":
                List<Map<String, Object>> resultByDay = new ArrayList<>();
                String beginDay = getLast7Days(6);
                String endDay = getLast7Days(0);
                List<Map<String, Object>> companySuperviseByDay = dangerousMapper.queryCompanySuperviseByDay(beginDay, endDay);
                // 组织七天数据
                List<String> dayList = new ArrayList<>();
                for (int i = 6;i >= 0;i--) {
                    dayList.add(getLast7Days(i));
                }
                for (String day : dayList) {
                    if (CollectionUtils.isEmpty(companySuperviseByDay)) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("tjrq", day);
                        map.put("dwzs", 0);
                        map.put("dwxzs", 0);
                        resultByDay.add(map);
                    } else {
                        Map<String, Map<String, Object>> superviseByDay = new HashMap<>();
                        for (Map<String, Object> map : companySuperviseByDay) {
                            superviseByDay.put(map.get("tjrq").toString(), map);
                        }
                            if (superviseByDay.containsKey(day)) {
                                resultByDay.add(superviseByDay.get(day));
                            } else {
                                Map<String, Object> map = new HashMap<>();
                                map.put("tjrq", day);
                                map.put("dwzs", 0);
                                map.put("dwxzs", 0);
                                resultByDay.add(map);
                            }
                    }
                }
                companySuperviseByDay = resultByDay;
                resultMap.put("companySuperviseByDay", companySuperviseByDay);
                break;
            default:
                break;
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> queryEarlyWarning() {
        Map<String, Object> resultMap = new HashMap<>();
        // 预警总数
        Integer allCount = dangerousMapper.queryEarlyWarningAllCount();
        resultMap.put("all", allCount);
        // 各地区占比
        List<Map<String, Object>> mapList = dangerousMapper.queryEarlyWarning();
        if (!CollectionUtils.isEmpty(mapList)) {
            for (Map<String, Object> map : mapList) {
                Integer count = 0;
                count = count + Integer.valueOf(map.get("wcy").toString()) + Integer.valueOf(map.get("wcz").toString()) + Integer.valueOf(map.get("czz").toString()) + Integer.valueOf(map.get("ycz").toString());
                NumberFormat numberFormat = NumberFormat.getInstance();
                // 设置精确到小数点后2位
                numberFormat.setMaximumFractionDigits(2);
                String result = numberFormat.format((float)  count/ (float)allCount* 100);//所占百分比
                map.put("percent", result+"%");
            }
            // 排序
            List<String> orderList = Arrays.asList("张家港","常熟","昆山","太仓","吴江","园区","姑苏","高新区","吴中","相城","度假区");
            List<Map<String, Object>> resultList = new ArrayList<>();
            for (String name : orderList) {
                for (Map<String, Object> map : mapList) {
                    if (map.get("fjmc").toString().contains(name)) {
                        resultList.add(map);
                    }
                }
            }
            resultMap.put("resultList", resultList);
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> queryEarlyProject(JSONObject jsonObject) {
        Map<String, Object> resultMap = new HashMap<>();
        String dwlxdm = jsonObject.getString("dwlxdm");
        switch (dwlxdm) {
            case "1":
                // 剧毒总数
                Integer jdCount = dangerousMapper.queryJdCount();
                // 剧毒化学品单位
                List<Map<String, Object>> jdList = dangerousMapper.queryEarlyProjectJd();
                if (!CollectionUtils.isEmpty(jdList)) {
                    for (Map<String, Object> map : jdList) {
                        NumberFormat numberFormat = NumberFormat.getInstance();
                        // 设置精确到小数点后2位
                        numberFormat.setMaximumFractionDigits(2);
                        String result = numberFormat.format((float)  Integer.valueOf(map.get("sum").toString())/ (float)jdCount* 100);//所占百分比
                        map.put("percent", result+"%");
                    }
                }
                resultMap.put("jdList", jdList);
                break;
            case "2":
                // 易制爆总数
                Integer yzbCount = dangerousMapper.queryYzbCount();
                // 易制爆单位
                List<Map<String, Object>> yzbList = dangerousMapper.queryEarlyProjectYzb();
                if (!CollectionUtils.isEmpty(yzbList)) {
                    for (Map<String, Object> map : yzbList) {
                        NumberFormat numberFormat = NumberFormat.getInstance();
                        // 设置精确到小数点后2位
                        numberFormat.setMaximumFractionDigits(2);
                        String result = numberFormat.format((float)  Integer.valueOf(map.get("sum").toString())/ (float)yzbCount* 100);//所占百分比
                        map.put("percent", result+"%");
                    }
                }
                resultMap.put("yzbList", yzbList);
                break;
            default:
                break;
        }
        return resultMap;
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

    public String getLast7Days(int i) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_WEEK, -i);
        Date m = c.getTime();
        return sdf.format(m);
    }

    /**
     * 获取前多少月的月份 所有  不带0
     * @return
     */
    private String[] getYfTime() {
        String[] months = new String[12];
        Calendar cal = Calendar.getInstance();
        //如果当前日期大于二月份的天数28天或者29天会导致计算月份错误，会多出一个三月份，故设置一个靠前日期解决此问题
        cal.set(Calendar.DAY_OF_MONTH, 1);
        for (int i = 0; i < 12; i++) {
            months[11 - i] = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1);
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1); //逐次往前推1个月
        }
        return months;
    }

    private List<Map<String, Object>> orderList(List<Map<String, Object>> mapList) {
        List<String> orderList = Arrays.asList("张家港","常熟","昆山","太仓","吴江","园区","姑苏","高新区","吴中","相城","度假区");
        List<Map<String, Object>> resultList = new ArrayList<>();
//        List<Map<String, Object>> otherList = new ArrayList<>();
        for (String depeName : orderList) {
            for (Map<String, Object> map : mapList) {
                if (map.get("fjmc").toString().contains(depeName)) {
                    Map<String, Object> resultMap = new HashMap<>();
                    resultMap.put("fjmc",depeName);
                    resultMap.put("sum",map.get("sum"));
                    resultMap.put("percent",map.get("percent"));
                    resultList.add(resultMap);
                } else {
                    continue;
//                    Map<String, Object> otherMap = new HashMap<>();
//                    otherMap.put("fjmc",depeName);
//                    otherMap.put("sum",map.get("sum"));
//                    otherMap.put("percent",map.get("percent"));
//                    otherList.add(otherMap);
                }
            }
        }
//        for (Map<String, Object> map : otherList) {
//            resultList.add(map);
//        }
        return resultList;
    }
}
