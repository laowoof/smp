package com.oceansoft.szga.smp.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.oceansoft.szga.smp.config.domain.ApiPager;
import com.oceansoft.szga.smp.config.domain.ApiQueryBase;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.service.DataModelService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 危险品分析
 * zhangxh
 * 2020-07-11
 */
@RequestMapping("wxpfx")
@RestController
public class WXPFXController {
    @Autowired
    private DataModelService dataModelService;



    @ApiOperation("总数")
    @RequestMapping("total-count")
    public ApiResult totalCount(){


        //TODO data 模拟数据，待实现
        Map data = new HashMap(){{
            put("dqkczs",100);//当前库存总数
            put("sndjykc",100);//上年度结余库存
            put("rkzl",100);//入库总量
            put("gmrkzl",100);//购买入库总量
            put("scrkzl",100);//生产入库总量
            put("qtrkzl",100);//其他入库总量
            put("ckzl",100);//出库总量
            put("xsckzl",100);//销售出库总量
            put("syckzl",100);//使用出库总量
            put("qtckzl",100);//其他出库总量
        }};
        return new ApiResult().success(data);
    }

    @ApiOperation("购运情况分析-民爆")
    @RequestMapping("gyqkfx-mb/{year}")
    public ApiResult gyqkfxmb(@PathVariable int year){
        //TODO data 模拟数据，待实现
        Map data = new HashMap(){{
            //区域
            put("area", Arrays.asList("吴中区", "姑苏区", "相城区", "度假区","虎丘区","吴江区","工业园区","昆山市","常熟市","太仓市","张家港市"));
            put("gmzsl",Arrays.asList(400, 400, 300, 300, 400, 300, 300, 400, 300, 300, 300));//购买证数量
            put("yszsl",Arrays.asList(400, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500));//购买证数量
            put("gmzzs",1000);//购买证总数
            put("yszzs",1001);//运输证总数
        }};
        return new ApiResult().success(data);
    }

