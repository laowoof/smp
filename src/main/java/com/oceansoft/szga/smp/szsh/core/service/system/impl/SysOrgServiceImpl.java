package com.oceansoft.szga.smp.szsh.core.service.system.impl;

import com.oceansoft.szga.smp.szsh.core.entity.system.SysOrg;
import com.oceansoft.szga.smp.szsh.core.mapper.system.SysOrgMapper;
import com.oceansoft.szga.smp.szsh.core.service.system.SysOrgService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysOrgServiceImpl extends ServiceImpl<SysOrgMapper, SysOrg> implements SysOrgService {

    @Override
    public List<SysOrg> getClassAlllist(){
        EntityWrapper<SysOrg> wrapper=new EntityWrapper<>();
        wrapper.orderBy("guid",true);
        return this.selectList(wrapper);
    }

}
