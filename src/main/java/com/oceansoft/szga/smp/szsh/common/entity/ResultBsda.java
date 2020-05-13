package com.oceansoft.szga.smp.szsh.common.entity;

import lombok.Data;

import java.util.List;

@Data
public class ResultBsda {

    private String prjguid;

    private Integer surveyStatus;

    private String Opinion;

    private List<FileResult> fileInfos;

}
