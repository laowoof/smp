package com.oceansoft.szga.smp.service.impl;

import com.oceansoft.szga.smp.entity.Queryparems;
import com.oceansoft.szga.smp.mapper.DeliverylogisticsMapper;
import com.oceansoft.szga.smp.service.DeliverylogisticsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
@Transactional(rollbackFor = Exception.class)
public class DeliverylogisticsServiceImpl  implements DeliverylogisticsService {


    @Resource
    private DeliverylogisticsMapper mapper;

    @Override
    public Map<String, Object> sumDeliverylogistics() {
        return mapper.sumDeliverylogistics();
    }

    @Override
    public List<Map<String, Object>> dwfl() {
        List<Map<String, Object>> list =new ArrayList<>() ;
        List<Map<String, Object>> dwfl = mapper.dwfl();
        String jdwl = String.valueOf(mapper.sumDeliverylogistics().get("jdwl"));
        int j =Integer.valueOf(jdwl); int f =j;
        for (int i =0;i<dwfl.size();i++){
            Map<String, Object> map =new HashMap<>();
            String num = String.valueOf(dwfl.get(i).get("num"));
            Float res=(float) Integer.valueOf(num)/Integer.valueOf(jdwl);
            map.put("bl",res);
            map.put("name",dwfl.get(i).get("name"));
            map.put("value",num);
            list.add(map);
            j -= Integer.valueOf(num);
        }
        Map<String, Object> aa =new HashMap<>();
        Float res=(float) j/f;
        aa.put("bl",res);
        aa.put("name","其他");
        aa.put("value",j);
        list.add(aa);
        return list;
    }

