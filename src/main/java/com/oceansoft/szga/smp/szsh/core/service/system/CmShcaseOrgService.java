package com.oceansoft.szga.smp.szsh.core.service.system;


import com.oceansoft.szga.smp.szsh.core.entity.system.CmOrg;
import com.oceansoft.szga.smp.szsh.core.entity.system.CmShcaseOrg;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * @author wx
 * @version 2018/9/20
 */
public interface CmShcaseOrgService extends IService<CmShcaseOrg> {

    /**
     * 新增事后监管事项与部门关联
     * @param caseId 事后监管事项标识
     * @param orgs 关联部门
     * @return
     */
    void addShcaseOrg(String caseId, List<CmOrg> orgs);

    /**
     * 删除事后监管事项与部门关联
     * @param caseId 事后监管事项标识
     * @return
     */
    void deleteShcaseOrg(String caseId);

}
