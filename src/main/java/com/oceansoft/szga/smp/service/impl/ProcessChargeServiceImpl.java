package com.oceansoft.szga.smp.service.impl;

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
//        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        com.baomidou.mybatisplus.plugins.Page<Map<String, Object>> page = new com.baomidou.mybatisplus.plugins.Page<>(pageNum, pageSize);
        List<Map<String, Object>> mapList = processChargeMapper.queryRoadSafeTable(page, questionQueryBean);
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
                    if (zdCheck.contains(Integer.valueOf(objectMap.get("lczt").toString()))) {
                        objectMap.put("dqlcjd", "中队审核");
                    }
                    if (ddCheck.contains(Integer.valueOf(objectMap.get("lczt").toString()))) {
                        objectMap.put("dqlcjd", "大队审核");
                    }
                    if (ywCheck.contains(Integer.valueOf(objectMap.get("lczt").toString()))) {
                        objectMap.put("dqlcjd", "业务部门审核");
                    }
                    if (detachmentCheck.contains(Integer.valueOf(objectMap.get("lczt").toString()))) {
                        objectMap.put("dqlcjd", "支队审核");
                    }
                }
            }
        }
        map.put("mapList", mapList);
        map.put("pages", page.getPages());
        map.put("total", page.getTotal());
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
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
            if (zdCheck.contains(Integer.valueOf(map.get("lczt").toString()))) {
                map.put("dqlcjd", "中队审核");
            }
            if (ddCheck.contains(Integer.valueOf(map.get("lczt").toString()))) {
                map.put("dqlcjd", "大队审核");
            }
            if (ywCheck.contains(Integer.valueOf(map.get("lczt").toString()))) {
                map.put("dqlcjd", "业务部门审核");
            }
            if (detachmentCheck.contains(Integer.valueOf(map.get("lczt").toString()))) {
                map.put("dqlcjd", "支队审核");
            }
        }
        getPointName(map);
        return map;
    }

    @Override
    public Map<String, Object> queryQzfTable(QuestionQueryBean questionQueryBean, Integer type) {
        Map<String, Object> map = new HashMap<>();
        int pageNum = questionQueryBean.getPageNum() == null ? 1 : questionQueryBean.getPageNum();
        int pageSize = questionQueryBean.getPageSize() == null ? 10 : questionQueryBean.getPageSize();
//        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        com.baomidou.mybatisplus.plugins.Page<Map<String, Object>> page = new com.baomidou.mybatisplus.plugins.Page<>(pageNum, pageSize);
        List<Map<String, Object>> mapList = processChargeMapper.queryQzfTable(page, questionQueryBean, type);
        String dqlcjd = "";
        if (!CollectionUtils.isEmpty(mapList) && type != 1) {
            for (Map<String, Object> stringObjectMap : mapList) {
                if (stringObjectMap.get("lzzt") != null) {
                    if (stringObjectMap.get("lzzt").toString().equals("0") || stringObjectMap.get("lzzt").toString().equals("1")) {
                        dqlcjd = "上报";
                    }
                }
                if (stringObjectMap.get("shzt") != null) {
                    if (stringObjectMap.get("shzt").toString().equals("2") || stringObjectMap.get("shzt").toString().equals("3")) {
                        dqlcjd = "审核";
                    }
                }
                if (stringObjectMap.get("ffzt") != null) {
                    if (stringObjectMap.get("ffzt").toString().equals("5")) {
                        dqlcjd = "分发";
                    }
                }
                if (stringObjectMap.get("rlzt") != null) {
                    if (stringObjectMap.get("rlzt").toString().equals("1005")) {
                        dqlcjd = "认领";
                    }
                }
                if (stringObjectMap.get("zgzt") != null) {
                    if (stringObjectMap.get("zgzt").toString().equals("1006")) {
                        dqlcjd = "整改";
                    }
                }
                stringObjectMap.put("dqlcjd", dqlcjd);
                stringObjectMap.put("lcmc", "非治安隐患处置流程");
                // 状态
                if (stringObjectMap.get("dqlcjd") != null) {
                    // 上报
                    if (stringObjectMap.get("dqlcjd").toString().equals("上报")) {
                        if (stringObjectMap.get("lzzt").toString().equals("0")) {
                            stringObjectMap.put("state", "未流转");
                        }
                        if (stringObjectMap.get("lzzt").toString().equals("1")) {
                            stringObjectMap.put("state", "已流转");
                        }
                    }
                    // 审核
                    if (stringObjectMap.get("dqlcjd").toString().equals("审核")) {
                        if (stringObjectMap.get("shzt").toString().equals("2")) {
                            stringObjectMap.put("state", "信息审核通过");
                        }
                        if (stringObjectMap.get("shzt").toString().equals("3")) {
                            stringObjectMap.put("state", "信息审核不通过");
                        }
                    }
                    // 分发
                    if (stringObjectMap.get("dqlcjd").toString().equals("分发")) {
                        if (stringObjectMap.get("ffzt").toString().equals("5")) {
                            stringObjectMap.put("state", "已分发");
                        }
                    }
                    // 认领
                    if (stringObjectMap.get("dqlcjd").toString().equals("认领")) {
                        if (stringObjectMap.get("rlzt").toString().equals("1005")) {
                            stringObjectMap.put("state", "已认领");
                        }
                    }
                    // 整改
                    if (stringObjectMap.get("dqlcjd").toString().equals("整改")) {
                        if (stringObjectMap.get("rlzt").toString().equals("1006")) {
                            stringObjectMap.put("state", "已处理");
                        }
                    }
                }
            }
        }
        if (!CollectionUtils.isEmpty(mapList) && type == 1) {
            for (Map<String, Object> stringObjectMap : mapList) {
                stringObjectMap.put("lcmc", "治安隐患处置流程");
                if (stringObjectMap.get("lzzt") != null) {
                    if (stringObjectMap.get("lzzt").toString().equals("0") || stringObjectMap.get("lzzt").toString().equals("1")) {
                        dqlcjd = "发现";
                    }
                }
                if (stringObjectMap.get("zgzt") != null) {
                    if (stringObjectMap.get("zgzt").toString().equals("1006")) {
                        dqlcjd = "整改";
                    }
                }
                stringObjectMap.put("dqlcjd", dqlcjd);
                // 状态
                if (stringObjectMap.get("dqlcjd") != null) {
                    // 发现
                    if (stringObjectMap.get("dqlcjd").toString().equals("发现")) {
                        if (stringObjectMap.get("lzzt").toString().equals("0") || stringObjectMap.get("lzzt").toString().equals("1")) {
                            stringObjectMap.put("state", "已发现");
                        }
                    }
                    // 整改
                    if (stringObjectMap.get("dqlcjd").toString().equals("整改")) {
                        if (stringObjectMap.get("rlzt").toString().equals("1006")) {
                            stringObjectMap.put("state", "已处理");
                        }
                    }
                }
            }
        }
        map.put("mapList", mapList);
        map.put("pages", page.getPages());
        map.put("total", page.getTotal());
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        return map;
    }

    @Override
    public Map<String, Object> queryQzfPoint(Integer id) {
        if (StringUtils.isEmpty(id)) {
            throw new RuntimeException("id不能为空");
        }
        Map<String, Object> map = processChargeMapper.queryQzfPoint(id);
        String dqlcjd = "";
        if (!CollectionUtils.isEmpty(map) && !map.get("yhdl").toString().equals("1")) {
            if (map.get("lzzt") != null) {
                if (map.get("lzzt").toString().equals("0") || map.get("lzzt").toString().equals("1")) {
                    dqlcjd = "上报";
                }
            }
            if (map.get("shzt") != null) {
                if (map.get("lzzt").toString().equals("2") || map.get("shzt").toString().equals("3")) {
                    dqlcjd = "审核";
                }
            }
            if (map.get("ffzt") != null) {
                if (map.get("ffzt").toString().equals("5")) {
                    dqlcjd = "分发";
                }
            }
            if (map.get("rlzt") != null) {
                if (map.get("rlzt").toString().equals("1005")) {
                    dqlcjd = "认领";
                }
            }
            if (map.get("zgzt") != null) {
                if (map.get("zgzt").toString().equals("1006")) {
                    dqlcjd = "整改";
                }
            }
            map.put("dqlcjd", dqlcjd);
            // 状态
            if (map.get("dqlcjd") != null) {
                // 上报
                if (map.get("dqlcjd").toString().equals("上报")) {
                    if (map.get("lzzt").toString().equals("0")) {
                        map.put("state", "未流转");
                    }
                    if (map.get("lzzt").toString().equals("1")) {
                        map.put("state", "已流转");
                    }
                }
                // 审核
                if (map.get("dqlcjd").toString().equals("审核")) {
                    if (map.get("shzt").toString().equals("2")) {
                        map.put("state", "信息审核通过");
                    }
                    if (map.get("shzt").toString().equals("3")) {
                        map.put("state", "信息审核不通过");
                    }
                }
                // 分发
                if (map.get("dqlcjd").toString().equals("分发")) {
                    if (map.get("ffzt").toString().equals("5")) {
                        map.put("state", "已分发");
                    }
                }
                // 认领
                if (map.get("dqlcjd").toString().equals("认领")) {
                    if (map.get("rlzt").toString().equals("1005")) {
                        map.put("state", "已认领");
                    }
                }
                // 整改
                if (map.get("dqlcjd").toString().equals("整改")) {
                    if (map.get("rlzt").toString().equals("1006")) {
                        map.put("state", "已处理");
                    }
                }
            }
        }
        if (!CollectionUtils.isEmpty(map) && map.get("yhdl").toString().equals("1")) {
            if (map.get("lzzt") != null) {
                if (map.get("lzzt").toString().equals("0") || map.get("lzzt").toString().equals("1")) {
                    dqlcjd = "发现";
                }
            }
            if (map.get("zgzt") != null) {
                if (map.get("zgzt").toString().equals("1006")) {
                    dqlcjd = "整改";
                }
            }
            map.put("dqlcjd", dqlcjd);
            // 状态
            if (map.get("dqlcjd") != null) {
                // 分发
                if (map.get("dqlcjd").toString().equals("发现")) {
                    if (map.get("lzzt").toString().equals("0") || map.get("lzzt").toString().equals("1")) {
                        map.put("state", "已发现");
                    }
                }
                // 整改
                if (map.get("dqlcjd").toString().equals("整改")) {
                    if (map.get("rlzt").toString().equals("1006")) {
                        map.put("state", "已处理");
                    }
                }
            }
        }
        return map;
    }

    @Override
    public Map<String, Object> queryImpTable(QuestionQueryBean questionQueryBean, Integer type) {
        Map<String, Object> map = new HashMap<>();
        int pageNum = questionQueryBean.getPageNum() == null ? 1 : questionQueryBean.getPageNum();
        int pageSize = questionQueryBean.getPageSize() == null ? 10 : questionQueryBean.getPageSize();
//        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        com.baomidou.mybatisplus.plugins.Page<Map<String, Object>> page = new com.baomidou.mybatisplus.plugins.Page<>(pageNum, pageSize);
        List<Map<String, Object>> mapList = processChargeMapper.queryImpTable(page, questionQueryBean, type);
        List<String> jclxList = Arrays.asList("01","1","2","3");
        List<String> clztList1 = Arrays.asList("01","1","2","4");
        List<String> clztList2 = Arrays.asList("5","6");
        if (!CollectionUtils.isEmpty(mapList)) {
            for (Map<String, Object> stringObjectMap : mapList) {
                // 当前流程节点
                if (stringObjectMap.get("jclx") != null && stringObjectMap.get("clzt") != null) {
                    if (jclxList.contains(stringObjectMap.get("jclx"))) {
                        stringObjectMap.put("dqlcjd", "隐患上报");
                    }
                    if (stringObjectMap.get("jclx").toString().equals("4") && clztList1.contains(stringObjectMap.get("clzt"))) {
                        stringObjectMap.put("dqlcjd", "复查");
                    }
                    if (stringObjectMap.get("jclx").toString().equals("4") && clztList2.contains(stringObjectMap.get("clzt"))) {
                        stringObjectMap.put("dqlcjd", "复查审批");
                    }
                    if (stringObjectMap.get("jclx").toString().equals("4") && stringObjectMap.get("clzt").equals("3")) {
                        stringObjectMap.put("dqlcjd", "隐患处置完成");
                    }
                    // 检查结果
                    // 初查
                    if (jclxList.contains(stringObjectMap.get("jclx")) && (stringObjectMap.get("clzt").toString().equals("1") || stringObjectMap.get("clzt").toString().equals("01"))) {
                        stringObjectMap.put("jcjg", "当场改正");
                        stringObjectMap.put("cljg", "当场改正");
                    }
                    if (jclxList.contains(stringObjectMap.get("jclx")) && stringObjectMap.get("clzt").toString().equals("2")) {
                        stringObjectMap.put("jcjg", "责令限期整改");
                        stringObjectMap.put("cljg", "责令限期整改");
                    }
                    if (jclxList.contains(stringObjectMap.get("jclx")) && stringObjectMap.get("clzt").toString().equals("3")) {
                        stringObjectMap.put("jcjg", "责令限期整改并处警告");
                        stringObjectMap.put("cljg", "责令限期整改并处警告");
                    }
                    // 复查
                    if (stringObjectMap.get("jclx").toString().equals("4") && (stringObjectMap.get("clzt").toString().equals("1") || stringObjectMap.get("clzt").toString().equals("01"))) {
                        stringObjectMap.put("jcjg", "因客观原因整改未达到规定要求");
                        stringObjectMap.put("cljg", "因客观原因整改未达到规定要求");
                    }
                    if (stringObjectMap.get("jclx").toString().equals("4") && stringObjectMap.get("clzt").toString().equals("2")) {
                        stringObjectMap.put("jcjg", "无正当理由整改未达到规定要求");
                        stringObjectMap.put("cljg", "无正当理由整改未达到规定要求");
                    }
                    if (stringObjectMap.get("jclx").toString().equals("4") && stringObjectMap.get("clzt").toString().equals("4")) {
                        stringObjectMap.put("jcjg", "逾期不整改");
                        stringObjectMap.put("cljg", "逾期不整改");
                    }
                    // 复查审批
                    if (stringObjectMap.get("jclx").toString().equals("4") && stringObjectMap.get("clzt").toString().equals("5")) {
                        stringObjectMap.put("jcjg", "协调解决");
                        stringObjectMap.put("cljg", "协调解决");
                    }
                    if (stringObjectMap.get("jclx").toString().equals("4") && stringObjectMap.get("clzt").toString().equals("6")) {
                        stringObjectMap.put("jcjg", "罚款");
                        stringObjectMap.put("cljg", "罚款");
                    }
                }
            }
        }
        map.put("mapList", mapList);
        map.put("pages", page.getPages());
        map.put("total", page.getTotal());
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        return map;
    }

    @Override
    public Map<String, Object> queryImpPoint(String id) {
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isEmpty(id)) {
            throw new RuntimeException("id不能为空");
        }
        Map<String, Object> stringObjectMap = processChargeMapper.queryImpPoint(id);
        List<String> jclxList = Arrays.asList("01","1","2","3");
        List<String> clztList1 = Arrays.asList("01","1","2","4");
        List<String> clztList2 = Arrays.asList("5","6");
        if (!CollectionUtils.isEmpty(stringObjectMap)) {
            map.put("czsj", stringObjectMap.get("jcsj"));
            // 当前流程节点
            if (jclxList.contains(stringObjectMap.get("jclx"))) {
                map.put("dqlcjd", "隐患上报");
            }
            if (stringObjectMap.get("jclx").toString().equals("4") && clztList1.contains(stringObjectMap.get("clzt"))) {
                map.put("dqlcjd", "复查");
            }
            if (stringObjectMap.get("jclx").toString().equals("4") && clztList2.contains(stringObjectMap.get("clzt"))) {
                map.put("dqlcjd", "复查审批");
            }
            if (stringObjectMap.get("jclx").toString().equals("4") && stringObjectMap.get("clzt").toString().equals("3")) {
                map.put("dqlcjd", "隐患处置完成");
            }
            // 当前状态
            if (jclxList.contains(stringObjectMap.get("jclx")) && (stringObjectMap.get("clzt").toString().equals("1") || stringObjectMap.get("clzt").toString().equals("01"))) {
                map.put("state", "当场改正");
            }
            if (jclxList.contains(stringObjectMap.get("jclx")) && stringObjectMap.get("clzt").toString().equals("2")) {
                map.put("state", "责令限期整改");
            }
            if (jclxList.contains(stringObjectMap.get("jclx")) && stringObjectMap.get("clzt").toString().equals("3")) {
                map.put("state", "责令限期整改并处警告");
            }
            // 复查
            if (stringObjectMap.get("jclx").toString().equals("4") && (stringObjectMap.get("clzt").toString().equals("1") || stringObjectMap.get("clzt").toString().equals("01"))) {
                map.put("state", "因客观原因整改未达到规定要求");
            }
            if (stringObjectMap.get("jclx").toString().equals("4") && stringObjectMap.get("clzt").toString().equals("2")) {
                map.put("state", "无正当理由整改未达到规定要求");
            }
            if (stringObjectMap.get("jclx").toString().equals("4") && stringObjectMap.get("clzt").toString().equals("4")) {
                map.put("state", "逾期不整改");
            }
            // 复查审批
            if (stringObjectMap.get("jclx").toString().equals("4") && stringObjectMap.get("clzt").toString().equals("5")) {
                map.put("state", "协调解决");
            }
            if (stringObjectMap.get("jclx").toString().equals("4") && stringObjectMap.get("clzt").toString().equals("6")) {
                map.put("state", "罚款");
            }
        }


