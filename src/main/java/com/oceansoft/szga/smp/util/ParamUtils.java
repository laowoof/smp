package com.oceansoft.szga.smp.util;

import eu.bitwalker.useragentutils.UserAgent;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author ：pc
 * @date ：Created in 2020/4/22 20:23
 * @description：
 * @modified By：
 * @version: $
 */
public class ParamUtils {
    /**
     * 获取用户代理对象
     * @param
     * @return
     */
    public static HashMap xcjyparsingParam(String param, String start, String end){
        HashMap<String,Object> hashMap=new HashMap<>();
        if(param.equals("year")){
            hashMap.put("start",start);
            hashMap.put("end",end);
            return  hashMap;
        }else if(param.equals("month")){
            // 如果1月  显示过去一年总数据
            if(start.equals(end)){
                if("01".equals(start.substring(5,7))){
                    Integer temp=Integer.valueOf(start.substring(0,4));
                    hashMap.put("start",String.valueOf(temp-1));
                    hashMap.put("end",String.valueOf(temp-1));
                    return hashMap;
                }
            }
            hashMap.put("param","month");
            hashMap.put("start",start.replace("-",""));
            hashMap.put("end",end.replace("-",""));

            return  hashMap;
        }
        return  null;
    }
    public static HashMap xcjyparsingParam(String param, String start, String end,String dd){
        HashMap<String,Object> hashMap=new HashMap<>();
        if(param.equals("year")){
            hashMap.put("start",start);
            hashMap.put("end",end);
            hashMap.put("dd",dd);
            return  hashMap;
        }else if(param.equals("month")){
            // 如果1月  显示过去一年总数据
            if("01".equals(start.substring(5,7))){
                Integer temp=Integer.valueOf(start.substring(0,4));
                hashMap.put("start",String.valueOf(temp-1));
                hashMap.put("end",String.valueOf(temp-1));
                hashMap.put("dd",dd);
                return hashMap;
            }
            hashMap.put("param","month");
            hashMap.put("start",start.replace("-",""));
            hashMap.put("end",end.replace("-",""));
            hashMap.put("dd",dd);
            return  hashMap;
        }
        return  null;
    }

    public static HashMap dlaqtjparsingParam(String param, String choiceDate){
        HashMap<String,Object> hashMap=new HashMap<>();
        if(param == null || choiceDate == null){
            return null;
        }
        if(param.equals("year")){
            //判断 yyyy 格式 是否正确
          if(choiceDate.matches("^[1-9][0-9]{3}$")){
              hashMap.put("choiceDate",choiceDate);
              return  hashMap;
          }
        }else if(param.equals("month")){
            //判断 yyyy-mm
            if(choiceDate.matches("^[1-9][0-9]{3}[-]((0([1-9]))|(1(0|1|2)))$")){
                // 如果是 一月 显示 过去 一年的全部信息
                if("01".equals(choiceDate.substring(5,7))){
                    Integer temp=Integer.valueOf(choiceDate.substring(0,4));
                    hashMap.put("choiceDate",String.valueOf(temp-1));
                    return hashMap;
                }else{
                    hashMap.put("param","month");
                    hashMap.put("start",choiceDate.substring(0,4)+"01");
                    hashMap.put("end",choiceDate.replace("-",""));
                    return hashMap;
                }
            }
            return  null;
        }
        return  null;
    }
    public static HashMap dlaqtjparsingParam(String param, String choiceDate,String name){
        HashMap<String,Object> hashMap=new HashMap<>();
        if(param == null || choiceDate == null || name ==null){
            return null;
        }
        if(param.equals("year")){
            //判断 yyyy 格式 是否正确
            if(choiceDate.matches("^[1-9][0-9]{3}$")){
                hashMap.put("choiceDate",choiceDate);
                hashMap.put("name",name);
                return  hashMap;
            }
        }else if(param.equals("month")){
            //判断 yyyy-mm
            if(choiceDate.matches("^[1-9][0-9]{3}[-]((0([1-9]))|(1(0|1|2)))$")){
                // 如果是 一月 显示 过去 一年的全部信息
                if("01".equals(choiceDate.substring(5,7))){
                    Integer temp=Integer.valueOf(choiceDate.substring(0,4));
                    hashMap.put("choiceDate",String.valueOf(temp-1));
                    hashMap.put("name",name);
                    return hashMap;
                }else{
                    hashMap.put("param","month");
                    hashMap.put("start",choiceDate.substring(0,4)+"01");
                    hashMap.put("end",choiceDate.replace("-",""));
                    hashMap.put("name",name);
                    return hashMap;
                }
            }
            return  null;
        }
        return  null;
    }

