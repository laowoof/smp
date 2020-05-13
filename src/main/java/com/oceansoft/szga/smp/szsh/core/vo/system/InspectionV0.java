package com.oceansoft.szga.smp.szsh.core.vo.system;

import lombok.Data;

/**
 * @author wx
 * @version 2019/6/18
 * 日常监管统计
 */
@Data
public class InspectionV0 {

    //事项id
    private String caseId;

    //事项名称
    private String caseName;

    //监管数量
    private Integer enterAmount;

    //抽取对象占比
//    private Float enterPercent;

    //合格数
    private Integer gradeNo;

    //合格百分比
    private Float gradePercent;

    //未完成数
//    private Integer imperfectNo;

    //未完成百分比
//    private Float imperfectPercent;

}
