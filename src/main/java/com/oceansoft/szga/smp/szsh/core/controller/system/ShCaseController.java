package com.oceansoft.szga.smp.szsh.core.controller.system;

import com.oceansoft.szga.smp.szsh.common.annotation.SysLogs;
import com.oceansoft.szga.smp.szsh.common.bean.ResponseCode;
import com.oceansoft.szga.smp.szsh.common.bean.ResponseResult;
import com.oceansoft.szga.smp.szsh.core.dto.system.userCase.FindShCaseDTO;
import com.oceansoft.szga.smp.szsh.core.entity.system.CmCase;
import com.oceansoft.szga.smp.szsh.core.service.system.CmCaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/system/shcase"})
@Api(tags = {"事后事项管理"})
public class ShCaseController {

    @Autowired
    private CmCaseService caseService;

    @PostMapping(value = {"/list"})
    @ApiOperation(value = "分页获取事后监管事项列表")
    @ApiImplicitParam(paramType = "header",name = "Authorization",value = "身份认证Token")
    public ResponseResult getShCaseListPage(@RequestBody @Validated @ApiParam(value = "事后监管事项搜索参数") FindShCaseDTO findShCaseDTO){
        return ResponseResult.e(ResponseCode.OK,caseService.getShCaseListPage(findShCaseDTO));
    }


    @PostMapping(value = {"/add"})
    @ApiOperation(value = "添加事后监管事项")
    @SysLogs("添加事后监管事项")
    @ApiImplicitParam(paramType = "header",name = "Authorization",value = "身份认证Token")
    public ResponseResult addShCase(@RequestBody @Validated @ApiParam(value = "事后监管事项数据") CmCase shCase){
        caseService.addShCase(shCase);
        return ResponseResult.e(ResponseCode.OK);
    }

    @PostMapping(value = {"/update"})
    @ApiOperation(value = "变更事后监管事项")
    @SysLogs("变更事后监管事项")
    @ApiImplicitParam(paramType = "header",name = "Authorization",value = "身份认证Token")
    public ResponseResult updateShCase(@RequestBody @Validated @ApiParam(value = "事后监管事项数据") CmCase shCase){
        caseService.updateShCase(shCase);
        return ResponseResult.e(ResponseCode.OK);
    }

}
