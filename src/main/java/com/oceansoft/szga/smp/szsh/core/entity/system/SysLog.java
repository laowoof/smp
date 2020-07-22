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
@TableName("rpt.sys_log")
public class SysLog implements Serializable {

    @TableId
    private String id;

    private String username;

    private String userid;

    private String ip;

    private Integer ajax;

    private String uri;

    private String params;

    private String httpMethod;

    private String classMethod;

    private String actionName;

    private Date createDate;


}
