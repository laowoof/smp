package com.oceansoft.szga.smp.config;

import com.oceansoft.szga.smp.config.domain.ApiQueryResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * 系统配置
 * @author wuzy
 * @created 2017-02-10-15:25
 * @email wzy@oceansoft.com.cn
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new ApiQueryResolver());
    }
}