package com.oceansoft.szga.smp.service;

import com.oceansoft.szga.smp.entity.TreeDeptResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ListTreeResultService {

    TreeDeptResult getDeptTreeResult();

    List<TreeDeptResult> getLowerDeptTreeResult(String id);
}
