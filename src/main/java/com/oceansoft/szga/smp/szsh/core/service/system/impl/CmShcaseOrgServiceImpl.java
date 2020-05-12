package com.oceansoft.szga.smp.szsh.core.service.system.impl;

import com.oceansoft.szga.smp.szsh.common.exception.RequestException;
import com.oceansoft.szga.smp.szsh.core.entity.system.CmOrg;
import com.oceansoft.szga.smp.szsh.core.entity.system.CmShcaseOrg;
import com.oceansoft.szga.smp.szsh.core.mapper.system.CmShcaseOrgMapper;
import com.oceansoft.szga.smp.szsh.core.service.system.CmShcaseOrgService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CmShcaseOrgServiceImpl extends ServiceImpl<CmShcaseOrgMapper, CmShcaseOrg> implements CmShcaseOrgService {

    @Override
    public void addShcaseOrg(String caseId, List<CmOrg> orgs){
        if(orgs!=null&&orgs.size()>0){
            try{
                orgs.forEach(v->this.insert(CmShcaseOrg.builder()
                        .id(UUID.randomUUID().toString())
                        .caseId(caseId)
                        .departmentId(v.getId()).build()
                ));
            }catch (Exception e){
                throw RequestException.fail("添加事后监管事项关联部门失败",e);
            }
        }
    }


    @Override
    public void deleteShcaseOrg(String caseId){
        EntityWrapper<CmShcaseOrg> wrapper=new EntityWrapper<>();
        wrapper.eq("case_id",caseId);
        try {
            this.delete(wrapper);
        }catch (Exception e){
            throw RequestException.fail("删除事后监管事项关联部门失败",e);
        }
    }

}
