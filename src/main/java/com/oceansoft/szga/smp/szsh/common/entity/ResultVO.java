package com.oceansoft.szga.smp.szsh.common.entity;

import lombok.Data;

/**
 * @author: wx
 * @description: 调用接口数据返回类
 * @create: 2018/10/04
 */
@Data
public class ResultVO<T> {

    private Boolean succ;

    private String message;

    private T data;


}
