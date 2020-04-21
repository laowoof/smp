package com.oceansoft.szga.smp.entity;

import java.util.List;

/**
 * 道路交通安全画像 源头管理实体类
 * @author wujg
 * Created by asus on 2020/4/21.
 */
public class SourceNum {

    //查询类型
    private String type;
    //年月旧
    private String nyold;
    //年月新
    private String nynew;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNyold() {
        return nyold;
    }

    public void setNyold(String nyold) {
        this.nyold = nyold;
    }

    public String getNynew() {
        return nynew;
    }

    public void setNynew(String nynew) {
        this.nynew = nynew;
    }
}
