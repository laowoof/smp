package com.oceansoft.szga.smp.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author zhangxh
 * @create 2020/1/14
 * @email zhangxh@oceansoft.com.cn
 */
@Repository
public interface TestMapper {
    List<Map> list();
    List<Map> test();
}
