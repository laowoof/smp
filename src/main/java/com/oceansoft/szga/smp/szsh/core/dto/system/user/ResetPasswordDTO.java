package com.oceansoft.szga.smp.szsh.core.dto.system.user;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

/**
 * @author wx
 * @version 2018/9/25
 */
@Data
public class ResetPasswordDTO {

    @NotBlank(message = "用户标识ID不能为空")
    private String userid;

    @NotBlank(message = "新密码不能为空")
    @Pattern(regexp = "^(\\w){6,18}$",message = "密码应为[A-Za-z0-9_]组成的6-18位字符！")
    private String password;

}
