package com.oceansoft.szga.smp.controller;

import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.entity.Queryparems;
import com.oceansoft.szga.smp.service.DeliverylogisticsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dlog")
public class DeliverylogisticsController {

    @Autowired
    private DeliverylogisticsService deliverylogisticsService;

    @ApiOperation(value = "头部总数", notes = "", httpMethod = "POST")
    @PostMapping("sum")
    public ApiResult queryRoadSafePoint() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            Map<String, Object> mapList = deliverylogisticsService.sumDeliverylogistics();
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

    @ApiOperation(value = "寄递物流单位分类分析", notes = "", httpMethod = "POST")
    @PostMapping("jdwl")
    public ApiResult czjdfl() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> dwfl = deliverylogisticsService.dwfl();
            apiResult.setData(dwfl);
            isSuccess = true;
            message = "查询成功";
            apiResult.setCode(200);
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    @ApiOperation(value = "隐患类型分析", notes = "", httpMethod = "POST")
    @PostMapping("yhlx")
    public ApiResult yhlx() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> yhlx = deliverylogisticsService.yhlx();
            apiResult.setData(yhlx);
            isSuccess = true;
            message = "查询成功";
            apiResult.setCode(200);
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    @ApiOperation(value = "从业人员类型分析", notes = "", httpMethod = "POST")
    @PostMapping("cyry")
    public ApiResult czcyry() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> cyry = deliverylogisticsService.cyry();
            apiResult.setData(cyry);
            isSuccess = true;
            message = "查询成功";
            apiResult.setCode(200);
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    @ApiOperation(value = "寄递物流以及从业人员单位人员分析", notes = "", httpMethod = "POST")
    @PostMapping("jdryfl")
    public ApiResult jdryfl(@RequestBody Queryparems queryparems) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> cyry = deliverylogisticsService.jdadnryfl(queryparems);
            apiResult.setData(cyry);
            isSuccess = true;
            message = "查询成功";
            apiResult.setCode(200);
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    @ApiOperation(value = "寄递物流以及从业人员单位人员分析", notes = "", httpMethod = "POST")
    @PostMapping("jcgfl")
    public ApiResult jcgfl(@RequestBody Queryparems queryparems) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> cyry = deliverylogisticsService.jcg(queryparems);
            apiResult.setData(cyry);
            isSuccess = true;
            message = "查询成功";
            apiResult.setCode(200);
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    @ApiOperation(value = "寄递物流以及从业人员单位人员分析", notes = "", httpMethod = "POST")
    @PostMapping("dwfx")
    public ApiResult dwfx(@RequestBody Queryparems queryparems) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> cyry = deliverylogisticsService.dwfx(queryparems);
            apiResult.setData(cyry);
            isSuccess = true;
            message = "查询成功";
            apiResult.setCode(200);
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    @ApiOperation(value = "寄递物流以及从业人员单位人员分析", notes = "", httpMethod = "POST")
    @PostMapping("dwflts")
    public ApiResult dwflts(@RequestBody Queryparems queryparems) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> cyry = deliverylogisticsService.dwflts(queryparems);
            apiResult.setData(cyry);
            isSuccess = true;
            message = "查询成功";
            apiResult.setCode(200);
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    @ApiOperation(value = "寄递物流以及从业人员单位人员分析", notes = "", httpMethod = "POST")
    @PostMapping("dwdj")
    public ApiResult dwdj(@RequestBody Queryparems queryparems) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> cyry = deliverylogisticsService.dwdj(queryparems);
            apiResult.setData(cyry);
            isSuccess = true;
            message = "查询成功";
            apiResult.setCode(200);
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    @ApiOperation(value = "寄递物流以及从业人员单位人员分析", notes = "", httpMethod = "POST")
    @PostMapping("zabw")
    public ApiResult zabw() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> cyry = deliverylogisticsService.zabw();
            apiResult.setData(cyry);
            isSuccess = true;
            message = "查询成功";
            apiResult.setCode(200);
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    @ApiOperation(value = "寄递物流以及从业人员单位人员分析", notes = "", httpMethod = "POST")
    @PostMapping("aqzr")
    public ApiResult aqzr() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> cyry = deliverylogisticsService.aqzr();
            apiResult.setData(cyry);
            isSuccess = true;
            message = "查询成功";
            apiResult.setCode(200);
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    @ApiOperation(value = "寄递物流以及从业人员单位人员分析", notes = "", httpMethod = "POST")
    @PostMapping("dwjc")
    public ApiResult dwjc(@RequestBody Queryparems queryparems) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> cyry = deliverylogisticsService.dwjc(queryparems);
            apiResult.setData(cyry);
            isSuccess = true;
            message = "查询成功";
            apiResult.setCode(200);
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    @ApiOperation(value = "寄递物流以及从业人员单位人员分析", notes = "", httpMethod = "POST")
    @PostMapping("smsj")
    public ApiResult smsj(@RequestBody Queryparems queryparems){
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> cyry = deliverylogisticsService.smsj(queryparems);
            apiResult.setData(cyry);
            isSuccess = true;
            message = "查询成功";
            apiResult.setCode(200);
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    @ApiOperation(value = "寄递物流以及从业人员单位人员分析", notes = "", httpMethod = "POST")
    @PostMapping("yhlxmxqy")
    public ApiResult yhlxmxqy(){
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> cyry = deliverylogisticsService.yhlxmxqy();
            apiResult.setData(cyry);
            isSuccess = true;
            message = "查询成功";
            apiResult.setCode(200);
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    @ApiOperation(value = "快递车辆登记量情况分析", notes = "", httpMethod = "POST")
    @PostMapping("kdcl")
    public ApiResult kdcl(){
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> cyry = deliverylogisticsService.kdcl();
            apiResult.setData(cyry);
            isSuccess = true;
            message = "查询成功";
            apiResult.setCode(200);
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    @ApiOperation(value = "寄递物流以及从业人员单位人员分析", notes = "", httpMethod = "POST")
    @PostMapping("yhlxmx")
    public ApiResult yhlxmx(@RequestBody Queryparems queryparems){
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> cyry = deliverylogisticsService.yhlxmx(queryparems);
            apiResult.setData(cyry);
            isSuccess = true;
            message = "查询成功";
            apiResult.setCode(200);
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }


}
