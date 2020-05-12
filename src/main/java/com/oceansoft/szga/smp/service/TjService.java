package com.oceansoft.szga.smp.service;
import com.alibaba.fastjson.JSONObject;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import org.apache.ibatis.annotations.Mapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

//    /**
//     *  重点单位实施数据  统计
//     * @param tjrq
//     * @return
//     */
//    ApiResult zdDwYhTjSs(String tjrq);
//
//    /**
//     *  重点单位实施数据 派出所  统计
//     * @param code
//     * @param tjrq
//     * @return
//     */
//    ApiResult zdDwYhTjSsPcs(String code,String tjrq);
//
//    /**
//     *  重点单位实施数据 责任区  统计
//     * @param code
//     * @param tjrq
//     * @return
//     */
//    ApiResult zdDwYhTjSsZrq(String code,String tjrq);

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
    /**
     * 重要设施隐患统计 月度数据统计
     * @param year
     * @date  2020/5/7
     * @return
     */
    ApiResult zySsYhTjYd(String year);


    /**
     * 重要设施隐患统计 月度数据统计 点击数据
     * @param map
     * @date  2020/5/8
     * @return
     */
    ApiResult zySsYhTjYdClick(HashMap map);

    /**
     * 监管项底数统计  月度数据
     * @param year
     * @date  2020/5/9
     * @return
     */
    ApiResult jgYdData(String year);

    /**
     * 监管项底数统计  月度数据  钻取功能
     * @param map
     * @date  2020/5/9
     * @return
     */
    ApiResult jgYdDataClick(HashMap map);

    /**
     * 监企事业单位新增统计  月度数据
     * @param map
     * @date  2020/5/11
     * @return
     */
    ApiResult qsyAddYdData(HashMap map);

    /**
     * 监企事业单位新增统计  实时数据
     * @param map
     * @date  2020/5/11
     * @return
     */
    ApiResult qsyAddSsData(HashMap map);

    /**
     * 重点单位隐患统计  月度数据
     * @param map
     * @date  2020/5/11
     * @return
     */
    ApiResult zdDwYhYdData(HashMap map);

    /**
     * 重点单位隐患统计  月度数据
     * @param map
     * @date  2020/5/11
     * @return
     */
    ApiResult zdDwYhSsData(HashMap map);

    List<List<Object>> createListObject(List<LinkedHashMap> data);

    List<List<String>> createHead();

    void exportExcel(HttpServletResponse response, List<List<Object>> objects, List<List<String>> heads, String 实时数据统计表) throws IOException;

    List<List<Object>> createJgSsTjListObject(List<Map> data);
}

