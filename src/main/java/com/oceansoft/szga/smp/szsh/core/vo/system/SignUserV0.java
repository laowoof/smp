package com.oceansoft.szga.smp.szsh.core.vo.system;

import lombok.Data;

import java.util.List;

/**
 * @author wx
 * 用户登陆返回信息
 * @version 2018/9/18
 */
@Data
public class SignUserV0 {

    /**
     * 用户Token
     */
    private String token;

    /**
     * 用户资源名称
     */
    private List<String> permission;

}
