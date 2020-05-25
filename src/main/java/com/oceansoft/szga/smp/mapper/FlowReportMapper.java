package com.oceansoft.szga.smp.mapper;

import com.oceansoft.szga.smp.config.domain.ApiQueryBase;
import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.entity.FlowExecute;
import com.oceansoft.szga.smp.entity.FlowReport;
import com.oceansoft.szga.smp.szsh.core.entity.system.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.crypto.hash.Hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangxh
 * @create 2020/4/21
 * @email zhangxh@oceansoft.com.cn
 */
@Mapper
public interface FlowReportMapper
{
    /**
     * 添加任务流转
     * @param report
     * @return
     */
    int add(FlowReport report);

    /**
     * 获取分页数据
     * @param query
     * @return
     */
    List<Map<String, Object>> page(ApiQueryBase query);

    List<HashMap> findAll();

    /**
     * 获取任务节点
     * @param flowType
     * @param id
     * @return
     */
    List<Map<String, Object>> findNodes(@Param("flowType") String flowType,@Param("id") String id);

    int addTask(Map<String, Object> map);

    /**
     * 根据当前任务id获取下个任务节点
     * @param guid
     * @return
     */
    List<Map<String, Object>> findNextNodes(String guid);

    /**
     * 完成任务，签收或者分发
     * @param execute
     * @return
     */
    int completeTask(FlowExecute execute);

    int updateInfo(FlowReport flowReport);

    Map<String, Object> get(String guid);

    Integer getNum(String guid);

    Integer updateIsDelete(String guid);

    List<Map<String, Object>> getTasks(String guid);

    Map<String, Object> getTask(String guid);

    SysUser userAll(String id);
}
