package com.oceansoft.szga.smp.service;

import com.oceansoft.szga.smp.config.domain.ApiResult;
import org.apache.ibatis.annotations.Mapper;


/**
 *  出租房、群租房
 * @author wzj
 * @date 2019/1/19
 */

@Mapper
public interface ZfService {
    /**
     *  出租房人数
     * @author  wzj
     * @date  2020/1/19
     */
    ApiResult CzfPersonNum();

    /**
     *  出租房数量
     * @author  wzj
     * @date  2020/1/19
     */
    ApiResult CzfNum();

    /**
     *  出租房重点人员
     * @author  wzj
     * @date  2020/1/19
     */
    ApiResult CzfImpPerson();

    /**
     *  群租房人数
     * @author  wzj
     * @date  2020/1/19
     */
    ApiResult QzfPersonNum();
    /**
     *  群租房数量
     * @author  wzj
     * @date  2020/1/19
     */
    ApiResult QzfNum();
    /**
     *  群租房隐患分析
     * @author  wzj
     * @date  2020/1/19
     */
    ApiResult QzfDangerous();
    /**
     *  群租屋重点人
     * @author  wzj
     * @date  2020/1/19
     */
    ApiResult QzwImpPerson();

    /**
     *  群租房重点人
     * @author  wzj
     * @date  2020/1/19
     */
    ApiResult QzfImpPerson();

    /**
     *  隐患出租房人数
     * @author  wzj
     * @date  2020/1/19
     */
    ApiResult QangerCzf();

    /**
     *  隐患出租房重点人
     * @author  wzj
     * @date  2020/1/19
     */
    ApiResult DangerCzfImpPerson();

    /**
     *  隐患群租房数量
     * @author  wzj
     * @date  2020/1/20
     */
    ApiResult DangerQzfNum();

    /**
     *  隐患大类分析
     * @author  wzj
     * @date  2020/1/20
     */
    ApiResult DangerTypeFx();
    /**
     *流动人口来源地 省
     * @author wzj
     * @date 2020/1/20
     * @return
     */
    ApiResult floatingPopulationS();
    /**
     *流动人口来源地 市
     * @author wzj
     * @date 2020/1/20
     * @return
     */
    ApiResult floatingPopulationShi();
    /**
     *流动人口来源地 县
     * @author wzj
     * @date 2020/1/20
     * @return
     */
    ApiResult floatingPopulationX();
    /**
     *流动人口年龄分析
     * @author wzj
     * @date 2020/1/20
     * @return
     */
    ApiResult floatingPopulationAge();

    /**
     *流动人口数量
     * @author wzj
     * @date 2020/1/20
     * @return
     */
    ApiResult floatingPopulationNum();

    /**
     *流动人口实有数
     * @author wzj
     * @date 2020/1/20
     * @return
     */
    ApiResult floatingPopulationTrueNum();
    /**
     * 非治安隐患类型
     * @author  wzj
     * @date  2020/1/19
     */
    ApiResult notDangerType();
    /**
     * 非治安隐患流程节点监测-上报情况
     * @author  wzj
     * @date  2020/1/19
     */

    ApiResult notDangerTypeSB();
    /**
     * 非治安隐患数据
     * @author  wzj
     * @date  2020/1/19
     */
    ApiResult notDangerTypeSJ();
    /**
     * 出租房重点人 行政区划
     * @author  wzj
     * @date  2020/1/20
     */
    ApiResult CzfImpXzqh();
    /**
     * 非治安隐患分发
     * @author  wzj
     * @date  2020/1/20
     */
    ApiResult Fzayhff();
    /**
     * 非治安隐患认领
     * @author  wzj
     * @date  2020/1/20
     */
    ApiResult Fzayhrl();
}

