package com.oceansoft.szga.smp.service;

import com.oceansoft.szga.smp.entity.QuestionImplementionEntity;
import com.oceansoft.szga.smp.entity.QuestionLookBackEntity;
import com.oceansoft.szga.smp.entity.QuestionPlanEntity;
import com.oceansoft.szga.smp.entity.QuestionResponseEntity;
import com.oceansoft.szga.smp.entity.bean.QuestionExecuteTaskBean;
import com.oceansoft.szga.smp.entity.bean.QuestionQueryBean;
import com.oceansoft.szga.smp.szsh.core.vo.system.SysUserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface QuestionHandlerService {

    boolean addQuestionPlan(QuestionPlanEntity questionPlanEntity);

    boolean updateQuestionPlan(QuestionPlanEntity questionPlanEntity);

    QuestionPlanEntity queryQuestionPlan(String questionGuid);

    boolean addQuestionResponse(QuestionResponseEntity questionResponseEntity);

    boolean updateQuestionResponse(QuestionResponseEntity questionResponseEntity);

    QuestionResponseEntity queryQuestionResponse(String questionGuid);

    boolean addQuestionImplemention(QuestionImplementionEntity questionImplementionEntity);

    QuestionImplementionEntity queryQuestionImplemention(String questionGuid);

    QuestionLookBackEntity queryQuestionLookBack(String questionGuid);

    boolean updateQuestionImplemention(QuestionImplementionEntity questionImplementionEntity);

    boolean addQuestionLookBack(QuestionLookBackEntity questionLookBackEntity);

    boolean updateQuestionLookBack(QuestionLookBackEntity questionLookBackEntity);

    boolean signForQuestion(String guid, SysUserVO userData);

    boolean questionReturn(String guid, SysUserVO userData);

    boolean questionManage(String guid, String operation, QuestionExecuteTaskBean questionExecuteTaskBean, SysUserVO userData);

    List<Map<String, Object>> queryPageHandler(QuestionQueryBean questionQueryBean, SysUserVO userData);
}
