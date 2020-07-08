package com.oceansoft.szga.smp.szsh.core.controller.system;

import com.oceansoft.szga.smp.service.FlowReportService;
import com.oceansoft.szga.smp.szsh.common.bean.ResponseCode;
import com.oceansoft.szga.smp.szsh.common.bean.ResponseResult;
import com.oceansoft.szga.smp.szsh.core.config.jwt.JwtToken;
import com.oceansoft.szga.smp.szsh.core.entity.system.SysUser;
import com.oceansoft.szga.smp.szsh.core.service.system.SysUserService;
import com.oceansoft.szga.smp.szsh.core.vo.system.SignUserV1;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * @author wx
 * @version 2018/12/26
 */

@Controller
@RequestMapping(value = {"cas/login"})
@Api(tags = {"单点登陆"})
public class CasLoginController {

    @Value("${prop.redirect-url}")
    private String redirectUrl;

    @Autowired
    private SysUserService userService;

    @Autowired
    private FlowReportService  reportService;

    @PostMapping(value = {"info"})
    @ResponseBody
    @ApiOperation(value = "单点登陆回传")
    public ResponseResult getInfo(){
        ResponseResult responseResult= new ResponseResult();
        SignUserV1 signUserV1=new SignUserV1();
        JwtToken jwtToken=((JwtToken) SecurityUtils.getSubject().getPrincipal());
        SysUser data =  (SysUser)reportService.userAll(jwtToken.getUid()).getData();
        if(jwtToken!=null){
            signUserV1.setDepartmentId(data.getDepartmentId());
            signUserV1.setDepartmentName(data.getDepartmentName());
            signUserV1.setUserId(data.getId());
            signUserV1.setLoginName(data.getName());
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
        System.err.println("====index接口===");
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
