package com.oceansoft.szga.smp.service.impl;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.mapper.TjMapper;
import com.oceansoft.szga.smp.service.TjService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

//    @Override
//    public ApiResult zdDwYhTjSs(String tjrq) {
//        List<HashMap> data = tjMapper.zdDwYhTjSs(tjrq);
//        return new ApiResult().success(200, "成功", data);
//    }
//
//    @Override
//    public ApiResult zdDwYhTjSsPcs(String code,String tjrq) {
//        List<HashMap> data = tjMapper.zdDwYhTjSsPcs(code,tjrq);
//        return new ApiResult().success(200, "成功", data);
//    }
//
//    @Override
//    public ApiResult zdDwYhTjSsZrq(String code,String tjrq) {
//        List<HashMap> data = tjMapper.zdDwYhTjSsZrq(code,tjrq);
//        return new ApiResult().success(200, "成功", data);
//    }

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

    @Override
    public ApiResult zySsYhTjYd(String year) {
        List<HashMap> data = tjMapper.zySsYhTjYd(year);
        if(data.size() > 0){
            return new ApiResult().success(200,"获取成功", data);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult zySsYhTjYdClick(HashMap map) {
        List<HashMap> data = null;
        if("zrq".equals(map.get("type"))){
            data = tjMapper.zySsYhTjYdZrq(map);
        }else if("pcs".equals(map.get("type"))){
            data = tjMapper.zySsYhTjYdPcs(map);
        }
        if(data.size() > 0){
            return new ApiResult().success(200,"获取成功", data);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult jgYdData(String year) {
        List<HashMap> data = tjMapper.jgYdData(year);
        if(data.size() > 0){
            return new ApiResult().success(200,"获取成功", data);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult jgYdDataClick(HashMap map) {
        List<HashMap> data = null;
        if("zrq".equals(map.get("type"))){
            data = tjMapper.jgYdDataZrq(map);
        }else if("pcs".equals(map.get("type"))){
            data = tjMapper.jgYdDataPcs(map);
        }
        if(data.size() > 0){
            return new ApiResult().success(200,"获取成功", data);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult qsyAddYdData(HashMap map) {
        List<HashMap> data = null;
        if("all".equals(map.get("type"))){
            data = tjMapper.qsyAddYd(map);
        }else if("zrq".equals(map.get("type"))){
            data = tjMapper.qsyAddYdZrq(map);
        }else if("pcs".equals(map.get("type"))){
            data = tjMapper.qsyAddYdPcs(map);
        }
        if(data.size() > 0){
            return new ApiResult().success(200,"获取成功", data);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult qsyAddSsData(HashMap map) {
        List<HashMap> data = null;
        if("all".equals(map.get("type"))){
            data = tjMapper.qsyAddSs(map);
        }else if("zrq".equals(map.get("type"))){
            data = tjMapper.qsyAddSsZrq(map);
        }else if("pcs".equals(map.get("type"))){
            data = tjMapper.qsyAddSsPcs(map);
        }
        if(data.size() > 0){
            return new ApiResult().success(200,"获取成功", data);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult zdDwYhYdData(HashMap map) {
        List<HashMap> data = null;
        if("all".equals(map.get("type"))){
            data = tjMapper.zdDwYhYd(map);
        }else if("zrq".equals(map.get("type"))){
            data = tjMapper.zdDwYhZrq(map);
        }else if("pcs".equals(map.get("type"))){
            data = tjMapper.zdDwYhPcs(map);
        }
        if(data.size() > 0){
            return new ApiResult().success(200,"获取成功", data);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult zdDwYhSsData(HashMap map) {
        List<HashMap> data = null;
        if("all".equals(map.get("type"))){
            data = tjMapper.zdDwYhTjSs(map);
        }else if("zrq".equals(map.get("type"))){
            data = tjMapper.zdDwYhTjSsZrq(map);
        }else if("pcs".equals(map.get("type"))){
            data = tjMapper.zdDwYhTjSsPcs(map);
        }
        if(data.size() > 0){
            return new ApiResult().success(200,"获取成功", data);
        }
        return new ApiResult().failure("暂无数据");
    }


    @Override
    public List<List<Object>> createListObject(List<LinkedHashMap> list) {
        List<List<Object>> temp=new ArrayList<>();
        list.forEach(map->{
            List<Object> ll=new ArrayList<>();
            map.values().forEach(v->ll.add(v));
            temp.add(ll);
        });
        return temp;
    }

    @Override
    public List<List<String>> createHead() {
        String[][] heads = {
                {"区域","区域"},
                {"企业事业单位总量","企业事业单位总量"},
                {"三级治安保卫重点单位","总量"},
                {"三级治安保卫重点单位","省级"},
                {"三级治安保卫重点单位","市级"},
                {"三级治安保卫重点单位","区县级"},
                {"社区关注重点单位","总量"},
                {"社区关注重点单位","加油站"},
                {"社区关注重点单位","金银珠宝场所"},
                {"铸盾工程单位数","加装人像卡口单位数"},
                {"铸盾工程单位数","未加装人像卡口单位数"},
                {"重要设施总数","重要设施总数"},
        };
        return getHeadList(heads);
    }

    @Override
    public void exportExcel(HttpServletResponse response, List<List<Object>> objects, List<List<String>> heads, String fileName) throws IOException {
        ServletOutputStream out = response.getOutputStream();
        response.setContentType("multipart/form-data");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename="+ URLEncoder.encode(fileName,"UTF-8")+".xlsx");
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
        Sheet sheet1 = new Sheet(1, 0);
        sheet1.setSheetName(fileName);
        sheet1.setHead(heads);
        writer.write1(objects, sheet1);
        writer.finish();
        out.flush();
    }

    @Override
    public List<List<Object>> createJgSsTjListObject(List<Map> list) {
        List<List<Object>> temp=new ArrayList<>();
        list.forEach(map->{
            List<Object> ll=new ArrayList<>();
            ll.add(map.get("area"));
            ll.add(map.get("qsysl"));
            ll.add(map.get("sjtotle"));
            ll.add(map.get("snum"));
            ll.add(map.get("sjnum"));
            ll.add(map.get("qxnum"));
            ll.add(map.get("sqtotle"));
            ll.add(map.get("jyznum"));
            ll.add(map.get("yjzbcszl"));
            ll.add(map.get("azsxtsl"));
            ll.add(map.get("wazsxtsl"));
            ll.add(map.get("dwsl"));
            temp.add(ll);
        });
        return temp;
    }

    private List<List<String>> getHeadList(String[][] heads) {
        List<List<String>> head = new ArrayList<List<String>>();
        for(int i=0;i<heads.length;i++){
            //每个子数组就是一列的表头
            head.add(Arrays.asList(heads[i]));
        }
        return head;
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
