package com.oceansoft.szga.smp.szsh.core.entity.system;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CmCase implements Serializable {

    private static final long serialVersionUID = -8792749020905431845L;

    @TableId
    private String id;
    private String caseName;
    private String orgId;
    private String orgName;
    private String caseType;

    private String createdBy;
    private Date createdDate;
    private String lastModifiedBy;
    private Date lastModifiedDate;

    private Long sort;

    /**
     * 是否市局
     */
//    private Integer isSj;

    /**
     * 是否可用
     */
    @TableField(exist = false)
    private Integer available=1;

    /**
     * 事后事项监管部门
     */
    @TableField(exist = false)
    private List<CmOrg> orgs;
}
