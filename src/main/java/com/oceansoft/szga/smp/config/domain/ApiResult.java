package com.oceansoft.szga.smp.config.domain;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author zhangxh
 * @create 2020/1/14
 * @email zhangxh@oceansoft.com.cn
 */
public class ApiResult<T> {
    public static final int RESULT_SUCC = 200;
    private boolean succ;
    private int code;
    private String msg;
    private T data;

    public ApiResult() {
        this(200, true, "", (T)null);
    }

    public ApiResult(String message) {
        this(200, true, message, (T)null);
    }

    public ApiResult(int status, String message) {
        this(status, 200 == status, message, (T)null);
    }

    public ApiResult(int status, T data) {
        this(status, 200 == status, "", data);
    }

    public ApiResult(T data) {
        this(200, true, "", data);
    }

    public ApiResult(int status, boolean success) {
        this(status, success, "", (T)null);
    }

    public ApiResult(int status, boolean succ, T data) {
        this(status, succ, "", data);
    }

    public ApiResult(int status, boolean succ, String message) {
        this(status, succ, message, (T)null);
    }

    public ApiResult(int status, boolean succ, String msg, T data) {
        this.succ = succ;
        this.code = status;
        this.data = data;
        this.msg = msg;
    }

    public ApiResult<T> success() {
        return this.success(200, this.msg, this.data);
    }

    public ApiResult<T> success(String message) {
        return this.success(message, this.data);
    }

    public ApiResult<T> success(T data) {
        return this.success(this.msg, data);
    }

    public ApiResult<T> success(String message, T data) {
        return this.success(200, message, data);
    }

    public ApiResult<T> success(int status, String message, T data) {
        this.succ = true;
        this.code = status;
        this.msg = message;
        this.data = data;
        return this;
    }

    public ApiResult<T> failure() {
        this.succ = false;
        return this;
    }

    public ApiResult<T> failure(String message) {
        this.succ = false;
        this.msg = message;
        return this;
    }

    public ApiResult<T> failure(T data) {
        this.succ = false;
        this.data = data;
        return this;
    }

    public ApiResult<T> failure(int status) {
        return this.failure(status, this.msg, this.data);
    }

    public ApiResult<T> failure(int status, String message) {
        return this.failure(status, message, this.data);
    }

    public ApiResult<T> failure(int status, T data) {
        return this.failure(status, this.msg, data);
    }

    public ApiResult<T> failure(int status, String message, T data) {
        this.succ = false;
        this.code = status;
        this.msg = message;
        this.data = data;
        return this;
    }

    public boolean isSucc() {
        return this.succ;
    }

    public void setSucc(boolean succ) {
        this.succ = succ;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static ApiResult error(BindingResult bindingResult) {
        final List<ObjectError> errors = bindingResult.getAllErrors();
        return (new ApiResult(new LinkedHashMap<String, String>(errors.size()) {
            {
                Iterator var3 = errors.iterator();

                while(var3.hasNext()) {
                    ObjectError error = (ObjectError)var3.next();
                    this.put(((FieldError)error).getField(), error.getDefaultMessage());
                }

            }
        })).failure(100101, "表单参数检验失败");
    }
}
