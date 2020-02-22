package com.oceansoft.szga.smp.mapper;

import com.oceansoft.szga.smp.entity.CzfNum;
import com.oceansoft.szga.smp.entity.CzfPersonNum;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

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
     * 出租房人数
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */
    List<CzfPersonNum> czfPersonNum();

    /**
     * 出租房数量
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */
    List<CzfNum> czfNum();

    /**
     * 出租房重点人
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */
    List<HashMap> czfImpPerson();
    /**
     * 群租房人数
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */

    List<HashMap> qzfPersonNum();
    /**
     * 出租房数量
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */

    List<HashMap> qzfNum();
    /**
     * 群租房隐患分析
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */

    List<HashMap> qzfDangerous();
    /**
     * 群租房隐患分析 非治安
     * @author wzj
     * @date 2020/2/19
     * @return 数据
     */

    List<HashMap> qzfDangerous2();

    /**
     * 群租屋重点人
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */

    List<HashMap> qzwImpPerson();

    /**
     * 群租房隐患分析
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */

    List<HashMap> qzfImpPerson();
    /**
     * 群租房隐患分析
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */

    List<HashMap> dangeroursCzf();
    /**
     * 隐患出租房重点人
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */

    List<HashMap> dangerCzfImpPerson();


    /**
     * 隐患群租房数量
     * @author wzj
     * @date 2020/2/17
     * @return 数据
     */
    List<HashMap> qzfMonthData(@Param("time") String time);

    /**
     * 隐患群租房数量 本月
     * @author wzj
     * @date 2020/2/20
     * @return 数据
     */

    List<HashMap> addQzfData2(@Param("time") String time,@Param("time2") String time2,@Param("xzqhmc")String xzqhmc);

    /**
     * 隐患群租房数量 某天新增数量
     * @author wzj
     * @date 2020/2/22
     * @return 数据
     */

    List<HashMap> addQzfData3(@Param("time") String time,@Param("time2") String time2);

    /**
     * 隐患群租房数量
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */
    List<HashMap> dangerQzfNum();

    /**
     * 隐患群租房单区数量
     * @author wzj
     * @date 2020/2/20
     * @return 数据
     */
    List<HashMap> yhQzfTotleNum(@Param("xzqhmc")String xzqhmc);

    /**
     * 隐患大类分析
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */
    List<HashMap> dangerTypeFx();

    /**
     *流动人口来源地 省
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */
    List<HashMap> floatingPopulationS();
    /**
     *流动人口来源地 市
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */
    List<HashMap> floatingPopulationShi();
    /**
     *流动人口来源地 县
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */
    List<HashMap> floatingPopulationX();
    /**
     *流动人口年龄分析
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */
    List<HashMap> floatingPopulationAge();
    /**
     *流动人口数量
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */
    List<HashMap> floatingPopulationNum();
    /**
     *流动人口实有数
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */
    List<HashMap> floatingPopulationTrueNum();
    /**
     *非治安隐患类型
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */
    List<HashMap> notDangerType();
    /**
     *非治安隐患流程节点监测-上报情况
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */
    List<HashMap> notDangerTypeSb();
    /**
     *非治安隐患数据
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */
    List<HashMap> notDangerTypeSj();
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
    List<HashMap> zaYhNum(@Param("xzqhmc")String xzqhmc );

    /**
     * 出租房重点人 行政区划
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */
    List<HashMap> czfImpXzqh();
    /**
     * 非治安隐患分发
     * @author wzj
     * @date 2020/1/20
     * @return 数据
     */
    List<HashMap> fzayhff();
    /**
     * 非治安隐患认领
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> fzayhrl();
    /**
     * 非治安隐患审核
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> fzayhsh();
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
    List<HashMap> qyldrysl();
    /**
     * 群租房重点人人数-按行政区划
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> czfzdrrsXzqh();
    /**
     * 隐患出租房重点人人数-按行政区划
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> czfzdrrsZdlx();
    /**
     * 隐患出租房重点人人数-按重点类型
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> yhczfzdrLx();
    /**
     * 隐患出租屋数量
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> yhczwsj();
    /**
     * 数图-隐患房屋数量-按派出所分类
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> yhfwpcs();
    /**
     * 安全监管群租房隐患趋势
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> yhqs();
    /**
     * 隐患群租房人数
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> yhqzfrs();
    /**
     * 隐患群租房重点人人数-按行政区划
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> qzfzdrrsXzqh();
    /**
     * 隐患群租房重点人人数-按重点类型
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> qzfzdrrsZdlx();
    /**
     * 隐患群租房重点人员
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> yhqzfzdry();
    /**
     * 隐患群租重点人-按类型
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> yhqzfzdrLx();
    /**
     * 隐患群租屋数量
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> yhqzwsj();
    /**
     * 隐患群租屋重点人
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> yhqzwzdr();
    /**
     * 治安隐患类型
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> zayhlx();
    /**
     * 治安隐患数据
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> zayhsj();
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
     * 出租房重点人员
     * @author wzj
     * @date 2020/2/12
     * @return 数据
     */
    List<HashMap> czfzdry();
}
