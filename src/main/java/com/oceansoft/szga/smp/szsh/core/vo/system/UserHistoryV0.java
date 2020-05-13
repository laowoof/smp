package com.oceansoft.szga.smp.szsh.core.vo.system;

import lombok.Data;

import java.util.Date;

/**
 * @author wx
 * @version 2018/10/18
 * 监管任务派发记录  人员或专家或企业
 */
@Data
public class UserHistoryV0 {

//    //派发编号
//    private String superNo;
//
//    //监管事项
//    private String caseName;
//
//    //监管企业
//    private String enterName;
//
//    //派发时间
//    private Date dispatchDate;

    //抽取编号
    private String extractNo;

    //抽取时间
    private Date extractDate;


}
