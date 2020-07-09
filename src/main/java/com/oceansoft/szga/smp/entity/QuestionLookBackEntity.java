package com.oceansoft.szga.smp.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 问题回头看实体
 *
 * @author JackChan
 * @Date 2020/7/2 0002 上午 11:19
 */
public class QuestionLookBackEntity implements Serializable {

    private static final long serialVersionUID = 4694902336417060766L;

    // 单据编号
    private String guid;

    // 问题guid
    private String questionGuid;

    // 回头看参与人员
    private String lookBackUser;

    // 回头看时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lookBackDate;

    // 回头看结果
    private String lookBackResult;

    // 附件ids
    private String fileIds;

    // 创建日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    // 创建人id
    private String createUserId;

    // 更新日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

    // 更新人id
    private String updateUserId;

    // 是否无效1是0否
    private Integer state;

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

    public String getLookBackUser() {
        return lookBackUser;
    }

    public void setLookBackUser(String lookBackUser) {
        this.lookBackUser = lookBackUser;
    }

    public Date getLookBackDate() {
        return lookBackDate;
    }

    public void setLookBackDate(Date lookBackDate) {
        this.lookBackDate = lookBackDate;
    }

    public String getLookBackResult() {
        return lookBackResult;
    }

    public void setLookBackResult(String lookBackResult) {
        this.lookBackResult = lookBackResult;
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

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
