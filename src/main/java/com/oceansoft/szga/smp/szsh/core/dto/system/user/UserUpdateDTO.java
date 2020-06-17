package com.oceansoft.szga.smp.szsh.core.dto.system.user;

import com.oceansoft.szga.smp.szsh.core.entity.system.SysRole;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @author wx
 * @version 2018/9/24
 */
@Data
public class UserUpdateDTO {

    @NotBlank(message = "用户名不能为空")
    @Pattern(regexp = "^(\\w){4,16}$",message = "用户名应为[A-Za-z0-9_]组成的4-16位字符！")
    private String username;

    @NotNull(message = "年龄不能为空")
    private Date age;

    @NotNull(message = "状态标识不能为空")
    private Integer status;

    //sj:市局    xfj:县分局（市局）   zxfj:县分局
//    @NotNull(message = "用户来源不能为空")
    private String source;

    @Size(min = 1, message = "请至少选择一个角色")
    private List<SysRole> roles;

}
