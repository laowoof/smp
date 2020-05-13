package com.oceansoft.szga.smp.szsh.core.vo.system;

import lombok.Data;

import java.util.Date;

/**
 * @author wx
 * 事后监管专家事项配置列表
 * @version 2018/9/18
 */
@Data
public class ShExpertcaseV0 {

    /**
     * 专家事项关联id
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
     * 专家姓名
     */
    private String expertName;

    /**
     * 专家性别
     */
    private Integer expertSex;

    /**
     * 专家年龄
     */
    private Integer expertAge;

    /**
     * 联系方式
     */
    private String contact;

    /**
     * 工作单位
     */
    private String employer;

    /**
     * 学历
     */
    private String education;

    /**
     * 职称
     */
    private String technical;

    /**
     * 证书编号
     */
    private String idNumber;

    /**
     * 证书有效期
     */
    private Date periodDate;


    /**
     * 证书状态  0：过期  1：正常  2：临近
     */
    private Integer status;

}
