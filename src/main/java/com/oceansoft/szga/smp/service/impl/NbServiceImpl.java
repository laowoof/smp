package com.oceansoft.szga.smp.service.impl;

import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.mapper.NbMapper;
import com.oceansoft.szga.smp.service.NbService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

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
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = nbMapper.findDataByZzOne(tjrq);
        for(HashMap map :data) {
            HashMap<String,String> has = new HashMap<>();
            has.put("ssfjmc","度假区分局");
            has.put("ssfjdm","320593000000");
            has.put("sum","0");
            String dm = "320593000000";
            if (!dm.equals(map.get("ssfjdm"))) {
                data.add(6,has);
                break;
            }
        }
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
}
