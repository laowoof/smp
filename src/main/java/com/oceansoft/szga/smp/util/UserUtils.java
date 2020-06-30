package com.oceansoft.szga.smp.util;

import com.oceansoft.szga.smp.service.FlowReportService;
import com.oceansoft.szga.smp.szsh.core.config.jwt.JwtToken;
import com.oceansoft.szga.smp.szsh.core.entity.system.SysUser;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 获取用户信息
 *
 * @author JackChan
 * @Date 2020/6/29 0029 下午 12:13
 */
public class UserUtils {

    @Autowired
    private static FlowReportService reportService;

    public static SysUser getUserData() {
        JwtToken jwtToken = ((JwtToken) SecurityUtils.getSubject().getPrincipal());
        SysUser data = (SysUser) reportService.userAll(jwtToken.getUid()).getData();
        SysUser data1 = data;
        return data1;
    }

}
