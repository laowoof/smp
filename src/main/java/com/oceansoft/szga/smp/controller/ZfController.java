package com.oceansoft.szga.smp.controller;


import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.entity.CzfPersonNum;
import com.oceansoft.szga.smp.service.ZfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *  出租房 出租屋
 * @author wzj
 * @date 2019/1/19
 */
@RestController
@RequestMapping({"szga"})
public class ZfController {
    @Autowired
    private ZfService zfService;

    /**
     * @author wzj
     * 出租房数量
     * @return 数据
     */
    @GetMapping("czfNum")
    public ApiResult czfNum(){
        ApiResult<CzfPersonNum> czfNum = zfService.czfNum();
        return czfNum;
    }

    /**
     * @author wzj
     * 出租房数量降序
     * @return 数据
     */
    @GetMapping("czfNumDesc")
    public ApiResult czfNumDesc(){
        ApiResult<CzfPersonNum> czfNumDesc = zfService.czfNumDesc();
        return czfNumDesc;
    }

    /**
     * @author wzj
     *  群租房数量
     * @return 数据
     */
    @GetMapping("qzfNum")
    public ApiResult QzfNum(){
        ApiResult qzfNum = zfService.qzfNum();
        return qzfNum;
    }
    /**
     * 近期内群租房户数量
     * @author wzj
     * @return 数据
     */
    @GetMapping("nearYhQzf")
    public ApiResult nearYhQzf(String num){
        ApiResult nearYhQzf = zfService.nearYhQzf(num);
        return nearYhQzf;
    }

    /**
     * 近期内群隐患数
     * @author wzj
     * @return 数据
     */
    @GetMapping("nearQzfNum")
    public ApiResult nearQzfNum(String num){
        ApiResult qzfNum = zfService.nearQzfNum(num);
        return qzfNum;
    }

    /**
     * @author wzj
     *  群租房当月数据
     * @return 数据
     */
    @GetMapping("qzfMonthNum")
    public ApiResult qzfMonthNum(String time){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat simpleDateFormatMonth = new SimpleDateFormat("yyyy-MM");
        time = simpleDateFormatMonth.format(c.getTime());
        ApiResult qzfNum = zfService.qzfMonthData(time);
        return qzfNum;
    }

    /**
     * @author wzj
     *  根绝区域获取群租房的区域总数量
     * @return 数据
     */
    @GetMapping("qzfAreaTotleNum")
    public ApiResult qzfAreaNum(String xzqhmc,String num){
        ApiResult qzfNum = zfService.qzfAreaNum(xzqhmc,num);
        return qzfNum;
    }

    /**
     * @author wzj
     *  群租房上个月总数据
     * @return 数据
     */
    @GetMapping("qzfMonthNum2")
    public ApiResult qzfMonthTwoNum(String time){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
        date = calendar.getTime();
        String accDate = format.format(date);
        ApiResult qzfNum = zfService.qzfMonthData(accDate);
        return qzfNum;
    }

    /**
     * @author wzj
     *  群租房单区域本月新增数量
     * @return 数据
     */
    @GetMapping("areaAddNum")
    public ApiResult areaAddNum(){
        ApiResult qzfNum = zfService.areaAddNum();
        return qzfNum;
    }

    /**
     * @author wzj
     * 群租房隐患分析
     * @return 数据
     */
    @GetMapping("qzfDanger")
    public ApiResult QzfDangerous(){
        ApiResult qzfDanger = zfService.qzfDangerous();
        return qzfDanger;
    }

    /**
     * @author wzj
     * 群租房隐患分析 非治安
     * @return 数据
     */
    @GetMapping("qzfDanger2")
    public ApiResult QzfDangerous2(){
        ApiResult qzfDanger2 = zfService.qzfDangerous2();
        return qzfDanger2;
    }


    /**
     * @author wzj
     *群租屋重点人-按区划
     * @return 数据
     */
    @GetMapping("qzwImpPerson")
    public ApiResult QzwImpPerson(){
        ApiResult qzwImpPerson = zfService.qzwImpPerson();
        return qzwImpPerson;
    }

    /**
     * @author wzj
     * 群租房重点人员
     * @return 数据
     */
    @GetMapping("qzfImpPerson")
    public ApiResult QzfImpPerson(){
        ApiResult qzfImpPerson = zfService.qzfImpPerson();
        return qzfImpPerson;
    }

