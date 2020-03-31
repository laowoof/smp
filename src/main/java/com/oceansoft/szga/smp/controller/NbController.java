package com.oceansoft.szga.smp.controller;


import com.alibaba.fastjson.JSONObject;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.service.NbService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;


/**
 * 内保
 * @author  wzj
 * @date 2020/3/13
 *
 */
@RestController
@RequestMapping({"nb"})
public class NbController {
    @Autowired
    private NbService nbService;



    /**
     * 内保测试
     * @author wzj
     * @return 数据
     */
    @GetMapping("test")
    public ApiResult test(){
        ApiResult qzfNum = nbService.test();
        return qzfNum;
    }


    /**
     * 企事业单位监管总数
     * @author wzj
     * @return 数据
     */
    @GetMapping("totleNum")
    public ApiResult totleNum(){
        ApiResult totleNum = nbService.totleNum();
        return totleNum;
    }

    /**
     * 重点监测单位总数
     * @author wzj
     * @return 数据
     */
    @GetMapping("totleNumBySl")
    public ApiResult totleNumBySl(){
        ApiResult totleNum = nbService.totleNumBySl();
        return totleNum;
    }
    /**
     * 企事业单位数据
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataByJj")
    public ApiResult findDataByJj(){
        ApiResult num = nbService.findDataByJj();
        return num;
    }
    /**
     * 重点单位 省，市，区县，占比数据
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataByZd")
    public ApiResult findDataByZd(){
        ApiResult data = nbService.findDataByZd();
        return data;
    }
    /**
     * 履历分析 单位登记量排名
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataByOrder")
    public ApiResult findDataByOrder(){
        ApiResult data = nbService.findDataByOrder();
        return data;
    }
    /**
     * 履历分析 单位登记量排名 详情派出所前10
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataByLimit")
    public ApiResult findDataByLimit(String name){
        ApiResult data = nbService.findDataByLimit(name);
        return data;
    }

    /**
     * 履历分析 单位登记量排名 详情派出所前10
     * @author wzj
     * @return 数据
     */
    @GetMapping("findNumByJcsl")
    public ApiResult findNumByJcsl(){
        ApiResult data = nbService.findNumByJcsl();
        return data;
    }

    /**
     * 隐患发现数
     * @author wzj
     * @return 数据
     */
    @GetMapping("findNumByYhsl")
    public ApiResult findNumByYhsl(){
        ApiResult data = nbService.findNumByYhsl();
        return data;
    }
    /**
     * 隐患单位数量分析
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataByFx")
    public ApiResult findDataByFx(){
        ApiResult data = nbService.findDataByFx();
        return data;
    }
    /**
     * 重点单位隐患数量
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataByNum")
    public ApiResult findDataByNum(){
        ApiResult data = nbService.findDataByNum();
        return data;
    }
    /**
     * 重要设施专项检查量排名
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataByZz")
    public ApiResult findDataByZz(){
        ApiResult data = nbService.findDataByZz();
        return data;
    }
    /**
     * 重要设施专项检查量排名 派出所排名
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataByZzLinit")
    public ApiResult findDataByZzLinit(String name){
        ApiResult data = nbService.findDataByZzLinit(name);
        return data;
    }
    /**
     * 全面分析重点单位 省
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataByZzOne")
    public ApiResult findDataByZzOne(){
        ApiResult data = nbService.findDataByZzOne();
        return data;
    }

    /**
     * 重点设施监管总数
     * @author wzj
     * @return 数据
     */
    @GetMapping("findNumByZyss")
    public ApiResult findNumByZyss(){
        ApiResult data = nbService.findNumByZyss();
        return data;
    }

    /**
     * 重点单位从业人员导入数
     * @author wzj
     * @return 数据
     */
    @GetMapping("findNumByCyry")
    public ApiResult findNumByCyry(){
        ApiResult data = nbService.findNumByCyry();
        return data;
    }

    /**
     *  “铸盾”工程单位数
     * @author wzj
     * @return 数据
     */
    @GetMapping("findNumByZd")
    public ApiResult findNumByZd(){
        ApiResult data = nbService.findNumByZd();
        return data;
    }

    /**
     *  生产安全事故立案数
     * @author wzj
     * @return 数据
     */
    @GetMapping("findNumByScaq")
    public ApiResult findNumByScaq(){
        ApiResult data = nbService.findNumByScaq();
        return data;
    }
    /**
     *  全面分析 隐患处理数
     * @author wzj
     * @return 数据
     */
    @GetMapping("findNumByYhcls")
    public ApiResult findNumByYhcls(){
        ApiResult data = nbService.findNumByYhcls();
        return data;
    }

