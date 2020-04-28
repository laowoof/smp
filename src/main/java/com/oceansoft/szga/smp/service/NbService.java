package com.oceansoft.szga.smp.service;
import com.alibaba.fastjson.JSONObject;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;


/**
 *  内保
 * @author wzj
 * @date 2019/3/13
 */

@Mapper
public interface NbService {
    ApiResult test();

    /**
     * @date 2020/3/18
     * @return 企事业单位监管总数总数
     */
    ApiResult totleNum();

    /**
     * 重点监测单位总数
     * @return
    */
    ApiResult totleNumBySl();

    /**
     *重点监测单位总数
     * @date 2020/3/18
     * @return
     */
    ApiResult findDataByJj();

    /**
     *  重点单位 省，市，区县，占比数据
     * @return
     */
    ApiResult findDataByZd();

    /**
     *   履历分析 单位登记量排名
     * @return
     */
    ApiResult findDataByOrder();

    /**
     *   履历分析 单位登记量排名 详情派出所前10
     * @param name  区域名字
     * @return  详情数据
     */
    ApiResult findDataByLimit(String name);

    /**
     *   常规检查 主动检查 专项检查数
     * @author wzj
     * @date 2020/3/19
     * @return
     */
    ApiResult findNumByJcsl();

    /**
     *   隐患发现数
     * @author wzj
     * @date 2020/3/19
     * @return
     */
    ApiResult findNumByYhsl();
    /**
     *   隐患单位数量分析
     * @author wzj
     * @date 2020/3/120
     * @return
     */
    ApiResult findDataByFx();
    /**
     *   重点单位隐患数量
     * @author wzj
     * @date 2020/3/120
     * @return
     */
    ApiResult findDataByNum();
    /**
     *   重要设施专项检查量排名
     * @author wzj
     * @date 2020/3/120
     * @return
     */
    ApiResult findDataByZz();

    /**
     *   重要设施专项检查量排名 派出所排名
     * @author wzj
     * @date 2020/3/120
     * @param name canshu
     * @return
     */
    ApiResult findDataByZzLinit(String name);

    /**
     *   面分析重点单位 省
     * @author wzj
     * @date 2020/3/120
     * @return
     */
    ApiResult findDataByZzOne();

    /**
     *   重点设施监管总数
     * @author wzj
     * @date 2020/3/23
     * @return
     */
    ApiResult findNumByZyss();

    /**
     *   重点单位从业人员导入数
     * @author wzj
     * @date 2020/3/23
     * @return
     */
    ApiResult findNumByCyry();

    /**
     *   “铸盾”工程单位数
     * @author wzj
     * @date 2020/3/23
     * @return
     */
    ApiResult findNumByZd();

    /**
     *   生产安全事故立案数
     * @author wzj
     * @date 2020/3/23
     * @return
     */
    ApiResult findNumByScaq();
    /**
     *   隐患处理数
     * @author wzj
     * @date 2020/3/23
     * @return
     */
    ApiResult findNumByYhcls();
    /**
     *   全面分析-重要设施分析
     * @author wzj
     * @date 2020/3/23
     * @return
     */
    ApiResult findNumBySsFx();
    /**
     *  履历分析-重要设施登记量排名
     * @author wzj
     * @date 2020/3/23
     * @return
     */
    ApiResult findDataZySsLimit();
    /**
     *  履历分析-重要设施登记量排名 派出所前10
     * @author wzj
     * @date 2020/3/23
     * @param name
     * @return
     */
    ApiResult findDataZySsPcs(String name);
    /**
     *  履历分析-隐患发现量排名
     * @author wzj
     * @date 2020/3/23
     * @return
     */
    ApiResult findDataYhFx();
    /**
     *  履历分析-隐患发现量排名 派出所前10
     * @author wzj
     * @date 2020/3/23
     * @param name
     * @return
     */
    ApiResult findDataYhFxPcs(String name);
    /**
     *  履历分析-重点单位常规检查排名
     * @author wzj
     * @date 2020/3/24
     * @return
     */
    ApiResult findDataJctjCg();
    /**
     *  履历分析-常规检查 派出所前10
     * @author wzj
     * @date 2020/3/24
     * @param name
     * @return
     */
    ApiResult findDataJctjCgPcs(String name);
    /**
     *  履历分析-重点单位专项检查排名
     * @author wzj
     * @date 2020/3/24
     * @return
     */
    ApiResult findDataJctjZx();
    /**
     *  履历分析-常规检查 派出所前10
     * @author wzj
     * @date 2020/3/24
     * @param name
     * @return
     */
    ApiResult findDataJctjZxPcs(String name);
    /**
     *  履历分析-重点单位缺省检查排名
     * @author wzj
     * @date 2020/3/24
     * @return
     */
    ApiResult findDataJctjQs();
    /**
     *  履历分析-缺省检查 派出所前10
     * @author wzj
     * @date 2020/3/24
     * @param name
     * @return
     */
    ApiResult findDataJctjQsPcs(String name);
    /**
     *  履历分析-主动单位缺省检查排名
     * @author wzj
     * @date 2020/3/24
     * @return
     */
    ApiResult findDataJctjZd();
    /**
     *  履历分析-主动检查 派出所前10
     * @author wzj
     * @date 2020/3/24
     * @param name
     * @return
     */
    ApiResult findDataJctjZdPcs(String name);
    /**
     *  履历分析-未整改排名
     * @author wzj
     * @date 2020/3/24
     * @return
     */
    ApiResult findDataJctjWzg();
    /**
     *  履历分析-未整改排名 派出所前10
     * @author wzj
     * @date 2020/3/24
     * @param name
     * @return
     */
    ApiResult findDataJctjWzgPcs(String name);
    /**
     *  履历分析-整改排名
     * @author wzj
     * @date 2020/3/24
     * @return
     */
    ApiResult findDataJctjZg();

