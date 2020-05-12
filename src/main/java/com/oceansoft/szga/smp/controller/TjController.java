package com.oceansoft.szga.smp.controller;


import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSONObject;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.service.TjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

/**
 * @author  wzj
 * @date  2020/4/8
 */
@RestController
@RequestMapping({"tj"})
public class TjController {
    @Autowired
    private TjService tjService;
    /**
     * 统计重要设施
     * @author wzj
     * @return 数据
     */
    @GetMapping("zyssFlTj")
    public ApiResult zyssFlTj(){
        ApiResult data = tjService.zyssFlTj();
        return data;
    }

    /**
     * 统计重要设施 派出所
     * @author wzj
     * @return 数据
     */
    @GetMapping("zyssFlTjPcs")
    public ApiResult zyssFlTjPcs(String code){
        ApiResult data = tjService.zyssFlTjPcs(code);
        return data;
    }

    /**
     * 统计重要设施  责任区
     * @author wzj
     * @return 数据
     */
    @GetMapping("zyssFlTjZrq")
    public ApiResult zyssFlTjZrq(String code){
        ApiResult data = tjService.zyssFlTjZrq(code);
        return data;
    }

    /**
     * 履历分析 实时数据
     * @param tjrq
     * @author wzj
     * @return 数据
     */
    @GetMapping("lzTjFxData")
    public ApiResult lzTjFxData(String tjrq){
        ApiResult data = tjService.lzTjFxData(tjrq);
        return data;
    }

    /**
     * 履历分析 实时数据 派出所
     * @param tjrq
     * @param code
     * @author wzj
     * @return 数据
     */
    @GetMapping("lzTjFxDataPcs")
    public ApiResult lzTjFxDataPcs(String code,String tjrq){
        ApiResult data = tjService.lzTjFxDataPcs(code,tjrq);
        return data;
    }
    /**
     * 履历分析 实时数据 责任区
     * @author wzj
     * @param tjrq
     * @param code
     * @return 数据
     */
    @GetMapping("lzTjFxDataZrq")
    public ApiResult lzTjFxDataZrq(String code,String tjrq){
        ApiResult data = tjService.lzTjFxDataZrq(code,tjrq);
        return data;
    }

    /**
     * 重要设施
     * @author wzj
     * @return 数据
     */
    @GetMapping("zyssYhTj")
    public ApiResult zyssYhTj(String tjrq){
        ApiResult data = tjService.zyssYhTj(tjrq);
        return data;
    }
    /**
     * 重要设施实时统计之派出所
     * @param tjrq
     * @param code
     * @author wzj
     * @return 数据
     */
    @GetMapping("zYssYhTjPcs")
    public ApiResult zYssYhTjPcs(String code,String tjrq){
        ApiResult data = tjService.zYssYhTjPcs(code,tjrq);
        return data;
    }

    /**
     * 重要设施实时统计之责任区
     * @param tjrq
     * @param code
     * @author wzj
     * @return 数据
     */
    @GetMapping("zYssYhTjZrq")
    public ApiResult zYssYhTjZrq(String code,String tjrq){
        ApiResult data = tjService.zYssYhTjZrq(code,tjrq);
        return data;
    }
    /**
     *  监管实施数据统计
     * @param tjrq
     * @author wzj
     * @return 数据
     */
    @GetMapping("jgSsTj")
    public ApiResult jgSsTj(String tjrq, HttpServletRequest request){
        ApiResult data = tjService.jgSsTj(tjrq);
        request.getSession().setAttribute("jgSsTj",data.getData());
        return data;
    }

    @GetMapping("jgSsTj/export")
    public void jgSsTjExport(String tjrq, HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Map> data = (List<Map>) request.getSession().getAttribute("jgSsTj");

        List<List<Object>> objects = tjService.createJgSsTjListObject(data);
        List<List<String>> heads = tjService.createHead();
        tjService.exportExcel(response, objects, heads,"实时数据统计表");
    }

    /**
     *  监管实施数据统计 派出所
     * @author wzj
     * @return 数据
     */
    @GetMapping("jgSsTjPcs")
    public ApiResult jgSsTjPcs(String code,String tjrq){
        ApiResult data = tjService.jgSsTjPcs(code,tjrq);
        return data;
    }

