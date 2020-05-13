package com.oceansoft.szga.smp.szsh.core.dto.system.userCase;

import com.oceansoft.szga.smp.szsh.core.dto.SplitPageDTO;
import lombok.Data;

/**
 * @author wx
 *  用户事项关联列表条件
 * @version 2018/9/18
 */
@Data
public class FindUsercaseDTO extends SplitPageDTO {
    
    private String type;
    
    private String userName;
    
    private String caseName;
}
