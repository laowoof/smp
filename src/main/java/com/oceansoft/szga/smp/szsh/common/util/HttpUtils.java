package com.oceansoft.szga.smp.szsh.common.util;

import com.oceansoft.szga.smp.szsh.common.entity.ResultVO;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author: wx
 * @description: 辅助工具类
 * @create: 2018/10/04
 */
public class HttpUtils {

    /**
     * 向目的URL发送post请求  formdata形式
     * @param url       目的url
     * @param params    发送的参数
     * @return  ResultVO
     */
    public static ResultVO sendPostRequest(String url, MultiValueMap<String, String> params){
        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpMethod method = HttpMethod.POST;
        // 以formdata形式的方式提交
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        //将请求头部和参数合成一个请求
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        //执行HTTP请求，将返回的结构使用ResultVO类格式化
        ResponseEntity<ResultVO> response = client.exchange(url, method, requestEntity, ResultVO.class);

        return response.getBody();
    }


    /**
     * 向目的URL发送post请求  json形式
     * @param url       目的url
     * @param params    发送的参数
     * @return  ResultVO
     */
    public static JSONObject sendPostJsonRequest(String url, JSONObject params){
        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpMethod method = HttpMethod.POST;


//        ResultVO response = client.postForEntity(url, params, ResultVO.class).getBody();
        JSONObject json = client.postForEntity(url, params, JSONObject.class).getBody();
        return json;
    }

}
