package com.oceansoft.szga.smp.service.impl;

import com.github.pagehelper.PageHelper;
import com.oceansoft.szga.smp.entity.*;
import com.oceansoft.szga.smp.entity.bean.QuestionExecuteTaskBean;
import com.oceansoft.szga.smp.entity.bean.QuestionQueryBean;
import com.oceansoft.szga.smp.mapper.QuestionHandlerMapper;
import com.oceansoft.szga.smp.mapper.QuestionRegisterMapper;
import com.oceansoft.szga.smp.service.QuestionHandlerService;
import com.oceansoft.szga.smp.szsh.core.vo.system.SysUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * 问题处置实现层
 *
 * @author JackChan
 * @Date 2020/7/2 0002 上午 11:52
 */
@Service
public class QuestionHandlerServiceImpl implements QuestionHandlerService {

    @Autowired
    private QuestionHandlerMapper questionHandlerMapper;

    @Autowired
    private QuestionRegisterMapper questionRegisterMapper;

    @Autowired
    private QuestionRegisterServiceImpl questionRegisterService;

    /**
     * 问题增改方案新增
     * @param questionPlanEntity
     * @return
     */
    @Override
    public boolean addQuestionPlan(QuestionPlanEntity questionPlanEntity) {
        if (questionPlanEntity == null) {
            throw new RuntimeException("新增实体不能为空");
        }
        questionPlanEntity.setGuid(UUID.randomUUID().toString());
        return questionHandlerMapper.addQuestionPlan(questionPlanEntity) > 0;
    }

    /**
     * 问题增改方案修改
     * @param questionPlanEntity
     * @return
     */
    @Override
    public boolean updateQuestionPlan(QuestionPlanEntity questionPlanEntity) {
        if (questionPlanEntity != null) {
            return questionHandlerMapper.updateQuestionPlan(questionPlanEntity)>0;
        } else {
            throw new RuntimeException("修改失败");
        }
    }

    /**
     * 查询问题增改方案
     * @param questionGuid
     * @return
     */
    @Override
    public QuestionPlanEntity queryQuestionPlan(String questionGuid) {
        if (StringUtils.isEmpty(questionGuid)) {
            throw new RuntimeException("问题id不能为空");
        }
        QuestionPlanEntity questionPlanEntity = questionHandlerMapper.queryQuestionPlan(questionGuid);
        if (questionPlanEntity == null) {
            return null;
        }
        return questionPlanEntity;
    }

    /**
     * 新增问题复函
     * @param questionResponseEntity
     * @return
     */
    @Override
    public boolean addQuestionResponse(QuestionResponseEntity questionResponseEntity) {
        if (questionResponseEntity == null) {
            throw new RuntimeException("新增实体不能为空");
        }
        questionResponseEntity.setGuid(UUID.randomUUID().toString());
        return questionHandlerMapper.addQuestionResponse(questionResponseEntity) > 0;
    }

    /**
     * 修改问题复函
     * @param questionResponseEntity
     * @return
     */
    @Override
    public boolean updateQuestionResponse(QuestionResponseEntity questionResponseEntity) {
        if (questionResponseEntity != null) {
            return questionHandlerMapper.updateQuestionResponse(questionResponseEntity)>0;
        } else {
            throw new RuntimeException("修改失败");
        }
    }

    /**
     * 查询问题复函
     * @param questionGuid
     * @return
     */
    @Override
    public QuestionResponseEntity queryQuestionResponse(String questionGuid) {
        if (StringUtils.isEmpty(questionGuid)) {
            throw new RuntimeException("问题id不能为空");
        }
        QuestionResponseEntity questionResponseEntity = questionHandlerMapper.queryQuestionResponse(questionGuid);
        if (questionResponseEntity == null) {
            return null;
        }
        return questionResponseEntity;
    }

    @Override
    public boolean addQuestionImplemention(QuestionImplementionEntity questionImplementionEntity) {
        if (questionImplementionEntity == null) {
            throw new RuntimeException("新增实体不能为空");
        }
        questionImplementionEntity.setGuid(UUID.randomUUID().toString());
        return questionHandlerMapper.addQuestionImplemention(questionImplementionEntity) > 0;
    }

    @Override
    public QuestionImplementionEntity queryQuestionImplemention(String questionGuid) {
        if (StringUtils.isEmpty(questionGuid)) {
            throw new RuntimeException("问题id不能为空");
        }
        QuestionImplementionEntity questionImplementionEntity = questionHandlerMapper.queryQuestionImplemention(questionGuid);
        if (questionImplementionEntity == null) {
            return null;
        }
        return questionImplementionEntity;
    }

