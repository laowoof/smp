package com.oceansoft.szga.smp.service;

import com.oceansoft.szga.smp.config.domain.ApiResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface DLAQTJService {

    /**
     * 源头底数统计
     * @author pc
     * @return 数据
     */
    ApiResult YTDSTJ(String param,String date);
    /**
     * 源头任务统计
     * @author pc
     * @return 数据
     */
    ApiResult YTRWTJ(String param,String choiceDate);

    /**
     * 源头任务统计  子项
     * @author pc
     * @return 数据
     */
    ApiResult YTRWTJZX(String param,String choiceDate,String name);

    /**
     * 隐患完成情况统计
     * @author pc
     * @return 数据
     */
    ApiResult YHWCQKTJ(String param,String choiceDate,String status);


    /**
     * 隐患完成情况统计 子项
     * @author pc
     * @return 数据
     */
    ApiResult YHWCQKTJZX(String param,String choiceDate,String status,String name);


    /**
     * 隐患类型统计
     * @author pc
     * @return 数据
     */
    ApiResult YHLXTJ(String param,String choiceDate,String status);

    /**
     * 八进宣传统计
     * @author pc
     * @return 数据
     */
    ApiResult BJXCTJ(String param,String start,String end);

    /**
     * 八进宣传统计 子项
     * @author pc
     * @return 数据
     */
    ApiResult BJXCTJZX(String param,String start,String end,String name);


    /**
     * 单位重点违法统计
     * @author pc
     * @return 数据
     */
    ApiResult DWZDWFTJ(String param,String start,String end);

    /**
     * 单位重点违法统计 子项
     * @author pc
     * @return 数据
     */
    ApiResult DWZDWFTJZX(String param,String start,String end,String name);


}


