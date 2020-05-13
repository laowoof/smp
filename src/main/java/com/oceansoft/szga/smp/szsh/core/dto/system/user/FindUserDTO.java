package com.oceansoft.szga.smp.szsh.core.dto.system.user;

import com.oceansoft.szga.smp.szsh.core.dto.SplitPageDTO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wx
 * @version 2018/9/18
 */
@Data
public class FindUserDTO extends SplitPageDTO implements Serializable {
    private String name;
}
