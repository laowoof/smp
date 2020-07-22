package com.oceansoft.szga.smp.szsh.core.entity.system;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Licoy
 * @version 2018/4/16/8:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("rpt.sys_role_resource")
public class SysRoleResource implements Serializable {

    @TableId
    private String id;

    private String rid;

    private String pid;

    private static final long serialVersionUID = 1L;
}
