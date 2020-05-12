package com.oceansoft.szga.smp.szsh.core.service.system.impl;

import com.oceansoft.szga.smp.szsh.common.exception.RequestException;
import com.oceansoft.szga.smp.szsh.core.config.jwt.JwtToken;
import com.oceansoft.szga.smp.szsh.core.dto.system.org.FindOrgDTO;
import com.oceansoft.szga.smp.szsh.core.entity.system.CmOrg;
import com.oceansoft.szga.smp.szsh.core.entity.system.CmShcaseOrg;
import com.oceansoft.szga.smp.szsh.core.mapper.system.CmOrgMapper;
import com.oceansoft.szga.smp.szsh.core.service.system.CmOrgService;
import com.oceansoft.szga.smp.szsh.core.service.system.CmShcaseOrgService;
import com.oceansoft.szga.smp.szsh.core.service.system.SysRoleService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CmOrgServiceImpl extends ServiceImpl<CmOrgMapper, CmOrg> implements CmOrgService {

    @Autowired
    private SysRoleService sysRoleService;


    @Autowired
    private CmShcaseOrgService shcaseOrgService;

    @Override
    public List<CmOrg> selectAllOrg(){
        EntityWrapper<CmOrg> wrapper=new EntityWrapper<>();
        wrapper.orderBy("sort",true);
        wrapper.orderBy("LAST_MODIFIED_DATE",false);
        return this.selectList(wrapper);
    }


    @Override
    public Page<CmOrg> getOrgListPage(FindOrgDTO findOrgDTO){
        EntityWrapper<CmOrg> wrapper = new EntityWrapper<>();
        wrapper.like("ORG_NAME",findOrgDTO.getOrgName());
        wrapper.orderBy("sort",!findOrgDTO.getAsc());
        wrapper.orderBy("LAST_MODIFIED_DATE",findOrgDTO.getAsc());
        return this.selectPage(new Page<>(findOrgDTO.getPage(),
                findOrgDTO.getPageSize()), wrapper);
    }


    @Override
    @Transactional(readOnly=true)
    public List<CmOrg> getOrgListByRole(){
        //获取角色所属警种
        JwtToken jwtToken = new JwtToken();
        BeanUtils.copyProperties(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal(),jwtToken);
        //获取角色所属部门
        String orgStr=sysRoleService.getRoleOrg(jwtToken.getUid());

        try {
            EntityWrapper<CmOrg> wrapper = new EntityWrapper<>();
            wrapper.in("id",orgStr);
            wrapper.orderBy("sort",true);
//            wrapper.orderBy("LAST_MODIFIED_DATE",true);
            return this.selectList(wrapper);
        }catch (Exception e){
            throw RequestException.fail("获取监管单位列表失败",e);
        }
    }


    @Override
    public void addOrg(CmOrg cmOrg){
        CmOrg co=this.findOrgByName(cmOrg.getOrgName());
        if(co!=null){
            throw RequestException.fail("此监管部门已存在！");
        }
        try{
            JwtToken jwtToken = new JwtToken();
            BeanUtils.copyProperties(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal(), jwtToken);

            cmOrg.setCreatedBy(jwtToken.getUid());
            cmOrg.setLastModifiedBy(jwtToken.getUid());
            cmOrg.setCreatedDate(new Date());
            cmOrg.setLastModifiedDate(new Date());
            this.insert(cmOrg);
        }catch (Exception e){
            throw RequestException.fail("监管部门添加失败",e);
        }

    }


    @Override
    public void updateOrg(CmOrg cmOrg){
        CmOrg co=this.selectById(cmOrg.getId());
        if(co==null){
            throw RequestException.fail("未找到此监管部门！");
        }
        try{
            JwtToken jwtToken = new JwtToken();
            BeanUtils.copyProperties(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal(), jwtToken);

            cmOrg.setLastModifiedBy(jwtToken.getUid());
            cmOrg.setLastModifiedDate(new Date());
            this.updateById(cmOrg);
        }catch (Exception e){
            throw RequestException.fail("监管部门变更失败",e);
        }
    }


    @Override
    public List<CmOrg> findOrgByShCaseId(String caseId){
        //获取关联
        List<CmShcaseOrg> shcaseOrgs =shcaseOrgService.selectList(
                new EntityWrapper<CmShcaseOrg>().eq("CASE_ID",caseId));

        //获取监管部门
        if(shcaseOrgs!=null){
            List<String> orgids=new ArrayList<>();
            shcaseOrgs.forEach(v->orgids.add(v.getDepartmentId()));
            if(orgids.size()==0){
                return null;
            }

            return this.selectList(new EntityWrapper<CmOrg>()
                    .in("id",orgids)
                    .orderBy("sort",true)
            );
        }
        return null;
    }


    /**
     * 根据名称查重
     * @param orgName
     * @return
     */
    private CmOrg findOrgByName(String orgName) {
        return this.selectOne(
                new EntityWrapper<CmOrg>().eq("ORG_NAME",orgName)
        );
    }

}
