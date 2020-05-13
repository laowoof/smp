package com.oceansoft.szga.smp.szsh.core.dto.system.role;

import com.oceansoft.szga.smp.szsh.core.entity.system.SysResource;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author wx
 * @version 2018/9/19
 */
@Data
public class RoleUpdateDTO {

    @NotBlank(message = "姓名不能为空")
    private String name;

    //管理警种名称
    private String className;

    //管理部门id
    private String orgId;

    @Size(min = 1,message = "请至少选择一个权限资源")
    private List<SysResource> resources;

}
