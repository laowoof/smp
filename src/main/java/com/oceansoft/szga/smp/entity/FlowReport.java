package com.oceansoft.szga.smp.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author zhangxh
 * @create 2020/4/21
 * @email zhangxh@oceansoft.com.cn
 */
@Data
public class FlowReport {
    private String guid;
    @NotNull
    private String flowType;
    @NotNull
    private String reportDept;
    private String reportDate;
    @NotNull
    private String taskName;
    private String des;
    private String receiptsInfo;
    private String fileIds;
    private String createUser;
    private String createUserId;
    private String createDate;
    private String isDelete;
    private String source;

}