    /**
     *  全面分析-重要设施分析
     * @author wzj
     * @return 数据
     */
    @GetMapping("findNumBySsFx")
    public ApiResult findNumBySsFx(){
        ApiResult data = nbService.findNumBySsFx();
        return data;
    }

    /**
     *  履历分析-重要设施登记量排名
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataZySsLimit")
    public ApiResult findDataZySsLimit(){
        ApiResult data = nbService.findDataZySsLimit();
        return data;
    }
    /**
     *  履历分析-重要设施登记量排名 派出所前10
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataZySsPcs")
    public ApiResult findDataZySsPcs(String name){
        ApiResult data = nbService.findDataZySsPcs(name);
        return data;
    }
    /**
     *  履历分析-隐患发现量排名
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataYhFx")
    public ApiResult findDataYhFx(){
        ApiResult data = nbService.findDataYhFx();
        return data;
    }
    /**
     *  履历分析-隐患发现量排名 前10
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataYhFxPcs")
    public ApiResult findDataYhFxPcs(String name){
        ApiResult data = nbService.findDataYhFxPcs(name);
        return data;
    }
    /**
     *  履历分析-重点单位常规检查排名
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataJctjCg")
    public ApiResult findDataJctjCg(){
        ApiResult data = nbService.findDataJctjCg();
        return data;
    }
    /**
     *  履历分析-常规检查 派出所 前10
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataJctjCgPcs")
    public ApiResult findDataJctjCgPcs(String name){
        ApiResult data = nbService.findDataJctjCgPcs(name);
        return data;
    }

    /**
     *  履历分析-重点单位专项检排名
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataJctjZx")
    public ApiResult findDataJctjZx(){
        ApiResult data = nbService.findDataJctjZx();
        return data;
    }
    /**
     *  履历分析-专项检查 派出所 前10
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataJctjZxPcs")
    public ApiResult findDataJctjZxPcs(String name){
        ApiResult data = nbService.findDataJctjZxPcs(name);
        return data;
    }
    /**
     *  履历分析-缺省单位专项检排名
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataJctjQs")
    public ApiResult findDataJctjQs(){
        ApiResult data = nbService.findDataJctjQs();
        return data;
    }
    /**
     *  履历分析-缺省检查 派出所 前10
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataJctjQsPcs")
    public ApiResult findDataJctjQsPcs(String name){
        ApiResult data = nbService.findDataJctjQsPcs(name);
        return data;
    }
    /**
     *  履历分析-缺省单位专项检排名
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataJctjZd")
    public ApiResult findDataJctjZd(){
        ApiResult data = nbService.findDataJctjZd();
        return data;
    }
    /**
     *  履历分析-缺省检查 派出所 前10
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataJctjZdPcs")
    public ApiResult findDataJctjZdPcs(String name){
        ApiResult data = nbService.findDataJctjZdPcs(name);
        return data;
    }

    /**
     *  履历分析-未整改排名
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataJctjWzg")
    public ApiResult findDataJctjWzg(){
        ApiResult data = nbService.findDataJctjWzg();
        return data;
    }
    /**
     *  履历分析-未整改 派出所 前10
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataJctjWzgPcs")
    public ApiResult findDataJctjWzgPcs(String name){
        ApiResult data = nbService.findDataJctjWzgPcs(name);
        return data;
    }
    /**
     *  履历分析-整改排名
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataJctjZg")
    public ApiResult findDataJctjZg(){
        ApiResult data = nbService.findDataJctjZg();
        return data;
    }
    /**
     *  履历分析-整改 派出所 前10
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataJctjZgPcs")
    public ApiResult findDataJctjZgPcs(String name){
        ApiResult data = nbService.findDataJctjZgPcs(name);
        return data;
    }
    /**
     *  隐患分析-隐患上报数
     * @author wzj
     * @return 数据
     */
    @GetMapping("findNumByGllx")
    public ApiResult findNumByGllx(){
        ApiResult data = nbService.findNumByGllx();
        return data;
    }
    /**
     *  隐患分析- 当场整改，责令限期整改并处警告，责令限期整改
     * @author wzj
     * @return 数据
     */
    @GetMapping("findNumByGljc")
    public ApiResult findNumByGljc(){
        ApiResult data = nbService.findNumByGljc();
        return data;
    }
    /**
     *  隐患分析- 复查
     * @author wzj
     * @return 数据
     */
    @GetMapping("findNumByFc")
    public ApiResult findNumByFc(){
        ApiResult data = nbService.findNumByFc();
        return data;
    }
    /**
     *  隐患分析- 复查  未完成量
     * @author wzj
     * @return 数据
     */
    @GetMapping("findNumByFcWwcl")
    public ApiResult findNumByFcWwcl(){
        ApiResult data = nbService.findNumByFcWwcl();
        return data;
    }
    /**
     *  隐患分析- 复查  未完成量原因
     * @author wzj
     * @return 数据
     */
    @GetMapping("findNumByFcJcjg")
    public ApiResult findNumByFcJcjg(){
        ApiResult data = nbService.findNumByFcJcjg();
        return data;
    }
    /**
     *  隐患分析- 复查审批  未完成量
     * @author wzj
     * @return 数据
     */
    @GetMapping("findNumByFcspWwcl")
    public ApiResult findNumByFcspWwcl(){
        ApiResult data = nbService.findNumByFcspWwcl();
        return data;
    }
    /**
     *  隐患分析- 复查审批  罚款
     * @author wzj
     * @return 数据
     */
    @GetMapping("findNumByFcspFk")
    public ApiResult findNumByFcspFk(){
        ApiResult data = nbService.findNumByFcspFk();
        return data;
    }
    /**
     *  隐患分析- 复查审批  协调解决
     * @author wzj
     * @return 数据
     */
    @GetMapping("findNumByFcspXt")
    public ApiResult findNumByFcspXt(){
        ApiResult data = nbService.findNumByFcspXt();
        return data;
    }
    /**
     *  隐患分析- 隐患处置  隐患处置 当场整改
     * @author wzj
     * @return 数据
     */
    @GetMapping("findNumByCzDczg")
    public ApiResult findNumByCzDczg(){
        ApiResult data = nbService.findNumByCzDczg();
        return data;
    }
    /**
     *  隐患分析- 隐患处置  整改完成数
     * @author wzj
     * @return 数据
     */
    @GetMapping("findNumByCzZgwcs")
    public ApiResult findNumByCzZgwcs(){
        ApiResult data = nbService.findNumByCzZgwcs();
        return data;
    }
    /**
     *  隐患分析- 隐患处置  未完成量
     * @author wzj
     * @return 数据
     */
    @GetMapping("findNumByCzWwcs")
    public ApiResult findNumByCzWwcs(){
        ApiResult data = nbService.findNumByCzWwcs();
        return data;
    }
    /**
     *  重点单位分析-重点单位占比分析-所有区域数据
     * @author wzj
     * @return 数据
     */
    @GetMapping("findNumByZddw")
    public ApiResult findNumByZddw(){
        ApiResult data = nbService.findNumByZddw();
        return data;
    }
    /**
     *  重点单位分析-重点单位占比分析-top5
     * @author wzj
     * @return 数据
     */
    @GetMapping("findNumByZddwLimit")
    public ApiResult findNumByZddwLimit(){
        ApiResult data = nbService.findNumByZddwLimit();
        return data;
    }
    /**
     *  重点单位分析-隐患数量态势-全市 年份
     * @author wzj
     * @return 数据
     */
    @GetMapping("findNumByYhYear")
    public ApiResult findNumByYhYear(){
        ApiResult data = nbService.findNumByYhYear();
        return data;
    }
    /**
     *  重要设施分析-重要设施新增分析
     * @author wzj
     * @return 数据
     */
    @GetMapping("findNumByZyssFx")
    public ApiResult findNumByZyssFx(){
        ApiResult data = nbService.findNumByZyssFx();
        return data;
    }

