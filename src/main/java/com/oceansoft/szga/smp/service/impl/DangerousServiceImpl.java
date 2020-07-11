package com.oceansoft.szga.smp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.oceansoft.szga.smp.mapper.DangerousMapper;
import com.oceansoft.szga.smp.service.DangerousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        String hwlx = json.getString("hwlx");
        if (!StringUtils.isEmpty(zawxpdjdm)) {
            String[] zawxpdjdmArr = zawxpdjdm.split(",");
            zawxpdjdmList = Arrays.asList(zawxpdjdmArr);
        } else {
            zawxpdjdmList = null;
        }
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
            newMap.put("name", map.get("fjmc"));
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
        return resultList;
    }
}
