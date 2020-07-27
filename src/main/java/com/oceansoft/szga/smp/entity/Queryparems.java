package com.oceansoft.szga.smp.entity;

import java.io.Serializable;

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

    private String[] xzqhs;

    private String[] mc;

    private String type;

    private String jclxdm;

    private String jcztdm;

    public String getJclxdm() {
        return jclxdm;
    }

    public void setJclxdm(String jclxdm) {
        this.jclxdm = jclxdm;
    }

    public String getJcztdm() {
        return jcztdm;
    }

    public void setJcztdm(String jcztdm) {
        this.jcztdm = jcztdm;
    }

    public String[] getXzqhs() {
        return xzqhs;
    }

    public void setXzqhs(String[] xzqhs) {
        this.xzqhs = xzqhs;
    }


    public String[] getMc() {
        return mc;
    }

    public void setMc(String[] mc) {
        this.mc = mc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSumjdwl() {
        return sumjdwl;
    }

    public void setSumjdwl(String sumjdwl) {
        this.sumjdwl = sumjdwl;
    }

    public String getSumctry() {
        return sumctry;
    }

    public void setSumctry(String sumctry) {
        this.sumctry = sumctry;
    }

    public String getSumsysf() {
        return sumsysf;
    }

    public void setSumsysf(String sumsysf) {
        this.sumsysf = sumsysf;
    }

    public String getSumjcgs() {
        return sumjcgs;
    }

    public void setSumjcgs(String sumjcgs) {
        this.sumjcgs = sumjcgs;
    }

    public String getSumaqzr() {
        return sumaqzr;
    }

    public void setSumaqzr(String sumaqzr) {
        this.sumaqzr = sumaqzr;
    }

    public String getSumcgjc() {
        return sumcgjc;
    }

    public void setSumcgjc(String sumcgjc) {
        this.sumcgjc = sumcgjc;
    }

    public String getSumzdjc() {
        return sumzdjc;
    }

    public void setSumzdjc(String sumzdjc) {
        this.sumzdjc = sumzdjc;
    }

    public String getSumzxjc() {
        return sumzxjc;
    }

    public void setSumzxjc(String sumzxjc) {
        this.sumzxjc = sumzxjc;
    }

    public String getSumyhfx() {
        return sumyhfx;
    }

    public void setSumyhfx(String sumyhfx) {
        this.sumyhfx = sumyhfx;
    }

    public String getSumyhcl() {
        return sumyhcl;
    }

    public void setSumyhcl(String sumyhcl) {
        this.sumyhcl = sumyhcl;
    }
}
