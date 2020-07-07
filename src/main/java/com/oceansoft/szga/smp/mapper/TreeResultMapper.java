package com.oceansoft.szga.smp.mapper;

import com.oceansoft.szga.smp.entity.TreeDeptResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TreeResultMapper {

    TreeDeptResult getRoot();

    List<TreeDeptResult> getChildResult(String parentId);

    List<TreeDeptResult> all();
}
