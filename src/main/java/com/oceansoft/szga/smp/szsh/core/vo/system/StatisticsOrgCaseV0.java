package com.oceansoft.szga.smp.szsh.core.vo.system;

import lombok.Data;

/**
 * @author wx
 * @version 2018/10/18
 * 部门事项统计
 */
@Data
public class StatisticsOrgCaseV0 {
    //事项名称
    private String caseName;

    //监管数量
    private Integer extractNo;

    //抽取对象占比
    private Float extractPercent;
}
