package com.oceansoft.szga.smp.szsh.core.dto.system.org;

import com.oceansoft.szga.smp.szsh.core.dto.SplitPageDTO;
import lombok.Data;

/**
 * @author wx
 * 监管部门列表筛选条件
 * @version 2019/3/4
 */
@Data
public class FindOrgDTO extends SplitPageDTO {
    //部门名称
    private String orgName;

}
