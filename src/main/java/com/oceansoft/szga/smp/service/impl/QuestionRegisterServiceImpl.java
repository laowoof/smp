package com.oceansoft.szga.smp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.oceansoft.szga.smp.entity.QuestionExecuteTaskEntity;
import com.oceansoft.szga.smp.entity.QuestionRecordEntity;
import com.oceansoft.szga.smp.entity.bean.QuestionExecuteTaskBean;
import com.oceansoft.szga.smp.entity.bean.QuestionQueryBean;
import com.oceansoft.szga.smp.mapper.QuestionHandlerMapper;
import com.oceansoft.szga.smp.mapper.QuestionRegisterMapper;
import com.oceansoft.szga.smp.service.QuestionRegisterService;
import com.oceansoft.szga.smp.szsh.core.vo.system.SysUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * 问题登记实现层
 *
 * @author JackChan
 * @Date 2020/7/2 0002 下午 5:17
 */
@Service
public class QuestionRegisterServiceImpl implements QuestionRegisterService {

    @Autowired
    private QuestionRegisterMapper questionRegisterMapper;

    @Autowired
    private QuestionHandlerMapper questionHandlerMapper;

    /**
     *
     * @param questionRecordEntity
     * @param questionExecuteTaskBean
     * @param type 1保存/2保存并派发
     * @return
     */
    @Override
    public boolean addQuestionRecord(QuestionRecordEntity questionRecordEntity, QuestionExecuteTaskBean questionExecuteTaskBean, Integer type, SysUserVO userData) {
        if (questionRecordEntity == null) {
            throw new RuntimeException("实体不能为空");
        }
        QuestionExecuteTaskEntity questionExecuteTaskEntity = new QuestionExecuteTaskEntity();
        switch (type) {
            // 保存 登记表：状态0 待处理部门编码null   问题操作任务表：设置下问题id,创建日期、创建人id、操作日期、操作名称、是否已处理0
            // 操作日期、操作人id、操作人姓名、意见、完成时限、操作部门名称、操作部门编码、附件ids、节点名称为null
            case 1:
                if (!StringUtils.isEmpty(questionRecordEntity.getGuid())) {
                    updateQuestionRecord(questionRecordEntity, userData);
                } else {
                    questionRecordEntity.setGuid(UUID.randomUUID().toString());
                    questionRecordEntity.setState(0);
                    try {
                        questionRegisterMapper.addRecord(questionRecordEntity);
                    } catch (Exception e) {
                        throw new RuntimeException("问题记录新增失败");
                    }
                    // 任务表也新增一条记录 设置下任务表的值并新增
                    questionExecuteTaskEntity.setGuid(UUID.randomUUID().toString());
                    questionExecuteTaskEntity.setQuestionGuid(questionRecordEntity.getGuid());
                    questionExecuteTaskEntity.setCreateDate(new Date());
                    questionExecuteTaskEntity.setCreateUserId(userData.getId());
                    questionExecuteTaskEntity.setState(0);
                    try {
                        questionRegisterMapper.addTask(questionExecuteTaskEntity);
                    } catch (Exception e) {
                        throw new RuntimeException("问题任务新增失败");
                    }
                }
                break;
                // 保存并派发 记录表 任务表 全部前端给 后端设一下主键   执行部门/操作部门 为指向部门id
                // 注：记录表状态为1    任务表状态为1
            case 2:
                // 修改操作的保存并派发
                if (!StringUtils.isEmpty(questionRecordEntity.getGuid())) {
                    boolean updateResult = updateQuestionRecord(questionRecordEntity, userData);
                    if (updateResult) {
                        // 修改下状态并把派发的部门也更新下
                        questionRecordEntity.setState(1);
                        questionRecordEntity.setExecuteDeptCode(questionExecuteTaskBean.getExecuteDeptCode());
                        int total = questionRegisterMapper.updateRecordStateAndCode(questionRecordEntity);
                        if (total > 1) {
                            addExecuteTask(questionExecuteTaskEntity, questionExecuteTaskBean, questionRecordEntity, userData);
                        }
                    }
                } else {
                    // 新增并派发
                    if (questionExecuteTaskBean == null) {
                        throw new RuntimeException("派发内容不能为空");
                    }
                    questionRecordEntity.setGuid(UUID.randomUUID().toString());
                    questionRecordEntity.setState(1);
                    try {
                        questionRegisterMapper.addRecord(questionRecordEntity);
                    } catch (Exception e) {
                        throw new RuntimeException("问题记录新增失败");
                    }
                    // 组织task数据并送入表中
                    addExecuteTask(questionExecuteTaskEntity, questionExecuteTaskBean, questionRecordEntity, userData);
                }
                break;
            default:
                break;
        }
        return true;
    }