    /**
     *  履历分析-整改排名 派出所前10
     * @author wzj
     * @date 2020/3/24
     * @param name
     * @return
     */
    ApiResult findDataJctjZgPcs(String name);
    /**
     *  隐患分析-隐患上报数
     * @author wzj
     * @date 2020/3/24
     * @return
     */
    ApiResult findNumByGllx();
    /**
     *  隐患分析- 当场整改，责令限期整改并处警告，责令限期整改
     * @author wzj
     * @date 2020/3/24
     * @return
     */
    ApiResult findNumByGljc();
    /**
     *  隐患分析- 复查
     * @author wzj
     * @date 2020/3/24
     * @return
     */
    ApiResult findNumByFc();
    /**
     *  隐患分析- 复查未完成量
     * @author wzj
     * @date 2020/3/25
     * @return
     */
    ApiResult findNumByFcWwcl();

    /**
     *  隐患分析- 复查未完成量 原因
     * @author wzj
     * @date 2020/3/25
     * @return
     */
    ApiResult findNumByFcJcjg();
    /**
     *  隐患分析- 复查审批未完成量
     * @author wzj
     * @date 2020/3/25
     * @return
     */
    ApiResult findNumByFcspWwcl();
    /**
     *  隐患分析- 复查审批  罚款
     * @author wzj
     * @date 2020/3/25
     * @return
     */
    ApiResult findNumByFcspFk();
    /**
     *  隐患分析- 复查审批  协调
     * @author wzj
     * @date 2020/3/25
     * @return
     */
    ApiResult findNumByFcspXt();
    /**
     *  隐患分析- 隐患处置 当场整改
     * @author wzj
     * @date 2020/3/25
     * @return
     */
    ApiResult findNumByCzDczg();
    /**
     *  隐患分析- 隐患处置 整改完成数
     * @author wzj
     * @date 2020/3/25
     * @return
     */
    ApiResult findNumByCzZgwcs();
    /**
     *  隐患分析- 隐患处置 未完成量
     * @author wzj
     * @date 2020/3/25
     * @return
     */
    ApiResult findNumByCzWwcs();
    /**
     *  重点单位分析-重点单位占比分析-所有区域数据
     * @author wzj
     * @date 2020/3/25
     * @return
     */
    ApiResult findNumByZddw();
    /**
     *  重点单位分析-重点单位占比分析-top5
     * @author wzj
     * @date 2020/3/25
     * @return
     */
    ApiResult findNumByZddwLimit();
    /**
     *  重点单位分析-隐患数量态势-全市 年份
     * @author wzj
     * @date 2020/3/25
     * @return
     */
    ApiResult findNumByYhYear();
    /**
     *  重要设施分析-重要设施新增分析
     * @author wzj
     * @date 2020/3/26
     * @return
     */
    ApiResult findNumByZyssFx();

    /**
     *  重要设施分析-重要设施新增分析 种类
     * @author wzj
     * @date 2020/3/27
     * @return
     */
    ApiResult findNumByZyssFxZl(JSONObject obj);

    /**
     *  重要设施分析-重要设施新增分析  总量
     * @author wzj
     * @date 2020/3/26
     * @return
     */
    ApiResult findNumByZyssTotle();

    /**
     *  重要设施分析-重点单位占比分析 等级
     * @author wzj
     * @date 2020/3/26
     * @return
     */
    ApiResult findNumByDj(JSONObject obj);
    /**
     *  重要设施分析-重点单位占比分析 种类
     * @author wzj
     * @date 2020/3/26
     * @return
     */
    ApiResult findNumByZddwZl(JSONObject obj);

