package com.oceansoft.szga.smp.szsh.core.config.cas;

import net.unicon.cas.client.configuration.CasClientConfigurerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author zhangxh
 * @date 2018/5/25
 */
@Configuration
public class CasConfig extends CasClientConfigurerAdapter {

    @Value("${prop.cas-ignore-pattern}")
    private String casIgnorePattern;

    @Override
    public void configureAuthenticationFilter(FilterRegistrationBean authenticationFilter) {
        authenticationFilter.getInitParameters().put("ignorePattern", casIgnorePattern);
    }
}
