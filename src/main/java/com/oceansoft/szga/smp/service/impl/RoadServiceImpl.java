package com.oceansoft.szga.smp.service.impl;

import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.mapper.RoadMapper;
import com.oceansoft.szga.smp.mapper.TjMapper;
import com.oceansoft.szga.smp.service.RoadService;
import com.oceansoft.szga.smp.service.TjService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 *  道路交通
 * @author wzj
 * @date 2019/4/20
 */

@Service
public class RoadServiceImpl implements RoadService {

    @Resource
    private RoadMapper roadMapper;

    @Override
    public ApiResult test() {
        List<HashMap> data = roadMapper.test();
        return new ApiResult().success(200, "成功", data);
    }
}
