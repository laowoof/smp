package com.oceansoft.szga.smp.szsh.core.service.system;

import com.oceansoft.szga.smp.szsh.core.dto.system.userCase.FindShCaseDTO;
import com.oceansoft.szga.smp.szsh.core.entity.system.CmCase;
import com.oceansoft.szga.smp.szsh.core.vo.system.ShCaseV0;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * @author wx
 * @version 2018/9/20
 */
public interface CmCaseService extends IService<CmCase>{
    /**
     * 获取指定类型的所有事项
     * @param type 事项类型  'sz'事中   'sh'事后
     * @return 事项集合
     */
    List<CmCase> list(String type);



    /**
     * 获取指定类型 和警种部门的所有事项
     * @return 事项集合
     */
    List<CmCase> classRoleOrglist();


    /**
     * 获取指定警种部门的所有事项
     * @param orgID 部门id
     * @return 事项集合
     */
    List<CmCase> classRoleOrglist(String orgID);



    /**
     * 获取指定类型 和警种部门的所有事项 县分局
     * @return 事项集合
     */
//    List<CmCase> classRoleOrglistXfj();



    /**
     * 根据ID获取指定类型的事项
     * @param caseId 事项id
     * @return 事项集合
     */
//    CmCase selectCaseById(String caseId);


    /**
     * 查询事后监管事项及监管部门
     * @param findShCaseDTO 查询条件
     * @return 事项集合
     */
    Page<ShCaseV0> getShCaseListPage(FindShCaseDTO findShCaseDTO);


    /**
     * 添加事后监管事项
     * @param shCase 事后监管事项数据
     */
    void addShCase(CmCase shCase);


    /**
     * 变更事后监管事项
     * @param shCase 事后监管事项数据
     */
    void updateShCase(CmCase shCase);

}