    @Override
    public List<Map<String, Object>> cyry() {
        List<Map<String, Object>> list =new ArrayList<>() ;
        List<Map<String, Object>> cyry = mapper.cyry();
        String s = String.valueOf(mapper.sumDeliverylogistics().get("cyry"));
        for (int i =0;i<cyry.size();i++){
            Map<String, Object> map =new HashMap<>();
            String num = String.valueOf(cyry.get(i).get("num"));
            Float res=(float) Integer.valueOf(num)/Integer.valueOf(s);
            map.put("bl",res);
            map.put("name",cyry.get(i).get("name"));
            map.put("value",num);
            list.add(map);
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> yhlx() {
        List<Map<String, Object>> list =new ArrayList<>() ;
        List<Map<String, Object>> yhlx = mapper.yhlx();
        String s = String.valueOf(mapper.sumDeliverylogistics().get("cyry"));
        int ll = 0;
        for (int i =0;i<yhlx.size();i++){
            if (i<10){
                Map<String, Object> map =new HashMap<>();
                String num = String.valueOf(yhlx.get(i).get("num"));
                map.put("name",yhlx.get(i).get("name"));
                map.put("value",num);
                list.add(map);
            }else {
                Integer num =Integer.valueOf(String.valueOf(yhlx.get(i).get("num")));
                ll+=num;
            }
        }
        Map<String, Object> aa =new HashMap<>();
        aa.put("name","其他");
        aa.put("value",ll);
        list.add(aa);
        return list;
    }


    @Override
    public List<Map<String, Object>> jdadnryfl(Queryparems queryparems) {
        List<Map<String, Object>> list =new ArrayList<>();
        if (queryparems.getType().equals("jdfl")){
            list= mapper.jdfl(queryparems.getMc());
        }else {
            list= mapper.ryfl(queryparems.getMc());
        }
        int he =0;
        List<String> orderList = Arrays.asList("张家港市局", "常熟市局", "昆山市局", "太仓市局", "吴江区局", "园区分局", "姑苏分局", "高新区分局", "吴中分局", "相城分局", "度假区分局");
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (int i =0 ;i<orderList.size();i++){
            for (int k = 0; k < list.size(); k++) {
                String xzqh = String.valueOf(list.get(k).get("xzqh"));
                String s = orderList.get(i);
                if (xzqh.equals(s) ){
                    Map<String, Object> resultMap = new HashMap<>();
                    int mm =Integer.valueOf(String.valueOf(list.get(k).get("num")));
                    he+= mm;
                }
            }
        }
        for (int i =0 ;i<orderList.size();i++){
            for (int k = 0; k < list.size(); k++) {
                String xzqh = String.valueOf(list.get(k).get("xzqh"));
                String s = orderList.get(i);
                if (xzqh.equals(s) ){
                    Map<String, Object> resultMap = new HashMap<>();
                    int mm =Integer.valueOf(String.valueOf(list.get(k).get("num")));
                    String name = String.valueOf(list.get(k).get("xzqh"));
                    name =name.substring(0,name.length()-2);
                    resultMap.put("dwmc", name);
                    resultMap.put("value", list.get(k).get("num"));
                    float res= (float) mm /he *100;
                    int p=getRoundNum(res);
                    resultMap.put("bl",p);
                    resultList.add(resultMap);
                }
            }
        }
        return resultList;
    }

    @Override
    public List<Map<String, Object>> dwdj(Queryparems queryparems) {
        List<Map<String, Object>> dwfx = mapper.dwdj(queryparems);
        List<Map<String, Object>> list =new ArrayList<>();
        int he =0;
        for (int i =0;i<dwfx.size();i++){
            int num = Integer.valueOf(String.valueOf(dwfx.get(i).get("num")));
            he+=num;
        }
        for (int i =0;i<dwfx.size();i++){
            int num = Integer.valueOf(String.valueOf(dwfx.get(i).get("num")));
            float res= (float) num /he *100;
            int p=getRoundNum(res);
            Map<String,Object> map =new HashMap<>();
            map.put("name",dwfx.get(i).get("name"));
            map.put("value",num);
            map.put("bl",p);
            list.add(map);
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> zabw() {
        List<Map<String, Object>> list =mapper.zabw();
        List<String> orderList = Arrays.asList("张家港市局", "常熟市局", "昆山市局", "太仓市局", "吴江区局", "园区分局", "姑苏分局", "高新区分局", "吴中分局", "相城分局", "度假区分局");
        List<Map<String, Object>> resultList = new ArrayList<>();
        Integer he = mapper.zabwzsl();
        for (int i =0 ;i<orderList.size();i++){
            for (int k = 0; k < list.size(); k++) {
                String xzqh = String.valueOf(list.get(k).get("xzqh"));
                String s = orderList.get(i);
                if (xzqh.equals(s) ){
                    Map<String, Object> resultMap = new HashMap<>();
                    int mm =Integer.valueOf(String.valueOf(list.get(k).get("num")));
                    String name = String.valueOf(list.get(k).get("xzqh"));
                    name =name.substring(0,name.length()-2);
                    resultMap.put("name", name);
                    resultMap.put("value", list.get(k).get("num"));
                    float res= (float) mm /he *100;
                    int p=getRoundNum(res);
                    resultMap.put("bl",p);
                    resultList.add(resultMap);
                }
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("name","总数量");
        map.put("value",he);
        resultList.add(map);
        return resultList;
    }

    @Override
    public List<Map<String, Object>> aqzr() {
        List<Map<String, Object>> list =mapper.aqzr();
        List<String> orderList = Arrays.asList("张家港市局", "常熟市局", "昆山市局", "太仓市局", "吴江区局", "园区分局", "姑苏分局", "高新区分局", "吴中分局", "相城分局", "度假区分局");
        List<Map<String, Object>> resultList = new ArrayList<>();
        Integer he = mapper.aqzrzsl();
        for (int i =0 ;i<orderList.size();i++)
            for (int k = 0; k < list.size(); k++) {
                String xzqh = String.valueOf(list.get(k).get("xzqh"));
                String s = orderList.get(i);
                if (xzqh.equals(s)) {
                    Map<String, Object> resultMap = new HashMap<>();
                    int mm = Integer.valueOf(String.valueOf(list.get(k).get("num")));
                    String name = String.valueOf(list.get(k).get("xzqh"));
                    name =name.substring(0,name.length()-2);
                    resultMap.put("name", name);
                    resultMap.put("value", list.get(k).get("num"));
                    float res = (float) mm / he * 100;
                    int p = getRoundNum(res);
                    resultMap.put("bl", p);
                    resultList.add(resultMap);
                }
            }
        Map<String, Object> map = new HashMap<>();
        return resultList;
    }

    @Override
    public List<Map<String, Object>> dwjc(Queryparems queryparems){
        List<Map<String, Object>> resultList = new ArrayList<>();
        List<String> orderList = Arrays.asList("张家港市局", "常熟市局", "昆山市局", "太仓市局", "吴江区局", "园区分局", "姑苏分局", "高新区分局", "吴中分局", "相城分局", "度假区分局");
        String jclxdm = queryparems.getJclxdm();
        System.out.println("dsfghferwrrgfh"+jclxdm);
        List<Map<String, Object>> dwjc1 = mapper.dwjc("0",jclxdm);
        List<Map<String, Object>> dwjc2 = mapper.dwjc("1",jclxdm);
        List<Map<String, Object>> dwjc3 = mapper.dwjc("2",jclxdm);
        List<Map<String, Object>> dwjc4 = mapper.dwjc("",jclxdm);
        for (int i =0 ;i<orderList.size();i++){
            for (int k = 0; k < dwjc1.size(); k++) {
                String xzqh1 = String.valueOf(dwjc1.get(k).get("name"));
                for (int q = 0; q < dwjc2.size(); q++) {
                    String xzqh2 = String.valueOf(dwjc2.get(q).get("name"));
                    for (int w = 0; w < dwjc3.size(); w++) {
                        String xzqh3 = String.valueOf(dwjc3.get(w).get("name"));
                        for (int e = 0; e < dwjc4.size(); e++) {
                            String xzqh4 = String.valueOf(dwjc4.get(e).get("name"));
                            if (orderList.get(i).equals(xzqh1) && xzqh1.equals(xzqh2) && xzqh2.equals(xzqh3) && xzqh3.equals(xzqh4)) {
                                Map<String, Object> resultMap = new HashMap<>();
                                resultMap.put("name", xzqh1);
                                resultMap.put("已检查数", dwjc2.get(k).get("num"));
                                resultMap.put("待检查数", dwjc1.get(q).get("num"));
                                resultMap.put("缺检查数", dwjc3.get(w).get("num"));
                                resultMap.put("检查数", dwjc4.get(e).get("num"));
                                resultList.add(resultMap);
                            }
                        }
                    }
                }
            }
        }
        return resultList;
    }

    @Override
    public List<Map<String, Object>> dwfx(Queryparems queryparems) {
        List<Map<String, Object>> dwfx = mapper.dwfx(queryparems);
        List<Map<String, Object>> list =new ArrayList<>();
        int he =0;
        for (int i =0;i<dwfx.size();i++){
            int num = Integer.valueOf(String.valueOf(dwfx.get(i).get("num")));
            he+=num;
        }
        for (int i =0;i<dwfx.size();i++){
            int num = Integer.valueOf(String.valueOf(dwfx.get(i).get("num")));
            float res= (float) num /he *100;
            int k=getRoundNum(res);
            Map<String,Object> map =new HashMap<>();
            map.put("name",dwfx.get(i).get("name"));
            map.put("value",num);
            map.put("bl",k);
            list.add(map);
        }
        return list;
    }




    public String getLast7Days(int i) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_WEEK, -i);
        Date m = c.getTime();
        return sdf.format(m);
    }

    /**
     * 获取前多少月的月份 所有  不带0
     * @return
     */
    private String[] getYfTime() {
        String[] months = new String[12];
        Calendar cal = Calendar.getInstance();
        //如果当前日期大于二月份的天数28天或者29天会导致计算月份错误，会多出一个三月份，故设置一个靠前日期解决此问题
        cal.set(Calendar.DAY_OF_MONTH, 1);
        for (int i = 0; i < 12; i++) {
            months[11 - i] = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1);
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1); //逐次往前推1个月
        }
        return months;
    }

    //四舍五入
    public int getRoundNum(float num){
        float n=(float)((int)num)+0.5f;
        if(num<n){
            return  (int)(n-0.5);
        }else{
            return  (int)(n+0.5f);
        }
    }







}
