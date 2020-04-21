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
                if("flhj".equals(hashMap.get("xzxlmc"))){
                    ydatas.add(hashMap);
                    yboole[Integer.parseInt(hashMap.get("xzdl").toString()) - 1] = true;
                }else{
                    ldatas.add(hashMap);
                }
            }
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
        }else{
            return new ApiResult().failure("暂无数据");
        }
    }

    /**
     * 处理查询按钮逻辑代码
     * @param json 前端入参
     * @return 年月
     */
    private SourceNum checkSourceEntity(JSONObject json){
        SourceNum sourceNum = new SourceNum();
        sourceNum.setType(json.getString("type"));
        JSONArray nyList = json.getJSONArray("nyList");
        if(nyList.size() > 0){
            String nyold = nyList.get(0).toString();
            String nynew = nyList.get(1).toString();
            if("nf".equals(sourceNum.getType())){
                sourceNum.setNyold(nyold.split("-")[0]);
                sourceNum.setNynew(nynew.split("-")[0]);
            }else if("yf".equals(sourceNum.getType())){
                sourceNum.setNyold(nyold);
                sourceNum.setNynew(nynew);
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
        return sourceNum;
    }
}
