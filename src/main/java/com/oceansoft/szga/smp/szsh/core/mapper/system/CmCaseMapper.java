package com.oceansoft.szga.smp.szsh.core.mapper.system;

import com.oceansoft.szga.smp.szsh.core.dto.system.userCase.FindShCaseDTO;
import com.oceansoft.szga.smp.szsh.core.entity.system.CmCase;
import com.oceansoft.szga.smp.szsh.core.vo.system.ShCaseV0;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CmCaseMapper extends BaseMapper<CmCase> {

    /**
     * 获取指定类型 和警种部门的所有事项 县分局
     * @param className 警种名称
     * @param orgID 部门ID
     * @return 事项集合
     */
//    List<CmCase> classRoleOrglistXfj(@Param("className")String className,
//                                                @Param("orgID")String orgID);



    /**
     * 获取指定类型 和警种部门的所有事项
     * @param className 警种名称
     * @param orgID 部门ID
     * @return 事项集合
     */
    List<CmCase> classRoleOrglist(@Param("className")String className,
                                  @Param("orgID")String orgID);




    /**
     * 获取指定警种部门的所有事项
     * @param className 警种名称
     * @param orgID 部门ID
     * @return 事项集合
     */
    List<CmCase> classRoleOrglistByOrgID(@Param("className")String className,
                                  @Param("orgID")String orgID);



    /**
     * 分页获取事后监管事项列表
     * @param findShCaseDTO 查询条件
     * @return 事项集合
     */
    List<ShCaseV0> getShCaseListPage(Pagination page ,
                                     @Param("findShCaseDTO") FindShCaseDTO findShCaseDTO);

}