    /**
     * @author wzj
     * 隐患群租房数量
     * @return 数据
     */
    @GetMapping("dangerQzfNum")
    public ApiResult DangerQzfNum(){
        ApiResult dangerQzfNum = zfService.dangerQzfNum();
        return dangerQzfNum;
    }

    /**
     * @author wzj
     * 隐患群租房单区数量
     * @return 数据
     */
    @GetMapping("yhQzfTotleNum")
    public ApiResult yhQzfTotleNum(){
        ApiResult totleNum = zfService.yhQzfTotleNum();
        return totleNum;
    }

    /**
     * @author wzj
     * 隐患大类分析
     * @return 数据
     */
    @GetMapping("dangerTypeFx")
    public ApiResult DangerTypeFx(){
        ApiResult dangerTypeFx = zfService.dangerTypeFx();
        return dangerTypeFx;
    }

    /**
     * @author wzj
     * 非治安隐患流程节点监测-上报情况
     * @return 数据
     */
    @GetMapping("notDangerTypeSB")
    public ApiResult notDangerTypeSB(){
        ApiResult notDangerTypeSB = zfService.notDangerTypeSb();
        return notDangerTypeSB ;
    }

    /**
     * @author wzj
     * 非治安隐患数据
     * @return 数据
     */
    @GetMapping("notDangerTypeSJ")
    public ApiResult notDangerTypeSJ(){
        ApiResult notDangerTypeSJ = zfService.notDangerTypeSj();
        return notDangerTypeSJ ;
    }

    /**
     * @author wzj
     * 非治安隐患数据  按照区县排序
     * @return 数据
     */
    @GetMapping("fZaSj")
    public ApiResult fZaSj(){
        ApiResult fZaSj = zfService.fZaSj();
        return fZaSj ;
    }


    /**
     * @author wzj
     * 单独数据7/30 非治安近几日数据
     * @return 数据
     */
    @GetMapping("sigleData")
    public ApiResult sigleData(String xzqhmc,String num){
        ApiResult sigleData = zfService.sigleData(xzqhmc,num);
        return sigleData ;
    }

    /**
     * @author wzj
     * 单独数据 治安近7/30日数据
     * @return 数据
     */
    @GetMapping("findDataByName")
    public ApiResult findDataByName(String xzqhmc,String num){
        ApiResult data = zfService.findDataByName(xzqhmc,num);
        return data ;
    }

    /**
     * @author wzj
     * 单区域数据 非治安
     * @return 数据
     */
    @GetMapping("fzaYhNum")
    public ApiResult fzaYhNum(String xzqhmc){
        ApiResult num = zfService.fzaYhNum(xzqhmc);
        return num;
    }

    /**
     * @author wzj
     * 非治安隐患数据统计
     * @return 数据
     */
    @GetMapping("totleNum")
    public ApiResult totleNum(String num){
        ApiResult totleNum = zfService.totleNum(num);
        return totleNum ;
    }
    /**
     * @author wzj
     * 治安隐患数据统计
     * @return 数据
     */
    @GetMapping("totleNum2")
    public ApiResult totleNum2(String num){
        ApiResult totleNum2 = zfService.totleNum2(num);
        return totleNum2;
    }

    /**
     * @author wzj
     * 治安隐患单区域数据统计
     * @return 数据
     */
    @GetMapping("zaYhNum")
    public ApiResult zaYhNum(){
        ApiResult num = zfService.zaYhNum();
        return num;
    }

    /**
     * @author wzj
     * 流动人口数量
     * @return 数据
     */
    @GetMapping("num")
    public ApiResult floatingPopulationNum(){
        ApiResult num = zfService.floatingPopulationNum();
        return num;
    }

    /**
     * @author wzj
     * 流动人口数量分析
     * @return 数据
     */
    @GetMapping("ldryFx")
    public ApiResult ldryFxData(){
        ApiResult num = zfService.ldryFxData();
        return num;
    }

