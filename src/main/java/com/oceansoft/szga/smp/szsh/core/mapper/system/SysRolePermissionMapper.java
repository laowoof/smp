package com.oceansoft.szga.smp.szsh.core.mapper.system;

import com.oceansoft.szga.smp.szsh.core.entity.system.SysRoleResource;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author wx
 * @version 2018/8/16/9:00
 */
@Mapper
@Repository
public interface SysRolePermissionMapper extends BaseMapper<SysRoleResource> {
}
