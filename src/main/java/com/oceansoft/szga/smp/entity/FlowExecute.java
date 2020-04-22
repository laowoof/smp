package com.oceansoft.szga.smp.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author zhangxh
 * @create 2020/4/21
 * @email zhangxh@oceansoft.com.cn
 */
@Data
public class FlowExecute {
    @NotNull
    private String updateUser;
    @NotNull
    private String guid;
    private String des;
    private String receiveDepts;
    private String action;
}
