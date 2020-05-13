package com.oceansoft.szga.smp.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：pc
 * @date ：Created in 2020/4/26 13:56
 * @description：源头任务
 * @modified By：
 * @version: $
 */
public class YTRW {
    // 大队(中队)名称
    private String company;

    //告知事项 任务数量
    private String task1;
    //告知事项 完成数量
    private String finished1;
    //现场检查  任务数量
    private String task2;
    //现场检查  完成数
    private String finished2;
    //驾驶人安全教育 任务数量
    private String task3;
    //驾驶人安全教育 完成数量
    private String finished3;
    //督查整改 任务数量
    private String task4;
    //督查整改 完成数量
    private String finished4;
    // 是否包含 子项
    private boolean hasChildren =true;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTask1() {
        return task1;
    }

    public void setTask1(String task1) {
        this.task1 = task1;
    }

    public String getFinished1() {
        return finished1;
    }

    public void setFinished1(String finished1) {
        this.finished1 = finished1;
    }

    public String getTask2() {
        return task2;
    }

    public void setTask2(String task2) {
        this.task2 = task2;
    }

    public String getFinished2() {
        return finished2;
    }

    public void setFinished2(String finished2) {
        this.finished2 = finished2;
    }

    public String getTask3() {
        return task3;
    }

    public void setTask3(String task3) {
        this.task3 = task3;
    }

    public String getFinished3() {
        return finished3;
    }

    public void setFinished3(String finished3) {
        this.finished3 = finished3;
    }

    public String getTask4() {
        return task4;
    }

    public void setTask4(String task4) {
        this.task4 = task4;
    }

    public String getFinished4() {
        return finished4;
    }

    public void setFinished4(String finished4) {
        this.finished4 = finished4;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }
}
