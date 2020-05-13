package com.oceansoft.szga.smp.szsh.core.controller.system;

import com.oceansoft.szga.smp.szsh.common.annotation.SysLogs;
import com.oceansoft.szga.smp.szsh.common.bean.ResponseCode;
import com.oceansoft.szga.smp.szsh.common.bean.ResponseResult;
import com.oceansoft.szga.smp.szsh.core.dto.system.org.FindOrgDTO;
import com.oceansoft.szga.smp.szsh.core.entity.system.CmOrg;
import com.oceansoft.szga.smp.szsh.core.service.system.CmOrgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author wx
 * @version 2018/9/18
 */
@RestController
@RequestMapping(value = {"/system/org"})
@Api(tags = {"监管部门管理"})
public class OrgController {

    @Autowired
    private CmOrgService orgService;

    @PostMapping(value = {"/list"})
    @ApiOperation(value = "分页获取监管部门")
    @ApiImplicitParam(paramType = "header",name = "Authorization",value = "身份认证Token")
    public ResponseResult getOrgListPage(@RequestBody @Validated @ApiParam(value = "监管部门搜索参数") FindOrgDTO findOrgDTO){
        return ResponseResult.e(ResponseCode.OK,orgService.getOrgListPage(findOrgDTO));
    }


    @PostMapping(value = {"/add"})
    @ApiOperation(value = "添加监管部门")
    @SysLogs("添加监管部门")
    @ApiImplicitParam(paramType = "header",name = "Authorization",value = "身份认证Token")
    public ResponseResult addOrg(@RequestBody @Validated @ApiParam(value = "监管部门数据") CmOrg cmOrg){
        orgService.addOrg(cmOrg);
        return ResponseResult.e(ResponseCode.OK);
    }


    @PostMapping(value = {"/update"})
    @ApiOperation(value = "变更监管部门")
    @SysLogs("变更监管部门")
    @ApiImplicitParam(paramType = "header",name = "Authorization",value = "身份认证Token")
    public ResponseResult updateOrg(@RequestBody @Validated @ApiParam(value = "监管部门数据") CmOrg cmOrg){
        orgService.updateOrg(cmOrg);
        return ResponseResult.e(ResponseCode.OK);
    }


}
