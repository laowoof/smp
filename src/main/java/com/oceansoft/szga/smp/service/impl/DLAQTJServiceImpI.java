package com.oceansoft.szga.smp.service.impl;

import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.entity.YTRW;
import com.oceansoft.szga.smp.mapper.DLAQTJMapper;
import com.oceansoft.szga.smp.service.DLAQTJService;
import com.oceansoft.szga.smp.util.ParamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author ：pc
 * @date ：Created in 2020/4/24 14:57
 * @description： 统计分析/道路安全统计分析
 * @modified By：
 * @version: $
 */
@Service
public class DLAQTJServiceImpI implements DLAQTJService {


    @Autowired
    private DLAQTJMapper dlaqtjMapper;


    /**
     * 源头底数统计
     * @author pc
     * @return  year
     */
    @Override
    public ApiResult YTDSTJ(String param,String date) {
        //参数检验
        HashMap hashMap = ParamUtils.ytdstjparsingParam(param, date);
        if(hashMap==null){
            return new ApiResult().failure("数据错误！！！！");
        }
        List<HashMap> data=dlaqtjMapper.YTDSTJ(hashMap);
        return  new ApiResult().success(200, "成功", data);
    }

    /**
     * 源头任务统计
     * @author pc
     * @return  year
     */
    @Override
    public ApiResult YTRWTJ(String param,String choiceDate) {
        //参数检验
        HashMap hashMap = ParamUtils.dlaqtjparsingParam(param, choiceDate);
        if(hashMap==null){
            return new ApiResult().failure("数据错误！！！！");
        }
        List<YTRW> data=dlaqtjMapper.YTRWTJ(hashMap);
        return  new ApiResult().success(200, "成功", data);
    }

    /**
     * 源头任务统计 子项
     * @author pc
     * @return  year
     */
    @Override
    public ApiResult YTRWTJZX(String param,String choiceDate,String name) {
        //参数检验
        HashMap hashMap = ParamUtils.dlaqtjparsingParam(param, choiceDate,name);
        if(hashMap==null){
            return new ApiResult().failure("数据错误！！！！");
        }
        List<YTRW> data=dlaqtjMapper.YTRWTJZX(hashMap);
        for(YTRW ytrw: data){
            ytrw.setHasChildren(false);
        }
        return  new ApiResult().success(200, "成功", data);
    }

    /**
     * 隐患完成情况统计
     * @author pc
     */
    @Override
    public ApiResult YHWCQKTJ(String param,String choiceDate,String status) {
        //参数检验
        HashMap hashMap = ParamUtils.yhwcqktjparsingParam(param, choiceDate,status);
        if(hashMap==null){
            return new ApiResult().failure("数据错误！！！！");
        }
        List<HashMap> data = dlaqtjMapper.YHWCQKTJ(hashMap);
        return  new ApiResult().success(200, "成功", data);
    }

    /**
     * 隐患完成情况统计 子项
     * @author pc
     */
    @Override
    public ApiResult YHWCQKTJZX(String param,String choiceDate,String status,String name) {
        //参数检验
        HashMap hashMap = ParamUtils.yhwcqktjparsingParam(param, choiceDate,status,name);
        if(hashMap==null){
            return new ApiResult().failure("数据错误！！！！");
        }
        List<HashMap> data = dlaqtjMapper.YHWCQKTJZX(hashMap);
        return  new ApiResult().success(200, "成功", data);
    }


    /**
     * 隐患类型统计
     * @author pc
     */
    @Override
    public ApiResult YHLXTJ(String param,String choiceDate,String status) {
        //参数检验
        HashMap hashMap = ParamUtils.yhlxtjparsingParam(param, choiceDate, status);
        if(hashMap==null){
            return new ApiResult().failure("数据错误！！！！");
        }
        List<HashMap> data = dlaqtjMapper.YHLXTJ(hashMap);
        return  new ApiResult().success(200, "成功", data);

    }

    /**
     * 八进宣传统计
     * @author pc
     */
    @Override
    public ApiResult BJXCTJ(String param,String start,String end) {
        //参数检验
        HashMap hashMap = ParamUtils.bjxctjparsingParam(param, start, end);
        if(hashMap==null){
            return new ApiResult().failure("数据错误！！！！");
        }
        List<HashMap> data = dlaqtjMapper.BJXCTJ(hashMap);
        return  new ApiResult().success(200, "成功", data);

    }

    /**
     * 八进宣传统计  子项
     * @author pc
     */
    @Override
    public ApiResult BJXCTJZX(String param,String start,String end,String name) {
        //参数检验
        HashMap hashMap = ParamUtils.bjxctjparsingParam(param, start, end,name);
        if(hashMap==null){
            return new ApiResult().failure("数据错误！！！！");
        }
        List<HashMap> data = dlaqtjMapper.BJXCTJZX(hashMap);
        return  new ApiResult().success(200, "成功", data);

    }

    /**
     * 单位重点违法统计
     * @author pc
     */
    @Override
    public ApiResult DWZDWFTJ(String param,String start,String end) {
        //参数检验
        HashMap hashMap = ParamUtils.dwzdwftjparsingParam(param, start, end);
        if(hashMap==null){
            return new ApiResult().failure("数据错误！！！！");
        }
        List<HashMap> data = dlaqtjMapper.DWZDWFTJ(hashMap);
        return  new ApiResult().success(200, "成功", data);

    }

    /**
     * 单位重点违法统计  子项
     * @author pc
     */
    @Override
    public ApiResult DWZDWFTJZX(String param,String start,String end,String name) {
        //参数检验
        HashMap hashMap = ParamUtils.dwzdwftjzxparsingParam(param, start, end,name);
        if(hashMap==null){
            return new ApiResult().failure("数据错误！！！！");
        }
        List<HashMap> data = dlaqtjMapper.DWZDWFTJZX(hashMap);
        return  new ApiResult().success(200, "成功", data);

    }
}
