package com.oceansoft.szga.smp.service;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import org.apache.ibatis.annotations.Mapper;


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
}

