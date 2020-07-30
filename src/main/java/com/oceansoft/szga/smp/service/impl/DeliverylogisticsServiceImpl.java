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
        List<Map<String, Object>> list =new ArrayList<>();
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
                if (xzqh.equals(s)){
                    Map<String, Object> resultMap = new HashMap<>();
                    int mm =Integer.valueOf(String.valueOf(list.get(k).get("num")));
                    String name = String.valueOf(list.get(k).get("xzqh"));
                    name =name.substring(0,name.length()-2);
                    resultMap.put("dwmc", name);
                    resultMap.put("value", list.get(k).get("num"));
                    float res= (float) mm /he *100;
                    int p=getRoundNum1(res);
                    resultMap.put("bl",p);
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
        List<Map<String, Object>> resultList = new ArrayList<>();
        Map<String, Object> resultMap10 = new HashMap<>();
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> resultMap1 = new HashMap<>();
        Map<String, Object> resultMap2 = new HashMap<>();
        Map<String, Object> resultMap3 = new HashMap<>();
        Map<String, Object> resultMap4 = new HashMap<>();
        Map<String, Object> resultMap5 = new HashMap<>();
        Map<String, Object> resultMap6 = new HashMap<>();
        Map<String, Object> resultMap8 = new HashMap<>();
        Map<String, Object> resultMap7 = new HashMap<>();
        Map<String, Object> resultMap9 = new HashMap<>();
        resultMap10.put("name","张家港");resultMap10.put("value","16");resultMap10.put("bl","12");resultList.add(resultMap10);
        resultMap1.put("name","常熟");resultMap1.put("value","9");resultMap1.put("bl","7");resultList.add(resultMap1);
        resultMap4.put("name","昆山");resultMap4.put("value","7");resultMap4.put("bl","5");resultList.add(resultMap4);
        resultMap5.put("name","太仓");resultMap5.put("value","10");resultMap5.put("bl","8");resultList.add(resultMap5);
        resultMap6.put("name","吴江");resultMap6.put("value","18");resultMap6.put("bl","14");resultList.add(resultMap6);
        resultMap9.put("name","园区");resultMap9.put("value","29");resultMap9.put("bl","22");resultList.add(resultMap9);
        resultMap3.put("name","姑苏");resultMap3.put("value","5");resultMap3.put("bl","4");resultList.add(resultMap3);
        resultMap2.put("name","高新区");resultMap2.put("value","13");resultMap2.put("bl","10");resultList.add(resultMap2);
        resultMap7.put("name","吴中");resultMap7.put("value","16");resultMap7.put("bl","12");resultList.add(resultMap7);
        resultMap8.put("name","相城");resultMap8.put("value","10");resultMap8.put("bl","8");resultList.add(resultMap8);
        resultMap.put("zsl","133");resultList.add(resultMap);
        return resultList;
//        List<Map<String, Object>> zabw = mapper.zabw();
//        List<String> orderList = Arrays.asList("张家港市局", "常熟市局", "昆山市局", "太仓市局", "吴江区局", "园区分局", "姑苏分局", "高新区分局", "吴中分局", "相城分局", "度假区分局");
//        List<Map<String, Object>> resultList = new ArrayList<>();
//        Integer he = mapper.zabwzsl();
//        for (int i =0 ;i<orderList.size();i++){
//            for (int k = 0; k < zabw.size(); k++) {
//                String xzqh = String.valueOf(zabw.get(k).get("xzqh"));
//                String s = orderList.get(i);
//                if (xzqh.equals(s) ){
//                    Map<String, Object> resultMap = new HashMap<>();
//                    int mm =Integer.valueOf(String.valueOf(zabw.get(k).get("num")));
//                    String name = String.valueOf(zabw.get(k).get("xzqh"));
//                    name =name.substring(0,name.length()-2);
//                    resultMap.put("name", name);
//                    resultMap.put("value", zabw.get(k).get("num"));
//                    float res= (float) mm /he *100;
//                    int p=getRoundNum(res);
//                    resultMap.put("bl",p);
//                    resultList.add(resultMap);
//                }
//            }
//        }
//        Map<String, Object> map = new HashMap<>();
//        map.put("zsl",he);
//        resultList.add(map);
//        return resultList;
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
                                resultMap.put("yjcs", dwjc2.get(q).get("num"));
                                resultMap.put("djcs", dwjc1.get(k).get("num"));
                                resultMap.put("qjcs", dwjc3.get(w).get("num"));
                                resultMap.put("jcs", dwjc4.get(e).get("num"));
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
            for (int i =11 ;i>=0;i--){
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
            for (int i=6;i>=0;i--){
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
        int jgzsl =0;
        int cgzsl =0;
        if (queryparems.getSjgs().equals("yf")){
            for (int i =11 ;i>=0;i--){
                Map<String, Object> map =new HashMap<>();
                queryparems.setData(getLast12Months(i));
                Integer dwflts =0;
                if (queryparems.getType().equals("jg")){
                    dwflts= mapper.jgyf(queryparems);
                    jgzsl+=dwflts;
                }else {
                    dwflts= mapper.cgyf(queryparems);
                    cgzsl+=dwflts;
                }
                map.put("yf",getLast12Months(i));
                map.put("sl",dwflts);
                list.add(map);
            }
        }else{
            for (int i=6;i>=0;i--){
                Map<String, Object> map =new HashMap<>();
                queryparems.setData(getLast7Days(i));
                Integer dwflts =0;
                if (queryparems.getType().equals("jg")){
                    jgzsl+=dwflts;
                    dwflts= mapper.jgrq(queryparems);
                }else {
                    dwflts= mapper.cgrq(queryparems);
                    cgzsl+=dwflts;
                }
                map.put("rq",getLast7Days(i));
                map.put("sl",dwflts);
                list.add(map);
            }
        }
        Map<String, Object> map1 =new HashMap<>();
        if (queryparems.getType().equals("jg")){
            map1.put("zsl",jgzsl);
        }else {
            map1.put("zsl",cgzsl);
        }
        list.add(map1);
        return list;
    }

    @Override
    public List<Map<String, Object>> smsj(Queryparems queryparems) {
        List<Map<String, Object>> list = new ArrayList<>();
        int sjl =0;
        if (queryparems.getSjgs().equals("yf")){
            for (int i =11 ;i>=0;i--){
                Map<String, Object> map =new HashMap<>();
                queryparems.setData(getLast12Month(i));
                List<Float> smsj = mapper.smsj(queryparems);
                int hs = hs(smsj);
                sjl=Zh(hs,12);
                String last7Day = getLast12Month(i);
                String ll =last7Day.substring(0,4)+"-"+last7Day.substring(4,6);
                map.put("sj",ll);
                map.put("bl",hs);
                list.add(map);
            }
        }else{
            for (int i=6;i>=0;i--){
                Map<String, Object> map =new HashMap<>();
                queryparems.setData(getLast7Day(i));
                List<Float> smsj = mapper.smsj(queryparems);
                int hs = hs(smsj);
                sjl=Zh(hs,7);
                String last7Day = getLast7Day(i);
                String ll =last7Day.substring(0,4)+"-"+last7Day.substring(4,6)+"-"+last7Day.substring(6,8);
                map.put("sj",ll);
                map.put("bl",hs);
                list.add(map);
            }
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("sjl",sjl);list.add(resultMap);
        return list;
    }

    @Override
    public List<Map<String, Object>> yhlxmx(Queryparems queryparems) {
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i =11 ;i>=0;i--){
            Map<String, Object> map =new HashMap<>();
            queryparems.setData(getLast12Months(i));
            String last7Day = getLast12Months(i);
            Integer yhlxyzg = mapper.yhlxyzg(queryparems);
            Integer yhlxzsl = mapper.yhlxzsl(queryparems);
            map.put("yzg",yhlxyzg);
            map.put("wzg",yhlxzsl-yhlxyzg);
            map.put("rq",last7Day);
            list.add(map);
            }
         return list;
    }

    @Override
    public List<Map<String, Object>> yhlxmxqy() {
        List<String> orderList = Arrays.asList("张家港市局", "常熟市局", "昆山市局", "太仓市局", "吴江区局", "园区分局", "姑苏分局", "高新区分局", "吴中分局", "相城分局", "度假区分局");
        List<Map<String, Object>> resultList = new ArrayList<>();
        Queryparems queryparems =new Queryparems();
        for (int i =0 ;i<orderList.size();i++){
            String s = orderList.get(i);
            queryparems.setFjmc(s);
            List<Map<String, Object>> list1 = mapper.yhlxzsl1(queryparems);
            List<Map<String, Object>> list2 = mapper.yhlxyzg1(queryparems);
            for (int k = 0; k < list1.size(); k++) {
                String fjmc1 = String.valueOf(list1.get(k).get("fjmc"));
                for (int m = 0; m < list2.size(); m++) {
                    String fjmc2 = String.valueOf(list2.get(m).get("fjmc"));
                    if (s.equals(fjmc1)&&fjmc1.equals(fjmc2)){
                        Map<String, Object> resultMap = new HashMap<>();
                        resultMap.put("name",s);
                        Integer num1 = Integer.valueOf(String.valueOf(list1.get(k).get("num")));
                        Integer num2 = Integer.valueOf(String.valueOf(list2.get(m).get("num")));
                        resultMap.put("yzg",num2);
                        resultMap.put("wzg",num1);
                        resultList.add(resultMap);
                    }
                }
            }
        }
        return resultList;
    }

    @Override
    public List<Map<String, Object>> tbzs() {
        List<Map<String, Object>> list =new ArrayList<>();
        Map<String, Object> map =new HashMap<>();
        Integer jgzs = mapper.jgzs();
        Integer cgzs = mapper.cgzs();
        map.put("jgzsl",jgzs);
        map.put("cgzsl",cgzs);
        map.put("kdclzsl","12261");
        list.add(map);
        return list;
    }

    public int Zh(int a,int b){
        if (b==0){
            return 0;
        }else {
            float res=(float) a/b;
            int ss =(int) res;
            return ss;
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




    @Override
    public List<Map<String, Object>> kdcl(Queryparems queryparems) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        Map<String, Object> resultMap1 = new HashMap<>();
        Map<String, Object> resultMap2 = new HashMap<>();
        Map<String, Object> resultMap3 = new HashMap<>();
        Map<String, Object> resultMap4 = new HashMap<>();
        Map<String, Object> resultMap5 = new HashMap<>();
        Map<String, Object> resultMap6 = new HashMap<>();
        Map<String, Object> resultMap7 = new HashMap<>();
        Map<String, Object> resultMap8 = new HashMap<>();
        Map<String, Object> resultMap9 = new HashMap<>();
        Map<String, Object> resultMap10 = new HashMap<>();
        Map<String, Object> resultMap11 = new HashMap<>();
        Map<String, Object> resultMap = new HashMap<>();
        if(queryparems.getFjmc().equals("")){
            resultMap1.put("name","顺丰");resultMap1.put("value","5456");resultMap1.put("bl","44");resultList.add(resultMap1);
            resultMap2.put("name","邮政");resultMap2.put("value","1391");resultMap2.put("bl","11");resultList.add(resultMap2);
            resultMap3.put("name","中通");resultMap3.put("value","791");resultMap3.put("bl","6");resultList.add(resultMap3);
            resultMap4.put("name","德邦");resultMap4.put("value","714");resultMap4.put("bl","6");resultList.add(resultMap4);
            resultMap5.put("name","京邦达");resultMap5.put("value","698");resultMap5.put("bl","6");resultList.add(resultMap5);
            resultMap6.put("name","申通");resultMap6.put("value","665");resultMap6.put("bl","5");resultList.add(resultMap6);
            resultMap7.put("name","华通");resultMap7.put("value","250");resultMap7.put("bl","2");resultList.add(resultMap7);
            resultMap8.put("name","晟邦");resultMap8.put("value","240");resultMap8.put("bl","2");resultList.add(resultMap8);
            resultMap9.put("name","蔓升");resultMap9.put("value","200");resultMap9.put("bl","2");resultList.add(resultMap9);
            resultMap10.put("name","品骏");resultMap10.put("value","180");resultMap10.put("bl","1");resultList.add(resultMap10);
            resultMap11.put("name","其他");resultMap11.put("value","1676");resultMap11.put("bl","14");resultList.add(resultMap11);
            resultMap.put("zsl","12261");resultList.add(resultMap);
        }else if(queryparems.getFjmc().equals("常熟")){
            resultMap1.put("name","顺丰");resultMap1.put("value","420");resultMap1.put("bl","51");resultList.add(resultMap1);
            resultMap2.put("name","邮政");resultMap2.put("value","108");resultMap2.put("bl","20");resultList.add(resultMap2);
            resultMap3.put("name","捷思兔");resultMap3.put("value","57");resultMap3.put("bl","6");resultList.add(resultMap3);
            resultMap4.put("name","京邦达");resultMap4.put("value","55");resultMap4.put("bl","5");resultList.add(resultMap4);
            resultMap5.put("name","神舟");resultMap5.put("value","53");resultMap5.put("bl","6");resultList.add(resultMap5);
            resultMap6.put("name","中通");resultMap6.put("value","43");resultMap6.put("bl","5");resultList.add(resultMap6);
            resultMap7.put("name","海航");resultMap7.put("value","40");resultMap7.put("bl","2");resultList.add(resultMap7);
            resultMap8.put("name","德邦");resultMap8.put("value","40");resultMap8.put("bl","1");resultList.add(resultMap8);
            resultMap9.put("name","晟邦");resultMap9.put("value","20");resultMap9.put("bl","1");resultList.add(resultMap9);
            resultMap10.put("name","品骏");resultMap10.put("value","9");resultMap10.put("bl","1");resultList.add(resultMap10);
            resultMap11.put("name","其他");resultMap11.put("value","16");resultMap11.put("bl","2");resultList.add(resultMap11);
            resultMap.put("zsl","824");resultList.add(resultMap);
        }else if(queryparems.getFjmc().equals("昆山")){
            resultMap1.put("name","顺丰");resultMap1.put("value","1176");resultMap1.put("bl","36");resultList.add(resultMap1);
            resultMap2.put("name","京邦达");resultMap2.put("value","280");resultMap2.put("bl","9");resultList.add(resultMap2);
            resultMap3.put("name","邮政");resultMap3.put("value","272");resultMap3.put("bl","8");resultList.add(resultMap3);
            resultMap4.put("name","中通");resultMap4.put("value","265");resultMap4.put("bl","8");resultList.add(resultMap4);
            resultMap5.put("name","华通");resultMap5.put("value","250");resultMap5.put("bl","8");resultList.add(resultMap5);
            resultMap6.put("name","申通");resultMap6.put("value","223");resultMap6.put("bl","7");resultList.add(resultMap6);
            resultMap7.put("name","德邦");resultMap7.put("value","189");resultMap7.put("bl","6");resultList.add(resultMap7);
            resultMap8.put("name","全天候");resultMap8.put("value","125");resultMap8.put("bl","4");resultList.add(resultMap8);
            resultMap9.put("name","韵达");resultMap9.put("value","101");resultMap9.put("bl","3");resultList.add(resultMap9);
            resultMap10.put("name","晟邦");resultMap10.put("value","92");resultMap10.put("bl","3");resultList.add(resultMap10);
            resultMap11.put("name","其他");resultMap11.put("value","294");resultMap11.put("bl","9");resultList.add(resultMap11);
            resultMap.put("zsl","3267");resultList.add(resultMap);
        }else if(queryparems.getFjmc().equals("苏州")){
            resultMap1.put("name","顺丰");resultMap1.put("value","2653");resultMap1.put("bl","42");resultList.add(resultMap1);
            resultMap2.put("name","邮政");resultMap2.put("value","622");resultMap2.put("bl","10");resultList.add(resultMap2);
            resultMap3.put("name","中通");resultMap3.put("value","522");resultMap3.put("bl","8");resultList.add(resultMap3);
            resultMap4.put("name","德邦");resultMap4.put("value","424");resultMap4.put("bl","7");resultList.add(resultMap4);
            resultMap5.put("name","申通");resultMap5.put("value","397");resultMap5.put("bl","6");resultList.add(resultMap5);
            resultMap6.put("name","京邦达");resultMap6.put("value","310");resultMap6.put("bl","5");resultList.add(resultMap6);
            resultMap7.put("name","蔓升");resultMap7.put("value","200");resultMap7.put("bl","3");resultList.add(resultMap7);
            resultMap8.put("name","万国");resultMap8.put("value","136");resultMap8.put("bl","2");resultList.add(resultMap8);
            resultMap9.put("name","晟邦");resultMap9.put("value","130");resultMap9.put("bl","2");resultList.add(resultMap9);
            resultMap10.put("name","火隆");resultMap10.put("value","97");resultMap10.put("bl","2");resultList.add(resultMap10);
            resultMap11.put("name","其他");resultMap11.put("value","803");resultMap11.put("bl","13");resultList.add(resultMap11);
            resultMap.put("zsl","6294");resultList.add(resultMap);
        } else if(queryparems.getFjmc().equals("太仓")){
            resultMap1.put("name","顺丰");resultMap1.put("value","267");resultMap1.put("bl","57");resultList.add(resultMap1);
            resultMap2.put("name","邮政");resultMap2.put("value","99");resultMap2.put("bl","21");resultList.add(resultMap2);
            resultMap3.put("name","京邦达");resultMap3.put("value","40");resultMap3.put("bl","9");resultList.add(resultMap3);
            resultMap4.put("name","德邦");resultMap4.put("value","30");resultMap4.put("bl","6");resultList.add(resultMap4);
            resultMap5.put("name","晟邦");resultMap5.put("value","9");resultMap5.put("bl","2");resultList.add(resultMap5);
            resultMap6.put("name","苏宁");resultMap6.put("value","9");resultMap6.put("bl","2");resultList.add(resultMap6);
            resultMap7.put("name","韵达");resultMap7.put("value","6");resultMap7.put("bl","1");resultList.add(resultMap7);
            resultMap8.put("name","中通");resultMap8.put("value","4");resultMap8.put("bl","1");resultList.add(resultMap8);
            resultMap9.put("name","品骏");resultMap9.put("value","3");resultMap9.put("bl","1");resultList.add(resultMap9);
            resultMap.put("zsl","467");resultList.add(resultMap);
        }else if(queryparems.getFjmc().equals("吴江")){
            resultMap1.put("name","顺丰");resultMap1.put("value","508");resultMap1.put("bl","63");resultList.add(resultMap1);
            resultMap2.put("name","邮政");resultMap2.put("value","122");resultMap2.put("bl","15");resultList.add(resultMap2);
            resultMap3.put("name","申通");resultMap3.put("value","45");resultMap3.put("bl","6");resultList.add(resultMap3);
            resultMap4.put("name","捷高");resultMap4.put("value","35");resultMap4.put("bl","4");resultList.add(resultMap4);
            resultMap5.put("name","德邦");resultMap5.put("value","33");resultMap5.put("bl","4");resultList.add(resultMap5);
            resultMap6.put("name","京邦达");resultMap6.put("value","22");resultMap6.put("bl","3");resultList.add(resultMap6);
            resultMap7.put("name","品骏");resultMap7.put("value","15");resultMap7.put("bl","2");resultList.add(resultMap7);
            resultMap8.put("name","海达跃");resultMap8.put("value","8");resultMap8.put("bl","1");resultList.add(resultMap8);
            resultMap9.put("name","跨越");resultMap9.put("value","7");resultMap9.put("bl","1");resultList.add(resultMap9);
            resultMap10.put("name","叮呱呱");resultMap10.put("value","6");resultMap10.put("bl","1");resultList.add(resultMap10);
            resultMap11.put("name","其他");resultMap11.put("value","11");resultMap11.put("bl","1");resultList.add(resultMap11);
            resultMap.put("zsl","812");resultList.add(resultMap);
        }else if(queryparems.getFjmc().equals("张家港")){
            resultMap1.put("name","顺丰");resultMap1.put("value","432");resultMap1.put("bl","72");resultList.add(resultMap1);
            resultMap2.put("name","邮政");resultMap2.put("value","111");resultMap2.put("bl","19");resultList.add(resultMap2);
            resultMap3.put("name","德邦");resultMap3.put("value","28");resultMap3.put("bl","5");resultList.add(resultMap3);
            resultMap4.put("name","品骏");resultMap4.put("value","7");resultMap4.put("bl","1");resultList.add(resultMap4);
            resultMap5.put("name","跨越");resultMap5.put("value","7");resultMap5.put("bl","1");resultList.add(resultMap5);
            resultMap6.put("name","宅急送");resultMap6.put("value","5");resultMap6.put("bl","1");resultList.add(resultMap6);
            resultMap7.put("name","江通");resultMap7.put("value","4");resultMap7.put("bl","1");resultList.add(resultMap7);
            resultMap8.put("name","京邦达");resultMap8.put("value","3");resultMap8.put("bl","1");resultList.add(resultMap8);
            resultMap.put("zsl","597");resultList.add(resultMap);
        }
        return resultList;
    }



}
