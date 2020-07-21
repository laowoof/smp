package com.oceansoft.szga.smp.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.entity.bean.QuestionQueryBean;
import com.oceansoft.szga.smp.service.ProcessChargeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 流程监管控制层
 *
 * @author JackChan
 * @Date 2020/7/10 0010 上午 11:12
 */
@RestController
@RequestMapping("process/charge")
public class ProcessChargeController {

    @Autowired
    private ProcessChargeService processChargeService;

    @ApiOperation(value = "交通安全设施表格", notes = "", httpMethod = "POST")
    @PostMapping("road-safe-table")
    @DS("second")
    public ApiResult queryRoadSafeTable(@RequestBody QuestionQueryBean questionQueryBean) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            Map<String, Object> mapList = processChargeService.queryRoadSafeTable(questionQueryBean);
            apiResult.setData(mapList);
            isSuccess = true;
            message = "查询成功";
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setCode(200);
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    @ApiOperation(value = "交通安全设施流程节点", notes = "", httpMethod = "POST")
    @GetMapping("road-safe-point")
    @DS("second")
    public ApiResult queryRoadSafePoint(String id) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            Map<String, Object> mapList = processChargeService.queryRoadSafePoint(id);
            apiResult.setData(mapList);
            isSuccess = true;
            message = "查询成功";
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setCode(200);
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }




}