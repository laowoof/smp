package com.oceansoft.szga.smp.szsh.core.entity.system;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SysRole implements Serializable  {

    @TableId
    private String id;
    
    private String name;

    //管理警种名称
    private String className;

    //管理部门id
    private String orgId;

    //管理部门名称
    @TableField(exist = false)
    private String orgName;

    @TableField(exist = false)
    private List<SysResource> resources;

    private static final long serialVersionUID = 1L;

}
