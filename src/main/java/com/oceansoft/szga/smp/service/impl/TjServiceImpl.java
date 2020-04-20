package com.oceansoft.szga.smp.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.mapper.TjMapper;
import com.oceansoft.szga.smp.service.TjService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *  统计
 * @author wzj
 * @date 2019/4/08
 */

@Service
public class TjServiceImpl implements TjService {

    @Resource
    private TjMapper tjMapper;

    @Override
    public ApiResult zyssFlTj() {
        List<HashMap> data = tjMapper.zyssFlTj();
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult zyssFlTjPcs(String code) {
        List<HashMap> data = tjMapper.zyssFlTjPcs(code);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult zyssFlTjZrq(String code) {
        List<HashMap> data = tjMapper.zyssFlTjZrq(code);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult lzTjFxData(String tjrq) {
        List<HashMap> data = tjMapper.lzTjFxData(tjrq);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult lzTjFxDataPcs(String code,String tjrq) {
        List<HashMap> data = tjMapper.lzTjFxDataPcs(code,tjrq);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult lzTjFxDataZrq(String code,String tjrq) {
        List<HashMap> data = tjMapper.lzTjFxDataZrq(code,tjrq);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult zyssYhTj(String tjrq) {
        List<HashMap> data = tjMapper.zyssYhTj(tjrq);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult zYssYhTjPcs(String code,String tjrq) {
        List<HashMap> data = tjMapper.zYssYhTjPcs(code,tjrq);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult zYssYhTjZrq(String code,String tjrq) {
        List<HashMap> data = tjMapper.zYssYhTjZrq(code,tjrq);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult jgSsTj(String tjrq) {
        List<HashMap> data = tjMapper.jgSsTj(tjrq);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult jgSsTjPcs(String code,String tjrq) {
        List<HashMap> data = tjMapper.jgSsTjPcs(code,tjrq);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult jgSsTjZrq(String code,String tjrq) {
        List<HashMap> data = tjMapper.jgSsTjZrq(code,tjrq);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult zdDwYhTjSs(String tjrq) {
        List<HashMap> data = tjMapper.zdDwYhTjSs(tjrq);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult zdDwYhTjSsPcs(String code,String tjrq) {
        List<HashMap> data = tjMapper.zdDwYhTjSsPcs(code,tjrq);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult zdDwYhTjSsZrq(String code,String tjrq) {
        List<HashMap> data = tjMapper.zdDwYhTjSsZrq(code,tjrq);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult zySsXzTjSs(String tjrq) {
        List<HashMap> data = tjMapper.zySsXzTjSs(time(tjrq),tjrq);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult zySsXzTjSsPcs(String code,String tjrq) {
        List<HashMap> data = tjMapper.zySsXzTjSsPcs(time(tjrq),code,tjrq);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult zySsXzTjSsZrq(String code,String tjrq) {
        List<HashMap> data = tjMapper.zySsXzTjSsZrq(time(tjrq),code,tjrq);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult qsyAddSs(String tjrq) {
        List<HashMap> data = tjMapper.qsyAddSs(tjrq);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult qsyAddSsPcs(String code,String tjrq) {
        List<HashMap> data = tjMapper.qsyAddSsPcs(code,tjrq);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult qsyAddSsZrq(String code,String tjrq) {
        List<HashMap> data = tjMapper.qsyAddSsZrq(code,tjrq);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult zySsXzTjYd(String year) {
        List<HashMap> data = tjMapper.zySsXzTjYd(year);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult zySsXzTjYdPcs(String year, String code) {
        List<HashMap> data = tjMapper.zySsXzTjYdPcs(year,code);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult zySsXzTjYdZrq(String year, String code) {
        List<HashMap> data = tjMapper.zySsXzTjYdZrq(year,code);
        return new ApiResult().success(200, "成功", data);
    }

    private String time(String tjrq){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date date = null;
        try{
            date =sdf.parse(tjrq);
        }catch (ParseException e){
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        String time = sdf.format(cal.getTime());
        return time;
    }
}
