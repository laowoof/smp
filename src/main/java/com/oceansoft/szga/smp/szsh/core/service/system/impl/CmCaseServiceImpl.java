package com.oceansoft.szga.smp.szsh.core.service.system.impl;

import com.oceansoft.szga.smp.szsh.common.exception.RequestException;
import com.oceansoft.szga.smp.szsh.core.config.jwt.JwtToken;
import com.oceansoft.szga.smp.szsh.core.dto.system.userCase.FindShCaseDTO;
import com.oceansoft.szga.smp.szsh.core.service.system.CmCaseService;
import com.oceansoft.szga.smp.szsh.core.entity.system.CmCase;
import com.oceansoft.szga.smp.szsh.core.mapper.system.CmCaseMapper;
import com.oceansoft.szga.smp.szsh.core.service.system.CmOrgService;
import com.oceansoft.szga.smp.szsh.core.service.system.CmShcaseOrgService;
import com.oceansoft.szga.smp.szsh.core.service.system.SysRoleService;
import com.oceansoft.szga.smp.szsh.core.vo.system.ShCaseV0;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CmCaseServiceImpl extends ServiceImpl<CmCaseMapper, CmCase> implements CmCaseService {

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private CmOrgService orgService;

    @Autowired
    private CmShcaseOrgService shcaseOrgService;

    @Override
    public List<CmCase> list(String type)
    {
        //获取事项
        EntityWrapper<CmCase> wrapper=new EntityWrapper<>();
        wrapper.eq("case_type",type);

        wrapper.orderBy("sort",true);

        List<CmCase> resources = this.selectList(wrapper);

        return resources;
    }


    @Override
    public List<CmCase> classRoleOrglist()
    {
        //根据角色获取事项
        JwtToken jwtToken = new JwtToken();
        BeanUtils.copyProperties(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal(),jwtToken);
        //获取角色警种
        String classStr=sysRoleService.getRoleClass(jwtToken.getUid());

        //获取角色部门
        String orgStr=sysRoleService.getRoleOrg(jwtToken.getUid());

        try {
//            if(StringUtils.isEmpty(orgStr)){//市局
                return this.baseMapper.classRoleOrglist(classStr,orgStr);
//            }else{//县分局
//                return this.baseMapper.classRoleOrglistXfj(classStr.toString(), orgStr.toString());
//            }


        }catch (Exception e){
            throw RequestException.fail("获取监管事项列表失败",e);
        }
    }




    @Override
    public List<CmCase> classRoleOrglist(String orgID){
        //根据角色获取事项
        JwtToken jwtToken = new JwtToken();
        BeanUtils.copyProperties(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal(),jwtToken);
        //获取角色警种
        String classStr=sysRoleService.getRoleClass(jwtToken.getUid());

        //获取角色部门
//        String orgStr=sysRoleService.getRoleOrg(jwtToken.getUid());

        try {
            return this.baseMapper.classRoleOrglistByOrgID(classStr,orgID);
        }catch (Exception e){
            throw RequestException.fail("获取监管事项列表失败",e);
        }
    }


//    @Override
//    public List<CmCase> classRoleOrglistXfj()
//    {
//        //根据角色获取事项
//        JwtToken jwtToken = new JwtToken();
//        BeanUtils.copyProperties(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal(),jwtToken);
//        //获取角色警种
//        StringBuilder classStr=sysRoleService.getRoleClass(jwtToken.getUid());
//
//        //获取角色部门
//        StringBuilder orgStr=sysRoleService.getRoleOrg(jwtToken.getUid());
//
//
//        try {
//            return this.baseMapper.classRoleOrglistXfj(classStr.toString(), orgStr.toString());
//        }catch (Exception e){
//            throw RequestException.fail("获取监管事项列表失败",e);
//        }
//    }




//    @Override
//    public CmCase selectCaseById(String caseId){
//        return this.selectById(caseId);
//    }


    @Override
    @Transactional(readOnly=true)
    public Page<ShCaseV0> getShCaseListPage(FindShCaseDTO findShCaseDTO){
        Page<ShCaseV0> page=new Page<>(findShCaseDTO.getPage(),findShCaseDTO.getPageSize());
        try {
            page.setRecords(this.baseMapper.getShCaseListPage(
                    page, findShCaseDTO));

            //获取监管部门
            if(page.getRecords()!=null){
                page.getRecords().forEach(v->
                        v.setOrgs(orgService.findOrgByShCaseId(v.getId()))
                );
            }
            return  page;
        }catch (Exception e){
            throw RequestException.fail("获取事后监管事项失败",e);
        }
    }


    @Override
    public void addShCase(CmCase shCase){
        CmCase findCase=this.selectOne(
                new EntityWrapper<CmCase>().eq("case_name",shCase.getCaseName())
        .eq("case_type",shCase.getCaseType()));

        if(findCase!=null){
            throw RequestException.fail(
                    String.format("已经存在名为 %s 的事后监管事项", shCase.getCaseName()));
        }

        JwtToken jwtToken = new JwtToken();
        BeanUtils.copyProperties(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal(),jwtToken);

        try{
            findCase = new CmCase();
            BeanUtils.copyProperties(shCase,findCase);
            findCase.setId(UUID.randomUUID().toString());
            findCase.setCreatedDate(new Date());
            findCase.setLastModifiedDate(new Date());
            findCase.setCreatedBy(jwtToken.getUid());
            findCase.setLastModifiedBy(jwtToken.getUid());
            this.insert(findCase);
            //关联监管部门
            shcaseOrgService.addShcaseOrg(findCase.getId(),findCase.getOrgs());
        }catch (Exception e){
            throw RequestException.fail("添加事后监管事项失败",e);
        }

    }


    @Override
    public void updateShCase(CmCase shCase){
        CmCase findCase=this.selectById(shCase.getId());

        if(findCase==null){
            throw RequestException.fail(
                    String.format("未找到名为 %s 的事后监管事项", shCase.getCaseName()));
        }

        JwtToken jwtToken = new JwtToken();
        BeanUtils.copyProperties(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal(),jwtToken);

        try{
            BeanUtils.copyProperties(shCase,findCase);
            findCase.setLastModifiedDate(new Date());
            findCase.setLastModifiedBy(jwtToken.getUid());
            this.updateById(findCase);
            //删除现有关联部门
            shcaseOrgService.deleteShcaseOrg(findCase.getId());
            //关联监管部门
            shcaseOrgService.addShcaseOrg(findCase.getId(),findCase.getOrgs());
        }catch (Exception e){
            throw RequestException.fail("添加事后监管事项失败",e);
        }
    }


}
