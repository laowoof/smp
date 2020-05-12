package com.oceansoft.szga.smp.szsh.core.vo.system;

import lombok.Data;

import java.util.Date;

/**
 * @author wx
 * @version 2018/11/14
 * 满意度填报总表
 */
@Data
public class EvaluateFillV0 {
    private String prjguid;

    //部门名称
    private String casedetpname;

    //办事效率
    private Integer evaluationgrade1;

    private Integer evaluationgrade2;

    private Integer evaluationgrade3;

    //办事效率满意度占比
    private Float gradepercent;

    //服务态度
    private Integer evaluationserve1;

    private Integer evaluationserve2;

    private Integer evaluationserve3;

    //办服务态度满意度占比
    private Float servepercent;


    //办事环境
    private Integer evaluationcontent1;

    private Integer evaluationcontent2;

    private Integer evaluationcontent3;

    //办事环境满意度占比
    private Float contentpercent;


    //总满意度占比
    private Float percent;


    //填报来源
    private String evaluationsource;

    //评价时间（月）
    private Date evaluatedate;
}