    /**
     *  重要设施分析-重点单位营业状态监测 默认年份
     * @author wzj
     * @date 2020/3/26
     * @return
     */
    ApiResult findDataByZddwYear(JSONObject obj);

    /**
     *  重要设施分析-重点单位营业状态监测 月份
     * @author wzj
     * @date 2020/3/27
     * @return
     */
    ApiResult findDataByZddwMonth(JSONObject obj);

    /**
     *  重要设施分析-重点单位营业状态监测 地区选择 月份
     * @author wzj
     * @date 2020/3/27
     * @return
     */
    ApiResult findNumByZddwJcMonth(JSONObject obj);

    /**
     *  全面分析企事业单位  种类选择
     * @author wzj
     * @date 2020/3/30
     * @param obj
     * @return
     */
    ApiResult findNumByQmQsyLx(JSONObject obj);
    /**
     *  重要设施
     * @author wzj
     * @date 2020/3/30
     * @return
     */
    ApiResult findNumByQmZyss();
    /**
     *  全面分析重要设施 种类选择
     * @author wzj
     * @date 2020/3/30
     * @param obj
     * @return
     */
    ApiResult findNumByQmZyssZl(JSONObject obj);

    /**
     *  全面分析-铸盾单位
     * @author wzj
     * @date 2020/3/30
     * @return
     */
    ApiResult findNumByZdNum();
    /**
     *  全面分析 企事业单位默认月份数据
     * @author wzj
     * @date 2020/3/30
     * @return
     */
    ApiResult findDataQsyMonth();

    /**
     *  全面分析 企事业单位默认年份数据
     * @author wzj
     * @date 2020/3/30
     * @return
     */
    ApiResult findDataQsyYear();
    /**
     *  全面分析 企事业单位数据联调
     * @author wzj
     * @date 2020/3/31
     * @param name
     */
    ApiResult findDataQsyLtMonth(String name);
    /**
     *  全面分析 企事业单位数据联调
     * @author wzj
     * @date 2020/3/31
     * @param name
     */
    ApiResult findDataQsyLtYear(String name);
    /**
     * 重点设施-主动检查
     * @param map
     * @return
     */
    ApiResult zdssZdjc(Map map);

    /**
     *  重点单位分析-主动检查分析
     *  @author wujg
     *  @date 2020/3/30
     *  @return
     */
    ApiResult findNumByZddwjcfx(String nf, String type);

    /**
     *  重要设施分析-营业状态监测-按月/按年/按地区
     *  @author wujg
     *  @date 2020/3/30
     *  @return
     */
    ApiResult findNumByZyssslZl(String nf, JSONObject obj);

    /**
     *  全面分析 “铸盾”工程单位数据联调
     * @author wzj
     * @date 2020/3/31
     * @param name
     */
    ApiResult findNumByZdgcYear(String name);

    /**
     *  全面分析 “铸盾”工程单位 默认年 数据
     * @author wzj
     * @date 2020/3/31
     */
    ApiResult findNumByZdgcMRYear();

    /**
     *  全面分析 “铸盾”工程单位 默认年 数据
     * @author wzj
     * @date 2020/4/1
     */
    ApiResult findNumByZdgcMRMonth();
    /**
     *  重要设施单位数量  年份数据
     * @author wzj
     * @date 2020/3/31
     * @param name
     */
    ApiResult findNumByZyssYear(String name);

    /**
     *  重要设施单位数量  默认年份数据
     * @author wzj
     * @date 2020/3/31
     */
    ApiResult findNumByZyssMRYear();
    /**
     *  重要设施单位数量  默认月份数据
     * @author wzj
     * @date 2020/4/1
     */
    ApiResult findNumByZyssMRMonth();

    /**
     *  重要设施单位数量  铸盾月份数据
     * @author wzj
     * @date 2020/4/2
     */
    ApiResult findNumByZddwLtMonth(String name);

    /**
     *  重要设施单位数量 月份数据
     * @author wzj
     * @date 2020/4/2
     */
    ApiResult findNumByZyssLtMonth(String name);

    /**
     * 隐患数量分析
     * @param map
     * @return
     */
    ApiResult yhslfx(Map map);

    /**
     * 隐患数量分析-地区-按月
     * @param map
     * @return
     */
    ApiResult yhslfxMonth(Map map);

    /**
     * 隐患数量分析-地区-按年
     * @param map
     * @return
     */
    ApiResult yhslfxYear(Map map);

    /**
     * 重要设施分析-专项检查分析
     * @param titleDateType
     * @return
     */
    ApiResult getDataJcFx(String titleDateType);
}

