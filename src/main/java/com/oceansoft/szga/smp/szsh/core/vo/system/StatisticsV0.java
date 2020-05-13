package com.oceansoft.szga.smp.szsh.core.vo.system;

import lombok.Data;

/**
 * @author wx
 * @version 2018/10/18
 * 总体统计
 */
@Data
public class StatisticsV0 {

    //事项名称
    private String caseName;

    //监管数量
    private Integer enterAmount;

    //抽取对象占比
    private Float enterPercent;

    //合格数
    private Integer gradeNo;

    //合格百分比
    private Float gradePercent;

    //未完成数
    private Integer imperfectNo;

    //未完成百分比
    private Float imperfectPercent;



}
