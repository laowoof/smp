package com.oceansoft.szga.smp.szsh.core.controller.system;

import com.oceansoft.szga.smp.szsh.common.bean.ResponseCode;
import com.oceansoft.szga.smp.szsh.common.bean.ResponseResult;
import com.oceansoft.szga.smp.szsh.core.config.jwt.JwtToken;
import com.oceansoft.szga.smp.szsh.core.service.system.SysUserService;
import com.oceansoft.szga.smp.szsh.core.vo.system.SignUserV1;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * @author wx
 * @version 2018/12/26
 */

@Controller
@RequestMapping(value = {"/cas/login"})
@Api(tags = {"单点登陆"})
public class CasLoginController {

    @Value("${cas.redirect-url}")
    private String redirectUrl;

    @Autowired
    private SysUserService userService;

    @PostMapping(value = {"/info"})
    @ResponseBody
    @ApiOperation(value = "单点登陆回传")
    public ResponseResult getInfo(){
        ResponseResult responseResult=new ResponseResult();
        SignUserV1 signUserV1=new SignUserV1();
        JwtToken jwtToken=((JwtToken) SecurityUtils.getSubject().getPrincipal());
        if(jwtToken!=null){
            signUserV1.setName(jwtToken.getUsername());
            signUserV1.setToken(jwtToken.getToken());
            signUserV1.setPermission(userService.getAllPermissionTag(jwtToken.getUid()));
            responseResult= ResponseResult.e(ResponseCode.SIGN_IN_OK,signUserV1);
        }else{
            responseResult= ResponseResult.e(ResponseCode.NOT_SING_IN_CAS);
        }
        return responseResult;
    }

    @GetMapping("index")
    public String index(){
        return "redirect:"+redirectUrl;
    }

    @PostMapping("out")
    @ResponseBody
    public ResponseResult logout(HttpServletRequest request) throws ServletException {
        SecurityUtils.getSubject().logout();
        request.getSession().invalidate();
        request.logout();
        return new ResponseResult();
    }



}
