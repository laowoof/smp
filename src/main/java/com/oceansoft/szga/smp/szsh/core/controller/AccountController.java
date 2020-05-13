package com.oceansoft.szga.smp.szsh.core.controller;

import com.oceansoft.szga.smp.szsh.core.config.jwt.JwtToken;
import com.oceansoft.szga.smp.szsh.core.dto.SignInDTO;
import com.oceansoft.szga.smp.szsh.core.service.system.SysUserService;
import com.oceansoft.szga.smp.szsh.common.bean.ResponseResult;
import com.oceansoft.szga.smp.szsh.common.bean.ResponseCode;
import com.oceansoft.szga.smp.szsh.common.annotation.SysLogs;
import com.oceansoft.szga.smp.szsh.core.vo.system.SignUserV0;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wx
 * @version 2018/9/13/14:02
 */
@RestController
@RequestMapping(value = {"/account"})
@Api(tags = {"账户相关"})
public class AccountController {

    @Autowired
    private SysUserService userService;

    @PostMapping(value = {"/sign-in"})
    @ApiOperation(value = "登录")
    @SysLogs("登录")
    public ResponseResult signIn(@RequestBody @Validated @ApiParam(value = "登录数据",required = true)
                                         SignInDTO signInDTO){
        userService.signIn(signInDTO);
        SignUserV0 signUserV0=new SignUserV0();
        signUserV0.setToken(((JwtToken)SecurityUtils.getSubject().getPrincipal()).getToken());
        signUserV0.setPermission(userService.getAllPermissionTag(((JwtToken) SecurityUtils.getSubject().getPrincipal()).getUid()));
        return ResponseResult.e(ResponseCode.SIGN_IN_OK,signUserV0);
    }

    @PostMapping(value = "/current")
    @ApiOperation(value = "获取当前用户信息")
    @SysLogs("获取当前用户信息")
    @ApiImplicitParam(paramType = "header",name = "Authorization",value = "身份认证Token")
    public ResponseResult current(){
        return ResponseResult.e(ResponseCode.OK, userService.getCurrentUser());
    }

    @PostMapping(value = "/logout")
    @ApiOperation(value = "注销登录")
    @SysLogs("注销登录")
    @ApiImplicitParam(paramType = "header",name = "Authorization",value = "身份认证Token")
    public ResponseResult logout(){
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
        }catch (Exception e){
            return ResponseResult.e(ResponseCode.LOGOUT_FAIL);
        }
        return ResponseResult.e(ResponseCode.LOGOUT_OK);
    }

    @PostMapping(value = "/all-permission-tag")
    @ApiOperation(value = "获取当前用户的权限标示")
    @ApiImplicitParam(paramType = "header",name = "Authorization",value = "身份认证Token")
    public ResponseResult<List<String>> getAllPermissionTag(){
        return ResponseResult.e(ResponseCode.OK,userService.getAllPermissionTag());
    }



}
