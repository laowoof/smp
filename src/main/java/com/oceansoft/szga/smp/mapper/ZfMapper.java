package com.oceansoft.szga.smp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 *  出租房  群租房
 * @author wzj
 * @date 2019/1/19
 */

@Mapper
public interface ZfMapper {

    /**
     * 出租房数量
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */
    List<HashMap> czfNum(@Param("tjrq")String tjrq);

    /**
     * 出租房数量降序
     * @author wzj
     * @date 2020/2/26
     * @return 数据
     */
    List<HashMap> czfNumDesc();

    /**
     * 出租房数量
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */

    List<HashMap> qzfNum(@Param("tjrq") String tjrq);

    /**
     * 出租房数量
     * @author wzj
     * @date 2020/3/5
     * @return 数据
     */

    List<HashMap> nearQzfNum(@Param("time") String time,@Param("time2")String time2);

    /**
     * 群租房隐患分析
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */

    List<HashMap> qzfDangerous(@Param("tjrq") String tjrq);
    /**
     * 群租房隐患分析 非治安
     * @author wzj
     * @date 2020/2/19
     * @return 数据
     */

    List<HashMap> qzfDangerous2(@Param("tjrq") String tjrq);

    /**
     * 群租屋重点人
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */

    List<HashMap> qzwImpPerson(@Param("tjrq")String tjrq);

    /**
     * 群租房隐患分析
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */

    List<HashMap> qzfImpPerson(@Param("tjrq")String tjrq);


    /**
     * 隐患群租房数量
     * @author wzj
     * @date 2020/2/17
     * @return 数据
     */
    List<HashMap> qzfMonthData(@Param("time") String time);

    /**
     * 根据区域获取区域内的群租房总数量
     * @author wzj
     * @date 2020/2/25
     * @return 数据
     */
    List<HashMap> qzfAreaNum(@Param("xzqhmc") String xzqhmc,@Param("time") String time,@Param("time2")String time2);

    /**
     * 区域新增群租房
     * @author wzj
     * @date 2020/3/5
     * @return 数据
     */

    List<HashMap> areaAddNum(@Param("time2") String time2, @Param("time") String time);


    /**
     * 隐患群租房数量
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */
    List<HashMap> dangerQzfNum(@Param("tjrq")String tjrq);

    /**
     * 隐患群租房单区数量
     * @author wzj
     * @date 2020/2/20
     * @return 数据
     */
    List<HashMap> yhQzfTotleNum(@Param("tjrq")String tjrq);

    /**
     * 隐患群租房
     * @author wzj
     * @date 2020/2/20
     * @return 数据
     */
    List<HashMap> nearYhQzf(@Param("time")String time,@Param("time2")String time2);

    /**
     * 隐患大类分析
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */
    List<HashMap> dangerTypeFx(@Param("tjrq")String tjrq);

    /**
     *流动人口数量
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */
    List<HashMap> floatingPopulationNum();

    /**
     *流动人口数量
     * @author wzj
     * @date 2020/3/9
     * @return 数据
     */
    List<HashMap> ldryFxData(@Param("tjrq") String tjrq);


    /**
     *非治安隐患流程节点监测-上报情况
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */
    List<HashMap> notDangerTypeSb(@Param("tjrq")String tjrq);
    /**
     *非治安隐患数据
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */
    List<HashMap> notDangerTypeSj(@Param("tjrq")String tjrq);

    /**
     *非治安隐患数据 区县
     * @author wzj
     * @date 2020/3/4
     * @return 数据
     */
    List<HashMap> fZaSj(@Param("tjrq")String tjrq);
    /**
     *非治安隐患数据
     * @author wzj
     * @date 2020/4/7
     * @return 数据
     */
    List<HashMap> fZaDataSj();

    /**
     * 单独数据
     * @author wzj
     * @date 2020/2/19
     * @return 数据
     */
    List<HashMap> sigleData(@Param("time")String time,@Param("time2")String time2,@Param("xzqhmc")String xzqhmc);

    /**
     * 单独数据
     * @author wzj
     * @date 2020/2/27
     * @return 数据
     */
    List<HashMap> findDataByName(@Param("time")String time,@Param("time2")String time2,@Param("xzqhmc")String xzqhmc);

    /**
     * 单独数据
     * @author wzj
     * @date 2020/2/20
     * @return 数据
     */
    List<HashMap> fzaYhNum(@Param("xzqhmc")String xzqhmc);

    /**
     *非治安隐患数据统计
     * @author wzj
     * @date 2020/2/18
     * @return 数据
     */
    List<HashMap> totleNum(@Param("time")String time,@Param("time2")String time2);

    /**
     *治安隐患数据统计
     * @author wzj
     * @date 2020/2/19
     * @return 数据
     */
    List<HashMap> totleNum2(@Param("time")String time,@Param("time2")String time2);
    /**
     *治安隐患单区域数据统计
     * @author wzj
     * @date 2020/2/20
     * @return 数据
     */
    List<HashMap> zaYhNum(@Param("tjrq")String tjrq );

    /**
     * 非治安隐患分发
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */
    List<HashMap> fzayhff(@Param("tjrq")String tjrq);
    /**
     * 非治安隐患认领
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> fzayhrl(@Param("tjrq")String tjrq);
    /**
     * 非治安隐患审核
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> fzayhsh(@Param("tjrq")String tjrq);
    /**
     * 非治安隐患整改
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> fzayhza();
    /**
     * 群租房区域流动人员数量
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> qyldrysl(@Param("tjrq")String tjrq);


    /**
     * 隐患出租屋数量
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> yhczwsj(@Param("tjrq")String tjrq);


    /**
     * 安全监管群租房隐患趋势
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> yhqs(@Param("time")String time,@Param("time2")String time2);

    /**
     * 安全监管群租房隐患趋势
     * @author wzj
     * @date 2020/3/11
     * @return 数据
     */
    List<HashMap> yhqs2(@Param("time")String time,@Param("time2")String time2);

    /**
     * 治安隐患数据
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> zayhsj(@Param("tjrq")String tjrq);

    /**
     * 非治安 治安隐患数据
     * @author wzj
     * @date 2020/3/4
     * @return 数据
     */
    List<HashMap> yhsData(@Param("tjrq")String tjrq);

    /**
     * 非治安 隐患数据 近期
     * @author wzj
     * @date 2020/3/6
     * @return 数据
     */
    List<HashMap> nearYhsData(@Param("time")String time,@Param("time2")String time2);

    /**
     * 非治安 隐患数据 单区域 近期
     * @author wzj
     * @date 2020/3/6
     * @return 数据
     */
    List<HashMap> singleAreaData(@Param("time")String time,@Param("time2")String time2,@Param("xzqhmc")String xzqhmc);

    /**
     * 安全监管群租房治安隐患整改发现数量
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> zayhFxsl();
    /**
     * 安全监管群租房治安隐患整改未整改数量
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> zayhWzgsl();
    /**
     * 安全监管群租房治安隐患整改整改数量
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> zayhZgsl();
    /**
     * 重点人员数量
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> zdrysl();

    /**
     *  全面分析  治安隐患数据
     * @return
     */
    List<HashMap> zaData();

    /**
     *  履职分析  流动人口
     * @author wzj
     * @date 2020/4/7
     * @return
     */
    List<HashMap> lzFxDataByLdrk();
}
