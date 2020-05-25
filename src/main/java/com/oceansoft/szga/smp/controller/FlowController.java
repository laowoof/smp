package com.oceansoft.szga.smp.controller;

import com.alibaba.fastjson.JSONObject;
import com.oceansoft.szga.smp.config.domain.ApiQueryBase;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.entity.FlowExecute;
import com.oceansoft.szga.smp.entity.FlowReport;
import com.oceansoft.szga.smp.service.FlowReportService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


/**
 * @author zhangxh
 * @create 2020/1/14
 * @email zhangxh@oceansoft.com.cn
 * 协同流转
 */
@RestController
@RequestMapping("flow/report")
//@ApiOperation("协同流转")
public class FlowController {
    @Autowired
    private FlowReportService reportService;


    @ApiOperation("协同流转分页数据")
    @GetMapping("page")
    public ApiResult page(ApiQueryBase query, HttpServletRequest request){
        System.err.println(request);
        query.getConditions().put("reportDept", request.getParameter("reportDept"));
        query.getConditions().put("keyword", request.getParameter("keyword"));
        query.getConditions().put("flowType", request.getParameter("flowType"));
        query.getConditions().put("qsState", request.getParameter("qsState"));
        query.getConditions().put("ffState", request.getParameter("ffState"));
        return new ApiResult(reportService.page(query));
    }
    @ApiOperation("新增并分发")
    @PostMapping("addFx")
    public ApiResult report(@Valid @RequestBody JSONObject json, BindingResult result){
        if(result.hasErrors()){
            ApiResult.error(result);
        }
        return reportService.add(json);
    }

    @ApiOperation("新增保存")
    @PostMapping("save")
    @ResponseBody
    public ApiResult save(@RequestBody JSONObject json){
        return reportService.save(json);
    }

    @ApiOperation("修改")
    @PostMapping("updateInfo")
    @ResponseBody
    public ApiResult updateInfo(@RequestBody JSONObject json){
        return reportService.updateInfo(json);
    }

    @ApiOperation("根据guid删除数据")
    @GetMapping("delete")
    @ResponseBody
    public ApiResult updateIsDelete(String guid){
        return reportService.updateIsDelete(guid);
    }

    @ApiOperation("处理")
    @PostMapping("execute")
    public ApiResult execute(@RequestBody FlowExecute execute){
        return reportService.execute(execute);
    }

    @ApiOperation("所有数据")
    @GetMapping("findAll")
    public ApiResult findAll(){
        return reportService.findAll();
    }

    @ApiOperation("根据id获取")
    @GetMapping("{guid}")
    public ApiResult get(@PathVariable String guid){
        return new ApiResult(reportService.get(guid));
    }

    @ApiOperation("根据flow_id获取任务,点亮流程图")
    @GetMapping("{guid}/tasks")
    public ApiResult getTasks(@PathVariable String guid){
        return new ApiResult(reportService.getTasks(guid));
    }
    @ApiOperation("根据guid获取任务")
    @GetMapping("task/{guid}")
    public ApiResult getTask(@PathVariable String guid){
        return new ApiResult(reportService.getTask(guid));
    }
}
