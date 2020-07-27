package com.oceansoft.szga.smp.service.impl;

import com.alibaba.excel.util.CollectionUtils;
import com.oceansoft.szga.smp.mapper.DeliverylogisticsMapper;
import com.oceansoft.szga.smp.service.DeliverylogisticsService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
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
            map.put("num",num);
            list.add(map);
            j -= Integer.valueOf(num);
        }
        Map<String, Object> aa =new HashMap<>();
        Float res=(float) j/f;
        aa.put("bl",res);
        aa.put("name","其他");
        aa.put("num",j);
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
            map.put("num",num);
            list.add(map);
        }
        return list;
    }


    @Override
    public List<Map<String, Object>> jdadnryfl(String type) {
        List<Map<String, Object>> list =new ArrayList<>();
        if (type.equals("jdfl")){
            list= mapper.jdfl();
        }else {
            list= mapper.ryfl();
        }
        List<Map<String, Object>> resultList = new ArrayList<>();
        List<String> orderList = Arrays.asList("张家港市局", "常熟市局", "昆山市局", "太仓市局", "吴江分局", "园区分局", "姑苏分局", "高新区分局", "吴中分局", "相城分局", "度假区分局");
        for (int i =0 ;i<orderList.size();i++)
            for (int k = 0; k < list.size(); k++) {
                String xzqh = String.valueOf(list.get(k).get("xzqh"));
                String s = orderList.get(i);
                if (xzqh.equals(s) ){
                    Map<String, Object> resultMap = new HashMap<>();
                    resultMap.put("dwmc", list.get(k).get("xzqh"));
                    resultMap.put("num", list.get(k).get("num"));
                    resultList.add(resultMap);
                }
            }
        return resultList;
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




}
