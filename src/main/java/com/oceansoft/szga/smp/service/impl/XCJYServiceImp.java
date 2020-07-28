package com.oceansoft.szga.smp.service.impl;

import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.mapper.XCJYMapper;
import com.oceansoft.szga.smp.service.XCJYService;
import com.oceansoft.szga.smp.util.ParamUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author ：pc
 * @date ：Created in 2020/4/21 11:36
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class XCJYServiceImp implements XCJYService {

    @Resource
    private XCJYMapper xcjyMapper;

    /**
     * 统计 基础信息
     * @author pc
     * @return 数据
     */
    @Override
    public ApiResult totalNum(String param,String start,String end) {
        HashMap hashMap = ParamUtils.xcjyparsingParam(param, start, end);
        if(hashMap == null){
            return new ApiResult().failure("数据错误！！！！");
        }
        //获取 采集单位总数
        Integer cjdwNum= xcjyMapper.totalNumCJDW(hashMap);
        //获取 宣传总数
        Integer xczsNum= xcjyMapper.totalNumXCZS(hashMap);

        HashMap<String, Object> data = new HashMap<>();
        data.put("cjdwNum",cjdwNum);
        data.put("xczsNum",xczsNum);

        return new ApiResult().success(200, "成功", data);
    }

    /**
     * 统计 基础底数
     * @author pc
     * @return 数据
     */
    @Override
    public ApiResult JCDSNum(String param, String start, String end) {

        HashMap hashMap = ParamUtils.xcjyparsingParam(param, start, end);
        if(hashMap == null){
            return new ApiResult().failure("数据错误！！！！");
        }

        List<HashMap> data=xcjyMapper.JCDUNum(hashMap);
        return new ApiResult().success(200, "成功", data);

    }

    /**
     * 单位宣传进度
     * @author pc
     * @return 数据
     */
    @Override
    public ApiResult Unitpublicity(String param,String start,String end) {
        HashMap hashMap = ParamUtils.xcjyparsingParam(param, start, end);
        if(hashMap == null){
            return new ApiResult().failure("数据错误！！！！");
        }
        List<HashMap> data= xcjyMapper.Unitpublicity(hashMap);
        List<String> orderList = Arrays.asList("张家港","常熟","昆山","太仓","吴江","园区","姑苏","高新区","吴中","相城","度假区","交警支队");
        List<HashMap> resultList = new ArrayList<>();
        for (String depeName : orderList) {
            for (HashMap datum : data) {
                if (datum.get("ddmc").toString().contains(depeName)) {
                    HashMap resultMap = new HashMap<>();
                    resultMap.put("ddmc", depeName);
                    resultMap.put("rate", datum.get("rate"));
                    resultList.add(resultMap);
                } else {
                    continue;
                }
            }
        }
        return new ApiResult().success(200, "成功", resultList);

    }
    /**
     * 八进宣传任务
     * @author pc
     * @return 数据
     */
    @Override
    public ApiResult PublicityTasks(String param,String start,String end,String dd) {
        HashMap hashMap = ParamUtils.xcjyparsingParam(param, start, end,dd);
        if(hashMap == null){
            return new ApiResult().failure("数据错误！！！！");
        }

        List<HashMap> data = xcjyMapper.PublicityTasks(hashMap);

        return new ApiResult().success(200, "成功", data);
    }

    /**
     *  民警宣传
     * @param param
     * @param start
     * @param end
     * @return
     */
    @Override
    public ApiResult PromotionalRate(String param,String start,String end,String dd) {

        HashMap hashMap = ParamUtils.xcjyparsingParam(param, start, end,dd);
        if(hashMap == null){
            return new ApiResult().failure("数据错误！！！！");
        }
        List<HashMap> data = xcjyMapper.PromotionalRate(hashMap);

        return new ApiResult().success(200, "成功", data);
    }
    /**
     * 获取大队名称列表
     * @return  大队名称集合
     */
    @Override
    public ApiResult DDMC() {
        List<HashMap> data = xcjyMapper.DDMC();
        return new ApiResult().success(200, "成功", data);
    }
}
