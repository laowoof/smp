package com.oceansoft.szga.smp.service;

import com.oceansoft.szga.smp.entity.QuestionExecuteTaskEntity;
import com.oceansoft.szga.smp.entity.QuestionRecordEntity;
import com.oceansoft.szga.smp.entity.bean.QuestionExecuteTaskBean;
import com.oceansoft.szga.smp.entity.bean.QuestionQueryBean;
import com.oceansoft.szga.smp.szsh.core.vo.system.SysUserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface QuestionRegisterService {

    boolean addQuestionRecord(QuestionRecordEntity questionRecordEntity, QuestionExecuteTaskBean questionExecuteTaskBean, Integer type, SysUserVO userData);

    boolean confirmDistribute(String guid, QuestionExecuteTaskBean questionExecuteTaskBean);

    boolean removeRecord(String guid);

    QuestionRecordEntity queryQuestionRecordById(String guid);

    List<QuestionExecuteTaskEntity> queryHistoryTask(String guid);

    boolean questionConfirm(String guid, String operation, QuestionExecuteTaskBean questionExecuteTaskBean, SysUserVO userData);

    List<Map<String, Object>> queryPageRecord(QuestionQueryBean questionQueryBean, SysUserVO userData);
}
