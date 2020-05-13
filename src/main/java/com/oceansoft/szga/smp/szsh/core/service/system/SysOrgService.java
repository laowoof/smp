package com.oceansoft.szga.smp.szsh.core.service.system;

import com.oceansoft.szga.smp.szsh.core.entity.system.SysOrg;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

public interface SysOrgService extends IService<SysOrg> {

    /**
     * 获取警种列表
     * @return 警种列表
     */
    List<SysOrg> getClassAlllist();

}
