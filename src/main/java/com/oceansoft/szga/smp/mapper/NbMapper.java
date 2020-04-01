package com.oceansoft.szga.smp.mapper;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wzj
 * @create 2020/3/13
 * @email wzj@oceansoft.com.cn
 */
@Repository
public interface NbMapper {
    List<HashMap> test(@Param("tjrq") String tjrq);

    /**
     * 企事业单位监管总数总数
     * @date  2020/3/18
     * @param tjrq 日期
     * @return
     */
    List<HashMap> totleNum(@Param("tjrq") String tjrq);

    /**
     * 重点监测单位总数
     * @date  2020/3/18
     * @param tjrq 日期
     * @return
     */
    List<HashMap> totleNumBySl(@Param("tjrq") String tjrq);
    /**
     * 重点监测单位总数
     * @date  2020/3/18
     * @param tjrq 日期
     * @return
     */
    List<HashMap> findDataByJj(@Param("tjrq") String tjrq);
    /**
     * 重点单位 省，市，区县，占比数据
     * @date  2020/3/19
     * @param tjrq 日期
     * @return
     */
    List<HashMap> findDataByZd(@Param("tjrq") String tjrq);
    /**
     * 履历分析 单位登记量排名
     * @date  2020/3/19
     * @param tjrq 日期
     * @return
     */
    List<HashMap> findDataByOrder(@Param("tjrq") String tjrq);

    /**
     * 履历分析 单位登记量排名 详情派出所前10
     * @date  2020/3/19
     * @param tjrq 日期
     * @param name 区域名字
     * @return
    **/
    List<HashMap> findDataByLimit(@Param("tjrq") String tjrq,@Param("name")String name);
    /**
     * 常规检查 主动检查 专项检查数
     * @date  2020/3/19
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByJcsl(@Param("tjrq") String tjrq);

    /**
     * 隐患发现数
     * @date  2020/3/19
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByYhsl(@Param("tjrq") String tjrq);
    /**
     * 隐患单位数量分析
     * @date  2020/3/20
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findDataByFx(@Param("tjrq") String tjrq);
    /**
     * 重点单位隐患数量
     * @date  2020/3/20
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findDataByNum(@Param("tjrq") String tjrq);
    /**
     * 重要设施专项检查量排名
     * @date  2020/3/20
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findDataByZz(@Param("tjrq") String tjrq);

    /**
     * 重要设施专项检查量排名 派出所排名
     * @date  2020/3/20
     * @param tjrq 日期
     * @param name
     * @return
     **/
    List<HashMap> findDataByZzLinit(@Param("tjrq") String tjrq,@Param("name")String name);

    /**
     * 全面分析重点单位 省
     * @date  2020/3/20
     * @return
     **/
    List<HashMap> findDataByZzOne();

