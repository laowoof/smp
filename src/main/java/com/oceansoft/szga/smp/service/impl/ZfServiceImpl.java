package com.oceansoft.szga.smp.service.impl;

import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.entity.CzfNum;
import com.oceansoft.szga.smp.entity.CzfPersonNum;
import com.oceansoft.szga.smp.mapper.ZfMapper;
import com.oceansoft.szga.smp.service.ZfService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 *  出租房
 * @author wzj
 * @date 2019/1/19
 */

@Service
public class ZfServiceImpl implements ZfService
{

    @Resource
    private ZfMapper zfMapper;



    @Override
    public ApiResult czfPersonNum() {
        List<CzfPersonNum> czfPersonNums = zfMapper.czfPersonNum();
        return new ApiResult().success(200,"返回数据",czfPersonNums);
    }

    @Override
    public ApiResult czfNum() {
        List<CzfNum> czfNums = zfMapper.czfNum();
        return new ApiResult().success(200,"返回数据",czfNums);

    }

    @Override
    public ApiResult czfImpPerson() {
        List<HashMap> czfNums = zfMapper.czfImpPerson();
        return new ApiResult().success(200,"返回数据",czfNums);
    }

    @Override
    public ApiResult qzfPersonNum() {
        List<HashMap> qzfPersonNums = zfMapper.qzfPersonNum();
        return new ApiResult().success(200,"返回数据",qzfPersonNums);
    }

    @Override
    public ApiResult qzfNum() {
        List<HashMap> qzfNum = zfMapper.qzfNum();
        return new ApiResult().success(200,"返回数据",qzfNum);
    }

    @Override
    public ApiResult qzfDangerous() {
        List<HashMap> qzfDanger = zfMapper.qzfDangerous();
        return new ApiResult().success(200,"返回数据",qzfDanger);
    }

    @Override
    public ApiResult qzwImpPerson() {
        List<HashMap> qzwImpPerson = zfMapper.qzwImpPerson();
        return new ApiResult().success(200,"返回数据",qzwImpPerson);
    }
    @Override
    public ApiResult qzfImpPerson() {
        List<HashMap> qzfImpPerson = zfMapper.qzfImpPerson();
        return new ApiResult().success(200,"返回数据",qzfImpPerson);
    }

    @Override
    public ApiResult dangerCzf() {
        List<HashMap> dangerCzf = zfMapper.dangeroursCzf();
        return new ApiResult().success(200,"返回数据",dangerCzf);
    }

    @Override
    public ApiResult dangerCzfImpPerson() {
        List<HashMap> dangerCzfImpPerson = zfMapper.dangerCzfImpPerson();
        return new ApiResult().success(200,"返回数据",dangerCzfImpPerson);
    }

    @Override
    public ApiResult dangerQzfNum() {
        List<HashMap> dangerQzfNum = zfMapper.dangerQzfNum();
        return new ApiResult().success(200,"返回数据",dangerQzfNum);
    }

    @Override
    public ApiResult dangerTypeFx() {
        List<HashMap> dangerTypeFx = zfMapper.dangerTypeFx();
        return new ApiResult().success(200,"返回数据",dangerTypeFx);
    }
    @Override
    public ApiResult floatingPopulationS() {
        List<HashMap> floatPrivate = zfMapper.floatingPopulationS();
        return new ApiResult().success(200,"返回数据",floatPrivate);
    }

    @Override
    public ApiResult floatingPopulationShi() {
        List<HashMap> floatCity = zfMapper.floatingPopulationS();
        return new ApiResult().success(200,"返回数据",floatCity);
    }

    @Override
    public ApiResult floatingPopulationX() {
        List<HashMap> floatArea = zfMapper.floatingPopulationX();
        return new ApiResult().success(200,"返回数据",floatArea);
    }

    @Override
    public ApiResult floatingPopulationAge() {
        List<HashMap> floatAge = zfMapper.floatingPopulationAge();
        return new ApiResult().success(200,"返回数据",floatAge);
    }

    @Override
    public ApiResult floatingPopulationNum() {
        List<HashMap> floatNum = zfMapper.floatingPopulationNum();
        return new ApiResult().success(200,"返回数据",floatNum);
    }

    @Override
    public ApiResult floatingPopulationTrueNum() {
        List<HashMap> floatTrueNum = zfMapper.floatingPopulationTrueNum();
        return new ApiResult().success(200,"返回数据",floatTrueNum);
    }
    @Override
    public ApiResult notDangerType() {
        List<HashMap> notDangerType = zfMapper.notDangerType();
        return new ApiResult().success(200,"返回数据",notDangerType);
    }

    @Override
    public ApiResult notDangerTypeSb() {
        List<HashMap> notDangerTypeSB = zfMapper.notDangerTypeSb();
        return new ApiResult().success(200,"返回数据",notDangerTypeSB);
    }

    @Override
    public ApiResult notDangerTypeSj() {
        List<HashMap> notDangerTypeSJ = zfMapper.notDangerTypeSj();
        return new ApiResult().success(200,"返回数据",notDangerTypeSJ);
    }

    @Override
    public ApiResult czfImpXzqh() {
        List<HashMap> czfImpXzqh = zfMapper.czfImpXzqh();
        return new ApiResult().success(200,"返回数据",czfImpXzqh);
    }

