package com.oceansoft.szga.smp.mapper;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;

/**
 * @author wzj
 * @create 2020/4/8
 * @email wzj@oceansoft.com.cn
 */
@Repository
public interface TjMapper {
    /**
     * 重要设施分类统计
     * @date  2020/4/08
     * @return
     */
    List<HashMap> zyssFlTj();

    /**
     * 重要设施分类统计 派出所
     * @date  2020/4/13
     * @param code
     * @return
     */
    List<HashMap> zyssFlTjPcs(@Param("code")String code);

    /**
     * 重要设施分类统计 责任区
     * @date  2020/4/13
     * @param code
     * @return
     */
    List<HashMap> zyssFlTjZrq(@Param("code")String code);

    /**
     * 履职分析 实时
     * @date  2020/4/09
     * @param tjrq
     * @return
     */
    List<HashMap> lzTjFxData(@Param("tjrq")String tjrq);

    /**
     * 履职分析 实时 派出所
     * @param code
     * @param tjrq
     * @date  2020/4/15
     * @return
     */
    List<HashMap> lzTjFxDataPcs(@Param("code") String code,@Param("tjrq")String tjrq);

    /**
     * 履职分析 实时 责任区
     * @param code
     * @param tjrq
     * @date  2020/4/15
     * @return
     */
    List<HashMap> lzTjFxDataZrq(@Param("code") String code,@Param("tjrq")String tjrq);
    /**
     * 重要设施统计
     * @date  2020/4/09
     * @param tjrq
     * @return
     */
    List<HashMap> zyssYhTj(@Param("tjrq")String tjrq);
    /**
     * 重要设施实时统计  之派出所
     * @date  2020/4/015
     * @param code
     * @param tjrq
     * @return
     */
    List<HashMap> zYssYhTjPcs(@Param("code") String code,@Param("tjrq")String tjrq);
    /**
     * 重要设施实时统计  之责任区
     * @date  2020/4/015
     * @param code
     * @param tjrq
     * @return
     */
    List<HashMap> zYssYhTjZrq(@Param("code") String code,@Param("tjrq")String tjrq);
    /**
     * 监管实施数据
     * @date  2020/4/13
     * @param tjrq
     * @return
     */
    List<HashMap> jgSsTj(@Param("tjrq") String tjrq);

    /**
     * 监管实施数据 派出所
     * @param code
     * @param tjrq
     * @date  2020/4/15
     * @return
     */
    List<HashMap> jgSsTjPcs(@Param("code")String code,@Param("tjrq")String tjrq);

    /**
     * 监管实施数据 责任区
     * @param code
     * @param tjrq
     * @date  2020/4/15
     * @return
     */
    List<HashMap> jgSsTjZrq(@Param("code") String code,@Param("tjrq")String tjrq);

    /**
     * 重点单位隐患统计 实时数据
     * @param tjrq
     * @date  2020/4/14
     * @return
     */
    List<HashMap> zdDwYhTjSs(@Param("tjrq")String tjrq);
    /**
     * 重点单位隐患统计 实时数据 派出所
     * @param code
     * @param tjrq
     * @date  2020/4/14
     * @return
     */
    List<HashMap> zdDwYhTjSsPcs(@Param("code") String code,@Param("tjrq")String tjrq);
    /**
     * 重点单位隐患统计 实时数据 责任区
     * @param code
     * @param tjrq
     * @date  2020/4/14
     * @return
     */
    List<HashMap> zdDwYhTjSsZrq(@Param("code") String code,@Param("tjrq")String tjrq);
    /**
     * 重要设施新增统计 实时数据
     * @param time
     * @param tjrq
     * @date  2020/4/14
     * @return
     */
    List<HashMap> zySsXzTjSs(@Param("time") String time,@Param("tjrq")String tjrq);
    /**
     * 重要设施新增统计 实时数据  派出所
     * @param code
     * @param time
     * @param tjrq
     * @date  2020/4/14
     * @return
     */
    List<HashMap> zySsXzTjSsPcs(@Param("time") String time,@Param("code") String code,@Param("tjrq")String tjrq);
    /**
     * 重要设施新增统计 实时数据  责任区
     * @param code
     * @param time
     * @date  2020/4/14
     * @return
     */
    List<HashMap> zySsXzTjSsZrq(@Param("time") String time,@Param("code") String code,@Param("tjrq")String tjrq);
    /**
     * 企事业单位新增统计  实施
     * @param tjrq
     * @date  2020/4/15
     * @return
     */
    List<HashMap> qsyAddSs(@Param("tjrq")String tjrq);
    /**
     * 企事业单位新增统计 实时 派出所
     * @param code
     * @param tjrq
     * @date  2020/4/15
     * @return
     */
    List<HashMap> qsyAddSsPcs(@Param("code")String code,@Param("tjrq")String tjrq);
    /**
     * 企事业单位新增统计  实施 责任区
     * @param code
     * @param tjrq
     * @date  2020/4/15
     * @return
     */
    List<HashMap> qsyAddSsZrq(@Param("code")String code,@Param("tjrq")String tjrq);

    /**
     * 重要设施新增统计 月度数据
     * @param year
     * @date  2020/4/17
     * @return
     */
    List<HashMap> zySsXzTjYd(@Param("year") String year);
    /**
     * 重要设施新增统计 月度数据 派出所
     * @param year
     * @param code
     * @date  2020/4/17
     * @return
     */
    List<HashMap> zySsXzTjYdPcs(@Param("year") String year,@Param("code")String code);
    /**
     * 重要设施新增统计 月度数据 责任区
     * @param year
     * @param code
     * @date  2020/4/17
     * @return
     */
    List<HashMap> zySsXzTjYdZrq(@Param("year") String year,@Param("code")String code);
}
