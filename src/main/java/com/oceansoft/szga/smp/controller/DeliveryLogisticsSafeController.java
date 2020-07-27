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





}
