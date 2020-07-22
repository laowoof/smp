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
 * @version 2018/4/16/11:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("rpt.sys_user_role")
public class SysUserRole implements Serializable {

    @TableId
    private String id;

    private String userid;

    private String rid;

}
