package com.oceansoft.szga.smp.szsh.core.service.system.impl;

import com.oceansoft.szga.smp.szsh.core.dto.system.role.FindRoleDTO;
import com.oceansoft.szga.smp.szsh.core.dto.system.role.RoleAddDTO;
import com.oceansoft.szga.smp.szsh.core.dto.system.role.RoleUpdateDTO;
import com.oceansoft.szga.smp.szsh.core.entity.system.SysResource;
import com.oceansoft.szga.smp.szsh.core.entity.system.SysRole;
import com.oceansoft.szga.smp.szsh.core.entity.system.SysRoleResource;
import com.oceansoft.szga.smp.szsh.core.entity.system.SysUserRole;
import com.oceansoft.szga.smp.szsh.core.mapper.system.SysRoleMapper;
import com.oceansoft.szga.smp.szsh.core.service.global.ShiroService;
import com.oceansoft.szga.smp.szsh.core.service.system.SysRoleResourceService;
import com.oceansoft.szga.smp.szsh.core.service.system.SysRoleService;
import com.oceansoft.szga.smp.szsh.core.service.system.SysUserRoleService;
import com.oceansoft.szga.smp.szsh.common.exception.RequestException;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysRoleResourceService roleResourceService;

    @Autowired
    private SysUserRoleService userRoleService;

    @Autowired
    private ShiroService shiroService;

    @Override
    public List<SysRole> findAllRoleByUserId(String uid,Boolean hasResource) {
        List<SysUserRole> userRoles = userRoleService.selectList(new EntityWrapper<SysUserRole>().eq("userid", uid));
        List<SysRole> roles = new ArrayList<>();
        userRoles.forEach(v->{
            SysRole role = this.selectById(v.getRid());
            if(role!=null){
                if(hasResource){
                    List<SysResource> permissions = roleResourceService.findAllResourceByRoleId(role.getId());
                    role.setResources(permissions);
                }
            }
            roles.add(role);
        });
        return roles;
    }

    @Override
    public Page<SysRole> list(FindRoleDTO findRoleDTO) {
        EntityWrapper<SysRole> wrapper = new EntityWrapper<>();
        wrapper.orderBy("id",findRoleDTO.getAsc());
        Page<SysRole> rolePage = this.selectPage(new Page<>(findRoleDTO.getPage(),
                findRoleDTO.getPageSize()), wrapper);
        if(findRoleDTO.getHasResource()){
            if(rolePage.getRecords()!=null){
                rolePage.getRecords().forEach(v->
                        v.setResources(roleResourceService.findAllResourceByRoleId(v.getId())));
            }
        }
        return rolePage;
    }

    @Override
    public void remove(String rid) {
        SysRole role = this.selectById(rid);
        if(role==null) throw RequestException.fail("角色不存在！");
        try {
            this.deleteById(rid);
            this.updateCache(role,true,false);
        }catch (DataIntegrityViolationException e){
            throw RequestException.fail(
                    String.format("请先解除角色为 %s 角色的全部用户！",role.getName()),e);
        }catch (Exception e){
            throw RequestException.fail("角色删除失败！",e);
        }
    }

    @Override
    public void update(String rid, RoleUpdateDTO roleUpdateDTO) {
        SysRole role = this.selectById(rid);
        if(role==null) throw RequestException.fail("角色不存在！");
        BeanUtils.copyProperties(roleUpdateDTO,role);
        try {
            this.updateById(role);
            roleResourceService.delete(new EntityWrapper<SysRoleResource>()
                    .eq("rid",rid));
            for (SysResource sysResource : roleUpdateDTO.getResources()) {
                roleResourceService.insert(SysRoleResource.builder()
                        .pid(sysResource.getId())
                        .rid(role.getId())
                        .build());
            }
            this.updateCache(role,true,false);
        }catch (Exception e){
            throw RequestException.fail("角色更新失败！",e);
        }

    }

    @Override
    public void add(RoleAddDTO addDTO) {
        SysRole role = this.selectOne(new EntityWrapper<SysRole>().eq("name",addDTO.getName()));
        if(role!=null){
            throw RequestException.fail(
                    String.format("已经存在名称为 %s 的角色",addDTO.getName()));
        }
        role = new SysRole();
        BeanUtils.copyProperties(addDTO,role);
        try {
            this.insert(role);
            for (SysResource sysResource : addDTO.getResources()) {
                roleResourceService.insert(SysRoleResource.builder()
                        .pid(sysResource.getId())
                        .rid(role.getId())
                        .build());
            }
        }catch (Exception e){
            throw RequestException.fail("添加失败",e);
        }
    }

    @Override
    public void updateCache(SysRole role,Boolean author, Boolean out) {
        List<SysUserRole> sysUserRoles = userRoleService.selectList(new EntityWrapper<SysUserRole>()
                .eq("rid", role.getId()));
                //.groupBy("userid"));
        List<String> userIdList = new ArrayList<>();
        if(sysUserRoles!=null && sysUserRoles.size()>0){
            sysUserRoles.forEach(v-> userIdList.add(v.getUserid()));
        }
        shiroService.clearAuthByUserIdCollection(userIdList,author,out);
    }


    @Override
    public String getRoleClass(String uid){
        List<SysRole> roles=this.findAllRoleByUserId(uid,false);
        StringBuilder classBuilder=new StringBuilder();
        roles.forEach(v->{
            if(!StringUtils.isEmpty(v.getClassName())){
                classBuilder.append(v.getClassName());
                classBuilder.append(',');
            }
        });
        String classStr=classBuilder.toString();
        if(StringUtils.isEmpty(classStr)){
            return classStr;
        }
        return classStr.substring(0,classStr.length()-1);
    }


    @Override
    public String getRoleOrg(String uid){
        List<SysRole> roles=this.findAllRoleByUserId(uid,false);
        StringBuilder orgBuilder=new StringBuilder();
        roles.forEach(v->{
            if(!StringUtils.isEmpty(v.getOrgId())){
                orgBuilder.append(v.getOrgId());
                orgBuilder.append(',');
            }
        });
        String orgStr=orgBuilder.toString();
        if(StringUtils.isEmpty(orgStr)){
            return orgStr;
        }
        return orgStr.substring(0,orgStr.length()-1);
    }


    @Override
    public Page<SysRole> getRoleListPage(FindRoleDTO findRoleDTO){
        Page<SysRole> page=new Page<>(findRoleDTO.getPage(),findRoleDTO.getPageSize());
        try {
            page.setRecords(this.baseMapper.getRoleListPage(page,
                    findRoleDTO));
            if(findRoleDTO.getHasResource()){
                if(page.getRecords()!=null){
                    page.getRecords().forEach(v->
                            v.setResources(roleResourceService.findAllResourceByRoleId(v.getId())));
                }
            }
            return page;
        }catch (Exception e){
            throw RequestException.fail("获取角色列表失败",e);
        }
    }
}
