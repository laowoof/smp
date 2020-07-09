package com.oceansoft.szga.smp.controller;

import com.oceansoft.szga.smp.config.domain.ApiResult;
import com.oceansoft.szga.smp.entity.QuestionImplementionEntity;
import com.oceansoft.szga.smp.entity.QuestionLookBackEntity;
import com.oceansoft.szga.smp.entity.QuestionPlanEntity;
import com.oceansoft.szga.smp.entity.QuestionResponseEntity;
import com.oceansoft.szga.smp.entity.bean.QuestionExecuteTaskBean;
import com.oceansoft.szga.smp.entity.bean.QuestionQueryBean;
import com.oceansoft.szga.smp.service.QuestionHandlerService;
import com.oceansoft.szga.smp.szsh.core.service.system.impl.SysUserServiceImpl;
import com.oceansoft.szga.smp.szsh.core.vo.system.SysUserVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 问题处置控制层
 *
 * @author JackChan
 * @Date 2020/7/1 0001 下午 3:44
 */
@RestController
@RequestMapping("question/handler")
public class OprQuestionHandlerController {

    @Autowired
    private QuestionHandlerService questionHandlerService;

    @Autowired
    private SysUserServiceImpl sysUserService;

    /**
     * 问题处置分页查询
     * @param questionQueryBean
     * @return
     */
    @ApiOperation(value = "问题处置分页查询", notes = "", httpMethod = "POST")
    @PostMapping("query-page-handler")
    public ApiResult queryPageHandler(@RequestBody QuestionQueryBean questionQueryBean) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            SysUserVO userData = sysUserService.getCurrentUser();
            Map<String, Object> map = questionHandlerService.queryPageHandler(questionQueryBean, userData);
            message = "查询成功";
            isSuccess = true;
            apiResult.setData(map);
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
     * 查询问题所有反馈结果
     */
    @ApiOperation(value = "查询问题所有方案", notes = "", httpMethod = "POST")
    @GetMapping("query-all")
    public ApiResult queryQuestionPlan(String questionGuid) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            Map<String, Object> map = new HashMap<>();
            QuestionPlanEntity questionPlanEntity = questionHandlerService.queryQuestionPlan(questionGuid);
            QuestionResponseEntity questionResponseEntity = questionHandlerService.queryQuestionResponse(questionGuid);
            QuestionImplementionEntity questionImplementionEntity = questionHandlerService.queryQuestionImplemention(questionGuid);
            QuestionLookBackEntity questionLookBackEntity = questionHandlerService.queryQuestionLookBack(questionGuid);
            map.put("questionPlanEntity", questionPlanEntity);
            map.put("questionResponseEntity", questionResponseEntity);
            map.put("questionImplementionEntity", questionImplementionEntity);
            map.put("questionLookBackEntity", questionLookBackEntity);
            isSuccess = true;
            apiResult.setData(map);
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setCode(200);
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    /**
     * 新增问题增改方案
     */
    @ApiOperation(value = "新增问题增改方案", notes = "", httpMethod = "POST")
    @PostMapping("add-plan")
    public ApiResult addQuestionPlan(@RequestBody QuestionPlanEntity questionPlanEntity) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            isSuccess = questionHandlerService.addQuestionPlan(questionPlanEntity);
            if (isSuccess) {
                message = "新增成功";
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setCode(200);
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    /**
     * 更新问题增改方案
     */
    @ApiOperation(value = "更新问题增改方案", notes = "", httpMethod = "POST")
    @PostMapping("update-plan")
    public ApiResult updateQuestionPlan(@RequestBody QuestionPlanEntity questionPlanEntity) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            isSuccess = questionHandlerService.updateQuestionPlan(questionPlanEntity);
            if (isSuccess) {
                message = "更新成功";
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setCode(200);
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    /**
     * 新增问题复函
     */
    @ApiOperation(value = "新增问题复函", notes = "", httpMethod = "POST")
    @PostMapping("add-response")
    public ApiResult addQuestionResponse(@RequestBody QuestionResponseEntity questionResponseEntity) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            isSuccess = questionHandlerService.addQuestionResponse(questionResponseEntity);
            if (isSuccess) {
                message = "新增成功";
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setCode(200);
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    /**
     * 修改问题复函
     */
    @ApiOperation(value = "修改问题复函", notes = "", httpMethod = "POST")
    @PostMapping("update-response")
    public ApiResult updateQuestionResponse(@RequestBody QuestionResponseEntity questionResponseEntity) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            isSuccess = questionHandlerService.updateQuestionResponse(questionResponseEntity);
            if (isSuccess) {
                message = "修改成功";
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setCode(200);
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    /**
     * 新增问题整改落实
     */
    @ApiOperation(value = "新增问题整改落实", notes = "", httpMethod = "POST")
    @PostMapping("add-implemention")
    public ApiResult addQuestionImplemention(@RequestBody QuestionImplementionEntity questionImplementionEntity) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            isSuccess = questionHandlerService.addQuestionImplemention(questionImplementionEntity);
            if (isSuccess) {
                message = "新增成功";
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setCode(200);
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    /**
     * 更新问题增改方案
     */
    @ApiOperation(value = "更新问题增改方案", notes = "", httpMethod = "POST")
    @PostMapping("update-implemention")
    public ApiResult updateQuestionImplemention(@RequestBody QuestionImplementionEntity questionImplementionEntity) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            isSuccess = questionHandlerService.updateQuestionImplemention(questionImplementionEntity);
            if (isSuccess) {
                message = "更新成功";
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setCode(200);
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    /**
     * 新增问题回头看
     */
    @ApiOperation(value = "新增问题回头看", notes = "", httpMethod = "POST")
    @PostMapping("add-lookback")
    public ApiResult addQuestionLookBack(@RequestBody QuestionLookBackEntity questionLookBackEntity) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            isSuccess = questionHandlerService.addQuestionLookBack(questionLookBackEntity);
            if (isSuccess) {
                message = "新增成功";
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setCode(200);
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    /**
     * 更新问题回头看
     */
    @ApiOperation(value = "更新问题回头看", notes = "", httpMethod = "POST")
    @PostMapping("update-lookback")
    public ApiResult updateQuestionLookBack(@RequestBody QuestionLookBackEntity questionLookBackEntity) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            isSuccess = questionHandlerService.updateQuestionLookBack(questionLookBackEntity);
            if (isSuccess) {
                message = "更新成功";
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setCode(200);
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    /**
     * 问题签收/批量签收
     */
    @ApiOperation(value = "问题签收", notes = "", httpMethod = "POST")
    @GetMapping("sign-for")
    public ApiResult signForQuestion(String guid) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            SysUserVO userData = sysUserService.getCurrentUser();
            isSuccess = questionHandlerService.signForQuestion(guid, userData);
            if (isSuccess) {
                message = "签收成功";
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setCode(200);
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    /**
     * 问题退回
     */
    @ApiOperation(value = "问题退回", notes = "", httpMethod = "POST")
    @GetMapping("question-return")
    public ApiResult questionReturn(String guid) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            SysUserVO userData = sysUserService.getCurrentUser();
            isSuccess = questionHandlerService.questionReturn(guid, userData);
            if (isSuccess) {
                message = "退回成功";
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        apiResult.setCode(200);
        apiResult.setMsg(message);
        apiResult.setSucc(isSuccess);
        return apiResult;
    }

    /**
     * 问题处置提交
     */
    @ApiOperation(value = "问题处置提交", notes = "", httpMethod = "POST")
    @PostMapping("question-manage")
    public ApiResult questionManage(String guid, String operation, @RequestBody QuestionExecuteTaskBean questionExecuteTaskBean) {
        ApiResult apiResult = new ApiResult();
        boolean isSuccess = false;
        String message = "";
        try {
            SysUserVO userData = sysUserService.getCurrentUser();
            isSuccess = questionHandlerService.questionManage(guid, operation, questionExecuteTaskBean, userData);
            if (isSuccess) {
                message = "处置成功";
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
