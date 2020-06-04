package com.oceansoft.szga.smp.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.oceansoft.szga.smp.config.domain.ApiPager;
import com.oceansoft.szga.smp.config.domain.ApiQueryBase;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.constant.Constant;
import com.oceansoft.szga.smp.entity.FlowExecute;
import com.oceansoft.szga.smp.entity.FlowReport;
import com.oceansoft.szga.smp.entity.FlowTask;
import com.oceansoft.szga.smp.mapper.FlowReportMapper;
import com.oceansoft.szga.smp.service.FlowReportService;
import com.oceansoft.szga.smp.util.GuidUtils;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangxh
 * @create 2020/4/21
 * @email zhangxh@oceansoft.com.cn
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class FlowReportServiceImpl implements FlowReportService {
    @Resource
    private FlowReportMapper mapper;

    @Override
    public ApiResult add(JSONObject json) {
        //1添加一条流转
//        report.setGuid(GuidUtils.newUUID());
        int num  =  mapper.getNum(report(json).getGuid());
        if(num>0){
            return new ApiResult().failure("单据编号已存在！");
        }else{
            int count = mapper.add(report(json));
            if(count==0){
                return new ApiResult().failure("保存失败");
            }
            //2添加代办任务
            List<Map<String, Object>> nodes = mapper.findNodes(report(json).getFlowType(), Constant.BEGIN_NODE_ID);
            nodes.stream().forEach(map->{
                map.put("guid", GuidUtils.newUUID());
                map.put("flow_id",report(json).getGuid());
                map.put("create_user",report(json).getCreateUser());
                map.put("des",report(json).getDes());
                map.put("flow_node_id",report(json).getReportDept());
                map.put("update_user",report(json).getCreateUser());
                System.err.println(map);
                mapper.addTask(map);
            });
            return new ApiResult("保存并分发成功！");
        }
    }

    @Override
    public ApiResult findAll() {
        List data =  mapper.findAll();
        return new ApiResult<>().success(data);
    }

    @Override
    public ApiResult save(JSONObject json) {
        //保存
        int num  =  mapper.getNum(report(json).getGuid());
        if(num>0){
            return new ApiResult().failure("单据编号已存在！");
        }else{
            int count = mapper.add(report(json));
            if(count==0){
                return new ApiResult().failure("保存失败");
            }
            return new ApiResult(200,true,"保存成功");
        }
    }

    @Override
    public ApiPager<Map<String, Object>> page(ApiQueryBase query) {
        PageHelper.startPage(query.getPi(), query.getPs(), true);
        Page<Map<String,Object>> page = (Page)mapper.page(query);
        ApiPager<Map<String,Object>> pager = new ApiPager(query.getPs(), query.getPi(), page.getTotal(), page.getResult());
        return pager;
    }

    @Override
    public ApiResult execute(FlowExecute execute) {
        //1完成当前任务
        int count = mapper.completeTask(execute);
        if(count==0){
            return new ApiResult().failure("操作失败");
        }
        //2添加下个节点任务
        List<Map<String, Object>> nodes = mapper.findNextNodes(execute.getGuid());
        nodes.stream().forEach(map->{
            map.put("guid", GuidUtils.newUUID());
            map.put("create_user",execute.getUpdateUser());
            if(StringUtils.isEmpty(execute.getReceiveDepts())){
                mapper.addTask(map);
            }else{
                String[] depts = execute.getReceiveDepts().split(",");
                Arrays.stream(depts).forEach(dept->{
                    map.put("dept",dept);
                    mapper.addTask(map);
                });
            }
        });
        return new ApiResult();
    }

    @Override
    public ApiResult updateInfo(JSONObject json) {
        int num = mapper.updateInfo(report(json));
        if(num ==0){
            return new ApiResult().failure("修改失败!");
        }else{
            return new ApiResult(200,true,"修改成功!");
        }
    }

    @Override
    public ApiResult updateIsDelete(String guid) {
         int num = mapper.updateIsDelete(guid);
         if(num == 0){
             return new ApiResult().failure("删除失败!");
         }else{
             return new ApiResult(200,true,"删除成功!");
         }
    }

    @Override
    public Map<String, Object> get(String guid) {
        return mapper.get(guid);
    }

    @Override
    public List<Map<String, Object>> getTasks(String guid) {
        return mapper.getTasks(guid);
    }

    @Override
    public Map<String, Object> getTask(String guid) {
        return mapper.getTask(guid);
    }

    @Override
    public ApiResult userAll(String id) {
        return new ApiResult().success(200,"成功",mapper.userAll(id));
    }

    @Override
    public ApiResult addTask(JSONObject json) {
        Map map = new HashMap();
        map.put("guid",GuidUtils.newUUID());
        map.put("flow_id",json.getString("guid"));
        map.put("create_date",json.getString("createdate"));
        map.put("create_user",json.getString("createUser"));
        map.put("node_name",json.getString("dept"));
        map.put("state","0");
        map.put("update_date",json.getString("operationTime"));
        map.put("update_user",json.getString("operator"));
        map.put("dept",json.getString("czDept"));
        map.put("flow_node_id",json.getString("reportDept"));
        map.put("des",json.getString("instructions"));
        map.put("action_name","分发");
        int num = mapper.addTask(map);
        if(num !=1){
            return new ApiResult().failure("分发失败!");
        }else{
            return new ApiResult(200,true,"分发成功!");
        }
    }

    @Override
    public ApiResult plFfInfo(JSONObject json) {
        Map mp  =  mapper.findSpecal(json.getString("deptName"),json.getString("actionName"));
        if("治安支队".equals(json.getString("deptName"))){
            List<Map<String,String>> list =  mapper.plFfInfo();
            if(list.size()>0){
                Map map2 = new HashMap();
                list.forEach(map->{
                    map2.put("guid",GuidUtils.newUUID());
                    map2.put("flow_id",map.get("guid"));
                    map2.put("create_date",map.get("create_date"));
                    map2.put("create_user",map.get("create_user"));
                    map2.put("node_name",mp.get("node_name"));
                    map2.put("state","0");
                    map2.put("update_date",json.getString("operationTime"));
                    map2.put("update_user",json.getString("operator"));
                    map2.put("dept",mp.get("dept"));
                    map2.put("flow_node_id",mp.get("id"));
                    map2.put("des",json.getString("instructions"));
                    map2.put("action_name",mp.get("action_name"));
                    mapper.addTask(map2);
                    map2.clear();
                });
                return new ApiResult(200,true,"分发成功!");
            }else{
                return new ApiResult().failure("暂无未分发数据,不可分发！");
            }
        }else{
            // 未分发总数
           int count = mapper.ffCount((String)mp.get("parent_id"));
            List<Map<String,String>> list = mapper.findTaskByParentId((String)mp.get("parent_id"));
           if(count >0){
               Map map2 = new HashMap();
               list.forEach(map->{
                   map2.put("guid",GuidUtils.newUUID());
                   map2.put("flow_id",map.get("flow_id"));
                   map2.put("create_date",map.get("create_date"));
                   map2.put("create_user",map.get("create_user"));
                   map2.put("node_name",mp.get("node_name"));
                   map2.put("state","0");
                   map2.put("update_date",json.getString("operationTime"));
                   map2.put("update_user",json.getString("operator"));
                   map2.put("dept",mp.get("dept"));
                   map2.put("flow_node_id",mp.get("id"));
                   map2.put("des",json.getString("instructions"));
                   map2.put("action_name",mp.get("action_name"));
                   mapper.addTask(map2);
                   mapper.updateId(map.get("guid"));
               });
               return new ApiResult(200,true,"分发成功!");
           }else{
               return new ApiResult().failure("暂无未分发数据,不可分发！");
           }
        }
    }

    @Override
    public ApiResult findAllTask() {
        return new ApiResult(200,true,"成功",mapper.findAllTask());
    }

    @Override
    public ApiResult plQsInfo(JSONObject json) {
        Map mm =  mapper.getNodeName(json.getString("deptName"));
        int num =0;
        if(mm.size()>0){
           for(int i=0;i<mm.size();i++){
               HashMap map = new HashMap();
               map.put("nodeName",mm.get("node_name"));
               map.put("updateUser",json.getString("operator"));
               map.put("dept",mm.get("dept"));
               map.put("flowNodeId",json.getString("deptName"));
               map.put("instructions",json.getString("instructions"));
               map.put("actionName",mm.get("action_name"));
               num = mapper.plQsInfo(map);
               map.clear();
           }
           if(num != 0){
               return new ApiResult(200,true,"签收成功!");
           }else{
               return new ApiResult().failure("签收失败！");
           }
        }else{
            return new ApiResult().failure("暂无可签收数据,不可签收！");
        }
    }

    @Override
    public ApiResult plQsInfo2(JSONObject json) {
        List<Map<String,String>> list =  mapper.qs(json.getString("deptName"));
        Map mm = mapper.getNodeName(json.getString("deptName"));
        int count = mapper.qsCount(json.getString("deptName"));
        if(count>0){
            if("分县局".equals(json.getString("userDeptName"))){
                list.forEach(map->{
                    Map mp = new HashMap();
                    mp.put("guid",GuidUtils.newUUID());
                    mp.put("flow_id",map.get("flow_id"));
                    mp.put("create_date",map.get("create_date"));
                    mp.put("create_user",map.get("create_user"));
                    mp.put("node_name",mm.get("node_name"));
                    mp.put("state","1");
                    mp.put("update_date",json.getString("operationTime"));
                    mp.put("update_user",json.getString("operator"));
                    mp.put("dept",mm.get("dept"));
                    mp.put("flow_node_id",json.getString("deptName"));
                    mp.put("des",json.getString("instructions"));
                    mp.put("action_name",mm.get("action_name"));
                    mapper.addTask(mp);
                    mapper.updateId(map.get("guid"));
                });
                return new ApiResult(200,true,"签收成功!");
            }else{
                list.forEach(map->{
                    Map mp = new HashMap();
                    mp.put("guid",GuidUtils.newUUID());
                    mp.put("flow_id",map.get("flow_id"));
                    mp.put("create_date",map.get("create_date"));
                    mp.put("create_user",map.get("create_user"));
                    mp.put("node_name",mm.get("node_name"));
                    mp.put("state","0");
                    mp.put("update_date",json.getString("operationTime"));
                    mp.put("update_user",json.getString("operator"));
                    mp.put("dept",mm.get("dept"));
                    mp.put("flow_node_id",json.getString("deptName"));
                    mp.put("des",json.getString("instructions"));
                    mp.put("action_name",mm.get("action_name"));
                    mapper.addTask(mp);
                    mapper.updateId(map.get("guid"));
                });
                return new ApiResult(200,true,"签收成功!");
            }
        }else{
            return new ApiResult().failure("咱无签收数据");
        }
    }

    @Override
    public ApiResult findNode(String deptName,String actionName) {
        return new ApiResult(200,true,"下层节点部门", mapper.findNode(deptName,actionName));
    }

    @Override
    public ApiResult findSpecal(String deptName,String actionName) {
        return new ApiResult(200,true,"下层节点部门", mapper.findSpecal(deptName,actionName));
    }

    private FlowReport report(JSONObject json){
        FlowReport report = new FlowReport();
        report.setGuid(json.getString("guid"));
        report.setSource(json.getString("source"));
        report.setFlowType(json.getString("flowType"));
        report.setTaskName(json.getString("taskName"));
        report.setReportDate(json.getString("reportDate"));
        report.setDes(json.getString("des"));
        report.setReportDept(json.getString("reportDept"));
        report.setFileIds(json.getString("fileIds"));
        report.setCreateUser(json.getString("createUser"));
        report.setCreateUserId(json.getString("createUserId"));
        report.setCreateDate(json.getString("createDate"));
        report.setIsDelete(json.getString("isDelete"));
        report.setReceiptsInfo(JSON.toJSONString(json.get("receiptsInfo")));
        return report;
    }
}
