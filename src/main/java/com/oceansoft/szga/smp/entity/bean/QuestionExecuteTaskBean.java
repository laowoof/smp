package com.oceansoft.szga.smp.entity.bean;

import java.util.Date;

/**
 * 执行任务bean
 *
 * @author JackChan
 * @Date 2020/7/3 0003 下午 2:12
 */
public class QuestionExecuteTaskBean {

    // 操作日期
    private Date executeDate;

    // 操作人id
    private String executeUserId;

    // 操作人姓名
    private String executeUserName;

    // 意见
    private String opinion;

    // 完成时限
    private Date finishDate;

    // 操作部门名称
    private String executeDeptName;

    // 操作部门编码
    private String executeDeptCode;

    // 操作名称，派发，签收等
    private String executeName;

    // 附件ids
    private String fileIds;

    // 节点名称 派发/接收人签收/问题处置/结果确认
    private String executeNodeName;

    public Date getExecuteDate() {
        return executeDate;
    }

    public void setExecuteDate(Date executeDate) {
        this.executeDate = executeDate;
    }

    public String getExecuteUserId() {
        return executeUserId;
    }

    public void setExecuteUserId(String executeUserId) {
        this.executeUserId = executeUserId;
    }

    public String getExecuteUserName() {
        return executeUserName;
    }

    public void setExecuteUserName(String executeUserName) {
        this.executeUserName = executeUserName;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getExecuteDeptName() {
        return executeDeptName;
    }

    public void setExecuteDeptName(String executeDeptName) {
        this.executeDeptName = executeDeptName;
    }

    public String getExecuteDeptCode() {
        return executeDeptCode;
    }

    public void setExecuteDeptCode(String executeDeptCode) {
        this.executeDeptCode = executeDeptCode;
    }

    public String getExecuteName() {
        return executeName;
    }

    public void setExecuteName(String executeName) {
        this.executeName = executeName;
    }

    public String getFileIds() {
        return fileIds;
    }

    public void setFileIds(String fileIds) {
        this.fileIds = fileIds;
    }

    public String getExecuteNodeName() {
        return executeNodeName;
    }

    public void setExecuteNodeName(String executeNodeName) {
        this.executeNodeName = executeNodeName;
    }
}
