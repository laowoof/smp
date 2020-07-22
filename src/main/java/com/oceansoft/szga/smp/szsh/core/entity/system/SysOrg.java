package com.oceansoft.szga.smp.szsh.core.entity.system;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("rpt.sys_org")
public class SysOrg implements Serializable {

    private static final long serialVersionUID = 6716005315530746097L;

    @TableId
    private String guid;

    private String orgname;

    private String parentguid;

    private Integer orderindex;
}
