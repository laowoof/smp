package com.oceansoft.szga.smp.controller;

import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.service.HomePageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 首页接口控制层
 *
 * @author JackChan
 * @Date 2020/6/24 0024 下午 2:44
 */
@RestController
@RequestMapping("home/page")
public class HomePageController {

    @Autowired
    private HomePageService homePageService;

    /**
     * 首页道路交通安全监管
     */
    @ApiOperation(value = "首页道路交通安全监管", notes = "", httpMethod = "POST")
    @PostMapping("road-safe")
    public ApiResult getRoadSafe() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            Map<String, Integer> roadBaseInfo = homePageService.getRoadBaseInfo();
            isSuccess = true;
            apiResult.setData(roadBaseInfo);
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setCode(200);
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    /**
     * 首页群租房安全监管
     */
    @ApiOperation(value = "首页群租房安全监管", notes = "", httpMethod = "POST")
    @PostMapping("renting-safe")
    public ApiResult getRentSafe() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            Map<String, Integer> rentSafe = homePageService.getRentSafe();
            isSuccess = true;
            apiResult.setData(rentSafe);
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setCode(200);
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    /**
     * 首页重点目标安全监管基本信息
     */
    @ApiOperation(value = "首页重点目标安全监管基本信息", notes = "", httpMethod = "POST")
    @PostMapping("imp-target")
    public ApiResult getImpTarget() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            Map<String, Integer> impTarget = homePageService.getImpTarget();
            isSuccess = true;
            apiResult.setData(impTarget);
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setCode(200);
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    /**
     * 首页重点目标安全监管基本信息饼图
     */
    @ApiOperation(value = "首页重点目标安全监管基本信息饼图", notes = "", httpMethod = "POST")
    @PostMapping("imp-targetPie")
    public ApiResult getImpTargetPie() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<Map<String, Integer>> impTargetPie = homePageService.getImpTargetPie();
            isSuccess = true;
            apiResult.setData(impTargetPie);
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setCode(200);
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

}
