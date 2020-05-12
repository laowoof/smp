package com.oceansoft.szga.smp.szsh.core.mapper.system;

import com.oceansoft.szga.smp.szsh.core.dto.system.role.FindRoleDTO;
import com.oceansoft.szga.smp.szsh.core.entity.system.SysRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 分页获取专家监管事项列表
     * @param findRoleDTO 查询条件
     * @return 事项集合
     */
    List<SysRole> getRoleListPage(Pagination page ,
                                           @Param("findRoleDTO") FindRoleDTO findRoleDTO);

}
