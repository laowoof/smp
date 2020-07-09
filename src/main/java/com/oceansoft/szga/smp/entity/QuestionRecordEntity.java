package com.oceansoft.szga.smp.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 问题登记实体
 *
 * @author JackChan
 * @Date 2020/7/2 0002 上午 9:50
 */
public class QuestionRecordEntity implements Serializable {

    private static final long serialVersionUID = -2781174343206298058L;

    // 单据编号
    private String guid;

    // 问题来源
    private String source;

    // 问题发生日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date happenDate;

    // 行政区划
    private String area;

    // 责任单位
    private String dutyUnit;

    // 完成时限
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date finishDate;

    // 问题地址
    private String address;

    // 问题表现
    private String performance;

    // 附件id
    private String fileIds;

    // 创建日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    // 创建人姓名
    private String createUserName;

    // 创建人id
    private String createUserId;

    // 创建人部门名字
    private String createDeptName;

    // 状态-1删除0待派发1待受理2处置中3待确认4已退回5已完结
    private Integer state;

    // 待处理部门编码
    private String executeDeptCode;

    // 创建人部门编码
    private String createDeptCode;

    public String getSource() {
        return source;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getHappenDate() {
        return happenDate;
    }

    public void setHappenDate(Date happenDate) {
        this.happenDate = happenDate;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDutyUnit() {
        return dutyUnit;
    }

    public void setDutyUnit(String dutyUnit) {
        this.dutyUnit = dutyUnit;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public String getFileIds() {
        return fileIds;
    }

    public void setFileIds(String fileIds) {
        this.fileIds = fileIds;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateDeptName() {
        return createDeptName;
    }

    public void setCreateDeptName(String createDeptName) {
        this.createDeptName = createDeptName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getExecuteDeptCode() {
        return executeDeptCode;
    }

    public void setExecuteDeptCode(String executeDeptCode) {
        this.executeDeptCode = executeDeptCode;
    }

    public String getCreateDeptCode() {
        return createDeptCode;
    }

    public void setCreateDeptCode(String createDeptCode) {
        this.createDeptCode = createDeptCode;
    }
}