    /**
     * @author wzj
     *  非治安隐患分发
     * @return 数据
     */
    @GetMapping("fzayhff")
    public ApiResult Fzayhff(){
        ApiResult fzayhff = zfService.fzayhff();
        return fzayhff;
    }
    /**
     * @author wzj
     *  非治安隐患审核
     * @return 数据
     */
    @GetMapping("fzayhsh")
    public ApiResult Fzayhsh(){
        ApiResult fzayhsh = zfService.fzayhsh();
        return fzayhsh;
    }
    /**
     * @author wzj
     *  非治安隐患认领
     * @return 数据
     */
    @GetMapping("fzayhrl")
    public ApiResult Fzayhrl() {
        ApiResult fzayhrl = zfService.fzayhrl();
        return fzayhrl;
    }
    /**
     * @author wzj
     *  非治安隐患整改
     * @return 数据
     */
    @GetMapping("fzayhza")
    public ApiResult Fzayhza(){
        ApiResult fzayhza = zfService.fzayhza();
        return fzayhza;
    }
    /**
     * @author wzj
     *  群租房区域流动人员数量
     * @return 数据
     */
    @GetMapping("qyldrysl")
    public ApiResult Qyldrysl(){
        ApiResult qyldrysl = zfService.qyldrysl();
        return qyldrysl;
    }

    /**
     * @author wzj
     * 隐患出租屋数量
     * @return 数据
     */
    @GetMapping("yhczwsj")
    public ApiResult yhczwsj(){
        ApiResult yhczwsj = zfService.yhczwsj();
        return yhczwsj;
    }

    /**
     * @author wzj
     * 隐患数据   非治安
     * @return 数据
     */
    @GetMapping("yhqs")
    public ApiResult yhqs(String num){
        ApiResult yhqs = zfService.yhqs(num);
        return yhqs;
    }
    /**
     * @author wzj
     * 隐患数据   治安
     * @return 数据
     */
    @GetMapping("yhqs2")
    public ApiResult yhqs2(String num){
        ApiResult yhqs2 = zfService.yhqs2(num);
        return yhqs2;
    }

    /**
     * @author wzj
     * 治安隐患数据
     * @return 数据
     */
    @GetMapping("zayhsj")
    public ApiResult zayhsj(){
        ApiResult zayhsj = zfService.zayhsj();
        return zayhsj;
    }

    /**
     * 非治安 治安隐患数据
     * @author wzj
     * @date 2020/3/4
     * @return 数据
     */
    @GetMapping("yhsData")
    public ApiResult yhsData(){
        ApiResult yhsData = zfService.yhsData();
        return yhsData;
    }

    /**
     * 非治安 隐患数据  近期内 7、30
     * @author wzj
     * @date 2020/3/6
     * @return 数据
     */
    @GetMapping("nearYhsData")
    public ApiResult nearYhsData(String num){
        ApiResult data = zfService.nearYhsData(num);
        return data;
    }

    /**
     * 非治安 隐患数据 单区域 近期内 7、30
     * @author wzj
     * @date 2020/3/6
     * @return 数据
     */
    @GetMapping("singleAreaData")
    public ApiResult singleAreaData(String xzqhmc,String num){
        ApiResult data = zfService.singleAreaData(xzqhmc,num);
        return data;
    }

    /**
     * @author wzj
     * 安全监管群租房治安隐患整改发现数量
     * @return 数据
     */
    @GetMapping("zayhzg-fxsl")
    public ApiResult zayhFxsl(){
        ApiResult zayhFxsl = zfService.zayhFxsl();
        return zayhFxsl;
    }
    /**
     * @author wzj
     * 安全监管群租房治安隐患整改未整改数量
     * @return 数据
     */
    @GetMapping("zayhzg-wzgsl")
    public ApiResult zayhWzgsl(){
        ApiResult zayhWzgsl = zfService.zayhWzgsl();
        return zayhWzgsl;
    }
    /**
     * @author wzj
     * 安全监管群租房治安隐患整改整改数量
     * @return 数据
     */
    @GetMapping("zayhzg-zgsl")
    public ApiResult zayhZgsl(){
        ApiResult zayhZgsl = zfService.zayhZgsl();
        return zayhZgsl;
    }
    /**
     * @author wzj
     * 重点人员数量
     * @return 数据
     */
    @GetMapping("zdrysl")
    public ApiResult zdrysl(){
        ApiResult zdrysl = zfService.zdrysl();
        return zdrysl;
    }

    /**
     * @author wzj
     *   治安隐患数据
     * @return 数据
     */
    @GetMapping("zaData")
    public ApiResult zaData(){
        ApiResult data = zfService.zaData();
        return data;
    }
}
