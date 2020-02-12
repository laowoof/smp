package com.oceansoft.szga.smp.controller;


import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.entity.CzfPersonNum;
import com.oceansoft.szga.smp.service.ZfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @return
     */
    @GetMapping("czfPersonNum")
    public ApiResult czfPersonNum(){
        ApiResult<CzfPersonNum> czfPersonNum = zfService.CzfPersonNum();
        return czfPersonNum;
    }

    /**
     * @author wzj
     * 出租房数量
     * @return
     */
    @GetMapping("czfNum")
    public ApiResult czfNum(){
        ApiResult<CzfPersonNum> czfNum = zfService.CzfNum();
        return czfNum;
    }

    /**
     * @author wzj
     *  出租房重点人
     * @return
     */
    @GetMapping("czfImp")
    public ApiResult CzfImpPerson(){
        ApiResult czfImpPerson = zfService.CzfImpPerson();
        return czfImpPerson;
    }

    /**
     * @author wzj
     *  群租房重点人员
     * @return
     */
    @GetMapping("qzf")
    public ApiResult QzfPersonNum(){
        ApiResult qzfPersonNum = zfService.QzfPersonNum();
        return qzfPersonNum;
    }

    /**
     * @author wzj
     *  群租房数量
     * @return
     */
    @GetMapping("qzfNum")
    public ApiResult QzfNum(){
        ApiResult qzfNum = zfService.QzfNum();
        return qzfNum;
    }

    /**
     * @author wzj
     * 群租房隐患分析
     * @return
     */
    @GetMapping("qzfDanger")
    public ApiResult QzfDangerous(){
        ApiResult qzfDanger = zfService.QzfDangerous();
        return qzfDanger;
    }

    /**
     * @author wzj
     *群租屋重点人-按区划
     * @return
     */
    @GetMapping("qzwImpPerson")
    public ApiResult QzwImpPerson(){
        ApiResult qzwImpPerson = zfService.QzwImpPerson();
        return qzwImpPerson;
    }

    /**
     * @author wzj
     * 群租房重点人员
     * @return
     */
    @GetMapping("qzfImpPerson")
    public ApiResult QzfImpPerson(){
        ApiResult qzfImpPerson = zfService.QzfImpPerson();
        return qzfImpPerson;
    }

    /**
     * @author wzj
     *  隐患出租房人数
     * @return
     */
    @GetMapping("dangerCzf")
    public ApiResult dangerCzf(){
        ApiResult dangerCzf = zfService.QangerCzf();
        return dangerCzf;
    }

    /**
     * @author wzj
     * @date 2020/1/20
     * 隐患出租房重点人
     * @return
     */
    @GetMapping("dangerCzfImp")
    public ApiResult DangerCzfImpPerson(){
        ApiResult dangerCzfImp = zfService.DangerCzfImpPerson();
        return dangerCzfImp;
    }

    /**
     * @author wzj
     * 隐患群租房数量
     * @return
     */
    @GetMapping("dangerQzfNum")
    public ApiResult DangerQzfNum(){
        ApiResult dangerQzfNum = zfService.DangerQzfNum();
        return dangerQzfNum;
    }

    /**
     * @author wzj
     * 隐患大类分析
     * @return
     */
    @GetMapping("dangerTypeFx")
    public ApiResult DangerTypeFx(){
        ApiResult dangerTypeFx = zfService.DangerTypeFx();
        return dangerTypeFx;
    }
    /**
     * @author wzj
     * 非治安隐患类型
     */
    @GetMapping("notDangerType")
    public ApiResult notDangerType(){
        ApiResult notDangerTypes = zfService.notDangerType();
        return notDangerTypes ;
    }

    /**
     * @author wzj
     * 非治安隐患流程节点监测-上报情况
     * @return
     */
    @GetMapping("notDangerTypeSB")
    public ApiResult notDangerTypeSB(){
        ApiResult notDangerTypeSB = zfService.notDangerTypeSB();
        return notDangerTypeSB ;
    }

    /**
     * @author wzj
     * 非治安隐患数据
     * @return
     */
    @GetMapping("notDangerTypeSJ")
    public ApiResult notDangerTypeSJ(){
        ApiResult notDangerTypeSJ = zfService.notDangerTypeSJ();
        return notDangerTypeSJ ;
    }
    /**
     * @author wzj
     * 流动人口来源地 省
     * @return
     */
    @GetMapping("provice")
    public ApiResult floatingPopulationS(){
        ApiResult provices = zfService.floatingPopulationS();
        return provices;
    }

    /**
     * @author wzj
     * 流动人口来源地 市
     * @return
     */
    @GetMapping("city")
    public ApiResult floatingPopulationShi(){
        ApiResult citys = zfService.floatingPopulationShi();
        return citys;
    }

    /**
     * @author wzj
     *  流动人口来源地 县
     * @return
     */
    @GetMapping("area")
    public ApiResult floatingPopulationX(){
        ApiResult areas = zfService.floatingPopulationX();
        return areas;
    }

    /**
     * @author wzj
     *  流动人口年龄分析
     * @return
     */
    @GetMapping("age")
    public ApiResult floatingPopulationAge(){
        ApiResult ages = zfService.floatingPopulationAge();
        return ages;
    }

    /**
     * @author wzj
     * 流动人口数量
     * @return
     */
    @GetMapping("num")
    public ApiResult floatingPopulationNum(){
        ApiResult num = zfService.floatingPopulationNum();
        return num;
    }

    /**
     * @author wzj
     * 流动人口实有数
     * @return
     */
    @GetMapping("trueNum")
    public ApiResult floatingPopulationTrueNum(){
        ApiResult nums = zfService.floatingPopulationTrueNum();
        return nums;
    }
    /**
     * @author wzj
     *  出租房重点人 行政区划
     * @return
     */
    @GetMapping("czfImpXzqh")
    public ApiResult CzfImpXzqh(){
        ApiResult czfImpXzqh = zfService.CzfImpXzqh();
        return czfImpXzqh;
    }
    /**
     * @author wzj
     *  非治安隐患分发
     * @return
     */
    @GetMapping("fzayhff")
    public ApiResult Fzayhff(){
        ApiResult fzayhff = zfService.Fzayhff();
        return fzayhff;
    }
    /**
     * @author wzj
     *  非治安隐患认领
     * @return
     */
    @GetMapping("fzayhrl")
    public ApiResult Fzayhrl(){
        ApiResult fzayhrl = zfService.Fzayhrl();
        return fzayhrl;
    }
}