    /**
     * 重点设施监管总数
     * @date  2020/3/23
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByZyss(@Param("tjrq") String tjrq);
    /**
     * 重点单位从业人员导入数
     * @date  2020/3/23
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByCyry(@Param("tjrq") String tjrq);

    /**
     * “铸盾”工程单位数
     * @date  2020/3/23
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByZd(@Param("tjrq") String tjrq);

    /**
     * 生产安全事故立案数
     * @date  2020/3/23
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByScaq(@Param("tjrq") String tjrq);

    /**
     * 隐患处理数
     * @date  2020/3/23
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByYhcls(@Param("tjrq") String tjrq);
    /**
     *  全面分析-重要设施分析
     * @date  2020/3/23
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumBySsFx(@Param("tjrq") String tjrq);

    /**
     *  履历分析-重要设施登记量排名
     * @date  2020/3/23
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findDataZySsLimit(@Param("tjrq") String tjrq);
    /**
     *  履历分析-重要设施登记量排名  派出所前10
     * @date  2020/3/23
     * @param tjrq 日期
     * @param  name
     * @return
     **/
    List<HashMap> findDataZySsPcs(@Param("tjrq") String tjrq,@Param("name")String name);
    /**
     *  履历分析-隐患发现量排名
     * @date  2020/3/23
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findDataYhFx(@Param("tjrq") String tjrq);
    /**
     *  履历分析-隐患发现量排名 派出所前10
     * @date  2020/3/23
     * @param tjrq 日期
     * @param  name
     * @return
     **/
    List<HashMap> findDataYhFxPcs(@Param("tjrq") String tjrq,@Param("name")String name);
    /**
     *  履历分析-重点单位常规检查排名
     * @date  2020/3/24
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findDataJctjCg(@Param("tjrq") String tjrq);

    /**
     *  履历分析-常规检查区域派出所 前10
     * @date  2020/3/24
     * @param tjrq 日期
     * @param name
     * @return
     **/
    List<HashMap> findDataJctjCgPcs(@Param("tjrq") String tjrq,@Param("name")String name);
    /**
     *  履历分析-专项检查排名
     * @date  2020/3/24
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findDataJctjZx(@Param("tjrq") String tjrq);

    /**
     *  履历分析-专项检查区域派出所 前10
     * @date  2020/3/24
     * @param tjrq 日期
     * @param name
     * @return
     **/
    List<HashMap> findDataJctjZxPcs(@Param("tjrq") String tjrq,@Param("name")String name);
    /**
     *  履历分析-缺省检查排名
     * @date  2020/3/24
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findDataJctjQs(@Param("tjrq") String tjrq);

    /**
     *  履历分析-缺省检查区域派出所 前10
     * @date  2020/3/24
     * @param tjrq 日期
     * @param name
     * @return
     **/
    List<HashMap> findDataJctjQsPcs(@Param("tjrq") String tjrq,@Param("name")String name);
    /**
     *  履历分析-主动检查排名
     * @date  2020/3/24
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findDataJctjZd(@Param("tjrq") String tjrq);

    /**
     *  履历分析-主动检查区域派出所 前10
     * @date  2020/3/24
     * @param tjrq 日期
     * @param name
     * @return
     **/
    List<HashMap> findDataJctjZdPcs(@Param("tjrq") String tjrq,@Param("name")String name);
    /**
     *  履历分析-未整改量排名
     * @date  2020/3/24
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findDataJctjWzg(@Param("tjrq") String tjrq);

    /**
     *  履历分析-未整改量区域派出所 前10
     * @date  2020/3/24
     * @param tjrq 日期
     * @param name
     * @return
     **/
    List<HashMap> findDataJctjWzgPcs(@Param("tjrq") String tjrq,@Param("name")String name);
    /**
     *  履历分析-整改量排名
     * @date  2020/3/24
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findDataJctjZg(@Param("tjrq") String tjrq);

    /**
     *  履历分析-整改量区域派出所 前10
     * @date  2020/3/24
     * @param tjrq 日期
     * @param name
     * @return
     **/
    List<HashMap> findDataJctjZgPcs(@Param("tjrq") String tjrq,@Param("name")String name);
    /**
     *  隐患分析-隐患上报数
     * @date  2020/3/24
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByGllx(@Param("tjrq") String tjrq);
    /**
     *  隐患分析- 当场整改，责令限期整改并处警告，责令限期整改
     * @date  2020/3/24
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByGljc(@Param("tjrq") String tjrq);
    /**
     *  隐患分析- 复查
     * @date  2020/3/24
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByFc(@Param("tjrq") String tjrq);
    /**
     *  隐患分析- 复查  未完成量
     * @date  2020/3/25
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByFcWwcl(@Param("tjrq") String tjrq);
    /**
     *  隐患分析- 复查  未完成量 原因
     * @date  2020/3/25
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByFcJcjg(@Param("tjrq") String tjrq);
    /**
     *  隐患分析- 复查审批  未完成量
     * @date  2020/3/25
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByFcspWwcl(@Param("tjrq") String tjrq);
    /**
     *  隐患分析- 复查审批 罚款
     * @date  2020/3/25
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByFcspFk(@Param("tjrq") String tjrq);

    /**
     *  隐患分析- 复查审批 协调解决
     * @date  2020/3/25
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByFcspXt(@Param("tjrq") String tjrq);
    /**
     *  隐患分析- 隐患处置 当场整改
     * @date  2020/3/25
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByCzDczg(@Param("tjrq") String tjrq);
    /**
     *  隐患分析- 隐患处置 整改完成数
     * @date  2020/3/25
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByCzZgwcs(@Param("tjrq") String tjrq);
    /**
     *  隐患分析- 隐患处置 未完成量
     * @date  2020/3/25
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByCzWwcs(@Param("tjrq") String tjrq);
    /**
     *  重点单位分析-重点单位占比分析-所有区域数据
     * @date  2020/3/25
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByZddw(@Param("tjrq") String tjrq);
    /**
     *  重点单位分析-重点单位占比分析-top5
     * @date  2020/3/25
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByZddwLimit(@Param("tjrq") String tjrq);
    /**
     *  重点单位分析-隐患数量态势-全市 年份
     * @date  2020/3/25
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByYhYear(@Param("tjrq") String tjrq);
    /**
     *  重要设施分析-重要设施新增分析
     * @date  2020/3/26
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByZyssFx(@Param("tjrq") String tjrq);

    /**
     *  重要设施分析-重要设施新增分析  种类
     * @date  2020/3/27
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByZyssFxZl(HashMap map);

    /**
     *  重要设施分析-重要设施新增分析  总量
     * @date  2020/3/26
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findNumByZyssTotle(@Param("tjrq") String tjrq);

    /**
     *  重要设施分析-重点单位占比分析 等级
     * @date  2020/3/27
     * @param map
     * @return
     **/
    List<HashMap> findNumByDj(HashMap map);

