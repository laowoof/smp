package com.oceansoft.szga.smp.service;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import org.apache.ibatis.annotations.Mapper;

/**
 *  道路交通
 * @author wzj
 * @date 2020/4/20
 */

@Mapper
public interface RoadService {
    ApiResult test();
}

