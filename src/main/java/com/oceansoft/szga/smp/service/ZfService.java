package com.oceansoft.szga.smp.service;

import com.oceansoft.szga.smp.config.domain.ApiResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 *  出租房、群租房
 * @author wzj
 * @date 2019/1/19
 */

@Mapper
public interface ZfService {

    /**
     *  出租房数量
     * @author  wzj
     * @date  2020/1/19
     * @return  数据
     */
    ApiResult czfNum();

    /**
     *  出租房数量降序
     * @author  wzj
     * @date  2020/2/26
     * @return  数据
     */
    ApiResult czfNumDesc();

    /**
     *  群租房数量
     * @author  wzj
     * @date  2020/1/19
     * @return  数据
     */
    ApiResult qzfNum();

    /**
     *  隐患群租房数量
     * @author  wzj
     * @date  2020/3/5
     * @return  数据
     */
    ApiResult nearQzfNum(String num);

    /**
     *  群租房数量
     * @author  wzj
     * @date  2020/2/17
     * @return  数据
     */
    ApiResult qzfMonthData(@Param("time") String time);

    /**
     *  根据区域获取区域内的群租房总数量
     * @author  wzj
     * @date  2020/2/25
     * @return  数据
     */
    ApiResult qzfAreaNum(@Param("xzqhmc") String xzqhmc,@Param("num") String num);

    /**
     * 区域新增群租房
     * @author wzj
     * @date 2020/3/5
     * @return 数据
     */
    ApiResult areaAddNum();


    /**
     *  群租房隐患分析
     * @author  wzj
     * @date  2020/1/19
     * @return  数据
     */
    ApiResult qzfDangerous();

    /**
     *  群租房隐患分析 非治安
     * @author  wzj
     * @date  2020/2/19
     * @return  数据
     */
    ApiResult qzfDangerous2();
    /**
     *  群租屋重点人
     * @author  wzj
     * @date  2020/1/19
     * @return  数据
     */
    ApiResult qzwImpPerson();

    /**
     *  群租房重点人
     * @author  wzj
     * @date  2020/1/19
     * @return  数据
     */
    ApiResult qzfImpPerson();


    /**
     *  隐患群租房数量
     * @author  wzj
     * @date  2020/1/20
     * @return  数据
     */
    ApiResult dangerQzfNum();

    /**
     *  隐患群租房d单区数量
     * @author  wzj
     * @date  2020/2/20
     * @return  数据
     */
    ApiResult yhQzfTotleNum();

    /**
     *  隐患群租房数量
     * @author  wzj
     * @date  2020/3/5
     * @return  数据
     */
    ApiResult nearYhQzf(String num);

    /**
     *  隐患大类分析
     * @author  wzj
     * @date  2020/1/20
     * @return  数据
     */
    ApiResult dangerTypeFx();


    /**
     *流动人口数量
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */
    ApiResult floatingPopulationNum();

    /**
     *流动人口数量
     * @author wzj
     * @date 2020/3/9
     * @return 数据
     */
    ApiResult ldryFxData();


    /**
     * 非治安隐患流程节点监测-上报情况
     * @author  wzj
     * @date  2020/1/19
     * @return 数据
     */

    ApiResult notDangerTypeSb();
    /**
     * 非治安隐患数据
     * @author  wzj
     * @date  2020/1/19
     * @return 数据
     */
    ApiResult notDangerTypeSj();

    /**
     * 非治安隐患数据
     * @author  wzj
     * @date  2020/3/4
     * @return 数据
     */
    ApiResult fZaSj();

    /**
     * 非治安隐患数据
     * @author  wzj
     * @date  2020/4/7
     * @return 数据
     */
    ApiResult fZaDataSj();

    /**
     * 非治安近日天数数据7/30
     * @author  wzj
     * @date  2020/2/19
     * @return 数据
     */
    ApiResult sigleData(String xzqhmc,String num);


    /**
     * 治安近日天数数据
     * @author  wzj
     * @date  2020/2/27
     * @return 数据
     */
    ApiResult findDataByName(String xzqhmc,String num);

    /**
     * 单独数据
     * @author  wzj
     * @date  2020/2/19
     * @return 数据
     */
    ApiResult fzaYhNum(String xzqhmc);

    /**
     * 非治安隐患数据统计
     * @author  wzj
     * @date  2020/2/18
     * @return 数据
     */
    ApiResult totleNum(String num);
    /**
     * 非治安隐患数据统计
     * @author  wzj
     * @date  2020/2/19
     * @return 数据
     */
    ApiResult totleNum2(String num);

    /**
     * 非治安隐患单区域数据统计
     * @author  wzj
     * @date  2020/2/20
     * @return 数据
     */
    ApiResult zaYhNum();

    /**
     * 非治安隐患分发
     * @author  wzj
     * @date  2020/1/20
     * @return 数据
     */
    ApiResult fzayhff();
    /**
     * 非治安隐患认领
     * @author  wzj
     * @date  2020/1/20
     * @return 数据
     */
    ApiResult fzayhrl();
    /**
     * 非治安隐患审核
     * @author  wzj
     * @date  2020/1/20
     * @return 数据
     */
    ApiResult fzayhsh();
    /**
     * 非治安隐患整改
     * @author  wzj
     * @date  2020/1/20
     * @return 数据
     */
    ApiResult fzayhza();
    /**
     * 群租房区域流动人员数量
     * @author  wzj
     * @date  2020/1/20
     * @return 数据
     */
    ApiResult qyldrysl();


    /**
     * 隐患出租屋数量
     * @author  wzj
     * @date  2020/1/20
     * @return 数据
     */
    ApiResult yhczwsj();

    /**
     * 安全监管群租房隐患趋势
     * @author  wzj
     * @date  2020/1/20
     * @return 数据
     */
    ApiResult yhqs(String num);

    /**
     * 安全监管群租房隐患趋势
     * @author  wzj
     * @date  2020/3/11
     * @return 数据
     */
    ApiResult yhqs2(String num);

    /**
     * 治安隐患数据
     * @author  wzj
     * @date  2020/1/20
     * @return 数据
     */
    ApiResult zayhsj();

    /**
     * 非治安 治安隐患数据
     * @author wzj
     * @date 2020/3/4
     * @return 数据
     */
    ApiResult yhsData();

    /**
     * 非治安隐患数据 近期
     * @author wzj
     * @date 2020/3/6
     * @return 数据
     */
    ApiResult nearYhsData(String num);

    /**
     * 非治安隐患数据 近期  单区域 7/30
     * @author wzj
     * @date 2020/3/6
     * @return 数据
     */
    ApiResult singleAreaData(String xzqhmc,String num);

    /**
     * 安全监管群租房治安隐患整改发现数量
     * @author  wzj
     * @date  2020/1/20
     * @return 数据
     */
    ApiResult zayhFxsl();

    /**
     * 安全监管群租房治安隐患整改未整改数量
     * @author  wzj
     * @date  2020/1/20
     * @return 数据
     */
    ApiResult zayhWzgsl();
    /**
     * 安全监管群租房治安隐患整改整改数量
     * @author  wzj
     * @date  2020/1/20
     * @return 数据
     */
    ApiResult zayhZgsl();
    /**
     * 重点人员数量
     * @author  wzj
     * @date  2020/1/20
     * @return 数据
     */
    ApiResult zdrysl();

    /**
     *  全面分析  治安隐患数据
     * @return
     */
    ApiResult zaData();
    /**
     * 重点人员数量
     * @author  wzj
     * @date  2020/4/7
     * @return 数据
     */
    ApiResult lzFxDataByLdrk();

}

