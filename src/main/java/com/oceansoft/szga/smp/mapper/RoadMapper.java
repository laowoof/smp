package com.oceansoft.szga.smp.mapper;

import com.oceansoft.szga.smp.entity.SourceNum;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wzj
 * @create 2020/4/20
 * @email wzj@oceansoft.com.cn
 */
@Repository
public interface RoadMapper {
    List<HashMap> test();
    /**
     *  安全隐患-隐患数据
     * @author wzj
     * @param map
     * @return
     */
    List<Map> anTotleNum(Map map);

    /**
     *  各大队隐患处理情况分析
     * @author wzj
     * @param map
     * @return
     */
    List<Map> yhQusFx(Map map);

    List<Map> yhQusGs(Map map);

    List<Map> yhQusXs(Map map);

    /**
     *  重要节点分析
     * @author wzj
     * @param map
     * @return
     */
    List<Map> zyJdFx(Map map);

    /**
     *  隐患类型分析
     * @author wzj
     * @param map
     * @return
     */
    List<Map> yhLxFx(Map map);

    /**
     * 获取十一个区县和全区
     * @return 区划代码和名称
     */
    List<HashMap> getAddress();

    /**
     * 页面按年/月/1月的查询按钮
     * @param sourceNum 条件
     * @return 企业总量、重点车辆数、重点人员数
     */
    HashMap getSourceSum(SourceNum sourceNum);

    /**
     * 企业性质/类型分析
     * @param sourceNum 条件
     * @return 处理后的数据
     */
    List<HashMap> getFirmAnalzeSum(SourceNum sourceNum);

    /**
     * 治理成果统计/类型分析、完成率
     * @param sourceNum 条件
     * @return 处理后的数据
     */
    List<HashMap> getAchievCount(SourceNum sourceNum);
}