    /**
     * 隐患完成情况统计  参数校验
     * @param param
     * @param choiceDate
     * @param name
     * @return
     */
    public static HashMap yhwcqktjparsingParam(String param, String choiceDate,String status){
        HashMap<String,Object> hashMap=new HashMap<>();
        if(param == null || choiceDate == null || status ==null){
            return null;
        }
        if(param.equals("year")){
            //判断 yyyy 格式 是否正确
            if(choiceDate.matches("^[1-9][0-9]{3}$")){
                hashMap.put("choiceDate",choiceDate);
                hashMap.put("status",status);
                return  hashMap;
            }
        }else if(param.equals("month")){
            //判断 yyyy-mm
            if(choiceDate.matches("^[1-9][0-9]{3}[-]((0([1-9]))|(1(0|1|2)))$")){
                // 如果是 一月 显示 过去 一年的全部信息
                if("01".equals(choiceDate.substring(5,7))){
                    Integer temp=Integer.valueOf(choiceDate.substring(0,4));
                    hashMap.put("choiceDate",String.valueOf(temp-1));
                    hashMap.put("status",status);
                    return hashMap;
                }else{
                    hashMap.put("param","month");
                    hashMap.put("start",choiceDate.substring(0,4)+"01");
                    hashMap.put("end",choiceDate.replace("-",""));
                    hashMap.put("status",status);
                    return hashMap;
                }
            }
            return  null;
        }
        return  null;
    }
    /**
     * 隐患完成情况统计 子项  参数校验
     * @param param
     * @param choiceDate
     * @param name
     * @return
     */
    public static HashMap yhwcqktjparsingParam(String param, String choiceDate,String status,String name){
        HashMap<String,Object> hashMap=new HashMap<>();
        if(param == null || choiceDate == null || status ==null || name==null){
            return null;
        }
        if(param.equals("year")){
            //判断 yyyy 格式 是否正确
            if(choiceDate.matches("^[1-9][0-9]{3}$")){
                hashMap.put("choiceDate",choiceDate);
                hashMap.put("status",status);
                hashMap.put("name",name);
                return  hashMap;
            }
        }else if(param.equals("month")){
            //判断 yyyy-mm
            if(choiceDate.matches("^[1-9][0-9]{3}[-]((0([1-9]))|(1(0|1|2)))$")){
                // 如果是 一月 显示 过去 一年的全部信息
                if("01".equals(choiceDate.substring(5,7))){
                    Integer temp=Integer.valueOf(choiceDate.substring(0,4));
                    hashMap.put("choiceDate",String.valueOf(temp-1));
                    hashMap.put("status",status);
                    hashMap.put("name",name);
                    return hashMap;
                }else{
                    hashMap.put("param","month");
                    hashMap.put("start",choiceDate.substring(0,4)+"01");
                    hashMap.put("end",choiceDate.replace("-",""));
                    hashMap.put("status",status);
                    hashMap.put("name",name);
                    return hashMap;
                }
            }
            return  null;
        }
        return  null;
    }