    /**
     *  重要设施分析-重点单位占比分析 种类
     * @date  2020/3/27
     * @param map
     * @return
     **/
    List<HashMap> findNumByZddwZl(HashMap map);

    /**
     *  重要设施分析-重点单位营业状态监测 默认年份
     * @date  2020/3/26
     * @param tjrq 日期
     * @return
     **/
    List<HashMap> findDataByZddwYear(HashMap has);
    /**
     *  重要设施分析-重点单位营业状态监测 默认月份
     * @date  2020/3/27
     * @param has 日期
     * @return
     **/
    List<HashMap> findDataByZddwMonth(HashMap has);
    /**
     *  重要设施分析-重点单位营业状态监测 地区选择 月份
     * @date  2020/3/27
     * @param map
     * @return
     **/
    List<HashMap> findNumByZddwJcMonth(HashMap map);
    /**
     *  全面分析企事业单位  种类选择
     * @date  2020/3/30
     * @param map
     * @return
     **/
    List<HashMap> findNumByQmQsyLx(HashMap map);
    /**
     *  全面分析重要设施
     * @date  2020/3/30
     * @return
     **/
    List<HashMap> findNumByQmZyss();

    /**
     *  全面分析重要设施  种类选择
     * @date  2020/3/30
     * @param map
     * @return
     **/
    List<HashMap> findNumByQmZyssZl(HashMap map);

    /**
     *  全面分析 铸盾单位
     * @date  2020/3/30
     * @return
     **/
    List<HashMap> findNumByZdNum();
    /**
     *  全面分析 企事业单位默认月份数据
     * @date  2020/3/30
     * @return
     **/
    List<HashMap> findDataQsyMonth();

    /**
     *  全面分析 企事业单位默认年份数据
     * @date  2020/3/30
     * @return
     **/
    List<HashMap> findDataQsyYear();

    /**
     *  全面分析 企事业单位数据联调
     * @date  2020/3/31
     * @param name
     * @return
     **/
    List<HashMap> findDataQsyLtMonth(@Param("name") String name);

    /**
     *  全面分析 企事业单位数据联调
     * @date  2020/3/31
     * @param name
     * @return
     **/
    List<HashMap> findDataQsyLtYear(@Param("name") String name);
    /**
     * 重点设施-主动检查
     * @param map
     * @return
     */
    List<Map> zdssZdjc(Map map);
    /**
     *  重点单位分析-主动检查分析
     *  @author wujg
     *  @date 2020/3/30
     *  @return
     */
    List<HashMap> findNumByZddwjcfx(@Param("nf") String nf);
    /**
     *  重要设施分析-营业状态监测-按月/地区
     *  @author wujg
     *  @date 2020/3/30
     *  @return
     */
    List<HashMap> findNumByZyssslZlMonth(HashMap has);
    /**
     *  重要设施分析-营业状态监测-按年/地区
     *  @author wujg
     *  @date 2020/3/30
     * @param has
     *  @return
     */
    List<HashMap> findNumByZyssslZlYear(HashMap has);
    /**
     *  “铸盾”工程单位  年份数据
     *  @author wzj
     *  @date 2020/4/1
     * @param name
     *  @return
     */
    List<HashMap> findNumByZdgcYear(@Param("name")String name);
    /**
     *  “铸盾”工程单位  年份数据
     *  @author wzj
     *  @date 2020/4/1
     *  @return
     */
    List<HashMap> findNumByZdgcMRYear();

    /**
     *  重要设施单位数量  年份数据
     *  @author wzj
     *  @date 2020/4/1
     * @param name
     *  @return
     */
    List<HashMap> findNumByZyssYear(@Param("name")String name);

    /**
     *  重要设施单位数量  默认年份数据
     *  @author wzj
     *  @date 2020/4/1
     *  @return
     */
    List<HashMap> findNumByZyssMRYear();

    /**
     * 隐患数量分析
     * @param map
     * @return
     */
    List<Map> yhslfx(Map map);

    /**
     * 隐患数量分析-按月
     * @param map
     * @return
     */
    List<Map> yhslfxMonth(Map map);

    /**
     * 隐患数量分析-按年
     * @param map
     * @return
     */
    List<Map> yhslfxYear(Map map);
    }