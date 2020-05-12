package com.oceansoft.szga.smp.szsh.core.mapper.system;

import com.oceansoft.szga.smp.szsh.core.entity.system.SysLog;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author wx
 * @version 2018/8/28/9:56
 */
@Mapper
@Repository
public interface SysLogMapper extends BaseMapper<SysLog> {
}
