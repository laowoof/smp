package com.oceansoft.szga.smp.szsh.core.vo.system;

import lombok.Data;

/**
 * @author wx
 * @version 2019/6/18
 * 日常监管所属事项统计列表
 */
@Data
public class InspectionCaseV0 {

    //单位名称
    private String unitName;

    //部门名称
    private String orgName;

    //检查人员
    private String checkPersonName;

    //警号
    private String userNo;

    //检查结果  0：不合格   1：合格
    private Integer checkResult;

}
