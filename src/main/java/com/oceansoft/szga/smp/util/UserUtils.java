package com.oceansoft.szga.smp.util;

import com.oceansoft.szga.smp.service.FlowReportService;
import com.oceansoft.szga.smp.szsh.core.config.jwt.JwtToken;
import com.oceansoft.szga.smp.szsh.core.entity.system.SysUser;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.BeanInitializationException;

/**
 * 获取用户信息
 *
 * @author JackChan
 * @Date 2020/6/29 0029 下午 12:13
 */
public class UserUtils {

    private static FlowReportService reportService;

    public static void setReportService(FlowReportService flowReportService) {
        UserUtils.reportService = flowReportService;
    }


    public static SysUser getUserData() {
        if (reportService == null) {
            throw new BeanInitializationException("reportService is null");
        }
        JwtToken jwtToken = ((JwtToken) SecurityUtils.getSubject().getPrincipal());
        SysUser data = (SysUser) reportService.userAll(jwtToken.getUid()).getData();
        SysUser data1 = data;
        return data1;
    }

}
