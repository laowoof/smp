package com.oceansoft.szga.smp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.oceansoft.szga.smp.entity.bean.QuestionQueryBean;
import com.oceansoft.szga.smp.mapper.ProcessChargeMapper;
import com.oceansoft.szga.smp.service.ProcessChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 流程监管实现层
 *
 * @author JackChan
 * @Date 2020/7/10 0010 上午 11:15
 */
@Service
public class ProcessChargeServiceImpl implements ProcessChargeService {

    @Autowired
    private ProcessChargeMapper processChargeMapper;

    // 中队审核
    private static List<Integer> zdCheck = Arrays.asList(2,3,4,5);
    // 大队审核
    private static List<Integer> ddCheck = Arrays.asList(6,7,8,9);
    // 业务部门审核
    private static List<Integer> ywCheck = Arrays.asList(10,11,12,13);
    // 支队审核
    private static List<Integer> detachmentCheck = Arrays.asList(14,15,16,17);

    @Override
    public Map<String, Object> queryRoadSafeTable(QuestionQueryBean questionQueryBean) {
        Map<String, Object> map = new HashMap<>();
        int pageNum = questionQueryBean.getPageNum() == null ? 1 : questionQueryBean.getPageNum();
        int pageSize = questionQueryBean.getPageSize() == null ? 10 : questionQueryBean.getPageSize();
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> mapList = processChargeMapper.queryRoadSafeTable(questionQueryBean);
        if (!CollectionUtils.isEmpty(mapList)) {
            for (Map<String, Object> objectMap : mapList) {
                objectMap.put("dept", "交警");
                if (!StringUtils.isEmpty(objectMap.get("clzt").toString())) {
                    if (objectMap.get("clzt").toString().equals("1")) {
                        objectMap.put("state", "未完成");
                    } else {
                        objectMap.put("state", "已完成");
                    }
                }
                if (!StringUtils.isEmpty(objectMap.get("lczt").toString())) {
                    if (objectMap.get("lczt").toString().equals("1")) {
                        objectMap.put("dqlcjd", "民警录入");
                    }
                    if (zdCheck.contains(objectMap.get("lczt"))) {
                        objectMap.put("dqlcjd", "中队审核");
                    }
                    if (ddCheck.contains(objectMap.get("lczt"))) {
                        objectMap.put("dqlcjd", "大队审核");
                    }
                    if (ywCheck.contains(objectMap.get("lczt"))) {
                        objectMap.put("dqlcjd", "业务部门审核");
                    }
                    if (detachmentCheck.contains(objectMap.get("lczt"))) {
                        objectMap.put("dqlcjd", "支队审核");
                    }
                }
            }
        }
        map.put("mapList", mapList);
        map.put("pages", page.getPages());
        map.put("total", page.getTotal());
        map.put("pageNum", page.getPageNum());
        map.put("pageSize", page.getPageSize());
        return map;
    }

    @Override
    public Map<String, Object> queryRoadSafePoint(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new RuntimeException("id不能为空");
        }
        Map<String, Object> map = processChargeMapper.queryRoadSafePointById(id);
        if (!StringUtils.isEmpty(map.get("lczt").toString())) {
            if (map.get("lczt").toString().equals("1")) {
                map.put("dqlcjd", "民警录入");
            }
            if (zdCheck.contains(map.get("lczt"))) {
                map.put("dqlcjd", "中队审核");
            }
            if (ddCheck.contains(map.get("lczt"))) {
                map.put("dqlcjd", "大队审核");
            }
            if (ywCheck.contains(map.get("lczt"))) {
                map.put("dqlcjd", "业务部门审核");
            }
            if (detachmentCheck.contains(map.get("lczt"))) {
                map.put("dqlcjd", "支队审核");
            }
        }
        getPointName(map);
        return map;
    }

    /**
     * 获取节点名称
     * 1-中队录入 2-中队查否 3-中队自行处理 4-中队提交大队 5-中队提交职能部门 6-大队查否 7-大队自行处理 8-大队提交业务部门 9-大队提交职能部门 10-业务部门查否 11-业务部门自行处理
     * 12-业务部门提交支队 13-提交安委会 14-验收通过  15-验收不通过  16-审核通过  17-审核不通过 27-风险-大队录入量
     * @param map
     * @return
     */
    private Map<String, Object> getPointName(Map<String, Object> map) {
        if (!StringUtils.isEmpty(map.get("lczt").toString())) {
            switch (map.get("lczt").toString()) {
                case "1":
                    map.put("state", "中队录入");
                    break;
                case "2":
                    map.put("state", "中队查否");
                    break;
                case "3":
                    map.put("state", "中队自行处理");
                    break;
                case "4":
                    map.put("state", "中队提交大队");
                    break;
                case "5":
                    map.put("state", "中队提交职能部门");
                    break;
                case "6":
                    map.put("state", "大队查否");
                    break;
                case "7":
                    map.put("state", "大队自行处理");
                    break;
                case "8":
                    map.put("state", "大队提交业务部门");
                    break;
                case "9":
                    map.put("state", "大队提交职能部门");
                    break;
                case "10":
                    map.put("state", "业务部门查否");
                    break;
                case "11":
                    map.put("state", "业务部门自行处理");
                    break;
                case "12":
                    map.put("state", "业务部门提交支队");
                    break;
                case "13":
                    map.put("state", "提交安委会");
                    break;
                case "14":
                    map.put("state", "验收通过");
                    break;
                case "15":
                    map.put("state", "验收不通过");
                    break;
                case "16":
                    map.put("state", "审核通过");
                    break;
                case "17":
                    map.put("state", "审核不通过");
                    break;
                case "27":
                    map.put("state", "风险");
                    break;
                default:
                    break;
            }
        }
        return map;
    }
}
