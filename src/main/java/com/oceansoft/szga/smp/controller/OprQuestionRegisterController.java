package com.oceansoft.szga.smp.controller;

import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.entity.QuestionExecuteTaskEntity;
import com.oceansoft.szga.smp.entity.QuestionRecordEntity;
import com.oceansoft.szga.smp.entity.bean.QuestionExecuteTaskBean;
import com.oceansoft.szga.smp.entity.bean.QuestionQueryBean;
import com.oceansoft.szga.smp.service.QuestionRegisterService;
import com.oceansoft.szga.smp.szsh.core.service.system.impl.SysUserServiceImpl;
import com.oceansoft.szga.smp.szsh.core.vo.system.SysUserVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 问题登记控制层
 *
 * @author JackChan
 * @Date 2020/7/1 0001 下午 3:44
 */
@RestController
@RequestMapping("question/register")
public class OprQuestionRegisterController {

    @Autowired
    private QuestionRegisterService questionRegisterService;

    @Autowired
    private SysUserServiceImpl sysUserService;

    /**
     * 问题登记分页查询
     * @param questionQueryBean
     * @return
     */
    @ApiOperation(value = "问题登记分页查询", notes = "", httpMethod = "POST")
    @PostMapping("query-page-record")
    public ApiResult queryPageRecord(QuestionQueryBean questionQueryBean) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            SysUserVO userData = sysUserService.getCurrentUser();
            List<Map<String, Object>> mapList = questionRegisterService.queryPageRecord(questionQueryBean, userData);
            message = "查询成功";
            isSuccess = true;
            apiResult.setData(mapList);
        } catch (Exception e) {
            message = e.getMessage();
            e.printStackTrace();
        }
        apiResult.setCode(200);
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    /**
     * 新增保存问题登记/登记并派发
     * @param questionRecordEntity 问题登记实体
     * @param questionExecuteTaskBean 问题派发bean
     * @param type 1保存/2保存并派发
     */
    @ApiOperation(value = "新增保存/修改问题登记", notes = "", httpMethod = "POST")
    @PostMapping("add-update-record")
    public ApiResult addQuestionRecord(@RequestBody QuestionRecordEntity questionRecordEntity, QuestionExecuteTaskBean questionExecuteTaskBean, Integer type) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            SysUserVO userData = sysUserService.getCurrentUser();
            isSuccess = questionRegisterService.addQuestionRecord(questionRecordEntity, questionExecuteTaskBean, type, userData);
            if (isSuccess) {
                message = "操作成功";
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setCode(200);
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    @ApiOperation(value = "派发提交操作", notes = "", httpMethod = "POST")
    @PostMapping("confirm-distribute")
    public ApiResult confirmDistribute(String guid, QuestionExecuteTaskBean questionExecuteTaskBean) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            isSuccess = questionRegisterService.confirmDistribute(guid, questionExecuteTaskBean);
            if (isSuccess) {
                message = "操作成功";
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setCode(200);
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    @ApiOperation(value = "删除记录操作", notes = "", httpMethod = "POST")
    @PostMapping("remove-record")
    public ApiResult removeRecord(String guid) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            isSuccess = questionRegisterService.removeRecord(guid);
            if (isSuccess) {
                message = "操作成功";
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setCode(200);
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    @ApiOperation(value = "根据guid获取一条记录", notes = "", httpMethod = "POST")
    @PostMapping("query-record")
    public ApiResult queryQuestionRecord(String guid) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            QuestionRecordEntity questionRecordEntity = questionRegisterService.queryQuestionRecordById(guid);
            message = "查询成功";
            apiResult.setData(questionRecordEntity);
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setCode(200);
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    @ApiOperation(value = "获取当前信息的历史任务", notes = "", httpMethod = "POST")
    @PostMapping("history-task")
    public ApiResult queryHistoryTask(String guid) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            List<QuestionExecuteTaskEntity> questionExecuteTaskEntities = questionRegisterService.queryHistoryTask(guid);
            message = "查询成功";
            apiResult.setData(questionExecuteTaskEntities);
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setCode(200);
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    @ApiOperation(value = "问题确认", notes = "", httpMethod = "POST")
    @PostMapping("question-confirm")
    public ApiResult questionConfirm(String guid, String operation, @RequestBody QuestionExecuteTaskBean questionExecuteTaskBean) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            SysUserVO userData = sysUserService.getCurrentUser();
            isSuccess = questionRegisterService.questionConfirm(guid, operation, questionExecuteTaskBean, userData);
            if (isSuccess) {
                message = "操作成功";
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setCode(200);
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

}
