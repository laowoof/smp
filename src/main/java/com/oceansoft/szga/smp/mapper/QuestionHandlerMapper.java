package com.oceansoft.szga.smp.mapper;

import com.oceansoft.szga.smp.entity.QuestionImplementionEntity;
import com.oceansoft.szga.smp.entity.QuestionLookBackEntity;
import com.oceansoft.szga.smp.entity.QuestionPlanEntity;
import com.oceansoft.szga.smp.entity.QuestionResponseEntity;
import com.oceansoft.szga.smp.entity.bean.QuestionQueryBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface QuestionHandlerMapper {

    int addQuestionPlan(QuestionPlanEntity questionPlanEntity);

    int deleteQuestionPlan(String guid);

    int deleteQuestionResponse(String guid);

    int deleteQuestionImplemention(String guid);

    int deleteQuestionLookBack(String guid);

    int updateQuestionPlan(QuestionPlanEntity questionPlanEntity);

    QuestionPlanEntity queryQuestionPlan(String questionGuid);

    int addQuestionResponse(QuestionResponseEntity questionResponseEntity);

    int updateQuestionResponse(QuestionResponseEntity questionResponseEntity);

    QuestionResponseEntity queryQuestionResponse(String questionGuid);

    int addQuestionImplemention(QuestionImplementionEntity questionImplementionEntity);

    QuestionImplementionEntity queryQuestionImplemention(String questionGuid);

    QuestionLookBackEntity queryQuestionLookBack(String questionGuid);

    int updateQuestionImplemention(QuestionImplementionEntity questionImplementionEntity);

    int addQuestionLookBack(QuestionLookBackEntity questionLookBackEntity);

    int updateQuestionLookBack(QuestionLookBackEntity questionLookBackEntity);

    String queryCreateDeptCode(String createUserId);

    List<Map<String, Object>> queryPageHandler(@Param("questionQueryBean") QuestionQueryBean questionQueryBean, @Param("departmentId") String departmentId, @Param("integerList") List<Integer> integerList);

    void updateFeedBackState(@Param("tableName") String tableName, @Param("guid") String guid);
}