//        map.put("dqlcjd", "上报");
//        map.put("czsj", "2020-06-18 09:52:38");
//        map.put("state", "已流转");
        return map;
    }

    @Override
    public Map<String, Object> queryImpProcessPic(Integer type) {
        Map<String, Object> map = processChargeMapper.queryImpProcessPic(type);
        return map;
    }

    @Override
    public Map<String, Object> queryDeliveryTable(QuestionQueryBean questionQueryBean) {
        Map<String, Object> map = new HashMap<>();
        int pageNum = questionQueryBean.getPageNum() == null ? 1 : questionQueryBean.getPageNum();
        int pageSize = questionQueryBean.getPageSize() == null ? 10 : questionQueryBean.getPageSize();
        com.baomidou.mybatisplus.plugins.Page<Map<String, Object>> page = new com.baomidou.mybatisplus.plugins.Page<>(pageNum, pageSize);
        List<Map<String, Object>> mapList = processChargeMapper.queryDeliveryTable(page, questionQueryBean);
        List<String> jclxList = Arrays.asList("1","2","3");
        if (!CollectionUtils.isEmpty(mapList)) {
            for (Map<String, Object> stringObjectMap : mapList) {
                if (stringObjectMap.get("jclx") != null && stringObjectMap.get("clzt") != null) {
                    if (jclxList.contains(stringObjectMap.get("jclx"))) {
                        stringObjectMap.put("dqlcjd", "隐患上报");
                    }
                    if (stringObjectMap.get("jclx").equals("4") && !stringObjectMap.get("clzt").equals("3")) {
                        stringObjectMap.put("dqlcjd", "复查");
                    }
                    if (stringObjectMap.get("jclx").equals("4") && stringObjectMap.get("clzt").equals("3")) {
                        stringObjectMap.put("dqlcjd", "隐患处置完成");
                    }
                    if (jclxList.contains(stringObjectMap.get("jclx")) && stringObjectMap.get("clzt").equals("1")) {
                        stringObjectMap.put("jcjg", "当场改正");
                    }
                    if (jclxList.contains(stringObjectMap.get("jclx")) && stringObjectMap.get("clzt").equals("3")) {
                        stringObjectMap.put("jcjg", "责令15天内限期整改并处警告");
                    }
                    if (stringObjectMap.get("jclx").equals("4") && !stringObjectMap.get("clzt").equals("3")) {
                        stringObjectMap.put("jcjg", "行政处罚");
                    }
                    if (stringObjectMap.get("jclx").equals("4") && stringObjectMap.get("clzt").equals("3")) {
                        stringObjectMap.put("dqlcjd", "已整改");
                    }
                }
                if (stringObjectMap.get("jczt") != null) {
                    if (stringObjectMap.get("jczt").equals("0")) {
                        stringObjectMap.put("jcztname", "待检查");
                    }
                    if (stringObjectMap.get("jczt").equals("1")) {
                        stringObjectMap.put("jcztname", "已检查");
                    }
                    if (stringObjectMap.get("jczt").equals("2")) {
                        stringObjectMap.put("jcztname", "缺检查");
                    }
                }
            }
        }
        map.put("mapList", mapList);
        map.put("pages", page.getPages());
        map.put("total", page.getTotal());
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
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
        if (map.get("lczt") != null) {
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
