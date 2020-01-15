package com.oceansoft.szga.smp.config.domain;
import java.lang.annotation.*;

/**
 * 工具类
 * 2018-8-16 刘柱 增加方法注释，类注释，行内注释
 * @author ganlu
 * @create 2017-02-10 09:03
 * @email ganlu@gmail.com
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiQuery {
    String value() default "";
}
