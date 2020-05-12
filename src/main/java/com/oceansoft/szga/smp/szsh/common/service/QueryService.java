package com.oceansoft.szga.smp.szsh.common.service;

import com.baomidou.mybatisplus.plugins.Page;

/**
 * @author wx
 * @version 2018/9/25/13:14
 * @see BaseService 注释配置请参见BaseService
 */
public interface QueryService<E,FD> {

    Page<E> list(FD findDTO);

}
