package com.oceansoft.szga.smp.service.impl;

import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.mapper.ZfMapper;
import com.oceansoft.szga.smp.service.ZfService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *  出租房
 * @author wzj
 * @date 2019/1/19
 */

@Service
public class ZfServiceImpl implements ZfService {

    @Resource
    private ZfMapper zfMapper;


    @Override
    public ApiResult czfNum() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> czfNums = zfMapper.czfNum(tjrq);
        return new ApiResult().success(200,"返回数据",czfNums);

    }

    @Override
    public ApiResult czfNumDesc() {
        List<HashMap> czfNumDesc = zfMapper.czfNumDesc();
        return new ApiResult().success(200,"成功",czfNumDesc);
    }


    @Override
    public ApiResult qzfNum() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> qzfNum = zfMapper.qzfNum(tjrq);
        return new ApiResult().success(200,"返回数据",qzfNum);
    }

    @Override
    public ApiResult nearQzfNum(String num) {
        Map<String,String> dmp = dataNum(num);
        List<HashMap> nearQzfNum = zfMapper.nearQzfNum(dmp.get("time2"),dmp.get("time"));
        return new ApiResult().success(200,"返回数据",dateData(nearQzfNum,num,null));
    }

    @Override
    public ApiResult qzfMonthData(String time) {
        List<HashMap> qzfNum = zfMapper.qzfMonthData(time);
        return new ApiResult().success(200,"返回数据",qzfNum);
    }

    @Override
    public ApiResult qzfAreaNum(String xzqhmc,String num) {
        Map<String,String> dmp = dataNum(num);
        List<HashMap> qzfAreaNum = zfMapper.qzfAreaNum(xzqhmc,dmp.get("time2"),dmp.get("time"));
        return new ApiResult().success(200,"返回数据",dateData(qzfAreaNum,num,xzqhmc));
    }


    @Override
    public ApiResult areaAddNum() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(calendar.getTime());
        calendar.add(Calendar.MONTH, -1);
        int MaxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set( calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), MaxDay);
        String time2 = sdf.format(calendar.getTime());
        System.out.println(111111);
        System.out.println(time);
        System.out.println(111111);
        System.out.println(2222222);
        System.out.println(time2);
        System.out.println(222222);
        List<HashMap> areaAddNum = zfMapper.areaAddNum(time2,time);
        return new ApiResult().success(200,"成功",areaAddNum);
    }


    @Override
    public ApiResult qzfDangerous() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> qzfDanger = zfMapper.qzfDangerous(tjrq);
        return new ApiResult().success(200,"返回数据",qzfDanger);
    }

    @Override
    public ApiResult qzfDangerous2() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> qzfDanger = zfMapper.qzfDangerous(tjrq);
        List<HashMap> qzfDanger2 = zfMapper.qzfDangerous2(tjrq);
        return new ApiResult().success(200,"返回数据",qzfDanger2);
    }

    @Override
    public ApiResult qzwImpPerson() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> qzwImpPerson = zfMapper.qzwImpPerson(tjrq);
        return new ApiResult().success(200,"返回数据",qzwImpPerson);
    }
    @Override
    public ApiResult qzfImpPerson() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> qzfImpPerson = zfMapper.qzfImpPerson(tjrq);
        return new ApiResult().success(200,"返回数据",qzfImpPerson);
    }


    @Override
    public ApiResult dangerQzfNum() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> dangerQzfNum = zfMapper.dangerQzfNum(tjrq);
        return new ApiResult().success(200,"返回数据",dangerQzfNum);
    }

    @Override
    public ApiResult yhQzfTotleNum() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> dangerQzfNum = zfMapper.yhQzfTotleNum(tjrq);
        return new ApiResult().success(200,"返回成功",dangerQzfNum);
    }

    @Override
    public ApiResult nearYhQzf(String num) {
        Map<String,String> dmp = dataNum(num);
        List<HashMap> nearYhQzf = zfMapper.nearYhQzf(dmp.get("time2"),dmp.get("time"));
        return new ApiResult().success(200,"返回数据",dateData(nearYhQzf,num,null));
    }

    @Override
    public ApiResult dangerTypeFx() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> dangerTypeFx = zfMapper.dangerTypeFx(tjrq);
        return new ApiResult().success(200,"返回数据",dangerTypeFx);
    }

    @Override
    public ApiResult floatingPopulationNum() {
        List<HashMap> floatNum = zfMapper.floatingPopulationNum();
        return new ApiResult().success(200,"返回数据",floatNum);
    }

    @Override
    public ApiResult ldryFxData() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = zfMapper.ldryFxData(tjrq);
        return new ApiResult().success(200,"返回数据",data);
    }


    @Override
    public ApiResult notDangerTypeSb() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> notDangerTypeSB = zfMapper.notDangerTypeSb(tjrq);
        return new ApiResult().success(200,"返回数据",notDangerTypeSB);
    }

    @Override
    public ApiResult notDangerTypeSj() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> notDangerTypeSJ = zfMapper.notDangerTypeSj(tjrq);
        return new ApiResult().success(200,"返回数据",notDangerTypeSJ);
    }

    @Override
    public ApiResult fZaSj() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = zfMapper.fZaSj(tjrq);
        return new ApiResult().success(200,"返回数据",data);
    }

    @Override
    public ApiResult fZaDataSj() {
        List<HashMap> data = zfMapper.fZaDataSj();
        return new ApiResult().success(200,"返回数据",data);
    }

    @Override
    public ApiResult sigleData(String xzqhmc,String num) {
        Map<String,String> dmp = dataNum(num);
        List<HashMap> sigleData = zfMapper.sigleData(dmp.get("time2"),dmp.get("time"),xzqhmc);
        return new ApiResult().success(200,"返回数据",dateData(sigleData,num,xzqhmc));
    }

    @Override
    public ApiResult findDataByName(String xzqhmc, String num) {
        Map<String,String> dmp = dataNum(num);
        List<HashMap> data = zfMapper.sigleData(dmp.get("time2"),dmp.get("time"),xzqhmc);
        return new ApiResult().success(200,"成功",dateData(data,num,xzqhmc));
    }

    @Override
    public ApiResult fzaYhNum(String xzqhmc) {
        List<HashMap> num = zfMapper.fzaYhNum(xzqhmc);
        return new ApiResult().success(200,"返回数据",num);
    }

    @Override
    public ApiResult totleNum(String num) {
        Map<String,String> dmp = dataNum(num);
        List<HashMap> totleNum = zfMapper.totleNum(dmp.get("time2"),dmp.get("time"));
        return new ApiResult().success(200,"成功",dateData(totleNum,num,null));
    }

    @Override
    public ApiResult totleNum2(String num) {
        Map<String,String> dmp = dataNum(num);
        List<HashMap> totleNum2 = zfMapper.totleNum2(dmp.get("time2"),dmp.get("time"));
        return new ApiResult().success(200,"成功",dateData(totleNum2,num,null));
    }

    @Override
    public ApiResult zaYhNum() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> num = zfMapper.zaYhNum(tjrq);
        return new ApiResult().success(200,"返回数据",num);
    }

    @Override
    public ApiResult fzayhff() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> fzayhff = zfMapper.fzayhff(tjrq);
        return new ApiResult().success(200,"返回数据",fzayhff);
    }

    @Override
    public ApiResult fzayhrl() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> fzayhrl = zfMapper.fzayhrl(tjrq);
        return new ApiResult().success(200,"返回数据",fzayhrl);
    }
    @Override
    public ApiResult fzayhsh() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> fzayhsh = zfMapper.fzayhsh(tjrq);
        return new ApiResult().success(200,"返回数据",fzayhsh);
    }
    @Override
    public ApiResult fzayhza() {
        List<HashMap> fzayhza = zfMapper.fzayhza();
        return new ApiResult().success(200,"返回数据",fzayhza);
    }

    @Override
    public ApiResult qyldrysl() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> qyldrysl = zfMapper.qyldrysl(tjrq);
        return new ApiResult().success(200,"返回数据",qyldrysl);
    }

    @Override
    public ApiResult yhczwsj() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> yhczwsj = zfMapper.yhczwsj(tjrq);
        return new ApiResult().success(200,"返回数据",yhczwsj);
    }

    @Override
    public ApiResult yhqs(String num) {
        Map<String,String> dmp = dataNum(num);
        List<HashMap> yhqs = zfMapper.yhqs(dmp.get("time2"),dmp.get("time"));
        return new ApiResult().success(200,"返回数据",dateData(yhqs,num,null));
    }

    @Override
    public ApiResult yhqs2(String num) {
        Map<String,String> dmp = dataNum(num);
        List<HashMap> yhqs2 = zfMapper.yhqs2(dmp.get("time2"),dmp.get("time"));
        return new ApiResult().success(200,"返回数据",dateData(yhqs2,num,null));
    }

    @Override
    public ApiResult zayhsj() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> zayhsj = zfMapper.zayhsj(tjrq);
        return new ApiResult().success(200,"返回数据",zayhsj);
    }

    @Override
    public ApiResult yhsData() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tjrq = sdf.format(calendar.getTime());
        List<HashMap> data = zfMapper.yhsData(tjrq);
        return new ApiResult().success(200,"返回数据",data);
    }

    @Override
    public ApiResult nearYhsData(String num) {
        Map<String,String> dmp = dataNum(num);
        List<HashMap> nearYhsData = zfMapper.nearYhsData(dmp.get("time2"),dmp.get("time"));
        return new ApiResult().success(200,"返回数据",dateData(nearYhsData,num,null));
    }

    @Override
    public ApiResult singleAreaData(String xzqhmc,String num) {
        Map<String,String> dmp = dataNum(num);
        List<HashMap> singleAreaData = zfMapper.singleAreaData(dmp.get("time2"),dmp.get("time"),xzqhmc);
        return new ApiResult().success(200,"返回数据",dateData(singleAreaData,num,null));
    }

    @Override
    public ApiResult zayhFxsl() {
        List<HashMap> zayhFxsl = zfMapper.zayhFxsl();
        return new ApiResult().success(200,"返回数据",zayhFxsl);
    }

    @Override
    public ApiResult zayhWzgsl() {
        List<HashMap> zayhWzgsl = zfMapper.zayhWzgsl();
        return new ApiResult().success(200,"返回数据",zayhWzgsl);
    }

    @Override
    public ApiResult zayhZgsl() {
        List<HashMap> zayhZgsl = zfMapper.zayhZgsl();
        return new ApiResult().success(200,"返回数据",zayhZgsl);
    }

    @Override
    public ApiResult zdrysl() {
        List<HashMap> zdrysl = zfMapper.zdrysl();
        return new ApiResult().success(200,"返回数据",zdrysl);
    }

    @Override
    public ApiResult zaData() {
        List<HashMap> data = zfMapper.zaData();
        return new ApiResult().success(200,"返回数据",data);
    }

    @Override
    public ApiResult lzFxDataByLdrk() {
        List<HashMap> data = zfMapper.lzFxDataByLdrk();
        return new ApiResult().success(200,"返回数据",data);
    }


    public List<HashMap> dateData(List<HashMap> list,String num,String xzqhmc){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<HashMap> dateList = new ArrayList<>();
            for(int i=0;i<=Integer.valueOf(num);i++){
                HashMap map = new HashMap<String,String>();
                //设定一个基础为0的求和
                String totleFws = "0";
                String totleYhs = "0";
                String totleZgs = "0";
                //判断此时间是否在已经取出数据的list里存在
                Iterator it = list.iterator();
                while (it.hasNext()){
                    HashMap has = (HashMap) it.next();
                    if(has.get("tjrq").equals(sdf.format(calendar.getTime()))){
                        if(xzqhmc != null){
                        map.put("xzqhmc",has.get("xzqhmc").toString());
                        }
                        totleFws = has.get("totle_fws").toString();
                        totleYhs = has.get("totle_yhs").toString();
                        totleZgs = has.get("totle_zgs").toString();
                        //如果有值 赋值完毕 跳出迭代器循环
                        break;
                    }
                }
                map.put("tjrq",sdf.format(calendar.getTime()));
                map.put("totleFws",totleFws);
                map.put("totleYhs",totleYhs);
                map.put("totleZgs",totleZgs);
                dateList.add(map);
                calendar.add(Calendar.DATE,-1);
            }
        dateList.sort(new Comparator<Map>() {
            @Override
            public int compare(Map o1, Map o2) {
                SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd");
                int index1 = 0;
                int index2 = 0;
                try {
                    Long cl1 = sdft.parse(String.valueOf(o1.get("tjrq"))).getTime();
                    Long cl2 = sdft.parse(String.valueOf(o2.get("tjrq"))).getTime();
                    if(cl1 > cl2){
                        index1 =  1;
                    }else{
                        index2 =  1;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return index1-index2;
            }
        });
        return dateList;
    }

    public Map<String,String> dataNum(String num){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(calendar.getTime());
        String time2 =null;
        if("6".equals(num)){
            calendar.add(Calendar.DATE,-6);
            time2 = sdf.format(calendar.getTime());
        }else{
            calendar.add(Calendar.DATE,-29);
            time2 = sdf.format(calendar.getTime());
        }
        Map map = new HashMap<String,String>();
        map.put("time",time);
        map.put("time2",time2);
        return map;
    }
}
