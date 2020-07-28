package com.oceansoft.szga.smp.service.impl;

import com.alibaba.excel.util.StringUtils;
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
        List<Map<String, Object>> list;
        String mc = queryparems.getMc();
        List<String> fjmcList = null;
        if (!StringUtils.isEmpty(mc)) {
            String[] split = mc.split(",");
            fjmcList = Arrays.asList(split);
        }
        if (queryparems.getType().equals("jdfl")){
            list= mapper.jdfl(fjmcList);
        }else {
            list= mapper.ryfl(fjmcList);
        }
        int he =0;
        List<String> orderList = Arrays.asList("张家港市局", "常熟市局", "昆山市局", "太仓市局", "吴江区局", "园区分局", "姑苏分局", "高新区分局", "吴中分局", "相城分局", "度假区分局");
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (int k = 0; k < list.size(); k++) {
            he+=Integer.valueOf(String.valueOf(list.get(k).get("num")));
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
                }else {
                    Map<String, Object> resultMap = new HashMap<>();
                    resultMap.put("name", orderList.get(i).substring(0,orderList.size()-2));
                    resultMap.put("value", "0");
                    resultMap.put("bl","0");
                    resultList.add(resultMap);
                }
            }
        }
        return resultList;
    }

    @Override
    public List<Map<String, Object>> dwdj(Queryparems queryparems) {
        String mc = queryparems.getXzqhs();
        List<String> fjmcList = null;
        if (!StringUtils.isEmpty(mc)) {
            String[] split = mc.split(",");
            fjmcList = Arrays.asList(split);
        }
        List<Map<String, Object>> dwfx = mapper.dwdj(fjmcList);
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
        List<Map<String, Object>> zabw = mapper.zabw();
        List<String> orderList = Arrays.asList("张家港市局", "常熟市局", "昆山市局", "太仓市局", "吴江区局", "园区分局", "姑苏分局", "高新区分局", "吴中分局", "相城分局", "度假区分局");
        List<Map<String, Object>> resultList = new ArrayList<>();
        Integer he = mapper.zabwzsl();
        for (int i =0 ;i<orderList.size();i++){
            for (int k = 0; k < zabw.size(); k++) {
                String xzqh = String.valueOf(zabw.get(k).get("xzqh"));
                String s = orderList.get(i);
                if (xzqh.equals(s) ){
                    Map<String, Object> resultMap = new HashMap<>();
                    int mm =Integer.valueOf(String.valueOf(zabw.get(k).get("num")));
                    String name = String.valueOf(zabw.get(k).get("xzqh"));
                    name =name.substring(0,name.length()-2);
                    resultMap.put("name", name);
                    resultMap.put("value", zabw.get(k).get("num"));
                    float res= (float) mm /he *100;
                    int p=getRoundNum(res);
                    resultMap.put("bl",p);
                    resultList.add(resultMap);
                }else {
                    Map<String, Object> resultMap = new HashMap<>();
                    resultMap.put("name", orderList.get(i).substring(0,orderList.size()-2));
                    resultMap.put("value", "0");
                    resultMap.put("bl","0");
                    resultList.add(resultMap);
                }
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("zsl",he);
        resultList.add(map);
        return resultList;
    }

    @Override
    public List<Map<String, Object>> aqzr() {
        List<String> orderList = Arrays.asList("张家港市局", "常熟市局", "昆山市局", "太仓市局", "吴江区局", "园区分局", "姑苏分局", "高新区分局", "吴中分局", "相城分局", "度假区分局");
        List<Map<String, Object>> resultList = new ArrayList<>();
        Queryparems queryparems =new Queryparems();
        for (int i =0 ;i<orderList.size();i++){
            String s = orderList.get(i);
            queryparems.setXzqhs(s);
            Integer he = mapper.aqzrzsl(queryparems);
            List<Map<String, Object>> list =mapper.aqzr(queryparems);
            for (int k = 0; k < list.size(); k++) {
                String xzqh = String.valueOf(list.get(k).get("xzqh"));
                if (xzqh.equals(s)) {
                    Map<String, Object> resultMap = new HashMap<>();
                    int mm = Integer.valueOf(String.valueOf(list.get(k).get("num")));
                    String name = String.valueOf(list.get(k).get("xzqh"));
                    name =name.substring(0,name.length()-2);
                    resultMap.put("name", name);
                    resultMap.put("value1", list.get(k).get("num"));
                    resultMap.put("value2",he);
                    float res = (float) mm / he * 100;
                    int p = getRoundNum(res);
                    resultMap.put("bl", p);
                    resultList.add(resultMap);
                }else {
                    Map<String, Object> resultMap = new HashMap<>();
                    resultMap.put("name", orderList.get(i).substring(0,orderList.size()-2));
                    resultMap.put("value1", "0");
                    resultMap.put("value2", "0");
                    resultMap.put("bl","0");
                    resultList.add(resultMap);
                }
            }
        }
        return resultList;
    }

    @Override
    public List<Map<String, Object>> dwjc(Queryparems queryparems){
        List<Map<String, Object>> resultList = new ArrayList<>();
        List<String> orderList = Arrays.asList("张家港市局", "常熟市局", "昆山市局", "太仓市局", "吴江区局", "园区分局", "姑苏分局", "高新区分局", "吴中分局", "相城分局", "度假区分局");
        String jclxdm = queryparems.getJclxdm();
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
                                resultMap.put("name", xzqh1.substring(0,xzqh1.length()-2));
                                resultMap.put("yjcs", dwjc2.get(k).get("num"));
                                resultMap.put("djcs", dwjc1.get(q).get("num"));
                                resultMap.put("qjcs", dwjc3.get(w).get("num"));
                                resultMap.put("jcs", dwjc4.get(e).get("num"));
                                resultList.add(resultMap);
                            }else {
                                Map<String, Object> resultMap = new HashMap<>();
                                resultMap.put("name", orderList.get(i).substring(0,orderList.size()-2));
                                resultMap.put("yjcs", "0");
                                resultMap.put("djcs", "0");
                                resultMap.put("qjcs", "0");
                                resultMap.put("jcs", "0");
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
        String mc = queryparems.getXzqhs();
        List<String> fjmcList = null;
        if (!StringUtils.isEmpty(mc)) {
            String[] split = mc.split(",");
            fjmcList = Arrays.asList(split);
        }
        List<Map<String, Object>> dwfx = mapper.dwfx(fjmcList);
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

    @Override
    public List<Map<String, Object>> dwflts(Queryparems queryparems) {
        List<Map<String, Object>> list = new ArrayList<>();
        if (queryparems.getSjgs().equals("yf")){
            for (int i =0 ;i<12;i++){
                Map<String, Object> map =new HashMap<>();
                queryparems.setData(getLast12Months(i));
                Integer dwflts =0;
                if (queryparems.getType().equals("jdfl")){
                    dwflts= mapper.dwfltsyf(queryparems);
                }else {
                    dwflts= mapper.ryfltsyf(queryparems);
                }
                map.put("yf",getLast12Months(i));
                map.put("sl",dwflts);
                list.add(map);
            }
            return list;
        }else{
            for (int i=0;i<7;i++){
                Map<String, Object> map =new HashMap<>();
                queryparems.setData(getLast7Days(i));
                Integer dwflts =0;
                if (queryparems.getType().equals("jdfl")){
                    dwflts= mapper.dwfltsrq(queryparems);
                }else {
                    dwflts= mapper.ryfltsrq(queryparems);
                }
                map.put("rq",getLast7Days(i));
                map.put("sl",dwflts);
                list.add(map);
            }
            return list;
        }

    }

    @Override
    public List<Map<String, Object>> jcg(Queryparems queryparems) {
    List<Map<String, Object>> list = new ArrayList<>();
        if (queryparems.getSjgs().equals("yf")){
            for (int i =0 ;i<12;i++){
                Map<String, Object> map =new HashMap<>();
                queryparems.setData(getLast12Months(i));
                Integer dwflts =0;
                if (queryparems.getType().equals("jg")){
                    dwflts= mapper.jgyf(queryparems);
                }else {
                    dwflts= mapper.cgyf(queryparems);
                }
                map.put("yf",getLast12Months(i));
                map.put("sl",dwflts);
                list.add(map);
            }
            return list;
        }else{
            for (int i=0;i<7;i++){
                Map<String, Object> map =new HashMap<>();
                queryparems.setData(getLast7Days(i));
                Integer dwflts =0;
                if (queryparems.getType().equals("jg")){
                    dwflts= mapper.jgrq(queryparems);
                }else {
                    dwflts= mapper.cgrq(queryparems);
                }
                map.put("rq",getLast7Days(i));
                map.put("sl",dwflts);
                list.add(map);
            }
        return list;
    }
    }

    @Override
    public List<Map<String, Object>> smsj(Queryparems queryparems) {
        List<Map<String, Object>> list = new ArrayList<>();
        if (queryparems.getSjgs().equals("yf")){
            for (int i =0 ;i<12;i++){
                Map<String, Object> map =new HashMap<>();
                queryparems.setData(getLast12Month(i));
                List<Float> smsj = mapper.smsj(queryparems);
                int hs = hs(smsj);
                String last7Day = getLast12Month(i);
                String ll =last7Day.substring(0,4)+"-"+last7Day.substring(4,6);
                map.put("sj",ll);
                map.put("bl",hs);
                list.add(map);
            }
            return list;
        }else{
            for (int i=0;i<7;i++){
                Map<String, Object> map =new HashMap<>();
                queryparems.setData(getLast7Day(i));
                List<Float> smsj = mapper.smsj(queryparems);
                int hs = hs(smsj);
                String last7Day = getLast7Day(i);
                String ll =last7Day.substring(0,4)+"-"+last7Day.substring(4,6)+"-"+last7Day.substring(6,8);
                map.put("sj",ll);
                map.put("bl",hs);
                list.add(map);
            }
            return list;
        }
    }

    public int hs(List<Float> num){
        float sum =0;
        for (int i = 0;i<num.size(); i++) {
            sum+=num.get(i);
        }
        float pingjun=sum/num.size();
        int p=getRoundNum1(pingjun);
        return p;
    }

    public String getLast12Months(int i) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -i);
        Date m = c.getTime();
        return sdf.format(m);
    }


    public String getLast12Month(int i) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -i);
        Date m = c.getTime();
        return sdf.format(m);
    }

    public String getLast7Day(int i) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_WEEK, -i);
        Date m = c.getTime();
        return sdf.format(m);
    }


    public String getLast7Days(int i) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_WEEK, -i);
        Date m = c.getTime();
        return sdf.format(m);
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

    public int getRoundNum1(float num){
        float n= num+0.49f;
        int k =(int) n;
        return k;
    }










}