    /**
     *  重要设施分析-重要设施新增分析  种类
     * @author wzj
     * @return 数据
     */
    @PostMapping("findNumByZyssFxZl")
    public ApiResult findNumByZyssFxZl(@RequestBody JSONObject obj){
        ApiResult data = nbService.findNumByZyssFxZl(obj);
        return data;
    }

    /**
     *  重点单位分析-主动检查分析
     *  @param nf 年份
     *  @author wujg
     *  @return 页面绑定数据
     */
    @GetMapping("findNumByZddwjcfx/{nf}")
    public ApiResult findNumByZddwjcfx(@PathVariable("nf") String nf){
        ApiResult data = nbService.findNumByZddwjcfx(nf);
        return data;
    }

    /**
        Updated upstream
     *  重要设施分析-重要设施新增分析  总量
     * @author wzj
     * @return 数据
     */
    @GetMapping("findNumByZyssTotle")
    public ApiResult findNumByZyssTotle(){
        ApiResult data = nbService.findNumByZyssTotle();
        return data;
    }

    /**
     *  重要设施分析-重点单位占比分析 等级
     * @author wzj
     * @return 数据
     */
    @PostMapping("findNumByDj")
    public ApiResult findNumByDj(@RequestBody JSONObject obj){
        ApiResult data = nbService.findNumByDj(obj);
        return data;
    }

