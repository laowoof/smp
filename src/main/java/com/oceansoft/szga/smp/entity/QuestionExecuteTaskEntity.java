package com.oceansoft.szga.smp.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 问题处置任务实体
 *
 * @author JackChan
 * @Date 2020/7/2 0002 上午 10:42
 */
public class QuestionExecuteTaskEntity implements Serializable {

    private static final long serialVersionUID = 3811372637018547187L;

    // 单据编号
    private String guid;

    // 问题登记信息id
    private String questionGuid;

    // 创建日期
    private Date createDate;

    // 创建人id
    private String createUserId;

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

    // 是否已处理1是0否
    private Integer state;

    // 节点名称 派发/接收人签收/问题处置/结果确认
    private String executeNodeName;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getQuestionGuid() {
        return questionGuid;
    }

    public void setQuestionGuid(String questionGuid) {
        this.questionGuid = questionGuid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getExecuteNodeName() {
        return executeNodeName;
    }

    public void setExecuteNodeName(String executeNodeName) {
        this.executeNodeName = executeNodeName;
    }
}
