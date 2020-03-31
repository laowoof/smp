package com.oceansoft.szga.smp.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableMap;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.mapper.NbMapper;
import com.oceansoft.szga.smp.service.NbService;
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
        return new ApiResult().success(200,"成功",data);
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
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findDataByOrder(tjrq);
        return new ApiResult().success(200, "成功", changeData(data));
    }

    @Override
    public ApiResult findDataByLimit(String name) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findDataByLimit(tjrq,changeName(name));
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
        return new ApiResult().success(200, "成功", data);
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
        return new ApiResult().success(200, "成功", data);
    }

    @Override
    public ApiResult findDataByZz() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findDataByZz(tjrq);
        return new ApiResult().success(200, "成功", changeData(data));
    }

    @Override
    public ApiResult findDataByZzLinit(String name) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findDataByZzLinit(tjrq,changeName(name));
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
        return new ApiResult().success(200, "成功",data);
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
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findDataZySsPcs(tjrq,changeName(name));
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
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findDataYhFxPcs(tjrq,changeName(name));
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
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findDataJctjCgPcs(tjrq,changeName(name));
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
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findDataJctjZxPcs(tjrq,changeName(name));
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
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findDataJctjQsPcs(tjrq,changeName(name));
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
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findDataJctjZdPcs(tjrq,changeName(name));
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
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findDataJctjWzgPcs(tjrq,changeName(name));
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
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findDataJctjZgPcs(tjrq,changeName(name));
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
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByZyssFx(tjrq);
        return new ApiResult().success(200, "成功",changeData(data));
    }

    public ApiResult findNumByZddwjcfx(String nf) {
        if(StringUtils.isEmpty(nf) || 4 != nf.length()){
            return new ApiResult().failure("非法参数!");
        }
        List<HashMap> data = nbMapper.findNumByZddwjcfx(nf);
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
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findNumByZddwZl(changeData4(obj,tjrq));
        return new ApiResult().success(200, "成功",changeData3(data));
    }

    @Override
    public ApiResult findDataByZddwYear() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findDataByZddwYear(tjrq);
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult findDataByZddwMonth() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        int year = calendar.get(Calendar.YEAR);
        List<HashMap> data = nbMapper.findDataByZddwMonth(tjrq,String.valueOf(year));
        return new ApiResult().success(200, "成功",changeMonth(data));
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
        return new ApiResult().success(200, "成功",changeData(data));
    }

    @Override
    public ApiResult findDataQsyMonth() {
        List<HashMap> data = nbMapper.findDataQsyMonth();
        return new ApiResult().success(200, "成功",changeMonth(data));
    }

    @Override
    public ApiResult findDataQsyYear() {
        List<HashMap> data = nbMapper.findDataQsyYear();
        return new ApiResult().success(200, "成功",data);
    }

    @Override
    public ApiResult findDataQsyLtMonth(String name) {
        List<HashMap> data = nbMapper.findDataQsyLtMonth(changeName(name));
        return new ApiResult().success(200, "成功",changeMonth(data));
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
            //默认今年无法选择
            has.put("nf","2020");
            has.put("ssfjmc",array);
            data = nbMapper.findNumByZyssslZlMonth(has);
            //月份进行处理
            data = changeMonth(data);
        }else if("year".equals(type)){
            has.put("ssfjmc",array);
            //默认最近三年
            data = nbMapper.findNumByZyssslZlYear(has);
            //年份数据处理
            data = changeYear(data);
        }else{
            return new ApiResult().failure("无效的参数!");
        }
        if(data.size()<1){
            return new ApiResult().failure("没有获取到任何数据!");
        }
        return new ApiResult().success(200, "成功",data);
    }

    public List<HashMap> changeData(List<HashMap> list){
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
    public List<HashMap> changeData2(List<HashMap> list){
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
    public List<HashMap> changeData3(List<HashMap> list){
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
    public List<HashMap> removeData(List<HashMap> list){
        for(HashMap map :list) {
            if ("".equals(map.get("sspcsname"))) {
                list.remove(map);
                break;
            }
        }
        return list;
    }
    public String changeName(String name){
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
    public List<HashMap> addData(List<HashMap> list,String tjrq){
        if(list.size() == 0){
            HashMap<String,String> has = new HashMap<>();
            has.put("tjrq",tjrq);
            has.put("sum","0");
            list.add(has);
        }
        return list;
    }
    public HashMap changeData4(JSONObject obj,String tjrq){
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
        maps.put("array",arrys);
        return maps;
    }

    /**
     * 返回一年的12个月的集合
     * @param list 入参集合
     * @return 修改后的集合
     */
    public List<HashMap> changeMonth(List<HashMap> list){
        String  oldList [] = {"01","02","03","04","05","06","07","08","09","10","11","12"};
        String  newList [] = {"1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"};
        List<HashMap> newHasList = new ArrayList<>();
        boolean hex = false;
        for(int i=0; i<oldList.length; i++){
            for(HashMap map : list){
                //判断是否集合里存在此名字
                if(map.get("yf").equals(oldList[i])) {
                    map.put("yf", newList[i]);
                    newHasList.add(map);
                    hex = true;
                }
            }
            if(!hex){
                HashMap has = new HashMap();
                has.put("yf", newList[i]);
                has.put("dwsl", 0);
                newHasList.add(has);
            }
            hex = false;
        }
        return newHasList;
    }

    /**
     * 返回最近两年的集合
     * @param list 入参集合
     * @return 修改后的集合
     */
    public List<HashMap> changeYear(List<HashMap> list){
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
    public JSONArray changeNameJsonArray(JSONArray arr,boolean bl){
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
    public HashMap changeData5(JSONObject obj,String tjrq,String nf){
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

}
