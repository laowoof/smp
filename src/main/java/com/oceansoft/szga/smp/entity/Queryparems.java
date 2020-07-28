package com.oceansoft.szga.smp.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class  Queryparems  implements Serializable {

    // 寄递物流总数
    private String sumjdwl;

    // 从业人员总数
    private String sumctry;

    // 实名收寄数
    private String sumsysf;

    // 进出港数
    private String sumjcgs;

    // 安全责任书签定数
    private String sumaqzr;

    // 常规检查数
    private String sumcgjc;

    // 主动检查数
    private String sumzdjc;
    // 专项检查数
    private String sumzxjc;
    // 隐患发现数
    private String sumyhfx;

    // 隐患处理数
    private String sumyhcl;

    private String xzqhs;

    private String mc;

    private String type;

    private String sjgs;

    private String jclxdm;

    private String jcztdm;

    private String data;

    private String fjmc;

}
