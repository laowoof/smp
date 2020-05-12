package com.oceansoft.szga.smp.szsh.core.entity.system;

import com.baomidou.mybatisplus.annotations.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CmOrg implements Serializable {

    private static final long serialVersionUID = 1686580600981273904L;

    @TableId
    private String id;

    private String orgName;

    private String createdBy;
    private Date createdDate;
    private String lastModifiedBy;
    private Date lastModifiedDate;

    private Long sort;
}
