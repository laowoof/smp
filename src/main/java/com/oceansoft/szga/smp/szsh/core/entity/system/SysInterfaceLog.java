package com.oceansoft.szga.smp.szsh.core.entity.system;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wx
 * @version 2018/9/27/17:20
 */
@Data
@TableName("rpt.sys_interface_log")
public class SysInterfaceLog implements Serializable {
    private static final long serialVersionUID = 7962938569916186221L;

    @TableId
    private String id;

    private String source;

    private String succ;

    private String msg;

    private String sourceid;

    private String parameter;

    private Date createtime;


}
