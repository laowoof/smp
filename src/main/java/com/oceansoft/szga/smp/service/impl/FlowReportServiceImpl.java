package com.oceansoft.szga.smp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.oceansoft.szga.smp.config.domain.ApiPager;
import com.oceansoft.szga.smp.config.domain.ApiQueryBase;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.constant.Constant;
import com.oceansoft.szga.smp.entity.FlowExecute;
import com.oceansoft.szga.smp.entity.FlowReport;
import com.oceansoft.szga.smp.mapper.FlowReportMapper;
import com.oceansoft.szga.smp.service.FlowReportService;
import com.oceansoft.szga.smp.util.GuidUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Arrays;
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
    public ApiResult add(FlowReport report) {
        //1添加一条流转
        report.setGuid(GuidUtils.newUUID());
        int count = mapper.add(report);
        if(count==0){
            return new ApiResult().failure("保存失败");
        }
        //2添加代办任务
        List<Map<String, Object>> nodes = mapper.findNodes(report.getFlowType(), Constant.BEGIN_NODE_ID);
        nodes.stream().forEach(map->{
            map.put("guid", GuidUtils.newUUID());
            map.put("flow_id",report.getGuid());
            map.put("create_user",report.getCreateUser());
            mapper.addTask(map);
        });
        return new ApiResult();
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

}
