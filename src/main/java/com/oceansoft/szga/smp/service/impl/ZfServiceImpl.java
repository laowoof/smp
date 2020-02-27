package com.oceansoft.szga.smp.service.impl;

import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.entity.CzfNum;
import com.oceansoft.szga.smp.entity.CzfPersonNum;
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
    public ApiResult czfPersonNum() {
        List<CzfPersonNum> czfPersonNums = zfMapper.czfPersonNum();
        return new ApiResult().success(200,"返回数据",czfPersonNums);
    }

    @Override
    public ApiResult czfNum() {
        List<CzfNum> czfNums = zfMapper.czfNum();
        return new ApiResult().success(200,"返回数据",czfNums);

    }

    @Override
    public ApiResult czfNumDesc() {
        List<CzfNum> czfNumDesc = zfMapper.czfNumDesc();
        return new ApiResult().success(200,"成功",czfNumDesc);
    }

    @Override
    public ApiResult czfImpPerson() {
        List<HashMap> czfNums = zfMapper.czfImpPerson();
        return new ApiResult().success(200,"返回数据",czfNums);
    }

    @Override
    public ApiResult qzfPersonNum() {
        List<HashMap> qzfPersonNums = zfMapper.qzfPersonNum();
        return new ApiResult().success(200,"返回数据",qzfPersonNums);
    }

    @Override
    public ApiResult qzfNum() {

        List<HashMap> qzfNum = zfMapper.qzfNum();
        return new ApiResult().success(200,"返回数据",qzfNum);
    }

    @Override
    public ApiResult qzfMonthData(String time) {
        List<HashMap> qzfNum = zfMapper.qzfMonthData(time);
        return new ApiResult().success(200,"返回数据",qzfNum);
    }

    @Override
    public ApiResult qzfAreaNum(String xzqhmc,String num) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> list = new ArrayList<String>();
        list.add(sdf.format(calendar.getTime()));
        for(int i=0;i<Integer.valueOf(num);i++){
            calendar.add(Calendar.DATE,-1);
            list.add(sdf.format(calendar.getTime()));
        }
        List dataList = new ArrayList();
        for(int i=0;i<list.size();i++){
            String time = list.get(i);
            List<HashMap> qzfNum = zfMapper.qzfAreaNum(xzqhmc,time);
            dataList.add(qzfNum);
        }
        return new ApiResult().success(200,"返回数据",dataList);
    }

    @Override
    public ApiResult qzfAreaAddNum(String xzqhmc, String num) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> list = new ArrayList<String>();
        list.add(sdf.format(calendar.getTime()));
        for(int i=0;i<Integer.valueOf(num);i++){
            calendar.add(Calendar.DATE,-1);
            list.add(sdf.format(calendar.getTime()));
        }
        List dataList = new ArrayList();
        for(int i=0;i<list.size();i++){
            String time = list.get(i);
            List<HashMap> qzfNum = zfMapper.qzfAreaAddNum(xzqhmc,time);
            dataList.add(qzfNum);
        }
        return new ApiResult().success(200,"返回数据",dataList);
    }

    @Override
    public ApiResult qzfTotleNum(String num) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> list = new ArrayList<String>();
        list.add(sdf.format(calendar.getTime()));
        for(int i=0;i<Integer.valueOf(num);i++){
            calendar.add(Calendar.DATE,-1);
            list.add(sdf.format(calendar.getTime()));
        }
        List dataList = new ArrayList();
        for(int i=0;i<list.size();i++){
            List<HashMap> qzfNum = zfMapper.qzfTotleNum(list.get(i));
            dataList.add(qzfNum);
        }
        return new ApiResult().success(200,"返回数据",dataList);
    }

    @Override
    public ApiResult addQzfData2(String xzqhmc) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String time = sdf.format(calendar.getTime());
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
        String time2 = sdf.format(calendar.getTime());
        List<HashMap> qzfNum = zfMapper.addQzfData2(time,time2,xzqhmc);
        return new ApiResult().success(200,"返回数据",qzfNum);
    }

    @Override
    public ApiResult addQzfData3(String num) {
//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String time = sdf.format(calendar.getTime());
//        calendar.set(Calendar.DATE,calendar.get(Calendar.DATE)-1);
//        String time2 = sdf.format(calendar.getTime());
        Map<String,String> dmp = dataNum(num);
        List<HashMap> sigleData = zfMapper.addQzfData3(dmp.get("time"),dmp.get("time2"));
        return new ApiResult().success(200,"返回数据",dateData(sigleData,num,null));
    }

    @Override
    public ApiResult qzfDangerous() {
        List<HashMap> qzfDanger = zfMapper.qzfDangerous();
        return new ApiResult().success(200,"返回数据",qzfDanger);
    }

    @Override
    public ApiResult qzfDangerous2() {
        List<HashMap> qzfDanger2 = zfMapper.qzfDangerous2();
        return new ApiResult().success(200,"返回数据",qzfDanger2);
    }

    @Override
    public ApiResult qzwImpPerson() {
        List<HashMap> qzwImpPerson = zfMapper.qzwImpPerson();
        return new ApiResult().success(200,"返回数据",qzwImpPerson);
    }
    @Override
    public ApiResult qzfImpPerson() {
        List<HashMap> qzfImpPerson = zfMapper.qzfImpPerson();
        return new ApiResult().success(200,"返回数据",qzfImpPerson);
    }

    @Override
    public ApiResult dangerCzf() {
        List<HashMap> dangerCzf = zfMapper.dangeroursCzf();
        return new ApiResult().success(200,"返回数据",dangerCzf);
    }

    @Override
    public ApiResult dangerCzfImpPerson() {
        List<HashMap> dangerCzfImpPerson = zfMapper.dangerCzfImpPerson();
        return new ApiResult().success(200,"返回数据",dangerCzfImpPerson);
    }

    @Override
    public ApiResult dangerQzfNum() {
        List<HashMap> dangerQzfNum = zfMapper.dangerQzfNum();
        return new ApiResult().success(200,"返回数据",dangerQzfNum);
    }

    @Override
    public ApiResult yhQzfTotleNum(String xzqhmc) {
        List<HashMap> dangerQzfNum = zfMapper.yhQzfTotleNum(xzqhmc);
        return new ApiResult().success(200,"返回数据",dangerQzfNum);
    }

    @Override
    public ApiResult dangerTypeFx() {
        List<HashMap> dangerTypeFx = zfMapper.dangerTypeFx();
        return new ApiResult().success(200,"返回数据",dangerTypeFx);
    }
    @Override
    public ApiResult floatingPopulationS() {
        List<HashMap> floatPrivate = zfMapper.floatingPopulationS();
        return new ApiResult().success(200,"返回数据",floatPrivate);
    }

    @Override
    public ApiResult floatingPopulationShi() {
        List<HashMap> floatCity = zfMapper.floatingPopulationS();
        return new ApiResult().success(200,"返回数据",floatCity);
    }

    @Override
    public ApiResult floatingPopulationX() {
        List<HashMap> floatArea = zfMapper.floatingPopulationX();
        return new ApiResult().success(200,"返回数据",floatArea);
    }

    @Override
    public ApiResult floatingPopulationAge() {
        List<HashMap> floatAge = zfMapper.floatingPopulationAge();
        return new ApiResult().success(200,"返回数据",floatAge);
    }

    @Override
    public ApiResult floatingPopulationNum() {
        List<HashMap> floatNum = zfMapper.floatingPopulationNum();
        return new ApiResult().success(200,"返回数据",floatNum);
    }

    @Override
    public ApiResult findNumDesc() {
        List<HashMap> num = zfMapper.findNumDesc();
        return new ApiResult().success(200,"成功",num);
    }

    @Override
    public ApiResult floatingPopulationTrueNum() {
        List<HashMap> floatTrueNum = zfMapper.floatingPopulationTrueNum();
        return new ApiResult().success(200,"返回数据",floatTrueNum);
    }
    @Override
    public ApiResult notDangerType() {
        List<HashMap> notDangerType = zfMapper.notDangerType();
        return new ApiResult().success(200,"返回数据",notDangerType);
    }

    @Override
    public ApiResult notDangerTypeSb() {
        List<HashMap> notDangerTypeSB = zfMapper.notDangerTypeSb();
        return new ApiResult().success(200,"返回数据",notDangerTypeSB);
    }

    @Override
    public ApiResult notDangerTypeSj() {
        List<HashMap> notDangerTypeSJ = zfMapper.notDangerTypeSj();
        return new ApiResult().success(200,"返回数据",notDangerTypeSJ);
    }

    @Override
    public ApiResult fzasjDesc() {
        List<HashMap> data = zfMapper.fzasjDesc();
        return new ApiResult().success(200,"成功",data);
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
    public ApiResult zaYhNum(String xzqhmc) {
        List<HashMap> num = zfMapper.zaYhNum(xzqhmc);
        return new ApiResult().success(200,"返回数据",num);
    }

    @Override
    public ApiResult czfImpXzqh() {
        List<HashMap> czfImpXzqh = zfMapper.czfImpXzqh();
        return new ApiResult().success(200,"返回数据",czfImpXzqh);
    }

    @Override
    public ApiResult fzayhff() {
        List<HashMap> fzayhff = zfMapper.fzayhff();
        return new ApiResult().success(200,"返回数据",fzayhff);
    }

    @Override
    public ApiResult fzayhrl() {
        List<HashMap> fzayhrl = zfMapper.fzayhrl();
        return new ApiResult().success(200,"返回数据",fzayhrl);
    }
    @Override
    public ApiResult fzayhsh() {
        List<HashMap> fzayhsh = zfMapper.fzayhsh();
        return new ApiResult().success(200,"返回数据",fzayhsh);
    }
    @Override
    public ApiResult fzayhza() {
        List<HashMap> fzayhza = zfMapper.fzayhza();
        return new ApiResult().success(200,"返回数据",fzayhza);
    }

    @Override
    public ApiResult qyldrysl() {
        List<HashMap> qyldrysl = zfMapper.qyldrysl();
        return new ApiResult().success(200,"返回数据",qyldrysl);
    }

    @Override
    public ApiResult czfzdrrsXzqh() {
        List<HashMap> xzqh = zfMapper.czfzdrrsXzqh();
        return new ApiResult().success(200,"返回数据",xzqh);
    }

    @Override
    public ApiResult czfzdrrsZdlx() {
        List<HashMap> zdlx = zfMapper.czfzdrrsZdlx();
        return new ApiResult().success(200,"返回数据",zdlx);
    }

    @Override
    public ApiResult yhczfzdrLx() {
        List<HashMap> lx = zfMapper.yhczfzdrLx();
        return new ApiResult().success(200,"返回数据",lx);
    }

    @Override
    public ApiResult yhczwsj() {
        List<HashMap> yhczwsj = zfMapper.yhczwsj();
        return new ApiResult().success(200,"返回数据",yhczwsj);
    }

    @Override
    public ApiResult yhfwpcs() {
        List<HashMap> yhfwpcs = zfMapper.yhfwpcs();
        return new ApiResult().success(200,"返回数据",yhfwpcs);
    }

    @Override
    public ApiResult yhqs() {
        List<HashMap> yhqs = zfMapper.yhqs();
        return new ApiResult().success(200,"返回数据",yhqs);
    }

    @Override
    public ApiResult yhqzfrs() {
        List<HashMap> yhqzfrs = zfMapper.yhqzfrs();
        return new ApiResult().success(200,"返回数据",yhqzfrs);
    }

    @Override
    public ApiResult qzfzdrrsXzqh() {
        List<HashMap> xzqh= zfMapper.qzfzdrrsXzqh();
        return new ApiResult().success(200,"返回数据",xzqh);
    }

    @Override
    public ApiResult qzfzdrrsZdlx() {
        List<HashMap> zdlx = zfMapper.qzfzdrrsZdlx();
        return new ApiResult().success(200,"返回数据",zdlx);
    }

    @Override
    public ApiResult yhqzfzdry() {
        List<HashMap> yhqzfzdry = zfMapper.yhqzfzdry();
        return new ApiResult().success(200,"返回数据",yhqzfzdry);
    }

    @Override
    public ApiResult yhqzfzdrLx() {
        List<HashMap> yhqzfzdrLx = zfMapper.yhqzfzdrLx();
        return new ApiResult().success(200,"返回数据",yhqzfzdrLx);
    }

    @Override
    public ApiResult yhqzwsj() {
        List<HashMap> yhqzwsj = zfMapper.yhqzwsj();
        return new ApiResult().success(200,"返回数据",yhqzwsj);
    }

    @Override
    public ApiResult yhqzwzdr() {
        List<HashMap> yhqzwzdr = zfMapper.yhqzwzdr();
        return new ApiResult().success(200,"返回数据",yhqzwzdr);
    }

    @Override
    public ApiResult zayhlx() {
        List<HashMap> zayhlx = zfMapper.zayhlx();
        return new ApiResult().success(200,"返回数据",zayhlx);
    }

    @Override
    public ApiResult zayhsj() {
        List<HashMap> zayhsj = zfMapper.zayhsj();
        return new ApiResult().success(200,"返回数据",zayhsj);
    }

    @Override
    public ApiResult zayhsjDesc() {
        List<HashMap> zayhsj = zfMapper.zayhsjDesc();
        return new ApiResult().success(200,"返回数据",zayhsj);
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
    public ApiResult czfzdry() {
        List<HashMap> czfzdry = zfMapper.czfzdry();
        return new ApiResult().success(200,"返回数据",czfzdry);
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
