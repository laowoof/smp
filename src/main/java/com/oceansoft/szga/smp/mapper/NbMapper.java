package com.oceansoft.szga.smp.mapper;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wzj
 * @create 2020/3/13
 * @email wzj@oceansoft.com.cn
 */
@Repository
public interface NbMapper {
    List<HashMap> test(@Param("tjrq") String tjrq);

    /**
     * 企事业单位监管总数总数
     * @date  2020/3/18
     * @param tjrq 日期
     * @return
     */
    List<HashMap> totleNum(@Param("tjrq") String tjrq);

    /**
     * 重点监测单位总数
     * @date  2020/3/18
     * @param tjrq 日期
     * @return
     */
    List<HashMap> totleNumBySl(@Param("tjrq") String tjrq);
    /**
     * 重点监测单位总数
     * @date  2020/3/18
     * @param tjrq 日期
     * @return
     */
    List<HashMap> findDataByJj(@Param("tjrq") String tjrq);
    /**
     * 重点单位 省，市，区县，占比数据
     * @date  2020/3/19
     * @param tjrq 日期
     * @return
     */
    List<HashMap> findDataByZd(@Param("tjrq") String tjrq);
    /**
     * 履历分析 单位登记量排名
     * @date  2020/3/19
     * @param tjrq 日期
     * @return
     */
    List<HashMap> findDataByOrder(@Param("tjrq") String tjrq);

    /**
     * 履历分析 单位登记量排名 详情派出所前10
     * @date  2020/3/19
     * @param tjrq 日期
     * @param name 区域名字
     * @return
    **/
    List<HashMap> findDataByLimit(@Param("tjrq") String tjrq,@Param("name")String name);
    /**
     * 常规检查 主动检查 专项检查数
     * @date  2020/3/19
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByJcsl(@Param("tjrq") String tjrq);

    /**
     * 隐患发现数
     * @date  2020/3/19
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByYhsl(@Param("tjrq") String tjrq);
    /**
     * 隐患单位数量分析
     * @date  2020/3/20
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findDataByFx(@Param("tjrq") String tjrq);
    /**
     * 重点单位隐患数量
     * @date  2020/3/20
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findDataByNum(@Param("tjrq") String tjrq);
    /**
     * 重要设施专项检查量排名
     * @date  2020/3/20
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findDataByZz(@Param("tjrq") String tjrq);

    /**
     * 重要设施专项检查量排名 派出所排名
     * @date  2020/3/20
     * @param tjrq 日期
     * @param name
     * @return
     **/
    List<HashMap> findDataByZzLinit(@Param("tjrq") String tjrq,@Param("name")String name);

    /**
     * 全面分析重点单位 省
     * @date  2020/3/20
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findDataByZzOne(@Param("tjrq") String tjrq);

    /**
     * 重点设施监管总数
     * @date  2020/3/23
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByZyss(@Param("tjrq") String tjrq);
    /**
     * 重点单位从业人员导入数
     * @date  2020/3/23
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByCyry(@Param("tjrq") String tjrq);

    /**
     * “铸盾”工程单位数
     * @date  2020/3/23
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByZd(@Param("tjrq") String tjrq);

    /**
     * 生产安全事故立案数
     * @date  2020/3/23
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByScaq(@Param("tjrq") String tjrq);

    /**
     * 隐患处理数
     * @date  2020/3/23
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByYhcls(@Param("tjrq") String tjrq);
    /**
     *  全面分析-重要设施分析
     * @date  2020/3/23
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumBySsFx(@Param("tjrq") String tjrq);

    /**
     *  履历分析-重要设施登记量排名
     * @date  2020/3/23
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findDataZySsLimit(@Param("tjrq") String tjrq);
    /**
     *  履历分析-重要设施登记量排名  派出所前10
     * @date  2020/3/23
     * @param tjrq 日期
     * @param  name
     * @return
     **/
    List<HashMap> findDataZySsPcs(@Param("tjrq") String tjrq,@Param("name")String name);
    /**
     *  履历分析-隐患发现量排名
     * @date  2020/3/23
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findDataYhFx(@Param("tjrq") String tjrq);
    /**
     *  履历分析-隐患发现量排名 派出所前10
     * @date  2020/3/23
     * @param tjrq 日期
     * @param  name
     * @return
     **/
    List<HashMap> findDataYhFxPcs(@Param("tjrq") String tjrq,@Param("name")String name);
    }