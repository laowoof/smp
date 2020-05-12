package com.oceansoft.szga.smp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @author pc
 * @create 2020/4/21
 * @email wzj@oceansoft.com.cn
 */
@Repository
public interface XCJYMapper {

    /**
     *  基础信息 采集单位总数
     * @param hashMap
     * @return
     */
    Integer totalNumCJDW(HashMap<String,Object> hashMap);

    /**
     *  基础信息 宣传总数
     * @param hashMap
     * @return
     */
    Integer totalNumXCZS(HashMap<String,Object> hashMap);


    /**
     *  基础底数
     * @param hashMap
     * @return
     */
    List<HashMap> JCDUNum(HashMap<String,Object> hashMap);

    /**
     *  单位宣传进度
     * @param hashMap
     * @return
     */
    List<HashMap> Unitpublicity(HashMap<String,Object> hashMap);


    /**
     * 八进宣传任务
     * @author pc
     * @return 数据
     */
    List<HashMap> PublicityTasks(HashMap<String,Object> hashMap);

    /**
     * 民警宣传
     * @author pc
     * @return 数据
     */

    List<HashMap> PromotionalRate(HashMap<String,Object> hashMap);

    /**
     * 大队名称集合
     * @author pc
     * @return 数据
     */

    List<HashMap> DDMC();
}
