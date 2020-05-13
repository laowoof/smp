package com.oceansoft.szga.smp.szsh.core.service.system;

import com.oceansoft.szga.smp.szsh.core.dto.system.log.FindLogDTO;
import com.oceansoft.szga.smp.szsh.core.entity.system.SysLog;
import com.oceansoft.szga.smp.szsh.common.service.QueryService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * @author wx
 * @version 2018/9/28/9:56
 */
public interface SysLogService extends IService<SysLog>,QueryService<SysLog, FindLogDTO>
{

    Page<SysLog> list(FindLogDTO findLogDTO);

    void remove(List<String> idList);

}
