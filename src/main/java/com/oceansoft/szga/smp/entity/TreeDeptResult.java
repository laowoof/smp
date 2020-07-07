package com.oceansoft.szga.smp.entity;

import java.util.List;

/**
 * 树形结构部门结果实体
 *
 * @author JackChan
 * @Date 2020/7/1 0001 下午 3:36
 */
public class TreeDeptResult {

    // 部门id
    private String id;

    // 部门名称
    private String orgName;

    // 父id
    private String parentId;

    private List<TreeDeptResult> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<TreeDeptResult> getChildren() {
        return children;
    }

    public void setChildren(List<TreeDeptResult> children) {
        this.children = children;
    }
}