    /**
     *
     * @param guid
     * @param questionExecuteTaskBean
     * @return
     */
    @Override
    public boolean confirmDistribute(String guid, QuestionExecuteTaskBean questionExecuteTaskBean) {
        if (StringUtils.isEmpty(guid) || questionExecuteTaskBean == null) {
            throw new RuntimeException("guid和任务不能为空");
        }
        // 根据guid找到该条记录  更新记录的状态和待处理部门编码
        QuestionRecordEntity questionRecordEntity = questionRegisterMapper.getRecordByGuid(guid);
        if (questionRecordEntity == null) {
            throw new RuntimeException("未找到问题记录");
        }
        questionRecordEntity.setState(1);
        questionRecordEntity.setExecuteDeptCode(questionExecuteTaskBean.getExecuteDeptCode());
        try {
            questionRegisterMapper.updateRecordStateAndCode(questionRecordEntity);
        } catch (Exception e) {
            throw new RuntimeException("更新失败");
        }
        // 更新任务表 注：状态为1
        QuestionExecuteTaskEntity executeTaskEntity = questionRegisterMapper.getExecuteTaskEntity(guid);
        executeTaskEntity = setTaskValue(executeTaskEntity, questionExecuteTaskBean);
        executeTaskEntity.setState(1);
        try {
            questionRegisterMapper.updateExecuteTask(executeTaskEntity);
        } catch (Exception e) {
            throw new RuntimeException("更新失败");
        }
        return true;
    }

    @Override
    public boolean removeRecord(String guid) {
        if (StringUtils.isEmpty(guid)) {
            throw new RuntimeException("id不能为空");
        }
        return questionRegisterMapper.deleteRecord(guid) > 0;
    }

    @Override
    public QuestionRecordEntity queryQuestionRecordById(String guid) {
        if (StringUtils.isEmpty(guid)) {
            throw new RuntimeException("guid不能为空");
        }
        QuestionRecordEntity questionRecordEntity = questionRegisterMapper.getRecordByGuid(guid);
        return questionRecordEntity;
    }

    @Override
    public List<QuestionExecuteTaskEntity> queryHistoryTask(String guid) {
        if (StringUtils.isEmpty(guid)) {
            throw new RuntimeException("guid不能为空");
        }
        List<QuestionExecuteTaskEntity> historyTask = questionRegisterMapper.getHistoryTask(guid);
        return historyTask;
    }

    @Override
    public boolean questionConfirm(String guid, String operation, QuestionExecuteTaskBean questionExecuteTaskBean, SysUserVO userData) {
        if (StringUtils.isEmpty(guid) || StringUtils.isEmpty(operation) || questionExecuteTaskBean == null) {
            throw new RuntimeException("问题确认所需条件不足，无法确认");
        }
        QuestionRecordEntity questionRecordEntity = questionRegisterMapper.getRecordByGuid(guid);
        if (questionRecordEntity == null) {
            throw new RuntimeException("未找到问题记录");
        }
        QuestionExecuteTaskEntity questionExecuteTaskEntity = new QuestionExecuteTaskEntity();
        if (operation.equals("已解决")) {
            try {
                // 根据guid修改记录的状态为5同时往任务表里插一条记录
                questionRegisterMapper.updateRecordStateByGuid(guid, 5);
            } catch (Exception e) {
                throw new RuntimeException("问题确认失败");
            }
        } else {
            // 修改记录状态为2处置中,修改待处理部门编码并往任务表插入一条记录
            try {
                questionRecordEntity.setState(2);
                questionRecordEntity.setExecuteDeptCode(questionExecuteTaskBean.getExecuteDeptCode());
                questionRegisterMapper.updateRecordStateAndCode(questionRecordEntity);
                // 修改这条所有反馈信息状态为1
                List<String> tableNameList = new ArrayList<>();
                tableNameList.add("question_plan");
                tableNameList.add("question_look_back");
                tableNameList.add("question_implemention");
                tableNameList.add("question_response");
                for (String tableName : tableNameList) {
                    questionHandlerMapper.updateFeedBackState(tableName, guid);
                }
            } catch (Exception e) {
                throw new RuntimeException("问题确认失败");
            }
        }
        addExecuteTask(questionExecuteTaskEntity, questionExecuteTaskBean, questionRecordEntity, userData);
        return true;
    }