    /**
     *  重要设施分析-重点单位占比分析 种类
     * @author wzj
     * @return 数据
     */
    @PostMapping("findNumByZddwZl")
    public ApiResult findNumByZddwZl(@RequestBody JSONObject obj){
        System.out.println(obj);
        ApiResult data = nbService.findNumByZddwZl(obj);
        return data;
    }

    /**
     *  重要设施分析-重点单位营业状态监测 默认年份
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataByZddwYear")
    public ApiResult findDataByZddwYear(){
        ApiResult data = nbService.findDataByZddwYear();
        return data;
    }
    /**
     *  重要设施分析-重点单位营业状态监测 默认月份
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataByZddwMonth")
    public ApiResult findDataByZddwMonth(){
        ApiResult data = nbService.findDataByZddwMonth();
        return data;
    }
    /**
     *  重要设施分析-重点单位营业状态监测 地区选择月份
     * @author wzj
     * @return 数据
     */
    @PostMapping("findNumByZddwJcMonth")
    public ApiResult findNumByZddwJcMonth(@RequestBody JSONObject obj){
        ApiResult data = nbService.findNumByZddwJcMonth(obj);
        return data;
    }

    /**
     *  全面分析企事业单位  种类选择
     * @author wzj
     * @return 数据
     */
    @PostMapping("findNumByQmQsyLx")
    public ApiResult findNumByQmQsyLx(@RequestBody JSONObject obj){
        ApiResult data = nbService.findNumByQmQsyLx(obj);
        return data;
    }
    /**
     *  全面分析  重要设施
     * @author wzj
     * @return 数据
     */
    @GetMapping("findNumByQmZyss")
    public ApiResult findNumByQmZyss(){
        ApiResult data = nbService.findNumByQmZyss();
        return data;
    }
    /**
     *  全面分析  重要设施 种类选择
     * @author wzj
     * @return 数据
     */
    @PostMapping("findNumByQmZyssZl")
    public ApiResult findNumByQmZyssZl(@RequestBody JSONObject obj){
        ApiResult data = nbService.findNumByQmZyssZl(obj);
        return data;
    }

    /**
     *  全面分析  铸盾单位
     * @author wzj
     * @return 数据
     */
    @GetMapping("findNumByZdNum")
    public ApiResult findNumByZdNum(){
        ApiResult data = nbService.findNumByZdNum();
        return data;
    }

    /**
     * 全面分析 企事业单位默认月份数据
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataQsyMonth")
    public ApiResult findDataQsyMonth(){
        ApiResult data = nbService.findDataQsyMonth();
        return data;
    }
    /**
     * 全面分析 企事业单位默认年份数据
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataQsyYear")
    public ApiResult findDataQsyYear(){
        ApiResult data = nbService.findDataQsyYear();
        return data;
    }

    /**
     * 全面分析 企事业单位数据联调
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataQsyLtMonth")
    public ApiResult findDataQsyLtMonth(String name){
        ApiResult data = nbService.findDataQsyLtMonth(name);
        return data;
    }
    /**
     * 全面分析 企事业单位数据联调
     * @author wzj
     * @return 数据
     */
    @GetMapping("findDataQsyLtYear")
    public ApiResult findDataQsyLtYear(String name){
        ApiResult data = nbService.findDataQsyLtYear(name);
        return data;
    }

    @ApiOperation("重点设施-主动检查")
    @PostMapping("zdss-zdjc")
    public ApiResult zdssZdjc(@RequestBody Map map){
        ApiResult data = nbService.zdssZdjc(map);
        return data;
    }
    /**  重要设施分析-营业状态监测
     *  @param type 类型
     *  @author wujg
     *  @return 页面绑定数据
     */
    @PostMapping("findNumByZyssslZl/{type}")
    public ApiResult findNumByZyssslZl(@PathVariable("type") String type, @RequestBody JSONObject obj){
        ApiResult data = nbService.findNumByZyssslZl(type, obj);
        return data;
    }
}
