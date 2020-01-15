package com.oceansoft.szga.smp.aop.DTO;

import lombok.Data;
/**
 *
 * @author zhangxh
 * @date 2018/4/20
 */
@Data
public class OperLog{

    private static final long serialVersionUID = -6729934107041673755L;
    private String url;

    private String httpMethod;

    private String ip;

    private String params;

    private String userAgent;

    private String classMethod;

    private String args;

    private String result;

    private String exception;

    private String startTime;

    private String endTime;
}
