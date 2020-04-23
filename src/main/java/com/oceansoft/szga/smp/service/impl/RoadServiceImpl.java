package com.oceansoft.szga.smp.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.entity.SourceNum;
import com.oceansoft.szga.smp.mapper.RoadMapper;
import com.oceansoft.szga.smp.service.RoadService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    public ApiResult getAddress() {
        return new ApiResult().success(200,"获取地址成功",roadMapper.getAddress());
    }

    @Override
    public HashMap getSourceSum(JSONObject json) {
        SourceNum sourceNum = checkSourceEntity(json);
        return roadMapper.getSourceSum(sourceNum);
    }

    @Override
    public ApiResult getFirmAnalzeSum(JSONObject json) {
        SourceNum sourceNum = checkSourceEntity(json);
        List<HashMap> has = roadMapper.getFirmAnalzeSum(sourceNum);
        if(has.size() > 0){
            //一个开关
            Boolean[] yboole = new Boolean[]{false,false,false,false};
            List<HashMap> ydatas = new ArrayList<>();
            List<HashMap> ldatas = new ArrayList<>();
            for(HashMap hashMap : has){
                //区分分类合计 只有4种类型
                if("flhj".equals(hashMap.get("xzxlmc"))){
                    ydatas.add(hashMap);
                    yboole[Integer.parseInt(hashMap.get("xzdl").toString()) - 1] = true;
                }else{
                    ldatas.add(hashMap);
                }
            }
            //处理数据中没有找到的类型并赋值为空
            for(int i=0 ;i<yboole.length; i++){
                HashMap ydata = new HashMap();
                if(!yboole[i]){
                    switch (i){
                        case 0: ydata.put("xzdl",1);ydata.put("xzdlmc","场站企业");ydata.put("xzxlmc","flhj");ydata.put("dwsl",0);
                            ydatas.add(ydata);
                            break;
                        case 1: ydata.put("xzdl",2);ydata.put("xzdlmc","经营性企业");ydata.put("xzxlmc","flhj");ydata.put("dwsl",0);
                            ydatas.add(ydata);
                            break;
                        case 2: ydata.put("xzdl",3);ydata.put("xzdlmc","自备车单位");ydata.put("xzxlmc","flhj");ydata.put("dwsl",0);
                            ydatas.add(ydata);
                            break;
                        case 3: ydata.put("xzdl",4);ydata.put("xzdlmc","个体车辆");ydata.put("xzxlmc","flhj");ydata.put("dwsl",0);
                            ydatas.add(ydata);
                            break;
                    }
                }
            }
            HashMap<String,List<HashMap>> listMap = new HashMap<>();
            listMap.put("ydata",ydatas);
            listMap.put("ldata",ldatas);
            return new ApiResult().success(200,"获取成功", listMap);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult getAchievCount(JSONObject json) {
        SourceNum sourceNum = checkSourceEntity(json);
        List<HashMap> has = roadMapper.getAchievCount(sourceNum);
        if(has.size() > 0){
            return new ApiResult().success(200,"获取成功", has);
        }
        return new ApiResult().failure("暂无数据");
    }

    /**
     * 处理查询按钮逻辑代码
     * @param json 前端入参
     * @return 年月
     */
    private SourceNum checkSourceEntity(JSONObject json){
        SourceNum sourceNum = new SourceNum();
        sourceNum.setType(json.getString("type"));
        sourceNum.setDeptId(json.getString("deptId"));
        sourceNum.setCgtype(json.getString("cgtype"));
        JSONArray nyList = json.getJSONArray("nyList");
        //判断当前是否为年初月则默认获取去年一年的数据 查询类型设置为按年
        if("01".equals(new SimpleDateFormat("MM").format(Calendar.getInstance().getTime()))){
            sourceNum.setType("nf");
            Calendar c = Calendar.getInstance();
            c.add(Calendar.YEAR, -1);
            sourceNum.setNyold(new SimpleDateFormat("yyyy").format(c.getTime()));
            sourceNum.setNynew(new SimpleDateFormat("yyyy").format(c.getTime()));
            return sourceNum;
        }
        //判断是否有选择时间
        if(nyList.size() > 0){
            //开始处理时间 前端传参都是 yyyy-MM 是个List 且只有2个值
            String nyold = nyList.get(0).toString();
            String nynew = nyList.get(1).toString();
            //判断查询类型是否为按年 拆分只要年份
            if("nf".equals(sourceNum.getType())){
                sourceNum.setNyold(nyold.split("-")[0]);
                sourceNum.setNynew(nynew.split("-")[0]);
                //判断查询类型是否按月 则直接赋值
            }else if("yf".equals(sourceNum.getType())){
                sourceNum.setNyold(nyold);
                sourceNum.setNynew(nynew);
                //判断两个值是否选择的值是一样且月份为1月 则赋值为去年 查询类型赋值强制为按年
            }
        }else{
            //没没有选择时间 则暂定获取今年的
            sourceNum.setNyold(new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime()));
            sourceNum.setNynew(new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime()));
        }
        return sourceNum;
    }

    @Override
    public ApiResult anTotleNum(Map map) {
        List<Map> data = roadMapper.anTotleNum(map);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult yhQusFx(String type,Map map) {
        List<Map> data = null;
        if("市区".equals(type)){
             data = roadMapper.yhQusFx(map);
        }else if("五县市".equals(type)){
             data = roadMapper.yhQusXs(map);
        }else if("高速".equals(type)) {
             data = roadMapper.yhQusGs(map);
        }
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult zyJdFx(Map map) {
        List<Map> data = roadMapper.zyJdFx(map);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult getAnYhDdFx(Map map) {
        Object changeYear =  map.get("twoYear");
        int b=Integer.parseInt((String)changeYear);
        map.put("twoYeat",b+1+"");
        List<Map> data = roadMapper.getAnYhDdFx(map);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult yhLxFx(Map map) {
        List<Map> data = roadMapper.yhLxFx(map);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult getYhZlLb(Map map) {
        Object changeYear =  map.get("twoYear");
        int b=Integer.parseInt((String)changeYear);
        map.put("twoYeat",b+1+"");
        List<Map> data = roadMapper.getYhZlLb(map);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult getDataClick(String clickName, Map map) {
        map.put("clickName",clickName);
        List<Map> data = roadMapper.getDataClick(map);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult getDataClickTop5(String clickName, Map map) {
        map.put("clickName",clickName);
        List<Map> data = roadMapper.getDataClickTop5(map);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult getSqTop5(String typeName,Map map) {
        map.put("typeName",typeName);
        List<Map> data = roadMapper.getSqTop5(map);
        return new ApiResult().success(200, "成功", data);
    }
}
