package com.oceansoft.szga.smp.szsh.core.dto.system.userCase;

import com.oceansoft.szga.smp.szsh.core.dto.SplitPageDTO;
import lombok.Data;

/**
 * @author wx
 *  查询事后监管事项及监管部门
 * @version 2019/3/18
 */
@Data
public class FindShCaseDTO extends SplitPageDTO {

    //事项名称
    private String caseName;

    //警种id
    private String classId;

    //警种名称
//    private String className;

    //部门id
    private String orgId;

}
