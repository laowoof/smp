package com.oceansoft.szga.smp.mapper;

import com.oceansoft.szga.smp.entity.SourceNum;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @author wzj
 * @create 2020/4/20
 * @email wzj@oceansoft.com.cn
 */
@Repository
public interface RoadMapper {
    List<HashMap> test();

    List<HashMap> getAddress();

    HashMap getSourceSum(SourceNum sourceNum);

    List<HashMap> getFirmAnalzeSum(SourceNum sourceNum);
}
