package com.oceansoft.szga.smp.mapper;

import com.oceansoft.szga.smp.entity.SourceNum;
import org.springframework.data.repository.query.Param;
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
     *  主要隐患高发地分析
     * @author wzj
     * @param map
     * @return
     */
    List<Map> getAnYhDdFx(Map map);

    /**
     *  隐患治理列表
     * @author wzj
     * @param map
     * @return
     */
    List<Map> getYhZlLb(Map map);

    /**
     *  top5
     * @author wzj
     * @param map
     * @return
     */
    List<Map> getSqTop5(Map map);

    /**
     *  各大队隐患处理情况分析  点击事件获取 中队数据
     * @author wzj
     * @param map
     * @return
     */
    List<Map> getDataClick(Map map);

    /**
     *  各大队隐患处理情况分析  点击事件获取中队数据后 道路隐患top5
     * @author wzj
     * @param map
     * @return
     */
    List<Map> getDataClickTop5(Map map);

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
    List<HashMap> getDataJtWf(HashMap map);

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
     * @param map
     * @return 处理后的数据
     */
    List<HashMap> getDataDdList(HashMap map);
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
