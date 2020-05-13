package com.oceansoft.szga.smp.szsh.core.vo.system;

import lombok.Data;

/**
 * @author wx
 * @version 2018/10/18
 * 满意度统计
 */
@Data
public class EvaluateStatisticsV0 {

    //事项名称
    private String casename;

    //部门名称
    private String casedetpname;

    //评价数量
    private Integer evaluation;

    //非常满意数量
    private Integer pleasedno;

    //非常满意数量占比
    private Float pleasedpercent;

    //满意数量
    private Integer satisfiedno;

    //满意数量占比
    private Float satisfiedpercent;

    //不满意数量
    private Integer criticalno;

    //不满意数量占比
    private Float criticalpercent;



}
