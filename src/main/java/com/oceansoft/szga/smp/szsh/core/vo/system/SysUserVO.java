package com.oceansoft.szga.smp.szsh.core.vo.system;

import com.oceansoft.szga.smp.szsh.core.entity.system.SysResource;
import com.oceansoft.szga.smp.szsh.core.entity.system.SysRole;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author wx
 * @version 2018/9/18
 */
@Data
public class SysUserVO {

    private String id;
    private String username;
    private String name;
    private Date age;
    private Integer ageInt;

    private Integer status;
    private List<SysRole> roles;
    private Date createDate;
    private List<SysResource> resources;

}
