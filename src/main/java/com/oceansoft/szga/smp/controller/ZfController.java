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
     * 出租房人数
     * @return 数据
     */
    @GetMapping("czfPersonNum")
    public ApiResult czfPersonNum(){
        ApiResult<CzfPersonNum> czfPersonNum = zfService.czfPersonNum();
        return czfPersonNum;
    }

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
     *  出租房重点人
     * @return 数据
     */
    @GetMapping("czfImp")
    public ApiResult CzfImpPerson(){
        ApiResult czfImpPerson = zfService.czfImpPerson();
        return czfImpPerson;
    }

    /**
     * @author wzj
     *  群租房重点人员
     * @return 数据
     */
    @GetMapping("qzf")
    public ApiResult QzfPersonNum(){
        ApiResult qzfPersonNum = zfService.qzfPersonNum();
        return qzfPersonNum;
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
     *  根绝区域获取群租房的区域新增数量
     * @return 数据
     */
    @GetMapping("qzfAreaAddNum")
    public ApiResult qzfAreaAddNum(String xzqhmc,String num){
        ApiResult qzfNum = zfService.qzfAreaAddNum(xzqhmc,num);
        return qzfNum;
    }

    /**
     * @author wzj
     *  获取每一天的总数量
     * @return 数据
     */
    @GetMapping("qzfTotleNum")
    public ApiResult qzfTotleNum(String num){
        ApiResult qzfNum = zfService.qzfTotleNum(num);
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
     *  群租房单个区域本月新增数量
     * @return 数据
     */
    @GetMapping("addQzfNum")
    public ApiResult addQzfNum(String xzqhmc){
        ApiResult qzfNum = zfService.addQzfData2(xzqhmc);
        return qzfNum;
    }

    /**
     * @author wzj
     *  群租房某天新增数量
     * @return 数据
     */
    @GetMapping("addQzfNum3")
    public ApiResult addQzfNum3(String num){
        ApiResult qzfNum = zfService.addQzfData3(num);
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
     *  隐患出租房人数
     * @return 数据
     */
    @GetMapping("dangerCzf")
    public ApiResult dangerCzf(){
        ApiResult dangerCzf = zfService.dangerCzf();
        return dangerCzf;
    }

    /**
     * @author wzj
     * @date 2020/1/20
     * 隐患出租房重点人
     * @return 数据
     */
    @GetMapping("dangerCzfImp")
    public ApiResult DangerCzfImpPerson(){
        ApiResult dangerCzfImp = zfService.dangerCzfImpPerson();
        return dangerCzfImp;
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
    public ApiResult yhQzfTotleNum(String xzqhmc){
        ApiResult totleNum = zfService.yhQzfTotleNum(xzqhmc);
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
     * 非治安隐患类型
     * @return 数据
     */
    @GetMapping("notDangerType")
    public ApiResult notDangerType(){
        ApiResult notDangerTypes = zfService.notDangerType();
        return notDangerTypes ;
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
     * 非治安隐患数据处理 排序 百分比
     * @return 数据
     */
    @GetMapping("fzasjDesc")
    public ApiResult fzasjDesc() {
        ApiResult fzasjDesc = zfService.fzasjDesc();
        return fzasjDesc;
    }

    /**
     * @author wzj
     * 单独数据7/30
     * @return 数据
     */
    @GetMapping("sigleData")
    public ApiResult sigleData(String xzqhmc,String num){
        ApiResult sigleData = zfService.sigleData(xzqhmc,num);
        return sigleData ;
    }

    /**
     * @author wzj
     * 单区域数据
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
        System.err.println(num);
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
        System.err.println(num);
        ApiResult totleNum2 = zfService.totleNum2(num);
        return totleNum2;
    }

    /**
     * @author wzj
     * 治安隐患单区域数据统计
     * @return 数据
     */
    @GetMapping("zaYhNum")
    public ApiResult zaYhNum(String xzqhmc){
        System.err.println(xzqhmc);
        ApiResult num = zfService.zaYhNum(xzqhmc);
        return num;
    }

    /**
     * @author wzj
     * 流动人口来源地 省
     * @return 数据
     */
    @GetMapping("provice")
    public ApiResult floatingPopulationS(){
        ApiResult provices = zfService.floatingPopulationS();
        return provices;
    }

    /**
     * @author wzj
     * 流动人口来源地 市
     * @return 数据
     */
    @GetMapping("city")
    public ApiResult floatingPopulationShi(){
        ApiResult citys = zfService.floatingPopulationShi();
        return citys;
    }

    /**
     * @author wzj
     *  流动人口来源地 县
     * @return 数据
     */
    @GetMapping("area")
    public ApiResult floatingPopulationX(){
        ApiResult areas = zfService.floatingPopulationX();
        return areas;
    }

    /**
     * @author wzj
     *  流动人口年龄分析
     * @return 数据
     */
    @GetMapping("age")
    public ApiResult floatingPopulationAge(){
        ApiResult ages = zfService.floatingPopulationAge();
        return ages;
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
     * 流动人口数量降序
     * @return 数据
     */
    @GetMapping("findNumDesc")
    public ApiResult findNumDesc(){
        ApiResult num = zfService.findNumDesc();
        return num;
    }

    /**
     * @author wzj
     * 流动人口实有数
     * @return 数据
     */
    @GetMapping("trueNum")
    public ApiResult floatingPopulationTrueNum(){
        ApiResult nums = zfService.floatingPopulationTrueNum();
        return nums;
    }
    /**
     * @author wzj
     *  出租房重点人 行政区划
     * @return 数据
     */
    @GetMapping("czfImpXzqh")
    public ApiResult CzfImpXzqh(){
        ApiResult czfImpXzqh = zfService.czfImpXzqh();
        return czfImpXzqh;
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
     * 隐患出租房重点人人数-按行政区划
     * @return 数据
     */
    @GetMapping("czfzdrrs-xzqh")
    public ApiResult CzfzdrrsXzqh(){
        ApiResult xzqh = zfService.czfzdrrsXzqh();
        return xzqh;
    }
    /**
     * @author wzj
     *  隐患出租房重点人人数-按重点类型
     * @return 数据
     */
    @GetMapping("czfzdrrs-zdlx")
    public ApiResult CzfzdrrsZdlx(){
        ApiResult zdlx = zfService.czfzdrrsZdlx();
        return zdlx;
    }
    /**
     * @author wzj
     * 隐患出租重点人-按类型
     * @return 数据
     */
    @GetMapping("yhczfzdr-lx")
    public ApiResult YhczfzdrLx(){
        ApiResult lx = zfService.yhczfzdrLx();
        return lx;
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
     * 数图-隐患房屋数量-按派出所分类
     * @return 数据
     */
    @GetMapping("yhfwpcs")
    public ApiResult Yhfwpcs(){
        ApiResult yhfwpcs = zfService.yhfwpcs();
        return yhfwpcs;
    }
    /**
     * @author wzj
     * 数图-隐患房屋数量-按派出所分类
     * @return 数据
     */
    @GetMapping("yhqs")
    public ApiResult yhqs(){
        ApiResult yhqs = zfService.yhqs();
        return yhqs;
    }
    /**
     * @author wzj
     * 隐患群租房人数
     * @return 数据
     */
    @GetMapping("yhqzfrs")
    public ApiResult yhqzfrs(){
        ApiResult yhqzfrs = zfService.yhqzfrs();
        return yhqzfrs;
    }
    /**
     * @author wzj
     * 隐患群租房重点人人数-按行政区划
     * @return 数据
     */
    @GetMapping("qzfzdrrs-xzqh")
    public ApiResult qzfzdrrsXzqh(){
        ApiResult xzqh = zfService.qzfzdrrsXzqh();
        return xzqh;
    }
    /**
     * @author wzj
     * 隐患群租房重点人人数-按重点类型
     * @return 数据
     */
    @GetMapping("qzfzdrrs-zdlx")
    public ApiResult qzfzdrrsZdlx(){
        ApiResult zdlx = zfService.qzfzdrrsZdlx();
        return zdlx;
    }
    /**
     * @author wzj
     * 隐患群租房重点人员
     * @return 数据
     */
    @GetMapping("yhqzfzdry")
    public ApiResult yhqzfzdry(){
        ApiResult yhqzfzdry = zfService.yhqzfzdry();
        return yhqzfzdry;
    }
    /**
     * @author wzj
     * 隐患群租重点人-按类型
     * @return 数据
     */
    @GetMapping("yhqzfzdr-lx")
    public ApiResult yhqzfzdrLx(){
        ApiResult yhqzfzdrLx = zfService.yhqzfzdrLx();
        return yhqzfzdrLx;
    }
    /**
     * @author wzj
     * 隐患群租屋数量
     * @return 数据
     */
    @GetMapping("yhqzwsj")
    public ApiResult yhqzwsj(){
        ApiResult yhqzwsj = zfService.yhqzwsj();
        return yhqzwsj;
    }
    /**
     * @author wzj
     * 隐患群租屋重点人
     * @return 数据
     */
    @GetMapping("yhqzwzdr")
    public ApiResult yhqzwzdr(){
        ApiResult yhqzwzdr = zfService.yhqzwzdr();
        return yhqzwzdr;
    }
    /**
     * @author wzj
     * 治安隐患类型
     * @return 数据
     */
    @GetMapping("zayhlx")
    public ApiResult zayhlx(){
        ApiResult zayhlx = zfService.zayhlx();
        return zayhlx;
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
     * @author wzj
     * 治安隐患数据 整体排序  百分比
     * @return 数据
     */
    @GetMapping("zayhsjDesc")
    public ApiResult zayhsjDesc(){
        ApiResult zayhsj = zfService.zayhsjDesc();
        return zayhsj;
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
     * 出租房重点人员
     * @return 数据
     */
    @GetMapping("czfzdry")
    public ApiResult czfzdry(){
        ApiResult czfzdry = zfService.czfzdry();
        return czfzdry;
    }
}
