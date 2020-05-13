package com.oceansoft.szga.smp.szsh.core.vo.system;

import com.oceansoft.szga.smp.szsh.core.entity.system.CmOrg;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;

import java.util.List;

/**
 * @author wx
 * @Description 获取事后监管事项列表及其监管部门
 * @version 2019/03/18
 */
@Data
public class ShCaseV0 {

    @TableId
    private String id;
    private String caseName;
    private String classId;
    private String className;
    private String caseType;

    private Long sort;

    private Integer isSj;

    //监管部门
    private List<CmOrg> orgs;

}