    /**
     *  监管实施数据统计  责任区
     * @param tjrq
     * @param code
     * @author wzj
     * @return 数据
     */
    @GetMapping("jgSsTjZrq")
    public ApiResult jgSsTjZrq(String code,String tjrq){
        ApiResult data = tjService.jgSsTjZrq(code,tjrq);
        return data;
    }

//    /**
//     *  重点单位隐患统计 实时数据
//     * @author wzj
//     * @return 数据
//     */
//    @GetMapping("zdDwYhTjSs")
//    public ApiResult zdDwYhTjSs(String tjrq){
//        ApiResult data = tjService.zdDwYhTjSs(tjrq);
//        return data;
//    }
//
//    /**
//     * 重点单位隐患统计 实时数据 派出所
//     * @param tjrq
//     * @param code
//     * @author wzj
//     * @return 数据
//     */
//    @GetMapping("zdDwYhTjSsPcs")
//    public ApiResult zdDwYhTjSsPcs(String code,String tjrq){
//        ApiResult data = tjService.zdDwYhTjSsPcs(code,tjrq);
//        return data;
//    }
//
//    /**
//     * 重点单位隐患统计 实时数据 责任区
//     * @param tjrq
//     * @param code
//     * @author wzj
//     * @return 数据
//     */
//    @GetMapping("zdDwYhTjSsZrq")
//    public ApiResult zdDwYhTjSsZrq(String code,String tjrq){
//        ApiResult data = tjService.zdDwYhTjSsZrq(code,tjrq);
//        return data;
//    }
    /**
     * 重要设施新增统计 实时数据
     * @author wzj
     * @param tjrq
     * @return 数据
     */
    @GetMapping("zySsXzTjSs")
    public ApiResult zySsXzTjSs(String tjrq){
        ApiResult data = tjService.zySsXzTjSs(tjrq);
        return data;
    }

    /**
     * 重要设施新增统计 实时数据  派出所
     * @author wzj
     * @return 数据
     */
    @GetMapping("zySsXzTjSsPcs")
    public ApiResult zySsXzTjSsPcs(String code,String tjrq){
        ApiResult data = tjService.zySsXzTjSsPcs(code,tjrq);
        return data;
    }
    /**
     * 重要设施新增统计 实时数据  责任区
     * @author wzj
     * @return 数据
     */
    @GetMapping("zySsXzTjSsZrq")
    public ApiResult zySsXzTjSsZrq(String code,String tjrq){
        ApiResult data = tjService.zySsXzTjSsZrq(code,tjrq);
        return data;
    }


    /**
     * 企事业单位新增统计  实时
     * @author wzj
     * @param map
     * @return 数据
     */
    @PostMapping("qsyAddSsData")
    public ApiResult qsyAddSsData(@RequestBody HashMap map){
        ApiResult data = tjService.qsyAddSsData(map);
        return data;
    }



    /**
     * 重要设施新增统计 月度数据
     * @author wzj
     * @param year
     * @return 数据
     */
    @GetMapping("zySsXzTjYd")
    public ApiResult zySsXzTjYd(String year){
        ApiResult data = tjService.zySsXzTjYd(year);
        return data;
    }

    /**
     * 重要设施新增统计 派出所
     * @author wzj
     * @param year
     * @return 数据
     */
    @GetMapping("zySsXzTjYdPcs")
    public ApiResult zySsXzTjYdPcs(String year,String code){
        ApiResult data = tjService.zySsXzTjYdPcs(year,code);
        return data;
    }
    /**
     * 重要设施新增统计 责任区
     * @author wzj
     * @param year
     * @return 数据
     */
    @GetMapping("zySsXzTjYdZrq")
    public ApiResult zySsXzTjYdZrq(String year,String code){
        ApiResult data = tjService.zySsXzTjYdZrq(year,code);
        return data;
    }
    /**
     * 重要设施隐患统计 月度数据统计
     * @author wzj
     * @param year
     * @return 数据
     */
    @GetMapping("zySsYhTjYd")
    public ApiResult zySsYhTjYd(String year){
        ApiResult data = tjService.zySsYhTjYd(year);
        return data;
    }

    @PostMapping("zySsYhTjYdClick")
    public ApiResult zySsYhTjYdClick(@RequestBody HashMap map){
        ApiResult data = tjService.zySsYhTjYdClick(map);
        return data;
    }
    /**
     * 监管项底数统计  月度数据
     * @author wzj
     * @param year
     * @return 数据
     */
    @GetMapping("jgYdData/{year}")
    public ApiResult jgYdData(@PathVariable("year") String year){
        return tjService.jgYdData(year);
    }

    /**
     * 监管项底数统计  月度数据  钻取功能
     * @author wzj
     * @param map
     * @return 数据
     */
    @PostMapping("jgYdDataClick")
    public ApiResult jgYdDataClick(@RequestBody HashMap map){
        ApiResult data = tjService.jgYdDataClick(map);
        return data;
    }
    /**
     * 企事业单位新增统计  月度数据
     * @author wzj
     * @param map
     * @return 数据
     */
    @PostMapping("qsyAddYdData")
    public ApiResult qsyAddYdData(@RequestBody HashMap map){
        ApiResult data = tjService.qsyAddYdData(map);
        return data;
    }
    /**
     * 重点单位隐患统计  月度数据
     * @author wzj
     * @param map
     * @return 数据
     */
    @PostMapping("zdDwYhYdData")
    public ApiResult zdDwYhYdData(@RequestBody HashMap map){
        return tjService.zdDwYhYdData(map);
    }

    /**
     * 重点单位隐患统计  实时数据
     * @author wzj
     * @param map
     * @return 数据
     */
    @PostMapping("zdDwYhSsData")
    public ApiResult zdDwYhSsData(@RequestBody HashMap map){
        return tjService.zdDwYhSsData(map);
    }
}