    /**
     * 隐患类型统计  参数校验
     * @param param
     * @param choiceDate
     * @param name
     * @return
     */
    public static HashMap yhlxtjparsingParam(String param, String choiceDate,String status){
        HashMap<String,Object> hashMap=new HashMap<>();
        if(param == null || choiceDate == null || status ==null ){
            return null;
        }
        if(param.equals("year")){
            //判断 yyyy 格式 是否正确
            if(choiceDate.matches("^[1-9][0-9]{3}$")){
                hashMap.put("choiceDate",choiceDate);
                hashMap.put("status",status);
                return  hashMap;
            }
        }else if(param.equals("month")){
            //判断 yyyy-mm
            if(choiceDate.matches("^[1-9][0-9]{3}[-]((0([1-9]))|(1(0|1|2)))$")){
                // 如果是 一月 显示 过去 一年的全部信息
                if("01".equals(choiceDate.substring(5,7))){
                    Integer temp=Integer.valueOf(choiceDate.substring(0,4));
                    hashMap.put("choiceDate",String.valueOf(temp-1));
                    hashMap.put("status",status);
                    return hashMap;
                }else{
                    hashMap.put("param","month");
                    hashMap.put("start",choiceDate.substring(0,4)+"01");
                    hashMap.put("end",choiceDate.replace("-",""));
                    hashMap.put("status",status);
                    return hashMap;
                }
            }
            return  null;
        }
        return  null;
    }

    /**
     * 八进宣传统计  参数校验
     * @param param
     * @param choiceDate
     * @param name
     * @return
     */
    public static HashMap bjxctjparsingParam(String param, String start,String end){
        HashMap<String,Object> hashMap=new HashMap<>();
        if(param == null || start == null || end ==null ){
            return null;
        }
        if(param.equals("year")){
            //判断 yyyy 格式 是否正确
            if(start.matches("^[1-9][0-9]{3}$") && end.matches("^[1-9][0-9]{3}$") ){
                hashMap.put("start",start);
                hashMap.put("end",end);
                return  hashMap;
            }
        }else if(param.equals("month")){
            //判断 yyyy-mm
            if(start.matches("^[1-9][0-9]{3}[-]((0([1-9]))|(1(0|1|2)))$") && end.matches("^[1-9][0-9]{3}[-]((0([1-9]))|(1(0|1|2)))$")){
                // 如果是 一月 显示 过去 一年的全部信息
                if("01".equals(end.substring(5,7)) && end.equals(start)){
                    Integer temp=Integer.valueOf(end.substring(0,4));
                    hashMap.put("start",String.valueOf(temp-1));
                    hashMap.put("end",String.valueOf(temp-1));
                    return hashMap;
                }else{
                    hashMap.put("param","month");
                    hashMap.put("start",start.replace("-",""));
                    hashMap.put("end",end.replace("-",""));
                    return hashMap;
                }
            }
            return  null;
        }
        return  null;
    }
    /**
     * 八进宣传统计 子项  参数校验
     * @param param
     * @param choiceDate
     * @param name
     * @return
     */
    public static HashMap bjxctjparsingParam(String param, String start,String end,String name){
        HashMap<String,Object> hashMap=new HashMap<>();
        if(param == null || start == null || end ==null || name==null){
            return null;
        }
        if(param.equals("year")){
            //判断 yyyy 格式 是否正确
            if(start.matches("^[1-9][0-9]{3}$") && end.matches("^[1-9][0-9]{3}$") ){
                hashMap.put("start",start);
                hashMap.put("end",end);
                hashMap.put("name",name);

                return  hashMap;
            }
        }else if(param.equals("month")){
            //判断 yyyy-mm
            if(start.matches("^[1-9][0-9]{3}[-]((0([1-9]))|(1(0|1|2)))$") && end.matches("^[1-9][0-9]{3}[-]((0([1-9]))|(1(0|1|2)))$")){
                // 如果是 一月 显示 过去 一年的全部信息
                if("01".equals(end.substring(5,7)) && end.equals(start)){
                    Integer temp=Integer.valueOf(end.substring(0,4));
                    hashMap.put("start",String.valueOf(temp-1));
                    hashMap.put("end",String.valueOf(temp-1));
                    hashMap.put("name",name);
                    return hashMap;
                }else{
                    hashMap.put("param","month");
                    hashMap.put("start",start.replace("-",""));
                    hashMap.put("end",end.replace("-",""));
                    hashMap.put("name",name);
                    return hashMap;
                }
            }
            return  null;
        }
        return  null;
    }

