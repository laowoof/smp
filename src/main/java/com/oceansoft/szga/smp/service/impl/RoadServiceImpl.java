package com.oceansoft.szga.smp.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.entity.SourceNum;
import com.oceansoft.szga.smp.mapper.RoadMapper;
import com.oceansoft.szga.smp.service.RoadService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *  道路交通
 * @author wzj
 * @date 2020/4/20
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

    @Override
    public ApiResult getWfDj(HashMap map) {
        List<HashMap> has = roadMapper.getWfDj(map);
        if(has.size() > 0){
            return new ApiResult().success(200,"获取成功", has);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult getZfSj(HashMap map) {
        List<HashMap> has = roadMapper.getZfSj(map);
        if(has.size() > 0){
            return new ApiResult().success(200,"获取成功", has);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult getZfSjZd(String clickName,HashMap map) {
        map.put("clickName",clickName);
        List<HashMap> has = roadMapper.getZfSjZd(map);
        if(has.size() > 0){
            return new ApiResult().success(200,"获取成功", has);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult getWfHmd(HashMap map) {
        List<HashMap> has = roadMapper.getWfHmd(map);
        if(has.size() > 0){
            return new ApiResult().success(200,"获取成功", has);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult getDataCjBk(HashMap map) {
        List<HashMap> has = roadMapper.getDataCjBk(map);
        if(has.size() > 0){
            return new ApiResult().success(200,"获取成功", has);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult getDataRxSb(HashMap map) {
        List<HashMap> has = roadMapper.getDataRxSb(map);
        if(has.size() > 0){
            return new ApiResult().success(200,"获取成功", has);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult getDataJtWf(String name) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        calendar.add(Calendar.DATE, -1);
        String yesterday  =  sdf.format(calendar.getTime());
        HashMap map = new HashMap();
        map.put("name",name);
        map.put("yesterday",yesterday);
        List<HashMap> has = roadMapper.getDataJtWf(map);
        if(has.size() > 0){
            return new ApiResult().success(200,"获取成功", has);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult getDataZdWlTj(String TypeName, HashMap map) {
        map.put("TypeName",TypeName);
        List<HashMap> has = roadMapper.getDataZdWlTj(map);
        if(has.size() > 0){
            return new ApiResult().success(200,"获取成功", has);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult getDataWfLx(String typeName, HashMap map) {
        map.put("typeName",typeName);
        List<HashMap> has = roadMapper.getDataWfLx(map);
        if(has.size() > 0){
            return new ApiResult().success(200,"获取成功", has);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult getDataWfLxType(String typeName, HashMap map) {
        map.put("typeName",typeName);
        List<HashMap> has = roadMapper.getDataWfLxType(map);
        if(has.size() > 0){
            return new ApiResult().success(200,"获取成功", has);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult getClickDataWfLxType(String name, HashMap map) {
        map.put("name",name);
        List<HashMap> has = roadMapper.getClickDataWfLxType(map);
        if(has.size() > 0){
            return new ApiResult().success(200,"获取成功", has);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult getDataCar(String typeName, HashMap map) {
        map.put("typeName",typeName);
        List<HashMap> has = null;
        if("year".equals(map.get("dateType"))){
             has = roadMapper.getDataCarYear(map);
        }
        if("month".equals(map.get("dateType"))){
             has = roadMapper.getDataCarMonth(map);
        }
        if("mr".equals(map.get("dateType"))){
            has = roadMapper.getDataCarMR(map);
        }
        if(has.size() > 0){
            return new ApiResult().success(200,"获取成功", has);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult getDataCarQue(String typeName, HashMap map) {
        map.put("typeName",typeName);
        List<HashMap> has = roadMapper.getDataCarQue(map);
        if(has.size() > 0){
            return new ApiResult().success(200,"获取成功", has);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult getDataDdList(String typeName) {
        HashMap map = new HashMap();
        map.put("typeName",typeName);
        List<HashMap> has = roadMapper.getDataDdList(map);
        return new ApiResult().success(200,"获取成功", has);
    }

    @Override
    public ApiResult getDataDdListChange(String titleName,Map map) {
        map.put("titleName",titleName);
        List<HashMap> has = roadMapper.getDataDdListChange(map);
        return new ApiResult().success(200,"获取成功", has);
    }

    @Override
    public ApiResult getDataDdListChangeCar(String titleName, Map map) {
        map.put("titleName",titleName);
        List<HashMap> has = null;
        if("year".equals(map.get("dateType"))){
            has = roadMapper.getDataDdListChangeYear(map);
        }
        if("month".equals(map.get("dateType"))){
            has = roadMapper.getDataDdListChangeMonth(map);
        }
        if("mr".equals(map.get("dateType"))){
            has = roadMapper.getDataDdListChangeMr(map);
        }
        if(has.size() > 0){
            return new ApiResult().success(200,"获取成功", has);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult getDataClickCarAndChange(String name, Map map) {
        map.put("name",name);
        List<HashMap> has = roadMapper.getDataClickCarAndChange(map);
        if(has.size()>0){
            return new ApiResult().success(200,"获取成功", has);
        }else{
            return new ApiResult().failure("暂无数据");
        }

    }

    @Override
    public ApiResult carYhData(Map map) {
        List<HashMap> has = roadMapper.carYhData(map);
        if(has.size()>0){
            return new ApiResult().success(200,"获取成功", has);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult getZdCarData(Map map) {
        List<HashMap> has = roadMapper.getZdCarData(map);
        if(has.size()>0){
            return new ApiResult().success(200,"获取成功", has);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult getIllegalCar(JSONObject json) {
        SourceNum sourceNum = checkSourceEntity(json);
        List<HashMap> has = roadMapper.getIllegalCar(sourceNum);
        List<String> dwmcList = new ArrayList<>();
        for (HashMap ha : has) {
            dwmcList.add((String) ha.get("dwmc"));
        }
        Map<String, Map> mapList = new HashMap<>();
        if (dwmcList != null && !dwmcList.isEmpty()) {
            List<HashMap> dwmcLxdm = roadMapper.getDwmcLxdm(dwmcList, sourceNum);
            for (HashMap hashMap : dwmcLxdm) {
                String dwmcName = (String) hashMap.get("dwmc");
                if (!mapList.containsKey(dwmcName)) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("dwmc", hashMap.get("dwmc"));
                    String lxdm = (String) hashMap.get("lxdm");
                    Integer sl = ((BigDecimal) hashMap.get("sl")).intValue();
                    if (lxdm.equals("1")) {
                        map.put("wfs", sl);
                    } else {
                        map.put("sgs", sl);
                    }
                    mapList.put(dwmcName, map);
                } else {
                    Map<String, Object> map = mapList.get(dwmcName);
                    if (hashMap.get("lxdm").equals("1")) {
                        map.put("wfs", hashMap.get("sl"));
                    } else {
                        map.put("sgs", hashMap.get("sl"));
                    }
                }
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("has", has);
        if (mapList.values() != null) {
            map.put("dwmcLxdm", mapList.values());
        } else {
            map.put("dwmcLxdm", null);
        }
            return new ApiResult().success(200,"获取成功", map);
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
        if(data.size() > 0){
            return new ApiResult().success(200,"获取成功", data);
        }
        return new ApiResult().failure("暂无数据");
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
        if(data.size() > 0){
            return new ApiResult().success(200,"获取成功", data);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult yhLxFx(Map map) {
        List<Map> data = roadMapper.yhLxFx(map);
        if(data.size() > 0){
            return new ApiResult().success(200,"获取成功", data);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult getYhZlLb(Map map) {
        Object changeYear =  map.get("twoYear");
        int b=Integer.parseInt((String)changeYear);
        map.put("twoYeat",b+1+"");
        List<Map> data = roadMapper.getYhZlLb(map);
        if(data.size() > 0){
            return new ApiResult().success(200,"获取成功", data);
        }
        return new ApiResult().failure("暂无数据");
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
        if(data.size() > 0){
            return new ApiResult().success(200,"获取成功", data);
        }
        return new ApiResult().failure("暂无数据");
    }
}