    @ApiOperation("购运情况分析-烟花")
    @RequestMapping("gyqkfx-yh/{year}")
    public ApiResult gyqkfxyh(@PathVariable int year){
        //TODO data 模拟数据，待实现
        Map data = new HashMap(){{
            put("area", Arrays.asList("吴中区", "姑苏区", "相城区", "度假区","虎丘区","吴江区","工业园区","昆山市","常熟市","太仓市","张家港市"));
            put("zb",Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 60, 80));//占比
            put("yszsl",Arrays.asList(400, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500));//运输证数量
            put("yszzs",1000);//运输证总数
        }};
        return new ApiResult().success(data);
    }

    @ApiOperation("购运情况分析-剧毒危险品")
    @RequestMapping("gyqkfx-jdwxp/{year}")
    public ApiResult gyqkfxjdwxp(@PathVariable int year){
        //TODO data 模拟数据，待实现
        Map data = new HashMap(){{
            put("area", Arrays.asList("吴中区", "姑苏区", "相城区", "度假区","虎丘区","吴江区","工业园区","昆山市","常熟市","太仓市","张家港市"));
            put("gmzsl",Arrays.asList(400, 400, 300, 300, 400, 300, 300, 400, 300, 300, 300));//购买证数量
            put("yszsl",Arrays.asList(400, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500));//购买证数量
            put("gmzzs",1000);//购买证总数
            put("yszzs",1001);//运输证总数
        }};
        return new ApiResult().success(data);
    }

    @ApiOperation("购运情况分析-易制爆危险品")
    @RequestMapping("gyqkfx-yzbwxp/{year}")
    public ApiResult gyqkfxyzbwxp(@PathVariable int year){
        //TODO data 模拟数据，待实现
        Map data = new HashMap(){{
            put("area", Arrays.asList("吴中区", "姑苏区", "相城区", "度假区","虎丘区","吴江区","工业园区","昆山市","常熟市","太仓市","张家港市"));
            put("gmbal",Arrays.asList(400, 400, 300, 300, 400, 300, 300, 400, 300, 300, 300));//购买备案量
            put("xsbal",Arrays.asList(400, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500));//销售备案量
            put("gmbazs",1000);//购买备案总数
            put("xsbazs",1001);//销售备案总数
        }};
        return new ApiResult().success(data);
    }

    @ApiOperation("剧毒化学品单位")
    @RequestMapping("jdhxpdw/{year}")
    public ApiResult jdhxpdw(@PathVariable int year){
        //TODO data 模拟数据，待实现
        Map data = new HashMap(){{
            put("area", Arrays.asList("吴中区", "姑苏区", "相城区", "度假区","虎丘区","吴江区","工业园区","昆山市","常熟市","太仓市","张家港市"));
            put("jddws",Arrays.asList(400, 400, 300, 300, 400, 300, 300, 400, 300, 300, 300));//剧毒单位数
            put("jyjs",Arrays.asList(400, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500));//剧易皆是
            put("zs",42);//总数
        }};
        return new ApiResult().success(data);
    }

    @ApiOperation("剧毒化学品类型")
    @RequestMapping("jdhxplx/{year}/{type}")
    public ApiResult jdhxplx(@PathVariable int year,@PathVariable String type){
        //TODO data 模拟数据，待实现
        Map data = new HashMap(){{
            put("legend-data", Lists.newArrayList(ImmutableMap.of("name","氰化钾","value",16),ImmutableMap.of("name","氯化钠","value",17),ImmutableMap.of("name","氰","value",18)));//剧毒单位数
            put("series-data",Arrays.asList("氰化钾", "氯化钠", "氰"));//剧易皆是
            put("zs",51);//总数
        }};
        return new ApiResult().success(data);
    }

    @ApiOperation("剧毒物品使用排行top10")
    @RequestMapping("jdwpsyph/{year}")
    public ApiResult jdwpsyph(@PathVariable int year){
        //TODO data 模拟数据，待实现
        Map data = new HashMap(){{
            put("area", Arrays.asList("吴中区", "姑苏区", "相城区", "度假区","虎丘区","吴江区","工业园区","昆山市","常熟市","太仓市","张家港市"));
            put("bar-data",Arrays.asList(30, 40, 45, 55, 60, 65, 70, 80, 85, 90, 95));//数据
        }};
        return new ApiResult().success(data);
    }
    @ApiOperation("剧毒物品销售排行top10")
    @RequestMapping("jdwpxsph/{year}")
    public ApiResult jdwpxsph(@PathVariable int year){
        //TODO data 模拟数据，待实现
        Map data = new HashMap(){{
            put("area", Arrays.asList("吴中区", "姑苏区", "相城区", "度假区","虎丘区","吴江区","工业园区","昆山市","常熟市","太仓市","张家港市"));
            put("bar-data",Arrays.asList(30, 40, 45, 55, 60, 65, 70, 80, 85, 90, 95));//数据
        }};
        return new ApiResult().success(data);
    }




    @ApiOperation("易制爆化学品单位")
    @RequestMapping("yzbhxpdw/{year}")
    public ApiResult yzbhxpdw(@PathVariable int year){
        //TODO data 模拟数据，待实现
        Map data = new HashMap(){{
            put("area", Arrays.asList("吴中区", "姑苏区", "相城区", "度假区","虎丘区","吴江区","工业园区","昆山市","常熟市","太仓市","张家港市"));
            put("jddws",Arrays.asList(400, 400, 300, 300, 400, 300, 300, 400, 300, 300, 300));//剧毒单位数
            put("jyjs",Arrays.asList(400, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500));//剧易皆是
            put("zs",42);//总数
        }};
        return new ApiResult().success(data);
    }

    @ApiOperation("易制爆化学品类型")
    @RequestMapping("yzbhxplx/{year}/{type}")
    public ApiResult yzbhxplx(@PathVariable int year,@PathVariable String type){
        //TODO data 模拟数据，待实现
        Map data = new HashMap(){{
            put("legend-data", Lists.newArrayList(ImmutableMap.of("name","氰化钾","value",16),ImmutableMap.of("name","氯化钠","value",17),ImmutableMap.of("name","氰","value",18)));//剧毒单位数
            put("series-data",Arrays.asList("氰化钾", "氯化钠", "氰"));//剧易皆是
            put("zs",51);//总数
        }};
        return new ApiResult().success(data);
    }

    @ApiOperation("易制爆物品使用排行top10")
    @RequestMapping("yzbwpsyph/{year}")
    public ApiResult yzbwpsyph(@PathVariable int year){
        //TODO data 模拟数据，待实现
        Map data = new HashMap(){{
            put("area", Arrays.asList("吴中区", "姑苏区", "相城区", "度假区","虎丘区","吴江区","工业园区","昆山市","常熟市","太仓市","张家港市"));
            put("bar-data",Arrays.asList(30, 40, 45, 55, 60, 65, 70, 80, 85, 90, 95));//数据
        }};
        return new ApiResult().success(data);
    }
    @ApiOperation("易制爆物品销售排行top10")
    @RequestMapping("yzbwpxsph/{year}")
    public ApiResult yzbwpxsph(@PathVariable int year){
        //TODO data 模拟数据，待实现
        Map data = new HashMap(){{
            put("area", Arrays.asList("吴中区", "姑苏区", "相城区", "度假区","虎丘区","吴江区","工业园区","昆山市","常熟市","太仓市","张家港市"));
            put("bar-data",Arrays.asList(30, 40, 45, 55, 60, 65, 70, 80, 85, 90, 95));//数据
        }};
        return new ApiResult().success(data);
    }


    @ApiOperation("酒驾案件")
    @RequestMapping("jjaj")
    public ApiResult jjaj(@RequestBody ApiQueryBase query){
        //TODO data 模拟数据，待实现
//        List<Map<String,Object>> list = Lists.newArrayList();
//        String temp ="{statisticalTime: '2020-04-20 17:16', source: 'XX系统', caseCategory: '严重违法', acceptTime: '2019-11-28', name: '李四', id: '220112199106050112', drivingLicense: '220112199106050112', state: '非吊销', organ: '江苏省苏州市交通警察支队'}";
//        for (int i = 0; i < 10; i++) {
//            list.add(JSONObject.parseObject(temp));
//        }
//        int total = 12;
//        ApiPager pager = new ApiPager(query.getPs(), query.getPi(),total, list);
        return new ApiResult().success(dataModelService.pageJjaj(query));
    }
    @ApiOperation("危险驾驶")
    @RequestMapping("wxjs")
    public ApiResult wxjs(@RequestBody ApiQueryBase query){
        //TODO data 模拟数据，待实现
//        List<Map<String,Object>> list = Lists.newArrayList();
//        String temp ="{statisticalTime: '2020-04-20 17:16', source: 'XX系统', caseCategory: '危险驾驶', acceptTime: '2019-12-29', name: '张三', id: '220112199106050112', drivingLicense: '220112199106050112', state: '非吊销', organ: '江苏省苏州市交通警察支队'}";
//        for (int i = 0; i < 10; i++) {
//            list.add(JSONObject.parseObject(temp));
//        }
//        int total = 12;
//        ApiPager pager = new ApiPager(query.getPs(), query.getPi(),total, list);
        return new ApiResult().success(dataModelService.pageWxjs(query));
    }

    @ApiOperation("寄递物流从业人员背景审查")
    @RequestMapping("jdry")
    public ApiResult jdry(@RequestBody ApiQueryBase query){
        //TODO data 模拟数据，待实现
//        List<Map<String,Object>> list = Lists.newArrayList();
//        String temp ="{statisticalTime: '2020-04-20 17:16', source: 'XX系统', caseCategory: '危险驾驶', acceptTime: '2019-12-29', name: '张三', id: '220112199106050112', drivingLicense: '220112199106050112', state: '非吊销', organ: '江苏省苏州市交通警察支队'}";
//        for (int i = 0; i < 10; i++) {
//            list.add(JSONObject.parseObject(temp));
//        }
//        int total = 12;
//        ApiPager pager = new ApiPager(query.getPs(), query.getPi(),total, list);
        return new ApiResult().success(dataModelService.jdry(query));
    }

    @ApiOperation("省厅危化品从业人员")
    @RequestMapping("stwhp")
    public ApiResult stwhp(@RequestBody ApiQueryBase query){
        //TODO data 模拟数据，待实现
//        List<Map<String,Object>> list = Lists.newArrayList();
//        String temp ="{statisticalTime: '2020-04-20 17:16', source: 'XX系统', caseCategory: '危险驾驶', acceptTime: '2019-12-29', name: '张三', id: '220112199106050112', drivingLicense: '220112199106050112', state: '非吊销', organ: '江苏省苏州市交通警察支队'}";
//        for (int i = 0; i < 10; i++) {
//            list.add(JSONObject.parseObject(temp));
//        }
//        int total = 12;
//        ApiPager pager = new ApiPager(query.getPs(), query.getPi(),total, list);
        return new ApiResult().success(dataModelService.stwhp(query));
    }
}
