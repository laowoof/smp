package com.oceansoft.szga.smp.szsh.common.annotation;

import java.lang.annotation.*;

/**
 * @author wx
 * @version 2018/9/27
 * 系统日志
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLogs {

    String value();

}
