package com.oceansoft.szga.smp.entity.bean;

import com.oceansoft.szga.smp.entity.QuestionRecordEntity;

/**
 * 接口参数集合
 *
 * @author JackChan
 * @Date 2020/7/9 0009 下午 2:39
 */
public class QuestionAllBean {

    private QuestionRecordEntity questionRecordEntity;

    private QuestionExecuteTaskBean questionExecuteTaskBean;

    public QuestionRecordEntity getQuestionRecordEntity() {
        return questionRecordEntity;
    }

    public void setQuestionRecordEntity(QuestionRecordEntity questionRecordEntity) {
        this.questionRecordEntity = questionRecordEntity;
    }

    public QuestionExecuteTaskBean getQuestionExecuteTaskBean() {
        return questionExecuteTaskBean;
    }

    public void setQuestionExecuteTaskBean(QuestionExecuteTaskBean questionExecuteTaskBean) {
        this.questionExecuteTaskBean = questionExecuteTaskBean;
    }
}
