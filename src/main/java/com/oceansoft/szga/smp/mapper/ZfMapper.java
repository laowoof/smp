package com.oceansoft.szga.smp.mapper;

import com.oceansoft.szga.smp.entity.CzfNum;
import com.oceansoft.szga.smp.entity.CzfPersonNum;
import org.apache.ibatis.annotations.Mapper;

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
     * @return
     */
    List<CzfPersonNum> CzfPersonNum();

    /**
     * 出租房数量
     * @author wzj
     * @date 2020/1/20
     * @return
     */
    List<CzfNum> CzfNum();

    /**
     * 出租房重点人
     * @author wzj
     * @date 2020/1/20
     * @return
     */
    List<HashMap> CzfImpPerson();
    /**
     * 群租房人数
     * @author wzj
     * @date 2020/1/20
     * @return
     */

    List<HashMap> QzfPersonNum();
    /**
     * 出租房数量
     * @author wzj
     * @date 2020/1/20
     * @return
     */

    List<HashMap> QzfNum();
    /**
     * 群租房隐患分析
     * @author wzj
     * @date 2020/1/20
     * @return
     */

    List<HashMap> QzfDangerous();

    /**
     * 群租屋重点人
     * @author wzj
     * @date 2020/1/20
     * @return
     */

    List<HashMap> QzwImpPerson();

    /**
     * 群租房隐患分析
     * @author wzj
     * @date 2020/1/20
     * @return
     */

    List<HashMap> QzfImpPerson();
    /**
     * 群租房隐患分析
     * @author wzj
     * @date 2020/1/20
     * @return
     */

    List<HashMap> DangeroursCzf();
    /**
     * 隐患出租房重点人
     * @author wzj
     * @date 2020/1/20
     * @return
     */

    List<HashMap> DangerCzfImpPerson();


    /**
     * 隐患群租房数量
     * @author wzj
     * @date 2020/1/20
     * @return
     */
    List<HashMap> DangerQzfNum();

    /**
     * 隐患大类分析
     * @author wzj
     * @date 2020/1/20
     * @return
     */
    List<HashMap> DangerTypeFx();

    /**
     *流动人口来源地 省
     * @author wzj
     * @date 2020/1/20
     * @return
     */
    List<HashMap> floatingPopulationS();
    /**
     *流动人口来源地 市
     * @author wzj
     * @date 2020/1/20
     * @return
     */
    List<HashMap> floatingPopulationShi();
    /**
     *流动人口来源地 县
     * @author wzj
     * @date 2020/1/20
     * @return
     */
    List<HashMap> floatingPopulationX();
    /**
     *流动人口年龄分析
     * @author wzj
     * @date 2020/1/20
     * @return
     */
    List<HashMap> floatingPopulationAge();
    /**
     *流动人口数量
     * @author wzj
     * @date 2020/1/20
     * @return
     */
    List<HashMap> floatingPopulationNum();
    /**
     *流动人口实有数
     * @author wzj
     * @date 2020/1/20
     * @return
     */
    List<HashMap> floatingPopulationTrueNum();
    /**
     *非治安隐患类型
     * @author wzj
     * @date 2020/1/20
     * @return
     */
    List<HashMap> notDangerType();
    /**
     *非治安隐患流程节点监测-上报情况
     * @author wzj
     * @date 2020/1/20
     * @return
     */
    List<HashMap> notDangerTypeSB();
    /**
     *非治安隐患数据
     * @author wzj
     * @date 2020/1/20
     * @return
     */
    List<HashMap> notDangerTypeSJ();
    /**
     * 出租房重点人 行政区划
     * @author wzj
     * @date 2020/1/20
     * @return
     */
    List<HashMap> CzfImpXzqh();
    /**
     * 非治安隐患分发
     * @author wzj
     * @date 2020/1/20
     * @return
     */
    List<HashMap> Fzayhff();
    /**
     * 非治安隐患认领
     * @author wzj
     * @date 2020/2、12
     * @return
     */
    List<HashMap> Fzayhrl();
}
