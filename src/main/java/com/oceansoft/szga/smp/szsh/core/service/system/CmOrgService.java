package com.oceansoft.szga.smp.szsh.core.service.system;

import com.oceansoft.szga.smp.szsh.core.dto.system.org.FindOrgDTO;
import com.oceansoft.szga.smp.szsh.core.entity.system.CmOrg;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * @author wx
 * @version 2019/3/4
 */
public interface CmOrgService extends IService<CmOrg> {

    /**
     * 获取所有监管部门
     * @return 监管部门集合
     */
    List<CmOrg> selectAllOrg();

    /**
     * 分页获取监管部门
     * @param findOrgDTO 搜索条件
     * @return 监管部门集合
     */
    Page<CmOrg> getOrgListPage(FindOrgDTO findOrgDTO);

    /**
     * 按角色获取监管部门
     * @return 监管部门集合
     */
    List<CmOrg> getOrgListByRole();


    /**
     * 添加监管部门
     * @param cmOrg 监管部门数据
     */
    void addOrg(CmOrg cmOrg);



    /**
     * 分页获取监管部门
     * @param cmOrg 监管部门数据
     */
    void updateOrg(CmOrg cmOrg);

    /**
     * 根据事项ID获取部门
     * @param caseId 部门
     */
    List<CmOrg> findOrgByShCaseId(String caseId);

}
