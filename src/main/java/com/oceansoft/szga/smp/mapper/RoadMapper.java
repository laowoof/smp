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

    List<HashMap> getAddress();

    HashMap getSourceSum(SourceNum sourceNum);

    List<HashMap> getFirmAnalzeSum(SourceNum sourceNum);

    List<HashMap> getAchievCount(SourceNum sourceNum);
}
