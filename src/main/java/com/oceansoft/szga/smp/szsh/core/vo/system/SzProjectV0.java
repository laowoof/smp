package com.oceansoft.szga.smp.szsh.core.vo.system;

import lombok.Data;

import java.util.Date;

/**
 * @author wx
 * 事中监管任务列表
 * @version 2018/9/18
 */
@Data
public class SzProjectV0 {

    private String id;
    /**
     * 事项ID
     */
    private String caseId;
    /**
     * 事项名称
     */
    private String caseName;
    /**
     * 申报编号
     */
    private String projectNo;
    /**
     * 受理人ID
     */
    private String acceptId;
    /**
     * 受理人姓名
     */
    private String acceptName;
    /**
     * 受理部门
     */
    private String acceptOrg;
    /**
     * 受理部门id
     */
    private String acceptOrgId;
    /**
     * 申报内容
     */
    private String content;
    /**
     * 受理时间
     */
    private Date acceptDate;
    /**
     * 申办单位/个人名称
     */
    private String applyName;
    /**
     * 身份证号/营业执照
     */
    private String applyCode;
    /**
     * 电话
     */
    private String applyPhone;
    /**
     * 手机
     */
    private String applyMobile;
    /**
     * 联系地址
     */
    private String applyAddress;
    /**
     * 联系人
     */
    private String applyMan;
    /**
     * 事中监管结果  0:不符合  1:符合  2:需整改
     */
    private Integer results;
    /**
     * 整改意见  results为2时必填
     */
    private String suggestion;
    /**
     * 转踏勘人员id
     */
    private String surveyBy;
    /**
     * 转踏勘时间
     */
    private Date surveyDate;
    /**
     * 接收人员id
     */
    private String inceptBy;
    /**
     * 接收人员姓名
     */
    private String inceptByName;
    /**
     * 接收时间
     */
    private Date inceptDate;
    /**
     * 审批完成时间
     */
    private Date approveDate;
    /**
     * 事中监管状态  0:待转  1:待接收  2:待完成  3:已完成
     */
    private Integer status;
    /**
     * 转踏勘超期日期
     */
    private Date overdueSurveyDate;
    /**
     * 接收超期日期
     */
    private Date overdueInceptDate;
    /**
     * 审批完成超期日期
     */
    private Date overdueApproveDate;





}
