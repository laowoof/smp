package com.oceansoft.szga.smp.szsh.core.dto;

import lombok.Data;

/**
 * @author wx
 * @version 2018/9/18/14:17
 */
@Data
public abstract class SplitPageDTO {

    private Integer page = 1;

    private Integer pageSize = 10;

    private Boolean asc = false;

}
