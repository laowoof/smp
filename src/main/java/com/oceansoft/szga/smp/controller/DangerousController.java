package com.oceansoft.szga.smp.controller;

import com.alibaba.fastjson.JSONObject;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.service.DangerousService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 危险品全态研析控制层
 *
 * @author JackChan
 * @Date 2020/7/10 0010 上午 11:12
 */
@RestController
@RequestMapping("dangerous/analysis")
public class DangerousController {

    @Autowired
    private DangerousService dangerousService;

    /**
     * 全面分析/基本信息
     * @return
     */
    @ApiOperation(value = "全面分析/基本信息", notes = "", httpMethod = "POST")
    @PostMapping("all/base-info")
    public ApiResult queryBaseInfo() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> mapList = dangerousService.queryBaseInfo();
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

    /**
     * 全面分析/监管单位分类分析
     * @return
     */
    @ApiOperation(value = "全面分析/监管单位分类分析", notes = "", httpMethod = "POST")
    @PostMapping("all/supervise-unit")
    public ApiResult querySuperviseUnit() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> mapList = dangerousService.querySuperviseUnit();
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

    /**
     * 全面分析/重点人员岗位分析
     * @return
     */
    @ApiOperation(value = "全面分析/重点人员岗位分析", notes = "", httpMethod = "POST")
    @PostMapping("all/import-people")
    public ApiResult queryImportPeople() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> mapList = dangerousService.queryImportPeople();
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

    /**
     * 全面分析/危险品单位
     * @return
     */
    @ApiOperation(value = "全面分析/危险品单位", notes = "", httpMethod = "POST")
    @PostMapping("all/dangerous-dw")
    public ApiResult queryDangerousDw(@RequestBody JSONObject json) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> mapList = dangerousService.queryDangerousDw(json);
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

    /**
     * 全面分析/重点岗位人员
     * @return
     */
    @ApiOperation(value = "全面分析/重点岗位人员", notes = "", httpMethod = "POST")
    @PostMapping("all/import-dw")
    public ApiResult queryImportDw(@RequestBody JSONObject json) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> mapList = dangerousService.queryImportDw(json);
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
