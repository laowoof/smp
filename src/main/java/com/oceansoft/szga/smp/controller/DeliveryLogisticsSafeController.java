package com.oceansoft.szga.smp.controller;

import com.alibaba.fastjson.JSONObject;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.service.DeliveryLogisticsSafeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 寄递物流全态研析
 *
 * @author JackChan
 * @Date 2020/7/10 0010 上午 11:12
 */
@RestController
@RequestMapping("delivery/logistics")
public class DeliveryLogisticsSafeController {

    @Autowired
    private DeliveryLogisticsSafeService deliveryLogisticsSafeService;

    @ApiOperation(value = "寄递物流/履职分析排行", notes = "", httpMethod = "POST")
    @PostMapping("duty/analysis-rank")
    public ApiResult queryDeliveryRank() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            Map<String, Object> mapList = deliveryLogisticsSafeService.queryDeliveryRank();
            apiResult.setData(mapList);
            isSuccess = true;
            message = "查询成功";
        } catch (Exception e) {
            message = e.getMessage();
            e.printStackTrace();
        }
        apiResult.setCode(200);
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    @ApiOperation(value = "寄递物流/履职分析钻取", notes = "", httpMethod = "POST")
    @PostMapping("duty/drill")
    public ApiResult queryDutyDrill(@RequestBody JSONObject jsonObject) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> mapList = deliveryLogisticsSafeService.queryDutyDrill(jsonObject);
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

    @ApiOperation(value = "隐患分析/隐患类型数量分析", notes = "", httpMethod = "POST")
    @PostMapping("hidden/num-analysis")
    public ApiResult queryHiddenNumAnalysis() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            Map<String, Object> map = deliveryLogisticsSafeService.queryHiddenNumAnalysis();
            apiResult.setData(map);
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


    @ApiOperation(value = "隐患分析/单位等级隐患数量分析", notes = "", httpMethod = "POST")
    @PostMapping("hidden/company-level")
    public ApiResult queryHiddenCompanyLevel() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            Map<String, Object> map = deliveryLogisticsSafeService.queryHiddenCompanyLevel();
            apiResult.setData(map);
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

    @ApiOperation(value = "隐患分析/治安保卫重点单位隐患TOP5", notes = "", httpMethod = "POST")
    @PostMapping("hidden/imp-top")
    public ApiResult queryImpTop() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            Map<String, Object> map = deliveryLogisticsSafeService.queryImpTop();
            apiResult.setData(map);
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

    @ApiOperation(value = "隐患分析/隐患数量分析", notes = "", httpMethod = "POST")
    @PostMapping("hidden/analysis-num")
    public ApiResult queryAnalysisNum(@RequestBody JSONObject jsonObject) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            Map<String, Object> map = deliveryLogisticsSafeService.queryAnalysisNum(jsonObject);
            apiResult.setData(map);
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

    @ApiOperation(value = "隐患分析/隐患数量态势-全市", notes = "", httpMethod = "POST")
    @PostMapping("hidden/num-trend")
    public ApiResult queryNumTrend(@RequestBody JSONObject jsonObject) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            Map<String, Object> map = deliveryLogisticsSafeService.queryNumTrend(jsonObject);
            apiResult.setData(map);
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