    @Override
    public Map<String, Object> queryPageRecord(QuestionQueryBean questionQueryBean, SysUserVO userData) {
        Map<String, Object> map = new HashMap<>();
        int pageNum = questionQueryBean.getPageNum() == null ? 1 : questionQueryBean.getPageNum();
        int pageSize = questionQueryBean.getPageSize() == null ? 10 : questionQueryBean.getPageSize();
        String departmentId = userData.getDepartmentId();
        List<Integer> integerList = null;
        if (questionQueryBean.getState() != null && questionQueryBean.getState().length != 0) {
             integerList = Arrays.asList(questionQueryBean.getState());
        }
        Page<Object> objects = PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> mapList = questionRegisterMapper.queryPageRecord(questionQueryBean, departmentId.trim(), integerList);
        map.put("mapList", mapList);
        map.put("pages", objects.getPages());
        map.put("total", objects.getTotal());
        map.put("pageNum", objects.getPageNum());
        map.put("pageSize", objects.getPageSize());
        return map;
    }

    public boolean updateQuestionRecord(QuestionRecordEntity questionRecordEntity, SysUserVO userData) {
        if (questionRecordEntity == null) {
            throw new RuntimeException("更新记录不能为空");
        }
        boolean isSuccess = (questionRecordEntity.getState() == 0 || questionRecordEntity.getState() == 4) && questionRecordEntity.getCreateDeptCode().equals(userData.getDepartmentId());
        if (isSuccess) {
            return questionRegisterMapper.updateRecord(questionRecordEntity) > 0;
        } else {
            throw new RuntimeException("您无法修改此条记录");
        }
    }

    /**
     * 任务bean往实体赋值
     * @param questionExecuteTaskEntity
     * @param questionExecuteTaskBean
     * @return
     */
    private QuestionExecuteTaskEntity setTaskValue (QuestionExecuteTaskEntity questionExecuteTaskEntity, QuestionExecuteTaskBean questionExecuteTaskBean) {
        questionExecuteTaskEntity.setExecuteDate(questionExecuteTaskBean.getExecuteDate());
        questionExecuteTaskEntity.setExecuteDeptCode(questionExecuteTaskBean.getExecuteDeptCode());
        questionExecuteTaskEntity.setExecuteDeptName(questionExecuteTaskBean.getExecuteDeptName());
        questionExecuteTaskEntity.setExecuteName(questionExecuteTaskBean.getExecuteName());
        questionExecuteTaskEntity.setExecuteNodeName(questionExecuteTaskBean.getExecuteNodeName());
        questionExecuteTaskEntity.setExecuteUserId(questionExecuteTaskBean.getExecuteUserId());
        questionExecuteTaskEntity.setExecuteUserName(questionExecuteTaskBean.getExecuteUserName());
        questionExecuteTaskEntity.setFileIds(questionExecuteTaskBean.getFileIds());
        questionExecuteTaskEntity.setFinishDate(questionExecuteTaskBean.getFinishDate());
        questionExecuteTaskEntity.setOpinion(questionExecuteTaskBean.getOpinion());
        return  questionExecuteTaskEntity;
    }

    /**
     * 将记录表的id作为任务表的questionId 并新增插入一条记录
     * @param questionExecuteTaskEntity
     * @param questionExecuteTaskBean
     */
    public void addExecuteTask (QuestionExecuteTaskEntity questionExecuteTaskEntity, QuestionExecuteTaskBean questionExecuteTaskBean, QuestionRecordEntity questionRecordEntity, SysUserVO userData) {
        questionExecuteTaskEntity = setTaskValue(questionExecuteTaskEntity, questionExecuteTaskBean);
        questionExecuteTaskEntity.setGuid(UUID.randomUUID().toString());
        questionExecuteTaskEntity.setQuestionGuid(questionRecordEntity.getGuid());
        questionExecuteTaskEntity.setCreateDate(new Date());
        questionExecuteTaskEntity.setCreateUserId(userData.getId());
        questionExecuteTaskEntity.setState(1);
        try {
            questionRegisterMapper.addTask(questionExecuteTaskEntity);
        } catch (Exception e) {
            throw new RuntimeException("问题任务新增失败");
        }
    }
}
