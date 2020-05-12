package com.oceansoft.szga.smp.szsh.core.dto.system.role;

import com.oceansoft.szga.smp.szsh.core.dto.SplitPageDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wx
 * @version 2018/9/19
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FindRoleDTO extends SplitPageDTO {

    private Boolean hasResource = true;

    private String name;

}
