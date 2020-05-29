package com.oceansoft.szga.smp.util;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author zhangxh
 * @create 2020/5/28
 * @email zhangxh@oceansoft.com.cn
 */
public class RestTemplateUtil {
    private static class SingletonRestTemplate {
        /**
         * 单例对象实例
         */
        static final RestTemplate INSTANCE = new RestTemplate();
    }

    /**
     * 单例实例
     */
    public static RestTemplate getInstance() {
        return SingletonRestTemplate.INSTANCE;
    }

    public static ApiResult confirmFile(String fileGuid,String confirmUrl){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map data = Maps.newHashMap();
        data.put("file_ids", fileGuid);
        HttpEntity request = new HttpEntity(data, headers);
        return getInstance().postForObject(confirmUrl, request, ApiResult.class);
    }

}
