package com.oceansoft.szga.smp.service;
import com.alibaba.fastjson.JSONObject;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import org.apache.ibatis.annotations.Mapper;
/**
 *  统计
 * @author wzj
 * @date 2020/4/08
 */

@Mapper
public interface TjService {

    /**
     *  重要设施分类统计
     * @return
     */
    ApiResult zyssFlTj();

    /**
     *  重要设施分类统计  派出所
     * @param code
     * @return
     */
    ApiResult zyssFlTjPcs(String code);

    /**
     *  重要设施分类统计  责任区
     * @param code
     * @return
     */
    ApiResult zyssFlTjZrq(String code);

    /**
     *  履职分析 实时
     * @param tjrq
     * @return
     */
    ApiResult lzTjFxData(String tjrq);

    /**
     *  履职分析 实时  派出所
     * @param tjrq
     * @param code
     * @return
     */
    ApiResult lzTjFxDataPcs(String code,String tjrq);

    /**
     *  履职分析 实时  责任区
     * @param code
     * @param tjrq
     * @return
     */
    ApiResult lzTjFxDataZrq(String code,String tjrq);

    /**
     *  重要设施 统计
     * @param tjrq
     * @return
     */
    ApiResult zyssYhTj(String tjrq);

    /**
     *  重要设施 实时统计值派出所
     * @param code
     * @param tjrq
     * @return
     */
    ApiResult zYssYhTjPcs(String code,String tjrq);
    /**
     *  重要设施 实时统计之责任区
     * @param code
     * @param tjrq
     * @return
     */
    ApiResult zYssYhTjZrq(String code,String tjrq);

    /**
     *  监管实施数据  统计
     * @param tjrq
     * @return
     */
    ApiResult jgSsTj(String tjrq);

    /**
     *  监管实施数据  统计  派出所
     * @param code
     * @param tjrq
     * @return
     */
    ApiResult jgSsTjPcs(String code,String tjrq);

    /**
     *  监管实施数据  统计  责任区
     * @param code
     * @param tjrq
     * @return
     */
    ApiResult jgSsTjZrq(String code,String tjrq);

    /**
     *  重点单位实施数据  统计
     * @param tjrq
     * @return
     */
    ApiResult zdDwYhTjSs(String tjrq);

    /**
     *  重点单位实施数据 派出所  统计
     * @param code
     * @param tjrq
     * @return
     */
    ApiResult zdDwYhTjSsPcs(String code,String tjrq);

    /**
     *  重点单位实施数据 责任区  统计
     * @param code
     * @param tjrq
     * @return
     */
    ApiResult zdDwYhTjSsZrq(String code,String tjrq);

    /**
     *  重点单位实施数据 责任区  统计
     * @param tjrq
     * @return
     */
    ApiResult zySsXzTjSs(String tjrq);

    /**
     *  重要设施新增统计 实时数据 派出所
     * @param tjrq
     * @param code
     * @return
     */
    ApiResult zySsXzTjSsPcs(String code,String tjrq);

    /**
     *  重要设施新增统计 实时数据 责任区
     * @param tjrq
     * @param code
     * @return
     */
    ApiResult zySsXzTjSsZrq(String code,String tjrq);

    /**
     *  企事业单位新增统计  实施
     * @param tjrq
     * @return
     */
    ApiResult qsyAddSs(String tjrq);
    /**
     *  企事业单位新增统计  实时派出所
     * @param code
     * @param tjrq
     * @return
     */
    ApiResult qsyAddSsPcs(String code,String tjrq);
    /**
     *  企事业单位新增统计  实时责任区
     * @param code
     * @param tjrq
     * @return
     */
    ApiResult qsyAddSsZrq(String code,String tjrq);
    /**
     *  重要设施新增统计 月度数据
     * @param year
     * @return
     */
    ApiResult zySsXzTjYd(String year);
    /**
     *  重要设施新增统计 月度数据 派出所
     * @param year
     * @param code
     * @return
     */
    ApiResult zySsXzTjYdPcs(String year,String code);
    /**
     *  重要设施新增统计 月度数据 责任区
     * @param year
     * @param code
     * @return
     */
    ApiResult zySsXzTjYdZrq(String year,String code);
}
