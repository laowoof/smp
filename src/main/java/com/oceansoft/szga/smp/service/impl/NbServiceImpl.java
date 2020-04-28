package com.oceansoft.szga.smp.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableMap;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.mapper.NbMapper;
import com.oceansoft.szga.smp.service.NbService;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 *  内保
 * @author wzj
 * @date 2019/1/19
 */

@Service
public class NbServiceImpl implements NbService {

    @Resource
    private NbMapper nbMapper;


    @Override
    public ApiResult test() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.test(tjrq);
        return new ApiResult().success(200,"成功",data);
    }

    @Override
    public ApiResult totleNum() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.totleNum(tjrq);
        return new ApiResult().success(200,"成功",data);
    }

    @Override
    public ApiResult totleNumBySl() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.totleNumBySl(tjrq);
        if(data.size()>0){
            return new ApiResult().success(200,"成功",data);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult findDataByJj() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findDataByJj(tjrq);
        return new ApiResult().success(200, "成功", changeData(data));
    }

    @Override
    public ApiResult findDataByZd() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findDataByZd(tjrq);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult findDataByOrder() {
        List<HashMap> data = nbMapper.findDataByOrder();
        return new ApiResult().success(200, "成功", changeData(data));
    }

    @Override
    public ApiResult findDataByLimit(String name) {
        List<HashMap> data = nbMapper.findDataByLimit(changeName(name));
        return new ApiResult().success(200, "成功", removeData(data));
    }

    @Override
    public ApiResult findNumByJcsl() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByJcsl(tjrq);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult findNumByYhsl() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByYhsl(tjrq);
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult findDataByFx() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findDataByFx(tjrq);
        for(HashMap map :data) {
            HashMap<String,String> has = new HashMap<>();
            has.put("jbdjdm","1");
            has.put("jbdjmc","省级治安单位");
            has.put("dwsl","0");
            has.put("yhsl","0");
            has.put("yhper","0");
            has.put("dwper","0");
            String dm = "1";
            if (!dm.equals(map.get("jbdjdm"))) {
                data.add(has);
                break;
            }
        }
        if(data.size()>0){
            return new ApiResult().success(200, "成功", data);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult findDataByNum() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findDataByNum(tjrq);
        for(HashMap map :data) {
            HashMap<String,String> has = new HashMap<>();
            has.put("jbdjdm","1");
            has.put("jbdjmc","省级治安单位");
            has.put("dwsl","0");
            has.put("yhsl","0");
            String dm = "1";
            if (!dm.equals(map.get("jbdjdm"))) {
                data.add(has);
                break;
            }
        }
        if(data.size()>0){
            return new ApiResult().success(200, "成功", data);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult findDataByZz() {
        List<HashMap> data = nbMapper.findDataByZz();
        return new ApiResult().success(200, "成功", changeData(data));
    }

    @Override
    public ApiResult findDataByZzLinit(String name) {
        List<HashMap> data = nbMapper.findDataByZzLinit(changeName(name));
        return new ApiResult().success(200, "成功",removeData(data));
    }

    @Override
    public ApiResult findDataByZzOne() {
        List<HashMap> data = nbMapper.findDataByZzOne();
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult findNumByZyss() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByZyss(tjrq);
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult findNumByCyry() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByCyry(tjrq);
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult findNumByZd() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByZd(tjrq);
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult findNumByScaq() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByScaq(tjrq);
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult findNumByYhcls() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByYhcls(tjrq);
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult findNumBySsFx() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumBySsFx(tjrq);
        if(data.size()>0){
            return new ApiResult().success(200, "成功",data);
        }
        return new ApiResult().failure("暂无数据");
    }

    @Override
    public ApiResult findDataZySsLimit() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findDataZySsLimit(tjrq);
        return new ApiResult().success(200, "成功",changeData(data));
    }

    @Override
    public ApiResult findDataZySsPcs(String name) {
        List<HashMap> data = nbMapper.findDataZySsPcs(changeName(name));
        return new ApiResult().success(200, "成功",removeData(data));
    }

    @Override
    public ApiResult findDataYhFx() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findDataYhFx(tjrq);
        return new ApiResult().success(200, "成功",changeData(data));
    }

    @Override
    public ApiResult findDataYhFxPcs(String name) {
        List<HashMap> data = nbMapper.findDataYhFxPcs(changeName(name));
        return new ApiResult().success(200, "成功",removeData(data));
    }

    @Override
    public ApiResult findDataJctjCg() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findDataJctjCg(tjrq);
        return new ApiResult().success(200, "成功",changeData2(data));
    }

    @Override
    public ApiResult findDataJctjCgPcs(String name) {
        List<HashMap> data = nbMapper.findDataJctjCgPcs(changeName(name));
        return new ApiResult().success(200, "成功",removeData(data));
    }

    @Override
    public ApiResult findDataJctjZx() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findDataJctjZx(tjrq);
        return new ApiResult().success(200, "成功",changeData2(data));
    }

    @Override
    public ApiResult findDataJctjZxPcs(String name) {
        List<HashMap> data = nbMapper.findDataJctjZxPcs(changeName(name));
        return new ApiResult().success(200, "成功",removeData(data));
    }

    @Override
    public ApiResult findDataJctjQs() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findDataJctjQs(tjrq);
        return new ApiResult().success(200, "成功",changeData2(data));
    }

    @Override
    public ApiResult findDataJctjQsPcs(String name) {
        List<HashMap> data = nbMapper.findDataJctjQsPcs(changeName(name));
        return new ApiResult().success(200, "成功",removeData(data));
    }

    @Override
    public ApiResult findDataJctjZd() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findDataJctjZd(tjrq);
        return new ApiResult().success(200, "成功",changeData2(data));
    }

    @Override
    public ApiResult findDataJctjZdPcs(String name) {
        List<HashMap> data = nbMapper.findDataJctjZdPcs(changeName(name));
        return new ApiResult().success(200, "成功",removeData(data));
    }

    @Override
    public ApiResult findDataJctjWzg() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findDataJctjWzg(tjrq);
        return new ApiResult().success(200, "成功",changeData2(data));
    }

    @Override
    public ApiResult findDataJctjWzgPcs(String name) {
        List<HashMap> data = nbMapper.findDataJctjWzgPcs(changeName(name));
        return new ApiResult().success(200, "成功",removeData(data));
    }

    @Override
    public ApiResult findDataJctjZg() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findDataJctjZg(tjrq);
        return new ApiResult().success(200, "成功",changeData2(data));
    }

    @Override
    public ApiResult findDataJctjZgPcs(String name) {
        List<HashMap> data = nbMapper.findDataJctjZgPcs(changeName(name));
        return new ApiResult().success(200, "成功",removeData(data));
    }

    @Override
    public ApiResult findNumByGllx() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByGllx(tjrq);
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult findNumByGljc() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByGljc(tjrq);
        for(HashMap map :data) {
            HashMap<String,String> has = new HashMap<>();
            has.put("gljcjg","3");
            has.put("gljcjgmc","责令限期整改并处警告");
            has.put("sum","0");
            String dm = "3";
            if (!dm.equals(map.get("gljcjg"))) {
                data.add(has);
                break;
            }
        }
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult findNumByFc() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByFc(tjrq);
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult findNumByFcWwcl() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByFcWwcl(tjrq);
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult findNumByFcJcjg() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByFcJcjg(tjrq);
        for(HashMap map :data) {
            HashMap<String,String> has = new HashMap<>();
            has.put("gljcjg","100");
            has.put("gljcjgmc","因客观原因整改未达到规定要求");
            has.put("sum","0");
            String dm = "100";
            if (!dm.equals(map.get("gljcjg"))) {
                data.add(has);
                break;
            }
        }
        for(HashMap map2 :data) {
            HashMap<String,String> has2 = new HashMap<>();
            has2.put("gljcjg","200");
            has2.put("gljcjgmc","无正当理由整改未达到规定要求");
            has2.put("sum","0");
            String dm2 ="200";
            if (!dm2.equals(map2.get("gljcjg"))) {
                data.add(has2);
                break;
            }
        }
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult findNumByFcspWwcl() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByFcspWwcl(tjrq);
        for(HashMap map :data) {
            HashMap<String,String> has = new HashMap<>();
            has.put("jclx","4");
            has.put("sum","0");
            String dm = "4";
            if (!dm.equals(map.get("jclx"))) {
                data.add(has);
                break;
            }
        }
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult findNumByFcspFk() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByFcspFk(tjrq);
        if(data.size() == 0){
            HashMap<String,String> has = new HashMap<>();
            has.put("gljcjg","201");
            has.put("gljcjgmc","罚款");
            has.put("sum","0");
            data.add(has);
        }
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult findNumByFcspXt() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByFcspXt(tjrq);
        if(data.size() == 0){
            HashMap<String,String> has = new HashMap<>();
            has.put("gljcjg","101");
            has.put("gljcjgmc","协调解决");
            has.put("sum","0");
            data.add(has);
        }
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult findNumByCzDczg() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByCzDczg(tjrq);
        return new ApiResult().success(200, "成功",addData(data,tjrq));
    }

    @Override
    public ApiResult findNumByCzZgwcs() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByCzZgwcs(tjrq);
        return new ApiResult().success(200, "成功",addData(data,tjrq));
    }

    @Override
    public ApiResult findNumByCzWwcs() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByCzWwcs(tjrq);
        return new ApiResult().success(200, "成功",addData(data,tjrq));
    }

    @Override
    public ApiResult findNumByZddw() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByZddw(tjrq);
        return new ApiResult().success(200, "成功",changeData3(data));
    }

    @Override
    public ApiResult findNumByZddwLimit() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByZddwLimit(tjrq);
        return new ApiResult().success(200, "成功",changeData3(data));
    }

    @Override
    public ApiResult findNumByYhYear() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByYhYear(tjrq);
        return new ApiResult().success(200, "成功",changeData3(data));
    }

    @Override
    public ApiResult findNumByZyssFx() {
        List<HashMap> data = nbMapper.findNumByZyssFx();
        if(data.size()>0){
            return new ApiResult().success(200, "成功",changeData(data));
        }
        return  new ApiResult().failure("暂无数据");
    }
    @Override
    public ApiResult findNumByZddwjcfx(String nf, String type) {
        if(StringUtils.isEmpty(nf) || 4 != nf.length() || StringUtils.isEmpty(type)){
            return new ApiResult().failure("非法参数!");
        }
        List<HashMap> data = new ArrayList<>();
        if("findZxjc".equals(type)){
            data = nbMapper.findNumByZddwjcfxZx(nf);
        }else if("findZdjc".equals(type)){
            data = nbMapper.findNumByZddwjcfx(nf);
        }else{
            return new ApiResult().failure("请传入类型!");
        }
        if(data.size()<1){
            return new ApiResult().failure("没有获取到任何数据!");
        }
        return new ApiResult().success(200, "成功",changeData(data));
    }

    @Override
    public ApiResult findNumByZyssFxZl(JSONObject obj) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByZyssFxZl(changeData4(obj,tjrq));
        return new ApiResult().success(200, "成功",changeData(data));
    }

    @Override
    public ApiResult findNumByZyssTotle() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByZyssTotle(tjrq);
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult findNumByDj(JSONObject obj) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByDj(changeData4(obj,tjrq));
        return new ApiResult().success(200, "成功",changeData3(data));
    }

    @Override
    public ApiResult findNumByZddwZl(JSONObject obj) {
        JSONArray djArrys = obj.getJSONArray("djData");
        JSONArray zlArrys = obj.getJSONArray("zlData");
        HashMap has = new HashMap();
        if(djArrys.size() < 1){
            has.put("dj", null);
        }else{
            has.put("dj", djArrys);
        }
        if(zlArrys.size() < 1){
            has.put("zl", null);
        }else{
            has.put("zl", zlArrys);
        }
        List<HashMap> data = nbMapper.findNumByZddwZl(has);
        return new ApiResult().success(200, "成功",changeData3(data));
    }

    @Override
    public ApiResult findDataByZddwYear(JSONObject obj) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        JSONArray array = obj.getJSONArray("ssfjmc");
        array = changeNameJsonArray(array,true);
        HashMap has = new HashMap();
        has.put("tjrq",tjrq);
        has.put("ssfjmc",array);
        List<HashMap> data = nbMapper.findDataByZddwYear(has);
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult findDataByZddwMonth(JSONObject obj) {
        //创建本月至前11个月
        HashMap dateMap = creatLtGtDate(11);
        //取出筛选内容
        JSONArray array = obj.getJSONArray("ssfjmc");
        array = changeNameJsonArray(array,true);
        HashMap has = new HashMap();
        has.put("ltnf",dateMap.get("ltnf"));
        has.put("gtnf",dateMap.get("gtnf"));
        has.put("ssfjmc",array);
        List<HashMap> data = nbMapper.findDataByZddwMonth(has);
        if(data.size() < 1){
            return new ApiResult().failure("没有查询到信息");
        }
        //生成本年本月往前一年的基本信息
        List<HashMap> creatZyssslList = creatZyssslMonth("ASC","ZddwMonth");
        //月份进行处理
        data = changeYearOrMonth(creatZyssslList, data, "ZddwMonth");
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult findNumByZddwJcMonth(JSONObject obj) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        int year = calendar.get(Calendar.YEAR);
        List<HashMap> data = nbMapper.findNumByZddwJcMonth(changeData5(obj,tjrq,String.valueOf(year)));
        return new ApiResult().success(200, "成功",changeMonth(data));
    }

    @Override
    public ApiResult findNumByQmQsyLx(JSONObject obj) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByQmQsyLx(changeData4(obj,tjrq));
        return new ApiResult().success(200, "成功",changeData(data));
    }

    @Override
    public ApiResult findNumByQmZyss() {
        List<HashMap> data = nbMapper.findNumByQmZyss();
        return new ApiResult().success(200, "成功",changeData(data));
    }

    @Override
    public ApiResult findNumByQmZyssZl(JSONObject obj) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByQmZyssZl(changeData4(obj,tjrq));
        return new ApiResult().success(200, "成功",changeData(data));
    }

    @Override
    public ApiResult findNumByZdNum() {
        List<HashMap> data = nbMapper.findNumByZdNum();
        for(HashMap map :data) {
            if ("0".equals(map.get("ssfjmc"))) {
                data.remove(map);
                break;
            }
        }
        return new ApiResult().success(200, "成功",changeData(data));
    }

    @Override
    public ApiResult findDataQsyMonth() {
        HashMap dateMap = creatLtGtDate(11);
        HashMap has = new HashMap();
        has.put("ltnf",dateMap.get("ltnf"));
        has.put("gtnf",dateMap.get("gtnf"));
        List<HashMap> data = nbMapper.findDataQsyMonth(has);
        //生成本年本月往前一年的基本信息
        List<HashMap> creatZyssslList = creatZyssslMonth("ASC","");
        //月份进行处理
        data = changeYearOrMonth(creatZyssslList, data, "");
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult findDataQsyYear() {
        List<HashMap> data = nbMapper.findDataQsyYear();
        return new ApiResult().success(200, "成功",removeData2(data));
    }

    @Override
    public ApiResult findDataQsyLtMonth(String name) {
        HashMap dateMap = creatLtGtDate(11);
        HashMap has = new HashMap();
        has.put("ltnf",dateMap.get("ltnf"));
        has.put("gtnf",dateMap.get("gtnf"));
        has.put("name",changeName(name));
        List<HashMap> data = nbMapper.findDataQsyLtMonth(has);
        //生成本年本月往前一年的基本信息
        List<HashMap> creatZyssslList = creatZyssslMonth("ASC","");
        //月份进行处理
        data = changeYearOrMonth(creatZyssslList, data, "");
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult findDataQsyLtYear(String name) {
        List<HashMap> data = nbMapper.findDataQsyLtYear(changeName(name));
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult zdssZdjc(Map map) {
        List<Map> list = nbMapper.zdssZdjc(map);
        int total = list.stream().collect(Collectors.summingInt(m-> ((BigDecimal) m.get("count")).intValue()));
        return new ApiResult(ImmutableMap.of("list",list,"total",total));
    }

    @Override
    public ApiResult findNumByZyssslZl(String type, JSONObject obj) {
        if(StringUtils.isEmpty(type) || 5 < type.length() ){
            return new ApiResult().failure("非法参数!");
        }
        JSONArray array = obj.getJSONArray("ssfjmc");
        array = changeNameJsonArray(array,true);
        List<HashMap> data = new ArrayList<>();
        HashMap has = new HashMap();
        if("month".equals(type)){
            //默认本月向前的一年内的数据
            HashMap dateMap = creatLtGtDate(11);
            has.put("gtnf",dateMap.get("gtnf"));
            has.put("ltnf",dateMap.get("ltnf"));
            has.put("ssfjmc",array);
            data = nbMapper.findNumByZyssslZlMonth(has);
            if(data.size()<1){
                return new ApiResult().failure("没有获取到任何数据!");
            }
            //生成本年本月往前一年的基本信息
            List<HashMap> creatZyssslList = creatZyssslMonth("ASC",null);
            //月份进行处理
            data = changeYearOrMonth(creatZyssslList, data, "");
        }else if("year".equals(type)){
            has.put("ssfjmc",array);
            //默认最近三年
            data = nbMapper.findNumByZyssslZlYear(has);
            if(data.size()<1){
                return new ApiResult().failure("没有获取到任何数据!");
            }
//            //年份数据处理
//            data = changeYear(data);
        }else{
            return new ApiResult().failure("无效的参数!");
        }
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult findNumByZdgcYear(String name) {
        List<HashMap> data = nbMapper.findNumByZdgcYear(changeName(name));
        return new ApiResult().success(200, "成功",removeData2(data));
    }

    @Override
    public ApiResult findNumByZdgcMRYear() {
        List<HashMap> data = nbMapper.findNumByZdgcMRYear();
        return new ApiResult().success(200, "成功",removeData2(data));
    }

    @Override
    public ApiResult findNumByZdgcMRMonth() {
        HashMap dateMap = creatLtGtDate(11);
        HashMap has = new HashMap();
        has.put("ltnf",dateMap.get("ltnf"));
        has.put("gtnf",dateMap.get("gtnf"));
        List<HashMap> data = nbMapper.findNumByZdgcMRMonth(has);
        //生成本年本月往前一年的基本信息
        List<HashMap> creatZyssslList = creatZyssslMonth("ASC","");
        //月份进行处理
        data = changeYearOrMonth(creatZyssslList, data, "");
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult findNumByZyssYear(String name) {
        List<HashMap> data = nbMapper.findNumByZyssYear(changeName(name));
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult findNumByZyssMRYear() {
        List<HashMap> data = nbMapper.findNumByZyssMRYear();
        return new ApiResult().success(200, "成功",removeData2(data));
    }

    @Override
    public ApiResult findNumByZyssMRMonth() {
        HashMap dateMap = creatLtGtDate(11);
        HashMap has = new HashMap();
        has.put("ltnf",dateMap.get("ltnf"));
        has.put("gtnf",dateMap.get("gtnf"));
        List<HashMap> data = nbMapper.findNumByZyssMRMonth(has);
        //生成本年本月往前一年的基本信息
        List<HashMap> creatZyssslList = creatZyssslMonth("ASC","");
        //月份进行处理
        data = changeYearOrMonth(creatZyssslList, data, "");
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult findNumByZddwLtMonth(String name) {
        HashMap dateMap = creatLtGtDate(11);
        HashMap has = new HashMap();
        has.put("ltnf",dateMap.get("ltnf"));
        has.put("gtnf",dateMap.get("gtnf"));
        has.put("name",changeName(name));
        List<HashMap> data = nbMapper.findNumByZddwLtMonth(has);
        //生成本年本月往前一年的基本信息
        List<HashMap> creatZyssslList = creatZyssslMonth("ASC","");
        //月份进行处理
        data = changeYearOrMonth(creatZyssslList, data, "");
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult findNumByZyssLtMonth(String name) {
        HashMap dateMap = creatLtGtDate(11);
        HashMap has = new HashMap();
        has.put("ltnf",dateMap.get("ltnf"));
        has.put("gtnf",dateMap.get("gtnf"));
        has.put("name",changeName(name));
        List<HashMap> data = nbMapper.findNumByZyssLtMonth(has);
        //生成本年本月往前一年的基本信息
        List<HashMap> creatZyssslList = creatZyssslMonth("ASC","");
        //月份进行处理
        data = changeYearOrMonth(creatZyssslList, data, "");
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult yhslfx(Map map) {
        return new ApiResult(nbMapper.yhslfx(map));
    }

    @Override
    public ApiResult yhslfxMonth(Map map) {
        map.put("monthStr","'"+getMonthStr()+"'");
        return new ApiResult(nbMapper.yhslfxMonth(map));
    }

    @Override
    public ApiResult yhslfxYear(Map map) {
        return new ApiResult(nbMapper.yhslfxYear(map));
    }

    @Override
    public ApiResult getDataJcFx(String titleDateType) {
        return new ApiResult(nbMapper.getDataJcFx(titleDateType));
    }

    private List<HashMap> changeData(List<HashMap> list){
        String  oldList [] = {"吴中分局","吴江区局","姑苏分局","度假区分局","相城分局","常熟市局","张家港市局","太仓市局","昆山市局","高新区分局","园区分局"};
        String  newList [] = {"吴中区","吴江区","姑苏区","度假区","相城区","常熟市","张家港市","太仓市","昆山市","虎丘区","工业园区"};
        for(HashMap map : list){
            for(int i=0; i<oldList.length; i++){
                //判断是否集合里存在此名字
                if(map.get("ssfjmc").equals(oldList[i])) {
                    map.put("ssfjmc", newList[i]);
                    break;
                }
            }
        }
        return list;
    }

    private List<HashMap> changeData2(List<HashMap> list){
        String  oldList [] = {"吴中分局","吴江区局","姑苏分局","度假区分局","相城分局","常熟市局","张家港市局","太仓市局","昆山市局","高新区分局","园区分局"};
        String  newList [] = {"吴中区","吴江区","姑苏区","度假区","相城区","常熟市","张家港市","太仓市","昆山市","虎丘区","工业园区"};
        for(HashMap map : list){
            for(int i=0; i<oldList.length; i++){
                //判断是否集合里存在此名字
                if(map.get("ssfxjname").equals(oldList[i])) {
                    map.put("ssfxjname", newList[i]);
                    break;
                }
            }
        }
        return list;
    }

    private List<HashMap> changeData3(List<HashMap> list){
        String  oldList [] = {"吴中分局","吴江区局","姑苏分局","度假区分局","相城分局","常熟市局","张家港市局","太仓市局","昆山市局","高新区分局","园区分局"};
        String  newList [] = {"吴中区","吴江区","姑苏区","度假区","相城区","常熟市","张家港市","太仓市","昆山市","虎丘区","工业园区"};
        for(HashMap map : list){
            for(int i=0; i<oldList.length; i++){
                //判断是否集合里存在此名字
                if(map.get("qy").equals(oldList[i])) {
                    map.put("qy", newList[i]);
                    break;
                }
            }
        }
        return list;
    }

    private List<HashMap> removeData(List<HashMap> list){
        for(HashMap map :list) {
            if ("".equals(map.get("sspcsname"))) {
                list.remove(map);
                break;
            }
        }
        return list;
    }

    private List<HashMap> removeData2(List<HashMap> list){
        for(HashMap map :list) {
            if ("0".equals(map.get("nf"))) {
                list.remove(map);
                break;
            }
        }
        return list;
    }

    private String changeName(String name){
        if("吴中区".equals(name)){
            name = "吴中分局";
        }
        if("吴江区".equals(name)){
            name = "吴江区局";
        }
        if("姑苏区".equals(name)){
            name = "姑苏分局";
        }
        if("度假区".equals(name)){
            name = "度假区分局";
        }
        if("相城区".equals(name)){
            name = "相城分局";
        }
        if("常熟市".equals(name)){
            name = "常熟市局";
        }
        if("张家港市".equals(name)){
            name = "张家港市局";
        }
        if("太仓市".equals(name)){
            name = "太仓市局";
        }
        if("昆山市".equals(name)){
            name = "昆山市局";
        }
        if("虎丘区".equals(name)){
            name = "高新区分局";
        }
        if("工业园区".equals(name)){
            name = "园区分局";
        }
        return name;
    }

    private List<HashMap> addData(List<HashMap> list,String tjrq){
        if(list.size() == 0){
            HashMap<String,String> has = new HashMap<>();
            has.put("tjrq",tjrq);
            has.put("sum","0");
            list.add(has);
        }
        return list;
    }

    private HashMap changeData4(JSONObject obj,String tjrq){
        //获取data内的数据
        JSONArray arrys = obj.getJSONArray("data");
        //遍历入list
        final List list = new ArrayList<String>();
        if(arrys.size() > 0){
            for(int i=0 ;i<arrys.size() ;i++){
                if(arrys.get(i) != null) {
                    list.add(arrys.get(i));
                }
            }
        }else{
            list.clear();
        }
        //建一个map将数据put进去
        HashMap maps = new HashMap();
        maps.put("tjrq",tjrq);
        maps.put("array",arrys);
        return maps;
    }

    /**
     * 创建本年本月往前12个月的基本信息(升序排列)
     * @return 本月往前12个月的基本信息集合
     */
    private List<HashMap> creatZyssslMonth(String sort,String type){
        List<HashMap> list = new LinkedList<>();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("M月");
        SimpleDateFormat sdfp = new SimpleDateFormat("yyyyMM");
        SimpleDateFormat sdfpn = new SimpleDateFormat("yyyy年M月");
        for(int i=0;i<12;i++){
            HashMap has = new HashMap();
            String month = sdf.format(cal.getTime());
            String tjrq = sdfp.format(cal.getTime());
            String year = sdfpn.format(cal.getTime());
            if("ZddwMonth".equals(type)){
                has.put("sjname","省级治安重点单位");
                has.put("sjsnum",0);
                has.put("sname","市级治安重点单位");
                has.put("ssnum",0);
                has.put("xname","县市、区级治安重点单位");
                has.put("xsnum",0);
                has.put("sqname","社区关注单位");
                has.put("sqsnum",0);
            }
            has.put("tjrq",tjrq);
            has.put("year",year);
            has.put("yf",month);
            has.put("dwsl",0);
            has.put("sort",i);
            list.add(has);
            cal.add(Calendar.MONTH,-1);
        }
        //ASC升序 默认降序
        if(!StringUtils.isEmpty(sort) && "ASC".equals(sort)){
            Collections.sort(list,(o1, o2) -> {
                int a = Integer.valueOf(o1.get("sort").toString());
                int b = Integer.valueOf(o2.get("sort").toString());
                return b - a;
            });
        }
        return list;
    }

    /**
     * 创建 本年本月往前到入参的年份
     * @return 某月 到 本月
     */
    private HashMap creatLtGtDate(int month){
        HashMap dateMap = new HashMap();
        Calendar cl = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        //获得本年本月
        String gtnf = sdf.format(cl.getTime());
        //减去输入的month月 例如 month=11就是 去年5月到今年4年
        cl.add(Calendar.MONTH,-month);
        String ltnf = sdf.format(cl.getTime());
        dateMap.put("gtnf",gtnf);
        dateMap.put("ltnf",ltnf);
        return dateMap;
    }

    /**
     * 返回一年的12个月的集合
     * @param data 入参集合
     * @param creatData 基本集合
     * @return 修改后的集合
     */
    private List<HashMap> changeYearOrMonth(List<HashMap> creatData, List<HashMap> data, String type){
        for(HashMap dataMap : data){
            for(HashMap creatMap : creatData){
                switch (type){
                    case "" :
                        if(dataMap.get("tjrq").equals(creatMap.get("tjrq"))){
                            creatMap.put("dwsl",dataMap.get("dwsl"));
                            break;
                        }
                    case "ZddwMonth" :
                        if(dataMap.get("tjrq").equals(creatMap.get("tjrq"))){
                            creatMap.put("sjsnum",dataMap.get("sjsnum"));
                            creatMap.put("ssnum",dataMap.get("ssnum"));
                            creatMap.put("xsnum",dataMap.get("xsnum"));
                            creatMap.put("sqsnum",dataMap.get("sqsnum"));
                            break;
                        }
                }
            }
        }
        return creatData;
    }

    private List<HashMap> changeMonth(List<HashMap> list){
        String  oldList [] = {"01","02","03","04","05","06","07","08","09","10","11","12"};
        String  newList [] = {"1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"};
        for(HashMap map : list){
            for(int i=0; i<oldList.length; i++){
                //判断是否集合里存在此名字
                if(map.get("yf").equals(oldList[i])) {
                    map.put("yf", newList[i]);
                    break;
                }
            }
        }
        return list;
    }

    /**
     * 返回最近两年的集合
     * @param list 入参集合
     * @return 修改后的集合
     */
    private List<HashMap> changeYear(List<HashMap> list){
        String[] yearList = new String[3];
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat smd = new SimpleDateFormat("yyyy年");
        List<HashMap> newHasList = new ArrayList<>();
        boolean hex = false;
        for(int i=2;0<=i;i--){
            String yearName = smd.format(calendar.getTime());
            yearList[i] = yearName;
            calendar.add(Calendar.YEAR,-1);
        }

        for(int j=0;j<yearList.length;j++){
            for(HashMap map : list){
                if(map.get("yen").equals(yearList[j])){
                    newHasList.add(map);
                    hex = true;
                }
            }
            if(!hex){
                HashMap has = new HashMap();
                has.put("yen", yearList[j]);
                has.put("dwsl", 0);
                newHasList.add(has);
            }
            hex = false;
        }
        return newHasList;
    }

    /**
     * @param arr 入参集合
     * @param bl  T 匹配new替换old  F 匹配old替换new
     * @return 替换后的集合
     */
    private JSONArray changeNameJsonArray(JSONArray arr,boolean bl){
        String  oldList [] = {"吴中分局","吴江区局","姑苏分局","度假区分局","相城分局","常熟市局","张家港市局","太仓市局","昆山市局","高新区分局","园区分局"};
        String  newList [] = {"吴中区","吴江区","姑苏区","度假区","相城区","常熟市","张家港市","太仓市","昆山市","虎丘区","工业园区"};
        if( arr != null && arr.size()>0 ){
            for(int i=0 ; i < arr.size() ; i++){
                String qhName = arr.get(i).toString();
                for(int j=0 ; j < oldList.length ; j++){
                    if(bl && newList[j].equals(qhName)){
                        arr.set(i,oldList[j]);
                    }else if (!bl && oldList[i].equals(qhName)){
                        arr.set(i,newList[j]);
                    }else{
                        continue;
                    }
                }
            }
        }else{
            arr = null;
        }
        return arr;
    }

    private HashMap changeData5(JSONObject obj,String tjrq,String nf){
        //获取data内的数据
        JSONArray arrys = obj.getJSONArray("data");
        //遍历入list
        final List list = new ArrayList<String>();
        for(int i=0 ;i<arrys.size() ;i++){
            if(arrys.get(i) != null) {
                list.add(arrys.get(i));
            }
        }
        //建一个map将数据put进去
        HashMap maps = new HashMap();
        maps.put("tjrq",tjrq);
        maps.put("nf",nf);
        maps.put("array",arrys);
        return maps;
    }

    private String getMonthStr() {
        int num=12;
        String[] monthArr = new String[num];
        Date now = new Date();
        for (int i=0;i<num;i++) {
            Date temp = DateUtils.addMonths(now,0-i);
            monthArr[i]= DateFormatUtils.format(temp,"yyyy-MM");
        }
        ArrayUtils.reverse(monthArr);
        return String.join(",",monthArr);
    }


}