    /**
     * 单位重点违法统计
     * @param param
     * @param choiceDate
     * @param name
     * @return
     */
    public static HashMap dwzdwftjparsingParam(String param, String start,String end){
        HashMap<String,Object> hashMap=new HashMap<>();
        if(param == null || start == null || end ==null ){
            return null;
        }
        if(param.equals("year")){
            //判断 yyyy 格式 是否正确
            if(start.matches("^[1-9][0-9]{3}$") && end.matches("^[1-9][0-9]{3}$") ){
                hashMap.put("start",start);
                hashMap.put("end",end);
                return  hashMap;
            }
        }else if(param.equals("month")){
            //判断 yyyy-mm
            if(start.matches("^[1-9][0-9]{3}[-]((0([1-9]))|(1(0|1|2)))$") && end.matches("^[1-9][0-9]{3}[-]((0([1-9]))|(1(0|1|2)))$")){
                // 如果是 一月 显示 过去 一年的全部信息
                if("01".equals(end.substring(5,7)) && end.equals(start)){
                    Integer temp=Integer.valueOf(end.substring(0,4));
                    hashMap.put("start",String.valueOf(temp-1));
                    hashMap.put("end",String.valueOf(temp-1));
                    return hashMap;
                }else{
                    hashMap.put("param","month");
                    hashMap.put("start",start.replace("-",""));
                    hashMap.put("end",end.replace("-",""));
                    return hashMap;
                }
            }
            return  null;
        }
        return  null;
    }

    /**
     * 单位重点违法统计 子项
     * @param param
     * @param choiceDate
     * @param name
     * @return
     */
    public static HashMap dwzdwftjzxparsingParam(String param, String start,String end,String name){
        HashMap<String,Object> hashMap=new HashMap<>();
        if(param == null || start == null || end ==null || name==null){
            return null;
        }
        if(param.equals("year")){
            //判断 yyyy 格式 是否正确
            if(start.matches("^[1-9][0-9]{3}$") && end.matches("^[1-9][0-9]{3}$") ){
                hashMap.put("start",start);
                hashMap.put("end",end);
                hashMap.put("name",name);
                return  hashMap;
            }
        }else if(param.equals("month")){
            //判断 yyyy-mm
            if(start.matches("^[1-9][0-9]{3}[-]((0([1-9]))|(1(0|1|2)))$") && end.matches("^[1-9][0-9]{3}[-]((0([1-9]))|(1(0|1|2)))$")){
                // 如果是 一月 显示 过去 一年的全部信息
                if("01".equals(end.substring(5,7)) && end.equals(start)){
                    Integer temp=Integer.valueOf(end.substring(0,4));
                    hashMap.put("start",String.valueOf(temp-1));
                    hashMap.put("end",String.valueOf(temp-1));
                    hashMap.put("name",name);
                    return hashMap;
                }else{
                    hashMap.put("param","month");
                    hashMap.put("start",start.replace("-",""));
                    hashMap.put("end",end.replace("-",""));
                    hashMap.put("name",name);
                    return hashMap;
                }
            }
            return  null;
        }
        return  null;
    }


    /**
     * 源头底数统计
     * @param param
     * @param choiceDate
     * @param name
     * @return
     */
    public static HashMap ytdstjparsingParam(String param, String date){
        HashMap<String,Object> hashMap=new HashMap<>();
        if(param == null || date ==null){
            return null;
        }
        if(param.equals("year")){
            //判断 yyyy 格式 是否正确
            if(date.matches("^[1-9][0-9]{3}$")  ){
                hashMap.put("year",date);
                return  hashMap;
            }
        }else if(param.equals("month")){
            //判断 yyyy-mm
            if(date.matches("^[1-9][0-9]{3}[-]((0([1-9]))|(1(0|1|2)))$") ){
                // 如果是 一月 显示 过去 一年的全部信息
                if("01".equals(date.substring(5,7)) ){
                    Integer temp=Integer.valueOf(date.substring(0,4));
                    hashMap.put("year",date);
                    return hashMap;
                }else{
                    hashMap.put("param","month");
                    String start=date.substring(0,4)+"01";
                    hashMap.put("end",date.replace("-",""));
                    hashMap.put("start",start);
                    return hashMap;
                }
            }
            return  null;
        }
        return  null;
    }
}
