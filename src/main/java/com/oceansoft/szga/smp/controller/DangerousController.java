package com.oceansoft.szga.smp.controller;

import com.alibaba.fastjson.JSONObject;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.service.DangerousService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
    private RestTemplate restTemplate;

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

    @ApiOperation(value = "调第三方接口", notes = "", httpMethod = "POST")
    @PostMapping("api")
    public JSONObject api(@RequestBody JSONObject json) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity( headers);
        return restTemplate.postForObject(json.getString("url"), request, JSONObject.class);
    }

    /**
     * 全面分析/剧毒
     * @return
     */
    @ApiOperation(value = "全面分析/剧毒", notes = "", httpMethod = "POST")
    @PostMapping("all/high-poison")
    public ApiResult queryHighPoison() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> mapList = dangerousService.queryHighPoison();
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
     * 全面分析/剧毒折线图
     * @return
     */
    @ApiOperation(value = "全面分析/剧毒折线图", notes = "", httpMethod = "POST")
    @GetMapping("all/high-poison-line")
    public ApiResult queryHighPoisonLine(Integer type) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> mapList = dangerousService.queryHighPoisonLine(type);
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
     * 全面分析/易制爆
     * @return
     */
    @ApiOperation(value = "全面分析/易制爆", notes = "", httpMethod = "POST")
    @PostMapping("all/easy-boom")
    public ApiResult queryEasyBoom() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> mapList = dangerousService.queryEasyBoom();
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
     * 全面分析/易制爆折线图
     * @param type
     * @return
     */
    @ApiOperation(value = "全面分析/易制爆折线图", notes = "", httpMethod = "POST")
    @GetMapping("all/easy-boom-line")
    public ApiResult queryEasyBoomLine(Integer type) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> mapList = dangerousService.queryEasyBoomLine(type);
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

    @ApiOperation(value = "危险品分析/基本信息", notes = "", httpMethod = "POST")
    @PostMapping("danger/base-info")
    public ApiResult queryDangerBaseInfo() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            Map<String, Object> map = dangerousService.queryDangerBaseInfo();
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

    /**
     * 危险品分析/剧毒化学品分析-单位
     * @param jsonObject
     * @return
     */
    @ApiOperation(value = "危险品分析/剧毒化学品分析-单位", notes = "", httpMethod = "POST")
    @PostMapping("danger/high-poison-dw")
    public ApiResult queryDangerHighPoisonDw(@RequestBody JSONObject jsonObject) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> mapList = dangerousService.queryDangerHighPoisonDw(jsonObject);
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
     * 危险品分析/剧毒化学品分析-类型
     * @param jsonObject
     * @return
     */
    @ApiOperation(value = "危险品分析/剧毒化学品分析-类型", notes = "", httpMethod = "POST")
    @PostMapping("danger/high-poison-lx")
    public ApiResult queryDangerHighPoisonLx(@RequestBody JSONObject jsonObject) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> mapList = dangerousService.queryDangerHighPoisonLx(jsonObject);
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
     * 危险品分析/剧毒化学品分析-排行榜
     * @param jsonObject
     * @return
     */
    @ApiOperation(value = "危险品分析/剧毒化学品分析-排行榜", notes = "", httpMethod = "POST")
    @PostMapping("danger/high-poison-rank")
    public ApiResult queryDangerHighPoisonRank(@RequestBody JSONObject jsonObject) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> mapList = dangerousService.queryDangerHighPoisonRank(jsonObject);
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

    @ApiOperation(value = "履职分析/单位登记量排名", notes = "", httpMethod = "POST")
    @PostMapping("duty/company-rank")
    public ApiResult queryCompanyRank() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> mapList = dangerousService.queryCompanyRank();
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

    @ApiOperation(value = "履职分析/重点岗位人员登记量排名", notes = "", httpMethod = "POST")
    @PostMapping("duty/imp-post-rank")
    public ApiResult queryImpPostRank() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> mapList = dangerousService.queryImpPostRank();
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

    @ApiOperation(value = "履职分析/单位缺检查量排名", notes = "", httpMethod = "POST")
    @PostMapping("duty/company-check-rank")
    public ApiResult queryCompanyCheckRank() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> mapList = dangerousService.queryCompanyCheckRank();
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

    @ApiOperation(value = "履职分析/隐患发现量排名", notes = "", httpMethod = "POST")
    @PostMapping("duty/hidden-discover-rank")
    public ApiResult queryHiddenDiscoverRank() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> mapList = dangerousService.queryHiddenDiscoverRank();
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

    @ApiOperation(value = "履职分析/隐患整改量排名", notes = "", httpMethod = "POST")
    @PostMapping("duty/hidden-handle-rank")
    public ApiResult queryHiddenHandleRank() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> mapList = dangerousService.queryHiddenHandleRank();
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

    @ApiOperation(value = "履职分析/隐患未整改量排名", notes = "", httpMethod = "POST")
    @PostMapping("duty/hidden-no-handle-rank")
    public ApiResult queryHiddenNoHandleRank() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> mapList = dangerousService.queryHiddenNoHandleRank();
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

    @ApiOperation(value = "履职分析/预警处理量排名", notes = "", httpMethod = "POST")
    @PostMapping("duty/early-handle-rank")
    public ApiResult queryEarlyHandleRank() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Object>> mapList = dangerousService.queryEarlyHandleRank();
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
