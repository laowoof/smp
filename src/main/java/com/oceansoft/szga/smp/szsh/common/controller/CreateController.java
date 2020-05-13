package com.oceansoft.szga.smp.szsh.common.controller;

import com.oceansoft.szga.smp.szsh.common.annotation.SysLogs;
import com.oceansoft.szga.smp.szsh.common.bean.ResponseCode;
import com.oceansoft.szga.smp.szsh.common.bean.ResponseResult;
import com.oceansoft.szga.smp.szsh.common.service.CreateService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author wx
 * @version 2018/9/25/13:27
 */
public interface CreateController<AD,S extends CreateService<AD>> {

    S getService();

    @PostMapping("/add")
    @ApiOperation(value = "添加新增")
    @SysLogs("添加新增")
    @ApiImplicitParam(paramType = "header",name = "Authorization",value = "身份认证Token",required = true)
    default ResponseResult add(@RequestBody @Validated AD a){
        getService().add(a);
        return ResponseResult.e(ResponseCode.OK);
    }
}
