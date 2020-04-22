package com.oceansoft.szga.smp.controller;

import com.oceansoft.szga.smp.config.domain.ApiQueryBase;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.entity.FlowExecute;
import com.oceansoft.szga.smp.entity.FlowReport;
import com.oceansoft.szga.smp.service.FlowReportService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * @author zhangxh
 * @create 2020/1/14
 * @email zhangxh@oceansoft.com.cn
 * 协同流转
 */
@RestController
@RequestMapping("flow/report")
@ApiOperation("协同流转")
public class FlowController {
    @Autowired
    private FlowReportService reportService;


    @ApiOperation("协同流转分页数据")
    @GetMapping("page")
    public ApiResult page(ApiQueryBase query){
        return new ApiResult(reportService.page(query));
    }

    @ApiOperation("新增")
    @PostMapping
    public ApiResult report(@Valid @RequestBody FlowReport report, BindingResult result){
        if(result.hasErrors()){
            ApiResult.error(result);
        }
        return reportService.add(report);
    }

    @ApiOperation("处理")
    @PostMapping("execute")
    public ApiResult execute(@RequestBody FlowExecute execute){
        return reportService.execute(execute);
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
