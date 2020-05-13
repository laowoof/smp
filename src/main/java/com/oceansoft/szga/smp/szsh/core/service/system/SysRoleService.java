package com.oceansoft.szga.smp.szsh.core.service.system;

import com.oceansoft.szga.smp.szsh.core.dto.system.role.FindRoleDTO;
import com.oceansoft.szga.smp.szsh.core.dto.system.role.RoleAddDTO;
import com.oceansoft.szga.smp.szsh.core.dto.system.role.RoleUpdateDTO;
import com.oceansoft.szga.smp.szsh.core.entity.system.SysRole;
import com.oceansoft.szga.smp.szsh.common.service.BaseService;
import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

public interface SysRoleService extends IService<SysRole>,
        BaseService<SysRole, RoleAddDTO, RoleUpdateDTO,String, FindRoleDTO> {

    /**
     * 获取指定ID用户的所有角色（并附带查询所有的角色的权限）
     * @param uid 用户ID
     * @return 角色集合
     */
    List<SysRole> findAllRoleByUserId(String uid,Boolean hasResource);

    /**
     * 更新缓存
     * @param role 角色
     * @param author 是否清空授权信息
     * @param out 是否清空session
     */
    void updateCache(SysRole role,Boolean author, Boolean out);

    /**
     * 获取角色所属警种
     * @param uid 用户id
     */
    String getRoleClass(String uid);

    /**
     * 获取角色所属部门
     * @param uid 用户id
     */
    String getRoleOrg(String uid);


    /**
     * 获取所有角色
     * @param findRoleDTO 搜索条件
     * @return 角色集合
     */
    Page<SysRole> getRoleListPage(FindRoleDTO findRoleDTO);
}
