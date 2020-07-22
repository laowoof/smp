package com.oceansoft.szga.smp.szsh.core.entity.system;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wx
 * 市局检查人员与监管事项关联表  事中 事后
 * @version 2018/9/18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("rpt.cm_user_case")
public class CmUsercase implements Serializable {

    private static final long serialVersionUID = 6084072770131032611L;

    @TableId
    private String id;
    private String caseId;
    private String caseName;
    private String userId;
    /**
     * 是否可用
     */
    private Integer available;
    /**
     * 关联类型： ‘sz’：事中监管人员； ‘sh’：事后监管人员
     */
    private String type;

    /**
     * 排序
     */
    private Long sort;


    private String createdBy;
    private Date createdDate;
    private String lastModifiedBy;
    private Date lastModifiedDate;

    //来源
    private String soutype;
}
