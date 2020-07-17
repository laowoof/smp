package com.oceansoft.szga.smp.entity.bean;

import java.util.Date;

/**
 * 查询条件bean
 *
 * @author JackChan
 * @Date 2020/7/5 0005 上午 10:07
 */
public class QuestionQueryBean {

    // 页码
    private Integer pageNum;

    // 条数
    private Integer pageSize;

    // 问题状态
    private Integer[] state;

    // 关键字
    private String keyWord;

    // 开始时间

    private Date startTime;

    // 结束时间

    private Date endTime;

    // 反应部门
    private String reactionDept;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer[] getState() {
        return state;
    }

    public void setState(Integer[] state) {
        this.state = state;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getReactionDept() {
        return reactionDept;
    }

    public void setReactionDept(String reactionDept) {
        this.reactionDept = reactionDept;
    }
}
