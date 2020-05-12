package com.oceansoft.szga.smp.szsh.core.vo.system;

import lombok.Data;

/**
 * @author wx
 * @version 2018/10/18
 * 部门统计
 */
@Data
public class StatisticsOrgV0 {
    //部门ID
    private String orgId;

    //部门名称
    private String orgName;

    //事项名称
//    private String caseName;

    //监管数量
    private Integer extractNo;

    //抽取对象占比
    private Float extractPercent;


}
