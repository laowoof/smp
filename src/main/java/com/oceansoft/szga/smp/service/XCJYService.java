package com.oceansoft.szga.smp.service;

import com.oceansoft.szga.smp.config.domain.ApiResult;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.GetMapping;

@Mapper
public interface XCJYService {
    /**
     * 统计 基础信息
     * @author pc
     * @return 数据
     */
    ApiResult totalNum(String param, String start ,String end);

    /**
     * 统计 基础底数
     * @author pc
     * @return 数据
     */
    ApiResult JCDSNum(String param, String start ,String end);

    /**
     * 单位宣传进度完成情况
     * @author pc
     * @return 数据
     */
    ApiResult Unitpublicity(String param, String start ,String end);

    /**
     * 八进宣传任务
     * @author pc
     * @return 数据
     */
    ApiResult PublicityTasks(String param, String start ,String end,String dd);

    /**
     * 民警宣传
     * @author pc
     * @return 数据
     */
    ApiResult PromotionalRate(String param, String start ,String end,String dd);

    /**
     * 大队名称集合
     * @author pc
     * @return 数据
     */
    ApiResult DDMC();

}
