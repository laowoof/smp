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
public class CmAttachment implements Serializable {

    private static final long serialVersionUID = 8585340817741769898L;

    @TableId
    private String id;
    private String projectId;
    private String fileName;

    private String identifier;

    private String type;

    private Integer totalSize;

    private String filePath;

    private String fileAliasName;

    private String location;

    private String createdBy;
    private Date createdDate;
//    private String lastModifiedBy;
//    private Date lastModifiedDate;
}
