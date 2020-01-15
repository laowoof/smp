package com.oceansoft.szga.smp.exception;

import java.util.HashMap;

/**
 * @author zhangxh
 * @create 2020/1/14
 * @email zhangxh@oceansoft.com.cn
 */
public class ParameterInvalidationException extends Exception {
    private String parameterName;
    private Object parameterValue;

    public ParameterInvalidationException() {
        this("", "请求参数非法");
    }

    public ParameterInvalidationException(String parameterName, Object parameterValue) {
        this.parameterName = parameterName;
        this.parameterValue = parameterValue;
    }

    public ParameterInvalidationException(String message, String parameterName, Object parameterValue) {
        this.parameterName = parameterName;
        this.parameterValue = parameterValue;
    }

    public Object getData() {
        return new HashMap<String, Object>(2) {
            {
                this.put("name", ParameterInvalidationException.this.parameterName);
                this.put("value", ParameterInvalidationException.this.parameterValue);
            }
        };
    }
}
