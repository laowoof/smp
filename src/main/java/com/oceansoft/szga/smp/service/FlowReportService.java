package com.oceansoft.szga.smp.service;

import com.oceansoft.szga.smp.config.domain.ApiPager;
import com.oceansoft.szga.smp.config.domain.ApiQueryBase;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.entity.FlowExecute;
import com.oceansoft.szga.smp.entity.FlowReport;

import java.util.List;
import java.util.Map;

/**
 * @author zhangxh
 * @create 2020/4/21
 * @email zhangxh@oceansoft.com.cn
 * 协同流转处理
 */
public interface FlowReportService {
    /**
     * 新增一个流转信息
     * @param report
     * @return
     */
    ApiResult add(FlowReport report);

    ApiPager<Map<String,Object>> page(ApiQueryBase query);

    ApiResult execute(FlowExecute execute);

    Map<String,Object> get(String guid);

    List<Map<String,Object>> getTasks(String guid);

    Map<String,Object> getTask(String guid);
}
