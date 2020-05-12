package com.oceansoft.szga.smp.szsh.core.dto.system.userCase;

import com.oceansoft.szga.smp.szsh.core.entity.system.CmCase;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @author wx
 * 事中监管新增用户事项关联
 * @version 2018/9/24
 */
@Data
public class UsercaseSzAddDTO {

    @NotBlank(message = "用户名不能为空")
    @Pattern(regexp = "^(\\w){4,16}$",message = "用户名应为[A-Za-z0-9_]组成的4-16位字符！")
    private String username;


    @NotNull(message = "年龄不能为空")
    private Date age;

//    @NotNull(message = "状态标识不能为空")
    //private Integer available;

    @NotNull(message = "真实姓名不能为空")
    private String name;
    private String departmentName;
    private Integer sex;
//    private String departmentId;
    private String description;

    //职务
    //private String category;
    //警号
//    private String userNo;
    //联系方式
    private String contact;
    //上一次监管日期
//    private Data lastDate;
    //警察证到期日期
//    private Data expireDate;
    //培训情况
//    private String training;


    @Size(min = 1, message = "请至少选择一个监管事项")
    private List<CmCase> cases;


}
