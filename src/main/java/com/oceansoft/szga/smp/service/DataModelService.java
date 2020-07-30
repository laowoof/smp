package com.oceansoft.szga.smp.service;

import com.oceansoft.szga.smp.config.domain.ApiPager;
import com.oceansoft.szga.smp.config.domain.ApiQueryBase;

/*
 * @author  zhangxh
 * @date  2020/7/22 10:24
 * @Email:zhangxh@oceansoft.com.cn
 */public interface DataModelService {
    ApiPager pageJjaj(ApiQueryBase query);

    ApiPager pageWxjs(ApiQueryBase query);

    ApiPager jdry(ApiQueryBase query);

    ApiPager stwhp(ApiQueryBase query);
}
