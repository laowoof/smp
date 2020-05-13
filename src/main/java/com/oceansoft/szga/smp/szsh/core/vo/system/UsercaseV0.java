package com.oceansoft.szga.smp.szsh.core.vo.system;

import lombok.Data;

import java.util.Date;

/**
 * @author wx
 * 事中监管配置列表
 * @version 2018/9/18
 */
@Data
public class UsercaseV0 {

//    private String id;
//    private String name;
//    private Integer age;
//    private String departmentName;
//    private Integer sex;
//    private String contact;
//    private List<CmUserCase> userCases;
//    private String type;
//    private String caseName;

    private String id;
    private String caseId;
    private String caseName;
    private String userId;
    private Integer available;
    private String type;
    private String createdBy;
    private Date createdDate;
    private String lastModifiedBy;
    private Date lastModifiedDate;
//    private SysUser user;
    private String name;
    private Integer age;
    private String departmentName;
    private Integer sex;
    private String contact;
    private String category;
    private String userNo;
//    private Date expireDate;
//    private String training;

    //所属部门ID
    private String orgId;

}
