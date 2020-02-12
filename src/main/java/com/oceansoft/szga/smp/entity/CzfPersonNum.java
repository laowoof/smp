package com.oceansoft.szga.smp.entity;

/**
 *  出租房人数实体类
 * @author wzj
 * @date 2020/1/19
 */
public class CzfPersonNum {
    /**
     * 统计日期
     */
    private String tjrq;

    /**
     * 行政区划
     */
    private String czwdzxzqh;

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

    public String getCzwdzxzqh() {
        return czwdzxzqh;
    }

    public void setCzwdzxzqh(String czwdzxzqh) {
        this.czwdzxzqh = czwdzxzqh;
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