    @Override
    public QuestionLookBackEntity queryQuestionLookBack(String questionGuid) {
        if (StringUtils.isEmpty(questionGuid)) {
            throw new RuntimeException("问题id不能为空");
        }
        QuestionLookBackEntity questionLookBackEntity = questionHandlerMapper.queryQuestionLookBack(questionGuid);
        if (questionLookBackEntity == null) {
            return null;
        }
        return questionLookBackEntity;
    }

    @Override
    public boolean updateQuestionImplemention(QuestionImplementionEntity questionImplementionEntity) {
        if (questionImplementionEntity != null) {
            return questionHandlerMapper.updateQuestionImplemention(questionImplementionEntity)>0;
        } else {
            throw new RuntimeException("修改失败");
        }
    }

    @Override
    public boolean addQuestionLookBack(QuestionLookBackEntity questionLookBackEntity) {
        if (questionLookBackEntity == null) {
            throw new RuntimeException("新增实体不能为空");
        }
        questionLookBackEntity.setGuid(UUID.randomUUID().toString());
        return questionHandlerMapper.addQuestionLookBack(questionLookBackEntity) > 0;
    }

    @Override
    public boolean updateQuestionLookBack(QuestionLookBackEntity questionLookBackEntity) {
        if (questionLookBackEntity != null) {
            return questionHandlerMapper.updateQuestionLookBack(questionLookBackEntity) > 0;
        } else {
            throw new RuntimeException("修改失败");
        }
    }

    @Override
    public boolean signForQuestion(String id, SysUserVO userData) {
        if (StringUtils.isEmpty(id)) {
            throw new RuntimeException("guid不能为空");
        }
        List<String> guidList = this.stringToList(id);
        for (String guid : guidList) {
            try {
                // 根据guid获取当前记录，更新状态和待处理部门编码
                QuestionRecordEntity questionRecordEntity = questionRegisterMapper.getRecordByGuid(guid);
                questionRecordEntity.setState(2);
                questionRecordEntity.setExecuteDeptCode(userData.getDepartmentId());
                questionRegisterMapper.updateRecordStateAndCode(questionRecordEntity);
                // 同时往问题任务表插入一条相应记录
                QuestionExecuteTaskEntity questionExecuteTaskEntity = new QuestionExecuteTaskEntity();
                questionExecuteTaskEntity.setGuid(UUID.randomUUID().toString());
                questionExecuteTaskEntity.setQuestionGuid(guid);
                questionExecuteTaskEntity.setCreateDate(new Date());
                questionExecuteTaskEntity.setCreateUserId(userData.getId());
                questionExecuteTaskEntity.setExecuteDate(new Date());
                questionExecuteTaskEntity.setExecuteUserId(userData.getId());
                questionExecuteTaskEntity.setExecuteUserName(userData.getUsername());
                questionExecuteTaskEntity.setExecuteDeptName(userData.getDepartmentName());
                questionExecuteTaskEntity.setExecuteDeptCode(userData.getDepartmentId());
                questionExecuteTaskEntity.setExecuteName("签收");
                questionExecuteTaskEntity.setState(1);
                questionExecuteTaskEntity.setExecuteNodeName("接收部门签收");
                questionRegisterMapper.addTask(questionExecuteTaskEntity);
            } catch (Exception e) {
                throw new RuntimeException("签收失败");
            }
        }
        return true;
    }

    @Override
    public boolean questionReturn(String guid, SysUserVO userData) {
        if (StringUtils.isEmpty(guid)) {
            throw new RuntimeException("guid不能为空");
        }
        try {
            // 根据guid获取当前记录，更新状态和待处理部门编码
            QuestionRecordEntity questionRecordEntity = questionRegisterMapper.getRecordByGuid(guid);
            questionRecordEntity.setState(4);
            questionRecordEntity.setExecuteDeptCode(questionRecordEntity.getCreateDeptCode());
            questionRegisterMapper.updateRecordStateAndCode(questionRecordEntity);
            // 同时往问题任务表插入一条相应记录
            QuestionExecuteTaskEntity questionExecuteTaskEntity = new QuestionExecuteTaskEntity();
            questionExecuteTaskEntity.setGuid(UUID.randomUUID().toString());
            questionExecuteTaskEntity.setQuestionGuid(guid);
            questionExecuteTaskEntity.setCreateDate(new Date());
            questionExecuteTaskEntity.setCreateUserId(userData.getId());
            questionExecuteTaskEntity.setExecuteDate(new Date());
            questionExecuteTaskEntity.setExecuteUserId(userData.getId());
            questionExecuteTaskEntity.setExecuteUserName(userData.getUsername());
            questionExecuteTaskEntity.setExecuteDeptName(questionRecordEntity.getCreateDeptName());
            questionExecuteTaskEntity.setExecuteDeptCode(questionRecordEntity.getCreateDeptCode());
            questionExecuteTaskEntity.setExecuteName("退回");
            questionExecuteTaskEntity.setState(1);
            questionExecuteTaskEntity.setExecuteNodeName("问题退回");
            questionRegisterMapper.addTask(questionExecuteTaskEntity);
        } catch (Exception e) {
            throw new RuntimeException("操作失败");
        }
        return true;
    }