    @Override
    public ApiResult fzayhff() {
        List<HashMap> fzayhff = zfMapper.fzayhff();
        return new ApiResult().success(200,"返回数据",fzayhff);
    }

    @Override
    public ApiResult fzayhrl() {
        List<HashMap> fzayhrl = zfMapper.fzayhrl();
        return new ApiResult().success(200,"返回数据",fzayhrl);
    }
    @Override
    public ApiResult fzayhsh() {
        List<HashMap> fzayhsh = zfMapper.fzayhsh();
        return new ApiResult().success(200,"返回数据",fzayhsh);
    }
    @Override
    public ApiResult fzayhza() {
        List<HashMap> fzayhza = zfMapper.fzayhza();
        return new ApiResult().success(200,"返回数据",fzayhza);
    }

    @Override
    public ApiResult qyldrysl() {
        List<HashMap> qyldrysl = zfMapper.qyldrysl();
        return new ApiResult().success(200,"返回数据",qyldrysl);
    }

    @Override
    public ApiResult czfzdrrsXzqh() {
        List<HashMap> xzqh = zfMapper.czfzdrrsXzqh();
        return new ApiResult().success(200,"返回数据",xzqh);
    }

    @Override
    public ApiResult czfzdrrsZdlx() {
        List<HashMap> zdlx = zfMapper.czfzdrrsZdlx();
        return new ApiResult().success(200,"返回数据",zdlx);
    }

    @Override
    public ApiResult yhczfzdrLx() {
        List<HashMap> lx = zfMapper.yhczfzdrLx();
        return new ApiResult().success(200,"返回数据",lx);
    }

    @Override
    public ApiResult yhczwsj() {
        List<HashMap> yhczwsj = zfMapper.yhczwsj();
        return new ApiResult().success(200,"返回数据",yhczwsj);
    }

    @Override
    public ApiResult yhfwpcs() {
        List<HashMap> yhfwpcs = zfMapper.yhfwpcs();
        return new ApiResult().success(200,"返回数据",yhfwpcs);
    }

    @Override
    public ApiResult yhqs() {
        List<HashMap> yhqs = zfMapper.yhqs();
        return new ApiResult().success(200,"返回数据",yhqs);
    }

    @Override
    public ApiResult yhqzfrs() {
        List<HashMap> yhqzfrs = zfMapper.yhqzfrs();
        return new ApiResult().success(200,"返回数据",yhqzfrs);
    }

    @Override
    public ApiResult qzfzdrrsXzqh() {
        List<HashMap> xzqh= zfMapper.qzfzdrrsXzqh();
        return new ApiResult().success(200,"返回数据",xzqh);
    }

    @Override
    public ApiResult qzfzdrrsZdlx() {
        List<HashMap> zdlx = zfMapper.qzfzdrrsZdlx();
        return new ApiResult().success(200,"返回数据",zdlx);
    }

    @Override
    public ApiResult yhqzfzdry() {
        List<HashMap> yhqzfzdry = zfMapper.yhqzfzdry();
        return new ApiResult().success(200,"返回数据",yhqzfzdry);
    }

    @Override
    public ApiResult yhqzfzdrLx() {
        List<HashMap> yhqzfzdrLx = zfMapper.yhqzfzdrLx();
        return new ApiResult().success(200,"返回数据",yhqzfzdrLx);
    }

    @Override
    public ApiResult yhqzwsj() {
        List<HashMap> yhqzwsj = zfMapper.yhqzwsj();
        return new ApiResult().success(200,"返回数据",yhqzwsj);
    }

    @Override
    public ApiResult yhqzwzdr() {
        List<HashMap> yhqzwzdr = zfMapper.yhqzwzdr();
        return new ApiResult().success(200,"返回数据",yhqzwzdr);
    }

    @Override
    public ApiResult zayhlx() {
        List<HashMap> zayhlx = zfMapper.zayhlx();
        return new ApiResult().success(200,"返回数据",zayhlx);
    }

    @Override
    public ApiResult zayhsj() {
        List<HashMap> zayhsj = zfMapper.zayhsj();
        return new ApiResult().success(200,"返回数据",zayhsj);
    }

    @Override
    public ApiResult zayhFxsl() {
        List<HashMap> zayhFxsl = zfMapper.zayhFxsl();
        return new ApiResult().success(200,"返回数据",zayhFxsl);
    }

    @Override
    public ApiResult zayhWzgsl() {
        List<HashMap> zayhWzgsl = zfMapper.zayhWzgsl();
        return new ApiResult().success(200,"返回数据",zayhWzgsl);
    }

    @Override
    public ApiResult zayhZgsl() {
        List<HashMap> zayhZgsl = zfMapper.zayhZgsl();
        return new ApiResult().success(200,"返回数据",zayhZgsl);
    }

    @Override
    public ApiResult zdrysl() {
        List<HashMap> zdrysl = zfMapper.zdrysl();
        return new ApiResult().success(200,"返回数据",zdrysl);
    }

    @Override
    public ApiResult czfzdry() {
        List<HashMap> czfzdry = zfMapper.czfzdry();
        return new ApiResult().success(200,"返回数据",czfzdry);
    }
}
