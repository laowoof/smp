package com.oceansoft.szga.smp.szsh.core.entity.system;

import com.baomidou.mybatisplus.annotations.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CmShcaseOrg implements Serializable {

    private static final long serialVersionUID = -3812088661192638315L;

    @TableId
    private String id;

    private String caseId;

    private String  departmentId;

}
