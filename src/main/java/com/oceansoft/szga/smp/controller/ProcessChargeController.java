package com.oceansoft.szga.smp.controller;

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

    @ApiOperation(value = "交通安全设施流程节点", notes = "", httpMethod = "GET")
    @GetMapping("road-safe-point")
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

    @ApiOperation(value = "群租房表格", notes = "", httpMethod = "POST")
    @PostMapping("qzf-table")
    public ApiResult queryQzfTable(@RequestBody QuestionQueryBean questionQueryBean, Integer type) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            Map<String, Object> mapList = processChargeService.queryQzfTable(questionQueryBean, type);
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

    @ApiOperation(value = "群租房流程节点", notes = "", httpMethod = "GET")
    @GetMapping("qzf-point")
    public ApiResult queryQzfPoint(Integer id) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            Map<String, Object> mapList = processChargeService.queryQzfPoint(id);
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

    @ApiOperation(value = "重点目标表格", notes = "", httpMethod = "POST")
    @PostMapping("imp-table")
    public ApiResult queryImpTable(@RequestBody QuestionQueryBean questionQueryBean, Integer type) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            Map<String, Object> mapList = processChargeService.queryImpTable(questionQueryBean, type);
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

    @ApiOperation(value = "重点目标节点", notes = "", httpMethod = "GET")
    @GetMapping("imp-point")
    public ApiResult queryImpPoint(String id) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            Map<String, Object> mapList = processChargeService.queryImpPoint(id);
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

    @ApiOperation(value = "重点目标流程图数据", notes = "", httpMethod = "GET")
    @GetMapping("imp-process-pic")
    public ApiResult queryImpProcessPic(Integer type) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            Map<String, Object> mapList = processChargeService.queryImpProcessPic(type);
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

    @ApiOperation(value = "寄递物流表格", notes = "", httpMethod = "POST")
    @PostMapping("delivery-table")
    public ApiResult queryDeliveryTable(@RequestBody QuestionQueryBean questionQueryBean) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            Map<String, Object> mapList = processChargeService.queryDeliveryTable(questionQueryBean);
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

    @ApiOperation(value = "交警流程数据", notes = "", httpMethod = "POST")
    @PostMapping("traffic-data")
    public ApiResult queryTrafficData() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            Map<String, Object> mapList = processChargeService.queryTrafficData();
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
