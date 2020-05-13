package com.oceansoft.szga.smp.szsh.common.entity;

import lombok.Data;

@Data
public class FileResult {

    private String filename;

    private String fileurl;

    //0图片、1视频、2其他
    private String filetype;

}
