package com.oceansoft.szga.smp.mapper;


import com.oceansoft.szga.smp.entity.YTRW;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * 统计分析/道路安全统计分析
 * @author pc
 * @create 2020/4/24
 * @email wzj@oceansoft.com.cn
 */
@Repository
public interface DLAQTJMapper {

    /**
     *  源头任务统计
     * @param hashMap
     * @return
     */

    List<YTRW> YTRWTJ(HashMap hashMap);


    /**
     *  源头任务统计  子项
     * @param hashMap
     * @return
     */

    List<YTRW> YTRWTJZX(HashMap hashMap);

    /**
     *  隐患完成情况统计
     * @param hashMap
     * @return
     */

    List<HashMap> YHWCQKTJ(HashMap hashMap);


    /**
     *  隐患完成情况统计  子项
     * @param hashMap
     * @return
     */

    List<HashMap> YHWCQKTJZX(HashMap hashMap);

    /**
     *  隐患类型统计
     * @param hashMap
     * @return
     */

    List<HashMap> YHLXTJ(HashMap hashMap);

    /**
     *  八进宣传统计
     * @param hashMap
     * @return
     */

    List<HashMap> BJXCTJ(HashMap hashMap);

    /**
     *  八进宣传统计 子项
     * @param hashMap
     * @return
     */

    List<HashMap> BJXCTJZX(HashMap hashMap);

    /**
     * 单位重点违法统计
     * @param hashMap
     * @return
     */

    List<HashMap> DWZDWFTJ(HashMap hashMap);

    /**
     * 单位重点违法统计 子项
     * @param hashMap
     * @return
     */

    List<HashMap> DWZDWFTJZX(HashMap hashMap);


    /**
     * 源头底数统计
     * @param hashMap
     * @return
     */

    List<HashMap> YTDSTJ(HashMap hashMap);



}
