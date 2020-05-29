package com.oceansoft.szga.smp.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zhangxh
 * @create 2020/1/14
 * @email zhangxh@oceansoft.com.cn
 */
@Component
@Data
public class ConfigProperties {
    @Value("${file.confirm-url}")
    private String confirmFileUrl;

    public String getConfirmFileUrl() {
        return confirmFileUrl;
    }

    public void setConfirmFileUrl(String confirmFileUrl) {
        this.confirmFileUrl = confirmFileUrl;
    }
}