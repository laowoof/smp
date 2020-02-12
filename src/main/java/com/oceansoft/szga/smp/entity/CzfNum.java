package com.oceansoft.szga.smp.entity;

public class CzfNum {
    /**
     * 统计日期
     */
    private String tjrq;

    /**
     * 行政区划
     */
    private String xzqh;

    /**
     * 行政区划名称
     */
    private String xzqhmc;

    /**
     * 数量
     */
    private int sl;

    public String getTjrq() {
        return tjrq;
    }

    public void setTjrq(String tjrq) {
        this.tjrq = tjrq;
    }

    public String getXzqh() {
        return xzqh;
    }

    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
    }

    public String getXzqhmc() {
        return xzqhmc;
    }

    public void setXzqhmc(String xzqhmc) {
        this.xzqhmc = xzqhmc;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }
}
