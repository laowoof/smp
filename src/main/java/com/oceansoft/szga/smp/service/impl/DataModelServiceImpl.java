package com.oceansoft.szga.smp.service.impl;

//import com.baomidou.mybatisplus.plugins.Page;

import com.baomidou.mybatisplus.plugins.Page;
import com.oceansoft.szga.smp.config.domain.ApiPager;
import com.oceansoft.szga.smp.config.domain.ApiQueryBase;
import com.oceansoft.szga.smp.mapper.DataModelMapper;
import com.oceansoft.szga.smp.service.DataModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/*
 * @author  zhangxh
 * @date  2020/7/22 10:24
 * @Email:zhangxh@oceansoft.com.cn
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DataModelServiceImpl implements DataModelService {
    @Autowired
    private DataModelMapper mapper;

    @Override
    public ApiPager pageJjaj(ApiQueryBase query) {

//        PageHelper.startPage(query.getPi(), query.getPs(), true);
//        Page<Map<String,Object>> page = (Page)mapper.selectPageJjaj(query);
//        return new ApiPager(query.getPs(), query.getPi(), page.getTotal(), page.getResult());

        Page<Map<String, Object>> page = new Page<>(query.getPi(), query.getPs());
        page.setRecords(mapper.selectPageJjaj(page, query));
        return new ApiPager<>(query.getPs(), query.getPi(), page.getTotal(), page.getRecords());
    }

    @Override
    public ApiPager pageWxjs(ApiQueryBase query) {
//        PageHelper.startPage(query.getPi(), query.getPs(), true);
//        Page<Map<String,Object>> page = (Page)mapper.selectPageWxjs(query);
//        return new ApiPager(query.getPs(), query.getPi(), page.getTotal(), page.getResult());
        Page<Map<String, Object>> page = new Page<>(query.getPi(), query.getPs());
        page.setRecords(mapper.selectPageWxjs(page, query));
        return new ApiPager<>(query.getPs(), query.getPi(), page.getTotal(), page.getRecords());
    }

    @Override
    public ApiPager jdry(ApiQueryBase query) {
        Page<Map<String, Object>> page = new Page<>(query.getPi(), query.getPs());
//         ,T1.PSON_WORKTYPE_GL as isgly  -- 是否管理人员，0否 1 是
//                ,T1.PSON_WORKTYPE_CZ  as isczy-- 是否操作员，0否 1 是
//                ,T1.PSON_WORKTYPE_BG  as isbgy-- 是否保管员，0否 1 是
//                ,T1.PSON_WORKTYPE_ZB  as iszabwy -- 是否治安保卫员，0否 1 是
//                ,T1.PSON_WORKTYPE_CG  as iscgy-- 是否采购员，0否 1 是
//                ,T1.PSON_WORKTYPE_QT  as isqt-- 是否其他类型人员，0否 1 是
        List<Map<String, Object>> jdry = mapper.jdry(page);

        page.setRecords(mapper.jdry(page));
        return new ApiPager<>(query.getPs(), query.getPi(), page.getTotal(), page.getRecords());
    }

    @Override
    public ApiPager stwhp(ApiQueryBase query) {
        Page<Map<String, Object>> page = new Page<>(query.getPi(), query.getPs());
        List<Map<String, Object>> jdry = mapper.stwhp(page);
        for (int i=0;i<jdry.size();i++){
            String rylb = "";
            if(String.valueOf(jdry.get(i).get("isgly")).equals("1")){
                rylb +="管理员,";
            }
            if(String.valueOf(jdry.get(i).get("isczy")).equals("1")){
                rylb +="操作员,";
            }
            if(String.valueOf(jdry.get(i).get("isbgy")).equals("1")){
                rylb +="保管员,";
            }
            if(String.valueOf(jdry.get(i).get("iszabwy")).equals("1")){
                rylb +="治安保卫员,";
            }
            if(String.valueOf(jdry.get(i).get("iscgy")).equals("1")){
                rylb +="采购员,";
            }
            if(String.valueOf(jdry.get(i).get("isqt")).equals("1")){
                rylb +="其他类型人员,";
            }
            if (rylb.length()>0){
                rylb =rylb.substring(0,rylb.length()-1);
            }
            jdry.get(i).put("rylb",rylb);
        }
        page.setRecords(jdry);
        return new ApiPager<>(query.getPs(), query.getPi(), page.getTotal(), page.getRecords());
    }
}
