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
    public ApiResult CzfPersonNum() {
        List<CzfPersonNum> czfPersonNums = zfMapper.CzfPersonNum();
        return new ApiResult().success(200,"返回数据",czfPersonNums);
    }

    @Override
    public ApiResult CzfNum() {
        List<CzfNum> czfNums = zfMapper.CzfNum();
        return new ApiResult().success(200,"返回数据",czfNums);

    }

    @Override
    public ApiResult CzfImpPerson() {
        List<HashMap> czfNums = zfMapper.CzfImpPerson();
        return new ApiResult().success(200,"返回数据",czfNums);
    }

    @Override
    public ApiResult QzfPersonNum() {
        List<HashMap> qzfPersonNums = zfMapper.QzfPersonNum();
        return new ApiResult().success(200,"返回数据",qzfPersonNums);
    }

    @Override
    public ApiResult QzfNum() {
        List<HashMap> qzfNum = zfMapper.QzfNum();
        return new ApiResult().success(200,"返回数据",qzfNum);
    }

    @Override
    public ApiResult QzfDangerous() {
        List<HashMap> qzfDanger = zfMapper.QzfDangerous();
        return new ApiResult().success(200,"返回数据",qzfDanger);
    }

    @Override
    public ApiResult QzwImpPerson() {
        List<HashMap> qzwImpPerson = zfMapper.QzwImpPerson();
        return new ApiResult().success(200,"返回数据",qzwImpPerson);
    }
    @Override
    public ApiResult QzfImpPerson() {
        List<HashMap> qzfImpPerson = zfMapper.QzfImpPerson();
        return new ApiResult().success(200,"返回数据",qzfImpPerson);
    }

    @Override
    public ApiResult QangerCzf() {
        List<HashMap> dangerCzf = zfMapper.DangeroursCzf();
        return new ApiResult().success(200,"返回数据",dangerCzf);
    }

    @Override
    public ApiResult DangerCzfImpPerson() {
        List<HashMap> dangerCzfImpPerson = zfMapper.DangerCzfImpPerson();
        return new ApiResult().success(200,"返回数据",dangerCzfImpPerson);
    }

    @Override
    public ApiResult DangerQzfNum() {
        List<HashMap> dangerQzfNum = zfMapper.DangerQzfNum();
        return new ApiResult().success(200,"返回数据",dangerQzfNum);
    }

    @Override
    public ApiResult DangerTypeFx() {
        List<HashMap> dangerTypeFx = zfMapper.DangerTypeFx();
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
    public ApiResult notDangerTypeSB() {
        List<HashMap> notDangerTypeSB = zfMapper.notDangerTypeSB();
        return new ApiResult().success(200,"返回数据",notDangerTypeSB);
    }

    @Override
    public ApiResult notDangerTypeSJ() {
        List<HashMap> notDangerTypeSJ = zfMapper.notDangerTypeSJ();
        return new ApiResult().success(200,"返回数据",notDangerTypeSJ);
    }

    @Override
    public ApiResult CzfImpXzqh() {
        List<HashMap> czfImpXzqh = zfMapper.CzfImpXzqh();
        return new ApiResult().success(200,"返回数据",czfImpXzqh);
    }

    @Override
    public ApiResult Fzayhff() {
        List<HashMap> fzayhff = zfMapper.Fzayhff();
        return new ApiResult().success(200,"返回数据",fzayhff);
    }

    @Override
    public ApiResult Fzayhrl() {
        List<HashMap> fzayhrl = zfMapper.Fzayhrl();
        return new ApiResult().success(200,"返回数据",fzayhrl);
    }

}
