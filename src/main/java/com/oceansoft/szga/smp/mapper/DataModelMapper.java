package com.oceansoft.szga.smp.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.oceansoft.szga.smp.config.domain.ApiQueryBase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/*
 * @author  zhangxh
 * @date  2020/7/22 10:26
 * @Email:zhangxh@oceansoft.com.cn
 */
@Mapper
public interface DataModelMapper {
    List<Map<String, Object>> selectPageJjaj(/*Page<Map<String, Object>> page,*/ ApiQueryBase query);

    List<Map<String, Object>> selectPageWxjs(/*Page<Map<String, Object>> page,*/ ApiQueryBase query);
}
