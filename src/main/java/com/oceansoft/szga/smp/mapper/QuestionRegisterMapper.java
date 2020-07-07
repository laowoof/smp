package com.oceansoft.szga.smp.mapper;

import com.oceansoft.szga.smp.entity.*;
import com.oceansoft.szga.smp.entity.bean.QuestionQueryBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface QuestionRegisterMapper {


    int addRecord(QuestionRecordEntity questionRecordEntity);

    int addTask(QuestionExecuteTaskEntity questionExecuteTaskEntity);

    QuestionRecordEntity getRecordByGuid(String guid);

    int updateRecordStateAndCode(QuestionRecordEntity questionRecordEntity);

    int updateExecuteTask(QuestionExecuteTaskEntity questionExecuteTaskEntity);

    QuestionExecuteTaskEntity getExecuteTaskEntity(String guid);

    int deleteRecord(String guid);

    int updateRecord(QuestionRecordEntity questionRecordEntity);

    List<QuestionExecuteTaskEntity> getHistoryTask(String guid);

    int updateRecordStateByGuid(@Param("guid") String guid, @Param("state") int state);

    List<Map<String, Object>> queryPageRecord(@Param("questionQueryBean") QuestionQueryBean questionQueryBean, @Param("departmentId") String departmentId);
}
