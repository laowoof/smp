package com.oceansoft.szga.smp.controller;

import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.entity.TreeDeptResult;
import com.oceansoft.szga.smp.service.ListTreeResultService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 获取树形结构控制层
 *
 * @author JackChan
 * @Date 2020/7/1 0001 下午 3:44
 */
@RestController
@RequestMapping("tree/result")
public class ListTreeResultController {

    @Autowired
    private ListTreeResultService listTreeResultService;

    /**
     * 获取树形所有派发部门
     */
    @ApiOperation(value = "获取树形派发部门", notes = "", httpMethod = "POST")
    @PostMapping("dept")
    public ApiResult getDeptTreeResult() {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            TreeDeptResult deptTreeResult = listTreeResultService.getDeptTreeResult();
            isSuccess = true;
            apiResult.setData(deptTreeResult);
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setCode(200);
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    /**
     * 获取树形下派部门
     */
    @ApiOperation(value = "获取树形派发部门", notes = "", httpMethod = "POST")
    @PostMapping("lower-dept")
    public ApiResult<List<TreeDeptResult>> getLowerDeptTreeResult(String id) {
        ApiResult<List<TreeDeptResult>> apiResult = new ApiResult<>();
        boolean isSuccess = false;
        String message = "";
        try {
            List<TreeDeptResult> deptTreeResult = listTreeResultService.getLowerDeptTreeResult(id);
            isSuccess = true;
            apiResult.setData(deptTreeResult);
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setCode(200);
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }


}
