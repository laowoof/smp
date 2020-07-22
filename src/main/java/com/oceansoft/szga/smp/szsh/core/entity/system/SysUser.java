package com.oceansoft.szga.smp.szsh.core.entity.system;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("rpt.sys_user")
public class SysUser implements Serializable  {

    
    @TableId
    private String id;
    private String username;
//    private Integer age;
    private Date age;
    private String password;
    private Integer status;

    private String name;
    private String departmentName;
    private Integer sex;
    private String departmentId;
    private String description;

    //职务
    private String category;
    //警号
    private String userNo;
    //联系方式
    private String contact;
    //上一次监管日期
    private Date lastDate;
    //警察证到期日期
    private Date expireDate;
    //培训情况
    private String training;

    //人员归属  sj:市局    xfj:县分局
    private String source;

    //所属部门id
    private String orgId;

    @TableField(exist = false)
    private List<SysRole> roles;
    private Date createDate;

    @TableField(exist = false)
    private List<CmCase> cases;

    private static final long serialVersionUID = 1L;

}
