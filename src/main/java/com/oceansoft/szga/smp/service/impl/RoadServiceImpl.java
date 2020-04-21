package com.oceansoft.szga.smp.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.entity.SourceNum;
import com.oceansoft.szga.smp.mapper.RoadMapper;
import com.oceansoft.szga.smp.service.RoadService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 *  道路交通
 * @author wzj
 * @date 2019/4/20
 */

@Service
public class RoadServiceImpl implements RoadService {

    @Resource
    private RoadMapper roadMapper;

    @Override
    public ApiResult test() {
        List<HashMap> data = roadMapper.test();
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public HashMap getSourceSum(JSONObject json) {
        SourceNum sourceNum = new SourceNum();
        sourceNum.setType(json.getString("type"));
        JSONArray nyList = json.getJSONArray("nyList");
        if(nyList.size() > 0){
            String nyold = nyList.get(0).toString();
            String nynew = nyList.get(1).toString();
            if("nf".equals(sourceNum.getType())){
                sourceNum.setNyold(nyold.split("-")[0]);
                sourceNum.setNynew(nynew.split("-")[0]);
            }else if(nyold.equals(nynew) && nyold.split("-")[1].equals("01") || nynew.split("-")[1].equals("01")){
                //设置为去年
                Calendar c = Calendar.getInstance();
                c.add(Calendar.YEAR, -1);
                sourceNum.setNyold(new SimpleDateFormat("yyyy-MM").format(c.getTime()));
                c.add(Calendar.MONTH, 11);
                sourceNum.setNynew(new SimpleDateFormat("yyyy-MM").format(c.getTime()));
            }
        }else{
            //暂时一进来先获取本年的 之后待定
            sourceNum.setNyold(new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime()));
            sourceNum.setNynew(new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime()));
        }
        return roadMapper.getSourceSum(sourceNum);
    }
}
