package com.oceansoft.szga.smp.entity;

import lombok.Data;

@Data
public class FlowTask {
    private String guid;
    private String flowId;
    private String createDate;
    private String createUser;
    private String nodeName;
    private String state;
    private String updateDate;
    private String updateUser;
    private String dept;
    private String flowNodeId;
    private String des;
    private String actionName;
}
