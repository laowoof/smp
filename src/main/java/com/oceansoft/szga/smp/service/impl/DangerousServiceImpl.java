package com.oceansoft.szga.smp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.oceansoft.szga.smp.mapper.DangerousMapper;
import com.oceansoft.szga.smp.service.DangerousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.NumberFormat;
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
        List<Map<String, Object>> mapList = dangerousMapper.queryDangerousDw(zawxpdjdmList, hwlxList);
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
        return mapList;
    }

    @Override
    public List<Map<String, Object>> queryEasyBoom() {
        List<Map<String, Object>> mapList = dangerousMapper.queryEasyBoom();
        return mapList;
    }

    @Override
    public List<Map<String, Object>> queryHighPoisonLine(Integer type) {
        List<Map<String, Object>> mapList = dangerousMapper.queryHighPoisonLine(type);
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
        List<Map<String, Object>> resultList = orderMethod(mapList);
        return resultList;
    }

    private List<Map<String, Object>> orderMethod(List<Map<String, Object>> mapList) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        List<String> orderList = Arrays.asList("张家港","常熟","昆山","太仓","吴江","园区","姑苏","高新区","吴中","相城","度假区");
        if (!CollectionUtils.isEmpty(mapList)) {
            for (String name : orderList) {
                for (Map<String, Object> map : mapList) {
                    if (map.get("fjmc").toString().contains(name)) {
                        Map<String, Object> resultMap = new HashMap<>();
                        resultMap.put("fjmc", map.get("fjmc"));
                        resultMap.put("sum", map.get("sum"));
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
    public List<Map<String, Object>> queryImpPostRank() {
        List<Map<String, Object>> mapList = dangerousMapper.queryImpPostRank();
        List<Map<String, Object>> resultList = orderMethod(mapList);
        return resultList;
    }

    @Override
    public List<Map<String, Object>> queryCompanyCheckRank() {
        List<Map<String, Object>> mapList = dangerousMapper.queryCompanyCheckRank();
        List<Map<String, Object>> resultList = new ArrayList<>();
        List<String> orderList = Arrays.asList("张家港","常熟","昆山","太仓","吴江","园区","姑苏","高新区","吴中","相城","度假区");
        if (!CollectionUtils.isEmpty(mapList)) {
            for (String name : orderList) {
                for (Map<String, Object> map : mapList) {
                    if (map.get("ssfxjmc").toString().contains(name)) {
                        Map<String, Object> resultMap = new HashMap<>();
                        resultMap.put("ssfxjmc", map.get("ssfxjmc"));
                        resultMap.put("sum", map.get("sum"));
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
    public List<Map<String, Object>> queryHiddenDiscoverRank() {
        List<Map<String, Object>> mapList = dangerousMapper.queryHiddenDiscoverRank();
        List<Map<String, Object>> resultList = orderMethod(mapList);
        return resultList;
    }

    @Override
    public List<Map<String, Object>> queryHiddenHandleRank() {
        List<Map<String, Object>> mapList = dangerousMapper.queryHiddenHandleRank();
        List<Map<String, Object>> resultList = orderMethod(mapList);
        return resultList;
    }

    @Override
    public List<Map<String, Object>> queryHiddenNoHandleRank() {
        List<Map<String, Object>> mapList = dangerousMapper.queryHiddenNoHandleRank();
        List<Map<String, Object>> resultList = orderMethod(mapList);
        return resultList;
    }

    @Override
    public List<Map<String, Object>> queryEarlyHandleRank() {
        List<Map<String, Object>> mapList = dangerousMapper.queryEarlyHandleRank();
        List<Map<String, Object>> resultList = orderMethod(mapList);
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
        String beginTime = null;
        String endTime = null;
        String[] yfTime = getYfTime();
        for (int i=0;i<yfTime.length-1;i++) {
            beginTime = yfTime[0];
            endTime = yfTime[11];
        }
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
