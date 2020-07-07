package com.oceansoft.szga.smp.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 问题复函实体
 *
 * @author JackChan
 * @Date 2020/7/2 0002 上午 11:40
 */
public class QuestionResponseEntity implements Serializable {

    private static final long serialVersionUID = -5601865421789705528L;

    // 单据编号
    private String guid;

    // 问题guid
    private String questionGuid;

    // 复函文号
    private String responseNo;

    // 复函时间
    private Date responseDate;

    // 附件ids
    private String fileIds;

    // 创建日期
    private Date createDate;

    // 创建人id
    private String createUserId;

    // 更新日期
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

    public String getResponseNo() {
        return responseNo;
    }

    public void setResponseNo(String responseNo) {
        this.responseNo = responseNo;
    }

    public Date getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(Date responseDate) {
        this.responseDate = responseDate;
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
