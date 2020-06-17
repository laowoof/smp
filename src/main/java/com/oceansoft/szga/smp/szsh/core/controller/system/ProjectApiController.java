package com.oceansoft.szga.smp.szsh.core.controller.system;


import com.oceansoft.szga.smp.szsh.common.bean.ResponseCode;
import com.oceansoft.szga.smp.szsh.common.bean.ResponseResult;
import com.oceansoft.szga.smp.szsh.core.service.system.CmOrgService;
import com.oceansoft.szga.smp.szsh.core.service.system.SysOrgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author wx
 * @version 2018/9/18
 */
@RestController
@RequestMapping(value = {"/api"})
@Api(tags = {"事中监管"})
public class ProjectApiController {


    @Autowired
    private CmOrgService orgService;

    @Autowired
    private SysOrgService classService;


    @GetMapping(value = {"/getOrgList"})
    @ApiOperation(value = "获取监管部门列表")
    @ApiImplicitParam(paramType = "header",name = "Authorization",value = "身份认证Token")
    public ResponseResult orglist(){
        return ResponseResult.e(ResponseCode.OK,orgService.selectAllOrg());
    }


    @GetMapping(value = {"/getClassList"})
    @ApiOperation(value = "获取警种列表")
    @ApiImplicitParam(paramType = "header",name = "Authorization",value = "身份认证Token")
    public ResponseResult getClassAlllist(){
        return ResponseResult.e(ResponseCode.OK,classService.getClassAlllist());
    }



}
