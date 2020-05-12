package com.oceansoft.szga.smp.szsh.core.vo.system;

import lombok.Data;

/**
 * @author wx
 * 事后监管企业事项配置列表
 * @version 2018/9/18
 */
@Data
public class ShEntercaseV0 {

    /**
     * 企业事项关联id
     */
    private String id;

    /**
     * 关联事项名称
     */
    private String caseName;

    /**
     * 是否可用    0：禁用  1：启用
     */
    private Integer available;

    /**
     * 企业名称
     */
    private String enterName;

    /**
     * 申请人姓名
     */
    private String applyName;

    /**
     * 统一社会信用代码
     */
    private String creditCode;

    /**
     * 申请人身份证号
     */
    private String applyCode;

    /**
     * 所属部门
     */
    private String orgName;

    /**
     * 登记机关
     */
    private String registration;

    /**
     * 法定代表人
     */
    private String artificial;

    /**
     * 联系方式
     */
    private String contact;


    /**
     * 是否市局监管  1:是
     */
    private Integer isSj;


}