    @Override
    public boolean questionManage(String guid, String operation, QuestionExecuteTaskBean questionExecuteTaskBean, SysUserVO userData) {
        if (StringUtils.isEmpty(guid)) {
            throw new RuntimeException("问题id不能为空");
        }
        if (StringUtils.isEmpty(operation)) {
            throw new RuntimeException("操作名不能为空");
        }
        QuestionRecordEntity questionRecordEntity = questionRegisterMapper.getRecordByGuid(guid);
        if (questionRecordEntity == null) {
            throw new RuntimeException("获取问题记录失败");
        }
        if (operation.equals("反馈结果")) {
            try {
                // 根据guid获取当前记录，更新状态和待处理部门编码
                questionRecordEntity.setState(3);
                questionRecordEntity.setExecuteDeptCode(questionRecordEntity.getCreateDeptCode());
                questionRegisterMapper.updateRecordStateAndCode(questionRecordEntity);
                // 同时往问题任务表插入一条相应记录
                QuestionExecuteTaskEntity questionExecuteTaskEntity = new QuestionExecuteTaskEntity();
                questionExecuteTaskEntity.setGuid(UUID.randomUUID().toString());
                questionExecuteTaskEntity.setQuestionGuid(guid);
                questionExecuteTaskEntity.setCreateDate(new Date());
                questionExecuteTaskEntity.setCreateUserId(userData.getId());
                questionExecuteTaskEntity.setExecuteDate(new Date());
                questionExecuteTaskEntity.setExecuteUserId(userData.getId());
                questionExecuteTaskEntity.setExecuteUserName(userData.getUsername());
                questionExecuteTaskEntity.setExecuteDeptName(questionRecordEntity.getCreateDeptName());
                questionExecuteTaskEntity.setExecuteDeptCode(questionRecordEntity.getCreateDeptCode());
                questionExecuteTaskEntity.setExecuteName("处置");
                questionExecuteTaskEntity.setState(1);
                questionExecuteTaskEntity.setExecuteNodeName("问题处置");
                questionRegisterMapper.addTask(questionExecuteTaskEntity);
            } catch (Exception e) {
                throw new RuntimeException("处置失败");
            }
        } else {
                if (questionExecuteTaskBean == null) {
                    throw new RuntimeException("派发内容不能为空");
                }
            try {
                // 更新当前记录的状态和待处理部门编码
                questionRecordEntity.setState(1);
                questionRecordEntity.setExecuteDeptCode(questionExecuteTaskBean.getExecuteDeptCode());
                questionRegisterMapper.updateRecordStateAndCode(questionRecordEntity);
                // 同时任务表也新增一条派发任务
                QuestionExecuteTaskEntity questionExecuteTaskEntity = new QuestionExecuteTaskEntity();
                questionRegisterService.addExecuteTask(questionExecuteTaskEntity, questionExecuteTaskBean, questionRecordEntity, userData);
            } catch (Exception e) {
                throw new RuntimeException("下派失败");
            }
        }
        return true;
    }

    @Override
    public List<Map<String, Object>> queryPageHandler(QuestionQueryBean questionQueryBean, SysUserVO userData) {
        int pageNum = questionQueryBean.getPageNum() == null ? 1 : questionQueryBean.getPageNum();
        int pageSize = questionQueryBean.getPageSize() == null ? 10 : questionQueryBean.getPageSize();
        String departmentId = userData.getDepartmentId();
        List<Integer> integerList = null;
        if (questionQueryBean.getState() != null && questionQueryBean.getState().length != 0) {
            integerList = Arrays.asList(questionQueryBean.getState());
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> mapList = questionHandlerMapper.queryPageHandler(questionQueryBean, departmentId.trim(), integerList);
        return mapList;
    }

    /**
     * string转list
     * @param strs
     * @return
     */
    public List<String> stringToList(String strs){
        String str[] = strs.split(",");
        return Arrays.asList(str);
    }
}
