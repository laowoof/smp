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
    /**
     * 违法打击 数量总计
     * @param map
     * @return 处理后的数据
     */
    List<HashMap> getWfDj(HashMap map);
    /**
     * 违法打击 执法数据
     * @param map
     * @return 处理后的数据
     */
    List<HashMap> getZfSj(HashMap map);

    /**
     * 违法打击 执法数据 中队数据
     * @param map
     * @return 处理后的数据
     */
    List<HashMap> getZfSjZd(HashMap map);

    /**
     * 违法打击  违法黑名单
     * @param map
     * @return 处理后的数据
     */
    List<HashMap> getWfHmd(HashMap map);
    /**
     * 违法打击  查缉布控
     * @param map
     * @return 处理后的数据
     */
    List<HashMap> getDataCjBk(HashMap map);

    /**
     * 违法打击  人像识别
     * @param map
     * @return 处理后的数据
     */
    List<HashMap> getDataRxSb(HashMap map);
    /**
     * 违法打击  交通违法时间段分析
     * @param name
     * @return 处理后的数据
     */
    List<HashMap> getDataJtWf(String name,String yesterday);

    /**
     * 违法打击  重点违量统计
     * @param map
     * @return 处理后的数据
     */
    List<HashMap> getDataZdWlTj(HashMap map);
    /**
     * 违法打击  重点违法类型分析
     * @param map
     * @return 处理后的数据
     */
    List<HashMap> getDataWfLx(HashMap map);
    /**
     * 违法打击  重点违法类型分析type
     * @param map
     * @return 处理后的数据
     */
    List<HashMap> getDataWfLxType(HashMap map);

    /**
     * 违法打击  重点违量统计点击事件
     * @param map
     * @return 处理后的数据
     */
    List<HashMap> getClickDataWfLxType(HashMap map);

    /**
     * 违法打击  车辆问题变化趋势分析
     * @param map
     * @return 处理后的数据
     */
    List<HashMap> getDataCarYear(HashMap map);
    /**
     * 违法打击  车辆问题变化趋势分析
     * @param map
     * @return 处理后的数据
     */
    List<HashMap> getDataCarMonth(HashMap map);
    /**
     * 违法打击  车辆问题变化趋势分析  默认数据
     * @param map
     * @return 处理后的数据
     */
    List<HashMap> getDataCarMR(HashMap map);
    /**
     * 违法打击    车辆问题类型分析
     * @param map
     * @return 处理后的数据
     */
    List<HashMap> getDataCarQue(HashMap map);
    /**
     * 违法打击    大队列表
     * @param typeName
     * @return 处理后的数据
     */
    List<HashMap> getDataDdList(String typeName);
    /**
     * 违法打击    选择大队
     * @param map
     * @return 处理后的数据
     */
    List<HashMap> getDataDdListChange(Map map);
    /**
     * 违法打击    选择大队后车辆问题变化趋势分析  默认
     * @param map
     * @return 处理后的数据
     */
    List<HashMap> getDataDdListChangeMr(Map map);
    /**
     * 违法打击    选择大队后车辆问题变化趋势分析  年份
     * @param map
     * @return 处理后的数据
     */
    List<HashMap> getDataDdListChangeYear(Map map);
    /**
     * 违法打击    选择大队后车辆问题变化趋势分析  月份
     * @param map
     * @return 处理后的数据
     */
    List<HashMap> getDataDdListChangeMonth(Map map);
    /**
     * 违法打击   点击事件
     * @param map
     * @return 处理后的数据
     */
    List<HashMap> getDataClickCarAndChange(Map map);
}
